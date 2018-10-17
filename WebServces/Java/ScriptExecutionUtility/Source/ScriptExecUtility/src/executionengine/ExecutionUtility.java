package executionengine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExecutionUtility {

	public static final String ROOT_DIR = "D:\\FarmClient";
	public static final String LOCAL_TEST_DIR = "D:\\FarmClient\\TestDir";
	public static final String JAR_DIR = "D:\\FarmClient\\TestDir\\Scripts";
	public static final String CONFIG_FILE_PATH = "D:\\FarmClient\\TestDir\\TestConfig\\config.properties";
	public static final String HOST_FILE_PATH = "C:\\Windows\\System32\\drivers\\etc\\hosts";
	public static final String LOG_FILE_PATH = "D:\\FarmClient\\TestDir\\run_log.csv";
	public static final String RESULT_FILE_PATH = "D:\\FarmClient\\TestDir\\execution_result.xlsx";

	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String CONNECTION_STR = "jdbc:mysql://QAMYSQL:3306/FARM?user=PythonScriptRead&password=PythonScriptRead&noAccessToProcedureBodies=true";

	public static int totalScriptPassed = 0;
	public static int totalScriptFailed = 0;

	public static void main(String[] args) {

		String executionEnv = "";
		// Read the command line arguments
		if (args.length > 0) {
			executionEnv = args[0];
		} else {
			executionEnv = "QA-F3";
		}

		// Delete the execution result and log file before starting the process
		new File(RESULT_FILE_PATH).delete();
		new File(LOG_FILE_PATH).delete();

		// Create result file and add header
		createResultFile();

		/*
		 * try {
		 * 
		 * //Add header to the execution result file FileWriter resultFile = new
		 * FileWriter(RESULT_FILE_PATH, true); resultFile.write(
		 * "SCRIPT NAME \t\t STEP PASSED \t STEP FAILED " +
		 * "\t RESULT \t COMMENT"); resultFile.close();
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */

		// Get all jar files and then execute them
		List<String> jarFileList = getJarDetails();
		if (jarFileList.size() > 0) {
			executeJar(jarFileList, executionEnv);
		}

		writeSummaryToFile(totalScriptPassed, totalScriptFailed);
	}

	public static void createResultFile() {

		FileInputStream file;
		XSSFWorkbook workbook;
		XSSFWorkbook wb;
		FileOutputStream fileOut;

		try {
			workbook = new XSSFWorkbook();
			String sheetName = "Result";
			wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet(sheetName);

			// Write header to result file
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell1 = row.createCell(0);
			cell1.setCellValue("SCRIPT NAME");
			XSSFCell cell2 = row.createCell(1);
			cell2.setCellValue("NO OF STEPS PASSED");
			XSSFCell cell3 = row.createCell(2);
			cell3.setCellValue("NO OF STEPS FAILEd");
			XSSFCell cell4 = row.createCell(3);
			cell4.setCellValue("FINAL RESULT");
			XSSFCell cell5 = row.createCell(4);
			cell5.setCellValue("COMMENT");

			fileOut = new FileOutputStream(RESULT_FILE_PATH);
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Get the list of script names based on the list of Jar files in Scripts
	 * folder
	 * 
	 * @Author : Gopu Raju
	 * @since : 11/14/2017
	 * @param :
	 *            None
	 * @Return : List<String>jarFileList (Data Type: List<String> )
	 **/
	public static List<String> getJarDetails() {

		// Get all jarfile name from jar directory
		File folder = new File(JAR_DIR);
		File[] listOfFiles = folder.listFiles();
		List<String> jarFileList = new ArrayList();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				jarFileList.add(listOfFiles[i].getName());
			}
		}
		return jarFileList;
	}

	/**
	 * Runs the list of scripts which are available in Scripts folder
	 * 
	 * @Author : Gopu Raju
	 * @since : 11/14/2017
	 * @param :
	 *            List<String> jarFileNameList, String executionEnv
	 * @Return : None
	 **/
	public static void executeJar(List<String> jarFileNameList, String executionEnv) {

		String command = "cmd.exe,/C,Start,/wait,ScriptExecUtility ,D:\\FarmClient\\TestDir\\Scripts\\";

		for (int i = 0; i < jarFileNameList.size(); i++) {
			// Get script details and then update host file
			String scriptName = (String) jarFileNameList.get(i);
			Script scriptDetails = getScriptDetailsFromDB(scriptName, executionEnv);
			updateHostFile(executionEnv);

			if (scriptDetails != null) {

				// Write the script details to config file
				writeConfigFile(scriptDetails, executionEnv);

				// Execute the jar
				String exeCommand = command + scriptName;
				String[] executionCommand = exeCommand.split(",");

				try {
					Process process = Runtime.getRuntime().exec(executionCommand);
					process.waitFor();
					writeExecutionResult(scriptName, 1);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				writeExecutionResult(scriptName, 0);
			}
		}
	}

	/**
	 * Method to get the Script ID, Product Name, Firm ID, Product ID, Firm
	 * Name, Env ID and URL from FARMDB for the specified script and environment
	 * 
	 * @Author : Gopu Raju
	 * @since : 11/14/2017
	 * @param :
	 *            String scriptName, String executionEnv
	 * @Return : Script scriptDetails
	 **/
	public static Script getScriptDetailsFromDB(String scriptName, String executionEnv) {

		ResultSet result = null;
		Script scriptDetails = null;

		String query = "SELECT Scripts.ID ScriptID, Products.ProductName ProductName, Apps.DATA_FirmID FirmID,"
				+ " Apps.DATA_ProductID ProductID, Firms.FirmName FirmName, Env.ID EnvID, Url.URL"
				+ " FROM FARM.DATA_Scripts Scripts LEFT OUTER JOIN FARM.DATA_Apps2Scripts A2S ON"
				+ " Scripts.ID = A2S.DATA_ScriptID LEFT OUTER JOIN FARM.DATA_Apps Apps ON"
				+ " A2S.DATA_AppID = Apps.ID LEFT OUTER JOIN FARM.DATA_Firms Firms ON Apps.DATA_FirmID = Firms.ID"
				+ " LEFT OUTER JOIN FARM.DATA_Products Products ON Apps.DATA_ProductID = Products.ID"
				+ " LEFT OUTER JOIN FARM.DATA_Envs2Apps E2A ON Apps.ID = E2A.DATA_AppID"
				+ " LEFT OUTER JOIN FARM.DATA_Environments Env ON E2A.DATA_EnvID = Env.ID"
				+ " LEFT OUTER JOIN FARM.DATA_URLs Url ON E2A.DATA_UrlID = Url.ID Where ScriptName='" + scriptName
				+ "' and Env.Environment='" + executionEnv + "'";

		try {

			// Query to get the script details from database
			Class.forName(MYSQL_DRIVER);
			Connection mySQLConnection = DriverManager.getConnection(CONNECTION_STR);
			Statement statement = mySQLConnection.createStatement();
			result = statement.executeQuery(query);

			while (result.next()) {

				scriptDetails = new Script();
				scriptDetails.setScriptID(result.getString(1));
				scriptDetails.setAppName(result.getString(2));
				scriptDetails.setFirmID(result.getInt(3));
				scriptDetails.setProductID(result.getInt(4));
				scriptDetails.setFirmName(result.getString(5));
				scriptDetails.setEnvID(result.getInt(6));
				scriptDetails.setUrl(result.getString(7));
				System.out.println("Successfully Fetched Test Data for Script: " + scriptName);
			}

			// Close the database connection
			mySQLConnection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return scriptDetails;
	}

	/**
	 * Write the config file for the script
	 * 
	 * @Author : Gopu Raju
	 * @since : 11/14/2017
	 * @param :
	 *            String scriptDetails, String executionEnv
	 * @Return : None
	 **/
	public static void writeConfigFile(Script scriptDetails, String executionEnv) {

		Properties prop = new Properties();
		try {

			// Write the properties to the config file
			prop.setProperty("Application", scriptDetails.getAppName());
			prop.setProperty("Frim", scriptDetails.getFirmName());
			prop.setProperty("URL", scriptDetails.getUrl());
			prop.setProperty("Environment", executionEnv);
			prop.setProperty("SubEnvironment", executionEnv);
			prop.setProperty("VIP", "Y");
			prop.setProperty("ExecutionLocation", "Local");
			prop.setProperty("BrowserType", "Chrome");
			prop.setProperty("BrowserVersion", "11");
			prop.setProperty("OS", "Windows");
			prop.setProperty("Device", "Desktop");
			prop.setProperty("FIRMID", scriptDetails.getFirmID() + "");
			prop.setProperty("PRODUCTID", scriptDetails.getProductID() + "");
			prop.setProperty("ENVIRONMENTID", scriptDetails.getEnvID() + "");
			prop.setProperty("SCRIPTID", scriptDetails.getScriptID() + "");
			prop.setProperty("DYNATRACE", "NO");
			prop.setProperty("JOBID", "001");
			prop.setProperty("LABID", "001");
			prop.setProperty("LABGROUPID", "001");

			prop.store(new FileOutputStream(CONFIG_FILE_PATH), null);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Update the host file with ip address and url
	 * 
	 * @Author : Gopu Raju
	 * @since : 11/14/2017
	 * @param :
	 *            String executionEnv
	 * @Return : None
	 **/
	public static void updateHostFile(String executionEnv) {

		try {
			// Get the host details from database
			Class.forName(MYSQL_DRIVER);
			Connection mySQLConnection = DriverManager.getConnection(CONNECTION_STR);

			String query = "select e.environment, h.ip, h.entry from FARM.DATA_Hosts h inner  "
					+ "join FARM.DATA_Environments e on h.envid = e.id where e.environment = '" + executionEnv
					+ "' or e.environment = 'All'";

			Statement statement = mySQLConnection.createStatement();
			ResultSet result = statement.executeQuery(query);

			// Write information to host file
			FileWriter fw = null;
			if (result != null) {
				fw = new FileWriter(HOST_FILE_PATH, false);
			}
			while (result.next()) {
				fw.write(result.getString(2) + " " + result.getString(3) + "\r\n");
			}

			if (fw != null) {
				fw.close();
			}

			Runtime.getRuntime().exec("ipconfig /flushdns");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read the run log file and write the execution result to the results file
	 * 
	 * @Author : Gopu Raju
	 * @since : 11/14/2017
	 * @param :
	 *            String scriptName, int execResult
	 * @Return : None
	 **/
	public static void writeExecutionResult(String scriptName, int execResult) {

		int maxCounter = 0;
		String numStepsPassed = "N/A";
		String numStepsFailed = "N/A";
		String numStepsWarning = "N/A";
		String comment = "N/A";
		String finalResult = "N/A";
		List<String> fileLines = null;

		if (execResult == 0) {

			finalResult = "Failed";
			comment = "Please add script information to FARM.";

		} else if ((!new File(LOG_FILE_PATH).exists()) && (execResult == 1)) {

			System.out.println(" --Unable to load run_log.csv. Exiting this execution...");
			comment = "Run had no result file, execution failure detected";

		} else {
			File logFile = new File(LOG_FILE_PATH);
			try {
				fileLines = java.nio.file.Files.readAllLines(logFile.toPath(), Charset.defaultCharset());
				maxCounter = fileLines.size();

			} catch (IOException e) {
				e.printStackTrace();
			}

			if (maxCounter == 0) {
				comment = "Log file was empty. Execution failure detected";
				System.out.println(" --Program execution failure detected, empty result file.");

			} else {
				int counter = 0;
				boolean summaryReached = false;

				// Iterate the contents of log file till sumary section reached
				while (counter < maxCounter) {
					String fileLine = fileLines.get(counter).replace("\r\n", "");
					if (fileLine.contains(",Summary")) {
						summaryReached = true;
						System.out.println("Summary reached");
					}

					// Get the number of steps passed count
					if ((fileLine.contains(",,Pass,")) && (summaryReached)) {

						String passLine = fileLines.get(counter).replace("\r\n", "");
						passLine = passLine.replace("\"\",,Pass,", "");
						numStepsPassed = passLine.replace(",,", "");
						System.out.println("Number of Steps Passed: " + numStepsPassed);

					}

					// Get the number of steps failed count
					if ((fileLine.contains(",,Fail,")) && (summaryReached)) {

						String failLine = fileLines.get(counter).replace("\r\n", "");
						failLine = failLine.replace("\"\",,Fail,", "");
						numStepsFailed = failLine.replace(",,", "");
						System.out.println("Number of Steps Failed: " + numStepsFailed);

					}
					// Get the number of steps warning count
					if ((fileLine.contains(",,Warnings,")) && (summaryReached)) {

						String warnLine = fileLines.get(counter).replace("\r\n", "");
						warnLine = warnLine.replace("\"\",,Warnings,", "");
						numStepsWarning = warnLine.replace(",,", "");
						System.out.println("Warning: " + numStepsWarning);

					}
					counter++;
				}

				// Based on number of step passed/failed determine final result
				if (!summaryReached) {

					finalResult = "Failed";
					comment = "No summary section found in log file";
					System.out.println("No summary section found in log file");

				}

				if ((numStepsPassed.equals("0")) && (numStepsFailed.equals("0"))) {

					finalResult = "Failed";
					comment = "Script doesnt contain any valid verification step.";

				} else if ((!numStepsFailed.equals("0")) && (!numStepsFailed.equals("N/A"))) {

					finalResult = "Failed";
					comment = "Script failed.";

				} else if ((!numStepsPassed.equals("0")) && (!numStepsPassed.equals("N/A"))
						&& (numStepsFailed.equals("0"))) {

					finalResult = "Passed";
					comment = "Script passed succesfully.";

				}
			}
			// Delete the log file after reading the execution log
			logFile.delete();
		}

		// Get count of no of passed and failed script
		if (finalResult.equals("Passed"))
			totalScriptPassed++;
		else if (finalResult.equals("Failed"))
			totalScriptFailed++;

		writeResultToFile(scriptName, numStepsPassed, numStepsFailed, finalResult, comment);
		System.out.println(totalScriptPassed + " ====== " + totalScriptFailed);

		// write this workbook to an Outputstream.

		/*
		 * try { //Write the final result to the result file FileWriter
		 * resultFile = new FileWriter(RESULT_FILE_PATH, true);
		 * resultFile.write("\r\n" + scriptName + " " + numStepsPassed + " " +
		 * numStepsFailed + " " + finalResult + " " + comment);
		 * resultFile.close(); } catch (IOException e) { e.printStackTrace(); }
		 */
	}

	public static void writeResultToFile(String scriptName, String numStepsPassed, String numStepsFailed,
			String finalResult, String comment) {

		// Write the jar execution result to excel file
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		try {
			FileInputStream file = new FileInputStream(new File(RESULT_FILE_PATH));

			// Create Workbook instance holding reference to .xlsx file
			workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());

			// Get the count in sheet
			int rowCount = sheet.getLastRowNum() + 1;
			Row row = sheet.createRow(rowCount);

			Cell c1 = row.createCell(0);
			c1.setCellValue(scriptName);
			Cell c2 = row.createCell(1);
			c2.setCellValue(numStepsPassed);
			Cell c3 = row.createCell(2);
			c3.setCellValue(numStepsFailed);
			Cell c4 = row.createCell(3);
			c4.setCellValue(finalResult);
			Cell c5 = row.createCell(4);
			c5.setCellValue(comment);

			// Write the workbook to excel file
			FileOutputStream fileStream = new FileOutputStream(new File(RESULT_FILE_PATH));
			workbook.write(fileStream);
			fileStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeSummaryToFile(int totalScriptPassed, int totalScriptFailed) {

		// Write the jar execution result to excel file
		XSSFWorkbook workbook = null;
		XSSFSheet sheet;
		FileOutputStream fileStream;
	    
		try {
			FileInputStream file = new FileInputStream(new File(RESULT_FILE_PATH));

			// Create Workbook instance holding reference to .xlsx file
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());

			CellStyle style1 = workbook.createCellStyle();
		    style1.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		    style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    CellStyle style2 = workbook.createCellStyle();
		    style2.setFillForegroundColor(IndexedColors.RED.getIndex());
		    style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    
			// Write the summary header
			int rowCount = sheet.getLastRowNum() + 2;
			Row row = sheet.createRow(rowCount);
			Cell c1 = row.createCell(0);
			c1.setCellValue("SUMMARY OF EXECUTION");
			Cell c2 = row.createCell(1);
			c2.setCellValue("TOTAL SCRIPTS PASSED:" );
			c2.setCellStyle(style1);
			Cell c3 = row.createCell(2);
			c3.setCellValue(totalScriptPassed);
			c3.setCellStyle(style1);
			Cell c4 = row.createCell(3);
			c4.setCellValue("TOTAL SCRIPTS FAILED: ");
			c4.setCellStyle(style2);
			Cell c5 = row.createCell(4);
			c5.setCellValue(totalScriptFailed);
			c5.setCellStyle(style2);

			// Write the workbook to excel file
			fileStream = new FileOutputStream(new File(RESULT_FILE_PATH));
			workbook.write(fileStream);
			fileStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Update Successfully");
	}

	/**
	 * Kill all the browsers
	 * 
	 * @Author : Gopu Raju
	 * @since : 11/14/2017
	 * @param :
	 *            None
	 * @Return : None
	 **/
	public static void killBrowsers() {
		try {
			Runtime.getRuntime().exec("taskkill /im firefox.exe /f");
			Thread.sleep(10L);
			Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
			Thread.sleep(10L);
			Runtime.getRuntime().exec("taskkill /im iexplore.exe /f");
			Thread.sleep(10L);
			Runtime.getRuntime().exec("taskkill /im WerFault.exe /f");
			Thread.sleep(10L);
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Kill all the Webdrivers
	 * 
	 * @Author : Gopu Raju
	 * @since : 11/14/2017
	 * @param :
	 *            None
	 * @Return : None
	 **/
	public static void killWebDrivers() {
		try {
			Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
			Thread.sleep(5L);
			Runtime.getRuntime().exec("taskkill /im IEDriverServer.exe /f");
			Thread.sleep(5L);
			Runtime.getRuntime().exec("taskkill /im geckodriver.exe /f");
			Thread.sleep(5L);
			Runtime.getRuntime().exec("taskkill /im java.exe /f");
			Thread.sleep(5L);
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Based on the input get the time in various formats
	 * 
	 * @Author : Gopu Raju
	 * @since : 11/14/2017
	 * @param :
	 *            String timeType
	 * @Return : None
	 **/
	public static String getTime(String timeType) {
		String timeStampStr = null;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		SimpleDateFormat dateMySql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat dateLog = new SimpleDateFormat("MM-dd-yy HH:mm:ss");
		SimpleDateFormat dateFile1 = new SimpleDateFormat("MMddyy");
		SimpleDateFormat dateFile2 = new SimpleDateFormat("HHmmss");

		if (timeType.equals("MYSQL")) {
			timeStampStr = dateMySql.format(timestamp).toString();
		} else if (timeType.equals("LOG")) {
			timeStampStr = dateLog.format(timestamp).toString();
		} else if (timeType.equals("FILE")) {
			timeStampStr = "-d" + dateFile1.format(timestamp).toString() + "-t"
					+ dateFile2.format(timestamp).toString();
		}

		return timeStampStr;
	}
}

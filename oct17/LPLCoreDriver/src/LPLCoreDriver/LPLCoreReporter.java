package LPLCoreDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.lplhtmlreport.lib.htmlReport;

/**
 * <p>
 * <br>
 * <b> Title: </b> LPLCoreReporter.java</br> <br>
 * <b> Description: </B> LPL Core Library - Reporter methods</br> <br>
 * <b>Usage:</br></b> 
 * <br>1. WriteReportHeader: Writes the Report header in the csv file</br>
 * <br>2. WriteReport: Writes the Report step in the csv file</br>
 * <br>3. captureScreenShot: Method to Capture Screen Print</br>
 * <br>4. writeSummary: Writes the Summary of Executions in the csv file</br>
 * <br>5. writeConsolidatedSummary: Writes the details of the current execution in the csv file</br>
 * <br>6. writeStepToReporter:This method is used to write the step reporter in scripts by capturing the screenshot path only for Passed step. </br>
 * <br>7. writeStepToReporter:This method is used to write the step reporter in scripts by capturing the screenshot path for both Passed & Failed step. </br> 
 * @author Aiswarya Srinivasan
 * @since 02-24-2017
 *        </p>
 */
	public class LPLCoreReporter extends LPLCoreDriver{// extends LPLCoreDriver{
		//Delimiter used in CSV file
		 //   private static final String COMMA_DELIMITER = ",";
		  //  private static final String NEW_LINE_SEPARATOR = "\n";
		// Report index 
		 //   private static final int REPORT_TIMESTAMP_IDX = 0; //1/6
		//    private static final int REPORT_TESTSTEP_IDX = 1;  //2/6
		 //   private static final int REPORT_EXPECTED_RESULT_IDX = 2; //3/6
		  //  private static final int REPORT_ACTUAL_RESULT_IDX = 3; //4/6
		  //  private static final int REPORT_STATUS_IDX=4;  //5/6
		  //  private static final int REPORT_SCREENSHORT_IDX=5; //6/6
		
		// Legend 
	    protected static int SummaryPass;
	    protected static int SummaryFail;
	    protected static int SummaryInfo;
	    protected static int SummaryWarn;
	    protected static int stepCount = 0;
	    static htmlReport report =  new htmlReport();
		//CSV file header    
		private static final String FILE_HEADER = "TimeStamp,Test Step,Expected Result,Actual Result, Status, Screenshot Path";
		
		public LPLCoreReporter(String[] arrScriptSteps){
			WriteReport("TOTAL NUMBER OF STEP IN SCRIPT: " +arrScriptSteps.length, "", "", "","");
			//The test steps for the scripts below
			for(int intStep = 0; intStep<arrScriptSteps.length; intStep++){
				WriteReport(arrScriptSteps[intStep], "", "", "","");
			}
			
		}
		/**
		 * Writes the Report header in the csv file
		 * @author Aiswarya Srinivasan
		 * @since 02-24-2017
		 * @param None
		 * @return None
		 */
		public static void WriteReportHeader()
		{
			String fileName; 
			LPLCoreConstents lplCoreConstents = LPLCoreConstents.getInstance();
			fileName = lplCoreConstents.REPORT_LOG_FILE_PATH + lplCoreConstents.REPORT_LOG_FILE_NAME; //"C:\\FarmClient\\TestDir\\run_log.csv";
			
	        //FileWriter fileWriter = null;
			boolean alreadyExists = new File(fileName).exists();
	    
	        try {
	        	CsvWriter csvOutput = new CsvWriter(new FileWriter(fileName, true), ',');
	        	if (!alreadyExists)
				{
	        		csvOutput.write("TimeStamp");
	        		csvOutput.write("TestStep");
	        		csvOutput.write("ExpectedResult");
	        		csvOutput.write("ActualResult");
	        		csvOutput.write("Status");
	        		csvOutput.write("ScreenshotPath");
	        		csvOutput.endRecord();
				}
	        	
	        	/*csvOutput.write("TimeStamp");
        		csvOutput.write("TestStep");
        		csvOutput.write("ExpectedResult");
        		csvOutput.write("ActualResult");
        		csvOutput.write("Status");
        		csvOutput.write("ScreenshotPath");
        		csvOutput.endRecord();*/
	        	
	        	csvOutput.close();
	        	
	         /*   fileWriter = new FileWriter(fileName);
	            //Write the CSV file header
	            fileWriter.append(FILE_HEADER.toString());
	            fileWriter.append(NEW_LINE_SEPARATOR);  */
	            System.out.println("CSV file was created and successfully !!!");
	        } catch (Exception e) {
	            System.out.println("Error in CsvFileWriter !!!");
	            e.printStackTrace();
	        } /*finally {
	            try {
	                fileWriter.flush();
	                fileWriter.close();
	            } catch (IOException e) {
	                System.out.println("Error while flushing/closing fileWriter !!!");
	                e.printStackTrace();
	            }
	        }*/
	    }
		
		/**
		 * Writes the Report step in the csv file
		 * @author Aiswarya Srinivasan
		 * @since 02-24-2017
		 * @param String TestStep - Test Step to be performed
		 * 		  String ExpectedResult - Expected Result
		 * 		  String ActualResult - Actual Result
		 * 		  String Status - Status (Passed/Failed/Done)
		 * 		  String ScreenshotPath - Screen shot path to place the screen print
		 * @return None
		 */
		public static void WriteReport(String TestStep,String ExpectedResult,String ActualResult,String Status,String ScreenshotPath)
		{
			LPLCoreConstents lplCoreConstents = LPLCoreConstents.getInstance();
			String fileName; 
			fileName = lplCoreConstents.REPORT_LOG_FILE_PATH + lplCoreConstents.REPORT_LOG_FILE_NAME; //"C:\\FarmClient\\TestDir\\run_log.csv";
			boolean alreadyExists = new File(fileName).exists();
			// FileWriter fileWriter = null;
	        try {
	        	//htmlReport report =  new htmlReport();
				
	        	CsvWriter csvOutput = new CsvWriter(new FileWriter(fileName,true),',');
	        	if (!alreadyExists)
	        	{
	        		csvOutput.write("TimeStamp");
	        		csvOutput.write("TestStep");
	        		csvOutput.write("ExpectedResult");
	        		csvOutput.write("ActualResult");
	        		csvOutput.write("Status");
	        		csvOutput.write("ScreenshotPath");
	        		csvOutput.endRecord();
	        	}
	        	 Date timeStamp = new Date();
		         SimpleDateFormat ftDateFormat = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a zzz");
		         
		         csvOutput.write(ftDateFormat.format(timeStamp));
	        	 csvOutput.write(TestStep);
	        	 csvOutput.write(ExpectedResult);
	        	 csvOutput.write(ActualResult);
	        	 csvOutput.write(Status);
	        	 csvOutput.write("<img src=\""+ScreenshotPath+"\">");
	        	 report.ReportHTML(TestStep,ExpectedResult,ActualResult,Status,ScreenshotPath);
	        	 csvOutput.endRecord();
	        	 csvOutput.close();
	        	 
	        	 if(Status.equalsIgnoreCase(LPLCoreConstents.FAILED)){
	        		 //report.ReportHTML(TestStep,ExpectedResult,ActualResult,Status,ScreenshotPath);
	        		 writeSummary();
		        	 System.exit(0); 
	        	 }
	        	/*
	        	fileWriter = new FileWriter(fileName,true);
	            
	            //Add a new line separator after the header
	            Date timeStamp = new Date();
	            SimpleDateFormat ftDateFormat = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a zzz");
	            fileWriter.append(NEW_LINE_SEPARATOR);
	            fileWriter.append(ftDateFormat.format(timeStamp));
	            fileWriter.append(COMMA_DELIMITER);
	            fileWriter.append(TestStep);
	            fileWriter.append(COMMA_DELIMITER);
	            fileWriter.append(ExpectedResult);
	            fileWriter.append(COMMA_DELIMITER);
	            fileWriter.append(ActualResult);
	            fileWriter.append(COMMA_DELIMITER);
	            fileWriter.append(Status);
	            fileWriter.append(COMMA_DELIMITER);
	            fileWriter.append(ScreenshotPath);
	            fileWriter.append(COMMA_DELIMITER);
	            fileWriter.append(NEW_LINE_SEPARATOR);
	            System.out.println("CSV file was created successfully !!!");
	            */ 
	        } catch (Exception e) {
	            System.out.println("Error in CsvFileWriter !!!");
	            e.printStackTrace();
	        } /* finally {
	          //  try {
	              //  fileWriter.flush();
	               // fileWriter.close();
	        //    } catch (IOException e) {
	        //        System.out.println("Error while flushing/closing fileWriter !!!");
	      //          e.printStackTrace();
	          //  }
	       // } */
	    }
			
		/**
		 * Method to Capture Screen Print and put it in the Global screenshot path
		 * @author Aiswarya Srinivasan
		 * @since 02-24-2017
		 * @param Webdriver - driver control, String screenShortName - Name to be given for the Screenshot
		 * @return String Screenshot path
		 */
		public static String captureScreenShot(WebDriver driver, String screenShortName) {
		try {
			LPLCoreConstents lplCoreConstents = LPLCoreConstents.getInstance();					
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = lplCoreConstents.SCREEN_SHOT_PATH + screenShortName + ".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshort taken");
			
			//Copying the Screenshot to the global automation snapshots folder
			String strGlobalScreenshotParentFolder = lplCoreConstents.GLOBAL_SCREEN_SHOT_PATH;
			
			//Created Sub folders with respect to Today's date
			Calendar objCalendar = Calendar.getInstance();
			
			//Folder path to be verified
			String strGlobalScreenshotFolder = strGlobalScreenshotParentFolder +"/"+ 
			//Year, month and date folder
			objCalendar.get(Calendar.YEAR) +"/"+ objCalendar.get(Calendar.MONTH) +"/"+ objCalendar.get(Calendar.DATE) +"/" + 
			//Job ID, Lab ID and Lab Group ID, Script ID folder
			LPLCoreDriver.ocfg.getJobID() + "/" + LPLCoreDriver.ocfg.getLabID() + "/" + LPLCoreDriver.ocfg.getLabGroupID()+ "/" + LPLCoreDriver.ocfg.getScriptId() + "/";
			File GlobalScreenshotFolder = new File(strGlobalScreenshotFolder);
			
			//Creating Year , Month, Date folders if not present
			GlobalScreenshotFolder.mkdirs();
			
			//Screenshot Destination
			String strNewSS = screenShortName.replace(" ","_").trim();
			System.out.println(strNewSS);
			String strGlobalScreenshotDest = strGlobalScreenshotFolder + strNewSS + ".png";
			
			File GlobalScreenshotDestination = new File(strGlobalScreenshotDest);
			
			//Copy the Screenshot to Global folder
			FileUtils.copyFile(destination, GlobalScreenshotDestination);
			
			return "http:" + strGlobalScreenshotDest;
		    }
		  catch (Exception e)	{
			  System.out.println(e.getMessage());
			  return e.getMessage();
		    }
		}
			
		/**
		 * Writes the Summary of Executions in the csv file
		 * @author Aiswarya Srinivasan
		 * @since 02-24-2017
		 * @param None
		 * @return None
		 */
		public static void writeSummary(){
			LPLCoreConstents lplCoreConstents = new LPLCoreConstents();
			String fileName; 
			fileName = lplCoreConstents.REPORT_LOG_FILE_PATH + lplCoreConstents.REPORT_LOG_FILE_NAME; //"C:\\FarmClient\\TestDir\\run_log.csv";	
		
			//Created Sub folders with respect to Today's date
			Calendar objCalendar = Calendar.getInstance();

			//Getting the name of the current month 
			String strMonthName = objCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());

			//Folder path to be verified
			String strGlobalScreenshotFolder = LPLCoreConstents.getInstance().QA2000ServerHTMLReportPath+
					//Script ID folder
					"ScriptID_"+LPLCoreDriver.ocfg.getScriptId() + "/"+"EnvID_"+ 
					//Environment ID folder
					LPLCoreDriver.ocfg.getEnvId()+"/"+
					//Year, month and date folder
					objCalendar.get(Calendar.YEAR) +"/"+ strMonthName +"/"+"Date_"+ objCalendar.get(Calendar.DATE)+"/";
			try {
				report.HTMLReport();
				
				//Creating Year , Month, Date folders if not present
				File GlobalScreenshotFolder = new File(strGlobalScreenshotFolder);
				GlobalScreenshotFolder.mkdirs();

				//report.FileMoving(LPLCoreConstents.getInstance().htmlReportPath ,LPLCoreConstents.getInstance().QA2000ServerHTMLReportPath);

				report.FileMoving(LPLCoreConstents.getInstance().htmlReportPath, strGlobalScreenshotFolder);
				//report.FileMoving(strGlobalScreenshotFolder,LPLCoreConstents.getInstance().QA2000ServerHTMLReportPath);
				
				//Reading the run_log.csv file 
				CsvReader result_log = new CsvReader(fileName);
				result_log.readHeaders();
				while(result_log.readRecord()) 
					{
					String reslogStatus = result_log.get("Status");
					if (reslogStatus.toLowerCase().contains("passed")) 
						{SummaryPass = SummaryPass + 1;}
					if (reslogStatus.toLowerCase().contains("failed")) 
						{SummaryFail = SummaryFail + 1;}
					if ((reslogStatus.toLowerCase().contains("info")) || (reslogStatus.toLowerCase().contains("done")))
						{SummaryInfo = SummaryInfo + 1;}
					if (reslogStatus.toLowerCase().contains("warning"))
						{SummaryWarn = SummaryWarn + 1;}
					}  
					result_log.close();
			      }    catch (FileNotFoundException e) {
			            e.printStackTrace();
			      } catch (IOException e)	{  System.out.println(e.getMessage());}
			
			
				LPLCoreReporter.WriteReport("<h2 style=\"color:dodgerblue\">******Test Execution Section Ends******</h2>", "","", "", "");
				LPLCoreReporter.WriteReport("<h2><a href="+strGlobalScreenshotFolder+report.strScriptName+"_"+report.strglobaldatetime+".html>HTML Report</a></h2>", "","", "", "");
				// write summary 
				// before we open the file check to see if it already exists
				boolean alreadyExists = new File(fileName).exists();	
				try	{	
					CsvWriter csvOutput = new CsvWriter(new FileWriter(fileName, true), ',');
					//csvOutput.write("<a href="+LPLCoreConstents.getInstance().QA2000ServerHTMLReportPath+report.strScriptName+".html>HTML Report</a>");
					if (!alreadyExists)
					{
						csvOutput.write(FILE_HEADER.toString());
						csvOutput.endRecord();
					}
					csvOutput.write("");
					csvOutput.write("Summary");
					csvOutput.write("");
					csvOutput.write("");
					csvOutput.write("");
					csvOutput.write("");
					csvOutput.endRecord();
					csvOutput.write("");
					csvOutput.write("");
					csvOutput.write("Pass");
					csvOutput.write(""+SummaryPass);
					csvOutput.write("");
					csvOutput.write("");
					csvOutput.endRecord();
					csvOutput.write("");
					csvOutput.write("");
					csvOutput.write("Fail");
					csvOutput.write(""+SummaryFail);
					csvOutput.write("");
					csvOutput.write("");
					csvOutput.endRecord();
					csvOutput.close();
					//Close Web driver or Dynatrace Session
					LPLCoreDriver.closeSession();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			

		/*	
		public static void main(String[] args) {
			LPLCoreDriver.StartSession();
			LPLCoreReporter.WriteReportHeader();
			LPLCoreReporter.WriteReport("1", "ExpectedResult", "ActualResult", LPLCoreConstents.PASSED, "ScreenshotPath");
			LPLCoreReporter.WriteReport("2", "ExpectedResult", "ActualResult", LPLCoreConstents.PASSED, "ScreenshotPath");
			LPLCoreReporter.WriteReport("3", "ExpectedResult", "ActualResult", LPLCoreConstents.FAILED, captureScreenShot(driver, "Step 1_20170303"));
			LPLCoreReporter.WriteReport("4", "ExpectedResult", "ActualResult", LPLCoreConstents.FAILED, "ScreenshotPath");
			LPLCoreReporter.writeSummary();
			
		}*/
		
		/**
		 * Writes the details of the current execution in the csv file
		 * @author Aiswarya Srinivasan
		 * @since 02-24-2017
		 * @param None
		 * @return None
		 */
		 public static void writeConsolidatedSummary(){
			 
			 LPLCoreReporter.WriteReport("<h2 style=\"color:darkblue\">******Information Section******</h2>", "","", "", "");
			 
			 /** OS Name */
			 LPLCoreReporter.WriteReport("OS Name", "", System.getProperty("os.name").toUpperCase(), "Done", "");
			 /** JRE Version */
			 LPLCoreReporter.WriteReport("JRE Version", "", System.getProperty("java.version"), "Done", "");
			 /** Browser Name & Version */
			 Capabilities caps = ((RemoteWebDriver) LPLCoreDriver.driver).getCapabilities();
			 LPLCoreReporter.WriteReport("Browser Name", "", caps.getBrowserName().toUpperCase(), "Done", "");
			 LPLCoreReporter.WriteReport("Browser Version", "", caps.getVersion().toUpperCase(), "Done", "");
			 /** Application */
			 LPLCoreReporter.WriteReport("Application", "", LPLCoreDriver.ocfg.getApplication().toUpperCase(), "Done", "");
			 /** URL */
			 LPLCoreReporter.WriteReport("URL", "", String.valueOf(LPLCoreDriver.ocfg.getURL()), "Done", "");
			 /** UserName */
			 LPLCoreReporter.WriteReport("UserName", "", String.valueOf(LPLCoreDriver.loginCredentials.get("Username")), "Done", "");
			 /** Password */
			 if(LPLCoreDriver.ocfg.getEnvironment().toUpperCase().contains("QA"))			 
				 LPLCoreReporter.WriteReport("Password", "", String.valueOf(LPLCoreDriver.loginCredentials.get("Password")), "Done", "");
			 /** Environment */
			 LPLCoreReporter.WriteReport("Environment", "", LPLCoreDriver.ocfg.getEnvironment().toUpperCase(), "Done", "");
			 /** FIRM */
			 LPLCoreReporter.WriteReport("FIRM", "", LPLCoreDriver.ocfg.getFirm().toUpperCase(), "Done", "");
			 /** Environment ID */
			 LPLCoreReporter.WriteReport("Environment ID", "", String.valueOf(LPLCoreDriver.ocfg.getEnvId()), "Done", "");
			 /** Script ID */
			 LPLCoreReporter.WriteReport("Script ID", "", String.valueOf(LPLCoreDriver.ocfg.getScriptId()), "Done", "");
			 /** Job ID */
			 LPLCoreReporter.WriteReport("Job ID", "", String.valueOf(LPLCoreDriver.ocfg.getJobID()), "Done", "");
			 /** Lab ID */
			 LPLCoreReporter.WriteReport("Lab ID", "", String.valueOf(LPLCoreDriver.ocfg.getLabID()), "Done", "");
			 /** Lab Group ID */
			 LPLCoreReporter.WriteReport("Lab Group ID", "", String.valueOf(LPLCoreDriver.ocfg.getLabGroupID()), "Done", "");
			 
			 LPLCoreReporter.WriteReport("<h2 style=\"color:dodgerblue\">******Test Execution Section Starts******</h2>", "","", "", "");
			 
		 }
		 
		 /**
			 * This method is used to write the step reporter in scripts by capturing the screenshot path only for Failed step
			 * @author Aiswarya Srinivasan
			 * @since 11-24-2017
			 * @param boolean blnResult - The required method boolean result captured in script
			 * 			boolean blnWhatResultIsPassed -To pass or fail the step
			 * 			String strStepDescription - Step Description
			 * 			String strExpectedResult - Expected Result
			 * 			String strActualResultIfPass - Actual Results if it is passed
			 * 			String strActualResultIfFailed - Actual Results if it is failed 			
			 * @return None
			 */
		 public static void writeStepToReporter(boolean blnResult, boolean blnWhatResultIsPassed,String strStepDescription, String strExpectedResult, String strActualResultIfPass,String strActualResultIfFailed){
				date = new Date();
				stepCount++;
				String strStepName = "Step " + stepCount;
				String strScreenshotName = strStepName+ "_";
				if(blnWhatResultIsPassed==blnResult){
						LPLCoreReporter.WriteReport(strStepName + ":" + strStepDescription, strExpectedResult,strActualResultIfPass, LPLCoreConstents.PASSED, "");
				}else{
					LPLCoreReporter.WriteReport(strStepName + ":" +strStepDescription, strExpectedResult, strActualResultIfFailed, LPLCoreConstents.FAILED,LPLCoreReporter.captureScreenShot(driver, strScreenshotName+dateFormat.format(date)));
				}
			}
			
		 	/**
			 * This method is used to write the step reporter in scripts by capturing the screenshot path for both Passed & Failed step
			 * @author Aiswarya Srinivasan
			 * @since 11-24-2017
			 * @param boolean blnResult - The required method boolean result captured in script
			 * 			boolean blnWhatResultIsPassed -To pass or fail the step
			 * 			String strStepDescription - Step Description
			 * 			String strExpectedResult - Expected Result
			 * 			String strActualResultIfPass - Actual Results if it is passed
			 * 			String strActualResultIfFailed - Actual Results if it is failed 
			 * 			boolean blnScreenshotRequiredForPassed - True: If screenshot path is required for Passed step also.
			 * 													 false: No need of screenshot path for Passed step.			
			 * @return None
			 */
			public static void writeStepToReporter(boolean blnResult, boolean blnWhatResultIsPassed,String strStepDescription, String strExpectedResult, String strActualResultIfPass,String strActualResultIfFailed,boolean blnScreenshotRequiredForPassed){
				date = new Date();
				stepCount++;
				String strStepName = "Step " + stepCount;
				String strScreenshotName = strStepName+ "_";
				if(blnWhatResultIsPassed==blnResult){
					if (!blnScreenshotRequiredForPassed) {
						LPLCoreReporter.WriteReport(strStepName + ":" + strStepDescription, strExpectedResult,strActualResultIfPass, LPLCoreConstents.PASSED, "");
					}else{
						LPLCoreReporter.WriteReport(strStepName + ":" + strStepDescription, strExpectedResult,strActualResultIfPass, LPLCoreConstents.PASSED, LPLCoreReporter.captureScreenShot(driver, strScreenshotName+dateFormat.format(date)));
					}
				}else{
					LPLCoreReporter.WriteReport(strStepName + ":" +strStepDescription, strExpectedResult, strActualResultIfFailed, LPLCoreConstents.FAILED,LPLCoreReporter.captureScreenShot(driver, strScreenshotName+dateFormat.format(date)));
				}
			}
		}
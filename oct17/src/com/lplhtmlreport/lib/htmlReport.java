package com.lplhtmlreport.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;

import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;

/**
 * <p>
 * <br>
 * <b> Title: </b> htmlReport.java</br> <br>
 * <b> Description: </B> LPL Core Library - HTML Reporter methods</br> <br>
 * <b>Usage:</br></b> 
 * <br>1. HTMLReport : Create HTML file and write test steps, config property, test data, page objects in newly created HTML file</br>
 * <br>2. indexOfItem : Get Index for Strart index</br>
 * <br>3. FileMoving : Move HTML file from local machine to QA2000server after script ended or failed</br>
 * <br>4. getScriptName : Get script name from caller script</br>
 * <br>5. getMultiplePageID : Add page objects in ArrayList and return that list</br>
 * <br>6. getPageID : Get page ids from the script</br>
 * <br>7. pageObjects : Get all the page objects for given page id</br>
 * <br>8. tabSwitch : To switch to config, test data, page objects and test steps tabs</br>
 * <br>9. writeTestStep : Write test steps in HTML Report</br>
 * <br>10. writeTestData: Write test data in HTML Report</br>
 * <br>11. ReportHTML : Get test steps details and add steps in ArrayList</br>
 * <br>12. writeConfig : Write config properties in HTML Report</br>
 * <br>13. getHostDetails: Used to get Current Host Details </br>
 * @author Partha Sham / Nishit Gupta
 * @since 06-19-2017
 * </p>
 */
public class htmlReport extends LPLCoreDriver{

	/*static ArrayList<String> arrList = new ArrayList<String>();
	static ArrayList<Integer> list = new ArrayList<Integer>();*/
	static ArrayList<String> arrList = new ArrayList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	static int intPageID;
	static int iTotalStep;
	static int intIndex;
	public String strScriptName;
	static String strStart = "******Test Execution Section Starts******";
	static boolean blnResult = false;
	public String strglobaldatetime ;
	
	/**
	 * Create HTML file and write test steps, config property, test data, page objects in newly created HTML file
	 * @author Partha Sham
	 * @since 06-21-2017
	 * @param None
	 * @return None
	 */
	public  void HTMLReport() {
	
		
		//htmlReport report = new htmlReport();
        this.strScriptName = /*report.*/getScriptName();
        Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("HH"+"_"+"mm"+"_"+"ss");
		strglobaldatetime = df.format(date);
		
        /*Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MMddyyyyHHmmss");
        strglobaldatetime = df.format(date);*/
		File file = new File(LPLCoreConstents.getInstance().htmlReportPath+strScriptName+"_" +strglobaldatetime+".html");
		
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		try {
			file.delete();
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
				
			String htmlPage = "<html><head><title>Report</title><link rel='stylesheet' type='text/css' href='"+LPLCoreConstents.getInstance().CSSPath+"'><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'></head><body>";
			
			bufferedWriter.write(htmlPage);
			
			bufferedWriter.append("<div class='w3-container w3-teal'>");
			bufferedWriter.append("<h1><i class='fa fa-home'>"+strScriptName+"_"+strglobaldatetime+"</i></h1></div>");
			bufferedWriter.append("<div class='w3-container'>");
			bufferedWriter.append("<header class='w3-container'>");
			intIndex = /*report.*/indexOfItem(strStart);
			String strStepDetails = arrList.get(intIndex);
			strStepDetails =  strStepDetails.toUpperCase();
			
			//added on 07/05
			if(strStepDetails.contains("TOTAL NUMBER OF STEP IN SCRIPT")){
				blnResult = true;
				String[] strStep = arrList.get(intIndex).split(":");
				iTotalStep = Integer.parseInt(strStep[1].trim());
			}
			else{
				intIndex=85;
				iTotalStep=0;
			}
			bufferedWriter.append("<div>");
			
			bufferedWriter.append("<h3>Test Execution Details </h3></header>");
			bufferedWriter.append("<table class='w3-table-all'>");
			
			bufferedWriter.append("<tr class='w3-indigo'>");
			bufferedWriter.append("<td>"+"Test Step"+"</td>");
			bufferedWriter.append("<td>"+"Expected Result"+"</td>");
			bufferedWriter.append("<td>"+"Actual Result"+"</td>");
			bufferedWriter.append("<td>"+"Status"+"</td>");
			bufferedWriter.append("<td>"+"Screenshot Path"+"</td>");
			bufferedWriter.append("</tr><tr>");
			int startCount = (intIndex+(iTotalStep*5))+5;
			
			if(startCount < arrList.size()){
				try{
					for(int i=startCount;i<arrList.size();i++){
						
						if(i>4 && i%5 == 0){
							bufferedWriter.append("</tr><tr>");
						}
						if(arrList.get(i).equalsIgnoreCase(LPLCoreConstents.FAILED)){
							bufferedWriter.append("<td class='w3-red'>"+arrList.get(i).toUpperCase()+"</td>");
						}else if(arrList.get(i).equalsIgnoreCase(LPLCoreConstents.PASSED)){
							bufferedWriter.append("<td class='w3-green'>"+arrList.get(i).toUpperCase()+"</td>");
						}else if(i%5 == 4 && arrList.get(i-1).equals(LPLCoreConstents.FAILED)){
							bufferedWriter.append("<td><a href="+arrList.get(i)+">Screenshot</a></td>");
						}
						else{
							bufferedWriter.append("<td>"+arrList.get(i)+"</td>");
						}					
					}
				}
				catch(Exception e){					
					e.printStackTrace();
				}
			}
			bufferedWriter.append("</tr>");
			bufferedWriter.append("</table>");
			bufferedWriter.append("</div>");
			bufferedWriter.append("<hr>");
			
			/*report.*/tabSwitch(bufferedWriter);
			/*report.*/writeConfig(bufferedWriter);
			/*report.*/writeTestData(bufferedWriter);
			/*report.*/getHostDetails(bufferedWriter);
			
			int maxCount =  intIndex+(iTotalStep*5)+5;
			
			if(maxCount<arrList.size()){
				writeTestStep(bufferedWriter,intIndex,maxCount,blnResult);
			}
			
			ArrayList<Integer> listArray = new ArrayList<Integer>();
			listArray = /*report.*/getMultiplePageID();
			/*report.*/pageObjects(bufferedWriter, listArray);
			
			bufferedWriter.append("</body></html>");
			bufferedWriter.flush();
			fileWriter.flush();			
		} 
		catch(Exception e) {				
			System.out.println(e.getMessage());
		}finally{
			try {		
				bufferedWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	/**
	 * Get Index for Starting point
	 * @author Partha Sham
	 * @since 06-26-2017
	 * @param String - Starting point 
	 * @return int - index Of Item
	 */
	public int indexOfItem(String item) {
		int index=0;
		for(int i = 0; i < arrList.size(); i++) {
			if(arrList.get(i).contains(item)) {
				index = i+5;
			}
		}
		return index;
	}
	
	/**
	 * Move HTML file from local machine to QA2000server after script ended or failed
	 * @author Partha Sham
	 * @since 07-17-2017
	 * @param String - Source Path, String - Destination Path
	 * @return None
	 */
	public void FileMoving(String sourceFilePath, String destinationPath){
		
		File source = new File(sourceFilePath+strScriptName+"_" + strglobaldatetime+".html");
		File dest = new File(destinationPath+strScriptName+"_" + strglobaldatetime+".html");
		try {
		    FileUtils.copyFile(source, dest);
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Get script name from caller script
	 * @author Partha Sham
	 * @since 06-29-2017
	 * @param None
	 * @return String - Caller script name
	 */
	public String getScriptName(){
		
		try {
			/** MySQL Driver */
			LPLCoreConstents lplCoreConstents = LPLCoreConstents.getInstance();
			String mySQLDriver = lplCoreConstents.MySQLDriver;
			CallableStatement callableStatement = null;
			ResultSet testDataResultSet = null;
			
			//Load the MySQL driver 
			Class.forName(mySQLDriver);
			
			//Create the MySQL Connection
			Connection mySQLConnection = DriverManager.getConnection(lplCoreConstents.FARMDBConnectionString);
            
			//Sql Query	
            String strScriptNameQuery = "SELECT Scripts.ScriptName ScriptName FROM FARM.DATA_Scripts Scripts  Where Scripts.ID = '"+ocfg.getScriptId()+"'";

			//callableStatement 
            callableStatement = mySQLConnection.prepareCall(strScriptNameQuery);

			//Execute the Stored Procedure to get the ResultSet
			testDataResultSet = callableStatement.executeQuery();
			String strScriptName=null;
			
			//Validate if it is null
			if(testDataResultSet != null){
				System.out.println("Successfully Fetched Test Data");
				testDataResultSet.next();
				strScriptName=testDataResultSet.getString(1);	
			}
			else
				System.out.println("Failed To Fetch Test Data");
			//Closing all the DB instances.
			testDataResultSet.close();
			callableStatement.close();
			mySQLConnection.close();
			strScriptName = strScriptName.replace(".jar", "");
				
			
			return strScriptName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	
}
	
	
	/**
	 * Add page objects in ArrayList and return that list
	 * @author Partha Sham
	 * @since 06-29-2017
	 * @param None
	 * @return ArrayList<Integer> - contains all page ids
	 */
	public ArrayList<Integer> getMultiplePageID(){
		
		return list;
	}
	
	/**
	 * Get page ids from the script
	 * @author Partha Sham
	 * @since 06-26-2017
	 * @param int - multiple or single page id
	 * @return None
	 */
	public void getPageID(int ...iPageID){
		
		HTMLGetSet htmlGetSet = new HTMLGetSet();
		for (int i : iPageID) {
			htmlGetSet.setPageID(i);
			
			if(!list.contains(htmlGetSet.getPageID())){
			       list.add(i);
			}
		}
	}
	
	/**
	 * Get all the page objects for given page id
	 * @author Partha Sham
	 * @since 06-30-2017
	 * @param BufferedWriter - buffered Writer control, ArrayList<Integer> multiple page ids
	 * @return None
	 */
	public void pageObjects(BufferedWriter bufferedWriter, ArrayList<Integer> intArrayList){
		 try {
			 	bufferedWriter.append("<div id='id03' class='w3-panel w3-display-container w3-border w3-indigo' style='display:none'>");
			 	bufferedWriter.append("<span onclick=this.parentElement.style.display='none' class='w3-button w3-red w3-display-topright'>"+"Close"+"</span>");
			 	bufferedWriter.append("<table class='w3-table-all'>");
				
				bufferedWriter.append("<tr><h3>Page Objects</h3></tr>");
				if(intArrayList.size() > 0){
				 	for (Integer pageID : intArrayList) {
				 		
					 	HashMap<String, HashMap<String, String>> testData=LPLCoreDBConnect.getObjectsFromDB(pageID,Integer.parseInt(String.valueOf(LPLCoreDriver.ocfg.getEnvId())));			 	
					 	bufferedWriter.append("<tr><td>Page Objects for page id with :"+pageID+"</td>");
					 	bufferedWriter.append("<td>Number of objects present :"+testData.size()+"</td><td></td></tr>");
						for (Entry<String, HashMap<String, String>> entry : testData.entrySet()){
							
							bufferedWriter.append("<tr>");
							
							HashMap<String, String> pageObjects = entry.getValue();
							for (Entry<String, String> valueEntry : pageObjects.entrySet()) {
								if(valueEntry.getValue() != null && valueEntry.getValue().length() > 0){
									bufferedWriter.append("<td>"+ entry.getKey()+"</td>");
									bufferedWriter.append("<td>"+ valueEntry.getKey()+"</td>");
									bufferedWriter.append("<td>"+ valueEntry.getValue()+"</td></tr>");
								}
							}
						}
					}
				}else{
					bufferedWriter.append("<tr>"+"No Page Objects Details Present in Script"+"</tr>");
				}
				bufferedWriter.append("</table>");
				bufferedWriter.append("</div>");
		 }
		 catch(Exception exception){
			 exception.printStackTrace();
		 }
	}
	
	/**
	 * To switch to config, test data, page objects and test steps tabs
	 * @author Partha Sham
	 * @since 07-05-2017
	 * @param BufferedWriter - buffered Writer control
	 * @return None
	 */
	public void tabSwitch(BufferedWriter bufferedWriter){
		
		try {
			bufferedWriter.append("<div class='w3-container w3-center'>");
			bufferedWriter.append("<button class='w3-button w3-indigo' onclick=document.getElementById('id01').style.display='block'><i class='w3-xlarge fa fa-cogs' aria-hidden='true'>"+" Config Property"+"</i></button>");
			bufferedWriter.append("<button class='w3-button w3-indigo' onclick=document.getElementById('id02').style.display='block'><i class='w3-xlarge fa fa-database' aria-hidden='true'>"+" Test Data"+"</i></button>");
			bufferedWriter.append("<button class='w3-button w3-Indigo' onclick=document.getElementById('id03').style.display='block'><i class='w3-xlarge fa fa-object-group' aria-hidden='true'>"+" Page Objects"+"</i></button>");
			bufferedWriter.append("<button class='w3-button w3-Indigo' onclick=document.getElementById('id04').style.display='block'><i class='w3-xlarge fa fa-list-alt' aria-hidden='true'>"+" Test Step"+"</i></button>");
			bufferedWriter.append("<button class='w3-button w3-Indigo' onclick=document.getElementById('id05').style.display='block'><i class='w3-xlarge fa fa-h-square' aria-hidden='true'>"+" Host Details"+"</i></button>");
			bufferedWriter.append("</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Write test steps in HTML Report
	 * @author Partha Sham
	 * @since 07-06-2017
	 * @param BufferedWriter - buffered Writer control, int - index for start, int -  end point
	 * @return None
	 */
	public void writeTestStep(BufferedWriter bufferedWriter,int intIndex,int maxCount, boolean blnStatus){
		
		try {
		
		 	bufferedWriter.append("<div id='id04' class='w3-panel w3-display-container w3-border w3-indigo' style='display:none'>");
		 	bufferedWriter.append("<span onclick=this.parentElement.style.display='none' class='w3-button w3-red w3-display-topright'>"+"Close"+"</span>");
		 	bufferedWriter.append("<table class='w3-table-all'>");
			
			bufferedWriter.append("<tr><h3>Test Step</h3></tr>");
				if (blnStatus){
			 	for(int count = intIndex;count<maxCount;count++){
			 		if(arrList.get(count).length()>0){
			 			bufferedWriter.append("<tr><td>"+arrList.get(count)+"</tr></td>");
			 		}
			 	}
				}else{
					bufferedWriter.append("<tr>"+"No Test Step Details Present in Script"+"</tr>");
				}
		 	bufferedWriter.append("</table>");
			bufferedWriter.append("</div>");
		}
		catch(Exception exception){
			 exception.printStackTrace();
		 }
	}
	
	/**
	 * Write test data in HTML Report
	 * @author Partha Sham
	 * @since 06-20-2017
	 * @param BufferedWriter - buffered Writer control
	 * @return None
	 */
	public void writeTestData(BufferedWriter bufferedWriter){
		
		 try {
			 	bufferedWriter.append("<div id='id02' class='w3-panel w3-display-container w3-border w3-indigo' style='display:none'>");
			 	bufferedWriter.append("<span onclick=this.parentElement.style.display='none' class='w3-button w3-red w3-display-topright'>"+"Close"+"</span>");
			 	HashMap<String, String> testData=LPLCoreDBConnect.getTestDataFromDB(Integer.parseInt(String.valueOf(LPLCoreDriver.ocfg.getScriptId())),Integer.parseInt(String.valueOf(LPLCoreDriver.ocfg.getEnvId())));
				bufferedWriter.append("<table class='w3-table-all'>");
				
				bufferedWriter.append("<tr><h3>Test Data</h3></tr>");
				for (Map.Entry<String,String> entry : testData.entrySet()){
					bufferedWriter.append("<tr><td>"+ entry.getKey()+"</td><td>"+entry.getValue()+"</td></tr>");
				}
				bufferedWriter.append("</table>");
				bufferedWriter.append("</div>");
		 }
		 catch(Exception exception){
			 exception.printStackTrace();
		 }
	}
	
	/**
	 * This Mehtods get the current host details
	 * @author Nishit Gupta
	 * @since 11-29-2017
	 * @param BufferedWriter - buffered Writer control
	 * @return None
	 */
	
	public void getHostDetails(BufferedWriter bufferedWriter){

		try {
			@SuppressWarnings("resource")
			// BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream( "C:\\Windows\\system32\\drivers\\etc\\hosts." ) ));
			BufferedReader br = new BufferedReader(new FileReader("C:\\Windows\\system32\\drivers\\etc\\hosts"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			bufferedWriter.append("<div id='id05' class='w3-panel w3-display-container w3-border w3-indigo' style='display:none'>");
			bufferedWriter.append("<span onclick=this.parentElement.style.display='none' class='w3-button w3-red w3-display-topright'>"+"Close"+"</span>");
			bufferedWriter.append("<table class='w3-table-all'>");
			bufferedWriter.append("<tr>"+"Host Entries");
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				bufferedWriter.append("<tr><td>"+line+"</td></tr>");
			}

			bufferedWriter.append("</tr>");



			bufferedWriter.append("</table>");
			bufferedWriter.append("</div>");
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Get test steps details and add steps in ArrayList
	 * @author Partha Sham
	 * @since 06-20-2017
	 * @param String - Test Step,String - Expected Result,String - Actual Result,String - Status,String - Screenshot Path
	 * @return ArrayList<String> - contains all steps
	 */
	public ArrayList<String> ReportHTML(String TestStep,String ExpectedResult,String ActualResult,String Status,String ScreenshotPath){
		
		arrList.add(TestStep);
		arrList.add(ExpectedResult);
		arrList.add(ActualResult);
		arrList.add(Status);
		arrList.add(ScreenshotPath);
		
		return arrList;
	}

	/**
	 * Write config properties in HTML Report
	 * @author Partha Sham
	 * @since 06-22-2017
	 * @param BufferedWriter - buffered Writer control
	 * @return None
	 */
	public void writeConfig(BufferedWriter bufferedWriter){
		
		 try {
			bufferedWriter.append("<div id='id01' class='w3-panel w3-display-container w3-border w3-indigo' style='display:none'>");
			bufferedWriter.append("<span onclick=this.parentElement.style.display='none' class='w3-button w3-red w3-display-topright'>"+"Close"+"</span>");
			bufferedWriter.append("<table  class='w3-table-all'>");
			
			//** OS Name *//*
			bufferedWriter.append("<tr><h3>Config Property</h3></tr>");
			bufferedWriter.append("<tr><td>OS Name :</td><td>"+System.getProperty("os.name").toUpperCase()+"</td></tr>" );
			//** JRE Version *//*
			bufferedWriter.append("<tr><td>JRE Version :</td><td>"+System.getProperty("java.version")+"</td></tr>" );
			//** Browser Name & Version *//*
			
			/*Capabilities caps = ((RemoteWebDriver) LPLCoreDriver.driver).getCapabilities();
			//Capabilities caps = ((RemoteWebDriver) LPLCoreDriver.driver).getCapabilities();
			bufferedWriter.append("<tr><td>Browser Name :</td><td>"+caps.getBrowserName().toUpperCase()+"</td></tr>" );
			bufferedWriter.append("<tr><td>Browser Version :</td><td>"+caps.getVersion().toUpperCase()+"</td></tr>" );*/
			//** Application *//*
			bufferedWriter.append("<tr><td>Application :</td><td>"+LPLCoreDriver.ocfg.getApplication().toUpperCase()+"</td></tr>" );
			//** URL *//*
			bufferedWriter.append("<tr><td>URL :</td><td>"+String.valueOf(LPLCoreDriver.ocfg.getURL())+"</td></tr>" );
			//** UserName *//*
			bufferedWriter.append("<tr><td>UserName :</td><td>"+String.valueOf(LPLCoreDriver.loginCredentials.get("Username"))+"</td></tr>" );
			//** Password *//*
			/*if(LPLCoreDriver.ocfg.getEnvironment().toUpperCase().contains("QA")){			 
				bufferedWriter.append("<tr><td>Password :</td><td>"+String.valueOf(LPLCoreDriver.loginCredentials.get("Password"))+"</td></tr>" );
			}else{
				bufferedWriter.append("<tr><td>Password :</td><td>*****</td></tr>" );
			}*/
			//** Environment *//*
			bufferedWriter.append("<tr><td>Environment :</td><td>"+LPLCoreDriver.ocfg.getEnvironment().toUpperCase()+"</td></tr>" );
			//** FIRM *//*
			bufferedWriter.append("<tr><td>FIRM :</td><td>"+LPLCoreDriver.ocfg.getFirm().toUpperCase()+"</td></tr>" );
			//** Environment ID *//*
			bufferedWriter.append("<tr><td>Environment ID :</td><td>"+String.valueOf(LPLCoreDriver.ocfg.getEnvId())+"</td></tr>" );
			//** Script ID *//*
			bufferedWriter.append("<tr><td>Script ID :</td><td>"+String.valueOf(LPLCoreDriver.ocfg.getScriptId())+"</td></tr>" );
			//** Job ID *//*
			bufferedWriter.append("<tr><td>Job ID :</td><td>"+String.valueOf(LPLCoreDriver.ocfg.getJobID())+"</td></tr>" );
			//** Lab ID *//*
			bufferedWriter.append("<tr><td>Lab ID :</td><td>"+String.valueOf(LPLCoreDriver.ocfg.getLabID())+"</td></tr>" );
			//** Lab Group ID *//*
			bufferedWriter.append("<tr><td>Lab Group ID :</td><td>"+String.valueOf(LPLCoreDriver.ocfg.getLabGroupID())+"</td></tr>" );
			//bufferedWriter.append("</tr>");
			bufferedWriter.append("</table>");
			bufferedWriter.append("</div>");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}

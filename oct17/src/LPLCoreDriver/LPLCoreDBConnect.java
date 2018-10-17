package LPLCoreDriver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import org.apache.log4j.Logger;


/**
 * <p>
 * <br>
 * <b> Title: </b> LPLCoreDBConnect.java</br> <br>
 * <b> Description: </B> LPL Core Library - DB Connection file</br> <br>
 * <b>Usage:</br></b> 
 * <br>1. getTestDataFromDB: Method to get the test data from FARM Database</br>
 * <br>2. getLoginCredentialFromDB: Method to get the login credentials from FARM Database</br>
 * <br>3. getObjectsFromDB: Method to get the object identification properties from FARM Database</br>
 * <br>4. updatePassword: Method to update the password in the Database</br>
 * <br>5. getIPDetails: Method to get IP details</br>
 * <br>6. getRestrictedLoginsFromDB:Method to get Restricted Logins</br>
 * @author Ambarish Khatua,Gopu Raju, Jyothi Jyothi
 * @since 06-09-2016
 *        </p>
 */

public class LPLCoreDBConnect {

	//using Log4j logger
	public static Logger log = Logger.getLogger(LPLCoreDBConnect.class); 
	
	/**
	 * Method to get the test data from FARM Database
	 * @author Ambarish Khatua
	 * @since 06-09-2016
	 * @param int intScriptID - Script Id, int intEnvID - Environment Id
	 * @return HashMap<String, String> - Test Data in form of Key,Value pair 
	 * where key will the data key and value will be the test data
	 */
	public static HashMap<String, String> getTestDataFromDB(int intScriptID, int intEnvID){
		/** 
		 * Create the HashMap to store the test data key and test data value
		 * Example: Key will be "strAccountNo" and Value will be "1111-1111"
		 */
		
		HashMap<String, String> testDataMap = new HashMap<String, String>();
		
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
			
			//Create the CallableStatement to execute the Stored Procedure
			callableStatement = mySQLConnection.prepareCall("{call "+lplCoreConstents.TestDataStoredProcedure+"(?,?)}");
			
			//Set the input data to execute the Stored Procedure
			callableStatement.setInt(1, intEnvID);
			callableStatement.setInt(2, intScriptID);
			
			//Execute the Stored Procedure to get the ResultSet
			testDataResultSet = callableStatement.executeQuery();
			
			//Validate if it is null
			if(testDataResultSet != null){
				log.info("Successfully Fetched Test Data");
				
				//Iterate through the ResultSet and fetch all the test data
				while(testDataResultSet.next()){
					//Add the Test Data Key and Value in HashMap in form of Key,Value pair.
					testDataMap.put(testDataResultSet.getString(2), testDataResultSet.getString(3));
				}
			}
			else
				log.info("Failed To Fetch Test Data");
				
			//Closing all the DB instances.
			testDataResultSet.close();
			callableStatement.close();
			mySQLConnection.close();
			
			
			return testDataMap;
		} catch (Exception e) {
			log.info(e.getMessage());
			return testDataMap;
		}
	}
	
	/**
	 * Method to get the login credentials from FARM Database
	 * @author Ambarish Khatua
	 * @since 06-09-2016
	 * @modified by Gopu Raju
	 * @since 02-23-2018
	 * Added Getting IP details
	 * @param int intScriptID - Script Id, int intFirmID - Firm Id, int intProductID - Product Id, int intEnvID - Environment Id
	 * @return HashMap<String, String> - Key,Value pair of Username and Password 
	 * where key will "Username" and "Password" respectively
	 */
	@SuppressWarnings("unused")
	public static HashMap<String, String> getLoginCredentialFromDB(int intScriptID, int intFirmID, int intProductID, int intEnvID,String strCryptoKey, String strEncryptionFlag){
        /** 
         * Create the HashMap to store the Username and Password
        * Example: Key will be "Username" and Value will be "test.account"
        * Key will be "Password" and Value will be "P@ssw0rd"
        */
        HashMap<String, String> loginDataMap = new HashMap<String, String>();
        
        //LPLConfig reference
        LPLConfig config;
        
        //Firm Name
        String strFirm;

        //Environment Name
        String strEnvironment;
        
        //UserName
        String strPassword;
        
        //Password
        String strUserName;
        

        String strIpAddress;

        String strHostName;
        
        try {
              //Fetch the Firm & Environment details from Config file 
              config = new LPLConfig();
              strFirm = config.getFirm();
              strEnvironment = config.getEnvironment();
              
              /** MySQL Driver */
              LPLCoreConstents lplCoreConstents = LPLCoreConstents.getInstance();
              String mySQLDriver = lplCoreConstents.MySQLDriver;
              String strFARMDBConnectionString = lplCoreConstents.FARMDBConnectionString;
              CallableStatement callableStatement = null;
              ResultSet loginResultSet = null;
              
              //get Host address
              strIpAddress = getIPDetails().getHostAddress();
              
              //get Host Name
              strHostName = getIPDetails().getHostName();
              
              
              //Load the MySQL driver 
              Class.forName(mySQLDriver);
              
              //Create the MySQL Connection
              Connection mySQLConnection = DriverManager.getConnection(strFARMDBConnectionString);

              //Create the CallableStatement to execute the Login Data Stored Procedure
              callableStatement = mySQLConnection.prepareCall("{call "+lplCoreConstents.LogInCredentialStoredProcedure+"(?,?,?,?,?,?,?)}");
              
              //Set the input data to execute the Stored Procedure
              callableStatement.setInt(1, intScriptID);
              callableStatement.setInt(2, intFirmID);
              callableStatement.setInt(3, intProductID);
              callableStatement.setInt(4, intEnvID);
              callableStatement.setString(5, strCryptoKey);
              callableStatement.setString(6, strIpAddress);
              callableStatement.setString(7, strHostName);
      
              //Execute the Stored Procedure to get the ResultSet
              loginResultSet = callableStatement.executeQuery();
              
        
              //Validate if it is null
              if(loginResultSet != null){
                    log.info("Successfully Fetched LogIn Data");
                    
                    loginResultSet.next();
                    
                    //Add the Username form of Key,Value pair.
                    strUserName = loginResultSet.getString(1);
                    loginDataMap.put("Username", strUserName);
                    
                    strPassword = loginResultSet.getString(2);
                    
                    //Add the Password form of Key,Value pair.
                    loginDataMap.put("Password", strPassword);
              }
              else
                 log.info("Failed To Fetch LogIn Data");
              
              //Closing all the DB instances.
              loginResultSet.close();
              callableStatement.close();
              mySQLConnection.close();
              
              //Return login data 
              return loginDataMap;
        } catch (Exception e) {
              log.info(e.getMessage());
              return loginDataMap;
        }
  }
	
	
	
	/**
	 * Method to get Restricted Logins
	 * @author Jyothi Jyothi
	 * @since 03-06-2018
	 * @param int intScriptID - Script Id, String strCryptoKey-CryptoKey
	 * @return HashMap<String, String> - Key,Value pair of Username and Password 
	 * where key will "Username" and "Password" respectively
	 */
	@SuppressWarnings("unused")
	public static HashMap<String, HashMap<String, String>> getRestrictedLoginsFromDB(int intScriptID,String strCryptoKey){
		/** 
         * Create the HashMap to store the Username and Password
        * Example: Key will be "Username" and Value will be "test.account"
        * Key will be "Password" and Value will be "P@ssw0rd"
        */
		HashMap<String, HashMap<String, String>> loginDataMap = new HashMap<String, HashMap<String, String>>();
        
        //UserName
        String strPassword;
        
        //Password
        String strUserName;
        
		//IP Address
        String strIpAddress;
		
		//Host Name
        String strHostName;
        String strURL;
        
        try {
              
              /** MySQL Driver */
              LPLCoreConstents lplCoreConstents = LPLCoreConstents.getInstance();
              String mySQLDriver = lplCoreConstents.MySQLDriver;
              String strFARMDBConnectionString = lplCoreConstents.FARMDBConnectionString;
              CallableStatement callableStatement = null;
              ResultSet loginResultSet = null;
              //get Host address
              strIpAddress = getIPDetails().getHostAddress();
              
              //get Host Name
              strHostName = getIPDetails().getHostName();
              
              
              //Load the MySQL driver 
              Class.forName(mySQLDriver);
              
              //Create the MySQL Connection
              Connection mySQLConnection = DriverManager.getConnection(strFARMDBConnectionString);
                            
              //Create the CallableStatement to execute the Login Data Stored Procedure 
             callableStatement = mySQLConnection.prepareCall("{call FARM."+lplCoreConstents.restrictedCredentialsStoredProcedure+"(?,?,?,?)}");
              
              //Set the input data to execute the Stored Procedure
              callableStatement.setInt(1, intScriptID);
              callableStatement.setString(2, strHostName);
              callableStatement.setString(3, strIpAddress);
              callableStatement.setString(4, strCryptoKey);
                
              //System.out.println(strHostName+ " " +strIpAddress);
              
              //Execute the Stored Procedure to get the ResultSet
              loginResultSet = callableStatement.executeQuery();
              
            
              //Validate if it is null
              if(loginResultSet != null){
                log.info("Successfully Fetched LogIn Data");
                    
              //Iterate through the ResultSet and fetch all the Page Objects
				while(loginResultSet.next()){

					HashMap<String, String> loginSet = new HashMap<String, String>();
					loginSet.put("Username",loginResultSet.getString(2));
					loginSet.put("Password",loginResultSet.getString(3));
					loginSet.put("URL",loginResultSet.getString(4));
					
					//Add the login name as Key and Locators as Value in HashMap
					loginDataMap.put(loginResultSet.getString(2), loginSet);	
				}	
				}
              else
                 log.info("Failed To Fetch LogIn Data");
              
              //Closing all the DB instances.
              loginResultSet.close();
              callableStatement.close();
              mySQLConnection.close();
              
              //Return login data 
              return loginDataMap;
        } catch (Exception e) {
              log.info(e.getMessage());
              return loginDataMap;
        }
  }
	
	
	/**
	 * Method to update the password in the Database
	 * @author Gopu Raju
	 * @since 02-23-2018
	 * @param String strLoginID, String strPassword,String strCryptoKey
	 * @return blnResult-true/false 
	 */
	public static boolean updatePassword(String strLoginID, String strPassword,String strCryptoKey){
	   boolean blnResult=false;
	   
	   //IP Address
	    String strIpAddress;
	    
	    //Host Name
	    String strHostName; 
	    try {
	          
	          /** MySQL Driver */
	          LPLCoreConstents lplCoreConstents = LPLCoreConstents.getInstance();
	          String mySQLDriver = lplCoreConstents.MySQLDriver;
	          String FARMDBConnectionString = lplCoreConstents.FARMDBConnectionString;
	          CallableStatement callableStatement = null;
	          ResultSet loginResultSet = null;
	          
	          //get the Host Address
	          strIpAddress = getIPDetails().getHostAddress();
	          
	          //get the Host Name
	          strHostName = getIPDetails().getHostName();
	          
	          
	          //Load the MySQL driver 
	          Class.forName(mySQLDriver);
	          
	          //Create the MySQL Connection
	          Connection mySQLConnection = DriverManager.getConnection(FARMDBConnectionString);
	          
	          //Create the CallableStatement to execute the Login Data Stored Procedure
	          callableStatement = mySQLConnection.prepareCall("{call "+lplCoreConstents.updatePasswordStoredProcedure+"(?,?,?,?,?)}");
	          
	          //Set the input data to execute the Stored Procedure
	          callableStatement.setString(1, strLoginID);
	          callableStatement.setString(2, strPassword);
	          callableStatement.setString(3, strCryptoKey);
	          callableStatement.setString(4, strIpAddress);
	          callableStatement.setString(5, strHostName);

	          //Execute the Stored Procedure to get the ResultSet
	          loginResultSet = callableStatement.executeQuery();
	         
	          //convert loginResultSet to string
	          String strLoginResult=loginResultSet.toString();
	          
	          //get the last character
	          char strlastchar=strLoginResult.charAt(strLoginResult.length()-1);
	          
	          //Determines if the specified character is a digit.
	          if (Character.isDigit(strlastchar)) { 
	        	//Returns the int value that the specified Unicode character represents.
	  		    int num = Character.getNumericValue(strlastchar); 
	  		    if(num>0){
	  		    	//password updated with num number of records
	  		    	blnResult=true;
	  		    }
	  		    else{
	  		    	//Password is not updated with even one record  
	  		    	blnResult=false;
	  		    }
	  		}

	          loginResultSet.close();
	          callableStatement.close();
	          mySQLConnection.close();
	          
	
	    } catch (Exception e) {
	          log.info(e.getMessage());
	          blnResult=false;
	    }
		return blnResult;
	}
	
	
	/**
	 * Method to get IP details
	 * @author Gopu Raju
	 * @since 02-23-2018
	 * @param none
	 * @return InetAddress ip
	 */
	@SuppressWarnings("unused")
	public static InetAddress getIPDetails(){
		   
	     InetAddress ip = null;
	   String hostname;
	   try {
		  //Get local host
	       ip = InetAddress.getLocalHost();
	       
	       //Get host name from local host
	       hostname = ip.getHostName();
	       
	       ip.getAddress();
	       
	   } catch (UnknownHostException e) {
		   log.info(e.getMessage());
		   return ip;
	   }
	     return ip;
	} 
	
	
	/**
	 * Method to get the object identification properties from FARM Database
	 * @author Ambarish Khatua
	 * @since 06-23-2016
	 * @param int intPageID - Page Id, int intEnvID - Environment Id
	 * @return HashMap<String, HashMap<String, String>> - Page Objects where object name as Key and value as another HashMap 
	 * 													  containing object identification properties.
	 */
	public static HashMap<String, HashMap<String, String>> getObjectsFromDB(int intPageID, int intEnvID){
		/** 
		 * Create HashMap to store object name as Key and value as another HashMap containing object identification properties.
		 * Example: Key will be "AccountSearchButton" and Value will be {"ID","text-search-button"}
		 */
		HashMap<String, HashMap<String, String>> PageObjectsMap = new HashMap<String, HashMap<String, String>>();
		
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
			
			//Create the CallableStatement to execute the Stored Procedure to fetch Page Objects from FARM Database
			callableStatement = mySQLConnection.prepareCall("{call "+lplCoreConstents.PageObjectStoredProcedure+"(?,?)}");
			
			//Set the input data to execute the Stored Procedure
			callableStatement.setInt(1, intPageID);
			callableStatement.setInt(2, intEnvID);
			
			//Execute the Stored Procedure to get the ResultSet
			testDataResultSet = callableStatement.executeQuery();
			
			//Validate if it is null
			if(testDataResultSet != null){
				log.info("Successfully Fetched Page Objects");
				
				//Iterate through the ResultSet and fetch all the Page Objects
				while(testDataResultSet.next()){
					/** 
					 * Create HashMap to store object identification properties.
					 * Example: Key will be "ID"/"XPATH" etc and Value will be ID/XPATh etc locator
					 */
					HashMap<String, String> pageObjects = new HashMap<String, String>();
					pageObjects.put("ID", testDataResultSet.getString(lplCoreConstents.intIDIndex));
					pageObjects.put("CSS", testDataResultSet.getString(lplCoreConstents.intCSSIndex));
					pageObjects.put("XPATH", testDataResultSet.getString(lplCoreConstents.intXPATHIndex));
					pageObjects.put("XCORD", testDataResultSet.getString(lplCoreConstents.intXCORDIndex));
					pageObjects.put("YCORD", testDataResultSet.getString(lplCoreConstents.intYCORDIndex));
					pageObjects.put("ANGULARREF", testDataResultSet.getString(lplCoreConstents.intAngularRefIndex));
					pageObjects.put("ANGULARLOCATORTYPE", testDataResultSet.getString(lplCoreConstents.intAngularLocatorTypeIndex));
					
					//Add the Page Object Name as Key and Locators as Value in HashMap
					PageObjectsMap.put(testDataResultSet.getString(1), pageObjects);
				}
			}
			else
				log.info("Failed To Fetch Page Objects");
				
			//Closing all the DB instances.
			testDataResultSet.close();
			callableStatement.close();
			mySQLConnection.close();
			
			
			return PageObjectsMap;
		} catch (Exception e) {
			log.info(e.getMessage());
			return PageObjectsMap;
		}
	}
	
	/**
	 * Method to get the password for QA Environment
	 * @author Ambarish Khatua
	 * @since 09-07-2016
	 * @param String strFIRM - Firm Name(LPL/AXA), String strEnv - Environment name(QA-F1TX, QA-F2Tx etc), String strUserName
	 * @return String strPassword - Password for QA Environment
	 *//*
	public static String getPasswordForQA(String strFIRM, String strEnv, String strUserName){
		//LPLCoreConstents reference 
		LPLCoreConstents coreConstents = LPLCoreConstents.getInstance();
		
		//Environment Server IP Address
		String strEnvironmentServer = null;
		
		//Password fetched form QA Servers
		String strPassword = null;
		
		//As per the Firm and Environment combination, select Server IP Address fetched from LPLCoreConstents XML file 
		switch (strFIRM.toUpperCase().trim()){
			case "LPL":
				switch (strEnv.toUpperCase().trim()){
					case "QA-F1TX":
						strEnvironmentServer = coreConstents.LPL_QAF1TX;
						break;
					case "QA-F2TX":
						strEnvironmentServer = coreConstents.LPL_QAF2TX;
						break;
					case "QA-F3TX":
						strEnvironmentServer = coreConstents.LPL_QAF3TX;
						break;
					case "QA-F4TX":
						strEnvironmentServer = coreConstents.LPL_QAF4TX;
						break;
					case "DEV-F1TX":
						strEnvironmentServer = coreConstents.LPL_DevF1TX;
						break;
				}
				break;
			case "AXA":
				switch (strEnv.toUpperCase().trim()){
					case "QA-F1TX":
						strEnvironmentServer = coreConstents.AXA_QAF1TX;
						break;
					case "QA-F2TX":
						strEnvironmentServer = coreConstents.AXA_QAF2TX;
						break;
					case "QA-F3TX":
						strEnvironmentServer = coreConstents.AXA_QAF3TX;
						break;
					case "QA-F4TX":
						strEnvironmentServer = coreConstents.AXA_QAF4TX;
						break;
					case "DEV-F1TX":
						strEnvironmentServer = coreConstents.AXA_DevF1TX;
						break;
				}
				break;
			default:
				log.info("Firm:"+strFIRM+" & Environment:"+strEnv+" are not matched!!!");
		}
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			//Username to connect to QA Server 
            String strQAUtilUserName = coreConstents.strQAUtilUserName;
            
            //Password to connect to QA Server
            String strQAUtilPassword = coreConstents.strQAUtilPassword;
            
            //Connection String to be used to connect QA Server
            String strConnectionString = coreConstents.strQAPasswordConnectionString.replace("xxx", strEnvironmentServer);
            
            //Query to be executed to fetch the password
            String strQueryString = coreConstents.strQAPasswordQueryString.replace("xxx", strUserName);
            
            //Connect to the QA Server
            Connection con = DriverManager.getConnection(strConnectionString, strQAUtilUserName, strQAUtilPassword);
            
            log.info("Database connection has been established!!!");
            
            //Create Statement to fetch the execute the query
            Statement statement = con.createStatement();
            
            //Execute the Query to get the ResultSet
            ResultSet resultSet = statement.executeQuery(strQueryString);
            
            log.info("Query has been successfully executed!!!");
            
            //Fetch the Password from the ResultSet.
            resultSet.next();
        	strPassword = resultSet.getString(1);
        	
			//Return password 
			return strPassword;
		} catch (Exception e) {
			log.info("getPasswordForQA failed. Error Message:"+e.getMessage());
			return strPassword;
		}
	}*/
}

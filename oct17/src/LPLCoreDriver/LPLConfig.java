/*
 * Package is used of getting and setting global configuration : 
 *  
 */

package LPLCoreDriver;


import java.io.FileInputStream;
import java.util.Properties;

/**
 * <p>
 * <br>
 * <b> Title: </b> LPLConfig.java</br> <br>
 * <b> Description: </B> LPL Core Library - Config file reader</br> <br>
 * <b>Usage:</br></b> 
 * <br>1. Getter setter methods are available for all the variables listed under Constructor</br>
 * @author Aiswarya Srinivasan
 * @since 02-24-2017
 *        </p>
 */
public class LPLConfig {
	
 private String Application;   
 private String Firm;
 private String Environment;
 private String URL;
 private String VIP;
 private String ExecutionLocation;
 private String BrowserType;
 private String BrowserVersion;
 private String OS;
 private String Device;
 private String User;
 private String Pwd;
 private String DynatraceFlag;
 private int FirmId;
 private int ProductId;
 private int EnvironmentId;
 private int ScriptId;
 private int JobID;
 private int LabID;
 private int LabGroupID;
 
 protected String user_dir = System.getProperty("user.dir"); 
 protected Properties prop = new Properties(); 
 
 
public LPLConfig() {
		try {
			LPLCoreConstents lplCoreConstents = LPLCoreConstents.getInstance();			
			FileInputStream configFile = new FileInputStream(lplCoreConstents.CONFIG_FILE_PATH);  
			if (configFile !=null) 
			{
				prop.load(configFile);
				configFile.close();
			}
		} 
		catch(Exception e) {			 
			e.printStackTrace();
			System.out.println("Error Loading Configuration properites: File system Error "+e.getStackTrace());
			System.exit(1);
	     }
		
		Application 		= prop.getProperty("Application");
		Firm 				= prop.getProperty("Frim");
		Environment 		= prop.getProperty("Environment");
		URL 				= prop.getProperty("URL");
		VIP 				= prop.getProperty("VIP");
		ExecutionLocation 	= prop.getProperty("ExecutionLocation");
		BrowserType 		= prop.getProperty("BrowserType");
		BrowserVersion 		= prop.getProperty("BrowserVersion");
		OS 					= prop.getProperty("OS");
		Device 				= prop.getProperty("Device");
		DynatraceFlag 		= prop.getProperty("DYNATRACE");
		FirmId 				= Integer.parseInt(prop.getProperty("FIRMID"));
		ProductId 			= Integer.parseInt(prop.getProperty("PRODUCTID"));
		EnvironmentId 		= Integer.parseInt(prop.getProperty("ENVIRONMENTID"));
		ScriptId			= Integer.parseInt(prop.getProperty("SCRIPTID"));
		
		
		// Temp fix config 
		if (prop.getProperty("JOBID")== null)
			JobID = 0;
		else 
			JobID	= Integer.parseInt(prop.getProperty("JOBID"));
	
		if (prop.getProperty("LABID")== null)
			LabID = 0;
		else
			LabID				= Integer.parseInt(prop.getProperty("LABID"));
		
		if (prop.getProperty("LABGROUPID")== null)
			LabGroupID = 0;
		else
			LabGroupID			= Integer.parseInt(prop.getProperty("LABGROUPID"));
		
		// Temp Properties 
		setUser(prop.getProperty("User"));
		setPwd(prop.getProperty("Pwd"));
	}

/** ----------------------------------------------Setter and getter methods for all the Parameters-----------------------------------------------------**/
	public int getJobID() {
		return JobID;
	}

	public void setJobID(int jobID) {
		JobID = jobID;
	}
	
	public int getLabID() {
		return LabID;
	}
	
	public void setLabID(int labID) {
		LabID = labID;
	}
	
	public int getLabGroupID() {
		return LabGroupID;
	}
	
	public void setLabGroupID(int labGroupID) {
		LabGroupID = labGroupID;
	}

	public String getApplication() {
		return Application;
	}

	public void setsApplication(String sApplication) {
		this.Application = sApplication;
	}

	public String getFirm() {
		return Firm;
	}

	public void setFirm(String firm) {
		Firm = firm;
	}

	public String getEnvironment() {
		return Environment;
	}

	public void setEnvironment(String environment) {
		Environment = environment;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getExecutionLocation() {
		return ExecutionLocation;
	}

	public void setExecutionLocation(String executionLocation) {
		ExecutionLocation = executionLocation;
	}

	public String getVIP() {
		return VIP;
	}

	public void setVIP(String vIP) {
		VIP = vIP;
	}

	public String getBrowserVersion() {
		return BrowserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		BrowserVersion = browserVersion;
	}

	public String getBrowserType() {
		return BrowserType;
	}

	public void setBrowserType(String browserType) {
		BrowserType = browserType;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	public String getDevice() {
		return Device;
	}

	public void setDevice(String device) {
		Device = device;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPwd() {
		return Pwd;
	}

	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	
	public int getFirmId() {
		return FirmId;
	}
	
	public void setFirmId(int FirmId) {
		this.FirmId = FirmId;
	}
	
	public int getProductId() {
		return ProductId;
	}
	
	public void setProductId(int ProductId) {
		this.ProductId = ProductId;
	}
	
	public int getEnvId() {
		return EnvironmentId;
	}
	
	public void setEnvId(int EnvironmentId) {
		this.EnvironmentId = EnvironmentId;
	}
	
	public int getScriptId() {
		return ScriptId;
	}
	
	public void setScriptId(int ScriptId) {
		this.ScriptId = ScriptId;
	}
	
    public void setDynatraceFlag(String Flag) {
        DynatraceFlag = Flag;
	}
	
	public String getDynatraceFlag () {
	        return DynatraceFlag;
	}
}
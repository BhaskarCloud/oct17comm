package PageObjectLibrary;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;

import com.paulhammant.ngwebdriver.ByAngular;
 
/**
 * <p>
 * <br><b> Title: </b> LoginPage.java</br>
 * <br><b> Description: </B> Page Object Library For Login Page</br> 
 * <br><b>Usage:</br></b>
 * <br>1. login: Method to login into ClientWorks</br>
 * @author Rahul Agarwal
 * @since 05-25-2016
 * </p>
 */

public class LoginPage {
	/** WebDriver Reference */
	public WebDriver driver;
	
	public String strUser_CSS = "#username";
	
	public String strPass_CSS = "#password";
	
	public String strLogin_BT = "Log In";
	
	public String strLoginError_CSS = "#invalid_credentials_error";
	
	public String strLoginError_Text = "try again"; 
	
	public String strError; 
	
	/** Current Page ID from FARM */ 
	public final int INT_PAGEID = 53;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		/** Fetching page objects from FARM */
		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
		try{
		if(PageObjectsMap.get("strUser").get("CSS")!=null)
			strUser_CSS = PageObjectsMap.get("strUser").get("CSS");
		
		if(PageObjectsMap.get("strPassword").get("CSS")!=null)
			strPass_CSS = PageObjectsMap.get("strPassword").get("CSS");
		
		if(PageObjectsMap.get("strLoginButton").get("ANGULARREF")!=null)
			strLogin_BT = PageObjectsMap.get("strLoginButton").get("ANGULARREF");
		
		if(PageObjectsMap.get("strLoginError").get("CSS")!=null)
			strLoginError_CSS = PageObjectsMap.get("strLoginError").get("CSS");
		
		if(PageObjectsMap.get("strLoginError").get("ANGULARREF")!=null)
			strLoginError_Text = PageObjectsMap.get("strLoginError").get("ANGULARREF");
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			LPLCoreReporter.WriteReport("Initialization of Login page", "Object should be successfully created for Login page", "Failed to create the object of Login page. Error:"+ex.toString(), "Failed", "");
		}
	}
	
	/**
	 * Method to login into ClientWorks
	 * @author Rahul Agarwal
	 * @since 05-25-2016
	 * @param username - Username, password - Password
	 * @return boolean
	 */
	public boolean login(String username,String password){
		boolean blnResult = false;
		try{
		
			driver.findElement(ByAngular.cssContainingText(strUser_CSS,"")).sendKeys(username);
			driver.findElement(ByAngular.cssContainingText(strPass_CSS,"")).sendKeys(password);
		
			if (driver.findElement(ByAngular.buttonText(strLogin_BT)).isEnabled()){
				driver.findElement(ByAngular.buttonText(strLogin_BT)).click();
				try{
					if(driver.findElement(ByAngular.cssContainingText(strLoginError_CSS, strLoginError_Text)).isDisplayed())
						blnResult = false;
				}catch(Exception ex){
					blnResult = true;
				}
			}
			return blnResult;		
		}catch(Exception ex){
			strError = ex.getMessage();
			return false;
		}

	}
	
}

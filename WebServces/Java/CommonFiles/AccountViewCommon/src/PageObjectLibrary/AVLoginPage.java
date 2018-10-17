package PageObjectLibrary;

import java.util.HashMap;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreSync;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> LoginPage.java</br>
 * <br><b> Description: </B> Page Object Library For Login Page</br> 
 * <br><b>Usage:</B></br>
 * <br>1. login: Method to login into the application. </br>
 * @author Rahul Agarwal
 * @since 08-22-2016
 * </p>
 */
public class AVLoginPage {

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;
	
	/** CSS property value of Username */
	public String strUsername_CSS = "#UserNameModel_UserName"; 
	
	/** CSS property value of Password */
	public String strPassword_CSS = "#Password";
	
	/** Angular ButtonText property value of Login Button */				
	public String strLogin_ButtonText = "Log In";
	
	/** CSS property value of Invalid Login Message */
	public String strInvalidLogin_CSS = ".validation-summary-errors.validation-summary-errors-login";
	
	/** Angular text property value of InvalidLogin */
	public String strInvalidLogin_Text = "invalid";
	
	/** CSS property value of Empty Fields Invalid Login Message */
	public String strEntryFieldError_CSS = ".field-validation-error>span";
	
	/** Current Page ID from FARM */ 
	public final int INT_PAGEID = 136;
	
	public AVLoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		/** Fetching the page objects from FARM */
		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
		
		if(PageObjectsMap.get("strUsername").get("CSS")!=null)
			strUsername_CSS = PageObjectsMap.get("strUsername").get("CSS");
		
		if(PageObjectsMap.get("strPassword").get("CSS")!=null)
			strPassword_CSS = PageObjectsMap.get("strPassword").get("CSS");
		
		if(PageObjectsMap.get("strLogin").get("ANGULARREF")!=null)
			strLogin_ButtonText = PageObjectsMap.get("strLogin").get("ANGULARREF");
		
		if(PageObjectsMap.get("strInvalidLogin").get("CSS")!=null)
			strInvalidLogin_CSS = PageObjectsMap.get("strInvalidLogin").get("CSS");
		
		if(PageObjectsMap.get("strInvalidLogin").get("ANGULARREF")!=null)
			strInvalidLogin_Text = PageObjectsMap.get("strInvalidLogin").get("ANGULARREF");
		
		if(PageObjectsMap.get("strEntryFieldError").get("CSS")!=null)
			strEntryFieldError_CSS = PageObjectsMap.get("strEntryFieldError").get("CSS");
		
	}
	
	/**
	 * Method to login into the application
	 * @author Rahul Agarwal
	 * @since 08-23-2016
	 * @param username - String type, password - String type
	 * @return (boolean) true/false
	 */
	public boolean login(String username,String password){
		boolean blnResult = false;
		LPLCoreConstents lplCoreConstents = new LPLCoreConstents();
		try{
		driver.findElement(ByAngular.cssContainingText(strUsername_CSS, "")).sendKeys(username);
		driver.findElement(ByAngular.cssContainingText(strPassword_CSS, "")).sendKeys(password);
		if(driver.findElement(ByAngular.buttonText(strLogin_ButtonText)).isEnabled()){
			driver.findElement(ByAngular.buttonText(strLogin_ButtonText)).click();
			blnResult = true;
			try{
				LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
				if(driver.findElement(ByAngular.cssContainingText(strEntryFieldError_CSS, "")).isDisplayed())
					blnResult = false;
			}catch(NoSuchElementException ex){
				blnResult = true;
			}
			try{
				LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
				if(driver.findElement(ByAngular.cssContainingText(strInvalidLogin_CSS, strInvalidLogin_Text)).isDisplayed())
					blnResult = false;
			}catch(NoSuchElementException ex){
				blnResult = true;
			} 	
		}
		return blnResult;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
}

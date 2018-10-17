package pageobjectlibrary;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;
import PageObjectLibrary.HomePage;

/**
 * <p>
 * <br> <b> Title: </b> AXAPortal.java</br>
 * <br> <b> Description: </B> Page Object Library For AXA Portal Login Page and AXA Portal </br>
 * <br> <b>Usage: </b> </br>
 * <br> 1. loginAXAPortal: Method to login into AXA Portal web site </br>
 * <br> 2. navigateAXAPortaltoCW: Navigate to Clientworks from AXA Portal </br>
 * @author Aiswarya Srinivasan
 * @since 01-17-2018
 * </p>
 */
public class AXAPortal  extends LPLCoreDriver{

	/** Current Page ID from FARM */
	public static final int INTPAGEID = 480;
	
	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** Other Page objects **/
	//------------------------------------------------------------------------------------------------------------------------------------------------
	HomePage homePage;
	LPLCoreConstents lplCoreConstents;
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	/** Page object locators for this page **/

	/** Object declaration for variable strMainLoginButton_xpath**/
	public String strMainLoginButton_xpath = ".//div[@id='wrapper']/..//a[@id='header-desktop-login']";

	/** Object declaration for variable strLogin_ButtonText**/
	public String strLogin_ButtonText = "Log In";

	/** Object declaration for variable strUserName_id**/
	public String strUserName_id = "loginId";

	/** Object declaration for variable strPassword_id**/
	public String strPassword_id = "loginPassword";

	/** Object declaration for variable strLoginButton2_id**/
	public String strLoginButton2_id = "panel-desktop-login";

	/** Object declaration for variable strGoThereNowLink_xpath**/
	public String strGoThereNowLink_xpath = ".//a[@href='/axae/myportal/rad']";

	/** Object declaration for variable strClientworksLogo_xpath**/
	public String strClientworksLogo_xpath = "//span[@class='LPLClientWorks']//img[@src='/retail/images/icon-app-lpl-clientworks-sm.png']";

	/** --------------------------------------------------------------------------------------------------String constants ----------------------------------------------**/

	/** Constant WINDOW**/
	public static final String WINDOW = "Window";

	/** Constant CWHOMEPAGETITLE**/
	public static final String CWHOMEPAGETITLE = "Home - Client Management";
	
	//------------------------------------------------------------------------------------------------------------------------------------------------
	public AXAPortal(WebDriver driver) {
		try {
			this.driver = driver;
			
			/** Objects for CM home page, LPL Core Util file and LPL Core Config file */ 
			homePage = new HomePage(driver);
			
			lplCoreConstents = LPLCoreConstents.getInstance();

			/** Fetching page objects from FARM */
			HashMap<String, HashMap<String, String>> pageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INTPAGEID, new LPLConfig().getEnvId());
			
			if (pageObjectsMap.get("strMainLoginButton").get(LPLCoreConstents.XPATH) != null) {
				this.strMainLoginButton_xpath=pageObjectsMap.get("strMainLoginButton").get(LPLCoreConstents.XPATH);
			}
			if (pageObjectsMap.get("strLogin").get(LPLCoreConstents.ANGULARREF) != null) {
				this.strLogin_ButtonText=pageObjectsMap.get("strLogin").get(LPLCoreConstents.ANGULARREF);
			}
			if (pageObjectsMap.get("strUserName").get(LPLCoreConstents.ID) != null) {
				this.strUserName_id=pageObjectsMap.get("strUserName").get(LPLCoreConstents.ID);
			}
			if (pageObjectsMap.get("strPassword").get(LPLCoreConstents.ID) != null) {
				this.strPassword_id=pageObjectsMap.get("strPassword").get(LPLCoreConstents.ID);
			}
			if (pageObjectsMap.get("strLoginButton2").get(LPLCoreConstents.ID) != null) {
				this.strLoginButton2_id=pageObjectsMap.get("strLoginButton2").get(LPLCoreConstents.ID);
			}
			if (pageObjectsMap.get("strGoThereNowLink").get(LPLCoreConstents.XPATH) != null) {
				this.strGoThereNowLink_xpath=pageObjectsMap.get("strGoThereNowLink").get(LPLCoreConstents.XPATH);
			}
			if (pageObjectsMap.get("strClientworksLogo").get(LPLCoreConstents.XPATH) != null) {
				this.strClientworksLogo_xpath=pageObjectsMap.get("strClientworksLogo").get(LPLCoreConstents.XPATH);
			}

		}catch (Exception ex) {
			strError = strError + ex.getLocalizedMessage();
			LPLCoreReporter
			.WriteReport(
					"Initialization of AXAPortal Class",
					"Objects should be successfully fetched from FARM for AXAPortal class",
					"Failed to fetch the objects of AXAPortal class from Farm. Error:"
							+ strError, LPLCoreConstents.FAILED, "");
		}

	}	

	/**
	 * Method to login into AXA Portal
	 * @author Aiswarya Srinivasan
	 * @since 01-17-2018
	 * @param strusername - Username
	 * @param strpassword - Password
	 * @return boolean
	 */
	public boolean loginAXAPortal(String strusername, String strpassword)
	{
		try{
			//Click on Login button after the AXA Portal URL is launched
			LPLCoreUtil.clickOnElement(lplCoreConstents.BASE,By.xpath(strMainLoginButton_xpath));
			
			//Type User name 
			WebElement objusername = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.id(strUserName_id));
			objusername.sendKeys(strusername);
			
			//Type Password
			WebElement objpassword = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.id(strPassword_id));
			objpassword.sendKeys(strpassword);
	
			//Click on Login button
			LPLCoreUtil.clickOnElement(lplCoreConstents.BASE,By.id(strLoginButton2_id));
			
			return true;		
		}catch(Exception ex){
			strError = ex.getLocalizedMessage();
			return false;
		}
	}
	
	/**
	 * Method to navigate from AXA Portal to CW
	 * @author Aiswarya Srinivasan
	 * @since 01-17-2018
	 * @param None
	 * @return boolean
	 */
	public boolean navigateAXAPortaltoCW(){
		try {
			//Click on Go there Now
			WebElement objGothereNow = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.xpath(strGoThereNowLink_xpath));
			LPLCoreUtil.mouseHoverAndClickJScript(objGothereNow);
			
			//Wait for the page to be loaded properly
			homePage.waitForPageLoading(homePage.lplCoreConstents.HIGH);
			
			//Navigate to Clientworks Logo
			WebElement objClientWorksLogo = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.xpath(strClientworksLogo_xpath));
			LPLCoreUtil.mouseHoverAndClickJScript(objClientWorksLogo);
				
			//Wait for the page to be loaded properly
			homePage.waitForPageLoading(homePage.lplCoreConstents.HIGH);
			
			//static wait for the New Window  to Load in Clientworks 
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
						
			//switch to new  window
			homePage = new HomePage(driver);
			return homePage.switchTo(WINDOW,CWHOMEPAGETITLE);
		}catch(Exception ex){
			strError = ex.getLocalizedMessage();
			return false;
		}
	}
	
}
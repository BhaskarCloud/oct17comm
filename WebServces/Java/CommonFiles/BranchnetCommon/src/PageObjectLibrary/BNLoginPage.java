package PageObjectLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngular;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;

/**
 * <p>
 * <br>
 * <b> Title: </b> BNLoginPage.java</br> <br>
 * <b> Description: </B> Page Object Library For BranchNet Login Page</br> <br>
 * <b>Usage:</br></b> <br>
 * 1. login: Method to login into BranchNet</br>
 * 
 * @author Aiswarya Srinivasan
 * @since 08-17-2016
 *        </p>
 */
class BNLoginPageOverride extends LPLCoreDriver{
	/** WebDriver Reference */
	public WebDriver driver;

	public String strUser_ID 					= "textUsername";

	public String strPass_ID 					= "textPassword";

	public String strLogin_ID 					= "submitButton";
	
	public String strSecurityQuestionsPage_ID 	= "ctl00_ContentPlaceHolder1_updatePanel";
	
	//Added for handling Password Expiry pop up
	public String strBNPopupFrame_name			= "dialogsPopupModalIFrame";
	
	public String strIgnoreButton_id			= "ignoreButton";
	
	public String strError;
	
	String strErrorMessageLabel = ". Error message: ";
	
	LPLCoreConstents lplCoreConstents;
	
	LoginPage loginPage;
	
	boolean blnLogin=false;
	
	boolean blnHome=false;
	
	boolean blnResult=false;
	
	boolean blnSwitchToWindow=false;
	
	public  static final String STRBRANCHNETTITLE ="BranchNet Welcome";
	
	public static final String STRWINDOW="Window";
	
	public static final String STRBNNAV="BranchNet";
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 117;
	
	public BNLoginPageOverride(WebDriver driver) {
		try{
		this.driver = driver;
		loginPage=new LoginPage(driver);
		lplCoreConstents = LPLCoreConstents.getInstance();

		/** Fetching page objects from FARM */
		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
				.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

		if (PageObjectsMap.get("strUser").get("ID") != null)
			strUser_ID = PageObjectsMap.get("strUser").get("ID");

		if (PageObjectsMap.get("strPassword").get("ID") != null)
			strPass_ID = PageObjectsMap.get("strPassword").get("ID");

		if (PageObjectsMap.get("strLoginButton").get("ID") != null)
			strLogin_ID = PageObjectsMap.get("strLoginButton").get("ID");
		
		if (PageObjectsMap.get("strSecurityQuestionsPage").get("ID") != null)
			strSecurityQuestionsPage_ID = PageObjectsMap.get("strSecurityQuestionsPage").get("ID");
		
		if (PageObjectsMap.get("strBNPopupFrame").get("ID") != null)
			strBNPopupFrame_name = PageObjectsMap.get("strBNPopupFrame").get("ID");
		
		if (PageObjectsMap.get("strIgnoreButton").get("ID") != null)
			strIgnoreButton_id = PageObjectsMap.get("strIgnoreButton").get("ID");
		}
		catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of Login Page  Class", "Object should be successfully created of AccountBrowse_AccountsPage class", "Failed to fetch the objects of BNLogin from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}

	/**
	 * Method to login into BranchNet
	 * 
	 * @author Varun Khurana
	 * @since 08-03-2016
	 * @param username
	 *            - Username, password - Password
	 * @return boolean
	 */
	public boolean login(String username, String password) {
		try {
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			driver.findElement(By.id(strUser_ID)).sendKeys(username);
			driver.findElement(By.id(strPass_ID)).sendKeys(password);

			if (driver.findElement(By.id(strLogin_ID)).isEnabled()) {
				driver.findElement(By.id(strLogin_ID)).click();
				
				//Wait for page to load
				LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
				try {
					// Try to switch to Pop up frame
					WebElement objPopUpFrame = driver.findElement(By.name(strBNPopupFrame_name));
					driver.switchTo().frame(objPopUpFrame);
					
					//If Pop up frame exists, then click on Ignore
					driver.findElement(By.id(strIgnoreButton_id)).click();
					LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
					driver.switchTo().defaultContent();
				} catch (Exception e) {
					
				}
				try {
					LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
					
					//If the Security questions Panel exists in the screen
					driver.findElement(By.id(strSecurityQuestionsPage_ID));
					
					/** Launch the Application URL again*/
					driver.get(ocfg.getURL());
					
					//Press enter on the Windows pop up asking to leave the page or not
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					
					LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
					return true;
				} catch (Exception e) {
					return true;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
			strError = ex.getMessage();
			return false;
		}

	}
	
}


public class BNLoginPage extends BNLoginPageOverride{
	
	/** WebDriver Reference */
	public WebDriver driver;
	public BNLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


	/**
	 * Method to login into BranchNet or Clientworks (depends on Login Page)
	 * 
	 * @author Jyothi Jyothi
	 * @since 01-30-2018
	 * @param username
	 *            - Username, password - Password
	 * @return boolean
	 */
	public boolean login(String username, String password) {
		try{
			//if URL directing to Clientworks page
			if(driver.findElement(ByAngular.cssContainingText(loginPage.strUser_CSS,"")).isDisplayed()){
				try {
					//login to Clientworks
					blnLogin=loginPage.login(username, password);
					
					//Navigate to BranchNet
					HomePage homePage = new HomePage(driver);
					blnHome =  homePage.navigateToCWMenu(STRBNNAV, "");
					
					//Switrch to Branchnet Window
					blnSwitchToWindow=homePage.switchTo(STRWINDOW,STRBRANCHNETTITLE);
					if(ocfg.getBrowserType().equalsIgnoreCase("IE") ||ocfg.getBrowserType().equalsIgnoreCase("INTERNETEXPLORER") || ocfg.getBrowserType().equalsIgnoreCase("IEXPLORE")){
						driver.manage().window().maximize();
					}
					LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
	
					//get the Page Title
					String strWindowName=driver.getTitle();
					
					if(blnLogin && blnHome && blnSwitchToWindow && strWindowName.equalsIgnoreCase(STRBRANCHNETTITLE)){	
						blnResult=true;
						//Wait for page to load
						LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
						try {
							// Try to switch to Pop up frame
							WebElement objPopUpFrame = driver.findElement(By.name(strBNPopupFrame_name));
							driver.switchTo().frame(objPopUpFrame);
							
							//If Pop up frame exists, then click on Ignore
							driver.findElement(By.id(strIgnoreButton_id)).click();
							LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
							driver.switchTo().defaultContent();
						} catch (Exception e) {
							
						}
						try {
							LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
							
							//If the Security questions Panel exists in the screen
							driver.findElement(By.id(strSecurityQuestionsPage_ID));
							
							/** Launch the Application URL again*/
							driver.get(ocfg.getURL());
							
							//Press enter on the Windows pop up asking to leave the page or not
							Robot robot = new Robot();
							robot.keyPress(KeyEvent.VK_ENTER);
							robot.keyRelease(KeyEvent.VK_ENTER);
							
							LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
							blnResult = true;
						} catch (Exception e) {
							blnResult = true;
						}
				
					}		

				} catch (Exception ex) {
					strError = ex.getMessage();
					blnResult = false;	
				}
				blnResult=true;
			}
			} catch (Exception ex) {
				//If URL is directing to Branchnet Page
				super.login(username, password);
				if(driver.getTitle().equalsIgnoreCase(STRBRANCHNETTITLE)){
					blnResult=true;
				}
				else{
					blnResult=false;
				}
			}
		return blnResult;
		}



	
	/**
	 * Method to Logout of BranchNet and close the browser
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 08-19-2016
	 * @Modified By Jyothi Jyothi
	 * @since 02-19-2018
	 * @param N/A
	 * @return boolean true if logout successful
	 */
	public boolean logoutBNAndCloseBrowser() {
		boolean blnResult=false;
		try{
			BNCommon bnCommon = new BNCommon(driver);
			BNHomePage bnHome = new BNHomePage(driver);
			bnCommon.waitForPageLoading(lplCoreConstents.MEDIUM);
			//get the window handles
			Set<String> winHandles = driver.getWindowHandles();
			for(String strWachWindow:winHandles){
				//switch to window
				driver.switchTo().window(strWachWindow);
				
				//If the title is BN perform BN logout
				if((driver.getTitle().equalsIgnoreCase(STRBRANCHNETTITLE))){
					if (bnHome.quickLinksNavigation("Logout")){
						LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						driver.close();
						blnResult=true;
					}else{
						blnResult=false;
					}
				}
				//Close the other existing window
				else{
					driver.close();
					blnResult=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			strError = strError + e.getMessage();
			blnResult=false;
		}
		return blnResult;	
	}
	
	/**
	 * Method to Logout of BranchNet and close the browser
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 08-19-2016
	 * @param N/A
	 * @Modified By Jyothi Jyothi
	 * @since 02-19-2018
	 * @return boolean true if logout successful
	 */
	public boolean logoutBN() {
		try{
			BNCommon bnCommon = new BNCommon(driver);
			BNHomePage bnHome = new BNHomePage(driver);
			Set<String> winHandles = driver.getWindowHandles();
			bnCommon.waitForPageLoading(lplCoreConstents.MEDIUM);
			//get the window handles
			for(String strWachWindow:winHandles){
				//switch to window
				driver.switchTo().window(strWachWindow);
				
				//If the title is BN perform BN logout
				if((driver.getTitle().equalsIgnoreCase(STRBRANCHNETTITLE))){
					if (bnHome.quickLinksNavigation("Logout")){
						LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
						driver.close();
						blnResult=true;
					}else{
						blnResult=false;
					}
				}
				//Close the other existing window
				else{
					driver.close();
					blnResult=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			strError = strError + e.getMessage();
			return false;
		}
		return blnResult;
	}
}

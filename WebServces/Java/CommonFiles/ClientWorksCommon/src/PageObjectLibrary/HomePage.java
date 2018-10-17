package PageObjectLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;

import com.google.common.base.Function;
import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> HomePage.java </br>
 * <br><b> Description: </B> Page Object Library For Home Page </br> 
 * <br><b>Usage:</br></b>
 * <br>1. navigateToCWMenu: Method to navigate to different applications in Client Works </br>
 * <br>2. logout: Method to logout of Client Works </br>
 * <br>3. getClientWorksMenu: Method to get the ClientWorks Menu </br>
 * <br>4. cancelCertPopUp: Method to cancel out the Certificate selection pop up </br>
 * <br>5. switchTo: This function is used to switch to different window / iFrame </br>
 * <br>6. verifyNewTab: This function is used to verify if the page has opened in new window </br>
 * <br>7. waitForPageLoading: Method to wait / Temporary </br>
 * <br>8. logOutWithOutClosingBrowser: Method to Logout of ClientWorks without closing the browser </br>
 * <br>9. closeBrowser: Method to Close Browser </br>
 * <br>10. openNewTab: Method to Open New Tab in Browser </br>
 * <br>11. performCWSupportView: This function is used to Support view in CLientWorks</br>
 * @author Rahul Agarwal
 * @since 05-26-2016
 * </p>
 */
public class HomePage extends LPLCoreDriver{

	/** WebDriver Reference */
	public WebDriver driver;
	
	public String strError;
	
	public String strApplauncher_CSS = "i.lplf.lplf-cw-applauncher";
	
	public String strLogout_CSS = ".cwNavbar-action>small>.lplf.lplf-cw-logout";
	
	public String strSubLink_CSS = ".ng-binding";
	
	public String strLoginBackButton_CSS = "#btnLogBackIn";
	
	//Added on 17 Apr 2017 for Support View method
	
	public String strSVLoginName_xpath="";
	
	public String strSVMasterRepID_xpath="";
	
	public String strSVOKButton_Xpath="";
	
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */ 
	public final int INT_PAGEID = 14;

	public HomePage(WebDriver driver){
		try{
			this.driver = driver;
			lplCoreConstents = LPLCoreConstents.getInstance();
			
			/** Fetching the PageObjects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
			
			if(PageObjectsMap.get("AppLauncher").get("CSS")!=null)
				strApplauncher_CSS = PageObjectsMap.get("AppLauncher").get("CSS");
			
			if(PageObjectsMap.get("strLogOut").get("CSS")!=null)
				strLogout_CSS = PageObjectsMap.get("strLogOut").get("CSS");
			
			if(PageObjectsMap.get("strSubLink").get("CSS")!=null)
				strSubLink_CSS = PageObjectsMap.get("strSubLink").get("CSS");
			
			if(PageObjectsMap.get("strLoginBackButton").get("CSS")!=null)
				strLoginBackButton_CSS = PageObjectsMap.get("strLoginBackButton").get("CSS");
			
			if(PageObjectsMap.get("strSVLoginName").get("XPATH") != null)
				strSVLoginName_xpath=PageObjectsMap.get("strSVLoginName").get("XPATH");
			
			if(PageObjectsMap.get("strSVMasterRepID").get("XPATH") != null)
				strSVMasterRepID_xpath=PageObjectsMap.get("strSVMasterRepID").get("XPATH");
			
			if(PageObjectsMap.get("strSVOKButton").get("XPATH") != null)
				strSVOKButton_Xpath=PageObjectsMap.get("strSVOKButton").get("XPATH");
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of Clientworks home page Class \"HomePage\"", "Object should be successfully created of Clientworks home page Class \"HomePage\"", "Failed to create the object of Clientworks home page Class \"HomePage\". Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	/**
	 * Method to navigate to various links
	 * @author Rahul Agarwal/Sunitha
	 * @since 05-26-2016
	 * @param strMainLink - Main Menu, strSubLink - Sub Menu
	 * @return (boolean) true/false
	 */
	public boolean navigateToCWMenu(String strMainLink,String... strSubLinks){
		boolean blnSubMenuFound = false;
		try{
			//To close what's new in clientworks popup
			waitForPageLoading(lplCoreConstents.MEDIUM);
			driver.navigate().refresh();
			
			//Wait for the Objects to get loaded...
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			LPLCoreUtil.waitForWebElement(lplCoreConstents.MEDIUM,ByAngular.cssContainingText(strApplauncher_CSS, ""));
			
			//Click on App launcher
			driver.findElement(ByAngular.cssContainingText(strApplauncher_CSS, "")).click();
			LPLCoreSync.staticWait(lplCoreConstents.UNITINMILLISEC);
			
			//Click on main link & cancel the ceritificate popup if displayed
			driver.findElement(By.linkText(strMainLink)).click();
			cancelCertPopUp();
			
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			
			// If the Sub menu items in the parameters is not empty, then
			// proceed to click further sub menu items
			if (strSubLinks.length!= 0) {
				for (String thisSubLink : strSubLinks) {
					try {
						if ((!thisSubLink.equals(null)) && (!thisSubLink.isEmpty()) && (!thisSubLink.equals(""))) {
							try {
								WebElement objSublink = driver.findElement(By
										.linkText(thisSubLink));
								JavascriptExecutor js = (JavascriptExecutor) driver;
								js.executeScript("arguments[0].click();",
										objSublink);
								LPLCoreSync
										.staticWait(lplCoreConstents.UNITINMILLISEC);
								cancelCertPopUp();
								blnSubMenuFound = true;
							} catch (Exception e) {
								e.printStackTrace();
								strError = strError
										+ " Sub menu not clicked. Error message: "
										+ e.getMessage();
								blnSubMenuFound = false;
								break;
							}
						}else{
							blnSubMenuFound = true;
							break;
						}
					} catch (NullPointerException e) {
						blnSubMenuFound = true;
						break;
					}
				}
				if (!blnSubMenuFound) {
					strError = strError + " Sub menu not found for user "
							+ loginCredentials.get("Username");
					return false;
				} else {
					return true;
				}
			}else{
				return true;
			}
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to get the ClientWorks Menu
	 * @author Ambarish Khatua
	 * @since 05-31-2016
	 * @param strMainLink - Main Menu, strSubLink - Sub Menu
	 * @return boolean True - if the menu is available and False if the menu is not available
	 */
	public boolean getClientWorksMenu(String strMainLink, String strSubLink){
		boolean blnReturn = false;
		
		try{
			//Wait for the Objects to get loaded...
			LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strApplauncher_CSS, ""), lplCoreConstents.BASE);
			
			//Click on 'Application Launcher' icon.
			driver.findElement(ByAngular.cssContainingText(strApplauncher_CSS, "")).click();
			
			//Verify if the ClientWorks menu is available 
			if(strSubLink.isEmpty()){
				if (driver.findElement(By.linkText(strMainLink)).isDisplayed())
					blnReturn = true;
			}else{
				driver.findElement(By.linkText(strMainLink)).click();
				if (driver.findElement(By.linkText(strSubLink)).isDisplayed())
					blnReturn = true;
			}
			return blnReturn;			
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to Logout of ClientWorks
	 * @author Rahul Agarwal
	 * @since 05-26-2016
	 * @param N/A
	 * @return boolean True - if logout is successful and False - if logout failed  
	 */
	public boolean logOut(){
		try{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			Set<String> winHandles = driver.getWindowHandles();
			waitForPageLoading(lplCoreConstents.MEDIUM);
			if (winHandles.size() > 1){
				String defaultHandler = winHandles.iterator().next();
				driver.close();
				driver.switchTo().window(defaultHandler);
			}else{
				driver.switchTo().defaultContent();
			}
			
			if(!driver.findElement(ByAngular.cssContainingText(strLogout_CSS, "")).isDisplayed()){
				js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(ByAngular.cssContainingText(strApplauncher_CSS, "")));
				driver.findElement(ByAngular.cssContainingText(strApplauncher_CSS, "")).click();
			}	
			
			js.executeScript("arguments[0].click();", driver.findElement(ByAngular.cssContainingText(strLogout_CSS, "")));
			
			cancelCertPopUp();
			js = null;
			return true;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to cancel out the Certificate selection pop up
	 * @author Aiswarya Srinivasan
	 * @since 06-17-2016
	 * @param N/A
	 * @return (boolean) True/False
	 */
	public boolean cancelCertPopUp(){
		try {
			if(!ocfg.getBrowserType().equalsIgnoreCase("firefox")){
				Thread.sleep(lplCoreConstents.LOWESTInMiliSec);
				Robot rb =new Robot();
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				rb = null;
				Thread.sleep(lplCoreConstents.BaseInMiliSec);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	* This function is used to switch to different window / iFrame
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   05-30-2016
	* @param   String WindowOrFrame - Switch To Window / Frame, String handler - Window name/FarmeID
	* @return  boolean True if it switched to Window/Frame successfully
	*/
	public boolean switchTo(String WindowOrFrame, String handler){
		boolean blnReturn = false;
		
		try{
			switch(WindowOrFrame.toUpperCase()){
				case "WINDOW":
					Set<String> winHandles = driver.getWindowHandles();
					for(String handle : winHandles){						
						if (!driver.getTitle().equalsIgnoreCase(handler)){
							driver.switchTo().window(handle);
							if (driver.getTitle().contains(handler)){
								blnReturn = true;
								break;
							}
						}else{
							blnReturn = true;
							break;
						}
					}
					break;
				case "FRAME":
					LPLCoreSync.waitForFrameToBeAvailableAndSwitchToIt(driver,handler,lplCoreConstents.BASE);
					blnReturn = true;
					break;
			}
			return blnReturn;
		} 
		catch(Exception e){
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	* This function is used to verify if the page has opened in new window
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   05-31-2016
	* @param   String strPageTitle - Page Title
	* @return  boolean True/False
	*/
	public boolean verifyNewTab(String strPageTitle){
		boolean blnReturn = false;
		
		try{
			Set<String> winHandles = driver.getWindowHandles();
			if (winHandles.size() > 1){
				for(String handle : winHandles){						
					if (!driver.getTitle().equalsIgnoreCase(strPageTitle)){
						driver.switchTo().window(handle);
						if (driver.getTitle().contains(strPageTitle)){
							blnReturn = true;
							break;
						}
					}
				}
			}
			return blnReturn;
		}catch(Exception e){
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * Method to wait / Temporary
	 * @author Aiswarya Srinivasan
	 * @since 06-01-2016
	 * @param intTime - time to wait
	 * @return (boolean)true/false
	 */
	public boolean waitForPageLoading(Integer intMaxTime){
		try{
			Thread.sleep(intMaxTime*100);
			 new WebDriverWait(driver, intMaxTime).until(new Function<WebDriver, Boolean>() {
				        @Override
				        public Boolean apply(WebDriver driver) {
				        	System.out.println("Current Window State       : "
					                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
					            return String
					                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
					                .equals("complete");
				        }
				    });
			return true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to Logout of ClientWorks without closing the browser
	 * @author Harish Babu
	 * @since 06-06-2016
	 * @param N/A
	 * @return (boolean) True/False
	 */
	public boolean logOutWithOutClosingBrowser(){
		try{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strApplauncher_CSS, ""),  lplCoreConstents.BASE);
			driver.findElement(ByAngular.cssContainingText(strApplauncher_CSS, "")).click();
			js.executeScript("arguments[0].click();", driver.findElement(ByAngular.cssContainingText(strLogout_CSS, "")));
			cancelCertPopUp();
			return true;
		
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to Close Browser
	 * @author Harish Babu
	 * @since 06-06-2016
	 * @param N/A
	 * @return (boolean) True/False
	 */
	public boolean closeBrowser() {
		try{
			driver.quit();
			cancelCertPopUp();
			return true;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to Open New Tab in Browser
	 * @author Harish Babu
	 * @since 06-06-2016
	 * @param N/A
	 * @return (boolean) True/False
	 * 
	 */
	public boolean openNewTab() {
		try{
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
			return true;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
		}
	}
	
	/**
	 * This function is used to Support view in CLientWorks
	 * @author Aiswarya
	 * @version 1.0
	 * @since 04-17-2017
	 * @param String strSupportViewOption - Support view option (Name/Rep ID),String strSupportViewData - Support view data (User to support view to)
	 * @return boolean true/false
	 *  */ 
	
	public boolean performCWSupportView(String strSupportViewOption, String strSupportViewData) {
		WebElement objSupportViewDataEditBox = null;
		try {
			//Wait for the Objects to get loaded...
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strApplauncher_CSS, ""), lplCoreConstents.MEDIUM);
			
			//click on App launcher Icon
			driver.findElement(ByAngular.cssContainingText(strApplauncher_CSS, "")).click();
			
			//click on Support view menu
			driver.findElement(By.linkText("Support View")).click();
			
			//Cancel certificate popup if displayed
			cancelCertPopUp();
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			
			//Switch to Frames to access the objects for Support View Operation.
			switchTo("WINDOW","Support View");
			if(!ocfg.getBrowserType().toUpperCase().contains("CHROME") && !ocfg.getBrowserType().toUpperCase().contains("FIREFOX")){
				driver.manage().window().maximize();
			}
			//Based on SupportView Options, select the element
			switch(strSupportViewOption.toUpperCase().trim()){
				case "NAME":
					objSupportViewDataEditBox = driver.findElement(By.xpath(strSVLoginName_xpath));
					break;
				case "REPID":
					objSupportViewDataEditBox = driver.findElement(By.xpath(strSVMasterRepID_xpath));
					break;
			}
			
			//Enter value in the SupportView element
			objSupportViewDataEditBox.sendKeys(strSupportViewData);
	
			driver.findElement(By.xpath(strSVOKButton_Xpath)).click();
			
			return true;
		} catch (Exception e) {
			strError = e.toString();
			return false;
		}
		
	}	
}

package PageObjectLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.WebToolKit.Keyboard;

import com.google.common.base.Function;

/**
 * <p>
 * <br>
 * <b> Title: </b> BNCommon.java</br> <br>
 * <b> Description: </B> Page Object Library For BranchNet - Common</br> <br>
 * <b>Usage:</br></b> 
 * <br>1. cancelCertPopUp: Method to cancel out the Certificate selection pop up</br>
 * <br>2. switchTo: This function is used to switch to different window / iFrame</br>
 * <br>3. switchToFrame: This function is used to switch to any iframe using By variable</br>
 * <br>4. switchToFrame: This function is used to switch to any iframe using String handler</br>
 * <br>5. verifyNewTab: This function is used to verify if the page has opened in new window</br>
 * <br>6. waitForPageLoading: Method to wait till document ready state to be complete</br>
 * <br>7. closeBrowser: Method to Close Browser</br>
 * <br>8. openNewTab: Method to Open New Tab in Browser</br>
 * <br>9. verifyPageObjects: Method to Verify All Objects in a page using an object array</br>
 * <br>10. verifyPageObject: Method to Verify a single Object in a page</br>
 * <br>11. enterRepIDControlLPL: Method to Enter Rep id in the LPL Firm where Rep ID is identified as one single HTML tag</br>
 * <br>12. enterRepIDControlAXA: Method to Enter Rep id in the AXA Firm where Rep ID is identified as one single HTML tag</br>
 * @author Aiswarya Srinivasan
 * @since 08-17-2016
 *        </p>
 */

public class BNCommon extends LPLCoreDriver {
	/** WebDriver Reference */
	public WebDriver driver;
	
	public LPLCoreConstents lplCoreConstents;
	
	/** ID Property value of the LogIn Name EditBox */
	String strLoginName_ID = "ctl00_ContentPlaceHolder1_txtLoginName";
	
	/** ID Property value of the Master RepID EditBox */
	String strMasterRepID_ID = "ctl00_ContentPlaceHolder1_txtMasterRepID";
	
	/** ID Property value of the OK Button */
	String strOKButton_ID =	"ctl00_ContentPlaceHolder1_btnOK";
	
	/** Name Property value of the Parent Frame */
	public String strParentFrame 	= "shell";
	
	/** Xpath Property value of the IFrame */
	public String strIframe_XPATH	= "//iframe[@id='panel_welcome']//following-sibling::iframe"; 
	
	public final String SUPPORTVIEWNAVMENULEVEL1 = "Utilities";
	public final String SUPPORTVIEWNAVMENULEVEL2 = "LPL Employee Utilities";
	public final String SUPPORTVIEWNAVMENULEVEL3 = "Support View";
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 252;

	public String strError;
	
	public String strObjectsNotFound;
	
	public BNCommon(WebDriver driver) {
		this.driver = driver;
		
		lplCoreConstents = LPLCoreConstents.getInstance();
		
		try {
			//Fetch page object identification properties from FARM
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
			
			if(PageObjectsMap.get("strLoginName").get("ID")!=null)
				strLoginName_ID = PageObjectsMap.get("strLoginName").get("ID");
			
			if(PageObjectsMap.get("strMasterRepID").get("ID")!=null)
				strMasterRepID_ID = PageObjectsMap.get("strMasterRepID").get("ID");
			
			if(PageObjectsMap.get("strOKButton").get("ID")!=null)
				strOKButton_ID = PageObjectsMap.get("strOKButton").get("ID");
			
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of BNCommon Class", "Object should be successfully created of BNCommon class", "Failed to fetch the objects of BNCommon from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}

	/**
	 * Method to cancel out the Certificate selection pop up
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 06-17-2016
	 * @param N
	 *            /A
	 * @return (boolean) True/False
	 */
	public boolean cancelCertPopUp() {
		try {
			if (!ocfg.getBrowserType().equalsIgnoreCase("firefox")) {
				Thread.sleep(lplCoreConstents.LOWESTInMiliSec);
				Robot rb = new Robot();
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
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 05-30-2016
	 * @param String
	 *            WindowOrFrame - Switch To Window / Frame, String handler -
	 *            Window name/FarmeID
	 * @return boolean True if it switched to Window/Frame successfully
	 */
	public boolean switchTo(String WindowOrFrame, String handler) {
		boolean blnReturn = false;

		try {
			switch (WindowOrFrame.toUpperCase()) {
			case "WINDOW":
				Set<String> winHandles = driver.getWindowHandles();
				for (String handle : winHandles) {
					if (!driver.getTitle().equalsIgnoreCase(handler)) {
						driver.switchTo().window(handle);
						if (driver.getTitle().equalsIgnoreCase(handler)) {
							blnReturn = true;
							break;
						}
					}
				}
				break;
			case "FRAME":
				LPLCoreSync.waitForFrameToBeAvailableAndSwitchToIt(driver, handler,lplCoreConstents.HIGH);
				blnReturn = true;
				break;
			}
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to switch to any iframe using By variable
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 08-19-2016
	 * @param ByVar - By variable through which the frame is identified
	 * @return boolean True if it switched to Frame successfully
	 */
	public boolean switchToFrame(By ByVar) {
		boolean blnReturn = false;
		try {	
			LPLCoreSync.waitForFrameToBeAvailableAndSwitchToIt(driver, ByVar,lplCoreConstents.HIGH);
			blnReturn = true;
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to switch to any iframe using String handler
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 08-19-2016
	 * @param handler - frame name to switch
	 * @return boolean True if it switched to Frame successfully
	 */
	public boolean switchToFrame(String handler) {
		boolean blnReturn = false;
		try {
			LPLCoreSync.waitForFrameToBeAvailableAndSwitchToIt(driver, handler,lplCoreConstents.HIGH);
			blnReturn = true;
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to verify if the page has opened in new window
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 05-31-2016
	 * @param String
	 *            strPageTitle - Page Title
	 * @return boolean True/False
	 */
	public boolean verifyNewTab(String strPageTitle) {
		boolean blnReturn = false;

		try {
			Set<String> winHandles = driver.getWindowHandles();
			if (winHandles.size() > 1) {
				for (String handle : winHandles) {
					if (!driver.getTitle().equalsIgnoreCase(strPageTitle)) {
						driver.switchTo().window(handle);
						if (driver.getTitle().contains(strPageTitle)) {
							blnReturn = true;
							break;
						}
					}
				}
			}
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}

	/**
	 * Method to wait till document ready state to be complete
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 06-01-2016
	 * @param intTime
	 *            - time to wait
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
	 * Method to Close Browser
	 * 
	 * @author Harish Babu
	 * @since 06-06-2016
	 * @param N
	 *            /A
	 * @return (boolean) True/False
	 */
	public boolean closeBrowser() {
		try {
			driver.quit();
			cancelCertPopUp();
			return true;
		} catch (Exception ex) {
			strError = strError + ex.getMessage();
			return false;
		}
	}

	/**
	 * Method to Open New Tab in Browser
	 * 
	 * @author Harish Babu
	 * @since 06-06-2016
	 * @param N
	 *            /A
	 * @return (boolean) True/False
	 * 
	 */
	public boolean openNewTab() {
		try {
			driver.findElement(By.cssSelector("body")).sendKeys(
					Keys.CONTROL + "t");
			return true;
		} catch (Exception ex) {
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to Verify All Objects in a page using an object array
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 08-19-2016
	 * @param arrPageObjects - page Objects to be verified.
	 * @return (boolean) True/False
	 * 
	 */
	public boolean verifyPageObjects(String[][] arrPageObjects) {
		By ByVar = null;
		boolean blnVerified = true;
		for (String[] arrEachObject:arrPageObjects) {
			List<String> objList = Arrays.asList(arrEachObject);
				switch (objList.get(2).toUpperCase()) {
				case "TAGNAME":
					ByVar = By.tagName(objList.get(0));
					break;
				case "XPATH":
					ByVar = By.xpath(objList.get(0));
					break;
				case "NAME":
					ByVar = By.name(objList.get(0));
					break;
				case "ID":
					ByVar = By.id(objList.get(0));
					break;
				case "LINKTEXT":
					ByVar = By.linkText(objList.get(0));
					break;
				case "CSS":
					ByVar = By.cssSelector(objList.get(0));
					break;
				case "CLASS":
					ByVar = By.className(objList.get(0));
					break;
				case "PARTIALLINKTEXT":
					ByVar = By.partialLinkText(objList.get(0));
					break;
				default:
					break;
				}
				try {
					driver.findElement(ByVar);
					blnVerified= true;
				} catch (Exception e) {
					strObjectsNotFound = strObjectsNotFound + ", " + objList.get(1);
					strError = strError + e.getMessage();
					blnVerified= false;
					break;
				}
		}
		return blnVerified;
	}
	
	/**
	 * Method to Verify a single Object in a page
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 08-19-2016
	 * @param Object - page Object to be verified.
	 * @return (boolean) True/False
	 * 
	 */
	public boolean verifyPageObject(String strPageObject,String strObjectName,String strObjectLocatorType) {
		By ByVar = null;
		boolean blnVerified = true;
		switch (strObjectLocatorType.toUpperCase()) {
		case "TAGNAME":
			ByVar = By.tagName(strPageObject);
			break;
		case "XPATH":
			ByVar = By.xpath(strPageObject);
			break;
		case "NAME":
			ByVar = By.name(strPageObject);
			break;
		case "ID":
			ByVar = By.id(strPageObject);
			break;
		case "LINKTEXT":
			ByVar = By.linkText(strPageObject);
			break;
		case "CSS":
			ByVar = By.cssSelector(strPageObject);
			break;
		case "CLASS":
			ByVar = By.className(strPageObject);
			break;
		case "PARTIALLINKTEXT":
			ByVar = By.partialLinkText(strPageObject);
			break;
		default:
			break;
		}
		try {
			driver.findElement(ByVar);
			blnVerified= true;
		} catch (Exception e) {
			strObjectsNotFound = strObjectsNotFound + ", " + strObjectName;
			strError = strError + e.getMessage();
			blnVerified= false;
		}
		return blnVerified;
	}
	
	/**
	 * Method to find text in PDF Content
	 * 
	 * @author Ambarish Khatua
	 * @since 09-26-2016
	 * @param String strTextToFind - Text to find
	 * @return (boolean) True/False
	 * 
	 */
	public boolean findTextInPDF(String strTextToFind){
		boolean blnFound = false;
		try {
			
			//1. Using Actions class, Do Ctrl+A & Ctrl+C to copy the text from PDF Report for the 1st Page
			Actions action = new Actions(driver); 
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			action.click().keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
			action.keyUp(Keys.CONTROL).perform();
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			
			//2. From SystemClipboard read the copied item
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			
			//3. Convert the Clipboard data into String & Verify if the Report Type is matched.
			String text = (String)clipboard.getData(DataFlavor.stringFlavor);
			
			text = (String)clipboard.getData(DataFlavor.stringFlavor);
			System.out.println(text);
			if(text.contains(strTextToFind)){
				blnFound = true;
			}
				
			return blnFound;
		} catch (Exception e) {
			strError  = e.getMessage();
			return blnFound;
		}
		
	}
	
	/**
	 * This function is used to perform Support View operation  
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 09-29-2016
	 * @param String strSupportViewOption - Support View Options, String strSupportViewData - Support View Data
	 * @return (boolean) True/False
	 */
	public boolean performSupportView(String strSupportViewOption, String strSupportViewData) {
		WebElement element = null;
		try {
			driver.switchTo().defaultContent();
			BNHomePage bnHome = new BNHomePage(driver);
			bnHome.navigateToBNMenu(SUPPORTVIEWNAVMENULEVEL1,SUPPORTVIEWNAVMENULEVEL2,SUPPORTVIEWNAVMENULEVEL3);
			
			waitForPageLoading(lplCoreConstents.LOW);
			
			//Switch to Frames to access the objects for Support View Operation.
			driver.switchTo().defaultContent();
			//First switch to Parent IFrame of name "shell"
			driver.switchTo().frame(strParentFrame);
			//Second switch to Last IFrame
			WebElement objIframe = driver.findElement(By.xpath(strIframe_XPATH));
			driver.switchTo().frame(objIframe);
			
			//Based on SupportView Options, select the element
			switch(strSupportViewOption.toUpperCase().trim()){
				case "NAME":
					element = driver.findElement(By.id(strLoginName_ID));
					break;
				case "REPID":
					element = driver.findElement(By.id(strMasterRepID_ID));
					break;
			}
			
			//Enter value in the SupportView element
			element.sendKeys(strSupportViewData);
			
			//Click on the "OK" button
			driver.findElement(By.id(strOKButton_ID)).click();
			
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			
			//Switch to Frames to access the objects for Support View Operation.
			driver.switchTo().defaultContent();
			
			return true;
		} catch (Exception e) {
			strError = e.toString();
			return false;
		}
	}
	
	/**
	 * This function is used to Enter Rep id in the LPL Firm where Rep ID is identified as one single HTML tag  
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-30-2016
	 * @param String strRepControl_tagname - Rep Control tagname (SearchSplitRepBox usually), String strRepID - Rep ID to enter
	 * @return (boolean) True/False
	 */
	public boolean enterRepIDControlLPL(String strRepControl_tagname, String strRepID) {
		try {
			//Move to the Rep Control and then Enter Rep ID
			WebElement objRepControl = driver.findElement(By.tagName(strRepControl_tagname));
			objRepControl.click();
			/*Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);*/
			
			Actions action = new Actions(driver); 
			action.click().keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
			action.keyUp(Keys.SHIFT).perform();
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
			
			Keyboard keyboard = new Keyboard();
			keyboard.type(strRepID);
			
			return true;
		} catch (AWTException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * This function is used to Enter Rep id in the AXA Firm where Rep ID is identified as one single HTML tag  
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 01-24-2017
	 * @param String strPageHeader_XPATH - xpath of the page header shown in Bold (Ex: //*[@class='PurposeStatementTitle']), String strRepID - Rep ID to enter
	 * @return (boolean) True/False
	 */
	public boolean enterRepIDControlAXA(String strRepID_TagName, String strRepID) {
		try {
			//Move to the Rep Control and then Enter Rep ID
			WebElement objRepControl = driver.findElement(By.tagName(strRepID_TagName));
			objRepControl.sendKeys(Keys.TAB);
			
			//Press tab 3 times
			/*Actions action = new Actions(driver); 
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();*/
			
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().LOWESTInMiliSec);
			/*action.click().keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
			action.keyUp(Keys.SHIFT).perform();
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);*/
			
			Keyboard keyboard = new Keyboard();
			keyboard.type(strRepID);
			
			return true;
		} catch (AWTException e) {
			e.printStackTrace();
			return false;
		}
	}
}
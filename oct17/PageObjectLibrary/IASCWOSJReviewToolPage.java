package PageObjectLibrary;

import java.util.HashMap;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;
import PageObjectLibrary.ClientManagement_Common;

/**
 * <p>
 * <br><b> Title: </b> IASCWOSJReviewToolPage.java</br>
 * <br><b> Description: </B> Page Object Library and common functions For Branch Trade Report</br>
 * <br><b>Usage:</br></b>
 * <br>clickAndVerifyTradeBlotterPage: This method is used to click and verify TradeBlotter Page </br
 * <br>clickAndVerifyEmailReviewPage: This method is used to click and verify Email Review  Page </br
 * @author Jyothi Jyothi
 * @since 09-12-2017
 * </p>
 */
public class IASCWOSJReviewToolPage extends ClientManagement_Common{
	
	
	/** CSS Selector Property Value of Page Title. */
	String strPageTitle_XPATH;
	
	/** XPATH Property value of Task Due header. */
	String strTaskDue_XPATH;
	
	/** XPATH Property value of Task Categories header. */
	String strTaskCategories_XPATH;

	/** Link text Property value of Button. */
	String strTradeBlotter_LINKTEXT;
	
	/** Link Text Property value of Button. */
	String strEmailReview_LINKTEXT;
	
	/** ID Property value of Frame1. */
	String strFrame1_ID;
	
	/** ID Property value of Frame2. */
	String strFrame2_ID;
	
	/** ID Property value of Frame3. */
	String strFrame3_ID;
	
	/** XPATH Property value of Table rows. */
	public String strTradeListCount_XPATH;
	
	/** XPATH Property value of Trade Blotter Page Title. */
	public String strTradeBlotterPageTitle_XPATH;
	
	/** XPATH Property value of Trade Blotter Page Title. */
	public String strEmailReviewPageHeader_XPATH;
	
	/** XPATH Property value of Trade Blotter Page Title. */
	public String strCreateYourOwnPortlets_XPATH;
	
    
	HomePage homePage;

	ClientManagement_Common cmCommon;
	
	final String strWindow="WINDOW";
	final String strFrame="FRAME"; 
	
	/** Current Page ID from FARM */ 
	public static final int INTPAGEID = 462;
	public String[][] allObjects = null;
	
	
	public IASCWOSJReviewToolPage(WebDriver driver){
		super(driver);
		try {
			
			homePage=new HomePage(driver);
			cmCommon = new ClientManagement_Common(driver);
			
			/** Fetching the page objects from FARM */
			HashMap<String,HashMap<String, String>> pageObjectsMap=LPLCoreDBConnect.getObjectsFromDB(INTPAGEID, new LPLConfig().getEnvId());
			final String  strLocatorXPATH ="XPATH";
			final String  strLocatorLINKTEXT ="LINKTEXT";
			final String  strLocatorID ="ID";
			if(pageObjectsMap.get("strPageTitle").get(strLocatorXPATH)!=null)
				strPageTitle_XPATH = pageObjectsMap.get("strPageTitle").get(strLocatorXPATH);
			
			if(pageObjectsMap.get("strTaskDue").get(strLocatorXPATH)!=null)
				strTaskDue_XPATH = pageObjectsMap.get("strTaskDue").get(strLocatorXPATH);
			
			if(pageObjectsMap.get("strTaskCategories").get(strLocatorXPATH)!=null)
				strTaskCategories_XPATH = pageObjectsMap.get("strTaskCategories").get(strLocatorXPATH);		
			
			if(pageObjectsMap.get("strTradeBlotter").get(strLocatorID)!=null)
				strTradeBlotter_LINKTEXT = pageObjectsMap.get("strTradeBlotter").get(strLocatorID);	
			
			if(pageObjectsMap.get("strEmailReview").get(strLocatorID)!=null)
				strEmailReview_LINKTEXT = pageObjectsMap.get("strEmailReview").get(strLocatorID);
			
			if(pageObjectsMap.get("strFrame1").get(strLocatorID)!=null)
				strFrame1_ID = pageObjectsMap.get("strFrame1").get(strLocatorID);
			
			if(pageObjectsMap.get("strFrame2").get(strLocatorID)!=null)
				strFrame2_ID = pageObjectsMap.get("strFrame2").get(strLocatorID);
			
			if(pageObjectsMap.get("strFrame3").get(strLocatorID)!=null)
				strFrame3_ID = pageObjectsMap.get("strFrame3").get(strLocatorID);
			
			if(pageObjectsMap.get("strTradeListCount").get(strLocatorXPATH)!=null)
				strTradeListCount_XPATH = pageObjectsMap.get("strTradeListCount").get(strLocatorXPATH);
			
			if(pageObjectsMap.get("strTradeBlotterPageTitle").get(strLocatorXPATH)!=null)
				strTradeBlotterPageTitle_XPATH = pageObjectsMap.get("strTradeBlotterPageTitle").get(strLocatorXPATH);
			
			if(pageObjectsMap.get("strEmailReviewPageHeader").get(strLocatorXPATH)!=null)
				strEmailReviewPageHeader_XPATH = pageObjectsMap.get("strEmailReviewPageHeader").get(strLocatorXPATH);
			
			if(pageObjectsMap.get("strCreateYourOwnPortlets").get(strLocatorXPATH)!=null)
				strCreateYourOwnPortlets_XPATH = pageObjectsMap.get("strCreateYourOwnPortlets").get(strLocatorXPATH);
			
			String[][] allPageObjects = {{strPageTitle_XPATH, "Page Title", strLocatorXPATH},{strTaskDue_XPATH,"Task Due",strLocatorXPATH},{strTaskCategories_XPATH,"Task Categories",strLocatorXPATH},{strTradeBlotter_LINKTEXT,"Trade Blotter",strLocatorLINKTEXT},{strEmailReview_LINKTEXT,"Email Review",strLocatorLINKTEXT}};
			this.allObjects = allPageObjects;
			
		} catch (Exception ex) {
			strError = strError+ex.getMessage();
			
		}
		
	}
	
	/**
	 * clickAndVerifyPageObjects : This method is used click and verify Trade Boltter page 
	 * @author Jyothi Jyothi
	 * @version 1.0
	 * @since 10-05-2017
	 * @return boolean True if all objects verified successfully 
	 */
	public boolean clickAndVerifyTradeBlotterPage(){
		
		try {
			//get window handles
			String osjHandle= driver.getWindowHandle();
			
			//Click on Trade Blotter Link
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			cmCommon.clickOnLinkText(strTradeBlotter_LINKTEXT);
			
			//Wait for page to Load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
			
			//switch to Trade Blotter page
			homePage.switchTo(strWindow,strTradeBlotter_LINKTEXT);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
		
			//switch to frame1
			homePage.switchTo(strFrame,strFrame1_ID);
			
			//Verify Page Header
			WebElement objTradeBlotterPageTitle=driver.findElement(By.xpath(strTradeBlotterPageTitle_XPATH));
			if(objTradeBlotterPageTitle.isDisplayed()){
				objTradeBlotterPageTitle.getText();
			}
			//switch to frame2
			LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
			homePage.switchTo(strFrame,strFrame2_ID);
			
			//switch to frame3
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			homePage.switchTo(strFrame,strFrame3_ID);
			
			//get text of total rows
			WebElement objRowsText=driver.findElement(By.xpath(strTradeListCount_XPATH));
			String count=objRowsText.getText();

			int intlenghUI = count.length();
			count=count.substring(1, intlenghUI-1);
		
			int countUI=Integer.parseInt(count);
			
			//compare the no of rows is greater than 1
			if(countUI>=1){
				LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
				driver.close();
				driver.switchTo().window(osjHandle);
			}
			return true;
		} catch (Exception ex) {
			strError = strError+ex.getMessage();
			return false;
		}
			
	}
		
	/**
	 * clickAndVerifyPageObjects : This method is used click and verify Email Review objects
	 * @author Jyothi Jyothi
	 * @version 1.0
	 * @since 10-05-2017
	 * @return boolean True if all objects verified successfully 
	 */
	public boolean clickAndVerifyEmailReviewPage(String strWindowHandle){
		
		try {
			
			LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
			
			//Click on Email Review  Link
			cmCommon.clickOnLinkText(strEmailReview_LINKTEXT);
			//wait for page loading
			homePage.waitForPageLoading(homePage.lplCoreConstents.MEDIUM);
			
			//get last wind handle
			String strEmailReviewtHandle = driver.getWindowHandle();
			boolean blnOSJWindowPresent = false;
			
			//get all windown handles and switch current window
			Set<String> arrAllHandles = driver.getWindowHandles();
			if (arrAllHandles.size()>=3) {
				for (String currentHandle : arrAllHandles) {
					if (!currentHandle.trim().equalsIgnoreCase(
							strEmailReviewtHandle.trim()) && !currentHandle.trim().equalsIgnoreCase(
									strWindowHandle.trim())) {
						driver.switchTo().window(currentHandle);
						blnOSJWindowPresent = true;
						break;
					}
				}
			}
			if(blnOSJWindowPresent){
				LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);		
				//Verify Page Header
				WebElement objEmailReviewPageHeader=driver.findElement(By.xpath(strEmailReviewPageHeader_XPATH));	
				if(LPLCoreUtil.isElementPresent(objEmailReviewPageHeader)){
					LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
					driver.close();
				}	
			}
			return true;
		} catch (Exception ex) {
			strError = strError+ex.getMessage();
			return false;
		}
			
	}
}

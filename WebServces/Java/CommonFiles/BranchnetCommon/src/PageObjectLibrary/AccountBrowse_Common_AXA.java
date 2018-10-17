package PageObjectLibrary;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;


/**
 * <p>
 * <br><b> Title: </b> AccountBrowse_Common.java</br>
 * <br><b> Description: </B> Page Object Library For BranchNet - Account Browse - any Tab</br>
 * <br><b>Usage:</br></b> 
 * <br>navigateToAccountBrowseTab: This function is used to click any tab link of the Account browse application in BranchNet. </br>
 * @author Aiswarya Srinivasan
 * @since 08-17-2016 
 * </p>
 */
public class AccountBrowse_Common_AXA extends BNCommon{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
		 
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strIframe_XPATH						= ".//iframe[2]"; 
	
	private String strCurrentSelectedTab_xpath 			= "//*[@class='Tab TabSelected']";
	
	private String strUnSelectedTabs_xpath 				= "//*[@class='Tab TabUnSelected' and text()='x']";
	
	private String strUnSelectedTabsContainsText_xpath 	= "//*[@class='Tab TabUnSelected' and contains(text(),'x')]";
	
	public String strParentFrame 						= "shell";
	
	public String strObjectsFound						= "";
	
	//Added on Jan 9 2017 for Level 2 - Aiswarya
	public String strClearButton_id						= "dvIcon_ctl00_cph_clearButton";
	
	public String strRepSearchTextBox_id				= "ctl00_cph_repSearch_TextBox";
	
	public String strResultsGridWholeTable_xpath		= "//table[@id='ctl00_cph_resultsGrid']";
	
	public String strNewSearchButton_id					= "dvIcon_ctl00_cph_btnNewSearch";
	
	public String strAccountAssetsIframe_XPATH			= "//iframe[contains(@id,'undefined')]";
	
	public String strAccountAssetsNewSearchBtn_id		= "dvIcon_ctl00_ContentPlaceHolder1_search_btnNewSearch";
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 344;
	
	public AccountBrowse_Common_AXA(WebDriver driver){
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();
		
		try {
			/** Fetching the PageObjects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
					.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

			if (PageObjectsMap.get("strIframe").get("XPATH") != null)
				strIframe_XPATH = PageObjectsMap.get("strIframe").get(
						"XPATH");

			if (PageObjectsMap.get("strCurrentSelectedTab").get("XPATH") != null)
				strCurrentSelectedTab_xpath = PageObjectsMap.get("strCurrentSelectedTab").get("XPATH");

			if (PageObjectsMap.get("strUnSelectedTabs").get("XPATH") != null)
				strUnSelectedTabs_xpath = PageObjectsMap.get(
						"strUnSelectedTabs").get("XPATH");
			
			if (PageObjectsMap.get("strParentFrame").get("ID") != null)
				strParentFrame = PageObjectsMap.get("strParentFrame").get("ID");
			
			if (PageObjectsMap.get("strUnSelectedTabsContainsText").get("XPATH") != null)
				strUnSelectedTabsContainsText_xpath = PageObjectsMap.get("strUnSelectedTabsContainsText").get("XPATH");
			
			if (PageObjectsMap.get("strAccountAssetsIframe").get("XPATH") != null)
				strAccountAssetsIframe_XPATH = PageObjectsMap.get("strAccountAssetsIframe").get("XPATH");
			
			if (PageObjectsMap.get("strAccountAssetsNewSearchBtn").get("ID") != null)
				strAccountAssetsNewSearchBtn_id = PageObjectsMap.get("strAccountAssetsNewSearchBtn").get("ID");
			
			if (PageObjectsMap.get("strRepSearchTextBox").get("ID") != null)
				strRepSearchTextBox_id = PageObjectsMap.get("strRepSearchTextBox").get("ID");
			
			if (PageObjectsMap.get("strResultsGridWholeTable").get("XPATH") != null)
				strResultsGridWholeTable_xpath = PageObjectsMap.get("strResultsGridWholeTable").get("XPATH");
			
			if (PageObjectsMap.get("strNewSearchButton").get("ID") != null)
				strNewSearchButton_id = PageObjectsMap.get("strNewSearchButton").get("ID");
			
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of AccountBrowse_Common Class", "Object should be successfully created of AccountBrowse_Common class", "Failed to fetch the objects of AccountBrowse_Common from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	/**
	 * This function is used to click any tab link of the Account browse application in BranchNet.
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 08-17-2016
	 * @param strTabName - Tab name To Be Clicked
	 * @return boolean True if Tab name link is clicked successfully and False if failed
	 */
	public boolean navigateToAccountBrowseTab(String strTabName,String pageTitle) {
		boolean blnReturn = false;

		try {			
			// Wait for the Objects to get loaded...
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);

			//Switch to proper frames
			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(strParentFrame);
			} catch (Exception e3) {
				driver.switchTo().defaultContent();
			}
			try {
				WebElement objIframe = driver.findElement(By.xpath(strIframe_XPATH));
				driver.switchTo().frame(objIframe);
			} catch (Exception e2) {
				driver.switchTo().defaultContent();
			}
			
			// Click on the Account browse tab
			WebElement objTabLink = null;
			try {
				String strChanged = strUnSelectedTabs_xpath.replaceAll("'x'", "'"+strTabName+"'");
				objTabLink = driver.findElement(By.xpath(strChanged));
				objTabLink.click();
			} catch (Exception e) {
				try {
					String strChanged1 = strUnSelectedTabsContainsText_xpath.replaceAll("'x'", "'Aggregate'");
					objTabLink = driver.findElement(By.xpath(strChanged1));
					objTabLink.click();
				} catch (Exception e2) {
					try {
						objTabLink = driver.findElement(By.xpath(strCurrentSelectedTab_xpath));
						objTabLink.click();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
			
			// Wait for the Objects to get loaded...
			waitForPageLoading(lplCoreConstents.MEDIUM);
				
			// If the Tab is selected, Return true
			if (driver.findElement(By.xpath(strCurrentSelectedTab_xpath)).getText().equalsIgnoreCase(strTabName)) {
				blnReturn = true;
			} else {
				strError = strTabName + " Link is not displayed/clicked. Error :[" + strError+ "]";
				blnReturn = false;
			}
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	public boolean verifyABPageObjectsPresent(String[] allIDsToVerify,String strTabDiv_Xpath){
		boolean blResult = true;
		
		//Switch to proper frames
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(strParentFrame);
		} catch (Exception e3) {
			driver.switchTo().defaultContent();
		}
		try {
			WebElement objIframe = driver.findElement(By.xpath(strIframe_XPATH));
			driver.switchTo().frame(objIframe);
		} catch (Exception e2) {
			driver.switchTo().defaultContent();
		}
		
		WebElement myPage = driver.findElement(By.xpath(strTabDiv_Xpath));
		List<WebElement> allTables = myPage.findElements(By.tagName("table"));
		int foundCount = 0;
		//Loop through all objects and validating presence of each
		for (int intIndex = 0; intIndex < allIDsToVerify.length; intIndex++) {
			for(WebElement objTable : allTables){
				try {
					objTable.findElement(By.id(allIDsToVerify[intIndex]));
					strObjectsFound = strObjectsFound + allIDsToVerify[intIndex] + ",";
					foundCount = foundCount +1;
					break;
				} catch (Exception e) {
					strError = e.getMessage();
				}
			}
		}
		if(foundCount<allIDsToVerify.length){
			blResult = false;
		}
		return blResult;
	}
	
	/**
	 * clearABPages : This method is used to click clear button in any Account browse Tab
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 10-04-2016
	 * @param strClearButtonLocator - Locator value of Clear Button
	 * @return boolean True if Clear button is clicked successfully and False if failed
	 */
	public boolean clearABPages(String strClearButtonLocator){
		//Switch to proper frames
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(strParentFrame);
		} catch (Exception e3) {
			driver.switchTo().defaultContent();
		}
		try {
			WebElement objIframe = driver.findElement(By.xpath(strIframe_XPATH));
			driver.switchTo().frame(objIframe);
		} catch (Exception e2) {
			driver.switchTo().defaultContent();
		}
		
		//Click on CLear Button
		WebElement objClearButton = driver.findElement(By.id(strClearButtonLocator));
		try {
			objClearButton.click();
			
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

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
 * <br><b> Title: </b> AccountBrowse_BalancesPage.java</br>
 * <br><b> Description: </B> Page Object Library For BranchNet - Account Browse - Balances Tab</br>
 * <br> This file is put in here for usage by different projects (Universal S&G and TSHD)</br>
 * @author Aiswarya Srinivasan
 * @since 08-17-2016 
 * </p>
 */
public class AccountBrowse_BalancesPage extends AccountBrowse_Common{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
	
	/**Variables to hold values of Missing and Found columns*/
	public String strFoundColumns = "";
	public String strMissingColumns = "";
		 
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strIframe_XPATH				= ".//iframe[2]";
	
	public String strTabDiv_Xpath 				= "//*[@class='mainContent balances']";
	
	public String strRepSearchPanel_id			= "ctl00_cph_repSearch";
	
	public String strRepDropDown_id				= "ctl00_cph_repSearch_DropDownList";
	
	public String strSearchButton_id			= "dvIcon_ctl00_cph_btnSearch";
	
	public String strRolodexLinks_id			= "rolodexContainer";
	
	//Added on 11/22/2016 - Aiswarya
	public String strClearButton_id				= "dvIcon_ctl00_cph_btnClear";
	
	public String strNumberOfResults_xpath		= ".//tbody/tr/td";
	
	public String strPageLinks_xpath			= ".//tbody/tr[4]/td/a";
	
	public String strResultHeaders_xpath		= ".//tbody/tr[5]/th/a";
	
	public String strAssetsActiveTab_id 		= "ctl00_ContentPlaceHolder1_assetsTab";
	
	public String strBalancesSection_AssetTab_id= "ctl00_ContentPlaceHolder1_balances_balancesPanel";
	
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 120;
	
	public String[][] allObjects = null;
	
	public AccountBrowse_BalancesPage(WebDriver driver){
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

			if (PageObjectsMap.get("strTabDiv").get("XPATH") != null)
				strTabDiv_Xpath = PageObjectsMap.get("strTabDiv").get("XPATH");

			if (PageObjectsMap.get("strRepSearchPanel").get("ID") != null)
				strRepSearchPanel_id = PageObjectsMap.get(
						"strRepSearchPanel").get("ID");
			
			if (PageObjectsMap.get("strRepDropDown").get("ID") != null)
				strRepDropDown_id = PageObjectsMap.get("strRepDropDown").get("ID");
			
			if (PageObjectsMap.get("strSearchButton").get("ID") != null)
				strSearchButton_id = PageObjectsMap.get("strSearchButton").get("ID");
			
			if (PageObjectsMap.get("strRolodexLinks").get("ID") != null)
				strRolodexLinks_id = PageObjectsMap.get("strRolodexLinks").get("ID");
			
			if (PageObjectsMap.get("strNumberOfResults").get("XPATH") != null)
				strNumberOfResults_xpath = PageObjectsMap.get("strNumberOfResults").get("XPATH");
			
			if (PageObjectsMap.get("strPageLinks").get("XPATH") != null)
				strPageLinks_xpath = PageObjectsMap.get("strPageLinks").get("XPATH");
			
			if (PageObjectsMap.get("strResultHeaders").get("XPATH") != null)
				strResultHeaders_xpath = PageObjectsMap.get("strResultHeaders").get("XPATH");
			
			if (PageObjectsMap.get("strAssetsActiveTab").get("ID") != null)
				strAssetsActiveTab_id = PageObjectsMap.get("strAssetsActiveTab").get("ID");
			
			if (PageObjectsMap.get("strBalancesSection_AssetTab").get("ID") != null)
				strBalancesSection_AssetTab_id = PageObjectsMap.get("strBalancesSection_AssetTab").get("ID");
			
			if (PageObjectsMap.get("strClearButton").get("ID") != null)
				strClearButton_id = PageObjectsMap.get("strClearButton").get("ID");
			
			String[][] allPageObjects = {
					{strTabDiv_Xpath,"Page Container","XPATH"},
					{strRepSearchPanel_id,"Rep Search Panel","ID"},
					{strRepDropDown_id,"Rep Drop down","ID"},
					{strSearchButton_id,"Search Button","ID"},
					{strRolodexLinks_id,"Rolodex Links","ID"}};
			
			this.allObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of AccountBrowse_BalancesPage Class", "Object should be successfully created of AccountBrowse_BalancesPage class", "Failed to fetch the objects of AccountBrowse_BalancesPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	/**
	 * setSearchCriteriaBalances : This method is set search Criteria in Balances Page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-22-2016
	 * @param strRepID = Rep ID to search with
	 * @return boolean True if search criteria is set successfully and False if failed
	 */
	public boolean setSearchCriteriaBalances(String strRepID){
		try {
			//Enter Rep ID
			WebElement objRepSearchTextBox = driver.findElement(By.id(strRepSearchTextBox_id));
			objRepSearchTextBox.sendKeys(strRepID);
			return true;
		} catch (Exception e) {
			strError = strError + " Problem setting the Search Criteria of Aggregate Balances page";
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * SearchAndValidateBalances : This method is to Search and validate the results in Balances page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-22-2016
	 * @param strExpectedColumns - Expected Column header header names in a comma separated single string
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean SearchAndValidateBalances(String strExpectedColumns){
		boolean blnResult1 = false;
		boolean blnResult2 = false;
		try {
			//Click Search Button
			WebElement objSearchButton = driver.findElement(By.id(strSearchButton_id));
			objSearchButton.click();
			
			//Wait for Results Grid to Load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			if(LPLCoreSync.waitTillVisible(driver, By.xpath(strResultsGridWholeTable_xpath), LPLCoreConstents.getInstance().BaseInMiliSec)){
				WebElement objWholeResultsGrid = driver.findElement(By.xpath(strResultsGridWholeTable_xpath));
				
				try {
					//Verify the Number of Results loaded line
					@SuppressWarnings("unused")
					WebElement objNumberOfResults = objWholeResultsGrid.findElement(By.xpath(strNumberOfResults_xpath));
					blnResult1 = true;
				} catch (Exception e) {
					strError = strError + " " + e.getMessage();
					blnResult1 = false;
				}
				
				try {
					//Verify the Page links in the Results Grid
					List<WebElement> objPageLinks = objWholeResultsGrid.findElements(By.xpath(strPageLinks_xpath));
					for(WebElement pageLink: objPageLinks){
						if(pageLink.getAttribute("id").contains("_pageLink")){
							blnResult2 = true;
						}
					}
				} catch (Exception e) {
					strError = strError + " " + e.getMessage();
					blnResult1 = false;
				}
				
				//Verify the Table header columns with the Expected Columns list
				List<WebElement> objResultHeaders = driver.findElements(By.xpath(strResultHeaders_xpath));
				String strActualHeaderList = "";
				for(WebElement thisResultHeader: objResultHeaders){
					strActualHeaderList = strActualHeaderList + thisResultHeader.getText() + ",";
				}
				
				String[] arrExpectedValues = strExpectedColumns.split(",");
				String[] arrActualvalues = strActualHeaderList.split(",");
				boolean blnThisValueFound = false;
				
				for(String strEachColumn:arrExpectedValues){
					blnThisValueFound = false;
					for(String strEachActualValue: arrActualvalues){
						if(strEachColumn.trim().equalsIgnoreCase(strEachActualValue.trim())){
							strFoundColumns = strFoundColumns + strEachColumn + ",";
							blnThisValueFound= true;
							break;
						}
					}
					if(!blnThisValueFound){
						strMissingColumns = strMissingColumns + strEachColumn + ",";
					}
				}
				if (blnThisValueFound & blnResult1 & blnResult2) {
					return true;
				}else{
					strError = strError + " Search Results validation failed for Balances page. Details: Expected Columns: " + strExpectedColumns+ " Actual Columns: " + strActualHeaderList + "; Page links and Number of results badge might also be missing ";
					return false;
				}
			}else{
				strError = strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Balances page";
				return false;
			}
		} catch (Exception e) {
			strError = strError + " Problem validating Search results of Balances page";
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifyAccountAssetsBalances : This method is to Click on LPL Account number link in the Balances search results and verify if Assets page and Balances section loaded
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-22-2016
	 * @param strLPLAcctNumberColumnText - LPL Account number column label as expected in the application
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean verifyAccountAssetsBalances(String strLPLAcctNumberColumnText){
		boolean blnAcctAssetsBalancesTableFound = false;
		try {
			//Wait for Results Grid to Load
			if(LPLCoreSync.waitTillVisible(driver, By.xpath(strResultsGridWholeTable_xpath), LPLCoreConstents.getInstance().BaseInMiliSec)){
				WebElement objWholeResultsGrid = driver.findElement(By.xpath(strResultsGridWholeTable_xpath));
				
				//Looping through the actual column headers
				boolean blnLPLAcNumColumnFound = false;
				boolean blnLPLAcNumLinkFound = false;
				int intCounter = 0;
				
				//Get the Header columns list
				List<WebElement> objResultHeaders = objWholeResultsGrid.findElements(By.xpath(strResultHeaders_xpath));
				for(WebElement thisResultHeader: objResultHeaders){
					intCounter = intCounter+1;
					if(strLPLAcctNumberColumnText.trim().equalsIgnoreCase(thisResultHeader.getText().trim())){
						blnLPLAcNumColumnFound= true;
						break;
					}
				}
				
				//If the Lpl Account number Column is found, then try to click
				if(blnLPLAcNumColumnFound){
					List<WebElement> objAllTRs = objWholeResultsGrid.findElements(By.tagName("tr"));
					
					for (WebElement thisTR : objAllTRs) {
						try {
							//Get the Current Window handle and click on the LPL Account number Link if found
							WebElement objLplAcNumLink = thisTR.findElement(By.xpath(".//td["+intCounter+"]/a"));
							blnLPLAcNumLinkFound = true;
							objLplAcNumLink.click();
							LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
							driver.switchTo().defaultContent();
							driver.switchTo().frame(strParentFrame);
							WebElement objAssetsFrame = driver.findElement(By.xpath(strAccountAssetsIframe_XPATH));
							driver.switchTo().frame(objAssetsFrame);
							
							//After Clicking on the Account number , wait for Account Assets page to load
							LPLCoreSync.waitTillVisible(driver, By.id(strAssetsActiveTab_id), LPLCoreConstents.getInstance().BaseInMiliSec);
							if (LPLCoreSync.waitTillVisible(driver, By.id(strBalancesSection_AssetTab_id), LPLCoreConstents.getInstance().BaseInMiliSec)) {
								blnAcctAssetsBalancesTableFound = true;
							}
							break;
						} catch (Exception e) {
							blnLPLAcNumLinkFound = false;
						}
					}
					//Fail the method if LPL Account number Link is not found in any row of search results
					if(!blnLPLAcNumLinkFound){
						strError = strError + " LPL Account number Link not found in any row of search results in Balances page";
						return false;
					}
					//If Account assets page loaded and the Balances section loaded, then Pass the method
					if (blnAcctAssetsBalancesTableFound) {
						//Click on New Search Button
						driver.findElement(By.id(strAccountAssetsNewSearchBtn_id)).click();
						LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
						driver.switchTo().defaultContent();
						return true;
					}else{
						strError = strError + " Account Assets did not open on clicking LPL Account number.";
						return false;
					}
				}else{
					strError = strError + " LPL Account number Column not found in search results of Balances page.";
					return false;
				}
			}else{
				strError = strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Balances page";
				return false;
			}
		} catch (Exception e) {
			strError = strError + e.getMessage();
			return false;
		}
	}
}

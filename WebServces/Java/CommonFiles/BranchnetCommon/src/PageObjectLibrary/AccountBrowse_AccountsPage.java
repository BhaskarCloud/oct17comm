package PageObjectLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import LPLCoreDriver.LPLCoreUtil;

/**
 * <p>
 * <br><b> Title: </b> AccountBrowse_AccountsPage.java</br>
 * <br><b> Description: </B> Page Object Library For BranchNet - Account Browse - Accounts Tab</br>
 * <br> This file is put in here for usage by different projects (Universal S&G and TSHD)</br>
 * @author Aiswarya Srinivasan
 * @since 08-26-2016 
 * </p>
 */
public class AccountBrowse_AccountsPage extends AccountBrowse_Common{

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
	
	/**Variables to hold values of Missing and Found columns*/
	public String strFoundColumns = "";
	public String strMissingColumns = "";
	public String strSecID = "";
	public String strPrice = "";
	public String strPriceYahoo= "";
	public WebElement objWholeResultsGrid = null;

	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strIframe_XPATH								= ".//iframe[2]";

	public String strTabDiv_Xpath 								= "//*[@class='mainContent accounts']";

	public String strRepSearchPanel_id							= "ctl00_cph_repSearch_Panel";

	public String strRepDropDown_id								= "ctl00_cph_repSearch_DropDownList";

	public String strSearchButton_id							= "dvIcon_ctl00_cph_btnSearch";
	
	public String strRolodexLinks_id							= "rolodexContainer";

	public String strDisplayResultsTypePanel_id					= "ctl00_cph_panelDisplayResults";

	public String strLPLAccountsPanel_id						= "ctl00_cph_panelLPLAccounts";

	public String strLifeInsuranceAccountsPanel_id				= "ctl00_cph_panelLifeInsurance";

	public String strUnofficalAccountsPanel_id					= "ctl00_cph_panelUnofficalAccounts";

	public String strGroupCriteriaPanel_id						= "ctl00_cph_panelGroupCriteria";

	public String strSortingCriteriaPanel_id					= "ctl00_cph_panelSorting";

	public String strLPLAccountNum_id							= "ctl00_cph_textBoxLPLAccount";

	public String strGoButton_id 								= "ctl00_cph_btnGoLPLAccount";
	
	//Added for TSHD - 03/13 - Aiswarya
	
	public String strMinValueTextBox_id							= "ctl00_cph_textBoxMinValue";
	
	public String strAccountAssetsIframe_XPATH					= "//iframe[contains(@id,'undefined')]";
	
	public String strMFPositionsGrid_id							= "ctl00_ContentPlaceHolder1_positions_positionsCallbackPanel_mfPositionsGrid";

	public String strLPLPositionsGrid_id						= "ctl00_ContentPlaceHolder1_positions_positionsCallbackPanel_lplPositionsGrid";
	
	public String strNumberOfResults_xpath						= ".//tbody/tr/td";
	
	public String strPageLinks_xpath							= ".//tbody/tr[3]/td/a";
	
	public String strResultHeaders_xpath						= ".//tbody/tr[4]/th/a";
	
	public String strResultHeaders2_xpath						= ".//tbody/tr[3]/th/a";
	
	public String strAssetsActiveTab_id 						= "ctl00_ContentPlaceHolder1_assetsTab_tabCell";
	
	public String strClearButton_id								= "dvIcon_ctl00_cph_btnClear";
	
	//Yahoo Finance Website Objects
	
	public String strFinYahooSearchBox_XPATH					= "//div[@id='search-assist-input']//input[@aria-label='Search']"; 
	
	public String strFinYahooSearchBtn_id						= "search-button";
	
	public String strFinYahooQuoteInfo_id						= "quote-header-info";
	
	public String strFinYahooQuotePrice_XPATH					= ".//div[2]/div/div/span";
	
	public String strLPLAcctsCheckBox_id						= "ctl00_cph_checkBoxLPL";
	
	public String strMFAcctsCheckBox_id							= "ctl00_cph_checkBoxMutualFunds";
	
	public String strSponsorAccountNum_id						= "ctl00_cph_textBoxMFAccount";
	
	public String strMFGoButton_id								= "dvIcon_ctl00_cph_btnGoMFAccount";
	
	public String strMFProfileSummaryPanel_id					= "ctl00_ContentPlaceHolder1_summary_summaryPanel";
	
	public String strFundAcctNum_id								= "ctl00_ContentPlaceHolder1_summary_fundAccountLabel";
	
	public String strSymbolCUSIP_id								= "ctl00_ContentPlaceHolder1_summary_symbolCusipLabel";
	
	public String strNAV_id										= "ctl00_ContentPlaceHolder1_summary_NAVLabel";
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */

	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;

	public String[][] allObjects = null;
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 151;

	public AccountBrowse_AccountsPage(WebDriver driver){
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

			if (PageObjectsMap.get("strDisplayResultsTypePanel").get("ID") != null)
				strDisplayResultsTypePanel_id = PageObjectsMap.get("strDisplayResultsTypePanel").get("ID");

			if (PageObjectsMap.get("strLPLAccountsPanel").get("ID") != null)
				strLPLAccountsPanel_id = PageObjectsMap.get("strLPLAccountsPanel").get("ID");

			if (PageObjectsMap.get("strLifeInsuranceAccountsPanel").get("ID") != null)
				strLifeInsuranceAccountsPanel_id = PageObjectsMap.get("strLifeInsuranceAccountsPanel").get("ID");

			if (PageObjectsMap.get("strUnofficalAccountsPanel").get("ID") != null)
				strUnofficalAccountsPanel_id = PageObjectsMap.get("strUnofficalAccountsPanel").get("ID");

			if (PageObjectsMap.get("strGroupCriteriaPanel").get("ID") != null)
				strGroupCriteriaPanel_id = PageObjectsMap.get("strGroupCriteriaPanel").get("ID");

			if (PageObjectsMap.get("strSortingCriteriaPanel").get("ID") != null)
				strSortingCriteriaPanel_id = PageObjectsMap.get("strSortingCriteriaPanel").get("ID");

			if (PageObjectsMap.get("strLPLAccountNum").get("ID") != null)
				strLPLAccountNum_id = PageObjectsMap.get("strLPLAccountNum").get("ID");

			if (PageObjectsMap.get("strGoButton").get("ID") != null)
				strGoButton_id = PageObjectsMap.get("strGoButton").get("ID");
			
			//Added for TSHD - 03/13 - Aiswarya
			
			if (PageObjectsMap.get("strMinValueTextBox").get("ID") != null)
				strMinValueTextBox_id = PageObjectsMap.get("strMinValueTextBox").get("ID");
			
			if (PageObjectsMap.get("strAccountAssetsIframe").get("XPATH") != null)
				strAccountAssetsIframe_XPATH = PageObjectsMap.get("strAccountAssetsIframe").get("XPATH");
			
			if (PageObjectsMap.get("strMFPositionsGrid").get("ID") != null)
				strMFPositionsGrid_id = PageObjectsMap.get("strMFPositionsGrid").get("ID");

			if (PageObjectsMap.get("strLPLPositionsGrid").get("ID") != null)
				strLPLPositionsGrid_id = PageObjectsMap.get("strLPLPositionsGrid").get("ID");
			
			if (PageObjectsMap.get("strNumberOfResults").get("XPATH") != null)
				strNumberOfResults_xpath = PageObjectsMap.get("strNumberOfResults").get("XPATH");
			
			if (PageObjectsMap.get("strPageLinks").get("XPATH") != null)
				strPageLinks_xpath = PageObjectsMap.get("strPageLinks").get("XPATH");
			
			if (PageObjectsMap.get("strResultHeaders").get("XPATH") != null)
				strResultHeaders_xpath = PageObjectsMap.get("strResultHeaders").get("XPATH");
			
			if (PageObjectsMap.get("strResultHeaders2").get("XPATH") != null)
				strResultHeaders2_xpath = PageObjectsMap.get("strResultHeaders2").get("XPATH");
			
			if (PageObjectsMap.get("strAssetsActiveTab").get("ID") != null)
				strAssetsActiveTab_id = PageObjectsMap.get("strAssetsActiveTab").get("ID");
			
			if (PageObjectsMap.get("strClearButton").get("ID") != null)
				strClearButton_id = PageObjectsMap.get("strClearButton").get("ID");
			
			//Yahoo Finance Website Objects
			
			if (PageObjectsMap.get("strFinYahooSearchBox").get("XPATH") != null)
				strFinYahooSearchBox_XPATH = PageObjectsMap.get("strFinYahooSearchBox").get("XPATH");
			
			if (PageObjectsMap.get("strFinYahooSearchBtn").get("ID") != null)
				strFinYahooSearchBtn_id = PageObjectsMap.get("strFinYahooSearchBtn").get("ID");
			
			if (PageObjectsMap.get("strFinYahooQuoteInfo").get("ID") != null)
				strFinYahooQuoteInfo_id = PageObjectsMap.get("strFinYahooQuoteInfo").get("ID");
			
			if (PageObjectsMap.get("strFinYahooQuotePrice").get("XPATH") != null)
				strFinYahooQuotePrice_XPATH = PageObjectsMap.get("strFinYahooQuotePrice").get("XPATH");
			
			if (PageObjectsMap.get("strLPLAcctsCheckBox").get("ID") != null)
				strLPLAcctsCheckBox_id = PageObjectsMap.get("strLPLAcctsCheckBox").get("ID");
			
			if (PageObjectsMap.get("strMFAcctsCheckBox").get("ID") != null)
				strMFAcctsCheckBox_id = PageObjectsMap.get("strMFAcctsCheckBox").get("ID");
			
			if (PageObjectsMap.get("strMFProfileSummaryPanel").get("ID") != null)
				strMFProfileSummaryPanel_id = PageObjectsMap.get("strMFProfileSummaryPanel").get("ID");
			
			if (PageObjectsMap.get("strFundAcctNum").get("ID") != null)
				strFundAcctNum_id = PageObjectsMap.get("strFundAcctNum").get("ID");
			
			if (PageObjectsMap.get("strSymbolCUSIP").get("ID") != null)
				strSymbolCUSIP_id = PageObjectsMap.get("strSymbolCUSIP").get("ID");
			
			if (PageObjectsMap.get("strNAV").get("ID") != null)
				strNAV_id = PageObjectsMap.get("strNAV").get("ID");
			
			String[][] allPageObjects = {
					{strTabDiv_Xpath,"Page Container","XPATH"},
					{strRepSearchPanel_id,"Rep Search Panel","ID"},
					{strRepDropDown_id,"Rep Drop down","ID"},
					{strSearchButton_id,"Search Button","ID"},
					{strRolodexLinks_id,"Rolodex Links","ID"},
					{strDisplayResultsTypePanel_id,"Display Results Type Selection Panel","ID"},
					{strLPLAccountsPanel_id,"LPL Accounts Selection criteria Panel","ID"},
					{strUnofficalAccountsPanel_id,"Unofficial and Historical Accounts Selection Criteria panel","ID"},
					{strGroupCriteriaPanel_id,"Search Accounts in groups Panel","ID"},
					{strSortingCriteriaPanel_id,"Sorting Criteria panel","ID"},
					{strLPLAccountNum_id,"LPL Account number","ID"},
					{strGoButton_id,"GO button","ID"}};

			this.allObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of AccountBrowse_AccountsPage Class", "Object should be successfully created of AccountBrowse_AccountsPage class", "Failed to fetch the objects of AccountBrowse_AccountsPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}

	/**
	 * Enter account number ,click on Go button.
	 * 
	 * @author Darshana Borade
	 * @version 1.0
	 * @since 12/26/2016
	 * @param String strAccNum - LPL account number. 
	 * @return boolean - True/False
	 */
	public boolean searchTheAccountNum(String strAccNum){
		boolean blnResult = false;
		try{
			//Enter Account number
			driver.findElement(By.id(strLPLAccountNum_id)).sendKeys(strAccNum);

			//click on Search button.
			driver.findElement(By.id(strGoButton_id)).click();

			blnResult = true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}

	/**
	 * setSearchCriteriaAccountsWithMinimumValue : This method is set search Criteria in Account Browse Page with accounts having a certain minimum value
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-13-2017
	 * @param strRepID - Rep ID to search with, strAccountNumber - Account number to search For, strMinValue - Minimum value of an account should be
	 * @return boolean True if search criteria is set successfully and False if failed
	 */
	public boolean setSearchCriteriaAccountsWithAcNum_MinValue(String strRepID, String strAccountNumber, String strMinValue){
		try {
			//Enter Rep ID
			WebElement objRepSearchTextBox = driver.findElement(By.id(strRepSearchTextBox_id));
			objRepSearchTextBox.sendKeys(strRepID);
			
			//Enter Account number
			WebElement objAcctNumTextBox = driver.findElement(By.id(strLPLAccountNum_id));
			objAcctNumTextBox.sendKeys(strAccountNumber);
			
			//Enter Minimum Value
			WebElement objMinValueTextBox = driver.findElement(By.id(strMinValueTextBox_id));
			objMinValueTextBox.sendKeys(strMinValue);
			return true;
		} catch (Exception e) {
			strError = strError + " Problem setting the Search Criteria of Account Browse page. Error text: " + e.getMessage();
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * SearchAndValidateAccountResults : This method is to Search and validate the results in Account browse page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-13-2017
	 * @param strExpectedColumns - Expected Column header header names in a comma separated single string
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean SearchAndValidateAccountResults(String strExpectedColumns){
		boolean blnResult1 = true;
		boolean blnResult2 = true;
		try {
			//Click Search Button
			WebElement objSearchButton = driver.findElement(By.id(strSearchButton_id));
			objSearchButton.click();
			
			//Wait for Results Grid to Load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			if(LPLCoreSync.waitTillVisible(driver, By.xpath(strResultsGridWholeTable_xpath), LPLCoreConstents.getInstance().BaseInMiliSec)){
				objWholeResultsGrid = driver.findElement(By.xpath(strResultsGridWholeTable_xpath));
				
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
				List<WebElement> objResultHeaders = LPLCoreUtil.waitForListOfWebElements(lplCoreConstents.BASE, By.xpath(strResultHeaders2_xpath),By.xpath(strResultHeaders_xpath));
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
					strError = strError + " Search Results validation failed for Account Browse Accounts page. Details: Expected Columns: " + strExpectedColumns+ " Actual Columns: " + strActualHeaderList + "; Page links and Number of results badge might also be missing ";
					return false;
				}
			}else{
				strError = strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Account Browse Accounts page";
				return false;
			}
		} catch (Exception e) {
			strError = strError + " Problem validating Search results of Account Browse Accounts page";
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifyAccountAssetsPositionsTable : This method is to Click on LPL Account number link in the Accounts search results and verify if Assets page and Positions table section loaded
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-13-2017
	 * @param strLPLAcctNumberColumnText - LPL Account number column label as expected in the application
	 * @return boolean true if verification is successful and false if failed
	 */
	public boolean verifyAccountAssetsPositionsTable(String strLPLAcctNumberColumnText){
		boolean blnAcctAssetsPositionsTableFound = false;
		try {
			//Looping through the actual column headers
			boolean blnLPLAcNumColumnFound = false;
			boolean blnLPLAcNumLinkFound = false;
			int intCounter = 0;
			
			//Get the Header columns list
			List<WebElement> objResultHeaders = LPLCoreUtil.waitForListOfWebElements(lplCoreConstents.BASE, By.xpath(strResultHeaders2_xpath),By.xpath(strResultHeaders_xpath));
			for(WebElement thisResultHeader: objResultHeaders){
				intCounter = intCounter+1;
				if(strLPLAcctNumberColumnText.trim().equalsIgnoreCase(thisResultHeader.getText().trim())){
					blnLPLAcNumColumnFound= true;
					break;
				}
			}
			
			//If the LPL Account number Column is found, then try to click
			if(blnLPLAcNumColumnFound){
				List<WebElement> objAllTRs = objWholeResultsGrid.findElements(By.tagName("tr"));
				for (WebElement thisTR : objAllTRs) {
					try {
						//Get the Current Window handle and click on the LPL Account number Link if found
						WebElement objLplAcNumLink = thisTR.findElement(By.xpath(".//td["+(intCounter+1)+"]/a"));
						blnLPLAcNumLinkFound = true;
						objLplAcNumLink.click();
						
						//Wait for the new frame to load
						LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
						
						//Switch back frames and switch to Account assets tab
						driver.switchTo().defaultContent();
						driver.switchTo().frame(strParentFrame);
						WebElement objAssetsFrame = driver.findElement(By.xpath(strAccountAssetsIframe_XPATH));
						driver.switchTo().frame(objAssetsFrame);
						
						//After Clicking on the Account number, wait for Account Assets page to load
						LPLCoreSync.waitTillVisible(driver, By.id(strAssetsActiveTab_id ), LPLCoreConstents.getInstance().BaseInMiliSec);
						if (LPLCoreSync.waitTillVisible(driver, By.id(strAssetsActiveTab_id), LPLCoreConstents.getInstance().BaseInMiliSec)
								&& (LPLCoreSync.waitTillVisible(driver, By.id(strLPLPositionsGrid_id), LPLCoreConstents.getInstance().BaseInMiliSec)
										|| LPLCoreSync.waitTillVisible(driver, By.id(strMFPositionsGrid_id), LPLCoreConstents.getInstance().BaseInMiliSec))) {
							blnAcctAssetsPositionsTableFound = true;
						}
						break;
					} catch (Exception e) {
						blnLPLAcNumLinkFound = false;
						continue;
					}
				}
				//Fail the method if LPL Account number Link is not found in any row of search results
				if(!blnLPLAcNumLinkFound){
					strError = strError + " LPL Account number Link not found in any row of search results in Account Browse Accounts page";
					return false;
				}
				return blnAcctAssetsPositionsTableFound;
			}else{
				strError = strError + " LPL Account number Column not found in search results of Account Browse Accounts page.";
				return false;
			}
		} catch (Exception e) {
			strError = strError + e.getMessage();
			return false;
		}
	}

	/**
	 * captureSecID_Price_ForSecType_AccountAssets : This method is to Capture a Security ID and its Price mentioned in MF Positions Grid of Account assets page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-13-2017
	 * @param strSecurityIDColumnText - Security ID column label as expected in the application, strPriceColumnText - Price column label as expected in the application
	 * @return boolean true if Capture is successful and false if failed
	 */
	public boolean captureSecID_Price_ForSecType_AccountAssets(String strSecurityIDColumnText, String strPriceColumnText, String strSecTypeColumnText, String strSecTypeExpectedValue){
		boolean blnSecIdPriceCaptured = false;
		boolean blnAllExpectedHeadersFound = false;
		try {
			int intSecIDCounter = 0, intPriceCounter =0, intSecTypeCounter = 0, intCounter=0;
			
			//Switch back frames and switch to Account assets tab
			driver.switchTo().defaultContent();
			driver.switchTo().frame(strParentFrame);
			WebElement objAssetsFrame = driver.findElement(By.xpath(strAccountAssetsIframe_XPATH));
			driver.switchTo().frame(objAssetsFrame);
			
			//Verify if MF Positions table found, if yes, capture Sec ID and Price
			WebElement objMFPositionsGrid = LPLCoreUtil.waitForWebElement(lplCoreConstents.FAIR, By.id(strLPLPositionsGrid_id));
			
			//Getting all data rows from Positions table
			List<WebElement> objAllTRs = objMFPositionsGrid.findElements(By.tagName("tr"));
			
			try {
				//Getting the first row (Header row) and capturing column number for Security Type, Security ID and Price
				List<WebElement> objMFPositionsTableHeaders = objAllTRs.get(0).findElements(By.tagName("th"));
				for(WebElement eachColumn: objMFPositionsTableHeaders){
					intCounter = intCounter+1;
					if(eachColumn.getText().equalsIgnoreCase(strSecurityIDColumnText)){
						intSecIDCounter = intCounter;
					}
					if(eachColumn.getText().equalsIgnoreCase(strPriceColumnText)){
						intPriceCounter = intCounter;
					}
					if(eachColumn.getText().equalsIgnoreCase(strSecTypeColumnText)){
						intSecTypeCounter = intCounter;
					}
				}
				//If all the column numbers are returned, then all columns are found
				if(intPriceCounter>0 && intSecIDCounter>0 && intSecTypeCounter>0){
					blnAllExpectedHeadersFound= true;
				}
			} catch (Exception e) {
				strError = strError + " Error capturing Security Type, Security ID and Price Colum number from Account assets MF Positions table. Details: " + e.getMessage();
				return false;
			}
			
			//Looping through rows to check the expected columns are present or not
			for(WebElement thisTR: objAllTRs){
				if (blnAllExpectedHeadersFound) {
					try {
						List<WebElement> objAllTDs = thisTR.findElements(By.tagName("td"));
						if(objAllTDs.get(intSecTypeCounter-1).getText().equalsIgnoreCase(strSecTypeExpectedValue)){
							//Security ID
							WebElement objSecID = objAllTDs.get(intSecIDCounter-1).findElement(By.tagName("a"));
							strSecID = objSecID.getText();
							
							//Price
							WebElement objPrice = objAllTDs.get(intPriceCounter-1);
							strPrice = objPrice.getText();
							
							blnSecIdPriceCaptured = true;
							break;
						}
					} catch (Exception e) {
						blnSecIdPriceCaptured = false;
						continue;
					}
				}else{
					strError = strError + " Error capturing Security ID and Price from Account assets MF Positions";
					return false;
				}
			}
			return blnSecIdPriceCaptured;
		} catch (Exception e) {
			strError = strError + " Error capturing Security ID and Price from Account assets MF Positions table. Details: " + e.getMessage();
			return blnSecIdPriceCaptured;
		}
	}
	
	/**
	 * captureSecID_Price_YahooFin : This method is to Capture a Security ID and its Price mentioned in Public finance websites like finance.yahoo.com
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-14-2017
	 * @param strFinanceYahooWebsite - The Yahoo finance Website in which we want to check the price of the Security ID
	 * @return boolean true if Capture is successful and false if failed
	 */
	public boolean captureSecID_Price_YahooFin(String strFinanceYahooWebsite){
		try {
			//Go to the Public Website
			driver.navigate().to(strFinanceYahooWebsite);
			
			//Press enter on the Windows pop up asking to leave the page or not
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			//Wait for the Yahoo finance page to load since waitForWebElement is throwing error
			LPLCoreSync.staticWait(lplCoreConstents.FAIRINMILLISEC);
			
			//Wait for search Box to appear
			WebElement objSearchBox = LPLCoreUtil.waitForWebElement(lplCoreConstents.FAIR, By.xpath(strFinYahooSearchBox_XPATH));
			objSearchBox.sendKeys(strSecID);
			
			/*//Click on Search
			WebElement objSearchBtn = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.id(strFinYahooSearchBtn_id));
			objSearchBtn.click();*/
			
			//Press enter on the Windows pop up asking to leave the page or not
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			//Wait for Quote Info to appear
			WebElement objQuoteInfo = LPLCoreUtil.waitForWebElement(lplCoreConstents.FAIR, By.id(strFinYahooQuoteInfo_id));
			
			//Capturing the Price from Yahoo Finance Web site
			WebElement objPrice = objQuoteInfo.findElement(By.xpath(strFinYahooQuotePrice_XPATH));
			strPriceYahoo = objPrice.getText();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			strError = strError + " Error Capturing the Price of a Security ID from Yahoo finance website. Error details: " + e.getMessage();
			return false;
		}
	}
	
	/**
	 * comparePrices : This method is to Compare the Price captured from Public finance websites and BranchNet Account Assets page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-14-2017
	 * @param None
	 * @return boolean true if both are equal and false if failed
	 */
	public boolean comparePrices(){
		try {
			//Converting Captured Prices to double
			Double dblBNPrice = Double.parseDouble(strPrice);
			Double dblYahooPrice = Double.parseDouble(strPriceYahoo);	
			
			//If Both prices are equal, return true
			if(LPLCoreUtil.roundDoubleValue(dblBNPrice, 2) == LPLCoreUtil.roundDoubleValue(dblYahooPrice, 2)){
				return true;
			}else{
				strError = strError + "Price of a Security ID from Yahoo finance website and BN Account Assets page are not equal";
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			strError = strError + " Error Comparing the Price of a Security ID from Yahoo finance website and BN Account Assets page. Error details: " + e.getMessage();
			return false;
		}
	}
	
	/**
	 * setSearchCriteriaMFAccounts : This method is set search Criteria in Account Browse Page with MF Accounts
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-20-2017
	 * @param strRepID - Rep ID to search with, strSponsorAccountNumber - Account number to search For
	 * @return boolean True if search criteria is set successfully and False if failed
	 */
	public boolean setSearchCriteriaMFAccounts(String strRepID, String strSponsorAccountNumber){
		try {
			//Enter Rep ID
			WebElement objRepSearchTextBox = driver.findElement(By.id(strRepSearchTextBox_id));
			objRepSearchTextBox.sendKeys(strRepID);
			
			//UnCheck LPL Accounts checkBox
			WebElement objLPLAccts_chk = driver.findElement(By.id(strLPLAcctsCheckBox_id));
			if(objLPLAccts_chk.isSelected()){
				objLPLAccts_chk.click();
			}
			
			//Check MF Accounts checkBox
			WebElement objMFAccts_chk = driver.findElement(By.id(strMFAcctsCheckBox_id));
			if(!objMFAccts_chk.isSelected()){
				objMFAccts_chk.click();
			}
			
			//Enter Sponsor Account number
			WebElement objSponsorAccountNumTextBox = driver.findElement(By.id(strSponsorAccountNum_id));
			objSponsorAccountNumTextBox.sendKeys(strSponsorAccountNumber);
			
			//Wait for the account frame to load
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			
			return true;
		} catch (Exception e) {
			strError = strError + " Problem Navigating to the MF Acct specified. Error text: " + e.getMessage();
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * navToMFAcctFromResults : This method is to navigate from Account search results to an MF Account page by clicking Sponsor account number
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-20-2017
	 * @param strSponsorAcctColumnText - Sponsor account number column text displayed in the table header
	 * @return boolean true if navigated successfully and false if failed
	 */
	public boolean navToMFAcctFromResults(String strSponsorAcctColumnText){
		boolean blnMFProfileTableFound = false;
		try {
			//Looping through the actual column headers
			boolean blnSponsorAcctColFound = false;
			boolean blnSponsorAcNumLinkFound = false;
			int intCounter = 0;
			
			//Get the Header columns list
			List<WebElement> objResultHeaders = LPLCoreUtil.waitForListOfWebElements(lplCoreConstents.BASE, By.xpath(strResultHeaders2_xpath),By.xpath(strResultHeaders_xpath));
			for(WebElement thisResultHeader: objResultHeaders){
				intCounter = intCounter+1;
				if(strSponsorAcctColumnText.trim().equalsIgnoreCase(thisResultHeader.getText().trim())){
					blnSponsorAcctColFound= true;
					break;
				}
			}
			
			//If the Sponsor Account number Column is found, then try to click
			if(blnSponsorAcctColFound){
				List<WebElement> objAllTRs = objWholeResultsGrid.findElements(By.tagName("tr"));
				for (WebElement thisTR : objAllTRs) {
					try {
						//Get the Current Window handle and click on the LPL Account number Link if found
						WebElement objSponsorAcNumLink = thisTR.findElement(By.xpath(".//td["+(intCounter+1)+"]/a"));
						blnSponsorAcNumLinkFound = true;
						objSponsorAcNumLink.click();
						
						//Wait for the new frame to load
						LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
						
						//Switch back frames and switch to Account assets tab
						driver.switchTo().defaultContent();
						driver.switchTo().frame(strParentFrame);
						WebElement objAssetsFrame = driver.findElement(By.xpath(strAccountAssetsIframe_XPATH));
						driver.switchTo().frame(objAssetsFrame);
						
						//After Clicking on the Account number, wait for Account Assets page to load
						LPLCoreSync.waitTillVisible(driver, By.id(strMFProfileSummaryPanel_id ), LPLCoreConstents.getInstance().BaseInMiliSec);
						if (LPLCoreSync.waitTillVisible(driver, By.id(strMFProfileSummaryPanel_id), LPLCoreConstents.getInstance().BaseInMiliSec)){
							blnMFProfileTableFound = true;
							break;
						}
					}catch(Exception e){
						blnSponsorAcNumLinkFound= false;
						blnMFProfileTableFound = false;
						continue;
					}
				}
				//Fail the method if Sponsor Account number Link is not found in any row of search results
				if(!blnSponsorAcNumLinkFound){
					strError = strError + " Sponsor Account number Link not found in any row of search results in Account Browse Accounts page";
					return false;
				}
				return blnMFProfileTableFound;
			}else{
				strError = strError + " Sponsor Account number Column not found in search results of Account Browse Accounts page.";
				return false;
			}
		}catch(Exception e){
			strError = strError + e.getMessage();
			return false;
		}
	}
	
	/**
	 * captureSymbol_NAV_MFProfile : This method is to Capture a Symbol and its NAV mentioned in MF Profile page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-20-2017
	 * @param strSponsorAccountNumber - Sponsor Account number
	 * @return boolean true if Capture is successful and false if failed
	 */
	public boolean captureSymbol_NAV_MFProfile(String strSponsorAccountNumber){
		boolean blnSymbolCaptured = false, blnNAVCaptured = false;
		try {
			//Switch back frames and switch to Account assets tab
			driver.switchTo().defaultContent();
			driver.switchTo().frame(strParentFrame);
			WebElement objAssetsFrame = driver.findElement(By.xpath(strAccountAssetsIframe_XPATH));
			driver.switchTo().frame(objAssetsFrame);
			
			//Verify if MF Profile Summary table found, if yes, capture Symbol and NAV
			WebElement objMFProfSummaryGrid = LPLCoreUtil.waitForWebElement(lplCoreConstents.FAIR, By.id(strMFProfileSummaryPanel_id));
			
			//Verify if the Sponsor account number is same as what we searched for in the Acct browse page
			if(objMFProfSummaryGrid.findElement(By.id(strFundAcctNum_id)).getText().equalsIgnoreCase(strSponsorAccountNumber)){
				//If yes, try to capture Symbol
				try {
					WebElement objSymbol = objMFProfSummaryGrid.findElement(By.id(strSymbolCUSIP_id));
					if(objSymbol.getText().contains("-")){
						strSecID = objSymbol.getText().split("-")[0].trim();
					}
					blnSymbolCaptured = true;
				} catch (Exception e) {
					strError = strError + " Error capturing Symbol from MF Profile page. Details: " + e.getMessage();
					blnSymbolCaptured = false;
				}
				
				//Capture NAV
				try {
					WebElement objNAV = objMFProfSummaryGrid.findElement(By.id(strNAV_id));
					if(!objNAV.getText().isEmpty()){
						strPrice = objNAV.getText();
					}
					driver.switchTo().defaultContent();
					blnNAVCaptured = true;
				} catch (Exception e) {
					strError = strError + " Error capturing NAV from MF Profile page. Details: " + e.getMessage();
					blnNAVCaptured = false;
				}
				
				//If Both Symbol and NAV are captured, then return true
				if (blnSymbolCaptured && blnNAVCaptured) {
					return true;
				}else{
					strError = strError + " Error capturing Symbol NAV from MF Profile page.";
					return false;
				}
			}else{
				strError = strError + " Not navigated to correct sponsor account.";
				return false;
			}
		} catch (Exception e) {
			strError = strError + " Error capturing Symbol NAV from MF Profile page. Details: " + e.getMessage();
			return false;
		}
	}
}

package PageObjectLibrary;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.WebToolKit.SelectDropDown;


/**
 * <p>
 * <br><b> Title: </b> AccountBrowse_TransactionsPage.java</br>
 * <br><b> Description: </B> Page Object Library For BranchNet - Account Browse - Transactions Tab</br>
 * <br> Usage:This file is put in here for usage by different projects (Universal S&G and TSHD)</br>
 * @author Aiswarya Srinivasan
 * @since 08-18-2016 
 * </p>
 */
public class AccountBrowse_TransactionsPage extends AccountBrowse_Common{

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;

	/**Variables to hold values of Missing and Found columns*/
	public String strFoundColumns = "";
	public String strMissingColumns = "";

	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strIframe_XPATH							= ".//iframe[2]";

	public String strTabDiv_Xpath 							= "//*[@class='mainContent transactions']";

	public String strRepSearchPanel_id						= "ctl00_cph_repSearch";

	public String strRepDropDown_id							= "ctl00_cph_repSearch_DropDownList";

	public String strSearchButton_id						= "dvIcon_ctl00_cph_btnSearch";

	public String strFilterTransactionsPanel_id				= "ctl00_cph_panelFilterTransactions";

	public String strGroupCriteriaPanel_id					= "ctl00_cph_panelGroupCriteria";

	public String strLPLAccountsPanel_id					= "ctl00_cph_panelLPLAccounts";

	public String strDBAccountsPanel_id						= "ctl00_cph_panelDirectBusiness";

	public String strUnofficialHistoricalPanel_id			= "ctl00_cph_panelUnofficialHistorical";

	//Added on 11/24/2016 - Aiswarya
	public String strClearButton_id							= "dvIcon_ctl00_cph_btnClear";

	public String strDateRangeComboBoxArrow_id				= "ctl00_cph_comboBoxDateRangeFilter_Arrow";

	public String strDateRangeDDList_xpath					= "//div[@id='ctl00_cph_comboBoxDateRangeFilter_DropDown']/div/ul/li";

	public String strSymbolTextBox_id						= "ctl00_cph_textBoxSymbol";

	public String strNumberOfResults_xpath					= ".//tbody/tr/td";

	public String strResultHeaders_xpath					= ".//tbody/tr[2]/th/a";

	public String strTransactionsTabLink_id					= "ctl00_ContentPlaceHolder1_transactionsTab_tabCell";

	public String strTransactionsSection_AssetTab_id		= "ctl00_ContentPlaceHolder1_transactionsTab";

	//added by Darshana 12/27
	public String strYTDTab_id								= "ctl00_ContentPlaceHolder1_activity_filterYTDButton";

	public String strGetTransButton_id             		 	= "ctl00_ContentPlaceHolder1_activity_getActivityButton";

	public String strTranTableRow_xpath 					= "(//table[@id='ctl00_ContentPlaceHolder1_activity_activityCallbackPanel_lplActivityGrid']//td[text()='K']//parent::tr)[1]";

	public String strIframe3_XPATH							= ".//iframe[3]";
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */

	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;

	/** Current Page ID from FARM */
	public final int INT_PAGEID = 122;

	public String[][] allObjects = null;

	public AccountBrowse_TransactionsPage(WebDriver driver){
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

			if (PageObjectsMap.get("strFilterTransactionsPanel").get("ID") != null)
				strFilterTransactionsPanel_id = PageObjectsMap.get("strFilterTransactionsPanel").get("ID");

			if (PageObjectsMap.get("strGroupCriteriaPanel").get("ID") != null)
				strGroupCriteriaPanel_id = PageObjectsMap.get("strGroupCriteriaPanel").get("ID");

			if (PageObjectsMap.get("strLPLAccountsPanel").get("ID") != null)
				strLPLAccountsPanel_id = PageObjectsMap.get("strLPLAccountsPanel").get("ID");

			if (PageObjectsMap.get("strDBAccountsPanel").get("ID") != null)
				strDBAccountsPanel_id = PageObjectsMap.get("strDBAccountsPanel").get("ID");

			if (PageObjectsMap.get("strUnofficialHistoricalPanel").get("ID") != null)
				strUnofficialHistoricalPanel_id = PageObjectsMap.get("strUnofficialHistoricalPanel").get("ID");

			if (PageObjectsMap.get("strYTDTab").get("ID") != null)
				strYTDTab_id = PageObjectsMap.get("strYTDTab").get("ID");

			if (PageObjectsMap.get("strGetTransButton").get("ID") != null)
				strGetTransButton_id = PageObjectsMap.get("strGetTransButton").get("ID");

			if (PageObjectsMap.get("strTranTableRow").get("ID") != null)
				strTranTableRow_xpath = PageObjectsMap.get("strTranTableRow").get("ID");

			if (PageObjectsMap.get("strTransactionsTabLink").get("ID") != null)
				strTransactionsTabLink_id = PageObjectsMap.get("strTransactionsTabLink").get("ID");
			
			if (PageObjectsMap.get("strResultHeaders").get("XPATH") != null)
				strResultHeaders_xpath = PageObjectsMap.get("strResultHeaders").get("XPATH");
			
			if (PageObjectsMap.get("strClearButton").get("ID") != null)
				strClearButton_id = PageObjectsMap.get("strClearButton").get("ID");
			
			if (PageObjectsMap.get("strNumberOfResults").get("XPATH") != null)
				strNumberOfResults_xpath = PageObjectsMap.get("strNumberOfResults").get("XPATH");
			
			if (PageObjectsMap.get("strSymbolTextBox").get("ID") != null)
				strSymbolTextBox_id = PageObjectsMap.get("strSymbolTextBox").get("ID");
			
			if (PageObjectsMap.get("strTransactionsSection_AssetTab").get("ID") != null)
				strTransactionsSection_AssetTab_id = PageObjectsMap.get("strTransactionsSection_AssetTab").get("ID");
			
			if (PageObjectsMap.get("strDateRangeComboBoxArrow").get("ID") != null)
				strDateRangeComboBoxArrow_id = PageObjectsMap.get("strDateRangeComboBoxArrow").get("ID");
			
			if (PageObjectsMap.get("strDateRangeComboBoxArrow").get("XPATH") != null)
				strDateRangeDDList_xpath = PageObjectsMap.get("strDateRangeComboBoxArrow").get("XPATH");
			
			if (PageObjectsMap.get("strIframe3").get("XPATH") != null)
				strIframe3_XPATH = PageObjectsMap.get("strIframe3").get("XPATH");
			
			String[][] allPageObjects = {
					{strRepSearchPanel_id,"Rep Search Panel","ID"},
					{strRepDropDown_id,"Rep Dropdown","ID"},
					{strSearchButton_id,"Search Button","ID"},
					{strFilterTransactionsPanel_id,"Filter Transactions Panel", "ID"},
					{strLPLAccountsPanel_id,"LPL Accounts Panel","ID"}};

			this.allObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of AccountBrowse_TransactionsPage Class", "Object should be successfully created of AccountBrowse_TransactionsPage class", "Failed to fetch the objects of AccountBrowse_TransactionsPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}

	/**
	 * setSearchCriteriaTransactions : This method is set search Criteria in Transactions Page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-22-2016
	 * @param strRepID = Rep ID to search with
	 * @return boolean True if search criteria is set successfully and False if failed
	 */
	public boolean setSearchCriteriaTransactions(String strRepID,String strDateRangeOption,String strSymbol){
		try {
			//Enter Rep ID
			WebElement objRepSearchTextBox = driver.findElement(By.id(strRepSearchTextBox_id));
			objRepSearchTextBox.sendKeys(strRepID);

			//Creating object for Select Drop down class from LPL Core driver
			SelectDropDown sdd = new SelectDropDown(driver, By.id(strDateRangeComboBoxArrow_id));

			//Select Date Range under Filter Transactions based on criteria Below
			sdd.selectInputDropDownByValue(By.id(strDateRangeComboBoxArrow_id),By.xpath(strDateRangeDDList_xpath),strDateRangeOption);

			//Enter CUSIP Value
			WebElement objSymbolTextBox = driver.findElement(By.id(strSymbolTextBox_id));
			objSymbolTextBox.sendKeys(strSymbol);

			return true;
		} catch (Exception e) {
			strError = strError + " Problem setting the Search Criteria of Aggregate Transactions page";
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * SearchAndValidateTransactions : This method is to Search and validate the results in Transactions page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-24-2016
	 * @param strExpectedColumns - Expected Column header header names in a comma separated single string
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean SearchAndValidateTransactions(String strExpectedColumns){
		boolean blnResult1 = false;
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
				if (blnThisValueFound & blnResult1) {
					return true;
				}else{
					strError = strError + " Search Results validation failed for Transactions page. Details: Expected Columns: " + strExpectedColumns+ " Actual Columns: " + strActualHeaderList + "; Page links and Number of results badge might also be missing ";
					return false;
				}
			}else{
				strError = strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Transactions page";
				return false;
			}
		} catch (Exception e) {
			strError = strError + " Problem validating Search results of Transactions page";
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * verifyAccountAssetsTransactions : This method is to Click on LPL Account number link in the Transactions search results and verify if Assets page and Transactions section loaded
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-22-2016
	 * @param strLPLAcctNumberColumnText - LPL Account number column label as expected in the application
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean verifyAccountTransactions(String strLPLAcctNumberColumnText){
		boolean blnAcctAssetsTransactionsTableFound = false;
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
							LPLCoreSync.waitTillVisible(driver, By.id(strTransactionsTabLink_id), LPLCoreConstents.getInstance().BaseInMiliSec);
							driver.findElement(By.id(strTransactionsTabLink_id)).click();
							LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
							if (LPLCoreSync.waitTillVisible(driver, By.id(strTransactionsSection_AssetTab_id), LPLCoreConstents.getInstance().BaseInMiliSec)) {
								blnAcctAssetsTransactionsTableFound = true;
							}
							break;
						} catch (Exception e) {
							blnLPLAcNumLinkFound = false;
						}
					}
					//Fail the method if LPL Account number Link is not found in any row of search results
					if(!blnLPLAcNumLinkFound){
						strError = strError + " LPL Account number Link not found in any row of search results in Transactions page";
						return false;
					}
					//If Account assets page loaded and the Transactions section loaded, then Pass the method
					if (blnAcctAssetsTransactionsTableFound) {
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
					strError = strError + " LPL Account number Column not found in search results of Transactions page.";
					return false;
				}
			}else{
				strError = strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Transactions page";
				return false;
			}
		} catch (Exception e) {
			strError = strError + e.getMessage();
			return false;
		}
	}



	/**
	 * Click on Transaction tab and fetch the transactions.
	 * 
	 * @author Darshana Borade
	 * @version 1.0
	 * @since 12/27/2016
	 * @param 
	 * @return boolean - True/False
	 */

	public boolean fetchTransaction(){
		boolean blnResult = false;

		try{
			//Click on Transactions tab.
			driver.findElement(By.id(strTransactionsTabLink_id)).click();

			//Under Accounts Transactions section , click on YTD & Get Transactions.
			WebElement ele = driver.findElement(By.id(strYTDTab_id));
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("return arguments[0].scrollIntoView();",ele);

			ele.click();
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			driver.findElement(By.id(strGetTransButton_id)).click();

			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);

			blnResult = true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}

	/**Verify details (Activity,Quantity,Security Id & Price) on the row having Equities symbol.
	 * 
	 * @author Darshana Borade
	 * @version 1.0
	 * @since 12/27/2016
	 * @param strEqsymbol - Equity symbol whose details are to be verified.
	 * @return boolean - True/False
	 */

	public boolean verifyRowDetails(String strEqsymbol){
		boolean blnResult = false;

		try{

			BNCommon bnCommon = new BNCommon(driver);
			String strTableRowsXpath1 = strTranTableRow_xpath.replace("SIRI", strEqsymbol);
			String strActivity = strTableRowsXpath1+"//td[2]";
			String strQty = strTableRowsXpath1+"//td[3]";
			String strSecurityID = strTableRowsXpath1+"//td[5]";
			String strPrice = strTableRowsXpath1+"//td[7]";

			String rowObjects[][] = {
					{strActivity,"Equity symbol activity","xpath"},
					{strQty,"Equity symbol Quantity","xpath"},
					{strSecurityID,"Equity symbol Security ID","xpath"},
					{strPrice,"Equity symbol price","xpath"}
			};

			//Verify if all the above objects present in the row.
			bnCommon.verifyPageObjects(rowObjects);

			blnResult = true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}

}

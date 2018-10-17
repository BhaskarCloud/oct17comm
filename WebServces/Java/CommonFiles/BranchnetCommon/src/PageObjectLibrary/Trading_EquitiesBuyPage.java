package PageObjectLibrary;

import java.util.HashMap;

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
 * <br><b> Title: </b> Trading_EquitiesBuyPage.java</br>
 * <br><b> Description: </B> Page Object Library For Trading - Equities - Buy page</br>
 * @author Aiswarya Srinivasan, Rahul Agarwal
 * @since 09-14-2016 
 * @modified 09-23-2016
 * </p>
 */
public class Trading_EquitiesBuyPage extends BNCommon{

	/** Web Driver Reference */
	public WebDriver driver;

	BNCommon bnCommon = new BNCommon(driver);

	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;

	/**Array for Holding objects to check or verify in the Sanity scripts */
	public String[][] allObjects;
	public String[][] allObjectsAfterSearch;
	public String[][] allObjectsBalancesPositions;		
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strPageTitle_XPATH					= "//*[@class='PageTitle']";

	public String strRepSearchPanel_ID					= "ctl00_ContentPlaceHolder1_repSearch_Panel"; 

	public String strRepSearchDD_ID 					= "ctl00_ContentPlaceHolder1_repSearch_DropDownList";

	public String strRepSearchTextBox_ID				= "ctl00_ContentPlaceHolder1_repSearch_TextBox";

	public String strLPLAccountsPanel_ID 				= "ctl00_ContentPlaceHolder1_panelLPLAccounts";

	public String strGreenTextBoldLabel_xpath 			= "//*[@id='ctl00_ContentPlaceHolder1_labelAction' and text()='Equity Buy']";

	public String strSelectTradingAction_ID 			= "ctl00_ContentPlaceHolder1_panelActions";

	public String strOtherActionsPanel_ID 				= "ctl00_ContentPlaceHolder1_panelOtherActions";

	public String strMarketDataLink_ID					= "ctl00_ContentPlaceHolder1_linkMarketData";

	public String strFixedIncomeNRLink_ID				= "ctl00_ContentPlaceHolder1_linkFixedIncomeNews";

	public String strBalancesPositionsRadio_ID			= "ctl00_ContentPlaceHolder1_radioBalances";

	public String strSearchButton_ID					= "dvIcon_ctl00_ContentPlaceHolder1_btnSearch";

	public String strSearchResultsTable_ID				= "ctl00_ContentPlaceHolder1_resultsGrid_ctl00_Header";

	public String strBalancesPositionsLinkinGrid_XPATH	= "//*[@id='ctl00_ContentPlaceHolder1_resultsGrid_ctl00__2']/td[7]/a";

	public String strBalancesPositionsHeader_XPATH 		= "//span[text()='Trading Balances and Positions']";

	public String strSummaryHeader_ID			        = "ctl00_ContentPlaceHolder1_summary1_headerLabel";

	public String strLPLAccountPanel_CSS			    = "tr td>fieldset";

	public String strAccountPositionsPanel_ID			= "ctl00_ContentPlaceHolder1_positions_positionsCallbackPanel";

	public String strAccountBalancesPanel_XPATH			= "(//div[@class='CollapsiblePanel_Blue'])[1]";

	public String strBalancesPositionsLink_XPATH		= "//a[text()='Balances/Positions']";

	public String strLPLAccNumSearchTextBox_ID			= "ctl00_ContentPlaceHolder1_textBoxAccountNumber";

	public String strBalancesPositionsLabelHeader_XPATH	= "//span[text()='Balances and Positions - Account xxx']";

	public String strShareQuantity_ID					= "txtShares";

	public String strSymbolText_ID						= "txtSymbol";

	public String strUnsolicitedRadioBtn_ID				= "rbSolicitDescr2";

	public String strPreSubmitBtn_ID					= "btnPreSubmit";

	public String strAccountNumber_ID					= "ctlAccountInfo_lblAcctNumData";

	public String strRepID_ID							= "ctlAccountInfo_lblRepIDData";

	public String strShareQty_ID						= "ctlOrderReceiptInfo_lblQuantityData";

	public String strSymbol_ID							= "ctlOrderReceiptInfo_lblSymbolData";

	public String strSendOrderBtn_ID					= "btnSendOrder";

	public String strMandatoryText_CSS					= ".InstructionText";

	/** ------------------------------------------------End of Page Objects------------------------------------------------ */

	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;

	/** Current Page ID from FARM */
	public final int INT_PAGEID = 196;

	public Trading_EquitiesBuyPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();

		try {
			/** Fetching the PageObjects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
					.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

			if (PageObjectsMap.get("strPageTitle").get("XPATH") != null){
				strPageTitle_XPATH = PageObjectsMap.get("strPageTitle").get("XPATH");
			}

			if (PageObjectsMap.get("strRepSearchPanel").get("ID") != null){
				strRepSearchPanel_ID = PageObjectsMap.get("strRepSearchPanel").get("ID");
			}

			if (PageObjectsMap.get("strRepSearchDD").get("ID") != null){
				strRepSearchDD_ID = PageObjectsMap.get("strRepSearchDD").get("ID");
			}

			if (PageObjectsMap.get("strRepSearchTextBox").get("ID") != null){
				strRepSearchTextBox_ID = PageObjectsMap.get("strRepSearchTextBox").get("ID");
			}

			if (PageObjectsMap.get("strLPLAccountsPanel").get("ID") != null){
				strLPLAccountsPanel_ID = PageObjectsMap.get("strLPLAccountsPanel").get("ID");
			}

			if (PageObjectsMap.get("strGreenTextBoldLabel").get("XPATH") != null){
				strGreenTextBoldLabel_xpath = PageObjectsMap.get("strGreenTextBoldLabel").get("XPATH");
			}

			if (PageObjectsMap.get("strSelectTradingAction").get("ID") != null){
				strSelectTradingAction_ID = PageObjectsMap.get("strSelectTradingAction").get("ID");
			}

			if (PageObjectsMap.get("strOtherActionsPanel").get("ID") != null){
				strOtherActionsPanel_ID = PageObjectsMap.get("strOtherActionsPanel").get("ID");
			}

			if (PageObjectsMap.get("strMarketDataLink").get("ID") != null){
				strMarketDataLink_ID = PageObjectsMap.get("strMarketDataLink").get("ID");
			}

			if (PageObjectsMap.get("strFixedIncomeNRLink").get("ID") != null){
				strFixedIncomeNRLink_ID = PageObjectsMap.get("strFixedIncomeNRLink").get("ID");
			}

			if (PageObjectsMap.get("strBalancesPositionsRadio").get("ID") != null){
				strBalancesPositionsRadio_ID = PageObjectsMap.get("strBalancesPositionsRadio").get("ID");
			}

			if (PageObjectsMap.get("strSearchButton").get("ID") != null){
				strSearchButton_ID = PageObjectsMap.get("strSearchButton").get("ID");
			}

			if (PageObjectsMap.get("strSearchResultsTable").get("ID") != null){
				strSearchResultsTable_ID = PageObjectsMap.get("strSearchResultsTable").get("ID");
			}

			if (PageObjectsMap.get("strBalancesPositionsLinkinGrid").get("XPATH") != null){
				strBalancesPositionsLinkinGrid_XPATH = PageObjectsMap.get("strBalancesPositionsLinkinGrid").get("XPATH");
			}

			if (PageObjectsMap.get("strBalancesPositionsHeader").get("XPATH") != null){
				strBalancesPositionsHeader_XPATH = PageObjectsMap.get("strBalancesPositionsHeader").get("XPATH");
			}

			if (PageObjectsMap.get("strSummaryHeader").get("ID") != null){
				strSummaryHeader_ID = PageObjectsMap.get("strSummaryHeader").get("ID");
			}

			if (PageObjectsMap.get("strLPLAccountPanel").get("CSS") != null){
				strLPLAccountPanel_CSS = PageObjectsMap.get("strLPLAccountPanel").get("CSS");
			}

			if (PageObjectsMap.get("strAccountPositionsPanel").get("ID") != null){
				strAccountPositionsPanel_ID = PageObjectsMap.get("strAccountPositionsPanel").get("ID");
			}

			if (PageObjectsMap.get("strAccountBalancesPanel").get("XPATH") != null){
				strAccountBalancesPanel_XPATH = PageObjectsMap.get("strAccountBalancesPanel").get("XPATH");
			}

			if (PageObjectsMap.get("strBalancesPositionsLink").get("XPATH") != null){
				strBalancesPositionsLink_XPATH = PageObjectsMap.get("strBalancesPositionsLink").get("XPATH");
			}

			if (PageObjectsMap.get("strLPLAccNumSearchTextBox").get("ID") != null){
				strLPLAccNumSearchTextBox_ID = PageObjectsMap.get("strLPLAccNumSearchTextBox").get("ID");
			}

			if (PageObjectsMap.get("strBalancesPositionsLabelHeader").get("XPATH") != null){
				strBalancesPositionsLabelHeader_XPATH = PageObjectsMap.get("strBalancesPositionsLabelHeader").get("XPATH");
			}

			if (PageObjectsMap.get("strShareQuantity").get("ID") != null){
				strShareQuantity_ID = PageObjectsMap.get("strShareQuantity").get("ID");
			}

			if (PageObjectsMap.get("strSymbolText").get("ID") != null){
				strSymbolText_ID = PageObjectsMap.get("strSymbolText").get("ID");
			}

			if (PageObjectsMap.get("strUnsolicitedRadioBtn").get("ID") != null){
				strUnsolicitedRadioBtn_ID = PageObjectsMap.get("strUnsolicitedRadioBtn").get("ID");
			}

			if (PageObjectsMap.get("strPreSubmitBtn").get("ID") != null){
				strPreSubmitBtn_ID = PageObjectsMap.get("strPreSubmitBtn").get("ID");
			}

			if (PageObjectsMap.get("strAccountNumber").get("ID") != null){
				strAccountNumber_ID = PageObjectsMap.get("strAccountNumber").get("ID");
			}

			if (PageObjectsMap.get("strRepID").get("ID") != null){
				strRepID_ID = PageObjectsMap.get("strRepID").get("ID");
			}

			if (PageObjectsMap.get("strShareQty").get("ID") != null){
				strShareQty_ID = PageObjectsMap.get("strShareQty").get("ID");
			}

			if (PageObjectsMap.get("strSymbol").get("ID") != null){
				strSymbol_ID = PageObjectsMap.get("strSymbol").get("ID");
			}

			if (PageObjectsMap.get("strSendOrderBtn").get("ID") != null){
				strSendOrderBtn_ID = PageObjectsMap.get("strSendOrderBtn").get("ID");
			}

			if (PageObjectsMap.get("strMandatoryText").get("CSS") != null){
				strMandatoryText_CSS = PageObjectsMap.get("strMandatoryText").get("CSS");
			}
			String[][] allPageObjects = {
					{strPageTitle_XPATH,"Page Header","XPATH"},
					{strRepSearchPanel_ID,"Rep Search Panel","ID"},
					{strRepSearchDD_ID,"Rep Search Dropdown","ID"},
					{strLPLAccountsPanel_ID,"LPL Accounts Panel","ID"},
					{strGreenTextBoldLabel_xpath,"Green Text Bold label with the trading appropriate page","XPATH"},
					{strSelectTradingAction_ID,"Select Trading Action Panel","ID"},
					{strOtherActionsPanel_ID,"Other Actions Panel","ID"},
					{strMarketDataLink_ID,"Market Data Link","ID"},
					{strFixedIncomeNRLink_ID,"Fixed Income New and research link","ID"}};

			String[][] allPageObjectsAfterSearch = {
					{strSearchResultsTable_ID,"Page Header","XPATH"},
					{strBalancesPositionsLinkinGrid_XPATH,"Rep Search Panel","ID"}};

			String[][] allPageObjectsBalancesPositions = {
					{strBalancesPositionsHeader_XPATH,"Page Header","XPATH"},
					{strSummaryHeader_ID,"Summary Header","ID"},
					{strLPLAccountPanel_CSS,"LPL Account Panel","CSS"},
					{strAccountPositionsPanel_ID,"Account Positions Panel","ID"},
					{strAccountBalancesPanel_XPATH,"Account Balances Panel","XPATH"}};

			this.allObjects = allPageObjects;
			this.allObjectsAfterSearch = allPageObjectsAfterSearch;
			this.allObjectsBalancesPositions = allPageObjectsBalancesPositions;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of Trading_EquitiesBuyPage Class", "Object should be successfully created of Trading_EquitiesBuyPage class", "Failed to fetch the objects of Trading_EquitiesBuyPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}

	public boolean verifySearchingBalancesPositions(String strRepID){
		try {
			//Click on Balances/Positions Radio button in Other Actions Panel
			WebElement objBalancesPositionsRadio = driver.findElement(By.id(strBalancesPositionsRadio_ID));
			objBalancesPositionsRadio.click();

			//Wait for page to load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);

			//Enter Rep ID
			WebElement objRepID = driver.findElement(By.id(strRepSearchTextBox_ID));
			objRepID.sendKeys(strRepID);

			// Click on Search
			WebElement objSearchButton = driver.findElement(By.id(strSearchButton_ID));
			objSearchButton.click();

			//Wait for Search Results to load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec+lplCoreConstents.BaseInMiliSec+lplCoreConstents.BaseInMiliSec);

			//Verify if the Search Results table is loaded and Balances/Positions Link is available in the right corner of first result row
			WebElement objSearchResults = driver.findElement(By.id(strSearchResultsTable_ID));
			objSearchResults.findElement(By.xpath(strBalancesPositionsLinkinGrid_XPATH));
			return true;
		} catch (Exception e) {
			bnCommon.strError = this.strError;
			return false;
		}
	}

	public boolean selectBalancesPositions(){
		try {

			//Click on Balances/Positions Radio button in Other Actions Panel
			WebElement objBalancesPositionsRadio = driver.findElement(By.id(strBalancesPositionsRadio_ID));
			objBalancesPositionsRadio.click();

			return true;
		} catch (Exception e) {
			bnCommon.strError = this.strError;
			return false;

		}
	}

	public boolean validateAcctNum(String strLPLAccountNumber){
		try {

			//Wait for page to load
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);

			//Validate the Summary Header label Account Number 
			driver.findElement(By.xpath(strBalancesPositionsLabelHeader_XPATH.replace("xxx", strLPLAccountNumber)));
			return true;
		} catch (Exception e) {
			bnCommon.strError = this.strError;
			return false;

		}
	}	

	/**
	 * Method to Enter Share Quantity and Symbol and Pre Submit the request. 
	 * 
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 05-26-2016
	 * @param String strShareQty - Share Quantity
	 * 			String strSymbol - Symbol
	 * @return boolean - True/False
	 */
	public boolean equitiesMidTransition(String strShareQty, String strSymbol){
		boolean blnResult = false;
		try{
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);

			//Enter Quantity
			driver.findElement(By.id(strShareQuantity_ID)).sendKeys(strShareQty);

			//Enter Symbol
			driver.findElement(By.id(strSymbolText_ID)).sendKeys(strSymbol);

			//Select Radio button
			driver.findElement(By.id(strUnsolicitedRadioBtn_ID)).click();

			//Click Pre-Submit
			driver.findElement(By.id(strPreSubmitBtn_ID)).click();

			blnResult = true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}

	/**
	 * Method to Validate the data in Equity Order Entry Page after Pre-Submit. 
	 * 
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 05-26-2016
	 * @param String strRepID - Rep ID
	 * 			String strLPLAccountNumber - Account Number
	 * 			String strShareQty - Share Quantity
	 * 			String strSymbol - Symbol
	 * 			strMandatoryText - Mandatory Text
	 * @return boolean - True/False
	 */
	public boolean validateEquitiesOrderEntryPage(String strRepId, String strAccountNumber, String strShareQuantity, String strSymbol, String strMandatoryText){
		boolean blnResult = false;

		try{
			WebElement accountNumber = driver.findElement(By.id(strAccountNumber_ID));
			WebElement repID = driver.findElement(By.id(strRepID_ID));
			WebElement shareQty = driver.findElement(By.id(strShareQty_ID));
			WebElement symbol = driver.findElement(By.id(strSymbol_ID));
			WebElement sendOrderBtn = driver.findElement(By.id(strSendOrderBtn_ID));
			WebElement mandatoryText = driver.findElement(By.cssSelector(strMandatoryText_CSS));

			//Validate the text on Equity Order Entry Page after Pre-Submit
			if((accountNumber.getText()).equals(strAccountNumber) && (repID.getText()).equals(strRepId) &&
					(shareQty.getText()).equals(strShareQuantity) && (symbol.getText()).equals(strSymbol) &&
					sendOrderBtn.isDisplayed() && (mandatoryText.getText()).equalsIgnoreCase(strMandatoryText)){
				blnResult = true;
			}
			else
				blnResult = false;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}

	/**
	 * Method to Validate the trade edit message on Equity Order Entry Page after Pre-Submit. 
	 * 
	 * @author Darshana Borade
	 * @version 1.0
	 * @since 12/20/2016
	 * @param   String strTradeEditMsg - Trade Edit Message
	 * @return boolean - True/False
	 */
	public boolean validateEquitiesOrderEntryPageTradeEdit(String strTradeEditMsg){
		boolean blnResult = false;

		try{
			WebElement tradeEditTxt = driver.findElement(By.id("ctlOrderValidation_lplFirstError"));

			//Validate the trade edit message on Equity Order Entry Page after Pre-Submit
			if(tradeEditTxt.getText().equals(strTradeEditMsg)){
				blnResult = true;
			}
			else
				blnResult = false;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}

}
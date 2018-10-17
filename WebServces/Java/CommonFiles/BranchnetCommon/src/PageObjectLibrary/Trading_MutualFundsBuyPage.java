package PageObjectLibrary;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import PageObjectLibrary.Trading_Common;

/**
 * <p>
 * <br><b> Title: </b> Trading_MutualFundsBuyPage.java</br>
 * <br><b> Description: </B> Page Object Library For Trading_MutualFundsBuyPage</br>
 * @author Aiswarya Srinivasan
 * @since 09-17-2016 
 * </p>
 */
public class Trading_MutualFundsBuyPage extends BNCommon{

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;

	/**Array for Holding objects to check or verify in the Sanity scripts */
	public String[][] allObjects;

	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strPageTitle_XPATH					= "//*[@class='PageTitle']";

	public String strRepSearchPanel_ID					= "ctl00_ContentPlaceHolder1_repSearch_Panel"; 

	public String strRepSearchDD_ID 					= "ctl00_ContentPlaceHolder1_repSearch_DropDownList";

	public String strLPLAccountsPanel_ID 				= "ctl00_ContentPlaceHolder1_panelLPLAccounts";

	public String strGreenTextBoldLabel_xpath 			= "//*[@id='ctl00_ContentPlaceHolder1_labelAction' and text()='Mutual Fund Buy']";

	public String strSelectTradingAction_ID 			= "ctl00_ContentPlaceHolder1_panelActions";

	public String strOtherActionsPanel_ID 				= "ctl00_ContentPlaceHolder1_panelOtherActions";

	public String strMarketDataLink_ID					= "ctl00_ContentPlaceHolder1_linkMarketData";

	public String strFixedIncomeNRLink_ID				= "ctl00_ContentPlaceHolder1_linkFixedIncomeNews";

	public String strCusipSymbol_XPATH					= "//input[@name='CusipSymbol']";

	public String strAmount_XPATH						= "//input[@name='Dollars']";

	public String strPresubmitButton_XPATH				= "//img[@name='presubmit']";

	public String strSolicitedInstructions_ID  		    = "SolDiscretionary_2";

	public String strMFOrderOptions_XPATH				= "//td[contains(text(),'xxx')]";

	public String strSubmitBtn_XPATH					= "//img[@name='submitorder']";

	public String strPreSubmitPanel_XPATH				= "//legend[text()='Pre-Submit']";

	public String strSymbol_XPATH						= "//b[text()='xxx']";

	public String strDiscountCalculationBtn_ID  		= "btnBreakpointButton";
	
	public String strROATable_XPATH  					= "//tr[@id='trLOIROAControls']/td/table";
	
	public String strCalculationReviewedBtn_ID  		= "btnCalcReviewed";
	
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */

	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;

	/** Current Page ID from FARM */
	public final int INT_PAGEID = 217;

	public Trading_MutualFundsBuyPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();

		try {
			/** Fetching the PageObjects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
					.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

			if (PageObjectsMap.get("strPageTitle").get("XPATH") != null){
				strPageTitle_XPATH = PageObjectsMap.get("strPageTitle").get(
						"XPATH");
			}

			if (PageObjectsMap.get("strRepSearchPanel").get("ID") != null){
				strRepSearchPanel_ID = PageObjectsMap.get("strRepSearchPanel").get("ID");
			}

			if (PageObjectsMap.get("strRepSearchDD").get("ID") != null){
				strRepSearchDD_ID = PageObjectsMap.get(
						"strRepSearchDD").get("ID");
			}

			if (PageObjectsMap.get("strLPLAccountsPanel").get("ID") != null){
				strLPLAccountsPanel_ID = PageObjectsMap.get(
						"strLPLAccountsPanel").get("ID");
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

			if (PageObjectsMap.get("strCusipSymbol").get("XPATH") != null){
				strCusipSymbol_XPATH = PageObjectsMap.get("strCusipSymbol").get("XPATH");
			}

			if (PageObjectsMap.get("strAmount").get("XPATH") != null){
				strAmount_XPATH = PageObjectsMap.get("strAmount").get("XPATH");
			}

			if (PageObjectsMap.get("strPresubmitButton").get("XPATH") != null){
				strPresubmitButton_XPATH = PageObjectsMap.get("strPresubmitButton").get("XPATH");
			}

			if (PageObjectsMap.get("strMFOrderOptions").get("XPATH") != null){
				strMFOrderOptions_XPATH = PageObjectsMap.get("strMFOrderOptions").get("XPATH");
			}

			if (PageObjectsMap.get("strSolicitedInstructions").get("ID") != null){
				strSolicitedInstructions_ID = PageObjectsMap.get("strSolicitedInstructions").get("ID");
			}

			if (PageObjectsMap.get("strSubmitBtn").get("XPATH") != null){
				strSubmitBtn_XPATH = PageObjectsMap.get("strSubmitBtn").get("XPATH");
			}

			if (PageObjectsMap.get("strPreSubmitPanel").get("XPATH") != null){
				strPreSubmitPanel_XPATH = PageObjectsMap.get("strPreSubmitPanel").get("XPATH");
			}

			if (PageObjectsMap.get("strSymbol").get("XPATH") != null){
				strSymbol_XPATH = PageObjectsMap.get("strSymbol").get("XPATH");
			}

			if (PageObjectsMap.get("strDiscountCalculationBtn").get("ID") != null){
				strDiscountCalculationBtn_ID = PageObjectsMap.get("strDiscountCalculationBtn").get("ID");
			}
			
			if (PageObjectsMap.get("strCalculationReviewedBtn").get("ID") != null){
				strCalculationReviewedBtn_ID = PageObjectsMap.get("strCalculationReviewedBtn").get("ID");
			}
			
			if (PageObjectsMap.get("strROATable").get("XPATH") != null){
				strROATable_XPATH = PageObjectsMap.get("strROATable").get("XPATH");
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
					{strFixedIncomeNRLink_ID,"Fixed Income News and research link","ID"}};

			this.allObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of Trading_MutualFundsBuyPage Class", "Object should be successfully created of Trading_MutualFundsBuyPage class", "Failed to fetch the objects of Trading_MutualFundsBuyPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}

	/**
	 * Method to Enter Amount, Symbol and Pre Submit the request. 
	 * 
	 * @author Sunitha
	 * @version 1.0
	 * @since 12-08-2016
	 * @param String strCusipSymbol - Symbol
	 * 		  String strAmount - Amount
	 * @return boolean - True/False
	 */
	public boolean mutualFundsMidTransaction(String strCusipSymbol, String strAmount, String strIframe){
		boolean blnResult = false;
		try {
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			
			//Enter Symbol/Cusip ID
			driver.findElement(By.xpath(strCusipSymbol_XPATH)).sendKeys(strCusipSymbol);
			
			//Enter Amount
			driver.findElement(By.xpath(strAmount_XPATH)).sendKeys(strAmount);
			
			LPLCoreSync.staticWait(lplCoreConstents.UNITINMILLISEC);
			try{
				//Check Whether Discount Calculation Button is Displayed or not
				if(driver.findElement(By.id(strDiscountCalculationBtn_ID)).isDisplayed()){
					
					//Get the Parent Window
					String strParentHandle = driver.getWindowHandle();
					
					//Click on Discount Calculation Button
					driver.findElement(By.id(strDiscountCalculationBtn_ID)).click();
					LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					
					//Get all the Window Handles
					Set<String> arrAllHandles = driver.getWindowHandles();
			        
					//Switch to Child Window 
					if (arrAllHandles.size()>1) {
			               for (String currentHandle : arrAllHandles) {
			                      if (!currentHandle.trim().equalsIgnoreCase(strParentHandle.trim())) {
			                             driver.switchTo().window(currentHandle);
			                             blnResult = true;
			                             break;
			                      }
			               }      
			        }
					
					//Click on Calculation Reviewed Button in Child Window
					if(driver.findElement(By.id(strCalculationReviewedBtn_ID)).isDisplayed()){
						driver.findElement(By.id(strCalculationReviewedBtn_ID)).click();
						LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					}
					
					//Switch to Parent Window
					driver.switchTo().window(strParentHandle);
					LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					
					//Switching to Default Frames
					Trading_Common tradCommon  = new Trading_Common(driver);
					
					driver.switchTo().frame(tradCommon.strParentFrame_NAME);
					WebElement objIFrame = driver.findElement(By.xpath(tradCommon.strIFrame_XPATH.replace("2", strIframe)));
					driver.switchTo().frame(objIFrame);
					driver.switchTo().frame(tradCommon.strcontentFrame_NAME);
					LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					
					//Check ROA Table is displayed or not
					JavascriptExecutor js = ((JavascriptExecutor) driver);
					js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strROATable_XPATH)));
					if(driver.findElement(By.xpath(strROATable_XPATH)).isDisplayed()){
						blnResult = true;
						}
					}
				} catch (Exception e) {
				
					blnResult = true;
				}
			//Click Unsolicited (Non-Discretionary) Instructions
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id(strSolicitedInstructions_ID)));
			
			LPLCoreSync.staticWait(lplCoreConstents.UNITINMILLISEC);
			driver.findElement(By.id(strSolicitedInstructions_ID)).click();
			
			// Click on Presubmit Button
			LPLCoreSync.staticWait(lplCoreConstents.MEDIUM);
			driver.findElement(By.xpath(strPresubmitButton_XPATH)).click();
			blnResult = true;
			
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}

	/**
	 * Method to Validate the data in Mutual Funds Order Confirmation Page after Pre-Submit. 
	 * 
	 * @author Sunitha
	 * @version 1.0
	 * @since 12-08-2016
	 * @param String strRepId - Rep ID
	 * 		  String strLPLAccountNumber - Account Number
	 * 		  String strAmount - Amount
	 * 		  String strSymbol - Symbol
	 * @return boolean - True/False
	 */

	public boolean validateMFOrderEntryPage(String strRepId, String strLPLAccountNumber, String strAmount, String strSymbol){
		boolean blnResult = false;
		try {
			//Wait for page to load
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);

			//Verifies Rep Id, Account Number, Amount, Symbol, Submit and Presubmit Panel in Order Confirmation page
			if(driver.findElement(By.xpath(strMFOrderOptions_XPATH.replace("xxx", strRepId))).isDisplayed() && 
					driver.findElement(By.xpath(strMFOrderOptions_XPATH.replace("xxx", strLPLAccountNumber))).isDisplayed() &&
					driver.findElement(By.xpath(strSymbol_XPATH.replace("xxx", strAmount))).isDisplayed() &&
					driver.findElement(By.xpath(strMFOrderOptions_XPATH.replace("xxx", strSymbol))).isDisplayed() &&
					driver.findElement(By.xpath(strSubmitBtn_XPATH)).isDisplayed() &&
					driver.findElement(By.xpath(strPreSubmitPanel_XPATH)).isDisplayed()){
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
	 * Method to Validate the data in Mutual Funds Order Confirmation Page after Pre-Submit. 
	 * 
	 * @author Sunitha
	 * @version 1.0
	 * @since 12-08-2016
	 * @param String strRepId - Rep ID
	 * 		  String strLPLAccountNumber - Account Number
	 * 		  String strAmount - Amount
	 * 		  String strSymbol - Symbol
	 * @return boolean - True/False
	 */

	public boolean validateMFOrderEntryPageTradeEdit(String strErrorText){
		boolean blnResult = false;
		try {
			//Wait for page to load
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);

			String TradeEditxpath = "//b[text()='MUTUAL FUNDS ONLINE TRADING CONFIRMATION']//parent::font//parent::th//parent::tr//following-sibling::tr/td/b";
			WebElement tradeEditTxt = driver.findElement(By.xpath(TradeEditxpath));


			if(tradeEditTxt.getText().equals(strErrorText)){
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

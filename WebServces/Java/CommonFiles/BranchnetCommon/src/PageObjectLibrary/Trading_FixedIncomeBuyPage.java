package PageObjectLibrary;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;

/**
 * <p>
 * <br><b> Title: </b> Trading_FixedIncomeBuyPage.java</br>
 * <br><b> Description: </B> Page Object Library For Trading - Fixed iNcome - Buy page</br>
 * @author Aiswarya Srinivasan
 * @since 09-17-2016 
 * </p>
 */
public class Trading_FixedIncomeBuyPage extends BNCommon{
	
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
	
	public String strGreenTextBoldLabel_xpath 			= "//*[@id='ctl00_ContentPlaceHolder1_labelAction' and text()='Fixed Income Buy']";
	
	public String strSelectTradingAction_ID 			= "ctl00_ContentPlaceHolder1_panelActions";
	
	public String strOtherActionsPanel_ID 				= "ctl00_ContentPlaceHolder1_panelOtherActions";
	
	public String strMarketDataLink_ID					= "ctl00_ContentPlaceHolder1_linkMarketData";
	
	public String strFixedIncomeNRLink_ID				= "ctl00_ContentPlaceHolder1_linkFixedIncomeNews";
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 216;
	
	public Trading_FixedIncomeBuyPage(WebDriver driver){
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
			LPLCoreReporter.WriteReport("Initialization of Trading_FixedIncomeBuyPage Class", "Object should be successfully created of Trading_FixedIncomeBuyPage class", "Failed to fetch the objects of Trading_FixedIncomeBuyPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
}

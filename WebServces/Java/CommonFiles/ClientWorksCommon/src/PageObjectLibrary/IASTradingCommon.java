package PageObjectLibrary;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.paulhammant.ngwebdriver.ByAngular;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;
import LPLCoreDriver.WebToolKit.SelectDropDown;

/**
 * <p>
 * <br><b> Title: </b> IASTradingCommon.java</br>
 * <br><b> Description: </B> verifies Trading pages</br>
 * <br><b>Usage:</br></b>
 * <br>1. clickOnElement: This method is used to click on any element by using Java script executor click or normal click</br>
 * <br>2. performContextOrActionDropdown: This Method is used to perform mouse hover java script operation on any menu. </br>
 * <br>3. performDiscountCalculation: This Method is used to verify discount calculation</br>
 * <br>4. fixedIncomeSearchCriteria: This Method is used to enter the search criteria to validate fixed Income buy page. </br>
 * @author Sunitha Appaiah
 * @since 10-11-2017
 * </p>
 */
public class IASTradingCommon extends LPLCoreDriver{
	
	public WebDriver driver;
	HomePage homePage =  new HomePage(driver);
	ClientManagement_AccountsTab cmAccountsTab	= new ClientManagement_AccountsTab(driver);
	
	/**-------------------------------------Constants----------------------------------------*/
	public static final String CALCULATIONREVIEWED	= "Calculation Reviewed";
	public static final String SEARCH				= "Search";
	
	/**-----------------------------------Test Objects for Mutual Funds Buy Page------------------------------*/
	public String strMutualFundsBuy_XPATH 			= "//*[contains(@class,'ng-binding ng-scope') and text()='xxx']";
	public String strActions_CSS					= ".btn.btn-default.btn-drop-shadow.dropdown-toggle.dropdown-menu-right.ng-binding";
	public String strSymbolSearchbox_ID				= "equitySymbol";
	public String strAmount_ID						= "numamount";
	public String strUnsolicited_ID					= "unsolicited";
	public String strReviewOrder_CSS				= ".btn.btn-primary.pull-right.ng-scope";
	public String strAmountValue_XPATH				= "//section[@class='clearfix']//div[text()='xxx']";
	public String strSymboltext_XPATH				= "//security-search//input[@value='xxx']";
	public String strPlaceOrderbtn_CSS				= ".btn.btn-success.ng-binding";
	public String strBuyTicketHeader_XPATH			= "//ticket-header//span[contains(text(),'xxx')]";
	public String strUnsolicitedtext_XPATH			= ".//*[@id='order-acceptance']//span[text()='Unsolicited']";
	public String strCancelbtn_CSS					= ".btn.btn-default.pull-left.ng-scope";
	public String strCancelOrder_CSS				= "#tradingMainContainer .btn.btn-primary";
	public String strCalculateDiscountbtn_CSS		= ".btn.btn-primary.discountbtn.ng-scope";
	public String strSalesChargeHeader_CSS			= ".ng-scope>div>h3";
	public String strCalculationReviewed_CSS		= ".btn.btn-primary.pull-right";
	public String strCalculationReviewedTable_CSS	= ".table.table-bordered.lpl-table.ng-scope";
	
	/**-----------------------------------Test Objects for Equity Page------------------------------*/
	public String strShareQuantity_CSS				=".share-quantity input";
	public String strEquityBuyTicketHeader_XPATH	= "//ticket-header//div[contains(text(),'xxx')]";
	
	/**-----------------------------------Test Objects for Annuties Page------------------------------*/
	public String strCancelButton_Xpath						= "//input[@class='ABANDONANDEXITButton']";
	public String strShowAllBtn_Id							= "ctl08_ctl02_ctl03_ctl06_ctl02_btnShowAll";
	public String strEditButton_Xpath						= "(//input[@class='dataControl EDIT'])[1]";
	public String strAnnuitySearchPanel_Id					= "SearchPanelTable";
	public String strAnnuityOrderTabsContainer_xpath			= "//div[@class='fullWidth WizardTabsContainer ADMTabContainer Title']";
	public String strAnnuityOrderContentContainer_xpath		= "//div[@class='fullWidth WizardContentContainer ADMTabContent']";
	public String strAnnuityTitle_XPATH						= ".//div[@class='hidden-sm hidden-xs navbar-text pull-left cwNavbar-application-title ng-binding' and text()='xxx']";
	
	/**-----------------------------------Test Objects for Fixed Income Buy Page------------------------------*/
	public String strFrame_Id						= "externContent";
	public String strAllProducts_XPATH				= "//button[text()='xxx']";
	public String strSearchButton_Xpath				= "//button[text()='Search']";
	public String strMaximumYearsDDList_XPATH 		= "//*[@class='x-combo-list-item']";
	public String strAllProductsFIBuyBtn_XPATH		= "//img[@class='class-buy-cell']";
	public String strOrderTicketTitle_XPATH			= "//*[text()='xxx']";
	public String strCloseOrderTicket_XPATH			= "//div[@class='x-window-header x-window-header-noborder x-unselectable x-window-draggable']//div[@class='x-tool x-tool-close']";
	public String strMaximumYearsComboBoxList_XPATH = "//*[@class='x-form-field-wrap x-form-field-trigger-wrap x-abs-layout-item']/input[@name='matTo']";
	
	
	public String[][] allAOEObjects = null;
	public String strError=null;
	
	/** Current Page ID from FARM */
	public static final int INTPAGEID =  461;
	public static final int INTPAGEID1 = 415;
	
	public IASTradingCommon(WebDriver driver) {
		this.driver =driver;
		try{
			
			/** Fetching the page objects from FARM */
			HashMap<String, HashMap<String, String>> pageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INTPAGEID, new LPLConfig().getEnvId());
			HashMap<String, HashMap<String, String>> pageObjectsMap1 = LPLCoreDBConnect.getObjectsFromDB(INTPAGEID1, new LPLConfig().getEnvId());
			
			if(pageObjectsMap.get("strMutualFundsBuy").get(LPLCoreConstents.XPATH)!= null)
				strMutualFundsBuy_XPATH = pageObjectsMap.get("strMutualFundsBuy").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strActions").get(LPLCoreConstents.CSS)!= null)
				strActions_CSS = pageObjectsMap.get("strActions").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strSymbolSearchbox").get(LPLCoreConstents.ID)!= null)
				strSymbolSearchbox_ID = pageObjectsMap.get("strSymbolSearchbox").get(LPLCoreConstents.ID);
			
			if(pageObjectsMap.get("strAmount").get(LPLCoreConstents.ID)!= null)
				strAmount_ID = pageObjectsMap.get("strAmount").get(LPLCoreConstents.ID);
			
			if(pageObjectsMap.get("strUnsolicited").get(LPLCoreConstents.ID)!= null)
				strUnsolicited_ID = pageObjectsMap.get("strUnsolicited").get(LPLCoreConstents.ID);
			
			if(pageObjectsMap.get("strReviewOrder").get(LPLCoreConstents.CSS)!= null)
				strReviewOrder_CSS = pageObjectsMap.get("strReviewOrder").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strPlaceOrderbtn").get(LPLCoreConstents.CSS)!= null)
				strPlaceOrderbtn_CSS = pageObjectsMap.get("strPlaceOrderbtn").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strCancelbtn").get(LPLCoreConstents.CSS)!= null)
				strCancelbtn_CSS = pageObjectsMap.get("strCancelbtn").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strCancelOrder").get(LPLCoreConstents.CSS)!= null)
				strCancelOrder_CSS = pageObjectsMap.get("strCancelOrder").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strAmountValue").get(LPLCoreConstents.XPATH)!= null)
				strAmountValue_XPATH = pageObjectsMap.get("strAmountValue").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strSymboltext").get(LPLCoreConstents.XPATH)!= null)
				strSymboltext_XPATH = pageObjectsMap.get("strSymboltext").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strBuyTicketHeader").get(LPLCoreConstents.XPATH)!= null)
				strBuyTicketHeader_XPATH = pageObjectsMap.get("strBuyTicketHeader").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strUnsolicitedtext").get(LPLCoreConstents.XPATH)!= null)
				strUnsolicitedtext_XPATH = pageObjectsMap.get("strUnsolicitedtext").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strAnnuityTitle").get(LPLCoreConstents.XPATH)!= null)
				strAnnuityTitle_XPATH = pageObjectsMap.get("strAnnuityTitle").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strCalculateDiscountbtn").get(LPLCoreConstents.CSS)!= null)
				strCalculateDiscountbtn_CSS = pageObjectsMap.get("strCalculateDiscountbtn").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strSalesChargeHeader").get(LPLCoreConstents.CSS)!= null)
				strSalesChargeHeader_CSS = pageObjectsMap.get("strSalesChargeHeader").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strCalculationReviewed").get(LPLCoreConstents.CSS)!= null)
				strCalculationReviewed_CSS = pageObjectsMap.get("strCalculationReviewed").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strCalculationReviewedTable").get(LPLCoreConstents.CSS)!= null)
				strCalculationReviewedTable_CSS = pageObjectsMap.get("strCalculationReviewedTable").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strShareQuantity").get(LPLCoreConstents.CSS)!= null)
				strShareQuantity_CSS = pageObjectsMap.get("strShareQuantity").get(LPLCoreConstents.CSS);
			
			if(pageObjectsMap.get("strEquityBuyTicketHeader").get(LPLCoreConstents.XPATH)!= null)
				strEquityBuyTicketHeader_XPATH = pageObjectsMap.get("strEquityBuyTicketHeader").get(LPLCoreConstents.XPATH);
			
			if (pageObjectsMap1.get("strCancelButton").get(LPLCoreConstents.XPATH) != null)
				strCancelButton_Xpath = pageObjectsMap1.get("strCancelButton").get(LPLCoreConstents.XPATH);
			
			if (pageObjectsMap1.get("strShowAllBtn").get(LPLCoreConstents.ID) != null)
				strShowAllBtn_Id = pageObjectsMap1.get("strShowAllBtn").get(LPLCoreConstents.ID);
			
			if (pageObjectsMap1.get("strEditButton").get(LPLCoreConstents.XPATH) != null)
				strEditButton_Xpath = pageObjectsMap1.get("strEditButton").get(LPLCoreConstents.XPATH);
			
			if (pageObjectsMap1.get("strAnnuitySearchPanel").get(LPLCoreConstents.ID) != null)
				strAnnuitySearchPanel_Id = pageObjectsMap1.get("strAnnuitySearchPanel").get(LPLCoreConstents.ID);
			
			if (pageObjectsMap1.get("strAnnuityOrderTabsContainer").get(LPLCoreConstents.XPATH) != null)
				strAnnuityOrderTabsContainer_xpath = pageObjectsMap1.get("strAnnuityOrderTabsContainer").get(LPLCoreConstents.XPATH);
			
			if (pageObjectsMap1.get("strAnnuityOrderContentContainer").get(LPLCoreConstents.XPATH) != null)
				strAnnuityOrderContentContainer_xpath = pageObjectsMap1.get("strAnnuityOrderContentContainer").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strFrame").get(LPLCoreConstents.ID)!= null)
				strFrame_Id = pageObjectsMap.get("strFrame").get(LPLCoreConstents.ID);
			
			if(pageObjectsMap.get("strAllProducts").get(LPLCoreConstents.XPATH)!= null)
				strAllProducts_XPATH = pageObjectsMap.get("strAllProducts").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strSearchButton").get(LPLCoreConstents.XPATH)!= null)
				strSearchButton_Xpath = pageObjectsMap.get("strSearchButton").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strMaximumYearsDDList").get(LPLCoreConstents.XPATH)!= null)
				strMaximumYearsDDList_XPATH = pageObjectsMap.get("strMaximumYearsDDList").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strAllProductsFIBuyBtn").get(LPLCoreConstents.XPATH)!= null)
				strAllProductsFIBuyBtn_XPATH = pageObjectsMap.get("strAllProductsFIBuyBtn").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strOrderTicketTitle").get(LPLCoreConstents.XPATH)!= null)
				strOrderTicketTitle_XPATH = pageObjectsMap.get("strOrderTicketTitle").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strCloseOrderTicket").get(LPLCoreConstents.XPATH)!= null)
				strCloseOrderTicket_XPATH = pageObjectsMap.get("strCloseOrderTicket").get(LPLCoreConstents.XPATH);
			
			if(pageObjectsMap.get("strMaximumYearsComboBoxList").get(LPLCoreConstents.XPATH)!= null)
				strMaximumYearsComboBoxList_XPATH = pageObjectsMap.get("strMaximumYearsComboBoxList").get(LPLCoreConstents.XPATH);
			
			
		String[][] allAOEPageObjects = {{strAnnuityOrderTabsContainer_xpath, "Buy Annuity Tabs", LPLCoreConstents.XPATH},
									{strAnnuityOrderContentContainer_xpath, "Buy Annuity Content", LPLCoreConstents.XPATH}};
									
		
		this.allAOEObjects =allAOEPageObjects;
		
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			LPLCoreReporter.WriteReport("Initialization of trading common page", "Object should be successfully created for trading common page", "Failed to create the object of trading common page. Error:"+ex.toString(), "Failed", "");
		}
	}
	
	/**
	 * This method is used to click on any element by using Java script executor click or normal click
	 * @author  Sunitha Appaiah
	 * @since   09-26-2017
	 * @parameter byLocator - To click on any By locator 
	 * @return  boolean true/false
	 */
	public boolean clickOnElement(By byLocator){
		boolean blnResult = false;
		try{
			//wait for page loading
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			try {
				//Java Executor click on by locator
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",driver.findElement(byLocator));
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
				blnResult =true;
			
			} catch(Exception ex){
				//Normal click on By locator
				driver.findElement(byLocator).click();
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
				blnResult=true;
			}
		return blnResult;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
		}
	}

	/**
	 * performContextOrActionDropdown: This Method is used to perform mouse hover java script operation on any menu
	 * @param strMainMenu - Main menu, strSubMenu - Sub menu, bySubMenu1 - By locator foer multi sub menu, byContextOrActionbtn - By Locator for Context Menu or Action Dropdown
	 * @return boolean - True/False
	 * @author Sunitha Appaiah
	 * @since 09-26-2017
	 */
	public boolean performContextOrActionDropdown(String strMainMenu, String strSubMenu1 ,String strSubMenu2, By byContextOrActionbtn){
		boolean blnResult =false;
		try {
			
			//Click on Context menu or Actions Menu button
			clickOnElement(byContextOrActionbtn);

			if(!(strSubMenu1==null || strSubMenu1.equals("")) || !(strSubMenu2==null || strSubMenu2.equals(""))){
			
				//Mouse over to Main menu
				LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(cmAccountsTab.strMenuWith2ndLevel_CSS, strMainMenu), LPLCoreConstents.getInstance().FAIR);
				LPLCoreUtil.mouseHoverJScript(driver.findElement(ByAngular.cssContainingText(cmAccountsTab.strMenuWith2ndLevel_CSS, strMainMenu)));
				
				//Wait for page Loading
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
				
				//for multi level navigation
				if(!(strSubMenu2==null || strSubMenu2.equals(""))){
					
					//Mouse over on sub menu 
					LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(cmAccountsTab.strMenuWith2ndLevel_CSS, strSubMenu1), LPLCoreConstents.getInstance().FAIR);
					LPLCoreUtil.mouseHoverJScript(driver.findElement(ByAngular.cssContainingText(cmAccountsTab.strMenuWith2ndLevel_CSS, strSubMenu1)));
					
					//Wait for page Loading
					LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
					
					//Click on the sub menu 1 
					LPLCoreUtil.mouseHoverAndClickJScript(driver.findElement(By.xpath(strMutualFundsBuy_XPATH.replace("xxx", strSubMenu2))));
					LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
					blnResult = true;
				
				}else{
					
					//Click on the sub menu (2 - way Navigation)
					LPLCoreUtil.mouseHoverAndClickJScript(driver.findElement(By.xpath(strMutualFundsBuy_XPATH.replace("xxx", strSubMenu1))));
					LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
					blnResult = true;
				}
			}else{
				
				//Click on the Main menu (1 - Way Navigation)
				LPLCoreUtil.mouseHoverAndClickJScript(driver.findElement(By.xpath(strMutualFundsBuy_XPATH.replace("xxx", strMainMenu))));
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
				blnResult = true;
			}
			return blnResult;
		
		}catch (Exception e) {
			strError = strError+e.getMessage();
			return blnResult;
		}
	}

	/**
	 * performDiscountCalculation: This Method is used to verify discount calculation
	 * @return boolean - True/False
	 * @author Sunitha Appaiah
	 * @since 09-27-2017
	 */
	
	public boolean performDiscountCalculation(){
		boolean blnResult = false;
		try{
			//Click on Calculate discount button
			clickOnElement(By.cssSelector(strCalculateDiscountbtn_CSS));
			
			//Verify discount calculation page displays
			if(driver.findElement(ByAngular.cssContainingText(strSalesChargeHeader_CSS, "")).isDisplayed()){
				
				//Click on Calculation Reviewed button
				clickOnElement(ByAngular.cssContainingText(strCalculationReviewed_CSS, CALCULATIONREVIEWED));
				
				//Verify calculation reviewed table is displayed or not
				if(driver.findElement(By.cssSelector(strCalculationReviewedTable_CSS)).isDisplayed()){
					blnResult =true;
				}
			}
			return blnResult;
		}catch(Exception ex){
			strError =strError+ex.getMessage();
			return false;
		}
		
	}

	/**
	 * fixedIncomeSearchCriteria: This Method is used to enter the search criteria to validate fixed Income buy page
	 * @return boolean - True/False
	 * @param String strAllProductsText - All Products button text
	 * 			String strValue - Max Years value to enter in All products page
	 * @author Sunitha Appaiah
	 * @since 10-09-2017
	 */
	public boolean fixedIncomeSearchCriteria(String strAllProductsText,String strValue){
		boolean blnResult =false;
		try{
			//Wait fo page loading
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			
			//click on All products button in advanced search panel
			clickOnElement(By.xpath(strAllProducts_XPATH.replace("xxx", strAllProductsText)));
			
			//Wait fo page loading
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			
			//selecting maximum 1 from years drop down 
			SelectDropDown sdd = new SelectDropDown(driver, By.xpath(strMaximumYearsComboBoxList_XPATH));
			if(sdd.selectInputDropDownByValue(By.xpath(strMaximumYearsComboBoxList_XPATH), By.xpath(strMaximumYearsDDList_XPATH), strValue)){
				
				//click on search button
				clickOnElement(By.xpath(strSearchButton_Xpath));
				
				//Wait fo page loading
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
				blnResult = true;
			}
			return blnResult;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
		}
	}
}


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
import LPLCoreDriver.LPLCoreUtil;
import LPLCoreDriver.WebToolKit.SelectDropDown;


/**
 * <p>
 * <br><b> Title: </b> AccountBrowse_ExecutionsPage.java</br>
 * <br><b> Description: </B> Page Object Library For BranchNet - Account Browse - Executions Tab</br>
 * <br> Usage:This file is put in here for usage by different projects (Universal S&G and TSHD)</br>
 * @author Aiswarya Srinivasan
 * @since 11-24-2016 
 * </p>
 */
public class AccountBrowse_ExecutionsPage extends AccountBrowse_Common{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
		 
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strIframe_XPATH					= ".//iframe[2]";
	
	public String strTabDiv_Xpath 					= "//*[@class='mainContent executions']";
	
	public String strRepSearchPanel_id				= "ctl00_cph_repSearch";
	
	public String strRepDropDown_id					= "ctl00_cph_repSearch_DropDownList";
	
	public String strSearchButton_id				= "dvIcon_ctl00_cph_btnSearch";
	
	//Added on 11/24/2016 - Aiswarya
	public String strClearButton_id					= "dvIcon_ctl00_cph_btnClear";
	
	public String strSymbolTextBox_id				= "ctl00_cph_textBoxSymbolCusip";
	
	public String strExecutionsIFrame_id			= "frameExecutions";
	
	public String strTabLinks_xpath					= "//*[@id='ctl00_ContentPlaceHolder1_tabStrip']/div/ul/li";
	
	public String strSelectedTabs_xpath				= "//a[contains(@class,'rtsSelected')]";
	
	public String strEOSymbol_id					= "ctl00_ContentPlaceHolder1_textBoxSymbol";
	
	public String strEODateRangeArrow_id			= "ctl00_ContentPlaceHolder1_lstDateRange_Arrow";
	
	public String strEODateRangeDDList_xpath		= "//div[@id='ctl00_ContentPlaceHolder1_lstDateRange_DropDown']/div/ul/li";
	
	public String strEOFilterActionDDArrow_id 		= "ctl00_ContentPlaceHolder1_lstAction_Arrow";
	
	public String strEOFilterActionDDList_xpath		= "//div[@id='ctl00_ContentPlaceHolder1_lstAction_DropDown']/div/ul/li";
	
	public String strEOFilterExecutionsLink_id		= "ctl00_ContentPlaceHolder1_buttonSearch";
	
	public String strEOResultsGridPanel_id			= "ctl00_ContentPlaceHolder1_ctl00_ContentPlaceHolder1_resultsGridPanel";
	
	public String strFIResultsGridPanel_id			= "ctl00_ContentPlaceHolder1_ctl00_ContentPlaceHolder1_resultsGridPanel";
	
	public String strMFResultsGridPanel_id			= "ctl00_ContentPlaceHolder1_ctl00_ContentPlaceHolder1_resultsGridPanel";
	
	public String strEONoRecordsFoundPanel_id		= "ctl00_ContentPlaceHolder1_pnlNoRecordsFound";
	
	public String strFIFrame_id						= "ctl00_ContentPlaceHolder1_FIFrame";
	
	public String strFINoRecordsFoundPanel_id		= "lblNotFoundMsg";
	
	public String strMFNoRecordsFoundPanel_id		= "ctl00_ContentPlaceHolder1_pnlNoRecordsFound";
	
	public String strFICusip_id						= "txtFilterSymbol";
	
	public String strFIGetExecutions_name			= "getexecutions";
	
	public String strMFPanelReps_id					= "ctl00_ContentPlaceHolder1_panelReps";
	
	public String strMFSymbol_id					= "ctl00_ContentPlaceHolder1_textBoxSymbol";
	
	public String strMFDateRangeArrow_id			= "ctl00_ContentPlaceHolder1_lstDateRange_Arrow";
	
	public String strMFDateRangeDDList_xpath		= "//div[@id='ctl00_ContentPlaceHolder1_lstDateRange_DropDown']/div/ul/li";
	
	public String strMFFilterActionDDArrow_id 		= "ctl00_ContentPlaceHolder1_lstVSPStatus_Arrow";
	
	public String strMFVSPStatusList_xpath			= "//div[@id='ctl00_ContentPlaceHolder1_lstVSPStatus_DropDown']/div/ul/li";
	
	public String strMFFilterExecutionsLink_id		= "ctl00_ContentPlaceHolder1_buttonSearch";
	
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	public String[][] allObjects = null;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 121;
	
	public AccountBrowse_ExecutionsPage(WebDriver driver){
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
			
			if (PageObjectsMap.get("strFIFrame").get("ID") != null)
				strFIFrame_id = PageObjectsMap.get("strFIFrame").get(
						"ID");

			if (PageObjectsMap.get("strTabDiv").get("XPATH") != null)
				strTabDiv_Xpath = PageObjectsMap.get("strTabDiv").get("XPATH");

			if (PageObjectsMap.get("strRepSearchPanel").get("ID") != null)
				strRepSearchPanel_id = PageObjectsMap.get(
						"strRepSearchPanel").get("ID");
			
			if (PageObjectsMap.get("strRepDropDown").get("ID") != null)
				strRepDropDown_id = PageObjectsMap.get("strRepDropDown").get("ID");
			
			if (PageObjectsMap.get("strSearchButton").get("ID") != null)
				strSearchButton_id = PageObjectsMap.get("strSearchButton").get("ID");
			
			if (PageObjectsMap.get("strClearButton").get("ID") != null)
				strClearButton_id = PageObjectsMap.get("strClearButton").get("ID");
			
			if (PageObjectsMap.get("strSymbolTextBox").get("ID") != null)
				strSymbolTextBox_id = PageObjectsMap.get("strSymbolTextBox").get("ID");
			
			if (PageObjectsMap.get("strExecutionsIFrame").get("ID") != null)
				strExecutionsIFrame_id = PageObjectsMap.get("strExecutionsIFrame").get("ID");
			
			if (PageObjectsMap.get("strTabLinks").get("XPATH") != null)
				strTabLinks_xpath = PageObjectsMap.get("strTabLinks").get("XPATH");
			
			if (PageObjectsMap.get("strSelectedTabs").get("XPATH") != null)
				strSelectedTabs_xpath = PageObjectsMap.get("strSelectedTabs").get("XPATH");
			
			if (PageObjectsMap.get("strEOSymbol").get("ID") != null)
				strEOSymbol_id = PageObjectsMap.get("strEOSymbol").get("ID");
			
			if (PageObjectsMap.get("strEODateRangeArrow").get("ID") != null)
				strEODateRangeArrow_id = PageObjectsMap.get("strEODateRangeArrow").get("ID");
			
			if (PageObjectsMap.get("strEODateRangeDDList").get("XPATH") != null)
				strEODateRangeDDList_xpath = PageObjectsMap.get("strEODateRangeDDList").get("XPATH");
			
			if (PageObjectsMap.get("strEOFilterActionDDArrow").get("ID") != null)
				strEOFilterActionDDArrow_id = PageObjectsMap.get("strEOFilterActionDDArrow").get("ID");
			
			if (PageObjectsMap.get("strEOFilterActionDDList").get("XPATH") != null)
				strEOFilterActionDDList_xpath = PageObjectsMap.get("strEOFilterActionDDList").get("XPATH");
			
			if (PageObjectsMap.get("strEOFilterExecutionsLink").get("ID") != null)
				strEOFilterExecutionsLink_id = PageObjectsMap.get("strEOFilterExecutionsLink").get("ID");
			
			if (PageObjectsMap.get("strEOResultsGridPanel").get("ID") != null)
				strEOResultsGridPanel_id = PageObjectsMap.get("strEOResultsGridPanel").get("ID");
			
			if (PageObjectsMap.get("strFIResultsGridPanel").get("ID") != null)
				strFIResultsGridPanel_id = PageObjectsMap.get("strFIResultsGridPanel").get("ID");
			
			if (PageObjectsMap.get("strMFResultsGridPanel").get("ID") != null)
				strMFResultsGridPanel_id = PageObjectsMap.get("strMFResultsGridPanel").get("ID");
			
			if (PageObjectsMap.get("strEONoRecordsFoundPanel").get("ID") != null)
				strEONoRecordsFoundPanel_id = PageObjectsMap.get("strEONoRecordsFoundPanel").get("ID");
			
			if (PageObjectsMap.get("strFINoRecordsFoundPanel").get("ID") != null)
				strFINoRecordsFoundPanel_id = PageObjectsMap.get("strFINoRecordsFoundPanel").get("ID");
			
			if (PageObjectsMap.get("strMFNoRecordsFoundPanel").get("ID") != null)
				strMFNoRecordsFoundPanel_id = PageObjectsMap.get("strMFNoRecordsFoundPanel").get("ID");
			
			if (PageObjectsMap.get("strFICusip").get("ID") != null)
				strFICusip_id = PageObjectsMap.get("strFICusip").get("ID");
			
			if (PageObjectsMap.get("strFIGetExecutions").get("ID") != null)
				strFIGetExecutions_name = PageObjectsMap.get("strFIGetExecutions").get("ID");
			
			if (PageObjectsMap.get("strMFPanelReps").get("ID") != null)
				strMFPanelReps_id = PageObjectsMap.get("strMFPanelReps").get("ID");
			
			if (PageObjectsMap.get("strMFSymbol").get("ID") != null)
				strMFSymbol_id = PageObjectsMap.get("strMFSymbol").get("ID");
			
			if (PageObjectsMap.get("strMFDateRangeArrow").get("ID") != null)
				strMFDateRangeArrow_id = PageObjectsMap.get("strMFDateRangeArrow").get("ID");
			
			if (PageObjectsMap.get("strMFDateRangeDDList").get("XPATH") != null)
				strMFDateRangeDDList_xpath = PageObjectsMap.get("strMFDateRangeDDList").get("XPATH");
			
			if (PageObjectsMap.get("strMFFilterActionDDArrow").get("ID") != null)
				strMFFilterActionDDArrow_id = PageObjectsMap.get("strMFFilterActionDDArrow").get("ID");
			
			if (PageObjectsMap.get("strMFVSPStatusList").get("XPATH") != null)
				strMFVSPStatusList_xpath = PageObjectsMap.get("strMFVSPStatusList").get("XPATH");
			
			if (PageObjectsMap.get("strMFFilterExecutionsLink").get("ID") != null)
				strMFFilterExecutionsLink_id = PageObjectsMap.get("strMFFilterExecutionsLink").get("ID");
			
			String[][] allPageObjects = {
					{strTabDiv_Xpath,"Page Container","XPATH"},
					{strRepSearchPanel_id,"Rep Search Panel","ID"},
					{strRepDropDown_id,"Rep Drop down","ID"},
					{strSearchButton_id,"Search Button","ID"}};
			
			this.allObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of AccountBrowse_ExecutionsPage Class", "Object should be successfully created of AccountBrowse_ExecutionsPage class", "Failed to fetch the objects of AccountBrowse_ExecutionsPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	/**
	 * setSearchCriteriaExecutions : This method is set search Criteria in Executions Page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-24-2016
	 * @param strRepID = Rep ID to search with, strSymbol = Symbol to search for
	 * @return boolean True if search criteria is set successfully and False if failed
	 */
	public boolean setSearchCriteriaExecutions(String strRepID,String strSymbol){
		try {
			//Enter Rep ID
			WebElement objRepSearchTextBox = driver.findElement(By.id(strRepSearchTextBox_id));
			objRepSearchTextBox.sendKeys(strRepID);
			
			//Enter Symbol
			WebElement objSymbolTextBox = driver.findElement(By.id(strSymbolTextBox_id));
			objSymbolTextBox.sendKeys(strSymbol);
			return true;
		} catch (Exception e) {
			strError = strError + " Problem setting the Search Criteria of Aggregate Executions page";
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * SearchAndValidateExecutions : This method is to Search and validate the results in Executions page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-22-2016
	 * @param strExpectedColumns - Expected Column header header names in a comma separated single string
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean SearchAndValidateExecutions(String strExpectedTabs){
		boolean blnResult = false;
		try {
			//Click Search Button
			WebElement objSearchButton = driver.findElement(By.id(strSearchButton_id));
			objSearchButton.click();
			
			//Wait for Results Grid to Load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			
			try {
				//Switch to proper frames
				driver.switchTo().defaultContent();
				driver.switchTo().frame(strParentFrame);
				driver.switchTo().frame(driver.findElement(By.xpath(strIframe_XPATH)));
				driver.switchTo().frame(driver.findElement(By.id(strExecutionsIFrame_id)));
			} catch (Exception e1) {
				strError = strError + " Frame Switching Problem in Execution search results page.";
				return false;
			}
			
			//Click on the required tabs
			List<WebElement> objTablinks = driver.findElements(By.xpath(strTabLinks_xpath));
			for(WebElement thisTab: objTablinks){
				try {
					//get the Headers of tabs and click one by one and Verify
					WebElement thisTabLink = thisTab.findElement(By.tagName("a"));
					
					if(strExpectedTabs.contains(thisTabLink.getText())){
						blnResult = true;
					}
				} catch (Exception e) {
					strError = strError + " No tab links are displayed. Error: " + e.getMessage();
					blnResult = false;
					break;
				}
			}
			return blnResult;
		}catch(Exception e){
			strError = strError + " Search result validation failed in the Executions page. Error: "+e.getMessage();
			return false;
		}
	}
	
	/**
	 * clickTab : This method is to click any tab in Executions results
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-24-2016
	 * @param strTabName = tab name to click on
	 * @return boolean True if click is successful and False if failed
	 */
	public boolean clickTab(String strTabName){
		boolean blnResult = false;
		try{
			try {
				//Switch to proper frames
				driver.switchTo().defaultContent();
				driver.switchTo().frame(strParentFrame);
				driver.switchTo().frame(driver.findElement(By.xpath(strIframe_XPATH)));
				driver.switchTo().frame(driver.findElement(By.id(strExecutionsIFrame_id)));
			} catch (Exception e1) {
				strError = strError + " Frame Switching Problem in Execution search results page.";
				return false;
			}
			
			//Click on the required tabs
			List<WebElement> objTablinks = driver.findElements(By.xpath(strTabLinks_xpath));
			for(WebElement thisTab: objTablinks){
				try {
					//get the Headers of tabs and click one by one and Verify
					WebElement thisTabLink = thisTab.findElement(By.tagName("a"));
					if (thisTabLink.getText().trim().equalsIgnoreCase(strTabName)) {
						//Click on the Tab link
						JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", thisTabLink);
						/*if(strTabName.equalsIgnoreCase("Mutual Funds")){
							thisTabLink.click();
						}*/
						
						//Wait for Results Grid to Load
						LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
						
						blnResult = true;
						break;
					}
				} catch (Exception e) {
					strError = strError + " No tab links are displayed with text " + strTabName + ". Error: " + e.getMessage();
					blnResult = false;
					break;
				}
			}
			return blnResult;
		}catch(Exception e){
			blnResult= false;
			strError = strError + " There are no selected Tabs in the Execution search result grid. Error: "+e.getMessage();
			return blnResult;
		}
	}
	
	/**
	 * verifyEOTabExecutionResults : This method is to verify Equity and Options tab in Executions results
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-25-2016
	 * @param strExpectedTabs = tab name to click on, strSymbol = Symbol, strEODateRange = Equity and Options Date range, strEOAction = Equity and Options Action to select
	 * @return boolean True if verification is successful and False if failed
	 */
	public boolean verifyEOTabExecutionResults(String strExpectedTabs, String strSymbol,String strEODateRange,String strEOAction){
		boolean blnResult1 = false;
		try {
			blnResult1 = clickTab(strExpectedTabs.split(",")[0]);
			
			try{
				//Verify if Search results exist
				driver.findElement(By.id(strEOResultsGridPanel_id));
				
				//Enter Symbol in the Filter Panel
				WebElement objEQOptionsSymbol = driver.findElement(By
						.id(strEOSymbol_id));
				objEQOptionsSymbol.click();
				objEQOptionsSymbol.sendKeys(strSymbol);
				
				//Creating object for Select Drop down class from LPL Core driver
				SelectDropDown sdd = new SelectDropDown(driver,By.id(strEODateRangeArrow_id));
				
				//Select Date Range
				sdd.selectInputDropDownByValue(
						By.id(strEODateRangeArrow_id),
						By.xpath(strEODateRangeDDList_xpath),
						strEODateRange);
				
				//Creating object for Select Drop down class from LPL Core driver
				SelectDropDown sdd1 = new SelectDropDown(driver,
						By.id(strEOFilterActionDDArrow_id));
				
				//Select Date Range
				sdd1.selectInputDropDownByValue(
						By.id(strEOFilterActionDDArrow_id),
						By.xpath(strEOFilterActionDDList_xpath),
						strEOAction);
				
				//Click on Filter Executions Link
				WebElement objEOFilterExecutionsLink = driver
						.findElement(By.id(strEOFilterExecutionsLink_id));
				objEOFilterExecutionsLink.click();
				
				//Wait for Results Grid to Load
				LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			}catch(Exception e){
				
			}
			
			//Verify the Results Panel
			WebElement objEOResults = LPLCoreUtil.waitForWebElements(lplCoreConstents.FAIR, By.id(strEOResultsGridPanel_id),By.id(strEONoRecordsFoundPanel_id));
			
			if(blnResult1 & objEOResults.isEnabled()){
				return true;
			}else{
				strError = strError + " Error in verifying the E&O tab in Execution search results. E&O filter results empty or not displayed";
				return false;
			}
		} catch (Exception e) {
			strError = strError + " Error in verifying the E&O tab in Execution search results. Error: "+e.getMessage();
			return false;
		}
	}
	
	/**
	 * verifyFITabExecutionResults : This method is to verify Fixed Income tab in Executions results
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-25-2016
	 * @param strExpectedTabs = tab name to click on, strCUSIP = CUSIP
	 * @return boolean True if verification is successful and False if failed
	 */
	public boolean verifyFITabExecutionResults(String strExpectedTabs, String strCUSIP){
		boolean blnResult1 = false;
		try {
			blnResult1 = clickTab(strExpectedTabs.split(",")[1]);
			
			try{
				//Switch To FI Frame
				WebElement objFIFrame = driver.findElement(By.id(strFIFrame_id));
				driver.switchTo().frame(objFIFrame);
				
				//Verify if Search results exist
				driver.findElement(By.id(strFIResultsGridPanel_id));
				
				//Enter Symbol in the Filter Panel
				WebElement objFICUSIPTextBox = driver.findElement(By
						.id(strFICusip_id));
				objFICUSIPTextBox.click();
				objFICUSIPTextBox.sendKeys(strCUSIP);
				
				//Enter Symbol in the Filter Panel
				WebElement objEOGetExecutionsLink = driver
						.findElement(By.name(strFIGetExecutions_name));
				objEOGetExecutionsLink.click();
				
				//Wait for Results Grid to Load
				LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			}catch(Exception e){
				
			}
			
			//Verify the Results Panel
			WebElement objEOResults = LPLCoreUtil.waitForWebElements(lplCoreConstents.FAIR, By.id(strFIResultsGridPanel_id),By.id(strFINoRecordsFoundPanel_id));
			
			if(blnResult1 & objEOResults.isEnabled()){
				return true;
			}else{
				strError = strError + " Error in verifying the Fixed Income tab in Execution search results. Fixed Income filter results empty or not displayed";
				return false;
			}
		} catch (Exception e) {
			strError = strError + " Error in verifying the Fixed Income tab in Execution search results. Error: "+e.getMessage();
			return false;
		}
	}
	
	/**
	 * verifyMFTabExecutionResults : This method is to verify Mutual Funds tab in Executions results
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-25-2016
	 * @param strExpectedTabs = tab name to click on, strSymbol = Symbol, strMFDateRange = Mutual Funds Date range, strMFAction = Mutual Funds Action to select
	 * @return boolean True if verification is successful and False if failed
	 */
	public boolean verifyMFTabExecutionResults(String strExpectedTabs, String strSymbol,String strMFDateRange,String strMFAction){
		boolean blnResult1 = false;
		try {
			blnResult1 = clickTab(strExpectedTabs.split(",")[2]);
			
			//Wait for Tab to Load
			LPLCoreSync.staticWait(lplCoreConstents.HIGHINMILLISEC);
			
			try{
				//Verify if Search results exist
				driver.findElement(By.id(strMFResultsGridPanel_id));
				
				//Enter Symbol in the Filter Panel
				WebElement objMFSymbol = driver.findElement(By
						.id(strMFSymbol_id));
				objMFSymbol.click();
				objMFSymbol.sendKeys(strSymbol);
				
				//Creating object for Select Drop down class from LPL Core driver
				SelectDropDown sdd = new SelectDropDown(driver,
						By.id(strMFDateRangeArrow_id));
				
				//Select Date Range
				sdd.selectInputDropDownByValue(
						By.id(strMFDateRangeArrow_id),
						By.xpath(strMFDateRangeDDList_xpath),
						strMFDateRange);
				
				//Creating object for Select Drop down class from LPL Core driver
				SelectDropDown sdd1 = new SelectDropDown(driver,
						By.id(strMFFilterActionDDArrow_id));
				
				//Select Date Range
				sdd1.selectInputDropDownByValue(
						By.id(strMFFilterActionDDArrow_id),
						By.xpath(strMFVSPStatusList_xpath),
						strMFAction);
				
				//Click on Filter Executions Link
				WebElement objMFFilterExecutionsLink = driver
						.findElement(By.name(strMFFilterExecutionsLink_id));
				objMFFilterExecutionsLink.click();
				
				//Wait for Results Grid to Load
				LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			}catch(Exception e){
				
			}
			
			//Verify the Results Panel
			WebElement objEOResults = LPLCoreUtil.waitForWebElements(lplCoreConstents.FAIR, By.id(strMFResultsGridPanel_id),By.id(strMFNoRecordsFoundPanel_id));
			
			if(blnResult1 & objEOResults.isEnabled()){
				return true;
			}else{
				strError = strError + " Error in verifying the Mutual Funds tab in Execution search results. Mutual Funds filter results empty or not displayed";
				return false;
			}
		} catch (Exception e) {
			strError = strError + " Error in verifying the Mutual Funds tab in Execution search results. Error: "+e.getMessage();
			return false;
		}
	}
}

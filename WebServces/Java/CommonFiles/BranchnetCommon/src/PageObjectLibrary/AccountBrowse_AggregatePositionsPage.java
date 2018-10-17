package PageObjectLibrary;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.WebToolKit.SelectDropDown;


/**
 * <p>
 * <br><b> Title: </b> AccountBrowse_AggregatePositionsPage.java</br>
 * <br><b> Description: </B> Page Object Library For BranchNet - Account Browse - Aggregate Positions Tab</br>
 * <br> This file is put in here for usage by different projects (Universal S&G and TSHD)</br>
 * <br><b> Usage: </b></br>
 * <br> setSearchCriteriaAgPositions - Sets all search criteria for a search in BranchNet - Account Browse - Aggregate Positions Tab</br>
 * <br> SearchAndValidateAgPositions - Clicks on Search and verifies if the search results loaded</br>
 * <br> verifySecurityIDAgPositions - Clicks on Security ID in the search results and verifies if the market quote window opens</br>
 * @author Aiswarya Srinivasan
 * @since 08-29-2016 
 * @modified 11-21-2016
 * </p>
 */
public class AccountBrowse_AggregatePositionsPage extends AccountBrowse_Common{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
		 
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strIframe_XPATH						= ".//iframe[2]";
	
	public String strTabDiv_Xpath 						= "//*[@class='mainContent aggregatePositions']";
	
	public String strRepSearchPanel_id					= "ctl00_cph_repSearch_Panel";
	
	public String strRepDropDown_id						= "ctl00_cph_repSearch_DropDownList";
	
	public String strRepSearchTextBox_id				= "ctl00_cph_repSearch_TextBox";
	
	public String strClearButton_id						= "dvIcon_ctl00_cph_clearButton";
	
	public String strSearchButton_id					= "dvIcon_ctl00_cph_searchButton";
	
	public String strSecurityCriteriaPanel_id			= "ctl00_cph_securityCriteriaPanel";
	
	public String strMatchTypeComboBox_id				= "ctl00_cph_matchTypeComboBox_Input";
	
	public String strValueToMatchTextBox_id				= "ctl00_cph_valueToMatchTextBox";
	
	public String strSortingCriteriaPanel_id			= "ctl00_cph_panelSorting";
	
	//Added on 11/21/2016 - Aiswarya
	public String strMatchTypeComboBoxArrow_id 			= "ctl00_cph_matchTypeComboBox_Arrow";
	
	public String strMatchTypeDDList_xpath				= "//div[@id='ctl00_cph_matchTypeComboBox_DropDown']/div/ul/li";
	
	public String strResultsGridWholeTable_xpath		= "//table[@id='ctl00_cph_resultsGrid']";
	
	public String strNumberOfResults_xpath				= ".//tbody/tr/td";
	
	public String strPageLinks_xpath					= ".//tbody/tr[2]/td/a";
	
	public String strResultHeaders_xpath				= ".//tbody/tr[5]/th/a";
	
	public String strResultHeaders2_xpath				= ".//tbody/tr[4]/th/a";
	
	public String strQuoteTab_id						= "imgButtonQuote";
	
	public String strNewSearchBtn_ResultsPage_id		= "dvIcon_ctl00_cph_newSearchButton";
	
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 153;
	
	public String[][] allObjects = null;
	
	public String strFoundColumns = "";
	public String strMissingColumns = "";

	public AccountBrowse_AggregatePositionsPage(WebDriver driver){
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
			
			if (PageObjectsMap.get("strSecurityCriteriaPanel").get("ID") != null)
				strSecurityCriteriaPanel_id = PageObjectsMap.get("strSecurityCriteriaPanel").get("ID");
			
			if (PageObjectsMap.get("strMatchTypeComboBox").get("ID") != null)
				strMatchTypeComboBox_id = PageObjectsMap.get("strMatchTypeComboBox").get("ID");
			
			if (PageObjectsMap.get("strValueToMatchTextBox").get("ID") != null)
				strValueToMatchTextBox_id = PageObjectsMap.get("strValueToMatchTextBox").get("ID");
			
			if (PageObjectsMap.get("strSortingCriteriaPanel").get("ID") != null)
				strSortingCriteriaPanel_id = PageObjectsMap.get("strSortingCriteriaPanel").get("ID");
			
			if (PageObjectsMap.get("strClearButton").get("ID") != null)
				strClearButton_id = PageObjectsMap.get("strClearButton").get("ID");
			
			if (PageObjectsMap.get("strMatchTypeComboBoxArrow").get("ID") != null)
				strMatchTypeComboBoxArrow_id = PageObjectsMap.get("strMatchTypeComboBoxArrow").get("ID");
			
			if (PageObjectsMap.get("strMatchTypeDDList").get("XPATH") != null)
				strMatchTypeDDList_xpath = PageObjectsMap.get("strMatchTypeDDList").get("XPATH");
			
			if (PageObjectsMap.get("strResultsGridWholeTable").get("XPATH") != null)
				strResultsGridWholeTable_xpath = PageObjectsMap.get("strResultsGridWholeTable").get("XPATH");
			
			if (PageObjectsMap.get("strNumberOfResults").get("XPATH") != null)
				strNumberOfResults_xpath = PageObjectsMap.get("strNumberOfResults").get("XPATH");
			
			if (PageObjectsMap.get("strPageLinks").get("XPATH") != null)
				strPageLinks_xpath = PageObjectsMap.get("strPageLinks").get("XPATH");
			
			if (PageObjectsMap.get("strResultHeaders").get("XPATH") != null)
				strResultHeaders_xpath = PageObjectsMap.get("strResultHeaders").get("XPATH");
			
			if (PageObjectsMap.get("strResultHeaders2").get("XPATH") != null)
				strResultHeaders2_xpath = PageObjectsMap.get("strResultHeaders2").get("XPATH");
			
			if (PageObjectsMap.get("strQuoteTab").get("ID") != null)
				strQuoteTab_id = PageObjectsMap.get("strQuoteTab").get("ID");
			
			if (PageObjectsMap.get("strNewSearchBtn_ResultsPage").get("ID") != null)
				strNewSearchBtn_ResultsPage_id = PageObjectsMap.get("strNewSearchBtn_ResultsPage").get("ID");
			
			if (PageObjectsMap.get("strRepSearchTextBox").get("ID") != null)
				strRepSearchTextBox_id = PageObjectsMap.get("strRepSearchTextBox").get("ID");
			
			String[][] allPageObjects = {
				{strTabDiv_Xpath,"Page Container","XPATH"},
				{strRepSearchPanel_id,"Rep Search Panel","ID"},
				{strRepDropDown_id,"Rep Drop down","ID"},
				{strSearchButton_id,"Search Button","ID"},
				{strSecurityCriteriaPanel_id,"Security Criteria Panel","ID"},
				{strMatchTypeComboBox_id,"Match type Combo box", "ID"},
				{strValueToMatchTextBox_id,"Value to Match Text Box","ID"},
				{strSortingCriteriaPanel_id,"Sorting Criteria Panel","ID"}};
			
			this.allObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of AccountBrowse_AggregatePositionsPage Class", "Object should be successfully created of AccountBrowse_AggregatePositionsPage class", "Failed to fetch the objects of AccountBrowse_AggregatePositionsPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}

	/**
	 * setSearchCriteriaAgPositions : This method is set search Criteria in Aggregate Positions Page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-21-2016
	 * @param strRepID = Rep ID to search with, strMatchTypeOption - Match type option (Ex: Security Description), strMatchTypeValue = Match type value to match with
	 * @return boolean True if search criteria is set successfully and False if failed
	 */
	public boolean setSearchCriteriaAgPositions(String strRepID,String strMatchTypeOption, String strMatchTypeValue){
		try {
			//Enter Rep ID
			WebElement objRepSearchTextBox = driver.findElement(By.id(strRepSearchTextBox_id));
			objRepSearchTextBox.sendKeys(strRepID);
			
			//Creating object for Select Drop down class from LPL Core driver
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			SelectDropDown sdd = new SelectDropDown(driver, By.id(strMatchTypeComboBoxArrow_id));
			
			//Select the Match type option
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			sdd.selectInputDropDownByValue(By.id(strMatchTypeComboBoxArrow_id),By.xpath(strMatchTypeDDList_xpath),strMatchTypeOption);
			
			//Enter the Match value to search
			WebElement objValueToMatchTextBox = driver.findElement(By.id(strValueToMatchTextBox_id));
			objValueToMatchTextBox.click();
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
			objValueToMatchTextBox.sendKeys(strMatchTypeValue);
			return true;
		} catch (Exception e) {
			strError = strError + " Problem setting the Search Criteria of Aggregate Positions page";
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * SearchAndValidateAgPositions : This method is to Search and validate the results in Aggregate positions page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-21-2016
	 * @param strExpectedColumns - Expected Column header header names in a comma separated single string
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean SearchAndValidateAgPositions(String strExpectedColumns){
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
					//Verify the Page links in the Results Grid . page links need not be mandatorily present so This validation is not mandatory. So,Catch block has also true in it 
					List<WebElement> objPageLinks = objWholeResultsGrid.findElements(By.xpath(strPageLinks_xpath));
					if (!objPageLinks.isEmpty()) {
						for (WebElement pageLink : objPageLinks) {
							if (pageLink.getAttribute("id").contains(
									"_pageLink")) {
								blnResult2 = true;
							}
						}
					}else{
						blnResult2 = true;
					}
				} catch (Exception e) {
					blnResult2 = true;
				}
				
				List<WebElement> objResultHeaders=null;
				//Enter the Match value to search
				objResultHeaders = driver.findElements(By.xpath(strResultHeaders_xpath));
				if(objResultHeaders.isEmpty() || objResultHeaders.size()<1){
					objResultHeaders = driver.findElements(By.xpath(strResultHeaders2_xpath));
				}
				
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
					strError = strError + " Search Results validation failed for Aggregate Positions page. Details: Expected Columns: " + strExpectedColumns+ " Actual Columns: " + strActualHeaderList + "; Page links and Number of results badge might also be missing ";
					return false;
				}
			}else{
				strError = strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Aggregate Positions page";
				return false;
			}
		} catch (Exception e) {
			strError = strError + " Problem validating Search results of Aggregate Positions page";
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifySecurityIDAgPositions : This method is to Click on Security ID link in the Aggregate positions
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-21-2016
	 * @param 
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean verifySecurityIDAgPositions(String strSecurityIDColumnText){
		boolean blnQuoteWindowPresent = false;
		String strParentHandle = null;
		try {
			//Wait for Results Grid to Load
			if(LPLCoreSync.waitTillVisible(driver, By.xpath(strResultsGridWholeTable_xpath), LPLCoreConstents.getInstance().BaseInMiliSec)){
				@SuppressWarnings("unused")
				WebElement objWholeResultsGrid = driver.findElement(By.xpath(strResultsGridWholeTable_xpath));
				
				//Looping through the actual column headers
				boolean blnSecurityIDColumnFound = false;
				boolean blnSecurityIDLinkFound = false;
				int intCounter = 0;
				
				//Get the Header columns list
				List<WebElement> objResultHeaders=null;
				objResultHeaders = driver.findElements(By.xpath(strResultHeaders_xpath));
				if(objResultHeaders.isEmpty() || objResultHeaders.size()<1){
					objResultHeaders = driver.findElements(By.xpath(strResultHeaders2_xpath));
				}
				for(WebElement thisResultHeader: objResultHeaders){
					intCounter = intCounter+1;
					if(strSecurityIDColumnText.trim().equalsIgnoreCase(thisResultHeader.getText().trim())){
						LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
						JavascriptExecutor js = ((JavascriptExecutor) driver);
						js.executeScript("arguments[0].click();", thisResultHeader);
						
						LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
						blnSecurityIDColumnFound= true;
						break;
					}
				}
				
				//If the Security ID Column is found, then try to click and verify the Market quote window
				if(blnSecurityIDColumnFound){
					WebElement objWholeResultsGridAfterSort = driver.findElement(By.xpath(strResultsGridWholeTable_xpath));
					List<WebElement> objAllTRs = objWholeResultsGridAfterSort.findElements(By.tagName("tr"));
					
					for (WebElement thisTR : objAllTRs) {
						try {
							//Get the Current Window handle and click on the Security ID Link if found
							strParentHandle = driver.getWindowHandle();
							WebElement objSecurityIdLink= thisTR.findElement(By.xpath(".//td["+intCounter+"]/a"));
							blnSecurityIDLinkFound = true;
							objSecurityIdLink.click();
							LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
							
							//If Cert selection popup came, Cancel out
							LPLCoreDriver.selectCertificate();
							
							//Switch to the Market quote window if found
							Set<String> arrAllHandles = driver.getWindowHandles();
							if (arrAllHandles.size()==2) {
								for (String currentHandle : arrAllHandles) {
									if (!currentHandle.trim().equalsIgnoreCase(
											strParentHandle.trim())) {
										driver.switchTo().window(currentHandle);
										blnQuoteWindowPresent = LPLCoreSync.waitTillVisible(driver, By.id(strQuoteTab_id), LPLCoreConstents.getInstance().BaseInMiliSec);
										break;
									}
								}
							}else{
								strError = strError + " More than 2 windows open.";
							}
							break;
						} catch (Exception e) {
							blnSecurityIDLinkFound = false;
						}
					}
					//Fail the method if Security ID Link is not found in any row of search results
					if(!blnSecurityIDLinkFound){
						strError = strError + " Security ID Link not found in any row of search results in Aggregate Positions page";
						return false;
					}
					//If Quote window opened , then Pass the method
					if (blnQuoteWindowPresent) {
						driver.close();
						driver.switchTo().window(strParentHandle);
						//Switch to proper frames
						try {
							driver.switchTo().defaultContent();
							driver.switchTo().frame(strParentFrame);
							WebElement objIframe = driver.findElement(By.xpath(strIframe_XPATH));
							driver.switchTo().frame(objIframe);
						} catch (Exception e3) {
							driver.switchTo().defaultContent();
						}
						
						//Click on New Search Button
						driver.findElement(By.id(strNewSearchBtn_ResultsPage_id)).click();
						LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
						return true;
					}else{
						strError = strError + " New Quote window did not open on clicking Security ID.";
						return false;
					}
				}else{
					strError = strError + " Security ID Column not found in search results of Aggregate Positions page.";
					return false;
				}
			}else{
				strError = strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Aggregate Positions page";
				return false;
			}
		} catch (Exception e) {
			strError = strError + e.getMessage();
			return false;
		}
	}
}

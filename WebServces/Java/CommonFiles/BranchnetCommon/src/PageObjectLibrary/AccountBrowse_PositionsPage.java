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
import LPLCoreDriver.WebToolKit.SelectDropDown;


/**
 * <p>
 * <br><b> Title: </b> AccountBrowse_PositionsPage.java</br>
 * <br><b> Description: </B> Page Object Library For BranchNet - Account Browse - Positions Tab</br>
 * <br> Usage:This file is put in here for usage by different projects (Universal S&G and TSHD)</br>
 * @author Aiswarya Srinivasan
 * @since 08-25-2016 
 * </p>
 */
public class AccountBrowse_PositionsPage extends AccountBrowse_Common{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
	
	/**Variables to hold values of Missing and Found columns*/
	public String strFoundColumns = "";
	public String strMissingColumns = "";
		 
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strIframe_XPATH					= ".//iframe[2]";
	
	public String strTabDiv_Xpath 					= "//*[@class='mainContent positions']";
	
	public String strRepSearchPanel_id				= "ctl00_cph_repSearch_Panel";
	
	public String strRepDropDown_id					= "ctl00_cph_repSearch_DropDownList";
	
	public String strSearchButton_id				= "dvIcon_ctl00_cph_btnSearch";
	
	public String strLPLAccountsPanel_id			= "ctl00_cph_panelAccounts";
	
	public String strDirectBusinessPanel_id			= "ctl00_cph_panelDirectBusiness";
	
	public String strUnofficialAcctsPanel_id		= "ctl00_cph_panelUnofficial";
	
	public String strSecuritiesPositionsPanel_id 	= "ctl00_cph_panelSecurities";
	
	public String strSortingCriteriaPanel_id		= "ctl00_cph_panelSorting";
	
	//Added on 11/22/2016 - Aiswarya
	public String strSecurityTypeRadio_id			= "ctl00_cph_radioSecurityType";
	
	public String strLPLAccountsCheckBox_id			= "ctl00_cph_checkBoxIncludeLPL";
	
	public String strSecurityTypeComboBoxArrow_id 	= "ctl00_cph_dropDownListSecurityType_Arrow";
	
	public String strSecurityTypeDDList_xpath		= "//div[@id='ctl00_cph_dropDownListSecurityType_DropDown']/div/ul/li";
	
	public String strSecurityTypeValueTextBox_id	= "ctl00_cph_textBoxValueToMatch";
	
	public String strResultsGridWholeTable_xpath	= "//table[@id='ctl00_cph_resultsGrid']";
	
	public String strNumberOfResults_xpath			= ".//tbody/tr/td";
	
	public String strPageLinks_xpath				= ".//tbody/tr[3]/td/a";
	
	public String strResultHeaders_xpath			= ".//tbody/tr[3]/th/a";
	
	public String strAssetsActiveTab_xpath 			= "//td[@class='TabView TabViewActive' and @id='ctl00_ContentPlaceHolder1_assetsTab_tabCell']";
	
	public String strPositionsSection_AssetTab_id	= "ctl00_ContentPlaceHolder1_positions_positionsCallbackPanel";
	
	public String strPositionsTable_AssetTab_id		= "ctl00_ContentPlaceHolder1_positions_positionsCallbackPanel_lplPositionsGrid";
	
	public String strClearButton_id					= "dvIcon_ctl00_cph_btnClear";
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	public String[][] allObjects = null;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 145;

	public AccountBrowse_PositionsPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();
		
		try {
			/** Fetching the PageObjects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
					.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

			if (PageObjectsMap.get("strIframe").get("XPATH") != null)
				strIframe_XPATH = PageObjectsMap.get("strIframe").get("XPATH");

			if (PageObjectsMap.get("strTabDiv").get("XPATH") != null)
				strTabDiv_Xpath = PageObjectsMap.get("strTabDiv").get("XPATH");

			if (PageObjectsMap.get("strRepSearchPanel").get("ID") != null)
				strRepSearchPanel_id = PageObjectsMap.get(
						"strRepSearchPanel").get("ID");
			
			if (PageObjectsMap.get("strRepDropDown").get("ID") != null)
				strRepDropDown_id = PageObjectsMap.get("strRepDropDown").get("ID");
			
			if (PageObjectsMap.get("strSearchButton").get("ID") != null)
				strSearchButton_id = PageObjectsMap.get("strSearchButton").get("ID");
			
			if (PageObjectsMap.get("strLPLAccountsPanel").get("ID") != null)
				strLPLAccountsPanel_id = PageObjectsMap.get("strLPLAccountsPanel").get("ID");
			
			if (PageObjectsMap.get("strDirectBusinessPanel").get("ID") != null)
				strDirectBusinessPanel_id = PageObjectsMap.get("strDirectBusinessPanel").get("ID");
			
			if (PageObjectsMap.get("strUnofficialAcctsPanel").get("ID") != null)
				strUnofficialAcctsPanel_id = PageObjectsMap.get("strUnofficialAcctsPanel").get("ID");
			
			if (PageObjectsMap.get("strSecuritiesPositionsPanel").get("ID") != null)
				strSecuritiesPositionsPanel_id = PageObjectsMap.get("strSecuritiesPositionsPanel").get("ID");
			
			if (PageObjectsMap.get("strSortingCriteriaPanel").get("ID") != null)
				strSortingCriteriaPanel_id = PageObjectsMap.get("strSortingCriteriaPanel").get("ID");
			
			if (PageObjectsMap.get("strSecurityTypeRadio").get("ID") != null)
				strSecurityTypeRadio_id = PageObjectsMap.get("strSecurityTypeRadio").get("ID");
			
			if (PageObjectsMap.get("strLPLAccountsCheckBox").get("ID") != null)
				strLPLAccountsCheckBox_id = PageObjectsMap.get("strLPLAccountsCheckBox").get("ID");
			
			if (PageObjectsMap.get("strSecurityTypeComboBoxArrow").get("ID") != null)
				strSecurityTypeComboBoxArrow_id = PageObjectsMap.get("strSecurityTypeComboBoxArrow").get("ID");
			
			if (PageObjectsMap.get("strSecurityTypeDDList").get("XPATH") != null)
				strSecurityTypeDDList_xpath = PageObjectsMap.get("strSecurityTypeDDList").get("XPATH");
			
			if (PageObjectsMap.get("strSecurityTypeValueTextBox").get("ID") != null)
				strSecurityTypeValueTextBox_id = PageObjectsMap.get("strSecurityTypeValueTextBox").get("ID");
				
			if (PageObjectsMap.get("strNumberOfResults").get("XPATH") != null)
				strNumberOfResults_xpath = PageObjectsMap.get("strNumberOfResults").get("XPATH");
			
			if (PageObjectsMap.get("strPageLinks").get("XPATH") != null)
				strPageLinks_xpath = PageObjectsMap.get("strPageLinks").get("XPATH");
			
			if (PageObjectsMap.get("strResultHeaders").get("XPATH") != null)
				strResultHeaders_xpath = PageObjectsMap.get("strResultHeaders").get("XPATH");
			
			if (PageObjectsMap.get("strAssetsActiveTab").get("XPATH") != null)
				strAssetsActiveTab_xpath = PageObjectsMap.get("strAssetsActiveTab").get("XPATH");
			
			if (PageObjectsMap.get("strPositionsSection_AssetTab").get("ID") != null)
				strPositionsSection_AssetTab_id = PageObjectsMap.get("strPositionsSection_AssetTab").get("ID");
			
			if (PageObjectsMap.get("strPositionsTable_AssetTab").get("ID") != null)
				strPositionsTable_AssetTab_id = PageObjectsMap.get("strPositionsTable_AssetTab").get("ID");
			
			if (PageObjectsMap.get("strClearButton").get("ID") != null)
				strClearButton_id = PageObjectsMap.get("strClearButton").get("ID");
			
			String[][] allPageObjects = {
					{strRepSearchPanel_id,"Rep Search Panel","ID"},
					{strRepDropDown_id,"Rep Dropdown","ID"},
					{strSearchButton_id,"Search Button","ID"},
					{strLPLAccountsPanel_id,"LPL Accounts Panel","ID"},
					{strUnofficialAcctsPanel_id,"Unofficial Accounts Panel","ID"},
					{strSecuritiesPositionsPanel_id,"Search Positions in Securities Panel","ID"},
					{strSortingCriteriaPanel_id,"Sorting Criteria Panel","ID"}};
			
			this.allObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of AccountBrowse_PositionsPage Class", "Object should be successfully created of AccountBrowse_PositionsPage class", "Failed to fetch the objects of AccountBrowse_PositionsPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}

	
	/**
	 * setSearchCriteriaPositions : This method is set search Criteria in Positions Page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-22-2016
	 * @param strRepID = Rep ID to search with, strMatchTypeOption - Match type option (Ex: Security Description), strMatchTypeValue = Match type value to match with
	 * @return boolean True if search criteria is set successfully and False if failed
	 */
	public boolean setSearchCriteriaPositions(String strRepID,String strSecurityTypeOption, String strSecurityTypeValue){
		try {
			//Enter Rep ID
			WebElement objRepSearchTextBox = driver.findElement(By.id(strRepSearchTextBox_id));
			objRepSearchTextBox.sendKeys(strRepID);
			
			//Select the Security Type Radio
			WebElement objSecurityTypeRadio = driver.findElement(By.id(strSecurityTypeRadio_id));
			objSecurityTypeRadio.click();
			
			//Wait for Drop down to Load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			
			//Creating object for Select Drop down class from LPL Core driver
			SelectDropDown sdd = new SelectDropDown(driver, By.id(strSecurityTypeComboBoxArrow_id));
			
			//Select the Match type option
			sdd.selectInputDropDownByValue(By.id(strSecurityTypeComboBoxArrow_id),By.xpath(strSecurityTypeDDList_xpath),strSecurityTypeOption);
			
			//Enter the Match value to search
			WebElement objValueToMatchTextBox = driver.findElement(By.id(strSecurityTypeValueTextBox_id));
			objValueToMatchTextBox.click();
			objValueToMatchTextBox.sendKeys(strSecurityTypeValue);
			return true;
		} catch (Exception e) {
			this.strError = this.strError + " Problem setting the Search Criteria of Positions page . Error: " + e.getMessage();
			return false;
		}
	}
	
	/**
	 * SearchAndValidatePositions : This method is to Search and validate the results in positions page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-22-2016
	 * @param strExpectedColumns - Expected Column header header names in a comma separated single string
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean SearchAndValidatePositions(String strExpectedColumns){
		boolean blnResult1 = false;
		//boolean blnResult2 = false;
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
					this.strError = this.strError + " " + e.getMessage();
					blnResult1 = false;
				}
				
				/*try {
					//Verify the Page links in the Results Grid
					List<WebElement> objPageLinks = objWholeResultsGrid.findElements(By.xpath(strPageLinks_xpath));
					for(WebElement pageLink: objPageLinks){
						if(pageLink.getAttribute("id").contains("_pageLink")){
							blnResult2 = true;
						}
					}
				} catch (Exception e) {
					this.strError = this.strError + " " + e.getMessage();
					blnResult1 = true;
				}*/
				
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
				if (blnThisValueFound & blnResult1 /*& blnResult2*/) {
					return true;
				}else{
					this.strError = this.strError + " Search Results validation failed for Positions page. Details: Expected Columns: " + strExpectedColumns+ " Actual Columns: " + strActualHeaderList + "; Page links and Number of results badge might also be missing ";
					return false;
				}
			}else{
				this.strError = this.strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Positions page";
				return false;
			}
		} catch (Exception e) {
			this.strError = this.strError + " Problem validating Search results of Positions page";
			return false;
		}
	}
	
	/**
	 * verifyAccountAssetsPositions : This method is to Click on LPL Account number link in the positions and verify if Assets page and Positions section loaded
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 11-22-2016
	 * @param strLPLAcctNumberColumnText - LPL Account number column label as expected in the application
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean verifyAccountAssetsPositions(String strLPLAcctNumberColumnText){
		boolean blnAcctAssetsPositionTableFound = false;
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
							WebElement objLplAcNumLink = thisTR.findElement(By.xpath(".//td["+(intCounter+1)+"]/a"));
							blnLPLAcNumLinkFound = true;
							objLplAcNumLink.click();
							LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
							driver.switchTo().defaultContent();
							driver.switchTo().frame(strParentFrame);
							WebElement objAssetsFrame = driver.findElement(By.xpath(strAccountAssetsIframe_XPATH));
							driver.switchTo().frame(objAssetsFrame);
							
							//After Clicking on the Account number , wait for Account Assets page to load
							LPLCoreSync.waitTillVisible(driver, By.xpath(strAssetsActiveTab_xpath ), LPLCoreConstents.getInstance().BaseInMiliSec);
							if (LPLCoreSync.waitTillVisible(driver, By.id(strPositionsSection_AssetTab_id), LPLCoreConstents.getInstance().BaseInMiliSec) &&
									LPLCoreSync.waitTillVisible(driver, By.id(strPositionsTable_AssetTab_id), LPLCoreConstents.getInstance().BaseInMiliSec)) {
								blnAcctAssetsPositionTableFound = true;
							}
							break;
						} catch (Exception e) {
							blnLPLAcNumLinkFound = false;
						}
					}
					//Fail the method if LPL Account number Link is not found in any row of search results
					if(!blnLPLAcNumLinkFound){
						this.strError = this.strError + " LPL Account number Link not found in any row of search results in Positions page";
						return false;
					}
					//If Account assets page loaded and the Positions section loaded, then Pass the method
					if (blnAcctAssetsPositionTableFound) {
						//Click on New Search Button
						driver.findElement(By.id(strAccountAssetsNewSearchBtn_id)).click();
						LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
						driver.switchTo().defaultContent();
						return true;
					}else{
						this.strError = this.strError + " Account Assets did not open on clicking LPL Account number.";
						return false;
					}
				}else{
					this.strError = this.strError + " LPL Account number Column not found in search results of Positions page.";
					return false;
				}
			}else{
				this.strError = this.strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Positions page";
				return false;
			}
		} catch (Exception e) {
			this.strError = this.strError + e.getMessage();
			return false;
		}
	}
}
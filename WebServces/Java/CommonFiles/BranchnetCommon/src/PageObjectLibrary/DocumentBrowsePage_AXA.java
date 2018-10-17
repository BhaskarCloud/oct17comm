package PageObjectLibrary;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;
import LPLCoreDriver.WebToolKit.SelectDropDown;


/**
 * <p>
 * <br><b> Title: </b> DocumentBrowsePage.java</br>
 * <br><b> Description: </B> Page Object Library For BranchNet - Document Browse Page</br>
 * @author Aiswarya Srinivasan
 * @since 08-29-2016 
 * </p>
 */
public class DocumentBrowsePage_AXA extends AccountBrowse_Common_AXA{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/**Variables to hold values of Missing and Found columns*/
	public String strFoundColumns = "";
	public String strMissingColumns = "";
	
	/**Variables to hold Document name column index*/
	public int intDocNameColCounter = 0;
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
		 
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strIframe_XPATH								= ".//iframe[2]";
	
	public String strPageHeader_Xpath 							= "//*[@class='headerCSS']";
	
	public String strCategoriesDD_id							= "categoriesDDL";
	
	public String strNameAcctNoTextBox_id						= "nameAcctTxtBx";
	
	public String strDocumentName_id							= "docNameTxt";
	
	public String strSubCategoryDD_id							= "subCatDDL";
	
	public String strRepIDTextBox_id							= "axaRepTxtbox";
	
	public String strEmpRepIDTextBox_id							= "empRepTxtbox";
	
	public String strDocDate_id									= "d";
	
	public String strResetButton_id								= "resetBtn";
	
	public String strSearchButton_id							= "searchBtn";
	
	public String strResultsGrid_id								= "searchGridWrapper";
	
	public String strRecordsFoundLabel_id						= "recordsFoundLbl";
	
	public String strUploadNewDocButton_id						= "uploadBtn";
	
	//Added on 01/17/2017
	public String strIncludeDelDocsCheckBox_ID					= "includeDeleteDocChkBx";
	
	public String strRepIDDD_ID									= "repIdDDL";
	
	public String strResultsTable_CSS							= "table.ui-jqgrid-htable";
	
	public String strPaginationControl_ID						= "pager14";
	
	public String strResultHeaders_XPATH						= "//th[@role='columnheader']";
	
	public String strResultsDataTable_ID						= "searchGrid";
	
	public String strDocLink_XPATH								= "(//a[@id='docNameClick' and text()='xxx'])[2]";
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 352;
	
	public String[][] allObjects = null;
	
	public DocumentBrowsePage_AXA(WebDriver driver){
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

			if (PageObjectsMap.get("strPageHeader").get("XPATH") != null)
				strPageHeader_Xpath = PageObjectsMap.get("strPageHeader").get("XPATH");

			if (PageObjectsMap.get("strCategoriesDD").get("ID") != null)
				strCategoriesDD_id = PageObjectsMap.get(
						"strCategoriesDD").get("ID");
			
			if (PageObjectsMap.get("strNameAcctNoTextBox").get("ID") != null)
				strNameAcctNoTextBox_id = PageObjectsMap.get("strNameAcctNoTextBox").get("ID");
			
			if (PageObjectsMap.get("strSearchButton").get("ID") != null)
				strSearchButton_id = PageObjectsMap.get("strSearchButton").get("ID");
			
			if (PageObjectsMap.get("strDocumentName").get("ID") != null)
				strDocumentName_id = PageObjectsMap.get("strDocumentName").get("ID");
			
			if (PageObjectsMap.get("strSubCategoryDD").get("ID") != null)
				strSubCategoryDD_id = PageObjectsMap.get("strSubCategoryDD").get("ID");
			
			if (PageObjectsMap.get("strEmpRepIDTextBox").get("ID") != null)
				strEmpRepIDTextBox_id = PageObjectsMap.get("strEmpRepIDTextBox").get("ID");
			
			if (PageObjectsMap.get("strRepIDTextBox").get("ID") != null)
				strRepIDTextBox_id = PageObjectsMap.get("strRepIDTextBox").get("ID");
			
			if (PageObjectsMap.get("strDocDate").get("ID") != null)
				strDocDate_id = PageObjectsMap.get("strDocDate").get("ID");
			
			if (PageObjectsMap.get("strResetButton").get("ID") != null)
				strResetButton_id = PageObjectsMap.get("strResetButton").get("ID");
			
			if (PageObjectsMap.get("strResultsGrid").get("ID") != null)
				strResultsGrid_id = PageObjectsMap.get("strResultsGrid").get("ID");
			
			if (PageObjectsMap.get("strRecordsFoundLabel").get("ID") != null)
				strRecordsFoundLabel_id = PageObjectsMap.get("strRecordsFoundLabel").get("ID");
			
			if (PageObjectsMap.get("strUploadNewDocButton").get("ID") != null)
				strUploadNewDocButton_id = PageObjectsMap.get("strUploadNewDocButton").get("ID");
			
			//Added on 01/17/2017
			if (PageObjectsMap.get("strIncludeDelDocsCheckBox").get("ID") != null)
				strIncludeDelDocsCheckBox_ID = PageObjectsMap.get("strIncludeDelDocsCheckBox").get("ID");
			
			if (PageObjectsMap.get("strRepIDDD").get("ID") != null)
				strRepIDDD_ID = PageObjectsMap.get("strRepIDDD").get("ID");
			
			if (PageObjectsMap.get("strResultsTable").get("CSS") != null)
				strResultsTable_CSS = PageObjectsMap.get("strResultsTable").get("CSS");
			
			if (PageObjectsMap.get("strPaginationControl").get("ID") != null)
				strPaginationControl_ID = PageObjectsMap.get("strPaginationControl").get("ID");
			
			if (PageObjectsMap.get("strResultHeaders").get("XPATH") != null)
				strResultHeaders_XPATH = PageObjectsMap.get("strResultHeaders").get("XPATH");
			
			if (PageObjectsMap.get("strResultsDataTable").get("ID") != null)
				strResultsDataTable_ID = PageObjectsMap.get("strResultsDataTable").get("ID");
			
			if (PageObjectsMap.get("strDocLink").get("XPATH") != null)
				strDocLink_XPATH = PageObjectsMap.get("strDocLink").get("XPATH");
			
			String[][] allPageObjects = {
					{strPageHeader_Xpath,"Page Header","XPATH"},
					{strCategoriesDD_id,"Categories Dropdown","ID"},
					{strNameAcctNoTextBox_id,"Name/Account Number text box","ID"},
					{strSearchButton_id,"Search Button","ID"},
					{strDocumentName_id,"Document name text box","ID"},
					{strSubCategoryDD_id,"Sub-Category dropdown","ID"},
					{strRepIDTextBox_id,"Rep ID Text box","ID"},
					{strDocDate_id,"Document date field","ID"},
					{strResetButton_id,"Reset Button","ID"},
					{strResultsGrid_id,"Results Grid","ID"},
					{strRecordsFoundLabel_id,"Number of Records found label","ID"},
					{strUploadNewDocButton_id,"Upload New Document button","ID"}};
			
			this.allObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of DocumentBrowsePage Class", "Object should be successfully created of DocumentBrowsePage class", "Failed to fetch the objects of DocumentBrowsePage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	/**
	 * setSearchCriteriaDocumentsBrowse : This method is set search Criteria in Documents browse Page
	 * @author Partha Sham
	 * @version 1.0
	 * @since 01-16-2016
	 * @param strRepID = Rep ID to search with, strDocName - Document name, blnIncludeDeletedDocs = Flag to include or ignore deleted docs
	 * @return boolean True if search criteria is set successfully and False if failed
	 */
	public boolean setSearchCriteriaDocumentsBrowse(String strRepID,String strDocName, boolean blnIncludeDeletedDocs){
		try {
			//Clear the page			
			WebElement objResetButton = driver.findElement(By.id(strResetButton_id));
			objResetButton.click();
			
			WebElement objRepSearchTextBox = null;
			try {
				//Enter Rep ID
				objRepSearchTextBox = driver.findElement(By.id(strRepIDTextBox_id));
				objRepSearchTextBox.sendKeys(strRepID);
			} catch (Exception e) {
				try {
					objRepSearchTextBox = driver.findElement(By.id(strEmpRepIDTextBox_id));
					objRepSearchTextBox.sendKeys(strRepID);
				} catch (Exception e1) {
					SelectDropDown objRepID	 = new SelectDropDown(driver, By.id(strRepIDDD_ID));
					objRepID.selectDropDownByValue(strRepID);
				}
			}
			
			//Enter Document name
			WebElement objDocName = driver.findElement(By.id(strDocumentName_id));
			objDocName.sendKeys(strDocName);
			
			if (blnIncludeDeletedDocs) {
				//If the blnIncludeDeletedDocs flag is true, then check the Include Deleted Documents Check box
				WebElement objIncludeCheckBox = driver.findElement(By
						.id(strIncludeDelDocsCheckBox_ID));
				objIncludeCheckBox.click();
			}
			return true;
		} catch (Exception e) {
			this.strError = this.strError + " Problem setting the Search Criteria of Documents browse page. Error : " + e.getMessage();
			return false;
		}
	}
	
	/**
	 * searchAndValidateDocumentsBrowse : This method is to Search and validate the results in Documents Browse page
	 * @author Partha Sham
	 * @version 1.0
	 * @since 01-16-2016
	 * @param strExpectedColumns - Expected Column header header names in a comma separated single string
	 * @return boolean True if search is successful and False if failed
	 */
	public boolean searchAndValidateDocumentsBrowse(String strExpectedColumns){
		boolean blnResult1 = false;
		boolean blnResult2 = false;
		try {
			//Click Search Button
			WebElement objSearchButton = driver.findElement(By.id(this.strSearchButton_id));
			objSearchButton.click();
			
			//Wait for Results Grid to Load
			waitForPageLoading(lplCoreConstents.HIGH);
			if(LPLCoreSync.waitTillVisible(driver, By.cssSelector(strResultsTable_CSS), LPLCoreConstents.getInstance().BaseInMiliSec)){
				WebElement objWholeResultsGrid = driver.findElement(By.cssSelector(strResultsTable_CSS));
				
				try {
					//Verify the Number of Results loaded line
					@SuppressWarnings("unused")
					WebElement objNumberOfResults = driver.findElement(By.id(strRecordsFoundLabel_id));
					blnResult1 = true;
				} catch (Exception e) {
					this.strError = this.strError + " Number of Results loaded is not displayed. Error text: " + e.getMessage();
					blnResult1 = false;
				}
				
				try {
					//Verify the Page links in the Results Grid
					@SuppressWarnings("unused")
					WebElement objPaginationControl = driver.findElement(By.id(strPaginationControl_ID));
					blnResult2 = true;
				} catch (Exception e) {
					this.strError = this.strError + " Pagination control is not displayed. Error text: " + e.getMessage();
					blnResult1 = false;
				}
				
				//Verify the Table header columns with the Expected Columns list
				List<WebElement> objResultHeaders = objWholeResultsGrid.findElements(By.xpath(strResultHeaders_XPATH));
				String strActualHeaderList = "";
				for(WebElement thisResultHeader: objResultHeaders){
					strActualHeaderList = strActualHeaderList + thisResultHeader.getText().trim() + ",";
				}
				
				String[] arrExpectedValues = strExpectedColumns.split(",");
				String[] arrActualvalues = strActualHeaderList.split(",");
				boolean blnThisValueFound = false;
				int intDocNameCounter = 0;
				
				for(String strEachColumn:arrExpectedValues){
					blnThisValueFound = false;
					for(String strEachActualValue: arrActualvalues){
						intDocNameCounter = intDocNameCounter +1;
						if(strEachColumn.trim().equalsIgnoreCase(strEachActualValue.trim())){
							strFoundColumns = strFoundColumns + strEachColumn + ",";
							if(strEachColumn.trim().equalsIgnoreCase("Document Name")){
								intDocNameColCounter = intDocNameCounter;
							}
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
					this.strError = this.strError + " Search Results validation failed for Documents Browse page. Details: Expected Columns: " + strExpectedColumns+ " Actual Columns: " + strActualHeaderList + "; Pagination control and Number of results badge might also be missing ";
					return false;
				}
			}else{
				this.strError = this.strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Documents Browse page";
				return false;
			}
		} catch (Exception e) {
			this.strError = this.strError + " Problem validating Search results of Documents Browse page";
			e.printStackTrace();
			return false;
		}
	}
	
	/** VerifyDocDownloadDocBrowse : This method is to Click and open a document in Documents browse Page results
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 02-03-2017
	 * @param strDocName - Document name
	 * @return boolean True if Document opened successfully and False if failed
	 */
	public boolean VerifyDocDownloadDocBrowse(String strDocName){
		try {
			//Download path
			String strDownloadFolderPath = LPLCoreConstents.getInstance().DefaultDownloadFolder;
			
			//Clean the Download directory
			File strDownloadDir = new File(strDownloadFolderPath);
			FileUtils.cleanDirectory(strDownloadDir); 
			
			//Finding the Results table
			WebElement objResultsDataTable = driver.findElement(By.id(strResultsDataTable_ID));
			
			//Enter Document name
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			WebElement objDocNameLink = objResultsDataTable.findElement(By.xpath(strDocLink_XPATH.replaceAll("xxx", strDocName)));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", objDocNameLink);
			
			//Wait for Results Grid to Load
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
			BNCommon bnCommon = new BNCommon(driver);
			
			Actions action = new Actions(driver);
			action.keyDown(Keys.CONTROL).sendKeys("j").build().perform();
			action.keyUp(Keys.CONTROL).build().perform();
			LPLCoreSync
					.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec); 
			
			String[] strDownloadCommand = LPLCoreConstents.getInstance().strIEOpenSaveDownloadCommand.split(",");
			Runtime runtime = Runtime.getRuntime();
			try {
				Process process = runtime.exec(strDownloadCommand);
				try {
					int value = process.waitFor();
					if(value!=0)
						LPLCoreReporter.WriteReport("IE Download Command Execution Process", "IE Download Command Execution Process should be successful","IE Download Command Execution Process terminated abnormally.", LPLCoreConstents.FAILED, "");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			bnCommon.waitForPageLoading(lplCoreConstents.FAIR);
			
			//Verify the latest file is what we just downloaded
			File newestFile = LPLCoreUtil.getLatestFilefromDir(strDownloadFolderPath);
			
			if(newestFile.getName().equalsIgnoreCase(strDocName)){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			this.strError = this.strError + " Problem Opening the document from Documents browse page results. Error : " + e.getMessage();
			e.printStackTrace();
			return false;
		}
	}
}

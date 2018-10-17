package PageObjectLibrary;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.WebToolKit.WebTable;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> ClientManagement_AccountTab.java</br>
 * <br><b> Description: </B> Page Object Library For ClientManagement's Account Tab</br>
 * <br><b>Usage:</br></b> 
 * <br>getSearchResultColumnHeaders: This function is used to get the list of account search result column headers.</br>
 * <br>getSearchResultRowCount: This function is used to get the total row count of search result table.</br>
 * <br>selectRowWithCellValue: This function is used to select the row with specified cell value mentioned under specific column.</br>
 * <br>getRowWithValueUnderCol: This function is used to get the first row index that has value mentioned under the specific column.</br>
 * <br> getValueUnderCol: This function is used to get the first non blank value from the specific column.</br>
 * <br>performContextMenuOperation: This function is used to perform the context menu operation</br>
 * <br>actionOperation: This function is used to perform the navigation through Actions button</br>
 * <br>clickActionButton: This function is used to click the Action button</br>
 * <br>validateLPLFilterPopup: This function is used Validate LPL Filter Popup</br>
 * <br>setLPLMinValue: This function is to Enter LPL Min Value</br>
 * <br>setLPLMaxValue: This function is to Enter LPL Max Value</br>
 * <br>getAlertMessage: This function is used to Validate Alert Message</br>
 * <br>clickLPLValueRow: This function is used to click on LPL Value Row</br>
 * 
 * @author Aiswarya Srinivasan, Ambarish Khatua, Rahul Agarwal, Harishbabau
 * @since 05-25-2016
 * </p>
 */
public class ClientManagement_AccountsTab extends ClientManagement_Common{

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;

	/** Angular model property value of Account Search Edit Box. */
	public String strAccountSearchBox_model = "gsVm.searchText";

	/** CSS Selector property value of Search button */
	public String strSearchButton_css = ".fa.fa-search";
	
	/** CSS Selector property value of Quick view heading */
	public String strQuickViewHeading_css			= ".panel-heading";
	
	/** CSS Selector property value of Create Client and Account button */
	public String strCreateClientAccountButton_css	= ".btn.btn-default.btn-drop-shadow.ng-scope";
	
	/** CSS Selector property value of Create Client and Account button */
	public String strAccountsPageTable_css			= "#data-table";
	
	/** CSS Selector property value of Page Header showing the number of records */
	public String strAccountPageHeading_css		= "#total-records>.ng-scope>span.ng-binding";
	
	/** Id property value of Account Search Result Table */
	public String strSearchResultTable_Id = "data-table";

	/** Id property value of Account Search Result Table Header */
	public String strSearchResultTableHeader_Id = "table-header";

	/** Angular Repeater property value of Search Result column headers */
	public String strColumnHeaders_repeater = "column in dtVm.savedView.columns";

	/** Tag property value of Search Result row */
	public String strRow_tag = "tr";
	
	/** Tag property value of Search Result column*/
	public String strColumn_tag = "td";

	/** Xpath property value of Account Search Result Column Name */
	public String strSearchResultColumn_Xpath = "//*[@id='table-header']//a";
	
	/** CSS property value of Account Search Result Column Name */
	public String strSearchResultColumn_CSS = "#table-header .ng-scope";

	/** Id property value of Loading Object */
	public String strLoading_Id = "ngProgress-container";

	/** Id property value of Frame. */
	public String frameID							= "containerFrame";
	
	/** Text property value of Actions Object */
	private String strActions_Text = "Actions";

	/** CSS property value of FirstLevel Menu Object */
	public String strMenuWith2ndLevel_CSS = ".ng-binding.ng-scope.has-children";

	/** CSS property value of MoveMoney Level2 Object */
	public String strMoveMoneyLevel2_CSS = ".btn.btn-link.ng-binding.ng-scope";

	/** CSS property value of Buy Alternative Investment Object */
	public String strBuyAltInvestment_CSS = ".ng-binding.ng-scope";

	/** CSS property value of Fixed Income Buy Object */
	public String strFixedIncomeBuy_CSS = ".btn.btn-link.ng-binding.ng-scope";

	/** Xpath property value of Context Menu Object */
	public String strContextMenu_Xpath = "//*[@id='data-table']//div[contains(.,'xxx')]//button[@class='btn btn-link']";
	
	/** CSS property value of Fixed Income Buy Object */
	public String strAccountLinkingActions_CSS = ".ng-scope.ng-isolate-scope>.btn.ng-scope.btn-link";
	
	/** Xpath property value of Account No Link in Search Result table */
	public String strAccountLink_Xpath = "//*[@id='data-table']//a[text()='xxx']";
	
	/** CSS property value of Min Value */
	public String strLplMinValue_CSS = "#acctVal-value-min";
	
	/** CSS property value of Max Value */
	public String strLplMaxValue_CSS = "#acctVal-value-max";
	
	/** CSS property value of Min Value */
	public String strTotalCostBasisMinValue_CSS = "#totalcostbasis-value-min";
	
	/** CSS property value of Max Value */
	public String strTotalCostBasisMaxValue_CSS = "#totalcostbasis-value-max";
	
	/** Xpath property value of Cancel */
	public String strLplAccept_Xpath = ".//*[@id='acctVal-filter-menu']/form/div[3]/button[1]";
	
	/** Xpath property value of  Accept*/
	public String strLplCancel_Xpath = ".//*[@id='acctVal-filter-menu']/form/div[3]/button[2]";
	
	/** CSS property value of Range Filter */
	public String strRangeFilterValue_CSS = "fmVm.control.availableFilters[filter.column].selectedText";
	
	/** CSS property value of Lpl Alert Message */
	public String strAlertMessage_CSS = "fmVm.control.errorMessage";
	
	/** Xpath property value of Lpl Value Row */
	public String strLplValueRow = ".//*[@id='thacctVal']/a";
	
	/** Xpath property value of Account Lock Icon */
	public String strAccountLockIcon_XPATH = ".//*[@id='thacctVal']/a";
	
	public String strIncomingAccountTransfer_CSS = ".btn.btn-link.ng-binding.ng-scope.ng-isolate-scope";
	
	public LPLCoreConstents lplCoreConstents;
	
	public String[] allObjects;
	
	/** Current Page ID from FARM */ 
	public final int INT_PAGEID = 12;
	
	public ClientManagement_AccountsTab(WebDriver driver){
		super(driver);
		try {
			lplCoreConstents = LPLCoreConstents.getInstance();
			this.driver = driver;
			
			/** Fetching the page objects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
			
			if(PageObjectsMap.get("strAccountSearchBox").get("ANGULARREF")!=null)
				strAccountSearchBox_model = PageObjectsMap.get("strAccountSearchBox").get("ANGULARREF");
			
			if(PageObjectsMap.get("SearchButton").get("CSS")!=null)
				strSearchButton_css = PageObjectsMap.get("SearchButton").get("CSS");
			
			if(PageObjectsMap.get("strQuickViewHeading").get("CSS")!=null)
				strQuickViewHeading_css = PageObjectsMap.get("strQuickViewHeading").get("CSS");		
			
			if(PageObjectsMap.get("strCreateClientAccountButton").get("CSS")!=null)
				strCreateClientAccountButton_css = PageObjectsMap.get("strCreateClientAccountButton").get("CSS");		
			
			if(PageObjectsMap.get("AccountsTable").get("CSS")!=null)
				strAccountsPageTable_css = PageObjectsMap.get("AccountsTable").get("CSS");
			
			if(PageObjectsMap.get("AccountsTable").get("ID")!=null)
				strSearchResultTable_Id = PageObjectsMap.get("AccountsTable").get("ID");
			
			if(PageObjectsMap.get("strAccountPageHeading").get("CSS")!=null)
				strAccountPageHeading_css = PageObjectsMap.get("strAccountPageHeading").get("CSS");
			
			if(PageObjectsMap.get("strSearchResultTableHeader").get("ID")!=null)
				strSearchResultTableHeader_Id = PageObjectsMap.get("strSearchResultTableHeader").get("ID");		
			
			if(PageObjectsMap.get("strColumnHeaders").get("ANGULARREF")!=null)
				strColumnHeaders_repeater = PageObjectsMap.get("strColumnHeaders").get("ANGULARREF");
			
			if(PageObjectsMap.get("strRow").get("ID")!=null)
				strRow_tag = PageObjectsMap.get("strRow").get("ID");
			
			if(PageObjectsMap.get("strColumn").get("ID")!=null)
				strColumn_tag = PageObjectsMap.get("strColumn").get("ID");
			
			if(PageObjectsMap.get("strColumnHeaders").get("XPATH")!=null)
				strSearchResultColumn_Xpath = PageObjectsMap.get("strColumnHeaders").get("XPATH");
			
			if(PageObjectsMap.get("strColumnHeaders").get("CSS")!=null)
				strSearchResultColumn_CSS = PageObjectsMap.get("strColumnHeaders").get("CSS");
			
			if(PageObjectsMap.get("strLoading").get("ID")!=null)
				strLoading_Id = PageObjectsMap.get("strLoading").get("ID");
			
			if(PageObjectsMap.get("frame").get("ID")!=null)
				frameID = PageObjectsMap.get("frame").get("ID");
			
			if(PageObjectsMap.get("Actions").get("ANGULARREF")!=null)
				strActions_Text = PageObjectsMap.get("Actions").get("ANGULARREF");
			
			if(PageObjectsMap.get("strMenuWith2ndLevel").get("CSS")!=null)
				strMenuWith2ndLevel_CSS = PageObjectsMap.get("strMenuWith2ndLevel").get("CSS");	
			
			if(PageObjectsMap.get("strMoveMoneyLevel2").get("CSS")!=null)				
				strMoveMoneyLevel2_CSS = PageObjectsMap.get("strMoveMoneyLevel2").get("CSS");
			
			if(PageObjectsMap.get("strBuyAltInvestment").get("CSS")!=null)				
				strBuyAltInvestment_CSS = PageObjectsMap.get("strBuyAltInvestment").get("CSS");
			
			if(PageObjectsMap.get("strFixedIncomeBuy").get("CSS")!=null)
				strFixedIncomeBuy_CSS = PageObjectsMap.get("strFixedIncomeBuy").get("CSS");
			
			if(PageObjectsMap.get("AccountContextMenuIcon").get("XPATH")!=null)
				strContextMenu_Xpath = PageObjectsMap.get("AccountContextMenuIcon").get("XPATH");
			
			if(PageObjectsMap.get("strAccountLinkingActions").get("CSS")!=null)
				strAccountLinkingActions_CSS = PageObjectsMap.get("strAccountLinkingActions").get("CSS");
			
			if(PageObjectsMap.get("AccountLink").get("XPATH")!=null)
				strAccountLink_Xpath = PageObjectsMap.get("AccountLink").get("XPATH");
			
			if(PageObjectsMap.get("strLplMinValue").get("CSS")!=null)
				strLplMinValue_CSS = PageObjectsMap.get("strLplMinValue").get("CSS");
			
			if(PageObjectsMap.get("strLplMaxValue").get("CSS")!=null)
				strLplMaxValue_CSS = PageObjectsMap.get("strLplMaxValue").get("CSS");
			
			if(PageObjectsMap.get("strLplAccept").get("XPATH")!=null)
				strLplAccept_Xpath = PageObjectsMap.get("strLplAccept").get("XPATH");
			
			if(PageObjectsMap.get("strLplCancel").get("XPATH")!=null)
				strLplCancel_Xpath = PageObjectsMap.get("strLplCancel").get("XPATH");
			
			if(PageObjectsMap.get("strRangeFilterValue").get("CSS")!=null)
				strRangeFilterValue_CSS = PageObjectsMap.get("strRangeFilterValue").get("CSS");
			
			if(PageObjectsMap.get("strAlertMessage").get("CSS")!=null)
				strAlertMessage_CSS = PageObjectsMap.get("strAlertMessage").get("CSS");
			
			if(PageObjectsMap.get("strLplValueRow").get("XPATH")!=null)
				strLplValueRow = PageObjectsMap.get("strLplValueRow").get("XPATH");
			
			if(PageObjectsMap.get("strAccountLockIcon").get("XPATH")!=null)
				strAccountLockIcon_XPATH = PageObjectsMap.get("strAccountLockIcon").get("XPATH");
			
			if(PageObjectsMap.get("strTotalCostBasisMinValue").get("CSS")!=null)
				strTotalCostBasisMinValue_CSS = PageObjectsMap.get("strTotalCostBasisMinValue").get("CSS");
			
			if(PageObjectsMap.get("strTotalCostBasisMaxValue").get("CSS")!=null)
				strTotalCostBasisMaxValue_CSS = PageObjectsMap.get("strTotalCostBasisMaxValue").get("CSS");
			
			if(PageObjectsMap.get("strIncomingAccountTransfer").get("CSS")!=null)
				strIncomingAccountTransfer_CSS = PageObjectsMap.get("strIncomingAccountTransfer").get("CSS");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		super.strAccountSearchBox_model = this.strAccountSearchBox_model;
		
		super.strRow_tag				= this.strRow_tag;
		
		super.strSearchButton_css 		= this.strSearchButton_css;
		
		super.strSearchResultTable_Id	= this.strSearchResultTable_Id;
		
		super.strColumnHeaders_repeater = this.strColumnHeaders_repeater;
		
		this.driver = driver;	
		
		String[] allObjects = {strSearchButton_css,strQuickViewHeading_css,strCreateClientAccountButton_css,strAccountsPageTable_css,strAccountPageHeading_css};
		
		this.allObjects = allObjects;
	}
	
	
	
	/**
	 * This function is used to get the list of account search result column headers.
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 05-26-2016
	 * @return List<WebElement> list of column headers
	 */
	public List<WebElement> getSearchResultColumnHeaders() {
		List<WebElement> lstColumnHeaders = null;

		try {
			// Create the WebTable utility class object
			WebTable webTable = new WebTable(ByAngular.repeater(strColumnHeaders_repeater), null, null);

			// Create the WebTable Search Result Header Object
			WebElement objSearchResultHeader = driver.findElement(By.id(strSearchResultTableHeader_Id));

			if (objSearchResultHeader.isDisplayed()) {
				// Get the list of column headers...
				lstColumnHeaders = webTable.getColumnHeaders(objSearchResultHeader);
			}
			return lstColumnHeaders;
		} catch (Exception e) {
			strError = e.toString();
			return lstColumnHeaders;
		}
	}

	/**
	 * This function is used to get the total row count of search result table.
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 05-26-2016
	 * @return int intRowsCount - Total rows count of search result table. Returns -1 if failed.
	 */
	public int getSearchResultRowCount() {
		int intRowsCount = -1;

		try {
			// Wait for the Table to get loaded...
			waitforCMTableToLoad();

			// Create the WebTable utility class object
			WebTable webTable = new WebTable(null, By.tagName(strRow_tag), null);

			// Create the WebTable Search Result Table
			WebElement objSearchResult = driver.findElement(By.id(strSearchResultTable_Id));

			if (objSearchResult.isDisplayed()) {
				// Get the Total rows count of the search result table
				intRowsCount = webTable.getRowCount(objSearchResult);
			}
			return intRowsCount;
		} catch (Exception e) {
			strError = e.toString();
			return intRowsCount;
		}
	}

	/**
	 * This function is used to select the row with specified cell value mentioned under specific column
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-01-2016
	 * @param String strValue - Cell value
	 * @return Boolean - True/False
	 */
	public boolean selectRowWithCellValue(String strValue) {
		Integer[] cellIndex;
		boolean blnResult = false;

		try {
			// Wait for the Table to get loaded...
			waitforCMTableToLoad();

			// Create the WebTable utility class object
			WebTable webTable = new WebTable(null, By.tagName(strRow_tag), By.tagName(strColumn_tag));

			// Create the WebTable Search Result Table
			WebElement objSearchResult = driver.findElement(By.id(strSearchResultTable_Id));

			if (objSearchResult.isDisplayed()) {
				// Get the cell index with the specified value
				cellIndex = webTable.getCellIndex(objSearchResult, strValue);
				if(cellIndex == null){
					strValue = "xxxx"+"-"+strValue.split("-")[1];
					cellIndex = webTable.getCellIndex(objSearchResult, strValue);
				}
				// Get the CheckBox of the specific row and click on it to
				// select it.
				WebElement objCheckBox = webTable.getChildItem(objSearchResult, cellIndex[0], 1, "input");
				if (objCheckBox.isDisplayed()) {
					objCheckBox.click();
					blnResult = true;
				}
			}
			return blnResult;
		} catch (Exception e) {
			strError = e.toString();
			return blnResult;
		}
	}
	
	/**
	 * This function is used to get the first row index that has value mentioned under the specific column
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-02-2016
	 * @param String strColumn - Column Name
	 * @return Boolean - True/False
	 */
	public int getRowWithValueUnderCol(String strColumn) {
		int intRow = -1;

		try {
			// Wait for the Table to get loaded...
			waitforCMTableToLoad();

			// Create the WebTable utility class object
			WebTable webTable = new WebTable(null, By.tagName(strRow_tag), By.tagName(strColumn_tag));

			// Create the WebTable Search Result Table
			WebElement objSearchResult = driver.findElement(By.id(strSearchResultTable_Id));

			if (objSearchResult.isDisplayed()) {
				//Get rows count
				int intRowsCount = webTable.getRowCount(objSearchResult);
				//Find the Column Index
				int intColumnIndex = webTable.getColumnIndex(driver.findElement(By.id(strSearchResultTableHeader_Id)), strColumn);
				//Iterate through all the rows and find if the column has any value
				for(int intRowIndex=2; intRowIndex<=intRowsCount;intRowIndex++){
					String strCellValue = webTable.getCellValue(objSearchResult, intRowIndex, intColumnIndex).trim(); 
					//Once the cell has any value, returns the row index
					if (!strCellValue.isEmpty()){
						intRow = intRowIndex;
						break;
					}
				}
			}
			return intRow;
		} catch (Exception e) {
			strError = e.toString();
			return intRow;
		}
	}
	
	/**
	 * This function is used to get the first non blank value from the specific column
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-02-2016
	 * @param String strColumn - Column Name
	 * @return String - strCellValue - Cell value
	 */
	public String getValueUnderCol(String strColumn) {
		String strCellValue = "";

		try {
			// Wait for the Table to get loaded...
			waitforCMTableToLoad();

			// Create the WebTable utility class object
			WebTable webTable = new WebTable(By.tagName("th"), By.tagName(strRow_tag), By.tagName(strColumn_tag));

			// Create the WebTable Search Result Table
			WebElement objSearchResult = driver.findElement(By.id(strSearchResultTable_Id));

			if (objSearchResult.isDisplayed()) {
				//Get the total rows count of table
				int intRowsCount = webTable.getRowCount(objSearchResult);
				//Find the Column Index
				int intColumnIndex = webTable.getColumnIndex(driver.findElement(By.id(strSearchResultTableHeader_Id)), strColumn);
				//Iterate through all the rows and find if the column has any value
				for(int intRowIndex=1; intRowIndex<=intRowsCount;intRowIndex++){
					String strValue = webTable.getCellValue(objSearchResult, intRowIndex, intColumnIndex).trim();
					//Once the cell has any value, returns it
					if (strValue.hashCode()!= 8212){
						strCellValue = strValue;
						break;
					}
				}
			}
			return strCellValue;
		} catch (Exception e) {
			strError = e.toString();
			return strCellValue;
		}
	}

	/**
	 * This function is used to perform the context menu operation
	 * 
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-01-2016
	 * @param String strAccountNo - AccountNo, String[] arrNavigationMenu - Array of navigation menu
	 * @return  boolean - True/False     
	 */
	public boolean performContextMenuOperation(String strAccountNo, String[] arrNavigationMenu) {
		boolean blnResult = false;

		try {
			//Create Actions object to do mouse and key-board operation
			Actions action = new Actions(driver);			
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			
			//Added the below code to handle the masked account
			if(strAccountNo.contains("-"))
				strAccountNo = strAccountNo.split("-")[1];
			
			//Click the Context menu icon through JavascriptExecutor
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			js.executeScript("arguments[0].click();",driver.findElement(By.xpath(strContextMenu_Xpath.replace("xxx", strAccountNo))));
			
			//Perform the context menu operation as per the different navigation path
			switch (arrNavigationMenu.length){
				case 1:	/** If it is one level navigation */
					switch (arrNavigationMenu[0].toUpperCase()) {
						case "ACCOUNT LINKING ACTIONS":
							LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strAccountLinkingActions_CSS, arrNavigationMenu[0]), lplCoreConstents.MEDIUM);
							action.moveToElement(driver.findElement(ByAngular.cssContainingText(strAccountLinkingActions_CSS, arrNavigationMenu[0]))).click().build().perform();
							blnResult = true;
							break;
					}
					break;
					
				default: /** If there are multi level navigation */
					
					//Wait for the element to be available and do mouse hover on it.
					LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strMenuWith2ndLevel_CSS, arrNavigationMenu[0]), lplCoreConstents.MEDIUM);
					action.moveToElement(driver.findElement(ByAngular.cssContainingText(strMenuWith2ndLevel_CSS, arrNavigationMenu[0]))).build().perform();
					
					//Perform the operation based on various options
					switch (arrNavigationMenu[0].toUpperCase()) {
						case "MOVE MONEY": /** For Move Money there is only one level navigation */
							LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strMoveMoneyLevel2_CSS, arrNavigationMenu[1]), lplCoreConstents.MEDIUM);
							driver.findElement(ByAngular.cssContainingText(strMoveMoneyLevel2_CSS, arrNavigationMenu[1])).click();
							blnResult = true;
							break;
							
						case "TRADE": /** For Trade there may be multi level navigation */
							switch (arrNavigationMenu.length) {
								case 2: /** For two level trade navigation e.g. Trade > Buy Alternative Investments */
									if (arrNavigationMenu[1].equalsIgnoreCase("Buy Alternative Investment") || arrNavigationMenu[1].equalsIgnoreCase("Buy Annuity")) {
										LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strBuyAltInvestment_CSS, arrNavigationMenu[1]), lplCoreConstents.MEDIUM);
										driver.findElement(ByAngular.cssContainingText(strBuyAltInvestment_CSS, arrNavigationMenu[1])).click();
									}
									blnResult = true;
									break;
									
								case 3: /** For three level trade navigation e.g. Trade > Fixed Income > Buy */
									LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strMenuWith2ndLevel_CSS, arrNavigationMenu[1]), lplCoreConstents.MEDIUM);
									action.moveToElement(driver.findElement(ByAngular.cssContainingText(strMenuWith2ndLevel_CSS, arrNavigationMenu[1]))).build().perform();
									if (arrNavigationMenu[1].equalsIgnoreCase("Fixed Income")) {
										LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strFixedIncomeBuy_CSS, arrNavigationMenu[2]), lplCoreConstents.MEDIUM);
										driver.findElement(ByAngular.cssContainingText(strFixedIncomeBuy_CSS, arrNavigationMenu[2])).click();
									}
									blnResult = true;
									break;
							}
						case "ACCOUNT TRANSFERS":
							LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strIncomingAccountTransfer_CSS,arrNavigationMenu[1]), lplCoreConstents.MEDIUM);
							driver.findElement(ByAngular.cssContainingText(strIncomingAccountTransfer_CSS,arrNavigationMenu[1])).click();							
							blnResult = true;
							break;
					}			
			}			
			return blnResult;
		} catch (Exception e) {
			strError = e.toString();
			return blnResult;
		}
	}
	
	/**
	 * This function is used to perform the navigation through Actions button
	 * 
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-01-2016
	 * @param String strAccountNo - AccountNo, String[] arrNavigationMenu - Array of navigation menu
	 * @return  boolean - True/False     
	 */
	public boolean actionOperation(String[] arrNavigationMenu) {
		boolean blnResult = false;

		try {
			//Crate the Actions object for mouse operations.
			Actions action = new Actions(driver);
			
			//Perform the Actions menu operation as per the different navigation path
			switch (arrNavigationMenu.length){
				case 1:	/** If it is one level navigation */
					switch (arrNavigationMenu[0].toUpperCase()) {
						case "ACCOUNT LINKING ACTIONS":
							LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strAccountLinkingActions_CSS, arrNavigationMenu[0]), lplCoreConstents.MEDIUM);
							action.moveToElement(driver.findElement(ByAngular.cssContainingText(strAccountLinkingActions_CSS, arrNavigationMenu[0]))).click().build().perform();
							break;
					}
					
				default: /** If there are multi level navigation */
					//Wait for the element to be available and do mouse hover on it.
					LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strMenuWith2ndLevel_CSS, arrNavigationMenu[0]), lplCoreConstents.MEDIUM);
					action.moveToElement(driver.findElement(ByAngular.cssContainingText(strMenuWith2ndLevel_CSS, arrNavigationMenu[0]))).build().perform();
					
					//Perform the operation based on various options
					switch (arrNavigationMenu[0].toUpperCase()) {
						case "MOVE MONEY": /** For Move Money there is only one level navigation */
							LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strMoveMoneyLevel2_CSS, arrNavigationMenu[1]), lplCoreConstents.MEDIUM);
							driver.findElement(ByAngular.cssContainingText(strMoveMoneyLevel2_CSS, arrNavigationMenu[1])).click();
							blnResult = true;
							break;
							
						case "TRADE": /** For Trade there may be multi level navigation */
							switch (arrNavigationMenu.length) {
								case 2: /** For two level trade navigation e.g. Trade > Buy Alternative Investments */
									if (arrNavigationMenu[1].equalsIgnoreCase("Buy Alternative Investment") || arrNavigationMenu[1].equalsIgnoreCase("Buy Annuity")) {
										LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strBuyAltInvestment_CSS, arrNavigationMenu[1]), lplCoreConstents.MEDIUM);
										driver.findElement(ByAngular.cssContainingText(strBuyAltInvestment_CSS, arrNavigationMenu[1])).click();
									}
									blnResult = true;
									break;
									
								case 3: /** For three level trade navigation e.g. Trade > Fixed Income > Buy */
									LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strMenuWith2ndLevel_CSS, arrNavigationMenu[1]), lplCoreConstents.MEDIUM);
									action.moveToElement(driver.findElement(ByAngular.cssContainingText(strMenuWith2ndLevel_CSS, arrNavigationMenu[1]))).build().perform();
									if (arrNavigationMenu[1].equalsIgnoreCase("Fixed Income")) {
										LPLCoreSync.waitTillVisible(driver,ByAngular.cssContainingText(strFixedIncomeBuy_CSS, arrNavigationMenu[2]), lplCoreConstents.MEDIUM);
										driver.findElement(ByAngular.cssContainingText(strFixedIncomeBuy_CSS, arrNavigationMenu[2])).click();
									}
									blnResult = true;
									break;
							}
					}			
			}			
			return blnResult;
		} catch (Exception e) {
			strError = e.toString();
			return blnResult;
		}
	}
	
	/**
	 * This function is used to click the Action button
	 * 
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-01-2016
	 * @return (boolean) true/false
	 */
	public boolean clickActionButton() {
		boolean blnResult = false;

		try {
			//Create the Actions button object
			WebElement objActions = driver.findElement(ByAngular.buttonText(strActions_Text));
			
			//If the button is enabled, click on it.
			if(objActions.isEnabled()){
				objActions.click();
				blnResult = true;
			}			
			return blnResult;
		}catch (Exception e) {
			strError = e.toString();
			return blnResult;
		}
	}
	
	/**
	 * This function is used Validate LPL Filter Popup
	 *
	 * @author Harish Babu
	 * @version 1.0
	 * @since 06-22-2016
	 * @return boolean True if the Objects are Present
	 */
	public boolean validateLPLFilterPopup() {
		boolean blnReturn = false;

		try {
			driver.findElement(By.cssSelector(strLplMinValue_CSS)).isDisplayed();
			driver.findElement(By.cssSelector(strLplMaxValue_CSS)).isDisplayed();
			driver.findElement(By.xpath(strLplAccept_Xpath)).isDisplayed();
			driver.findElement(By.xpath(strLplCancel_Xpath)).isDisplayed();
			blnReturn = true;
			return blnReturn;
		}	
		 catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is to Enter LPL Min Value
	 *
	 * @author Harish Babu
	 * @version 1.0
	 * @since 06-22-2016
	 * @param (String) strLPLMinValue - LPL Min value
	 * @return (boolean) True/False
	 */
	public boolean setLPLMinValue(String strLPLMinValue) {
		boolean blnReturn = false;

		try {
			driver.findElement(By.cssSelector(strLplMinValue_CSS)).sendKeys(strLPLMinValue);
			blnReturn = true;
			return blnReturn;
		}	
		 catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is to Enter LPL Max Value
	 *
	 * @author Harish Babu
	 * @version 1.0
	 * @since 06-22-2016
	 * @param (String) strLPLMaxValue - LPL Max value
	 * @return (boolean) True/False
	 */
	public boolean setLPLMaxValue(String strLPLMaxValue) {
		boolean blnReturn = false;

		try {
			driver.findElement(By.cssSelector(strLplMaxValue_CSS)).sendKeys(strLPLMaxValue);
			blnReturn = true;
			return blnReturn;
		}	
		 catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
}
	
	/**
	 * This function is used to Validate Min value
	 * 
	 * @author Harish Babu
	 * @version 1.0
	 * @since 06-22-2016
	 * @return boolean
	 */
	public boolean getLPLMinValue(String strLPLMinValue) {
		boolean blnResult = false;

		try {
				String lplMinValue = driver.findElement(ByAngular.binding(strRangeFilterValue_CSS)).getText();
				String expLplMinValue = ">=$".concat(strLPLMinValue);
				if(expLplMinValue.contains(lplMinValue)){
					blnResult = true;
				}
			return blnResult;
		}catch (Exception e) {
			strError = e.toString();
			return blnResult;
			
		}
	}
	
	/**
	 * This function is used to Validate Max value
	 * 
	 * @author Harish Babu
	 * @version 1.0
	 * @since 06-22-2016
	 * @return boolean
	 */
	public boolean getLPLMaxValue(String strLPLMaxValue) {
		boolean blnResult = false;

		try {
				String lplMaxValue = driver.findElement(ByAngular.binding(strRangeFilterValue_CSS)).getText();
				String expLplMaxValue = "<=$".concat(strLPLMaxValue);
				if(expLplMaxValue.contains(lplMaxValue)){
					blnResult = true;
				}
			return blnResult;
		}catch (Exception e) {
			strError = e.toString();
			return blnResult;
			
		}
	}
	/**
	 * This function is used to Validate Alert Message
	 * 
	 * @author Harish Babu
	 * @version 1.0
	 * @since 06-22-2016
	 * @return boolean
	 */
	public boolean getAlertMessage(String strAlertMsg) {
		boolean blnResult = false;
		
		try {
			String alertMsg = driver.findElement(ByAngular.binding(strAlertMessage_CSS)).getText();
			if(alertMsg.contains(strAlertMsg)){
				blnResult = true;
			}
		return blnResult;
	}catch (Exception e) {
		strError = e.toString();
		return blnResult;
	}
}
	/**
	 * This function is used to click on LPL Value Row
	 * 
	 * @author Harish Babu
	 * @version 1.0
	 * @since 06-23-2016
	 * @return boolean
	 */
	public boolean clickLPLValueRow() {
		boolean blnResult = false;
		
		try {
			driver.findElement(By.xpath(strLplValueRow)).click();
			blnResult = true;
			return blnResult;
		}
	catch (Exception e) {
		strError = e.toString();
		return blnResult;
	}
 }

}

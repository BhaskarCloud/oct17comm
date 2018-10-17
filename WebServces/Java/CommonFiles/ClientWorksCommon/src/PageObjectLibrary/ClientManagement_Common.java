package PageObjectLibrary;

import java.awt.Robot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;
import LPLCoreDriver.WebToolKit.WebTable;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> ClientManagement_Common.java</br>
 * <br><b> Description: </B> Page Object Library and common functions For Client Management</br>
 * <br><b>Usage:</br></b>
 * <br>switchToDefaultOrframe: Method to navigate to frame. </br>
 * <br>switchToTopframe: Method to navigate to Top frame. </br>
 * <br>tabNavigationCM: Method to navigate to various tabs inside CM. </br>
 * <br>search: This function is used to search Account/Client etc in Client Management Application. </br>
 * <br>clickEntity: This function is used to click the link displayed in the search result table. </br>
 * <br>cancelFilters: This function is used to cancel the filters. </br>
 * <br>selectFilter: This function is used to select different Filters. </br>
 * <br>cancelTagFilterValue: This function is used to cancel selected tag filter value. </br>
 * <br>selectTagFilterValue: This function is used to select tag filter value. </br>
 * <br>selectListFilterValue: This function is used to select list filter value. </br>
 * <br>getSelectedTagFilterValueCount: This function is used to get the no of items selected for a tag filter. </br>
 * <br>getTopFilterValueCount: This function is used to get the top level filter value count. </br>
 * <br>applyFilter: This function is used to apply the selected filters. </br>
 * <br>clickListFilterCheckAll: This function is used to click Check All link for List Filter. </br>
 * <br>clickListFilterUnCheckAll: This function is used to get the count of selected items for list filter. </br>
 * <br>getListFilterAllItemsCount: This function is used to get the count of all items for list filter. </br>
 * <br>checkEmptyListFilterValueSelectionMessage: This function is used to verify the empty list filter value selection error message. </br>
 * <br>checkEmptyTagFilterValueSelectionMessage: This function is used to verify the empty tag filter value selection error message. </br>
 * <br>checkTagFilterValueSelection: This function is used to verify the tag filter value selection functionality. </br>
 * <br>checkListFilterValueSelection: This function is used to verify the tag filter value selection functionality. </br>
 * <br>editColumn: This function is used to add/remove column. </br>
 * <br>verifySortColumn: This function is used to verify sorting functionality. </br>
 * <br>infiniteScrollingVerification: This function is used to verify infinite Scrolling. </br>
 * <br>getCurrentQVName: This function is used to get the current Quick view name. </br>
 * <br>switchToQuickView: This function is used to switch to the Quick view we desire. </br>
 * <br>deleteQuickView: This function is used to delete the Quick view we desire. </br>
 * <br>deleteUnWantedQuickViews: This function is used to delete the quick views other than the required ones in any tab of Client Management Application. </br>
 * <br>addSystemQuickViews: This function is used to add system views in any tab of Client Management Application. </br>
 * <br>enterSearchText: This function is used to enter value in search box and click on search button if enabled in any tab of Client Management Application. </br>
 * <br>validateSearchableColumn: This function is used to check if the search is successful in any tab of Client Management Application. </br>
 * <br>validateSearchText: This function is used to check if the search text is present in any tab of Client Management Application. </br>
 * <br>clickOnLinkText: This function is used to click on any Link using the text. </br>
 * <br>editColumnsAddAll: This function is used to click Edit Columns and Add all columns to the grid. </br>
 * <br>validateRangeFilterPopup : This function is used Validate any Range Filter Popup</br>
 * <br>setRangeFilterMinOrMaxValue : This function is to Enter Range Filter Min or Max Value </br>
 * <br> getRangeFilterMinOrMaxValue: This function is to get and validate Range Filter Min or Max Value </br>
 * @author Aiswarya Srinivasan, Ambarish Khatua, Rahul Agarwal, Harishbabu
 * @since 06-02-2016 
 * </p>
 */
public class ClientManagement_Common{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;
		 
	/** CSS Selector property value of Search button */
	public String strSearchButton_css				= "#text-search-button"; 
	
	/** CSS Selector property value of Quick view heading */
	public String strQuickViewHeading_css			= ".panel-heading";
	
	/** CSS Selector property value of Page Header showing the number of records */
	public String strTabPageHeading_css		= "#total-records>.ng-scope>span.ng-binding";
	
	/** id property value of Data table displayed in the page */
	public String strDataTable_id					= "data-table";
	
	/** css selector property value of Data table displayed in the page */
	public String strDataTable_css					= "#data-table";
	
	/** Id property value of Account Search Result Table Header */
	public String strSearchResultTableHeader_Id = "table-header";
	
	/** Tag property value of Search Result row */
	public String strRow_tag = "tr";
	
	/** Tag property value of Search Result column*/
	public String strColumn_tag = "td";

	/** Angular Repeater property value of Search Result column headers */
	public String strColumnHeaders_repeater = "column in dtVm.savedView.columns";
	
	/** CSS Selector property value of CM Tab links */
	public String strCMTabLinks_css				= "#list-nav>ul>li>a";
	
	/** CSS Selector property value of CM Tab links */
	public String strCMTabLinksUnderMore_css	= "#list-nav>ul>li>ul>li>a";
	
	/** Id property value of Account Search Result Table */
	public String strSearchResultTable_Id = "data-table";
	
	/** Angular model property value of Account Search Edit Box. */
	public String strAccountSearchBox_model = "gsVm.searchText";
	
	/** Id property value of Loading Object */
	public String strLoading_Id = "ngProgress-container";
	
	/** Id property value of Loading Object */
	public String strLoading2_Id = "loading-overlay";
	
	/** CSS property value of Filter */
	public String strFilter_CSS = ".btn.btn-default.btn-remove.btn-filter";
	
	/** CSS property value of Add Filter */
	public String strAddFilter_CSS = "#add-filter";
	
	/** CSS property value of Filter Search Edit Box */
	public String strFilterSearch_CSS = "#filter-search";
	
	/** CSS property value of Filter Name Suggestions */
	public String strFilterNameSuggestion_CSS = "#filter-select>li>a.ng-binding";
	
	/** Xpath property value of Tag Filter Value EditBox */
	public String strTagFilterValueEditBox_Xpath = "//div[@id='clientGroupName-filter-menu']//input";
	
	/** CSS property value of Suggestions */
	public String strTagFilterValueSuggestion_CSS = ".suggestion-item.ng-binding.ng-scope";
	
	/** CSS Selector Property of Filter Item link in List Filter*/
	public String strListFilterValueLink_css		= "a.list-group-item.ng-binding.ng-scope";
	
	/** CSS Selector Property of Selected Item link in List Filter*/
	public String strListFilterSelectedItem_css	= "div.list-group.selected-items>a.list-group-item.ng-binding.ng-scope";
	
	/** Xpath property value of Filter Button */
	public String strFilterButton_Xpath = "//div[contains(@id,'filter-menu')]//button[text()='Apply']";
	
	/** Text property value of Apply Filter Button */
	public String strApplyFilter_Text 				= "Apply";
	
	/** Text property value of Cancel Filter Button */
	public String strCancelFilter_Text 				= "Cancel";
	
	/** CSS property value of Selected Tag Filter Items */
	public String strSelectedTagFilterItems_CSS 	= ".tag-item.ng-scope";
	
	/** CSS property value of Selected Filter Items Count */
	public String strSelectedItemsCount_CSS 		= ".filter-label.ng-binding";
	
	/** CSS property value of Selected QuickView */
	public String strCurrentQuickView_CSS 			= "ul#user-saved-views>li.list-group-item.ng-scope.active>a.ng-binding";
	
	/** css Selector property value of user saved quick views */
	public String strQVLinks_css 					= "ul#user-saved-views>li.list-group-item.ng-scope>a.ng-binding";
	
	/** css Selector property value of all quick views */
	public String strQVBlocks_css 					= "ul#user-saved-views>li.list-group-item.ng-scope";
	
	/** css Selector property value of all options under quick view dropdown */
	public String strQVDelete_css 					= "ul#user-saved-views>li.list-group-item.ng-scope>div.btn-group.btn-group-context-actions.ng-hide>div.btn-group>ul.dropdown-menu.dropdown-menu-right>li>a";
	
	/** css Selector property value of all items in the Default quick views selection overlay */
	public String strQVSelectionItems_css 			= "div.checkbox>label";
	
    /** css Selector property value of Apply button in the Default quick views selection overlay */
	public String strQVSelectionApply_css 			= "div#saved-view-selection-modal>div.modal-dialog>div.modal-content>div.modal-footer>button.btn.btn-primary";
	
	/** css Selector property value of all quick views */
	public String strSystemViewsButton_css 		= "button#btn-system-views";
	
	/** css Selector property value of all options under quick view dropdown */
	public String strQVOverlayDelete_css 			= "div#confirmDialog>div.modal-dialog>div.modal-content>div.modal-footer>button.btn.btn-primary.ng-binding";
	
	/** css Selector property value of all quick views */
	public String strQVDropdownArrow_xpath 		= "//button[@data-toggle='dropdown']";//"div.btn-group.btn-group-context-actions.ng-hide>div.btn-group>button";
	
	/** CSS property value of Hidden Column Search Box */
	public String strHiddenColumnSearchBox_CSS 		= "#txtAllColumnSearch";
	
	/** CSS property value of any row in the data table */
	public String strDataTableRows_CSS 				= "tr.tr-items.ng-scope";
	
	/** CSS property value of Display Column Search Box */
	public String strDisplayColumnSearchBox_CSS 	= "#txtSelectedColumnSearch";
	
	/** Xpath property value of Column */
	public String strColumnName_Xpath				= "//span[text()='xxx']";
	
	/** CSS property value of Add/Remove link */
	public String strAddRemoveLink_CSS				= ".list-group-item.ng-scope>.pull-right";
	
	/** CSS property value of Apply button */
	public String strEditColumnApply_CSS			= "#column-selection-modal .btn.btn-primary";
	
	/** Xpath property value of Cancel Tag Filter Value icon */
	public String strCancelTagFilterValue_Xpath		= "//span[text()='xxx']/following-sibling::a";
	
	/** CSS property value of Cancel Tag Filter Value icon */
	public String strCrossTagFilterIcon_CSS			= ".remove-button.ng-binding";
	
	/** CSS property value of Selected Filter Name */
	public String strSelectedFilter_CSS				= ".btn.btn-default.btn-filter.dropdown-toggle";
	
	/** CSS property value of Empty Filter Value Selection Message */
	public String strEmptyWaringMessage_CSS		= ".alert.alert-danger";
	
	/** NG Model property value of List Filter Search Edit Box */
	public String strListFilterSearchBox_Model = "searchTextFilter.label";
	
	/** CSS property value of List Filter Check All Link */
	public String strListFilterCheckAll_CSS		= ".btn.btn-link.btn-check-all.ng-scope";
	
	/** CSS property value of List Filter UnCheck All Link */
	public String strListFilterUnCheckAll_CSS	= ".btn.btn-link.btn-uncheck-all";
	
	/** CSS property value of List Filter All Items */
	public String strListFilterAllItems_CSS		= ".list-group.all-items>.list-group-item.ng-binding.ng-scope";
	
	/** CSS property value of List Filter Displayed Items */
	public String strListFilterDisplayedItems_CSS = ".list-group.selected-items>.list-group-item.ng-binding.ng-scope";
	
	/** CSS property value of Edit Columns button */
	public String strEditColumns_CSS = "#btnEditColumns";
	
	/** CSS Selector property value of Search box */
	public String strSearchBox_css				= "#grid-search";
	
	/** CSS Selector property value of Search able columns */
	public String strAllSearchableColumn_css	= ".ng-scope";
	
	/** CSS Selector property value of Add All links */
	public String strAddAllLinks_css			= "div.panel-heading.expanded>a.pull-right";
	
	/** Text value of Add All links */
	public String strAddAllLink_Text 			= "add all";
	
	public String strAddGlobalFilter_xpath      = "//*[@id='persistent-filters']//button[contains(text(),'Global Filter')]";
	public String strRepId_css                  = "ul#persistent-filter-select>li>a.ng-binding";
	public String strHeader_tag					= "th";
	
	/** Current Page ID from FARM */ 
	public final int INT_PAGEID = 54;
	
	LPLCoreConstents lplCoreConstents;
	
	public ClientManagement_Common(WebDriver driver){
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();
		try{
		/** Fetching Page Object Identification Properties from FARM for current page */ 
		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
		
		if(PageObjectsMap.get("strSearchButton").get("CSS")!=null)
			strSearchButton_css = PageObjectsMap.get("strSearchButton").get("CSS");
		
		if(PageObjectsMap.get("strQuickViewHeading").get("CSS")!=null)
			strQuickViewHeading_css = PageObjectsMap.get("strQuickViewHeading").get("CSS");
		
		if(PageObjectsMap.get("strTabPageHeading").get("CSS")!=null)
			strTabPageHeading_css = PageObjectsMap.get("strTabPageHeading").get("CSS");
		
		if(PageObjectsMap.get("strDataTable").get("ID")!=null)
			strDataTable_id = PageObjectsMap.get("strDataTable").get("ID");
		
		if(PageObjectsMap.get("strDataTable").get("CSS")!=null)
			strDataTable_css = PageObjectsMap.get("strDataTable").get("CSS");
		
		if(PageObjectsMap.get("strSearchResultTableHeader").get("ID")!=null)
			strSearchResultTableHeader_Id = PageObjectsMap.get("strSearchResultTableHeader").get("ID");	
		
		if(PageObjectsMap.get("strRow").get("ID")!=null)
			strRow_tag = PageObjectsMap.get("strRow").get("ID");
		
		if(PageObjectsMap.get("strColumn").get("ID")!=null)
			strColumn_tag = PageObjectsMap.get("strColumn").get("ID");
		
		if(PageObjectsMap.get("strColumnHeaders").get("ANGULARREF")!=null)
			strColumnHeaders_repeater = PageObjectsMap.get("strColumnHeaders").get("ANGULARREF");
		
		if(PageObjectsMap.get("strCMTabLinks").get("CSS")!=null)
			strCMTabLinks_css = PageObjectsMap.get("strCMTabLinks").get("CSS");
		
		if(PageObjectsMap.get("strCMTabLinksUnderMore").get("CSS")!=null)
			strCMTabLinksUnderMore_css = PageObjectsMap.get("strCMTabLinksUnderMore").get("CSS");
		
		if(PageObjectsMap.get("strDataTable").get("ID")!=null)
			strSearchResultTable_Id = PageObjectsMap.get("strDataTable").get("ID");
		
		if(PageObjectsMap.get("strAccountSearchBox").get("ANGULARREF")!=null)
			strAccountSearchBox_model = PageObjectsMap.get("strAccountSearchBox").get("ANGULARREF");
		
		if(PageObjectsMap.get("strLoading").get("ID")!=null)
			strLoading_Id = PageObjectsMap.get("strLoading").get("ID");
		
		if(PageObjectsMap.get("strLoading").get("ID")!=null)
			strLoading2_Id = PageObjectsMap.get("strLoading").get("ID");
		
		if(PageObjectsMap.get("strFilter").get("CSS")!=null)
			strFilter_CSS = PageObjectsMap.get("strFilter").get("CSS");	
		
		if(PageObjectsMap.get("strAddFilter").get("CSS")!=null)
			strAddFilter_CSS = PageObjectsMap.get("strAddFilter").get("CSS");
		
		if(PageObjectsMap.get("strFilterSearch").get("CSS")!=null)
			strFilterSearch_CSS = PageObjectsMap.get("strFilterSearch").get("CSS");
		
		if(PageObjectsMap.get("strFilterNameSuggestion").get("CSS")!=null)
			strFilterNameSuggestion_CSS = PageObjectsMap.get("strFilterNameSuggestion").get("CSS");
		
		if(PageObjectsMap.get("strTagFilterValueEditBox").get("XPATH")!=null)
			strTagFilterValueEditBox_Xpath = PageObjectsMap.get("strTagFilterValueEditBox").get("XPATH");	
		
		if(PageObjectsMap.get("strTagFilterValueSuggestion").get("CSS")!=null)
			strTagFilterValueSuggestion_CSS = PageObjectsMap.get("strTagFilterValueSuggestion").get("CSS");	
		
		if(PageObjectsMap.get("strListFilterValueLink").get("CSS")!=null)
			strListFilterValueLink_css = PageObjectsMap.get("strListFilterValueLink").get("CSS");	
		
		if(PageObjectsMap.get("strListFilterSelectedItem").get("CSS")!=null)
			strListFilterSelectedItem_css = PageObjectsMap.get("strListFilterSelectedItem").get("CSS");
		
		if(PageObjectsMap.get("strFilterButton").get("XPATH")!=null)
			strFilterButton_Xpath = PageObjectsMap.get("strFilterButton").get("XPATH");	
		
		if(PageObjectsMap.get("strApplyFilter").get("ANGULARREF")!=null)
			strApplyFilter_Text = PageObjectsMap.get("strApplyFilter").get("ANGULARREF");
		
		if(PageObjectsMap.get("strCancelFilter").get("ANGULARREF")!=null)
			strCancelFilter_Text = PageObjectsMap.get("strCancelFilter").get("ANGULARREF");
		
		if(PageObjectsMap.get("strSelectedTagFilterItems").get("CSS")!=null)
			strSelectedTagFilterItems_CSS = PageObjectsMap.get("strSelectedTagFilterItems").get("CSS");	
		
		if(PageObjectsMap.get("strSelectedItemsCount").get("CSS")!=null)
			strSelectedItemsCount_CSS = PageObjectsMap.get("strSelectedItemsCount").get("CSS");
		
		if(PageObjectsMap.get("strCurrentQuickView").get("CSS")!=null)
			strCurrentQuickView_CSS = PageObjectsMap.get("strCurrentQuickView").get("CSS");	
		
		if(PageObjectsMap.get("strQVLinks").get("CSS")!=null)
			strQVLinks_css = PageObjectsMap.get("strQVLinks").get("CSS");
		
		if(PageObjectsMap.get("strQVBlocks").get("CSS")!=null)
			strQVBlocks_css = PageObjectsMap.get("strQVBlocks").get("CSS");	
		
		if(PageObjectsMap.get("strQVDelete").get("CSS")!=null)
			strQVDelete_css = PageObjectsMap.get("strQVDelete").get("CSS");	
		
		if(PageObjectsMap.get("strQVSelectionItems").get("CSS")!=null)
			strQVSelectionItems_css = PageObjectsMap.get("strQVSelectionItems").get("CSS");	
		
		if(PageObjectsMap.get("strQVSelectionApply").get("CSS")!=null)
			strQVSelectionApply_css = PageObjectsMap.get("strQVSelectionApply").get("CSS");	
		
		if(PageObjectsMap.get("strSystemViewsButton").get("CSS")!=null)
			strSystemViewsButton_css = PageObjectsMap.get("strSystemViewsButton").get("CSS");
		
		if(PageObjectsMap.get("strQVOverlayDelete").get("CSS")!=null)
			strQVOverlayDelete_css = PageObjectsMap.get("strQVOverlayDelete").get("CSS");	
		
		if(PageObjectsMap.get("strQVDropdownArrow").get("XPATH")!=null)
			strQVDropdownArrow_xpath = PageObjectsMap.get("strQVDropdownArrow").get("XPATH");	
		
		if(PageObjectsMap.get("strHiddenColumnSearchBox").get("CSS")!=null)
			strHiddenColumnSearchBox_CSS = PageObjectsMap.get("strHiddenColumnSearchBox").get("CSS");
		
		if(PageObjectsMap.get("strDataTableRows").get("CSS")!=null)
			strDataTableRows_CSS = PageObjectsMap.get("strDataTableRows").get("CSS");
		
		if(PageObjectsMap.get("strDisplayColumnSearchBox").get("CSS")!=null)
			strDisplayColumnSearchBox_CSS = PageObjectsMap.get("strDisplayColumnSearchBox").get("CSS");
		
		if(PageObjectsMap.get("strColumnName").get("XPATH")!=null)
			strColumnName_Xpath = PageObjectsMap.get("strColumnName").get("XPATH");
		
		if(PageObjectsMap.get("strAddRemoveLink").get("CSS")!=null)
			strAddRemoveLink_CSS = PageObjectsMap.get("strAddRemoveLink").get("CSS");
		
		if(PageObjectsMap.get("strEditColumnApply").get("CSS")!=null)
			strEditColumnApply_CSS = PageObjectsMap.get("strEditColumnApply").get("CSS");
		
		if(PageObjectsMap.get("strCancelTagFilterValue").get("XPATH")!=null)
			strCancelTagFilterValue_Xpath = PageObjectsMap.get("strCancelTagFilterValue").get("XPATH");
		
		if(PageObjectsMap.get("strCrossTagFilterIcon").get("CSS")!=null)
			strCrossTagFilterIcon_CSS = PageObjectsMap.get("strCrossTagFilterIcon").get("CSS");	
		
		if(PageObjectsMap.get("strSelectedFilter").get("CSS")!=null)
			strSelectedFilter_CSS = PageObjectsMap.get("strSelectedFilter").get("CSS");
		
		if(PageObjectsMap.get("strEmptyWaringMessage").get("CSS")!=null)
			strEmptyWaringMessage_CSS = PageObjectsMap.get("strEmptyWaringMessage").get("CSS");
		
		if(PageObjectsMap.get("strListFilterSearchBox").get("ANGULARREF")!=null)
			strListFilterSearchBox_Model = PageObjectsMap.get("strListFilterSearchBox").get("ANGULARREF");
		
		if(PageObjectsMap.get("strListFilterCheckAll").get("CSS")!=null)
			strListFilterCheckAll_CSS = PageObjectsMap.get("strListFilterCheckAll").get("CSS");
		
		if(PageObjectsMap.get("strListFilterUnCheckAll").get("CSS")!=null)
			strListFilterUnCheckAll_CSS = PageObjectsMap.get("strListFilterUnCheckAll").get("CSS");
		
		if(PageObjectsMap.get("strListFilterAllItems").get("CSS")!=null)
			strListFilterAllItems_CSS = PageObjectsMap.get("strListFilterAllItems").get("CSS");	
		
		if(PageObjectsMap.get("strListFilterDisplayedItems").get("CSS")!=null)
			strListFilterDisplayedItems_CSS = PageObjectsMap.get("strListFilterDisplayedItems").get("CSS");	
		
		if(PageObjectsMap.get("strEditColumns").get("CSS")!=null)
			strEditColumns_CSS = PageObjectsMap.get("strEditColumns").get("CSS");
		
		if(PageObjectsMap.get("strSearchBox").get("CSS")!=null)
			strSearchBox_css = PageObjectsMap.get("strSearchBox").get("CSS");
		
		if(PageObjectsMap.get("strAllSearchableColumn").get("CSS")!=null)
			strAllSearchableColumn_css = PageObjectsMap.get("strAllSearchableColumn").get("CSS");
		
		if(PageObjectsMap.get("strAddGlobalFilter").get("XPATH")!=null)
			strAddGlobalFilter_xpath = PageObjectsMap.get("strAddGlobalFilter").get("XPATH");
		
		if(PageObjectsMap.get("strRepId").get("CSS")!=null)
			strRepId_css = PageObjectsMap.get("strRepId").get("CSS");
		
		if(PageObjectsMap.get("strHeader").get("ID")!=null)
			strHeader_tag = PageObjectsMap.get("strHeader").get("ID");
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			LPLCoreReporter.WriteReport("Initialization of CM common page", "Object should be successfully created for CM common page", "Failed to create the object of CM common page. Error:"+ex.toString(), "Failed", "");
		}
		}
	
	public boolean waitforCMTableToLoad(){
		try{
			// Wait for the table to get loaded...
			LPLCoreSync.waitTillInVisible(driver, By.id(strLoading_Id), lplCoreConstents.LOW);
			WebTable table = new WebTable(null, By.tagName(strRow_tag), null);
			table.waitTillTableLoaded(driver, By.id(strDataTable_id), lplCoreConstents.HIGHEST);
			return true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to navigate to frame
	 * @author Aiswarya Srinivasan
	 * @since 06-07-2016
	 * @param None
	 * @return N/A
	 * 
	 */
	public void switchToDefaultOrframe() {
		try {
			driver.switchTo().frame(driver.findElement(By.id("containerFrame")));
		} catch (Exception e) {
			driver.switchTo().defaultContent();
		}
	}
	
	/**
	 * Method to navigate to Top frame
	 * @author Aiswarya Srinivasan
	 * @since 06-07-2016
	 * @param None
	 * @return N/A
	 * 
	 */
	public void switchToTopframe() {
		try {
			driver.switchTo().frame(driver.findElement(By.id("containerFrame")));
		} catch (Exception e) {
			driver.switchTo().defaultContent();
		}
	}
	
	/**
	 * Method to navigate to various tabs inside CM
	 * @author Aiswarya Srinivasan
	 * @since 06-02-2016
	 * @param strTabLink - Tab name
	 * 
	 */
	public boolean tabNavigationCM(String strCWMainMenu, String strCMSubMenu){
		
		try{
			boolean blnresult= false;
			HomePage homePage = new HomePage(driver);
			homePage.waitForPageLoading(lplCoreConstents.MEDIUM);
			blnresult = homePage.navigateToCWMenu(strCWMainMenu, "");
			homePage.waitForPageLoading(lplCoreConstents.LOW);
			driver.navigate().refresh();
			homePage.waitForPageLoading(lplCoreConstents.MEDIUM);

			try {
				//Click on the Tab link
				driver.findElement(ByAngular.cssContainingText(strCMTabLinks_css,strCMSubMenu )).click();
			} catch (Exception e) {
				//If not found, Click on More
				WebElement objMoreLink = driver.findElement(ByAngular.cssContainingText(strCMTabLinks_css,"More"));
				objMoreLink.click();
				
				//Wait for few seconds
				LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
				
				//Click on the Tab link now which is inside More
				WebElement objLink = driver.findElement(ByAngular.cssContainingText(strCMTabLinksUnderMore_css,strCMSubMenu));
				objLink.click();
			}
			homePage.waitForPageLoading(lplCoreConstents.MEDIUM);
			
			blnresult= true;
		return blnresult;
			
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * This function is used to search Account/Client etc in Client Management Application
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-02-2016
	 * @param strToBeSearched - Value to searched for
	 * @return boolean True if Search is performed successfully and False if failed to search
	 */
	public boolean search(String strToBeSearched) {
		boolean blnReturn = false;

		try {
			// Wait for the table to get loaded.
			driver.manage().timeouts().implicitlyWait(lplCoreConstents.FAIR, TimeUnit.SECONDS);
			

			// Create the object for 'Account Search EditBox' and 'Search Button'
			WebElement objAccountSearchBox = driver.findElement(ByAngular.model(strAccountSearchBox_model));
			WebElement objSearchButton = driver.findElement(ByAngular.cssContainingText(strSearchButton_css, ""));

			// If the 'Account Search EditBox' is displayed, enter the Account No to be searched
			if (objAccountSearchBox.isDisplayed()) {
				objAccountSearchBox.sendKeys(strToBeSearched);
			} else {
				strError = "Search EditBox is not displayed.";
				blnReturn = false;
			}

			// If the 'Search Button' is displayed, click on it
			if (objSearchButton.isDisplayed()) {
				objSearchButton.click();
				blnReturn = true;
			} else {
				strError = "Search EditBox is not displayed.";
				blnReturn = false;
			}
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to click the link displayed in the search result table
	 * result.
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-02-2016
	 * @param strText - Text of the link to be clicked
	 * @return boolean True if link is clicked successfully and False if failed
	 */
	public boolean clickEntity(String strText) {
        boolean blnReturn = false;
        Integer[] cellIndex;
        try {
               // Wait for the table to get loaded.
               HomePage hPage = new HomePage(driver);
               hPage.waitForPageLoading(lplCoreConstents.BASE);
               
               // Create the WebTable utility class object
               WebTable webTable = new WebTable(null, By.tagName(strRow_tag), By.tagName(strColumn_tag));
                                   
               // Create the WebTable Search Result Table
               WebElement objSearchResult = driver.findElement(By.id(strSearchResultTable_Id));

               if (objSearchResult.isDisplayed()) {
                     // Get the cell index with the specified value
                     cellIndex = webTable.getCellIndex(objSearchResult, strText);
                     
                     if(cellIndex == null){
                            strText = "xxxx"+"-"+strText.split("-")[1];
                     }
               }
               
               // Create the link object displayed in search result table
               WebElement objLink = driver.findElement(By.linkText(strText));

               // If the link object is displayed, click on it.
               if (objLink.isDisplayed()) {
                     objLink.click();
                     blnReturn = true;
               } else {
                     strError = strError + " Link is not displayed";
                     blnReturn = false;
               }
               return blnReturn;
        } catch (Exception e) {
               strError = e.toString();
               return blnReturn;
        }
 }

	
	/**
	 * This function is used to cancel the filters
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-03-2016
	 * @param N/A
	 * @return boolean True if all the filters have been closed and False if not
	 */
	public boolean cancelFilters() {
		boolean blnResult  = false;
		try {
			// Wait for the table to get loaded.
			waitforCMTableToLoad();

			// Get all the Filter objects
			if(LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strFilter_CSS, ""), lplCoreConstents.LOW)){
				List<WebElement> lstFilters = driver.findElements(ByAngular.cssContainingText(strFilter_CSS, ""));
	
				// Close all the filter objects....
				if(!lstFilters.isEmpty()){
					for(WebElement objFilter : lstFilters){
						objFilter.click();
						if(waitforCMTableToLoad()){
							blnResult=true;
						}
					}
				}
							
				// Wait for the table to get loaded.
				HomePage homePage = new HomePage(driver);
				homePage.waitForPageLoading(lplCoreConstents.HIGH);
			}else{
				blnResult=true;
			}
			
			return blnResult;
		} catch (Exception e) {
			strError = e.toString();
			return false;
		}
	}
	
	/**
	 * This function is used to select different Filters
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-08-2016
	 * @param strFilterName - Filter Name
	 * @return boolean True if the Filter is selected successfully and False if failed
	 */
	public boolean selectFilter(String strFilterName) {
		boolean blnReturn = false;

		try {
			// Wait for the table to get loaded.
			waitforCMTableToLoad();

			// Create the Add Filter Object...
			WebElement objFilter = driver.findElement(ByAngular.cssContainingText(strAddFilter_CSS, ""));
			if (objFilter.isDisplayed()){
				objFilter.click();
				
				// Create the Filter Search EditBox object
				WebElement objFilterSearch = driver.findElement(ByAngular.cssContainingText(strFilterSearch_CSS, ""));
				
				// Enter the Filter Name
				objFilterSearch.sendKeys(strFilterName);
				
				// Select the Filter
				WebElement objFilterName = driver.findElement(ByAngular.cssContainingText(strFilterNameSuggestion_CSS, strFilterName));
				objFilterName.click();
				blnReturn = true;
			}			
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to cancel selected tag filter value
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-20-2016
	 * @param strFilterName - Filter Name
	 * @return boolean True if the Filter value is canceled successfully and False if failed
	 */
	public boolean cancelTagFilterValue(String strFilterName) {
		boolean blnReturn = false;

		try {
			// Wait for the table to get loaded.
			waitforCMTableToLoad();

			// Create the Add Filter Object...
			WebElement objFilterValueCancel = driver.findElement(By.xpath(strCancelTagFilterValue_Xpath.replace("xxx", strFilterName)));
			
			if(objFilterValueCancel.isDisplayed()){
				objFilterValueCancel.click();
				blnReturn = true;
			}
			
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to select tag filter value
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-08-2016
	 * @param strFilterValue - Array of Filter Values
	 * @return boolean True if the Filter Value is selected successfully and False if failed
	 */
	public boolean selectTagFilterValue(String[] strFilterValues) {
		boolean blnReturn = false;

		try {

			// Create the Filter Value EditBox object...
			LPLCoreSync.waitTillVisible(driver, By.xpath(strTagFilterValueEditBox_Xpath), lplCoreConstents.BASE);
			WebElement objFilterValueEditBox = driver.findElement(By.xpath(strTagFilterValueEditBox_Xpath));
			
			if (objFilterValueEditBox.isDisplayed()){
				
				//Enter the Filter Value
				for(String strValue : strFilterValues){
					//Update the initial value as False
					blnReturn = false;
					
					//Enter the Filter Value
					objFilterValueEditBox.sendKeys(strValue);
					LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
					
					//Get the Suggestion objects as per the value entered
					List<WebElement> lstSuggestions = driver.findElements(By.cssSelector(strTagFilterValueSuggestion_CSS));
					
					//Iterate through all the suggestions and select the actual matched one
					for(WebElement objSuggestion : lstSuggestions){
						
						//Select the suggestion object that matches with the actual value
						if(objSuggestion.getText().trim().equalsIgnoreCase(strValue)){
							objSuggestion.click();
							LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
							blnReturn = true;
							break;
						}
					}
				}
			}	
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to select list filter value
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-21-2016
	 * @param strFilterValue - Array of Filter Values
	 * @return boolean True if the Filter Value is selected successfully and False if failed
	 */
	public boolean selectListFilterValue(String[] strFilterValues) {
		boolean blnReturn = false;

		try {
			//First Uncheck All to de-select all the previously selected values
			clickListFilterUnCheckAll();
			
			// Create the Filter Value EditBox object...
			WebElement objFilterValueEditBox = driver.findElement(ByAngular.model(strListFilterSearchBox_Model));
			if (objFilterValueEditBox.isDisplayed()){
				//Enter the Filter Value
				for(String strValue : strFilterValues){
					//Update the initial value as False
					blnReturn = false;
					
					//Before entering the filter Value, clean it.
					objFilterValueEditBox.clear();
					
					//Enter the Filter Value
					objFilterValueEditBox.sendKeys(strValue);
					
					//Get the list filter item
					WebElement objListFilterItem = driver.findElement(ByAngular.cssContainingText(strListFilterAllItems_CSS, strValue));
					if(objListFilterItem.isDisplayed()){
						objListFilterItem.click();
						blnReturn = true;
					}					
				}
			}	
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to get the no of items selected for a tag filter
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-08-2016
	 * @param N/A
	 * @return (int) Selected Filter Count
	 */
	public int getSelectedTagFilterValueCount() {
		int intSelectedFilterCount = -1;

		try {
			//Create the selected filters objects
			List<WebElement> lstSelectedFilters = driver.findElements(ByAngular.cssContainingText(strSelectedTagFilterItems_CSS, ""));
			
			//Get the selected filter count
			intSelectedFilterCount = lstSelectedFilters.size();
			
			return intSelectedFilterCount;
			
		} catch (Exception e) {
			strError = e.toString();
			return intSelectedFilterCount;
		}
	}
	
	/**
	 * This function is used to get the top level filter value count
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-20-2016
	 * @param N/A
	 * @return (int) Selected Filter Value Count
	 */
	public int getTopFilterValueCount() {
		int intSelectedFilterCount = -1;

		try {
			//Create the selected filter values count objects
			WebElement objSelectCount = driver.findElement(ByAngular.cssContainingText(strSelectedItemsCount_CSS, ""));
			
			//Get the  top level filter value count
			intSelectedFilterCount = Integer.valueOf(objSelectCount.getText().split(" ")[0]);
			
			return intSelectedFilterCount;
			
		} catch (Exception e) {
			strError = e.toString();
			return intSelectedFilterCount;
		}
	}
	
	/**
	 * This function is used to apply the selected filters
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-08-2016
	 * @param N/A
	 * @return boolean true if the filters are selected and false if not
	 */
	public boolean applyFilter() {
		boolean blnReturn = false;

		try {
			//Create the Apply button
			WebElement objApplyFilter = driver.findElement(By.xpath(strFilterButton_Xpath));
			
			//If the Apply button is displayed, click on it.
			if (objApplyFilter.isDisplayed()){
				objApplyFilter.click();
				blnReturn = true;
			}			
				
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to click Check All link for List Filter
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-21-2016
	 * @param N/A
	 * @return boolean true if the Check All link is clicked and false if not. 
	 */
	public boolean clickListFilterCheckAll() {
		boolean blnReturn = false;

		try {
			//Create the Check All Object
			WebElement objListFilterCheckAll = driver.findElement(By.cssSelector(strListFilterCheckAll_CSS));
			
			//If the Check All Object is displayed, click on it.
			if (objListFilterCheckAll.isDisplayed()){
				objListFilterCheckAll.click();
				blnReturn = true;
			}			
				
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to click UnCheck All link for List Filter
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-21-2016
	 * @param N/A
	 * @return boolean true if the UnCheck All link is clicked and false if not. 
	 */
	public boolean clickListFilterUnCheckAll() {
		boolean blnReturn = false;

		try {
			//Create the UnCheck All Object
			WebElement objListFilterUnCheckAll = driver.findElement(By.cssSelector(strListFilterUnCheckAll_CSS));
			
			//If the UnCheck All Object is displayed, click on it.
			if (objListFilterUnCheckAll.isDisplayed()){
				objListFilterUnCheckAll.click();
				blnReturn = true;
			}			
				
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to get the count of selected items for list filter
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-21-2016
	 * @param N/A
	 * @return int intCount: count of selected items and -1 in case of failure
	 */
	public int getListFilterSelectedItemsCount() {
		int intCount = -1;

		try {
			//Get all the selected filter items 
			List<WebElement> lstSelectedItems = driver.findElements(By.cssSelector(strListFilterDisplayedItems_CSS));
			
			//Get the count of selected items
			intCount = lstSelectedItems.size();			
				
			return intCount;
		} catch (Exception e) {
			strError = e.toString();
			return intCount;
		}
	}
	
	/**
	 * This function is used to get the count of all items for list filter
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-21-2016
	 * @param N/A
	 * @return int intCount: count of all items and -1 in case of failure
	 */
	public int getListFilterAllItemsCount() {
		int intCount = -1;

		try {
			//Get all the all filter items 
			List<WebElement> lstAllItems = driver.findElements(By.cssSelector(strListFilterAllItems_CSS));
			
			//Get the count of all items
			intCount = lstAllItems.size();			
				
			return intCount;
		} catch (Exception e) {
			strError = e.toString();
			return intCount;
		}
	}
	
	/**
	 * This function is used to verify the empty list filter value selection error message
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-21-2016
	 * @param N/A
	 * @return boolean true if the error message is displayed and false if not
	 */
	public boolean checkEmptyListFilterValueSelectionMessage() {
		boolean blnReturn = false;

		try {
			//Create the Apply button
			WebElement objApplyFilter = driver.findElement(By.xpath(strFilterButton_Xpath));
			
			//If the Apply button is displayed, click on it.
			if (!objApplyFilter.isDisplayed()){
				driver.findElement(ByAngular.cssContainingText(strSelectedFilter_CSS, "")).click();
			}
			
			//Uncheck all the previously selected items.
			clickListFilterUnCheckAll();
			
			//Click on Apply button
			driver.findElement(By.xpath(strFilterButton_Xpath)).click();
			LPLCoreSync.waitTillVisible(driver, By.cssSelector(strEmptyWaringMessage_CSS), lplCoreConstents.MEDIUM);
			
			//Verify if the warning message has been displayed or not
			if(driver.findElement(By.cssSelector(strEmptyWaringMessage_CSS)).isDisplayed()){
				blnReturn = true;
			}
				
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
		
	/**
	 * This function is used to verify the empty tag filter value selection error message
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-20-2016
	 * @param N/A
	 * @return boolean true if the error message is displayed and false if not
	 */
	public boolean checkEmptyTagFilterValueSelectionMessage() {
		boolean blnReturn = false;

		try {
			//Create the Apply button
			WebElement objApplyFilter = driver.findElement(By.xpath(strFilterButton_Xpath));
			
			//If the Apply button is displayed, click on it.
			if (!objApplyFilter.isDisplayed()){
				driver.findElement(ByAngular.cssContainingText(strSelectedFilter_CSS, "")).click();
			}
			
			//Get the list of all Cross Icons
			List<WebElement> lstCrossIcon = driver.findElements(ByAngular.cssContainingText(strCrossTagFilterIcon_CSS, ""));
			
			//Click on the cross icons to cancel all the selected filters.
			for(WebElement crossFilter : lstCrossIcon){
				crossFilter.click();
			}
			//wait till element is invisible
			if(!LPLCoreSync.waitTillClickable(driver, ByAngular.cssContainingText(strCrossTagFilterIcon_CSS, ""), lplCoreConstents.MEDIUM)){
				//Click on the Apply button
				driver.findElement(By.xpath(strFilterButton_Xpath)).click();
				LPLCoreSync.waitTillVisible(driver, By.cssSelector(strEmptyWaringMessage_CSS), lplCoreConstents.MEDIUM);
				
				//Verify if the warning message has been displayed or not
				if(driver.findElement(By.cssSelector(strEmptyWaringMessage_CSS)).isDisplayed()){
					blnReturn = true;
				}
			}
				
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to verify the tag filter value selection functionality
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-20-2016
	 * @param String strFilterValue - Sample Filter Value to be used for searching
	 * @return boolean true if the successfully verified tag filter value selection and false if failed
	 */
	public boolean checkTagFilterValueSelection(String strFilterValue) {
		boolean blnReturn = false;

		try {
			// Create the Filter Value EditBox object...
			LPLCoreSync.waitTillVisible(driver, By.xpath(strTagFilterValueEditBox_Xpath), lplCoreConstents.BASE);
			WebElement objFilterValueEditBox = driver.findElement(By.xpath(strTagFilterValueEditBox_Xpath));
			
			if (objFilterValueEditBox.isDisplayed()){
				//Clear the edit box
				objFilterValueEditBox.clear();
				
				//Enter the Filter Value
				objFilterValueEditBox.sendKeys(strFilterValue);
				
				//Get the Suggestion objects as per the value entered
				List<WebElement> lstSuggestions = driver.findElements(By.cssSelector(strTagFilterValueSuggestion_CSS));
				
				//Verify the suggestion count
				if(strFilterValue.length() <3){		/** If the filter value is of less than 3 characters, */
					if (lstSuggestions.size() == 0)	/** then there should not be any suggestion values */
						blnReturn = true;
					else
						blnReturn = false;
				}else{								/** If the filter value is of minimum 3 characters, */
					if (lstSuggestions.size() == 0) /** then there should be suggestion values */
						blnReturn = false;
					else
						blnReturn = true;
				}
				
				return blnReturn;
			}
				
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to verify the tag filter value selection functionality.
	 * 
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-20-2016
	 * @param String strFilterValue - Sample Filter Value to be used for searching
	 * @return boolean true if the successfully verified list filter value selection and false if failed
	 */
	public boolean checkListFilterValueSelection(String strFilterValue) {
		boolean blnReturn = false;

		try {
			// Create the List Filter Value EditBox object...
			WebElement objListFilterValueEditBox = driver.findElement(ByAngular.model(strListFilterSearchBox_Model));
			if (objListFilterValueEditBox.isDisplayed()){
				//Clear the edit box
				objListFilterValueEditBox.clear();
				
				//Enter the Filter Value
				objListFilterValueEditBox.sendKeys(strFilterValue);
				
				//Get the list of list filter values
				List<WebElement> lstListFilterValueSuggestions = driver.findElements(By.cssSelector(strListFilterAllItems_CSS));
				
				//Verify the if the suggestion words contains the searched characters.
				blnReturn = true;
				for(WebElement objSuggestion : lstListFilterValueSuggestions){
					if(!objSuggestion.getText().toLowerCase().contains(strFilterValue.toLowerCase()))
						blnReturn = false;
				}
				
				return blnReturn;
			}
				
			return blnReturn;
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used to add/remove column
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-08-2016
	 * @param String strOperation - Add/Edit Operation, String strColumnName - Column Name
	 * @return boolean true if the filters are selected and false if not
	 */
	public boolean editColumn(String strOperation, String strColumn){
		WebElement objHiddenColumnSearchBox;
		WebElement objDisplayColumnSearchBox;
		WebElement objColumnName;
		Actions action = new Actions(driver);
		boolean blnResult = false;
		
		//Click on EditColumn button
		WebElement objEditColumn = driver.findElement(By.cssSelector(strEditColumns_CSS));
		if(objEditColumn.isDisplayed()){
			objEditColumn.click();
		}
		
		//Perform the Add/Remove Column
		switch(strOperation.toUpperCase()){			
			case "ADD":
				//Wait for the Hidden Column SearchBox and enter the Column name
				new WebDriverWait(driver, lplCoreConstents.BASE).until(ExpectedConditions.visibilityOfElementLocated(ByAngular.cssContainingText(strHiddenColumnSearchBox_CSS, "")));
				objHiddenColumnSearchBox = driver.findElement(ByAngular.cssContainingText(strHiddenColumnSearchBox_CSS, ""));
				objHiddenColumnSearchBox.click();
				objHiddenColumnSearchBox.sendKeys(strColumn);
				
				//Wait for the Column Name to be displayed...
				new WebDriverWait(driver, lplCoreConstents.BASE).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strColumnName_Xpath.replace("xxx", strColumn))));
				objColumnName 			 = driver.findElement(By.xpath(strColumnName_Xpath.replace("xxx", strColumn)));
				
				//Move mouse over to the Column name object
				action.moveToElement(objColumnName).build().perform();
				
				//Click on the "add" link
				new WebDriverWait(driver, lplCoreConstents.BASE).until(ExpectedConditions.visibilityOfElementLocated(ByAngular.cssContainingText(strAddRemoveLink_CSS, "add")));
				driver.findElement(ByAngular.cssContainingText(strAddRemoveLink_CSS, "add")).click();
				blnResult = true;
				break;
			case "REMOVE":
				//Wait for the Display Column SearchBox and enter the Column name
				new WebDriverWait(driver, lplCoreConstents.BASE).until(ExpectedConditions.visibilityOfElementLocated(ByAngular.cssContainingText(strDisplayColumnSearchBox_CSS, "")));
				objDisplayColumnSearchBox = driver.findElement(ByAngular.cssContainingText(strDisplayColumnSearchBox_CSS, ""));	
				objDisplayColumnSearchBox.click();
				objDisplayColumnSearchBox.sendKeys(strColumn);
				
				//Wait for the Column Name to be displayed...
				new WebDriverWait(driver, lplCoreConstents.BASE).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(strColumnName_Xpath.replace("xxx", strColumn))));
				objColumnName 			 = driver.findElement(By.xpath(strColumnName_Xpath.replace("xxx", strColumn)));
				
				//Move mouse over to the Column name object
				action.moveToElement(objColumnName).build().perform();
				
				//Click on the "remove" link
				new WebDriverWait(driver, lplCoreConstents.BASE).until(ExpectedConditions.visibilityOfElementLocated(ByAngular.cssContainingText(strAddRemoveLink_CSS, "remove")));
				driver.findElement(ByAngular.cssContainingText(strAddRemoveLink_CSS, "remove")).click();
				blnResult = true;
				break;
		}
		//Click on Apply Button
		LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
		WebElement objApply = driver.findElement(By.cssSelector(strEditColumnApply_CSS));
		if (objApply.isDisplayed()){
			objApply.click();
			blnResult = true;
		}
		return blnResult;
	}
	
	/**
	 * This function is used to verify sorting functionality
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-24-2016
	 * @param String strColumnName - Column Name
	 * @return boolean true if the sorting is verified and false if not
	 */
	public boolean verifySortColumn(String strColumnName){
		boolean blnResult = false;
		String strCellValue;
		ArrayList<String> lstColumnData = new ArrayList<String>();
		ArrayList<String> lstCopyOfColumnData = new ArrayList<String>();
		NavigableMap <Integer, String> dataMap = new TreeMap <Integer, String> ();
		
		try{
			//Create the WbTable object
			WebTable objTable = new WebTable(ByAngular.repeater(strColumnHeaders_repeater),By.tagName(strRow_tag), By.tagName(strColumn_tag));
			//Wait till the search result table is loaded properly
			waitforCMTableToLoad();
			//Get Column Index
			int intColumnIndex = objTable.getColumnIndex(driver.findElement(By.id(strSearchResultTableHeader_Id)), strColumnName);
			//Get Total Rows Count
			int totalRowCount =  objTable.getRowCount(driver.findElement(By.id(strDataTable_id)));
			
			//Navigate through all the visible rows and fetch the cell data
			for(int intRowIndex=1; intRowIndex<=totalRowCount;intRowIndex++){
				strCellValue = objTable.getCellValue(driver.findElement(By.id(strDataTable_id)), intRowIndex, intColumnIndex).trim();
				//Add the values to ArrayList
				lstColumnData.add(strCellValue);
				//Add the values to TreeMap so that it is automatically sorted.
				dataMap.put(intRowIndex, strCellValue);
			}
			
			//Create another ArrayList with all the values stored in the TreeMap
			lstCopyOfColumnData = new ArrayList<String>(dataMap.values());
			
			//Verify the data stored in TreeMap with the ones displayed in application
			if(lstColumnData.equals(lstCopyOfColumnData))
				blnResult = true;
			else{
				//Reverse the all the data and compare again
				Collections.reverse(lstCopyOfColumnData);
				if(lstColumnData.equals(lstCopyOfColumnData))
					blnResult = true;
				else
					blnResult = false;
			}
			return blnResult;
		}catch(Exception e){
			strError = e.toString();
			return blnResult;
		}		
	}
	
	/**
	 * This function is used to verify infinite Scrolling
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 06-20-2016
	 * @param String strTabOrPage - The CM Tab or page in which Infinite scrolling needs to be tested
	 * @return boolean true if verified Infinite scrolling and false if not
	 */
	public boolean infiniteScrollingVerification(){
		try {
			boolean blnLoading = true,blnRowDifference = true;
			//Wait till Table is loaded.
			LPLCoreSync.waitTillInVisible(driver, By.id(strLoading_Id), lplCoreConstents.HIGH);
			
			WebElement tableInCM = driver.findElement(By.id(strDataTable_id));
			
			List<WebElement> tableRows = tableInCM.findElements(By.tagName(strRow_tag));
			int intRowsBefore = tableRows.size();
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", tableRows.get(tableRows.size()-1));
			
			// If the Loading ID appears after scrolling to last element, then loading boolean value turns true
			try{
				WebElement objLoading = LPLCoreSync.waitForWebElements(driver,5, By.id(strLoading2_Id), By.id(strLoading_Id));
				if(objLoading.isDisplayed()){
					blnLoading = true;
				}
			}catch(Exception ee){
				ee.printStackTrace();
				blnLoading = false;
			}
			
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			
			//Check if number of rows increased after loading
			List<WebElement> tableRowsAfter = tableInCM.findElements(By.tagName(strRow_tag));
			int intRowsAfter = tableRowsAfter.size();
			
			if(!(intRowsAfter-intRowsBefore>0)){
				blnRowDifference = false;
			}
			
			js = null;
			
			//If both loading and row difference passed, Then pass the Infinite scrolling method
			if(blnLoading & blnRowDifference){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			strError = strError + " Error: " + e.getMessage();
			return false;
		}
	}
	
	
	
	/**
	 * This function is used to get the current Quick view name
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 06-20-2016
	 * @param None
	 * @return String value - which will have the default quick view's name
	 */
	public String getCurrentQVName()throws Exception{
		HomePage hp = new HomePage(driver);
		//Wait till Table is loaded.
		waitforCMTableToLoad();
		hp.waitForPageLoading(lplCoreConstents.MEDIUM);
		
		return driver.findElement(ByAngular.cssContainingText(strCurrentQuickView_CSS, "")).getText();
	}

	/**
	 * This function is used to switch to the Quick view we desire
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 06-20-2016
	 * @param String strQuickViewName
	 * @return boolean true if Switched to the mentioned QuickView else false
	 */
	public boolean switchToQuickView(String strQuickViewName)throws Exception{
		HomePage hp = new HomePage(driver);
		//Wait till Table is loaded.
		waitforCMTableToLoad();
		
		//If the current quick view is not what we prefer, then click on it
		if(!getCurrentQVName().equalsIgnoreCase(strQuickViewName)){
			
			//Clicks on the Required quick view
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", driver.findElement(ByAngular.cssContainingText(strQVLinks_css, strQuickViewName)));
			hp.waitForPageLoading(lplCoreConstents.MEDIUM);
			
			//Wait till Table is loaded.
			waitforCMTableToLoad();
		}
		
		//Now, if the current quick view is not what we prefer, fail the function, else pass it
		if(driver.findElement(ByAngular.cssContainingText(strCurrentQuickView_CSS, strQuickViewName)).isDisplayed()){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * This function is used to delete the Quick view we desire
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 06-21-2016
	 * @param String strQuickViewName
	 * @return boolean true if deleted the mentioned QuickView else false
	 */
	public boolean deleteQuickView(String strQuickViewName)throws Exception{
		try {
			HomePage hp = new HomePage(driver);
			//Wait till Table is loaded.
			waitforCMTableToLoad();
			
			//Click on the Dropdown arrow
			List<WebElement> objQVBlocks = driver.findElements(ByAngular.cssContainingText(strQVBlocks_css, ""));
			for(WebElement objQVBlock: objQVBlocks){
				if(objQVBlock.getText().trim().equalsIgnoreCase(strQuickViewName)){
					WebElement objQVDDArrow = objQVBlock.findElement(By.xpath(strQVDropdownArrow_xpath));
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", objQVDDArrow);
					
					hp.waitForPageLoading(lplCoreConstents.HIGH);
					
					//Click on Delete Option
					WebElement objDelete = objQVBlock.findElement(ByAngular.cssContainingText(strQVDelete_css, "Delete"));
					js.executeScript("arguments[0].click();", objDelete);
					
					hp.waitForPageLoading(lplCoreConstents.HIGH);
					
					//Click on delete in the confirmation pop up
					LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strQVOverlayDelete_css, "Delete"), lplCoreConstents.MediumInMiliSec);
					driver.findElement(ByAngular.cssContainingText(strQVOverlayDelete_css, "Delete")).click();
					
					hp.waitForPageLoading(lplCoreConstents.HIGH);
					break;
				}
			}
			
			//Wait till Table is loaded.
			waitforCMTableToLoad();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * This function is used to delete the quick views other than the required ones in any tab of Client Management Application
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 06-21-2016
	 * @param strRequiredQuickViews - value having semicolon separated names of quick views that are required
	 * @return boolean True if other quick views are deleted successfully and False if failed to delete
	 */
	public boolean deleteUnWantedQuickViews(String strRequiredQuickViews){
		try {
			String[] arrRequiredQVs = strRequiredQuickViews.split(";");
			String d="";
			boolean blnRequired = false;
			
			//Wait till Table is loaded.
			waitforCMTableToLoad();
			
			//Loop through all the quick views and Check whether the QV is required or not, if not required , then delete that quick view
			List<WebElement> objAvailableQuickViews = driver.findElements(ByAngular.cssContainingText(strQVLinks_css, ""));
			for(WebElement thisElem : objAvailableQuickViews){
				for(String strQV: arrRequiredQVs){
					if(thisElem.getText().trim().equalsIgnoreCase(strQV)){
						blnRequired = true;
						break;
					}
				}
				
				if(!blnRequired){
					d=d+";"+thisElem.getText().trim();
				}
				blnRequired = false;
			}
			for(String strDeletableView : d.split(";")){
				if(!strDeletableView.isEmpty())
					deleteQuickView(strDeletableView);
			}
			
			arrRequiredQVs= null;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * This function is used to add system views in any tab of Client Management Application
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 06-21-2016
	 * @param None
	 * @return boolean True if other quick views are added and deleted successfully else False
	 */
	public boolean addSystemQuickViews(String strRequiredQuickViews)throws Exception{
		HomePage hp = new HomePage(driver);
		String[] arrRequiredQVs = strRequiredQuickViews.split(";");
		
		//Get all the quick views and get the number
		List<WebElement> objAvailableQuickViews = driver.findElements(ByAngular.cssContainingText(strQVLinks_css, ""));
		int intBeforeOperation = objAvailableQuickViews.size(); 
		
		WebElement objSystemViewsButton = driver.findElement(ByAngular.cssContainingText(strSystemViewsButton_css, ""));
		objSystemViewsButton.click();
		
		hp.waitForPageLoading(lplCoreConstents.HIGH);
		
		//Add the system quick views to the quick view list again.
		List<WebElement> objQuickViewSelectionItems = driver.findElements(ByAngular.cssContainingText(strQVSelectionItems_css, ""));
		for(WebElement thisOne: objQuickViewSelectionItems){
			for(String thisString: arrRequiredQVs){
				if(thisOne.getText().trim().contains(thisString)){
					thisOne.findElement(By.tagName("input")).click();
					break;
				}
			}
		}
		
		//Click on Apply
		WebElement objApply = driver.findElement(ByAngular.cssContainingText(strQVSelectionApply_css, "Apply"));
		objApply.click();
		
		LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
		
		//Get all the quick views and get the number
		List<WebElement> objAvailableQuickViews2 = driver.findElements(ByAngular.cssContainingText(strQVLinks_css, ""));
		int intAfterOperation = objAvailableQuickViews2.size();
		
		arrRequiredQVs= null;
		if(intAfterOperation-intBeforeOperation!=0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * This function is used to enter value in search box and click on search button if enabled in any tab of Client Management Application
	 *
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 06-23-2016
	 * @param searchText - Text to be searched.
	 * @return boolean True if clicking on search button successfully else False
	 */	
	public boolean enterSearchText(String searchText){
		try{
			WebElement searchBox = driver.findElement(ByAngular.cssContainingText(strSearchBox_css, ""));
			WebElement searchButton = driver.findElement(ByAngular.cssContainingText(strSearchButton_css, ""));
			if(searchBox.isDisplayed()){
				searchBox.sendKeys(searchText);
				if(searchButton.isEnabled()){
					LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
					searchButton.click();
					LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
					return true;
				}
				else 
					return false;
			}
			else
				return false;
		}catch (Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * This function is used to check if the search is successful in any tab of Client Management Application
	 *
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 06-23-2016
	 * @param arrSearchableColumn - list of search able columns separated by coma,searchText - Text to be searched.
	 * @return boolean True if clicking on search button successfully else False
	 */	
	public boolean validateSearchableColumn(String[] arrSearchableColumn){
		try{
		ClientManagement_AccountsTab clientManagement = new ClientManagement_AccountsTab(driver);
		int count = 0;
		for (int i=0;i<arrSearchableColumn.length;i++){
			if(driver.findElement(ByAngular.cssContainingText(strAllSearchableColumn_css, arrSearchableColumn[i])).isDisplayed()){
				count ++;
			}
		}
		if(count == arrSearchableColumn.length && clientManagement.getSearchResultRowCount() != -1)		
			return true;
		else
			return false;
		}catch (Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * This function is used to check if the search text is present in any tab of Client Management Application
	 *
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 06-23-2016
	 * @param arrSearchableColumn - list of search able columns separated by coma,searchText - Text to be searched.
	 * @return boolean True if clicking on search button successfully else False
	 */
	public boolean validateSearchText(String searchText, String[] arrSearchableColumn){
		try{
			boolean blnResult = false;
			WebTable table = new WebTable(By.tagName(strHeader_tag), By.tagName(strRow_tag), By.tagName(strColumn_tag));
			int intTotalRowCount = table.getRowCount(driver.findElement(By.id(strDataTable_id)));
			for(int intRowIndex=1;intRowIndex<intTotalRowCount;intRowIndex++){
				blnResult = false;
				for(String strCol:arrSearchableColumn){
					int intSearchableColIndex = table.getColumnIndex(driver.findElement(By.id(strSearchResultTableHeader_Id)), strCol);
					String strCellValue = table.getCellValue(driver.findElement(By.id(strSearchResultTable_Id)), intRowIndex, intSearchableColIndex).trim().toLowerCase();
					if(strCellValue.contains(searchText.trim().toLowerCase())){
						blnResult = true;
						break;
					}
				}
			
				if(blnResult==false){
					System.out.println("Failed Row: "+intRowIndex);
					break;
				}
			}
			return blnResult;
		}
		catch(Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * This function is used to click on any Link using the text
	 *
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 06-23-2016
	 * @param String linkText - Text of the link
	 * @return (boolean) true/false
	 */
	public boolean clickOnLinkText(String linkText) {
		boolean blnResult = false;
		try {
			HomePage homePage = new HomePage(driver);
			driver.findElement(By.linkText(linkText)).click();
			homePage.waitForPageLoading(lplCoreConstents.LOW);
			blnResult = true;
			return blnResult;
		} catch (Exception e) {
			strError = e.toString();
			return blnResult;
		}
	}
	
	/**
	 * This function is used to perform the Keyboard operation
	 *
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 08-19-2016
	 * @param String linkText - Text of the link
	 * @return (boolean) true/false
	 */
	public boolean sendKeyboardKeys(int[] keyCodes) {
		try {
			Robot robot = new Robot();
			for(int key : keyCodes)
				robot.keyPress(key);
			Thread.sleep(2000);
			for(int key : keyCodes)
				robot.keyRelease(key);
			return true;
		} catch (Exception e) {
			strError = e.toString();
			return false;
		}
	}
	
	/**
	 * This function is used to Add all columns to grid view
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 09-29-2016
	 * @return (boolean) true/false
	 */
	public boolean editColumnsAddAll(){
		try {
			boolean blnResult = false;
			
			//Click on EditColumn button
			WebElement objEditColumn = driver.findElement(By.cssSelector(strEditColumns_CSS));
			if(objEditColumn.isDisplayed()){
				objEditColumn.click();
				LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
				LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			}
			
			//Add all the columns
			List<WebElement> addAllLinks = driver.findElements(ByAngular.cssContainingText(strAddAllLinks_css, strAddAllLink_Text));
			for (WebElement addAll : addAllLinks) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();",addAll);
				LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			}
			
			//Click on Apply Button
			WebElement objApply = driver.findElement(By.cssSelector(strEditColumnApply_CSS));
			if (objApply.isDisplayed()){
				objApply.click();
				blnResult = true;
			}
			
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			waitforCMTableToLoad();
			return blnResult;
		
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean scrollToTop()
	{
		boolean blnResult=false;
		try
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			blnResult=true;
		}catch(Exception ex)
		{
			strError = strError + ex.getMessage();
			return false;
		}
		return blnResult;
	}
	
	public boolean selectGlobalFilter(String strFilterName) {
		boolean blnReturn = false;

		try {
			scrollToTop();
			LPLCoreSync.waitForWebElement(driver, "XPATH",strAddGlobalFilter_xpath, lplCoreConstents.FAIR);
			LPLCoreSync.waitForWebElement(driver, "XPATH",strAddGlobalFilter_xpath, lplCoreConstents.BASE);
			WebElement objGlobalFilter = driver.findElement(By.xpath(strAddGlobalFilter_xpath));
			if (objGlobalFilter.isDisplayed()){
				LPLCoreSync.staticWait(lplCoreConstents.LOWEST);
				objGlobalFilter.click();
				LPLCoreSync.staticWait(lplCoreConstents.UNIT);
				WebElement objFilterName = driver.findElement(ByAngular.cssContainingText(strRepId_css, strFilterName));
				objFilterName.click();
				blnReturn = true;
				
			}
			return blnReturn=true;
			
		} catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is used Validate any Range Filter Popup
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 05-25-2017
	 * @param objMinValueLocator - Minimum value text box locator, objMaxValueLocator - Max value text box locator,  objAcceptBtnLocator - Accept button locator, objCancelBtnLocator - Cancel button locator
	 * @return boolean True if the Objects are Present
	 */
	public boolean validateRangeFilterPopup(By objMinValueLocator, By objMaxValueLocator, By objAcceptBtnLocator, By objCancelBtnLocator) {
		boolean blnReturn = false;

		try {
			LPLCoreUtil.waitForWebElement(lplCoreConstents.LOW, objMinValueLocator).isDisplayed();
			LPLCoreUtil.waitForWebElement(lplCoreConstents.LOW, objMaxValueLocator).isDisplayed();
			LPLCoreUtil.waitForWebElement(lplCoreConstents.LOW, objAcceptBtnLocator).isDisplayed();
			LPLCoreUtil.waitForWebElement(lplCoreConstents.LOW, objCancelBtnLocator).isDisplayed();
			blnReturn = true;
			return blnReturn;
		}	
		 catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	/**
	 * This function is to Enter Range filter Min or Max Value
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 05-25-2017
	 * @param (String) strRangeFilterMinOrMaxValue - Range filter Min value, By objMinOrMaxValueLocator - Min value text box locator
	 * @return (boolean) True/False
	 */
	public boolean setRangeFilterMinOrMaxValue(String strRangeFilterMinOrMaxValue, By objMinOrMaxValueLocator) {
		boolean blnReturn = false;

		try {
			driver.findElement(objMinOrMaxValueLocator).sendKeys(strRangeFilterMinOrMaxValue);
			blnReturn = true;
			return blnReturn;
		}	
		 catch (Exception e) {
			strError = e.toString();
			return blnReturn;
		}
	}
	
	
	/**
	 * This function is used to Validate Min or Max value value
	 * 
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 05-25-2017
	 * @param (String) strRangeFilterMinOrMaxValue - Range filter Min value, By objMinOrMaxValueLocator - Min value text box locator
	 * @return boolean
	 */
	public boolean getRangeFilterMinOrMaxValue(String strExpectedRangeFilterMinOrMaxValue, String strMinOrMax, By objRangeFilterValue) {
		boolean blnResult = false;

		try {
				String strRangeFilterActualMinOrMaxValue = driver.findElement(objRangeFilterValue).getText();
				String expRangeFilterMinOrMaxValue = "";
				switch (strMinOrMax.toUpperCase()) {
				case "MAX":
					expRangeFilterMinOrMaxValue = "<=$".concat(strRangeFilterActualMinOrMaxValue);
					break;
				case "MIN":
					expRangeFilterMinOrMaxValue = ">=$".concat(strRangeFilterActualMinOrMaxValue);
					break;
				default:
					break;
				}
				if(expRangeFilterMinOrMaxValue.contains(strExpectedRangeFilterMinOrMaxValue)){
					blnResult = true;
				}
			return blnResult;
		}catch (Exception e) {
			strError = e.toString();
			return blnResult;
		}
	}

}

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
import LPLCoreDriver.LPLCoreUtil;


/**
 * <p>
 * <br><b> Title: </b> GroupBrowsePage.java</br>
 * <br><b> Description: </B> Page Object Library For BranchNet - Group Browse page</br>
 * @author Aiswarya Srinivasan
 * @since 08-29-2016 
 * </p>
 */
public class GroupBrowsePage_AXA extends AccountBrowse_Common_AXA{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
		 
	/**Variables to hold values of Missing and Found columns*/
	public String strFoundColumns = "";
	public String strMissingColumns = "";
	public String[] arrExpectedValues;
	public String[] arrActualvalues;
	
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strIframe_XPATH								= ".//iframe[2]";
	
	public String strPageHeader_Xpath 							= "//*[@class='PageHeader_Title_Legacy']";
	
	public String strRepSearchPanel_id							= "ctl00_cph_repSearch_Panel";
	
	public String strRepDropDown_id								= "ctl00_cph_repSearch_DropDownList";
	
	public String strSearchButton_id							= "dvIcon_ctl00_cph_searchButton";
	
	public String strAddGroupButton_id							= "dvIcon_ctl00_cph_addGroupButton";
	
	public String strRolodexLinks_id							= "rolodexContainer";
	
	public String strGroupTypePanel_id							= "ctl00_cph_groupTypePanel";
	
	public String strGroupCriteriaPanel_id						= "ctl00_cph_criteriaPanel";
	
	public String strSortingCriteriaPanel_id					= "ctl00_cph_sortCriteriaPanel";
	
	//Added on 08 Mar 2017 for TSHD - Aiswarya
	public String strGroupResultGrid_id							= "ctl00_cph_searchGrid";
	
	public String strNumberOfResults_xpath						= ".//tbody/tr/td";

	public String strPageLinks_xpath							= ".//tbody/tr[2]/td/a";
	
	public String strResultHeaders_xpath						= ".//tbody/tr[4]/th/a";
	
	public String strGroupSummaryIframe_XPATH					= "//iframe[contains(@id,'undefined')]";
	
	public String strGroupSummaryTitle_id						= "ctl00_ContentPlaceHolder1_tabControl_TitleLabel";
	
	public String strGroupMaintenanceButton_id					= "dvIcon_ctl00_ContentPlaceHolder1_groupMaintenanceButton";
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 351;
	
	public String[][] allObjects = null;
	
	public GroupBrowsePage_AXA(WebDriver driver){
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

			if (PageObjectsMap.get("strRepSearchPanel").get("ID") != null)
				strRepSearchPanel_id = PageObjectsMap.get(
						"strRepSearchPanel").get("ID");
			
			if (PageObjectsMap.get("strRepDropDown").get("ID") != null)
				strRepDropDown_id = PageObjectsMap.get("strRepDropDown").get("ID");
			
			if (PageObjectsMap.get("strSearchButton").get("ID") != null)
				strSearchButton_id = PageObjectsMap.get("strSearchButton").get("ID");
			
			if (PageObjectsMap.get("strRolodexLinks").get("ID") != null)
				strRolodexLinks_id = PageObjectsMap.get("strRolodexLinks").get("ID");
			
			if (PageObjectsMap.get("strAddGroupButton").get("ID") != null)
				strAddGroupButton_id = PageObjectsMap.get("strAddGroupButton").get("ID");
			
			if (PageObjectsMap.get("strGroupTypePanel").get("ID") != null)
				strGroupTypePanel_id = PageObjectsMap.get("strGroupTypePanel").get("ID");
			
			if (PageObjectsMap.get("strGroupCriteriaPanel").get("ID") != null)
				strGroupCriteriaPanel_id = PageObjectsMap.get("strGroupCriteriaPanel").get("ID");
			
			if (PageObjectsMap.get("strSortingCriteriaPanel").get("ID") != null)
				strSortingCriteriaPanel_id = PageObjectsMap.get("strSortingCriteriaPanel").get("ID");
			
			if (PageObjectsMap.get("strGroupResultGrid").get("ID") != null)
				strGroupResultGrid_id = PageObjectsMap.get("strGroupResultGrid").get("ID");
			
			if (PageObjectsMap.get("strNumberOfResults").get("XPATH") != null)
				strNumberOfResults_xpath = PageObjectsMap.get("strNumberOfResults").get("XPATH");

			if (PageObjectsMap.get("strPageLinks").get("XPATH") != null)
				strPageLinks_xpath = PageObjectsMap.get("strPageLinks").get("XPATH");
			
			if (PageObjectsMap.get("strResultHeaders").get("XPATH") != null)
				strResultHeaders_xpath = PageObjectsMap.get("strResultHeaders").get("XPATH");
			
			if (PageObjectsMap.get("strGroupSummaryIframe").get("XPATH") != null)
				strGroupSummaryIframe_XPATH = PageObjectsMap.get("strGroupSummaryIframe").get("XPATH");
			
			if (PageObjectsMap.get("strGroupSummaryTitle").get("ID") != null)
				strGroupSummaryTitle_id = PageObjectsMap.get("strGroupSummaryTitle").get("ID");
			
			if (PageObjectsMap.get("strGroupMaintenanceButton").get("ID") != null)
				strGroupMaintenanceButton_id = PageObjectsMap.get("strGroupMaintenanceButton").get("ID");
			String[][] allPageObjects = {
					{strPageHeader_Xpath,"Page Header","XPATH"},
					{strRepSearchPanel_id,"Rep Search Panel","ID"},
					{strRepDropDown_id,"Rep Drop down","ID"},
					{strSearchButton_id,"Search Button","ID"},
					{strRolodexLinks_id,"Rolodex Links","ID"},
					{strAddGroupButton_id,"Add group button","ID"},
					{strGroupTypePanel_id,"LPL Accounts Selection criteria Panel","ID"},
					{strGroupCriteriaPanel_id,"Search Accounts in groups Panel","ID"},
					{strSortingCriteriaPanel_id,"Sorting Criteria panel","ID"}};
			
			this.allObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of GroupBrowsePage Class", "Object should be successfully created of GroupBrowsePage class", "Failed to fetch the objects of GroupBrowsePage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	/**
	 * searchGroupBrowse : This method is set search Criteria in Group Browse Page
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-08-2017
	 * @param strRepID - Rep ID to search with, strExpectedColumns - Expected columns separated in commas
	 * @return boolean true if search criteria is set successfully and false if failed
	 */
	public boolean searchGroupBrowse(String strRepID, String strExpectedColumns){
		try {
			boolean blnResult1 = false;
			//Clear the page first
			WebElement objClearBtn = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.id(strClearButton_id));
			objClearBtn.click();
			
			//Wait for Results Grid to Load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			
			//Enter Rep ID
			WebElement objRepSearchTextBox = driver.findElement(By.id(strRepSearchTextBox_id));
			objRepSearchTextBox.sendKeys(strRepID);
			
			//Click on Search
			WebElement objSearchBtn = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.id(strSearchButton_id));
			objSearchBtn.click();
			
			//Wait for Results Grid to Load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			
			if(LPLCoreSync.waitTillVisible(driver, By.id(strGroupResultGrid_id), LPLCoreConstents.getInstance().BaseInMiliSec)){
				WebElement objWholeResultsGrid = driver.findElement(By.id(strGroupResultGrid_id));

				try {
					//Verify the Number of Results loaded line
					@SuppressWarnings("unused")
					WebElement objNumberOfResults = objWholeResultsGrid.findElement(By.xpath(strNumberOfResults_xpath));
					blnResult1 = true;
				} catch (Exception e) {
					strError = strError + " " + e.getMessage();
					blnResult1 = false;
				}

				//Verify the Table header columns with the Expected Columns list
				List<WebElement> objResultHeaders = driver.findElements(By.xpath(strResultHeaders_xpath));
				String strActualHeaderList = "";
				for(WebElement thisResultHeader: objResultHeaders){
					strActualHeaderList = strActualHeaderList + thisResultHeader.getText() + ",";
				}

				this.arrExpectedValues = strExpectedColumns.split(",");
				this.arrActualvalues = strActualHeaderList.split(",");
				boolean blnThisValueFound = false;

				for(String strEachColumn:this.arrExpectedValues){
					blnThisValueFound = false;
					for(String strEachActualValue: this.arrActualvalues){
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
				if (blnThisValueFound & blnResult1) {
					return true;
				}else{
					strError = strError + " Search Results validation failed for Group Browse page. Details: Expected Columns: " + strExpectedColumns+ " Actual Columns: " + strActualHeaderList + "; Page links and Number of results badge might also be missing ";
					return false;
				}
			}else{
				strError = strError + " Search results were not found within "+ LPLCoreConstents.getInstance().BaseInMiliSec +" milliseconds for Group Browse page";
				return false;
			}
		} catch (Exception e) {
			strError = strError + " Problem setting the Search Criteria of Group Browse page";
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * navigateToGroupFromResults : This method is Navigate to the first group under results where we have link
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-08-2017
	 * @param strGrpNameColumnText - Group name Column text
	 * @return boolean true if search criteria is set successfully and false if failed
	 */
	public boolean navigateToGroupFromResults(String strGrpNameColumnText, String strGrpTypeColumnText, String strGrpTypeToPick, String GrpMaintenanceHeaderText){
		boolean blnGroupDetailsPageFound = false;
		try {
			//Wait for Results Grid to Load
			if(LPLCoreSync.waitTillVisible(driver, By.id(strGroupResultGrid_id), LPLCoreConstents.getInstance().BaseInMiliSec)){
				WebElement objWholeResultsGrid = driver.findElement(By.id(strGroupResultGrid_id));
				
				//Looping through the actual column headers - Boolean Variables for all the checks and int variables to hold column numbers
				boolean blnGrpNameColFound = false;
				boolean blnGrpTypeColFound = false;
				int intCounter = 0;
				int intGrpNameCounter = 0;
				int intGrpTypeCounter = 0;
				
				//Get the column number of Group name and Group type
				for(String strEachActualValue: this.arrActualvalues){
					intCounter = intCounter+1;
					if(strGrpNameColumnText.trim().equalsIgnoreCase(strEachActualValue.trim())){
						blnGrpNameColFound= true;
						intGrpNameCounter = intCounter;
					}
					if(strGrpTypeColumnText.trim().equalsIgnoreCase(strEachActualValue.trim())){
						blnGrpTypeColFound= true;
						intGrpTypeCounter = intCounter;
					}
				}
				
				//If both the Group name Column and Group type column are found, 
				//then try to click on the Group name which has the desired group type
				if(blnGrpNameColFound && blnGrpTypeColFound){
					List<WebElement> objAllTRs = objWholeResultsGrid.findElements(By.tagName("tr"));
					for (WebElement thisTR : objAllTRs) {
						try {
							WebElement objGrpType = thisTR.findElement(By.xpath(".//td["+(intGrpTypeCounter+2)+"]"));
							
							//If the Group type in the current row is what we want to pick, then click on Group name link in that row
							if(objGrpType.getText().equalsIgnoreCase(strGrpTypeToPick)){
								try {
									//Click on the Group name Link if found
									WebElement objGrpNameLink = thisTR.findElement(By.xpath(".//td["+(intGrpNameCounter+2)+"]/a"));
									objGrpNameLink.click();
									
									//Wait for Group details page to load
									LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
									
									//Switch proper frames
									driver.switchTo().defaultContent();
									driver.switchTo().frame(strParentFrame);
									WebElement objGrpDetailsFrame = driver.findElement(By.xpath(strGroupSummaryIframe_XPATH));
									driver.switchTo().frame(objGrpDetailsFrame);
									
									//After Clicking on the Group name, wait for Group Summary page to load
									if(LPLCoreSync.waitTillVisible(driver, By.id(strGroupSummaryTitle_id ), LPLCoreConstents.getInstance().BaseInMiliSec)){
										//Click on Group maintenance button
										WebElement objGrpMaintenance = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.id(strGroupMaintenanceButton_id));
										objGrpMaintenance.click();
										
										//Verify if the Group maintenance page loaded
										if(LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.xpath(strPageHeader_Xpath)).getText().contains(GrpMaintenanceHeaderText)){
											return blnGroupDetailsPageFound = true;
										}else{
											this.strError = this.strError + " Group maintenance page did not load properly.";
											return false;
										}
									}else{
										this.strError = this.strError + " Group summary page did not load properly. Could not click on Group maintenance.";
										return false;
									}
								} catch (Exception e) {
									//If Group name link not found in the current row, continue to next row in the loop
									continue;
								}
							}else{
								//If desired Group Type not found in current row, continue to next row in the loop
								continue;
							}
						}catch(Exception ex){
							//If td item not found in the current row, continue to next row in the loop
							continue;
						}
					}
				}else{
					strError = strError + "Expected Group name or Group type not found in Search Results";
					return false;
				}
			}
			return blnGroupDetailsPageFound;
		} catch (Exception e) {
			strError = strError + " Problem setting the Search Criteria of Group Browse page";
			e.printStackTrace();
			return false;
		}
	}
}
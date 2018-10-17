package PageObjectLibrary;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> AccountViewCommon.java</br>
 * <br><b> Description: </B> Common Page Object Library For Account View Pages</br> 
 * <br><b>Usage:</B></br>
 * <br>1. homePageTabNavigation: Method to navigate to different tabs on Home Page. </br>
 * <br>2. subTabNavigation: Method to navigate to different sub tabs. </br>
 * <br>3. logOut: Method to logout of the application. </br>
 * <br>4. handleExtraNavigation: Method to handle Go Paperless link of the application. </br>
 * <br>5. searchClient(String strClientName): This function is used to Search for an Client and checks results grid is displayed in AV Page.</br>
 * <br>6. clickOnArrowButton():  This function is used to click on By Accounts Arrow button in AV Positions Page.</br>
 * @author Rahul Agarwal
 * @since 08-22-2016
 * </p>
 */
public class AVCommon {
	
	/** Web Driver Reference */
	public WebDriver driver;

	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;
	
	/** LPLCoreConstents Reference */
	public LPLCoreConstents lplCoreConstents;
	
	/** CSS property value of Details Header */
	public String strCommonTab_CSS = "li a";
	
	/** CSS property value of Details Header */
	public String strPanelBody_CSS = ".panel-body";
	
	/** CSS property value of Asset Allocation Sub Tab */
	public String strAssetAllocationSubTabCommon_CSS = ".AssetAllocationChartLabel";
	
	/** CSS property value of Value Over Time Sub Tab */
	public String strValueOverTimeSubTabCommon_CSS = ".VOTLabel";
	
	/** CSS property value of Statements Sub Tab */
	public String strStatementsSubTabCommon_CSS = ".t-reset.t-tabstrip-items span";
	
	/** CSS property value of Home Page Table */
	public String strHomePageTable_CSS = " .panel-body.no-pad .av_table-responsive";
	
	/** CSS property value of Logout */
	public String strLogout_CSS = ".navLogoutMenuPic";
	
	/** Angular text property value of Logout */
	public String strLogout_Text = "Logout";
	
	//Added objects on 02/14/2017
	
	/** CSS property value of Search Field */
	public String strSearchField_CSS		= "#Search";
	
	/** ID property value of Search by Clicking on Go Field */
	public String strSearchButton_ID 		= "searchBtn";
	
	/** CSS property value of Go Button */
	public String strGoButton_CSS 			= "#goButton";
	
	/** CSS property value of Search Grid Results */
	public String strClientsSearchGrid_CSS	= ".t-master-row";
	
	/** CSS property value of Arrow Drop Down*/
	public String strArrowButton_CSS 		= ".t-icon.t-arrow-down.t-panelbar-expand";
	
	/** ID property value of Positions Tab Account Results*/
	public String strPositionsByAccounts_ID = "PositionsByAccounts";
	
	/** CSS property value of Positions sub tabs*/
	public String strPositionsSubTabs_CSS = "#PositionsTabStrip ul li span";
	
	/** CSS property value of Documents and statements sub tabs*/
	public String strDocumentsAndStatementsSubTabs_CSS ="#statementsTab li a";
	
	/** Current Page ID from FARM */ 
	public static final int INT_PAGEID = 137;

	public AVCommon(WebDriver driver) {
		
		lplCoreConstents = LPLCoreConstents.getInstance();
		this.driver = driver;
		
		try{
			
		/** Fetching the page objects from FARM */
		HashMap<String, HashMap<String, String>> pageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
		
		if(pageObjectsMap.get("strCommonTab").get("CSS")!=null)
			strCommonTab_CSS = pageObjectsMap.get("strCommonTab").get("CSS");
		
		if(pageObjectsMap.get("strPanelBody").get("ANGULARREF")!=null)
			strPanelBody_CSS = pageObjectsMap.get("strPanelBody").get("ANGULARREF");
		
		if(pageObjectsMap.get("strAssetAllocationSubTabCommon").get("CSS")!=null)
			strAssetAllocationSubTabCommon_CSS = pageObjectsMap.get("strAssetAllocationSubTabCommon").get("CSS");
		
		if(pageObjectsMap.get("strValueOverTimeSubTabCommon").get("CSS")!=null)
			strValueOverTimeSubTabCommon_CSS = pageObjectsMap.get("strValueOverTimeSubTabCommon").get("CSS");
		
		if(pageObjectsMap.get("strStatementsSubTabCommon").get("CSS")!=null)
			strStatementsSubTabCommon_CSS = pageObjectsMap.get("strStatementsSubTabCommon").get("CSS");
		
		if(pageObjectsMap.get("strHomePageTable").get("CSS")!=null)
			strHomePageTable_CSS = pageObjectsMap.get("strHomePageTable").get("CSS");
		
		if(pageObjectsMap.get("strLogout").get("CSS")!=null)
			strLogout_CSS = pageObjectsMap.get("strLogout").get("CSS");
		
		if(pageObjectsMap.get("strLogout").get("ANGULARREF")!=null)
			strLogout_Text = pageObjectsMap.get("strLogout").get("ANGULARREF");
		
		if(pageObjectsMap.get("strSearchField").get("CSS")!=null)
			strSearchField_CSS = pageObjectsMap.get("strSearchField").get("CSS");
		
		if(pageObjectsMap.get("strSearchButton").get("ID")!=null)
			strSearchButton_ID = pageObjectsMap.get("strSearchButton").get("ID");
		
		if(pageObjectsMap.get("strGoButton").get("CSS")!=null)
			strGoButton_CSS = pageObjectsMap.get("strGoButton").get("CSS");
		
		if(pageObjectsMap.get("strClientsSearchGrid").get("CSS")!=null)
			strClientsSearchGrid_CSS = pageObjectsMap.get("strClientsSearchGrid").get("CSS");
		
		if(pageObjectsMap.get("strArrowButton").get("CSS")!=null)
			strArrowButton_CSS = pageObjectsMap.get("strArrowButton").get("CSS");
		
		if(pageObjectsMap.get("strPositionsByAccounts").get("ID")!=null)
			strPositionsByAccounts_ID = pageObjectsMap.get("strPositionsByAccounts").get("ID");
		
		if(pageObjectsMap.get("strPositionsSubTabs").get("CSS")!=null)
			strPositionsSubTabs_CSS = pageObjectsMap.get("strPositionsSubTabs").get("CSS");
		
		if(pageObjectsMap.get("strDocumentsAndStatementsSubTabs").get("CSS")!=null)
			strDocumentsAndStatementsSubTabs_CSS = pageObjectsMap.get("strDocumentsAndStatementsSubTabs").get("CSS");
		
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of AVCommon Class", "Object should be successfully created of AVCommon class", "Failed to fetch the objects of AVCommon from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
			}
	}

	/**
	 * Method to navigate to different tabs on Home Page
	 * @author Rahul Agarwal
	 * @since 08-22-2016
	 * @param strTabName - String type
	 * @return (boolean) true/false
	 */
	public boolean homePageTabNavigation(String strTabName){
		boolean blnResult = false;
		LPLCoreSync.waitTillVisible(driver, ByAngular.cssContainingText(strHomePageTable_CSS, ""),lplCoreConstents.BASE);
		try{
			driver.findElement(ByAngular.cssContainingText(strCommonTab_CSS, strTabName)).click();
			blnResult = true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;			
		}
		return blnResult;
	}
	
	/**
	 * Method to navigate to different sub tabs
	 * @author Rahul Agarwal
	 * @since 08-23-2016
	 * @param strMainTab - String type, strSubTab - String type
	 * @return (boolean) true/false
	 */
	public boolean subTabNavigation(String strMainTab, String strSubTab){
		boolean blnResult = false;
		LPLCoreSync.waitTillVisible(driver,ByAngular.cssContainingText(strPanelBody_CSS, ""),lplCoreConstents.HIGHEST);
		switch (strMainTab.toUpperCase()) {
		case "ASSET ALLOCATION":
			driver.findElement(ByAngular.cssContainingText(strAssetAllocationSubTabCommon_CSS, strSubTab)).click();
			blnResult = true;
			break;
		case "VALUE OVER TIME":
			driver.findElement(ByAngular.cssContainingText(strValueOverTimeSubTabCommon_CSS, strSubTab)).click();
			blnResult = true;
			break;
		case "POSITIONS":
			driver.findElement(ByAngular.cssContainingText(strPositionsSubTabs_CSS, strSubTab)).click();
			blnResult = true;
			break;
		case "STATEMENTS":
			driver.findElement(ByAngular.cssContainingText(strStatementsSubTabCommon_CSS, strSubTab)).click();
			blnResult = true;
			break;
		case "DOCUMENTS AND STATEMENTS":
			driver.findElement(ByAngular.cssContainingText(strDocumentsAndStatementsSubTabs_CSS, strSubTab)).click();
			blnResult = true;
			break;
		default:
			break;
		}
		return blnResult;
	}
	
	/**
	 * Method to logout of the application
	 * @author Rahul Agarwal
	 * @since 08-23-2016
	 * @return (boolean) true/false
	 */
	public boolean logOut(){
		boolean blnResult = false;
			if(driver.findElement(By.cssSelector(strLogout_CSS)).isDisplayed())
			{
				driver.findElement(By.cssSelector(strLogout_CSS)).click();
				blnResult = true;
			}
		return blnResult;
	}
	
	/**
	 * Method to handle Go Paperless link of the application
	 * @author Rahul Agarwal
	 * @since 09-26-2016
	 */
	public void handleExtraNavigation(){
		try{
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			if(driver.findElement(By.linkText("Not Now")).isDisplayed())
				driver.findElement(By.linkText("Not Now")).click();
		}catch(NoSuchElementException ex){
			
		}
		
	}
	/**
	 * This function is used to Search for an Client and checks results grid is displayed in AV Page
	 *
	 * @author Sunitha
	 * @version 1.0
	 * @since 02/08/2017
	 * @param String strClientName - Search for an client 
	 * @return boolean - True/False
	 * @param N/A
	 */
	public boolean searchClient(String strClientName) {
		
		boolean blnReturn = false;
		try{
		
		LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
		
		//Enter the client details in Search field
		driver.findElement(By.cssSelector(strSearchField_CSS)).sendKeys(strClientName);
		LPLCoreSync.staticWait(lplCoreConstents.LOWEST);
		
		//Click on the search button
		driver.findElement(By.id(strSearchButton_ID)).click();
		LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
		
		//Scroll to the Search results Grid Element
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(strClientsSearchGrid_CSS)));
		
		//Check whether Search Results Grid exist or not
		WebElement objClientsSearchGrid = driver.findElement(By.cssSelector(strClientsSearchGrid_CSS));
		if(objClientsSearchGrid.isDisplayed()){
			blnReturn = true;
		}else{
			blnReturn = false;	
		}
		return blnReturn;
		}catch(Exception e){
			strError = strError + "Error: After Searching with Client Name or ID, No Record Exist for the ClientName or ID";
			return false;
		}
	}	

	/**
	 * This function is used to click on By Accounts Arrow button in AV Page
	 *
	 * @author Sunitha
	 * @version 1.0
	 * @since 02/08/2017 
	 * @return boolean - True/False
	 * @param N/A
	 */
	public boolean clickOnArrowButton() {
		
		boolean blnReturn = false;
		WebElement objPositionsByAccounts = null;
		
		//Wait for page loading
		LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
		
		try{
			//Check whether Accounts Panel exist or not in Positions Page
			objPositionsByAccounts=driver.findElement(By.id(strPositionsByAccounts_ID));
			if(objPositionsByAccounts.isDisplayed()){
				
				//Click on the Arrow Drop down button under Accounts Panel
				driver.findElement(By.cssSelector(strArrowButton_CSS)).click();
				LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
				blnReturn = true;
			} else {
				strError = "Account Link:[" + strError+ "] Grid is not displayed";
				blnReturn = false;
			}
		return blnReturn;
		} catch (Exception e) {
			strError = e.getMessage();
			return false;
		}
	}
}

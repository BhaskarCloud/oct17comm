package PageObjectLibrary;

import java.util.HashMap;

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
 * <br><b> Title: </b> UniversalDataExportPage.java</br>
 * <br><b> Description: </B> Page Object Library For Universal Data Export Page</br>
 * <br><b>Usage:</br></b>
 * <br> 1. selectAccountClass : Method to select all SAM & SWM class from Dropdown. </br>
 * <br> 2. exportBatchResult : Method to select appropriate values and export batch result. </br>
 * <br> 3. verifySelectMode : Method to verify the exported batch result. </br>
 * @author Rahul Agarwal
 * @since 09-24-2016
 * </p>
 */
public class UniversalDataExportPage {
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;
	
	/** XPATH property value of Iframe */
	public String strIframe_XPATH					= "//iframe[2]";
	
	/** Name property value of Parent Iframe */
	public String strParentFrame					= "shell";
	
	/** CSS property value of Page Title */
	public String strPageTitle_CSS					= ".PageTitle";
	
	/** CSS property value of Header Text */
	public String strHeaderText_CSS					= ".PageDescription";
	
	/** CSS property value of Rep Search Title Bar */
	public String strRepSearchTitleBar_CSS			= "#ctl00_cph_panelRepSearch_TitleBar";
	
	/** CSS property value of Rep Search Panel */
	public String strRepSearchPanel_CSS 			= "#ctl00_cph_panelRepSearch";
	
	/** CSS property value of Account Type Title bar */
	public String strAccountTypeTitleBar_CSS		= "#ctl00_cph_panelAccountTypes_TitleBar";
	
	/** CSS property value of Account Type Panel */
	public String strAccountTypePanel_CSS 			= "#ctl00_cph_panelAccountTypes";
	
	/** CSS property value of Advanced Title bar */
	public String strAdvancedTitleBar_CSS			= "#ctl00_cph_panelAdvanced_TitleBar";
	
	/** CSS property value of Export Favorites Title bar */
	public String strExportFavoritesTitleBar_CSS	= "#ctl00_cph_exportFavoritesPanel_TitleBar";
	
	/** CSS property value of Export Favorites Panel */
	public String strExportFavoritesPanel_CSS 		= "#ctl00_cph_exportFavoritesPanel";
	
	public String strLPLAccountCheckBox_ID			= "ctl00_cph_lplCheckBox";
	
	public String strAllAccountClass_ID				= "ctl00_cph_accClsComboBox_i0_chk";
	
	public String strLocatorProperties1_ID			= "ctl00_cph_accClsComboBox_i39_chk;ctl00_cph_accClsComboBox_i40_chk;ctl00_cph_accClsComboBox_i41_chk;ctl00_cph_accClsComboBox_i42_chk;";
	
	public String strLocatorProperties2_ID			= "ctl00_cph_accClsComboBox_i43_chk;ctl00_cph_accClsComboBox_i44_chk;ctl00_cph_accClsComboBox_i45_chk;ctl00_cph_accClsComboBox_i46_chk";
	
	public String strAccountClassDDArrow_ID			= "ctl00_cph_accClsComboBox_Arrow";
	
	public String strSearchBtn_ID					= "ctl00_cph_searchButton";
	
	public String strExportBatchReportDD_ID			= "ctl00_cph_exportToComboBox_Arrow";
	
	public String strPositionRadioBtn_ID			= "ctl00_cph_positionsRadio";
	
	public String strExportBtn_ID					= "ctl00_cph_exportButton";
	
	public String strBatchMode_XPATH				= "//table[@id='modeSelection']//td[text()='Batch Mode']";
	
	public String strExitBtn_ID						= "navButtonExit";
	
	public String strPopFrame_ID					= "popinIframe";
		
	/** Current Page ID from FARM */ 
	public final int INT_PAGEID = 247;
	
	BNCommon bnCommon = new BNCommon(driver);
	
	public UniversalDataExportPage(WebDriver driver) {
		
		this.driver = driver;
		
		try {
			/** Fetching Page Object Identification Properties from FARM for current page */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
			
			if(PageObjectsMap.get("strPageTitle").get("CSS")!=null)
				strPageTitle_CSS = PageObjectsMap.get("strPageTitle").get("CSS");
			
			if(PageObjectsMap.get("strHeaderText").get("CSS")!=null)
				strHeaderText_CSS = PageObjectsMap.get("strHeaderText").get("CSS");
			
			if(PageObjectsMap.get("strRepSearchTitleBar").get("CSS")!=null)
				strRepSearchTitleBar_CSS = PageObjectsMap.get("strRepSearchTitleBar").get("CSS");
			
			if(PageObjectsMap.get("strRepSearchPanel").get("CSS")!=null)
				strRepSearchPanel_CSS = PageObjectsMap.get("strRepSearchPanel").get("CSS");
				
			if(PageObjectsMap.get("strAccountTypeTitleBar").get("CSS")!=null)
				strAccountTypeTitleBar_CSS = PageObjectsMap.get("strAccountTypeTitleBar").get("CSS");
			
			if(PageObjectsMap.get("strAccountTypePanel").get("CSS")!=null)
				strAccountTypePanel_CSS = PageObjectsMap.get("strAccountTypePanel").get("CSS");
				
			if(PageObjectsMap.get("strAdvancedTitleBar").get("CSS")!=null)
				strAdvancedTitleBar_CSS = PageObjectsMap.get("strAdvancedTitleBar").get("CSS");
			
			if(PageObjectsMap.get("strExportFavoritesTitleBar").get("CSS")!=null)
				strExportFavoritesTitleBar_CSS = PageObjectsMap.get("strExportFavoritesTitleBar").get("CSS");
			
			if(PageObjectsMap.get("strExportFavoritesPanel").get("CSS")!=null)
				strExportFavoritesPanel_CSS = PageObjectsMap.get("strExportFavoritesPanel").get("CSS");
			
			if(PageObjectsMap.get("strLocatorProperties1").get("ID")!=null)
				strLocatorProperties1_ID = PageObjectsMap.get("strLocatorProperties1").get("ID");
			
			if(PageObjectsMap.get("strLocatorProperties2").get("ID")!=null)
				strLocatorProperties2_ID = PageObjectsMap.get("strLocatorProperties2").get("ID");
			
			if(PageObjectsMap.get("strLPLAccountCheckBox").get("ID")!=null)
				strLPLAccountCheckBox_ID = PageObjectsMap.get("strLPLAccountCheckBox").get("ID");
			
			if(PageObjectsMap.get("strAllAccountClass").get("ID")!=null)
				strAllAccountClass_ID = PageObjectsMap.get("strAllAccountClass").get("ID");
			
			if(PageObjectsMap.get("strAccountClassDDArrow").get("ID")!=null)
				strAccountClassDDArrow_ID = PageObjectsMap.get("strAccountClassDDArrow").get("ID");
			
			if(PageObjectsMap.get("strSearchBtn").get("ID")!=null)
				strSearchBtn_ID = PageObjectsMap.get("strSearchBtn").get("ID");
				
			if(PageObjectsMap.get("strExportBatchReportDD").get("ID")!=null)
				strExportBatchReportDD_ID = PageObjectsMap.get("strExportBatchReportDD").get("ID");
			
			if(PageObjectsMap.get("strPositionRadioBtn").get("ID")!=null)
				strPositionRadioBtn_ID = PageObjectsMap.get("strPositionRadioBtn").get("ID");
				
			if(PageObjectsMap.get("strExportBtn").get("ID")!=null)
				strExportBtn_ID = PageObjectsMap.get("strExportBtn").get("ID");
			
			if(PageObjectsMap.get("strBatchMode").get("ID")!=null)
				strBatchMode_XPATH = PageObjectsMap.get("strBatchMode").get("ID");
			
			if(PageObjectsMap.get("strExitBtn").get("ID")!=null)
				strExitBtn_ID = PageObjectsMap.get("strExitBtn").get("ID");

			if(PageObjectsMap.get("strPopFrame").get("ID")!=null)
				strPopFrame_ID = PageObjectsMap.get("strPopFrame").get("ID");
		
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of UniversalDataExportPage Class", "Object should be successfully created of UniversalDataExportPage class", "Failed to fetch the objects of UniversalDataExportPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	public String allPageObjects[][] ={{strPageTitle_CSS,"Page Title","css"},
										{strHeaderText_CSS,"Header Text","css"},
										{strRepSearchTitleBar_CSS,"Rep Search Title Bar","css"},
										{strRepSearchPanel_CSS,"Rep Search Panel","css"},
										{strAccountTypeTitleBar_CSS,"Account Type Title Bar","css"},
										{strAccountTypePanel_CSS,"Account Type Panel","css"},
										{strAdvancedTitleBar_CSS,"Advanced Title Bar","css"},
										{strExportFavoritesTitleBar_CSS,"Export Favorites Title Bar","css"},
										{strExportFavoritesPanel_CSS,"Export Favorites Panel","css"}};

	/**
	 * Method to select all SAM & SWM class from Dropdown. 
	 * 
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 01-20-2017
	 * @return boolean - True/False
	 */
	public boolean selectAccountClass(){
		boolean blnResult = false;
		try{
			WebElement objLPLAccount = driver.findElement(By.id(strLPLAccountCheckBox_ID));
			if(!objLPLAccount.isSelected()){
				objLPLAccount.click();
			}
			
			WebElement strAccountClassArrow = driver.findElement(By.id(strAccountClassDDArrow_ID));
			strAccountClassArrow.click();
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().LOWESTInMiliSec);
			WebElement strAllAccountClasses = driver.findElement(By.id(strAllAccountClass_ID));
			if(!strAllAccountClasses.isSelected()){
				strAllAccountClasses.click();
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().LOWESTInMiliSec);
				strAllAccountClasses.click();
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().LOWESTInMiliSec);
				strAccountClassArrow.click();
			}
			else{
				strAllAccountClasses.click();
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().LOWESTInMiliSec);
				strAccountClassArrow.click();
			}
			String strAccountClassLocator = strLocatorProperties1_ID + strLocatorProperties2_ID;
			String[] strAccountClasses = strAccountClassLocator.split(";");
			
			for(String strAcctClass : strAccountClasses){
				SelectDropDown selectDropDownPage = new SelectDropDown(driver, By.id(strAccountClassDDArrow_ID));
				selectDropDownPage.selectValueByCheckBox(By.id(strAccountClassDDArrow_ID), By.id(strAcctClass));
			}
			
			driver.findElement(By.id(strSearchBtn_ID)).click();
			blnResult = true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}
	
	/**
	 * Method to select appropriate values and export batch result. 
	 * 
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 01-20-2017
	 * @param String strDDText - Drop Down Text
	 * @return boolean - True/False
	 */
	public boolean exportBatchResult(String strDDText){
		boolean blnResult = false;
		try{
			WebElement strExportBatchResultArrow = driver.findElement(By.id(strExportBatchReportDD_ID));
			SelectDropDown selectDropDownPage = new SelectDropDown(driver, By.id(strExportBatchReportDD_ID));
			strExportBatchResultArrow.click();
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().LOWESTInMiliSec);
			selectDropDownPage.selectValueByVisibleText(strDDText);
			
			driver.findElement(By.id(strPositionRadioBtn_ID)).click();
			
			driver.findElement(By.id(strExportBtn_ID)).click();
			
			blnResult = true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}
	
	/**
	 * Method to verify the exported batch result. 
	 * 
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 01-20-2017
	 * @return boolean - True/False
	 */
	public boolean verifySelectMode(){
		boolean blnResult = false;
		try{
			if(driver.findElement(By.xpath(strBatchMode_XPATH)).isDisplayed()){
				blnResult = true;
			}
			
			driver.findElement(By.id(strExitBtn_ID)).click();
			
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
			
			blnResult = bnCommon.switchTo("FRAME",strPopFrame_ID);
			
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
			
			blnResult = true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}
}

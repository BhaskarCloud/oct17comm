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
import LPLCoreDriver.LPLCoreUtil;
import LPLCoreDriver.WebToolKit.SelectDropDown;
import LPLCoreDriver.WebToolKit.WebTable;

/**
 * <p>
 * <br><b> Title: </b> UniversalDataExportPage.java</br>
 * <br><b> Description: </B> Page Object Library For Universal Data Export Page</br>
 * <br><b>Usage:</br></b>
 * <br> 1. selectAccountClass : Method to select all SAM class from Dropdown. </br>
 * <br> 2. exportBatchResult : Method to select appropriate values and export batch result. </br>
 * <br> 3. verifySelectMode : Method to verify the exported batch result. </br>
 * <br> 4. validatePriceAsOfDate(String columnName, String dayFormat, String DateFormat): Method is used to Validate the price as of date is previous Business day or not. </br>
 * @author Rahul Agarwal
 * @since 11-17-2016
 * </p>
 */
public class UniversalDataExportPage_AXA extends LPLCoreUtil{
	
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
	
	public String strLocatorProperties_ID			= "ctl00_cph_accClsComboBox_i21_chk;ctl00_cph_accClsComboBox_i22_chk;ctl00_cph_accClsComboBox_i23_chk;ctl00_cph_accClsComboBox_i24_chk;";
	
	public String strAccountClassDDArrow_ID			= "ctl00_cph_accClsComboBox_Arrow";
	
	public String strSearchBtn_ID					= "ctl00_cph_searchButton";
	
	public String strExportBatchReportDD_ID			= "ctl00_cph_exportToComboBox_Arrow";
	
	public String strPositionRadioBtn_ID			= "ctl00_cph_positionsRadio";
	
	public String strExportBtn_ID					= "ctl00_cph_exportButton";
	
	public String strBatchMode_XPATH				= "//table[@id='modeSelection']//td[text()='Batch Mode']";
	
	public String strExitBtn_ID						= "navButtonExit";
	
	public String strPopFrame_ID					= "popinIframe";
	
	//Added Objects for TSHD Scripts on 03212017
	public String strBatchModeGoBtn_XPATH			= "//table[@id='modeSelection']/tbody/tr//img";
	
	public String strContinueBtn_ID					= "navButtonContinue";
	
	public String strSaveAndContinue_ID				= "navButtonSaveContinue";
	
	public String strModelPortfolioLink_XPATH		= "//table[@class='modelList']//a[@class='link']";
	
	public String strColumnHeaders_XPATH			= "//table[@class='data']//tr[@class='header']//td";
	
	public String strCloseBtn_XPATH					= "//div[@class='popinButton']/a/img";
	
	public String strPortfolioColumnHeaders_XPATH	= "//div[@class='slate_popin']//table[@class='data']//tr[@class='header']/td";
	
	public String strDataTable_XPATH				= "//div[@class='slate_popin']//table[2]";
	
	public String strRow_Tag						= "tr";
	
	public String strColumn_Tag						= "td";
	
	/** Current Page ID from FARM */ 
	public final int INT_PAGEID = 374;
	
	BNCommon bnCommon = new BNCommon(driver);
	
	public UniversalDataExportPage_AXA(WebDriver driver) {
		
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
			
			if(PageObjectsMap.get("strLocatorProperties").get("ID")!=null)
				strLocatorProperties_ID = PageObjectsMap.get("strLocatorProperties").get("ID");
			
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
			
			if(PageObjectsMap.get("strBatchModeGoBtn").get("XPATH")!=null)
				strBatchModeGoBtn_XPATH = PageObjectsMap.get("strBatchModeGoBtn").get("XPATH");
			
			if(PageObjectsMap.get("strModelPortfolioLink").get("XPATH")!=null)
				strModelPortfolioLink_XPATH = PageObjectsMap.get("strModelPortfolioLink").get("XPATH");
			
			if(PageObjectsMap.get("strColumnHeaders").get("XPATH")!=null)
				strColumnHeaders_XPATH = PageObjectsMap.get("strColumnHeaders").get("XPATH");
			
			if(PageObjectsMap.get("strCloseBtn").get("XPATH")!=null)
				strCloseBtn_XPATH = PageObjectsMap.get("strCloseBtn").get("XPATH");
				
			if(PageObjectsMap.get("strPortfolioColumnHeaders").get("XPATH")!=null)
				strPortfolioColumnHeaders_XPATH = PageObjectsMap.get("strPortfolioColumnHeaders").get("XPATH");
			
			if(PageObjectsMap.get("strDataTable").get("XPATH")!=null)
				strDataTable_XPATH = PageObjectsMap.get("strDataTable").get("XPATH");
				
			if(PageObjectsMap.get("strColumn").get("ID")!=null)
				strColumn_Tag = PageObjectsMap.get("strColumn").get("ID");
			
			if(PageObjectsMap.get("strRow").get("ID")!=null)
				strRow_Tag = PageObjectsMap.get("strRow").get("ID");
			
			if(PageObjectsMap.get("strSaveAndContinue").get("ID")!=null)
				strSaveAndContinue_ID = PageObjectsMap.get("strSaveAndContinue").get("ID");

			if(PageObjectsMap.get("strContinueBtn").get("ID")!=null)
				strContinueBtn_ID = PageObjectsMap.get("strContinueBtn").get("ID");
		
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
	 * Method to select all SAM class from Dropdown. 
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
			
			String[] strAccountClasses = strLocatorProperties_ID.split(";");
			
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

	/**
	 * validatePriceAsOfDate : Method is used to Validate the price as of date is previous Business day or not. 
	 * @author Sunitha
	 * @version 1.0
	 * @since 03-21-2017
	 * @param strColumnName = Column Name
	 * 		  strDayFormat	= Enter required day format e.g.,EEE for Mon, EEEE for Monday
	 * 		  strDateFormat = Enter required Date Format e.g., M/d/YY, MM/dd/YYYY
	 * @return boolean True if search criteria is set successfully and False if failed
	 */
	public boolean validatePriceAsOfDate(String strColumnName, String strDayFormat, String strDateFormat){
		try{
			boolean blnResult = false;
			//Wait fo page Loading
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
			WebTable table = new WebTable(By.xpath(strPortfolioColumnHeaders_XPATH), By.tagName(strRow_Tag), By.tagName(strColumn_Tag));
			
			//Get the total rows count
			int intTotalRowCount = table.getRowCount(driver.findElement(By.xpath(strDataTable_XPATH)));
			
			//Get the text in price as of date column
			for(int intRowIndex=1;intRowIndex<=intTotalRowCount;intRowIndex++){
				blnResult = false;
				
				int intSearchableColIndex = table.getColumnIndex(driver.findElement(By.xpath(strPortfolioColumnHeaders_XPATH)), strColumnName);
				String strCellValue = table.getCellValue(driver.findElement(By.xpath(strDataTable_XPATH)), intRowIndex, intSearchableColIndex).trim().toLowerCase();
				
				if(!strCellValue.equalsIgnoreCase("")){
					
					//Converting previous business date to String
					String previousBusinessDay = getPreviousBusinessDay(strDayFormat, strDateFormat);
						
					//Check whether the previous business day is displayed same as in Model Portfolio - Price As of Date page
					if(strCellValue.contains(previousBusinessDay.trim())){
						blnResult = true;
						break;
						}
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
}

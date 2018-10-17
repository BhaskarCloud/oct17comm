package PageObjectLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;
import LPLCoreDriver.WebToolKit.SelectDropDown;


/**
 * <p>
 * <br><b> Title: </b> Updates_3rdPartyPortfolioDownloadPage.java</br>
 * <br><b> Description: </B> Page Object Library For Updates - Third Party Portfolio Download page</br>
 * @author Aiswarya Srinivasan
 * @since 09-06-2016 
 * </p>
 */
public class Updates_3rdPartyPortfolioDownloadPage extends BNCommon{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** Variable to hold Downloaded File reference **/
	public File downloadedFile;
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
		 
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strParentFrame_NAME					= "shell";
	
	public String strIFrame_XPATH						= ".//iframe[2]";
	
	public String strPageTitle_XPATH					= "//*[@class='PurposeStatementTitle' and text()='Third Party Portfolio Download']";
	
	public String strRepIdDropdown_ID					= "repSearch"; 
	
	public String strLoadDatesButton_ID 				= "dvIcon_LoadDatesButton";
	
	public String strAvailableDatesList_ID 				= "AvailableDatesListBox";
	
	public String strDownloadLocationTextBox_ID 		= "DownloadLocationTextBox";
	
	public String strBrowseDownloadLocationButton_ID 	= "dvIcon_DownloadLocationButton";
	
	public String strDownloadButton_ID 					= "dvIcon_DownloadButton";
	
	//Added on Feb 16 2017 for TSHD Scripts
	public String strClearButton_ID						= "dvIcon_ClearButton";
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 181;
	
	public Updates_3rdPartyPortfolioDownloadPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();
		
		try {
			/** Fetching the PageObjects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
					.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
			
			if (PageObjectsMap.get("strParentFrame").get("ID") != null)
				strParentFrame_NAME = PageObjectsMap.get("strParentFrame").get(
						"ID");
			
			if (PageObjectsMap.get("strIFrame").get("XPATH") != null)
				strIFrame_XPATH = PageObjectsMap.get("strIFrame").get(
						"XPATH");
			
			if (PageObjectsMap.get("strPageTitle").get("XPATH") != null)
				strPageTitle_XPATH = PageObjectsMap.get("strPageTitle").get(
						"XPATH");
			
			if (PageObjectsMap.get("strRepIdDropdown").get("ID") != null)
				strRepIdDropdown_ID = PageObjectsMap.get("strRepIdDropdown").get("ID");
			
			if (PageObjectsMap.get("strLoadDatesButton").get("ID") != null)
				strLoadDatesButton_ID = PageObjectsMap.get(
						"strLoadDatesButton").get("ID");
			
			if (PageObjectsMap.get("strAvailableDatesList").get("ID") != null)
				strAvailableDatesList_ID = PageObjectsMap.get(
						"strAvailableDatesList").get("ID");
			
			if (PageObjectsMap.get("strDownloadLocationTextBox").get("ID") != null)
				strDownloadLocationTextBox_ID = PageObjectsMap.get("strDownloadLocationTextBox").get("ID");
			
			if (PageObjectsMap.get("strBrowseDownloadLocationButton").get("ID") != null)
				strBrowseDownloadLocationButton_ID = PageObjectsMap.get("strBrowseDownloadLocationButton").get("ID");
			
			if (PageObjectsMap.get("strDownloadButton").get("ID") != null)
				strDownloadButton_ID = PageObjectsMap.get("strDownloadButton").get("ID");
			
			if (PageObjectsMap.get("strClearButton").get("ID") != null)
				strClearButton_ID = PageObjectsMap.get("strClearButton").get("ID");
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of Updates_3rdPartyPortfolioDownloadPage Class", "Object should be successfully created of Updates_3rdPartyPortfolioDownloadPage class", "Failed to fetch the objects of Updates_3rdPartyPortfolioDownloadPage from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	public String[][] allObjects = {
			{strPageTitle_XPATH,"Page Header","XPATH"},
			{strRepIdDropdown_ID,"Rep ID Dropdown","ID"},
			{strLoadDatesButton_ID,"Load Available Dates Button","ID"},
			{strAvailableDatesList_ID,"Availables Dates list","ID"},
			{strDownloadLocationTextBox_ID,"Download Location Select Text Box","ID"},
			{strBrowseDownloadLocationButton_ID,"Browse Download Location Button","ID"},
			{strDownloadButton_ID,"Download Button","ID"}};
	
	/**
	 * Method to Verify Load Available Dates functionality
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 02-16-2017
	 * @param StrRepID - Rep ID to validate
	 * @return (boolean) true/false
	 */
	public boolean loadAvailableDates(String strRepID) {
		try {
			//Click on Clear button
			LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.id(strClearButton_ID)).click();
			
			//Wait for page to load
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			
			//Creating object for Select Drop down class from LPL Core driver
			SelectDropDown sdd = new SelectDropDown(driver, By.id(strRepIdDropdown_ID));
			
			//Select Rep ID
			sdd.selectDropDownByValue(strRepID);
			
			//Wait for page to load
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			
			//Click on Load Available Dates button
			LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.id(strLoadDatesButton_ID)).click();
			
			//Wait for page to load
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			
			//Verify that the latest date is previous business day
			WebElement objAvailableDatesSection = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE, By.id(strAvailableDatesList_ID));
			Select availableDates = new Select(objAvailableDatesSection);
			String latestDateAvailable = availableDates.getOptions().get(0).getText();
			
			//Prepare the expected date
			String strToday = LPLCoreUtil.getCurrentDay("EEEE");
			SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy"); 
			String strExpectedDate;
			Calendar cal = Calendar.getInstance();
			if(strToday.equalsIgnoreCase("Monday")){
				cal.add(Calendar.DATE, -3);	//-3 for subtracting 
				strExpectedDate = dateformat.format(cal.getTime());
			}else if (strToday.equalsIgnoreCase("Sunday")) {
				cal.add(Calendar.DATE, -2);	//-2 for subtracting 
				strExpectedDate = dateformat.format(cal.getTime());
			}else{
				cal.add(Calendar.DATE, -1);	//-1 for subtracting 
				strExpectedDate = dateformat.format(cal.getTime());
			}
			
			//Verify if the latest date is previous business day
			if(latestDateAvailable.equalsIgnoreCase(strExpectedDate)){
				availableDates.getOptions().get(0).click();
				return true;
			}else{
				availableDates.getOptions().get(0).click();
				strError = strError + " Load available dates failed. Latest available date is not previous business day";
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			strError = strError + " Load available dates failed. Error: " + e.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to Verify Download file from 3rd Party Portfolio download page
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 02-16-2017
	 * @param None
	 * @return boolean true if file downloaded
	 */
	public boolean download3rdPartyPortfolio() {
		try {
			//Wait for page to load
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			
			//Browse for the download folder mentioned
			WebElement objBrowseButton = LPLCoreUtil.waitForWebElement(lplCoreConstents.FAIR, By.id(strBrowseDownloadLocationButton_ID));
//			objBrowseButton.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			//Waiting to see if any pop up appears
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			
			//Press Down twice and then ENTER
			Runtime rt = Runtime.getRuntime();
			try {
				rt.exec(lplCoreConstents.strThirdPartyDownloadCommand);
				js.executeScript("arguments[0].click()", objBrowseButton);
			}
			catch( IOException e ) {
				e.printStackTrace();
			}
			   
			//Wait for page to load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			
			//Click on Download
			LPLCoreUtil.waitForWebElement(lplCoreConstents.FAIR, By.id(strDownloadButton_ID)).click();
			
			//Waiting to see if any pop up appears
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			
			//Select Certificates if the cert Selection pop up appears
			LPLCoreDriver.selectCertAfterMenuNavigation();
			
			//Waiting to see if any pop up appears
			LPLCoreSync.staticWait(lplCoreConstents.FAIRINMILLISEC);
			
			//If there is a transfer completed pop up, click on ok
			try {
				driver.switchTo().alert().accept();
			} catch (Exception e) {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}
			
			System.out.println(System.getProperty("user.home"));
			//Wait for File to download
			long lngTenMinutesAgo = System.currentTimeMillis() - (10*60*1000);
			downloadedFile = LPLCoreUtil.getLatestFilefromDir(System.getProperty("user.home"));
			if(downloadedFile.lastModified() < lngTenMinutesAgo){
				strError = strError + " 3rd party downloads failed. Last Modified file is older than 10 minutes";
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			strError = strError + " 3rd party downloads failed. Error: " + e.getMessage();
			return false;
		}
	}
}

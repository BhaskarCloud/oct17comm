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


/**
 * <p>
 * <br><b> Title: </b> Trading_Common.java</br>
 * <br><b> Description: </B>Common Page Object Library For Trading</br>
 * @author Aiswarya Srinivasan
 * @since 09-14-2016 
 * </p>
 */
public class Trading_Common extends BNCommon{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	BNCommon bnCommon = new BNCommon(driver);
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
		 
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strParentFrame_NAME					= "shell";
	
	public String strIFrame_XPATH						= ".//iframe[2]";
	
	public String strcontentFrame_NAME					= "content";
	
	public String strRepSearchTextBox_ID				= "ctl00_ContentPlaceHolder1_repSearch_TextBox";
	
	public String strLPLAccNumSearchTextBox_ID			= "ctl00_ContentPlaceHolder1_textBoxAccountNumber";
	
	public String strSearchButton_ID					= "dvIcon_ctl00_ContentPlaceHolder1_btnSearch";
	
	public String strSearchResultsTable_ID				= "ctl00_ContentPlaceHolder1_resultsGrid_ctl00_Header";
	
	public String strGoButton_ID						= "dvIcon_ctl00_ContentPlaceHolder1_btnGoLPLAccount";
	
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 193;
	
	public Trading_Common(WebDriver driver){
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();
		
		try {
			/** Fetching the PageObjects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
					.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
			
			if (PageObjectsMap.get("strParentFrame").get("ID") != null){
				strParentFrame_NAME = PageObjectsMap.get("strParentFrame").get("ID");
			}
			
			if (PageObjectsMap.get("strIFrame").get("XPATH") != null){
				strIFrame_XPATH = PageObjectsMap.get("strIFrame").get("XPATH");
			}
			
			if (PageObjectsMap.get("strcontentFrame").get("ID") != null){
				strcontentFrame_NAME = PageObjectsMap.get("strcontentFrame").get("ID");
			}
			
			if (PageObjectsMap.get("strSearchButton").get("ID") != null){
				strSearchButton_ID = PageObjectsMap.get("strSearchButton").get("ID");
			}
			
			if (PageObjectsMap.get("strSearchResultsTable").get("ID") != null){
				strSearchResultsTable_ID = PageObjectsMap.get("strSearchResultsTable").get("ID");
			}
			
			if (PageObjectsMap.get("strRepSearchTextBox").get("ID") != null){
				strRepSearchTextBox_ID = PageObjectsMap.get("strRepSearchTextBox").get("ID");
			}
			
			if (PageObjectsMap.get("strLPLAccNumSearchTextBox").get("ID") != null){
				strLPLAccNumSearchTextBox_ID = PageObjectsMap.get("strLPLAccNumSearchTextBox").get("ID");
			}
			
			if (PageObjectsMap.get("strGoButton").get("ID") != null){
				strGoButton_ID = PageObjectsMap.get("strGoButton").get("ID");
			}
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of Trading_Common Class", "Object should be successfully created of Trading_Common class", "Failed to fetch the objects of Trading_Common from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	/**
	 * Method to Enter Rep Id and Account Number and perform the search. 
	 * 
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 05-26-2016
	 * @param String strRepID - Rep ID
	 * 			String strLPLAccountNumber - Account Number
	 * @return boolean - True/False
	 */
	public boolean setTradingSearch(String strRepID, String strLPLAccountNumber){
		try {
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			
			//Enter Rep ID
			WebElement objRepID = driver.findElement(By.id(strRepSearchTextBox_ID));
			objRepID.sendKeys(strRepID);
			
			//Enter Account Number
			WebElement objLPLAccountNumber = driver.findElement(By.id(strLPLAccNumSearchTextBox_ID));
			objLPLAccountNumber.sendKeys(strLPLAccountNumber);
						
			// Click on Go
			WebElement objSearchButton = driver.findElement(By.id(strGoButton_ID));
			objSearchButton.click();
			
			return true;

		} catch (Exception e) {
			bnCommon.strError = this.strError;
			return false;

		}
	}

}

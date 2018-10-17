package PageObjectLibrary;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreUtil;

/**
 * <p>
 * <br><b> Title: </b> IAS_AccountViewPage.java</br>
 * <br><b> Description: </B> Page Object Library For Account View Page</br>
 * <br><b> Usage: </b></br>
 * 1. verifyAsOfDate(String dayFormat): This function is used to Verify date in Overall Returns which contains previous business day or not in AV Positions Page.
 * @author Sunitha Appaiah
 * @since 02/08/2017
 * </p>
 */
public class IAS_AccountViewPage extends LPLCoreUtil{

	/** WebDriver Reference */
	public WebDriver driver;
	
	/** LPLCoreConstents Reference */
	public LPLCoreConstents lplCoreConstents;

	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;
	
	/** CSS property value of Cancel Button */
	public String strCancelButton_CSS			= ".closeBtn";
	
	/** CSS property value of Account View Image */
	public String strAccountViewImage_CSS		= ".advisorLogo";

	/** XPATH property value of Price as of Date*/
	public String strPriceAsOf_XPATH  			= "//td[@class='alignCenter posMVHDcol3 t-last']";
	
	/** CSS property value of date */
	public String strAsOfDate_CSS 				= ".portfolioPercentValue.floatLeft";
	
	/** ID property value of Overall Returns Radio Button */
	public String strOverallReturnsRdoBtn_ID 	= "radioBtnOverallReturns";
	
	/** NAME property value of Overide Cerificate Link */
	public String strOverrideLink_NAME			= "overridelink";
	
	
	/** Current Page ID from FARM */ 
	public final int INT_PAGEID = 392;
	
	public IAS_AccountViewPage(WebDriver driver) {
		
		lplCoreConstents = LPLCoreConstents.getInstance();
		
		this.driver = driver;
		
		try {
			
		/** Fetching the page objects from FARM */
		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
		
		if(PageObjectsMap.get("strCancelButton").get("CSS")!=null)
			strCancelButton_CSS = PageObjectsMap.get("strCancelButton").get("CSS");
		
		if(PageObjectsMap.get("strAccountViewImage").get("CSS")!=null)
			strAccountViewImage_CSS = PageObjectsMap.get("strAccountViewImage").get("CSS");
		
		if(PageObjectsMap.get("strPriceAsOf").get("XPATH")!=null)
			strPriceAsOf_XPATH = PageObjectsMap.get("strPriceAsOf").get("XPATH");
		
		if(PageObjectsMap.get("strAsOfDate").get("CSS")!=null)
			strAsOfDate_CSS = PageObjectsMap.get("strAsOfDate").get("CSS");
		
		if(PageObjectsMap.get("strOverallReturnsRdoBtn").get("ID")!=null)
			strOverallReturnsRdoBtn_ID = PageObjectsMap.get("strOverallReturnsRdoBtn").get("ID");
		
		if(PageObjectsMap.get("strOverrideLink").get("ID")!=null)
			strOverrideLink_NAME = PageObjectsMap.get("strOverrideLink").get("ID");
		
		}catch(Exception ex){
		LPLCoreReporter.WriteReport("Initialization of AVPositionsPage Class", "Object should be successfully created of AVPositionsPage class", "Failed to fetch the objects of AVPositionsPage from Farm. Error:"+ex.toString(), "Failed", "");
		}
	}
	
	/**
	 * This function is used to Verify date in Overall Returns which contains previous business day or not in AV Positions Page
	 *
	 * @author Sunitha
	 * @version 1.0
	 * @since 02/08/2017
	 * @param String dayFormat - Search for Required day format e.g., EEE(Mon) or EEEE(Monday)
	 * 		  String DateFormat - Search for Required Date Format e.g., M/d/YYYY or M/d/YY
	 * @return boolean - True/False
	 * @param N/A
	 */
	public boolean verifyAsOfDate(String dayFormat, String DateFormat) {
		boolean blnReturn = false;
		
		try{
		
		//Click on Overall Returns Radio Button
		driver.findElement(By.id(strOverallReturnsRdoBtn_ID)).click();
			
		//Get the date in Overall Returns Page
		String strAsOfDate = driver.findElement(By.cssSelector(strAsOfDate_CSS)).getText();
		
		//Converting previous business date to String
		String previousBusinessDay =getPreviousBusinessDay(dayFormat, DateFormat);
		
		//Check whether the previous business day is displayed same as in Overall Returns page
		if(strAsOfDate.contains(previousBusinessDay.trim())){
				blnReturn = true;
			}else{
				blnReturn = false;
		}
		return 	blnReturn;
		
		} catch (Exception e) {
		  strError = strError + " Problem in Validating Date in Overall Returns - AV-Positions page. Error Details: "+e.getMessage();
			e.printStackTrace();
			return false;
			}
	}
}

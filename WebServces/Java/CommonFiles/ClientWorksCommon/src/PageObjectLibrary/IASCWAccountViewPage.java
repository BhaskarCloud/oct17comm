package PageObjectLibrary;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreUtil;

/**
 * <p>
 * <br><b> Title: </b> IASCWAccountViewPage.java</br>
 * <br><b> Description: </B> Page Object Library and common functions For Branch Trade Report</br>
 * <br><b>Usage:</br></b>
 * <br>verifyBalanceDate: This method is used to verifies the Balance Date </br
 * @author Jyothi Jyothi
 * @since 09-12-2017
 * </p>
 */
public class IASCWAccountViewPage extends ClientManagement_Common{

	
	/** _CSS Selector Property Value of Page Title. */
	public String strBalanceToday_XPATH;
	
	/** _CSS  Property Value of Advisor Logo. */
	public String strAdvisorLogo_CSS;
	
	/** _CSS  Property Value of Search . */
	public String strSearch_CSS;
	
	/** _CSS Property value of As Of Date. */
	public String strAsOfDate_CSS;
	
	/** _ID Property value of As Of Date. */
	String strOverAllReturns_ID;
    
	HomePage homePage;
	
	  
	/** Current Page _ID from FARM */ 
	static final int INTPAGE_ID = 455;
	
	
	public IASCWAccountViewPage(WebDriver driver){
		super(driver);
		try {
			
			homePage=new HomePage(driver);
			
			/** Fetching the page objects from FARM */
			HashMap<String,HashMap<String, String>> pageObjectsMap=LPLCoreDBConnect.getObjectsFromDB(INTPAGE_ID, new LPLConfig().getEnvId());
			
			if(pageObjectsMap.get("strBalanceToday").get("XPATH")!=null)
				strBalanceToday_XPATH = pageObjectsMap.get("strBalanceToday").get("XPATH");
			
			if(pageObjectsMap.get("strAdvisorLogo").get("CSS")!=null)
				strAdvisorLogo_CSS = pageObjectsMap.get("strAdvisorLogo").get("CSS");
			
			if(pageObjectsMap.get("strSearch").get("CSS")!=null)
				strSearch_CSS = pageObjectsMap.get("strSearch").get("CSS");		
			
			if(pageObjectsMap.get("strAsOfDate").get("CSS")!=null)
				strAsOfDate_CSS = pageObjectsMap.get("strAsOfDate").get("CSS");		
			
			if(pageObjectsMap.get("strOverAllReturns").get("ID")!=null)
				strOverAllReturns_ID = pageObjectsMap.get("strOverAllReturns").get("ID");
		} catch (Exception ex) {
			strError = strError+ex.getMessage();
			
		}
	}
		
		/**
		 * verifyBalanceDate : This method is used to verifies the Balance Date
		 * @author Jyothi Jyothi
		 * @version 1.0
		 * @since 09-12-2017
		 * @param String - to provide dayFormat
		 * 			String - to provide strDateFormat
		 * @return boolean True/False
		 */
		public boolean verifyBalanceDate(String dayFormat, String strDateFormat ){
			
			try {
				// wait for  page to load
				homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);	
				
				//get text from balance on 
				String strBalanceToday=driver.findElement(By.xpath(strBalanceToday_XPATH)).getText();
				
				//get previous Business day
				String strCurrentday =LPLCoreUtil.getCurrentDay(strDateFormat);
				
				//check Balance on date is same as Previous business day 
				if(strBalanceToday.contains(strCurrentday))
					return true;

			} catch (Exception ex) {
				strError = strError+ex.getMessage();
				return false;
			}
			return true;
	}
}

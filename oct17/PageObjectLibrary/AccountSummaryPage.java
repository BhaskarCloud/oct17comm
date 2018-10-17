package PageObjectLibrary;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.WebToolKit.WebTable;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> AccountSummaryPage.java</br>
 * <br><b> Description: </B> Page Object Library For Account Summary Page</br> 
 * <br><b>Usage:</br></b>
 * <br>1. getAccountNumber: Method to retrieve account number from Account Summary Page</br>
 * <br>2. performBackNavigation: Method to navigate back to Client Management Page</br>
 * <br>3. navigateToTab: Method to navigate to different tabs under Account Summary page</br>
 * <br>4. clickArrow: Method to click the arrow button of the mentioned row in the search result table</br> 
 * @author Rahul Agarwal
 * @since 05-26-2016
 * </p>
 */
public class AccountSummaryPage extends ClientManagement_Common{

	/** WebDriver Reference */
	WebDriver driver;
	
	/** String type...To be used to capture any error occurred at runtime. */
	public String strError; 
	
	/** Binding property of Account Number in Investment tab of Account Summary page */
	String strAccountNumber_Binding = "header.account.acctNo|accountNo";
	
	/** Binding property of Back Navigation on Account Summary page */
	String strBackNavigation_Binding = "breadcrumbs.backLabel";
	
	/** Xpath Selector property of different tabs in Account Summary page */
	public String strAccountSummaryTab_Xpath  = "//*[@id='details-nav']//a[text()='xxx']";
	
	/** CSS Selector property of search result table in Investment tab of Account Summary page */
	public String strSearchResultTable_Investment_CSS = "#data-table";
	
	/** id property value of Data table displayed in the page */
	private String strDataTable_id					= "data-table";
	
	/** CSS Selector property of row of search result table in Investment tab of Account Summary page */
	public String strRow_Result_Investment_Repeater = "row in dtVm.dataSet.data";
	
	/** CSS Selector property of Short Term Lots and Long Term Lots in Investment tab of Account Summary page */
	public String strInvestmentLots_CSS = ".lpl-master-detail-table>div>a.master-detail-inner-toggle.open>h4";
	
	/** Html Tag of Arrow button */
	String strArrowTag = "i";
	
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */ 
	public final int INT_PAGEID = 59;

	public AccountSummaryPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();
		
		/** Fetching Page Object Identification Properties from FARM for current page */ 
		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
		
		if(PageObjectsMap.get("strAccountNumber").get("ANGULARREF")!=null)
			strAccountNumber_Binding = PageObjectsMap.get("strAccountNumber").get("ANGULARREF");
		
		if(PageObjectsMap.get("strBackNavigation").get("ANGULARREF")!=null)
			strBackNavigation_Binding = PageObjectsMap.get("strBackNavigation").get("ANGULARREF");
		
		if(PageObjectsMap.get("strAccountSummaryTab").get("XPATH")!=null)
			strAccountSummaryTab_Xpath = PageObjectsMap.get("strAccountSummaryTab").get("XPATH");
		
		if(PageObjectsMap.get("strRow_Result_Investment").get("ANGULARREF")!=null)
			strRow_Result_Investment_Repeater = PageObjectsMap.get("strRow_Result_Investment").get("ANGULARREF");
		
		if(PageObjectsMap.get("strInvestmentLots").get("CSS")!=null)
			strInvestmentLots_CSS = PageObjectsMap.get("strInvestmentLots").get("CSS");
		
		if(PageObjectsMap.get("strArrowTag").get("ID")!=null)
			strArrowTag = PageObjectsMap.get("strArrowTag").get("ID");
		
		this.strSearchResultTable_Investment_CSS = super.strDataTable_css;
		
		this.strDataTable_id = super.strDataTable_id;
	}
	
	/**
	 * Method to get account number from Account Summary Page
	 * 
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 05-26-2016
	 * @return String - Account No
	 */
	public String getAccountNumber(){
		try{
			//Wait for the Objects to get loaded...
			LPLCoreSync.waitTillVisible(driver, ByAngular.binding(strAccountNumber_Binding), lplCoreConstents.BASE);
			String accountNumber = driver.findElement(ByAngular.binding(strAccountNumber_Binding)).getText();
				return accountNumber;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			return "";
		}
	}
	
	/**
	 * Method to navigate back to Client Management Page
	 * 
	 * @author Rahul Agarwal
	 * @version 1.0
	 * @since 05-26-2016
	 * @return boolean
	 */
	public boolean performBackNavigation(){
		try{
			driver.findElement(ByAngular.binding(strBackNavigation_Binding)).click();
			return true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to navigate to different tabs under Account Summary page
	 * 
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-02-2016
	 * @param strTabName - Different tabs under Account Summary page
	 * @return boolean
	 */
	public boolean navigateToTab(String strTabName){
		boolean blnResult = false;
		try{
			// Wait for the Objects to get loaded...
			LPLCoreSync.waitTillVisible(driver, By.xpath(strAccountSummaryTab_Xpath.replace("xxx", strTabName)), lplCoreConstents.MEDIUM);
			WebElement objTab = driver.findElement(By.xpath(strAccountSummaryTab_Xpath.replace("xxx", strTabName)));
			if (objTab.isDisplayed()){
				objTab.click();
				blnResult = true;
			}
			return blnResult;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			return blnResult;
		}
	}
	
	/**
	 * Method to click the arrow button of the mentioned row in the search result table
	 * 
	 * @author Ambarish Khatua
	 * @version 1.0
	 * @since 06-03-2016
	 * @param int intRowIndex - Row index at which the arrow button is to be clicked.
	 * @return boolean
	 */
	public boolean clickArrow(int intRowIndex){
		boolean blnResult = false;
		try{
			// Wait for the Objects to get loaded...
			waitforCMTableToLoad();
			ClientManagement_Common cmCommon = new ClientManagement_Common(driver);
			WebElement objSearchResultTable = driver.findElement(By.cssSelector(strSearchResultTable_Investment_CSS));
			WebTable table = new WebTable(null, By.tagName(cmCommon.strRow_tag),null);
			table.waitTillTableLoaded(driver, By.id(strDataTable_id), lplCoreConstents.VERYHIGH);
			WebElement objArrow = table.getChildItem(objSearchResultTable, intRowIndex, 1, strArrowTag);
			if (objArrow.isDisplayed()){
				objArrow.click();
				blnResult = true;
			}
			return blnResult;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			return blnResult;
		}
	}
}

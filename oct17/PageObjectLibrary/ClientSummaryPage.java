package PageObjectLibrary;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> ClientSummaryPage.java</br>
 * <br><b> Description: </B> Page Object Library For Client Summary Page</br> 
 * <br><b>Usage:</br></b>
 * <br>1. getClientName: Method to retrieve Client Name from Client Summary Page</br>
 * <br>2. performBackNavigation: Method to Navigate back to Clients page in Client Management</br>
 * 
 * @author Aiswarya Srinivasan
 * @since 06-02-2016
 * </p>
 */
public class ClientSummaryPage extends AccountSummaryPage{

	/** WebDriver Reference */
	WebDriver driver;
	
	/** css Selector property of Client Name on Account Summary page */
	String strClientName_css = "div#details-header>h2>span.ng-binding";
	
	/** Binding property of Back Navigation on Account Summary page */
	String strBackNavigation_Binding = "breadcrumbs.backLabel";
	
	/** css Selector property value of Sub tab Link */
	private String strsubTabLink_css 					= "div#details-nav>ul>li>a.ng-binding";
	
	/** css Selector property value of Client Profile Summary Heading */
	private String strClientProfileSummaryHeading_css 	= "div#client-profile-summary>div.panel-heading";
	
	/** css Selector property value of Accounts Summary Heading */
	private String strAcSummaryHeading_css 				= "div#accounts-summary>div.panel-heading";
	
	/** css Selector property value of Accounts Summary Heading */
	private String strClientBalancesHeading_css 		= "div#accountbalances>div.panel-heading";
	
	/** css Selector property value of user saved quick views */
	private String strcurrentQV_css 					= "ul#user-saved-views>li.list-group-item.ng-scope.active>a.ng-binding";
	
	/** css Selector property value of selected sub tab */
	private String strselectedSubTab_css 				= "div#details-nav>ul>li.ng-scope.active>a.ng-binding";
	
	/** css Selector property value of Client Profile Summary Heading */
	private String strClientSummaryHeading_css 			= ".panel-heading";
	
	/** Goals Widget Xpath */
	public String  strGoalWidget_xpath =".//*[@id='create-plan-widget']";
	
	public String strError;
	
	public LPLCoreConstents lplCoreConstents;
	
	public ClientSummaryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.strBackNavigation_Binding = super.strBackNavigation_Binding;
		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(60, new LPLConfig().getEnvId());
		try{
		
			lplCoreConstents = LPLCoreConstents.getInstance();
			if(PageObjectsMap.get("strClientName").get("CSS")!=null)
				strClientName_css = PageObjectsMap.get("strClientName").get("CSS");
			if(PageObjectsMap.get("strsubTabLink").get("CSS")!=null)
				strsubTabLink_css = PageObjectsMap.get("strsubTabLink").get("CSS");
			if(PageObjectsMap.get("strClientProfileSummaryHeading").get("CSS")!=null)
				strClientProfileSummaryHeading_css = PageObjectsMap.get("strClientProfileSummaryHeading").get("CSS");
			if(PageObjectsMap.get("strAcSummaryHeading").get("CSS")!=null)
				strAcSummaryHeading_css = PageObjectsMap.get("strAcSummaryHeading").get("CSS");
			if(PageObjectsMap.get("strClientBalancesHeading").get("CSS")!=null)
				strClientBalancesHeading_css = PageObjectsMap.get("strClientBalancesHeading").get("CSS");
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			LPLCoreReporter.WriteReport("Initialization of Client summary page", "Object should be successfully created for Client summary page", "Failed to create the object of Client summary page. Error:"+ex.toString(), "Failed", "");
		}

	}
	
	public String[] summaryTabObjects = {strClientProfileSummaryHeading_css,strAcSummaryHeading_css,strClientBalancesHeading_css};
	
	/**
	 * Method to get Client name from Client Summary Page
	 * @author Aiswarya Srinivasan
	 * @since 06-02-2016
	 * @return strClientName - String type
	 */
	public String getClientName(){
		try{
			//Wait for the Objects to get loaded...
			LPLCoreSync.waitTillInVisible(driver, ByAngular.cssContainingText(strClientName_css,""), lplCoreConstents.MEDIUM);
			LPLCoreSync.waitTillInVisible(driver, ByAngular.cssContainingText(strClientName_css,""), lplCoreConstents.MEDIUM);

			String strClientName = driver.findElement(ByAngular.cssContainingText(strClientName_css,"")).getText();
				return strClientName;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			return "";
		}
	}
	
	/**
	 * Method to verify any Sub tab in Client Summary Page
	 * @author Aiswarya Srinivasan
	 * @since 06-02-2016
	 * @return blnVerified - Boolean type
	 */
	public boolean verifySubTab(String strTabName){
		try{
			boolean blnVerified = false;
			clickSubTab(strTabName);
			
			//Wait for the Objects to get loaded...
			HomePage homePage = new HomePage(driver);

			homePage.waitForPageLoading(homePage.lplCoreConstents.MEDIUM);

			homePage.waitForPageLoading(homePage.lplCoreConstents.MEDIUM);
			
			switch(strTabName){
			case "Summary":
				blnVerified = verifyObjectsInSubTab(summaryTabObjects);
				break;
			case "Activity":
				if(driver.findElement(ByAngular.cssContainingText(strselectedSubTab_css, "Activity")).isDisplayed()){
					blnVerified = true;
				}
				break;
			case "Investments": case "Requests": case "Documents":
				if(driver.findElement(ByAngular.cssContainingText(strcurrentQV_css, strTabName)).isDisplayed() 
						& driver.findElement(ByAngular.cssContainingText(strselectedSubTab_css, strTabName)).isDisplayed()){
					blnVerified = true;
				}
				break;
			default:
				break;
			}
			return blnVerified;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to Click any Sub tab in Client Summary Page
	 * @author Aiswarya Srinivasan
	 * @since 06-02-2016
	 * @return Boolean type
	 */
	public boolean clickSubTab(String strTabName){
		try{
			//Wait for the Objects to get loaded...
			LPLCoreSync.waitTillInVisible(driver, ByAngular.cssContainingText(strClientName_css,""), lplCoreConstents.MEDIUM);
			LPLCoreSync.waitTillInVisible(driver, ByAngular.cssContainingText(strClientName_css,""), lplCoreConstents.MEDIUM);

			driver.findElement(ByAngular.cssContainingText(strsubTabLink_css, strTabName)).click();
				return true;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to Verify the Sub tabs from Client Summary Page
	 * @author Aiswarya Srinivasan
	 * @since 06-02-2016
	 */
	public boolean verifyObjectsInSubTab(String[] TabObjects){
		boolean objFound = true;
		for(String strObj:TabObjects){
			if (!driver.findElement(ByAngular.cssContainingText(strObj,"")).isDisplayed()){
				objFound = false;
			}
		}
		return objFound;
	}
	
	/**
	 * Method to navigate back to Clients - Client Management Page
	 * @author Aiswarya Srinivasan
	 * @since 06-02-2016
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
	 * Method to verify Object on Client Summary Page
	 * @author Rahul Agarwal
	 * @since 06-22-2016
	 * @return blnVerified - Boolean type
	 */
	public boolean verifyClientSummary(String strClientType){
		try{
			boolean blnVerified = false;
			
			//Wait for the Objects to get loaded...
			HomePage homePage = new HomePage(driver);

			homePage.waitForPageLoading(homePage.lplCoreConstents.MEDIUM);

			homePage.waitForPageLoading(homePage.lplCoreConstents.MEDIUM);

			
			if(driver.findElement(ByAngular.cssContainingText(strClientSummaryHeading_css, strClientType)).isDisplayed()){
				blnVerified = true;
			}
			driver.switchTo().defaultContent();
			return blnVerified;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to verify All the sub tabs are present on Client Summary Page
	 * @author Ravneet kaur
	 * @since 06-13-2017
	 * @param String... strSubTabNames - Sub tab names in a list
	 * @return blnVerified - Boolean type
	 */
	public boolean verifySubTabsInClientSummary(String... strSubTabNames){
		try{
			boolean blnAllTabsPresent = false;
			
			//Wait for the Objects to get loaded...
			HomePage homePage = new HomePage(driver);
			homePage.waitForPageLoading(homePage.lplCoreConstents.MEDIUM);
			
			//
			for (String strThisTab : strSubTabNames) {
				if(!LPLCoreUtil.isElementPresent(driver.findElement(ByAngular.cssContainingText(strsubTabLink_css, strThisTab)))){
					blnAllTabsPresent = false;
				}else{
					blnAllTabsPresent = true;
				}
			}
			return blnAllTabsPresent;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
	}
}

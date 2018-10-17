package PageObjectLibrary;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;

/**
 * <p>
 * <br><b> Title: </b> IAS_EnhancedTradingPage.java</br>
 * <br><b> Description: </B> Page Object Library For IAS_EnhancedTradingPage</br>
 * <b>Usage:</br></b> 
 * <br>1. navigateToETMenu(String strETMainMenu, String strETSubMenu): Method to Enter Amount, Symbol and Pre Submit the request.</br>
 * @author Sunitha
 * @since 03/02/2017 
 * </p>
 */
public class EnhancedTradingPage extends BNCommon{

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;

	/**Array for Holding objects to check or verify in the Sanity scripts */
	public String[][] allPageObjects;

	/** ------------------------------------------------Page Objects------------------------------------------------ */
	
	public String strETMainMenu_XPATH					= "//ul[@id='horizontalMenu']//a[contains(text(),'xxx')]";

	public String strETSubMenu_XPATH					= "//a[text()='xxx']"; 

	public String strAccountSelectionPanel_ID			= "AccountSelectionSectionID";
	
	public String strAccountNumberSearchBox_XPATH		= "//input[@type='text']";
	
	public String strSingleOrderEntry_XPATH				= "//span[text()='Single Order Entry']";
	
	public String strGoButton_XPATH						= "//button[text()='Go']";
	
	public String strCreateTradesSubmenu_ID				= "CreateTradesSubMenu";
	
	public String strCreateHistorySubMenu_ID			= "CreateHistorySubMenu";
	
	public String strPageTitle_XPATH					= "//ul[@class='ux-menu-container' and @id='horizontalMenu']";
	
	public String strOverrideLink_NAME					= "overridelink";
	
	public String strMainMenu_XPATH						= "//a[@data-qtip='xxx']";
	
	public String strSubMenus_XPATH						= "//a[@class='x-menu-item-link']";
	
	public String strIframe_NAME						= "actionIFrame";
	
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */

	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;

	/** Current Page ID from FARM */
	public final int INT_PAGEID = 414;

	public EnhancedTradingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();

		try {
			/** Fetching the PageObjects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
					.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

			if (PageObjectsMap.get("strETMainMenu").get("XPATH") != null){
				strETMainMenu_XPATH = PageObjectsMap.get("strETMainMenu").get("XPATH");
			}

			if (PageObjectsMap.get("strETSubMenu").get("XPATH") != null){
				strETSubMenu_XPATH = PageObjectsMap.get("strETSubMenu").get("XPATH");
			}
			
			if (PageObjectsMap.get("strAccountSelectionPanel").get("ID") != null){
				strAccountSelectionPanel_ID = PageObjectsMap.get("strAccountSelectionPanel").get("ID");
			}

			if (PageObjectsMap.get("strAccountNumberSearchBox").get("XPATH") != null){
				strAccountNumberSearchBox_XPATH = PageObjectsMap.get("strAccountNumberSearchBox").get("XPATH");
			}
			if (PageObjectsMap.get("strSingleOrderEntry").get("XPATH") != null){
				strSingleOrderEntry_XPATH = PageObjectsMap.get("strSingleOrderEntry").get("XPATH");
			}

			if (PageObjectsMap.get("strGoButton").get("XPATH") != null){
				strGoButton_XPATH = PageObjectsMap.get("strGoButton").get("XPATH");
			}
			
			if (PageObjectsMap.get("strCreateTradesSubmenu").get("ID") != null){
				strCreateTradesSubmenu_ID = PageObjectsMap.get("strCreateTradesSubmenu").get("ID");
			}

			if (PageObjectsMap.get("strCreateHistorySubMenu").get("ID") != null){
				strCreateHistorySubMenu_ID = PageObjectsMap.get("strCreateHistorySubMenu").get("ID");
			}
			
			if (PageObjectsMap.get("strPageTitle").get("XPATH") != null){
				strPageTitle_XPATH = PageObjectsMap.get("strPageTitle").get("XPATH");
			}

			if (PageObjectsMap.get("strOverrideLink").get("ID") != null){
				strOverrideLink_NAME = PageObjectsMap.get("strOverrideLink").get("ID");
			}
			
			if (PageObjectsMap.get("strMainMenu").get("XPATH") != null){
				strMainMenu_XPATH = PageObjectsMap.get("strMainMenu").get("XPATH");
			}

			if (PageObjectsMap.get("strIframe").get("ID") != null){
				strIframe_NAME = PageObjectsMap.get("strIframe").get("ID");
			}
			
			if (PageObjectsMap.get("strSubMenus").get("XPATH") != null){
				strSubMenus_XPATH = PageObjectsMap.get("strSubMenus").get("XPATH");
			}

			String[][] allPageObjects = {
					{strAccountSelectionPanel_ID,"Account Selection Panel","ID"},
					{strAccountNumberSearchBox_XPATH,"Account Number Search Box","XPATH"},
					{strGoButton_XPATH,"Go Button","XPATH"},
					{strSingleOrderEntry_XPATH,"Single Order Entry Header","XPATH"}};

			this.allPageObjects = allPageObjects;
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of CCS_EnhancedTradingPage Class", "Object should be successfully created of CCS_EnhancedTradingPage class", "Failed to fetch the objects of CCS_EnhancedTradingPage from Farm. Error:"+ex.toString(), "Failed", "");
		}
	}

	/**
	 * Method to Navigate to Enhanced Trading Sub Menu. 
	 * 
	 * @author Sunitha
	 * @version 1.0
	 * @since 04/03/2017
	 * @param String strETMainLinkName - Main Menu
	 * 		  String strETSubLinks - Sub Menu
	 * @return boolean - True/False
	 */
	public boolean navigateToETMenu(String strETMainLinkName, String... strETSubLinks){
		boolean blnSubMenuFound = false;
		try {
			LPLCoreSync.staticWait(lplCoreConstents.BASE);
			
			//click on Main Menu
			driver.findElement(By.xpath(strMainMenu_XPATH.replace("xxx", strETMainLinkName))).click();
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			// If the Sub menu items in the parameters is not empty, then
			// proceed to click further sub menu items
			if (strETSubLinks.length != 0) {
				List<WebElement> SubMenuLinks = null;
				for (int intsublinks = 0; intsublinks < strETSubLinks.length; intsublinks++) {
					try {
						if (!strETSubLinks[intsublinks].equals(null)) {
							SubMenuLinks = driver.findElements(By.xpath(strSubMenus_XPATH));
							    for (WebElement SubMenuLink : SubMenuLinks) {
							    	String strSubMenu = SubMenuLink.getText();
								    if (strSubMenu.equalsIgnoreCase(strETSubLinks[intsublinks])) {
									    try {
										    SubMenuLink.click();
									    } catch (Exception e) {
										    JavascriptExecutor js = (JavascriptExecutor) driver;
										    js.executeScript("arguments[0].click();",SubMenuLink);
									    }
									blnSubMenuFound = true;
									break;
								   }
							}
							// Wait for the Objects to get loaded...						
							LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
						}
					} catch (NullPointerException e) {
									blnSubMenuFound = true;
									break;
						}
				}			
				if(!blnSubMenuFound){
					strError = strError + " Sub menu not found for user " + loginCredentials.get("Username");
					return false;
				}else{
								
					// Wait for the Objects to get loaded...						
					LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					return true;
				}
			} else {
				strError = strError + " Enhanced Trading Page Navigation Unsuccessful ";
				return false;
			}
		} catch (Exception ex) {
			strError = strError + ex.getMessage();
			return false;
		}
	}
}

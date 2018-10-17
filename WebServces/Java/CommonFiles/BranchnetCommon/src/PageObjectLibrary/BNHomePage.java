
package PageObjectLibrary;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreSync;
/**
 * <p>
 * <br>
 * <b> Title: </b> BNHomePage.java </br> <br>
 * <b> Description: </B> Page Object Library For BranchNet Home Page </br> <br>
 * <b>Usage:</br></b> <br>
 * 1. navigateToBNMenu: Method to navigate to different applications in
 * BranchNet </br> <br>
 * 2. BNlogout: Method to logout of BranchNet </br> <br>
 * 3. cancelCertPopUp: Method to cancel out the Certificate selection pop up
 * </br> <br>
 * 5. switchTo: This function is used to switch to different window / iFrame
 * </br> <br>
 * 6. verifyNewTab: This function is used to verify if the page has opened in
 * new window </br> <br>
 * 7. waitForPageLoading: Method to wait / Temporary </br> <br>
 * 8. logOutWithOutClosingBrowser: Method to Logout of ClientWorks without
 * closing the browser </br> <br>
 * 9. closeBrowser: Method to Close Browser </br> <br>
 * 10. openNewTab: Method to Open New Tab in Browser </br>
 * 
 * @author Aiswarya Lakshmi
 * @since 08-17-2016
 *        </p>
 */
public class BNHomePage extends LPLCoreDriver {

	/** WebDriver Reference */
	public WebDriver driver;

	public String strError;

	public String strHomePageIdentifier_ID 				= "ctl00_ContentPlaceHolder1_pageTitle";

	public String strMainMenuLink_XPATH 				= "//td[text()='x' and @class='LPLMenu_TopMenu']";

	public String strSubmenu_XPATH 						= ".//td[contains(@id,'xxx')]";

	public String strParentFrame_NAME					= "shell";

	public String strSubFrame_NAME 						= "panel_welcome";
	
	public String strQuickLinks_XPATH 					= "//img[@alt='x']";
	
	public String strMainMenu_IDText					="";
	
	public String strSubMenu_IDText						="";
	
	public String strSubMenuTable_IDText				="";
	
	public String strChildMenu_IDText					="";
	public LPLCoreConstents lplCoreConstents;

	// Creating Javascript executor object for Executing the Java script click
	// method for any element
	JavascriptExecutor js = (JavascriptExecutor) driver;

	/** Current Page ID from FARM */
	public final int INT_PAGEID = 118;

	public BNHomePage(WebDriver driver) {
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();

		/** Fetching the PageObjects from FARM */
		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
				.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

		if (PageObjectsMap.get("strMainMenuLink").get("XPATH") != null)
			strMainMenuLink_XPATH = PageObjectsMap.get("strMainMenuLink").get(
					"XPATH");

		if (PageObjectsMap.get("strSubmenu").get("XPATH") != null)
			strSubmenu_XPATH = PageObjectsMap.get("strSubmenu").get("XPATH");

		if (PageObjectsMap.get("strHomePageIdentifier").get("ID") != null)
			strHomePageIdentifier_ID = PageObjectsMap.get(
					"strHomePageIdentifier").get("ID");
		
		if (PageObjectsMap.get("strParentFrame").get("ID") != null)
			strParentFrame_NAME = PageObjectsMap.get("strParentFrame").get("ID");
		
		if (PageObjectsMap.get("strSubFrame").get("ID") != null)
			strSubFrame_NAME = PageObjectsMap.get("strSubFrame").get("ID");
	}

	/**
	 * Method to navigate to various links from BranchNet Home page
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 08-17-2016
	 * @param strMainLink
	 *            - Main Menu, strSubLinks - Sub Menu links in an array if the
	 *            sub menu has children sub menus
	 * @return (boolean) true/false
	 */
	public boolean navigateToBNMenu(String strMainLinkName,
			String... strSubLinks) {
		boolean blnSubMenuFound = false;
		try {
			/*String parentWindowHandle = null;
			parentWindowHandle = driver.getWindowHandle();*/
		
			// Wait for the Objects to get loaded...
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);

			// Switch to proper frames and validate the Welcome message in home
			// page
			driver.switchTo().defaultContent();
			driver.switchTo().frame(strParentFrame_NAME);
			driver.switchTo().frame(strSubFrame_NAME);
			LPLCoreSync.waitTillVisible(driver, By.id(strHomePageIdentifier_ID),lplCoreConstents.MEDIUM);
			
			// Switching to default content and clicking on the main menu item
			driver.switchTo().defaultContent();
			WebElement mainMenuLink = driver.findElement(By
					.xpath(strMainMenuLink_XPATH.replaceAll("'x'", "'"
							+ strMainLinkName + "'")));
			strMainMenu_IDText = mainMenuLink.getAttribute("id");
			strSubMenu_IDText = strMainMenu_IDText + "-subMenu-menuItem";
			strSubMenuTable_IDText = strMainMenu_IDText + "-subMenu";
			mainMenuLink.click();
			
			// Wait for the Objects to get loaded...
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);

			// If the Sub menu items in the parameters is not empty, then
			// proceed to click further sub menu items
			if (strSubLinks.length != 0) {
				List<WebElement> SubMenuLinks = null;
				for (int intsublinks = 0; intsublinks < strSubLinks.length; intsublinks++) {
					try {
						if (!strSubLinks[intsublinks].equals(null)) {
							WebElement objMenuTable = driver.findElement(By
									.id(strSubMenuTable_IDText));
							SubMenuLinks = objMenuTable.findElements(By
									.xpath(strSubmenu_XPATH.replaceAll("xxx",
											strSubMenu_IDText)));
							for (WebElement SubMenuLink : SubMenuLinks) {
								if (SubMenuLink.getText().equalsIgnoreCase(
										strSubLinks[intsublinks])) {
									try {
										strSubMenu_IDText = SubMenuLink
												.getAttribute("id");
										SubMenuLink.click();
									} catch (Exception e) {
										js.executeScript(
												"arguments[0].click();",
												SubMenuLink);
									}
									blnSubMenuFound = true;
									break;
								}
							}
							// Wait for the Objects to get loaded...						
							LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
							
							strSubMenuTable_IDText = strSubMenu_IDText
									+ "-subMenu";
							strSubMenu_IDText = strSubMenu_IDText
									+ "-subMenu-menuItem";
							SubMenuLinks = null;
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
					
					//Added the below method to handle the Certificate PopUp after menu navigation
					LPLCoreDriver.selectCertAfterMenuNavigation();
					return true;
				}
			} else {
				strError = strError + " BN Page Navigation Unsuccessful ";
				return false;
			}
		} catch (Exception ex) {
			strError = strError + ex.getMessage();
			return false;
		}
	}
	
	/**
	 * Method to navigate to various Quick links from BranchNet Home page
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 08-19-2016
	 * @param strLinkName
	 *            - The link name
	 * @return (boolean) true/false
	 */
	public boolean quickLinksNavigation(String strLinkToolTipText) {
		String strXpath = strQuickLinks_XPATH.replaceAll("'x'", "'" + strLinkToolTipText + "'");
		try {
			// Wait for the Objects to get loaded...
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);

			// Switching to default content and clicking on the Quick link
			driver.switchTo().defaultContent();
			LPLCoreSync.waitTillVisible(driver, By.xpath(strXpath),lplCoreConstents.MEDIUM);

			WebElement qLink = driver.findElement(By.xpath(strXpath));
			qLink.click();

			// Wait for the Sub menu items to get loaded...
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			
			if(!strLinkToolTipText.toLowerCase().trim().equals("logout")){
				//Added the below method to handle the Certificate PopUp after menu navigation
				LPLCoreDriver.selectCertAfterMenuNavigation();
			}
			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * Method to navigate to various links in RC
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 08-19-2016
	 * @param strLinkName
	 *            - The link name
	 * @return (boolean) true/false
	 */
	public boolean RCNavigation(String strNavigationTagName,By landingPageVerificationElement) {
		try {
			//Loading the file from the given path
			 FileInputStream xmlFile=new FileInputStream("C:\\FarmClient\\TestDir\\ProjectConfig\\RCMenuNavigation.xml");
			 
			 //Parsing the XML file into a document
			 Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
			 
			 Node myNode = document.getElementsByTagName(strNavigationTagName).item(0);
			 String strnavigationString = myNode.getNodeValue();
			 while (!(myNode.getParentNode().getNodeName().equalsIgnoreCase("RESOURCE_CENTER"))) {
				 myNode = myNode.getParentNode();
				 strnavigationString = strnavigationString + myNode.getNodeValue();
			 }
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

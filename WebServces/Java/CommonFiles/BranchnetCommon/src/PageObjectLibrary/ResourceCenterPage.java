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
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreUtil;

/**
 * <p>
 * <br>
 * <b> Title: </b> ResourceCenterPage.java </br> <br>
 * <b> Description: </B> Page Object Library For BranchNet Resource center Page
 * </br> <br>
 * <b>Usage:</br></b> <br>
 * 1. RCMenuNavigation: Method to navigate to different links in Resource center
 * </br> <br>
 * 
 * @author Aiswarya Srinivasan
 * @since 08-23-2016
 *        </p>
 */
public class ResourceCenterPage extends BNCommon {
	/** WebDriver Reference */
	public WebDriver driver;

	public String strError;

	public String strParentFrame_NAME 				= "shell";

	public String strSubFrame_XPATH 				= "//iframe[contains(@id,'ResourceCenter')]";

	public String strMainMenuLink_XPATH 			= "//*[@class='tab dropdown']/a";

	public String strSubmenuLinkType1_XPATH 		= "//*[@class='dropdown-menu']/li";

	public String strSubmenuLinkType2_XPATH 		= ".//ul/li";
	
	//Added Level 2 Objects on 12-08-2016 - Aiswarya
	public String strPageAggregationHeader_xpath  	= "//*[@id='page-aggregation']/div/header/div/h1";

	public String strPageAggregationHeader_id  		= "page-aggregation";
	
	public String strh1Header_xpath					= "//div[@class='title']/h1";
	
	public String strh1Header_tagName  				= "h1";
	
	public LPLCoreConstents lplCoreConstents;

	// Creating Javascript executor object for Executing the Java script click
	// method for any element
	JavascriptExecutor js = (JavascriptExecutor) driver;

	/** Current Page ID from FARM */
	public final int INT_PAGEID = 133;

	public ResourceCenterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();

		/** Fetching the PageObjects from FARM */
		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
				.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
		if (PageObjectsMap.get("strParentFrame").get("ID") != null)
			strParentFrame_NAME = PageObjectsMap.get("strParentFrame")
					.get("ID");

		if (PageObjectsMap.get("strSubFrame").get("XPATH") != null)
			strSubFrame_XPATH = PageObjectsMap.get("strSubFrame").get("XPATH");

		if (PageObjectsMap.get("strMainMenuLink").get("XPATH") != null)
			strMainMenuLink_XPATH = PageObjectsMap.get("strMainMenuLink").get(
					"XPATH");

		if (PageObjectsMap.get("strSubmenuLinkType1").get("XPATH") != null)
			strSubmenuLinkType1_XPATH = PageObjectsMap.get(
					"strSubmenuLinkType1").get("XPATH");

		if (PageObjectsMap.get("strSubmenuLinkType2").get("XPATH") != null)
			strSubmenuLinkType2_XPATH = PageObjectsMap.get(
					"strSubmenuLinkType2").get("XPATH");
		
		if (PageObjectsMap.get("strPageAggregationHeader").get("XPATH") != null)
			strPageAggregationHeader_xpath = PageObjectsMap.get(
					"strPageAggregationHeader").get("XPATH");
		
		if (PageObjectsMap.get("strPageAggregationHeader").get("ID") != null)
			strPageAggregationHeader_id = PageObjectsMap.get(
					"strPageAggregationHeader").get("ID");
		
		if (PageObjectsMap.get("strh1Header").get("ID") != null)
			strh1Header_tagName = PageObjectsMap.get(
					"strh1Header").get("ID");
		
		if (PageObjectsMap.get("strh1Header").get("XPATH") != null)
			strh1Header_xpath = PageObjectsMap.get(
					"strh1Header").get("XPATH");
	}

	/**
	 * Method to navigate to various links in Resource center Menu
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 08-23-2016
	 * @param strNavigationXMLTag
	 *            - The Tag in the Navigation XML file which represents the
	 *            Navigation path inside RC Application
	 * @return (boolean) true/false
	 */
	public boolean RCMenuNavigation(String strNavigationXMLTag) {
		try {
			//Get the menu links from XML File using XML Tag
			String[] arrNavigation = getRCMenuLinksFromXMLTag(strNavigationXMLTag);

			try {
				//Switching frame
				driver.switchTo().defaultContent();
				driver.switchTo().frame(strParentFrame_NAME);
				driver.switchTo().frame(
						driver.findElement(By.xpath(strSubFrame_XPATH)));
			} catch (Exception e) {
				LPLCoreReporter.WriteReport("Frame Switching",
						"Frame Switching should be successful",
						"Frame Switching Failed. Error: "
								+ e.getMessage(), LPLCoreConstents.FAILED,"");
			}

			// Click on the main link first
			List<WebElement> objMainLinkInRc = driver.findElements(By
					.xpath(strMainMenuLink_XPATH));
			for (WebElement thisLink : objMainLinkInRc) {
				if (thisLink.getText().trim()
						.equalsIgnoreCase(arrNavigation[0])) {
					thisLink.click();
					
					//Wait for the Sub menu to load
					waitForPageLoading(lplCoreConstents.LOW);
					break;
				}
			}

			// Click on the sub link
			boolean blnSubLinkFound = true;
			List<WebElement> subListItems = null;
			linksFor: for (int i = 1; i < arrNavigation.length; i++) {
				// First searching in the blue header links
				try {
					subListItems = driver.findElements(By
							.xpath(strSubmenuLinkType1_XPATH));
					subLinkFor: for (WebElement thisListItem : subListItems) {
						//Searching for Links inside the Li tag
						List<WebElement> thisSubLinks = thisListItem.findElements(By
								.tagName("a"));
						for (WebElement thisSubLink: thisSubLinks) {
							//If any Blue Link matches with text, click on it
							if (thisSubLink.getText().trim()
									.equalsIgnoreCase(arrNavigation[i])) {
								thisSubLink.click();
								blnSubLinkFound = true;
								break subLinkFor;
							} else {
								blnSubLinkFound = false;
							}
						}
						
						// If the sub link is not found in blue header links, then
						// searching in white sub links
						if (!blnSubLinkFound) {
							try {
								List<WebElement> whileSubListItems = thisListItem.findElements(By
										.xpath(strSubmenuLinkType2_XPATH));
								for (WebElement thisWhiteColourLinkItem : whileSubListItems) {
									//Searching for Links inside the Li tag
									List<WebElement> whiteSubLinks = thisWhiteColourLinkItem.findElements(By
											.tagName("a"));
									for (WebElement thisWhiteSubLink : whiteSubLinks) {
										if (thisWhiteSubLink.getText().trim()
												.equalsIgnoreCase(arrNavigation[i])) {
											thisWhiteSubLink.click();
											blnSubLinkFound = true;
											break linksFor;
										} else {
											blnSubLinkFound = false;
										}
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
								strError = strError + " Error in RC Menu navigation : " + e.getMessage();
							}
						} else {
							break linksFor;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			//Wait for the Page to load
			waitForPageLoading(lplCoreConstents.FAIR);
			
			return blnSubLinkFound;
		} catch (Exception e) {
			strError = strError + " Error in RC Menu navigation : " + e.getMessage();
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * verifyRCMenuNavigation: Method to verify if the navigation is successful in Resource center Menu
	 * @author Aiswarya Srinivasan
	 * @since 12-08-2016
	 * @param strNavigationXMLTag
	 *            - The Tag in the Navigation XML file which represents the
	 *            Navigation path inside RC Application
	 * @return (boolean) true/false
	 */
	public boolean verifyRCMenuNavigation(String strNavigationXMLTag) {
		boolean blnVerifyNavFlag = false;
		try {
			//Get the menu links from XML File using XML Tag
			String[] arrNavigation = getRCMenuLinksFromXMLTag(strNavigationXMLTag);

			try {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(strParentFrame_NAME);
				driver.switchTo().frame(
						driver.findElement(By.xpath(strSubFrame_XPATH)));
			} catch (Exception e) {
				LPLCoreReporter.WriteReport("Frame Switching",
						"Frame Switching should be successful",
						"Frame Switching Failed. Error: "
								+ e.getMessage(), LPLCoreConstents.FAILED,"");
				e.printStackTrace();
			}
			
			try {
				//Verify if the Header contains the text which you clicked.
				WebElement objPageAggregationHeader = LPLCoreUtil.waitForWebElements(lplCoreConstents.MEDIUM,By.xpath(strPageAggregationHeader_xpath),By.id(strPageAggregationHeader_id),By.xpath(strh1Header_xpath),By.tagName(strh1Header_tagName));
				if(objPageAggregationHeader.getText().trim().contains(arrNavigation[1].trim())){
					blnVerifyNavFlag = true;
				}else{
					if(driver.getTitle().trim().contains(arrNavigation[1].trim())){
						blnVerifyNavFlag = true;
					}
				}
			} catch (Exception e) {
				try {
					if(driver.getTitle().trim().contains(arrNavigation[1].trim())){
						blnVerifyNavFlag = true;
					}
				} catch (Exception e1) {
					this.strError = this.strError + arrNavigation[1] + " Page not loaded Properly .Error: " + e1.getMessage();
					e1.printStackTrace();
					blnVerifyNavFlag= false;
				}
			}
			return blnVerifyNavFlag;
		}catch (Exception e2) {
			return blnVerifyNavFlag;
		}
	}
	
	/**
	 * Method to get the Menu link names from the RCMENUNAVIGATION_XML_PATH file
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 02-09-2017
	 * @param strNavigationXMLTag
	 *            - The Tag in the Navigation XML file which represents the
	 *            Navigation path inside RC Application
	 * @return (boolean) true/false
	 */
	public String[] getRCMenuLinksFromXMLTag(String strNavigationXMLTag) {
		try {
			// Loading the file from the given path
			FileInputStream xmlFile = new FileInputStream(
					lplCoreConstents.RCMENUNAVIGATION_XML_PATH);

			// Parsing the XML file into a document
			Document document = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().parse(xmlFile);

			Node myNode = document.getElementsByTagName(strNavigationXMLTag)
					.item(0);
			String strnavigationString = myNode.getTextContent();
			String[] arrNavigation = strnavigationString.split("~");
			
			return arrNavigation;
		}catch(Exception e){
			strError = strError + " Error in Reading RC Menu navigation XML file in " + lplCoreConstents.RCMENUNAVIGATION_XML_PATH ;
			return null;
		}
	}
}
package PageObjectLibrary;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreReporter;


/**
 * <p>
 * <br><b> Title: </b> PortfolioReviewTool_PRT.java</br>
 * <br><b> Description: </B> Page Object Library For PRT page</br>
 * <br> Usage:This file is put in here for usage by different projects (Universal S&G and TSHD)</br>
 * @author Aiswarya Srinivasan
 * @since 09-01-2016 
 * </p>
 */
public class PortfolioReviewTool_PRT extends BNCommon{
	
	/** Web Driver Reference */
	public WebDriver driver;
	
	/** String type... To be used to capture any error occurred at runtime. */
	public String strError;
		 
	/** ------------------------------------------------Page Objects------------------------------------------------ */
	public String strParentFrame_name							= "shell";
	
	public String strIframe_id									= "panel_PRT";
	
	public String strHeaderMenus_id								= "hdrPageHeader_MainMenu";
	
	public String strHomeTab_XPATH								= "//a[@title='Home']"; 
	
	public String strNewPortfolioTab_XPATH						= "//a[@title='New Portfolio']"; 
	
	public String strPortfolioReviewManagerTab_XPATH			= "//a[@title='Portfolio Review Manager']";
	
	public String strCustomModelsManagerTab_XPATH				= "//a[@title='Custom Models Manager']";
	
	public String strViewPortfolioByStatus_id					= "PRTStatus";
	
	public String strSearchRecentReportsPanel_id				= "fsSearch";
	
	public String strSearchButton_id							= "ucSearch_fsSearch_btnSearch";
	/** ------------------------------------------------End of Page Objects------------------------------------------------ */
	
	/** lpl core constants instance */
	public LPLCoreConstents lplCoreConstents;
	
	/** Current Page ID from FARM */
	public final int INT_PAGEID = 171;
	
	public PortfolioReviewTool_PRT(WebDriver driver){
		super(driver);
		this.driver = driver;
		lplCoreConstents = LPLCoreConstents.getInstance();
		
		try {
			/** Fetching the PageObjects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect
					.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
			
			if (PageObjectsMap.get("strParentFrame").get("ID") != null)
				strParentFrame_name = PageObjectsMap.get("strParentFrame").get(
						"ID");
			
			if (PageObjectsMap.get("strIframe").get("ID") != null)
				strIframe_id = PageObjectsMap.get("strIframe").get(
						"ID");
			
			if (PageObjectsMap.get("strHeaderMenus").get("ID") != null)
				strHeaderMenus_id = PageObjectsMap.get("strHeaderMenus").get(
						"ID");

			if (PageObjectsMap.get("strHomeTab").get("XPATH") != null)
				strHomeTab_XPATH = PageObjectsMap.get("strHomeTab").get("XPATH");

			if (PageObjectsMap.get("strNewPortfolioTab").get("XPATH") != null)
				strNewPortfolioTab_XPATH = PageObjectsMap.get(
						"strNewPortfolioTab").get("XPATH");
			
			if (PageObjectsMap.get("strPortfolioReviewManagerTab").get("XPATH") != null)
				strPortfolioReviewManagerTab_XPATH = PageObjectsMap.get(
						"strPortfolioReviewManagerTab").get("XPATH");
			
			if (PageObjectsMap.get("strCustomModelsManagerTab").get("XPATH") != null)
				strCustomModelsManagerTab_XPATH = PageObjectsMap.get(
						"strCustomModelsManagerTab").get("XPATH");
			
			if (PageObjectsMap.get("strViewPortfolioByStatus").get("ID") != null)
				strViewPortfolioByStatus_id = PageObjectsMap.get(
						"strViewPortfolioByStatus").get("ID");
			
			if (PageObjectsMap.get("strSearchRecentReportsPanel").get("ID") != null)
				strSearchRecentReportsPanel_id = PageObjectsMap.get(
						"strSearchRecentReportsPanel").get("ID");
			
			if (PageObjectsMap.get("strSearchButton").get("ID") != null)
				strSearchButton_id = PageObjectsMap.get(
						"strSearchButton").get("ID");
			
		}catch(Exception ex){
			LPLCoreReporter.WriteReport("Initialization of PortfolioReviewTool_PRT Class", "Object should be successfully created of PortfolioReviewTool_PRT class", "Failed to fetch the objects of PortfolioReviewTool_PRT from Farm. Error:"+ex.toString(), LPLCoreConstents.FAILED, "");
		}
	}
	
	public String[][] allObjects = {
			{strHeaderMenus_id,"Header menus Table","id"},
			{strHomeTab_XPATH,"Home tab link","XPATH"},
			{strNewPortfolioTab_XPATH,"New Portfolio Tab link","XPATH"},
			{strPortfolioReviewManagerTab_XPATH,"Portfolio Review manager Tab link","XPATH"},
			{strCustomModelsManagerTab_XPATH,"Custom Models manager Tab link","XPATH"},
			{strViewPortfolioByStatus_id,"View Portfolio By status Panel","id"},
			{strSearchRecentReportsPanel_id,"Search Panel","id"},
			{strSearchButton_id,"Search Button","id"}};
	
}

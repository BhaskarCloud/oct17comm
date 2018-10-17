package PageObjectLibrary;


import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;

/**
 * <p>
 * <br>
 * <b> Title: </b> ASATPage.java</br> <br>
 * <b> Description: </B> Page Object Library For ASAT Page</br> <br>
 * <b>Usage:</br></b> <br>
 * 1. ASATLogin: Method to Login to ASAT application</br>
 * 
 * @author Ravneet Kaur
 * @since 06-12-2017
 *        </p>
 */
public class ASATPage extends LPLCoreDriver {

	public WebDriver driver;
	public HomePage homePage;
	public LPLCoreConstents lplCoreConstents;
	public int INT_PAGEID = 432;

	// -------------------------------------------------Page Objects--------------------------------------------------------//
	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;

	/** ASAT Login Button xpath */
	public String strLoginButton_xpath = ".//input[@id='btnLogin']";

	/** ASAT Login name text box in the search panel */
	public String strLoginNameEdit_xpath = ".//span[contains(text(),'Find By Login Name:')]/../..//input[@id='tabContainerASATCRM_tabASATSearch_ucSearch_tbSALoginName']";

	/** ASAT Click on search Button*/
	public String strSearchButton_xpath= "//input[@id='tabContainerASATCRM_tabASATSearch_ucSearch_btnSearch']";
	
	/** ASAT Click on Link from  Search Results */
	public String strFullNameLink_xpath = "//a[@id='tabContainerASATCRM_tabASATSearch_ucSearch_rptSearchResults_ctl01_lnkUserFullName']/../..//a[contains(text(),'xxx')]";
	
	/** ASAT Click on Branchnet tab */
	public String strBranchnetTab_xpath = ".//span[@id='__tab_tabContainerASAT_tabBranchnet']/../..//span[contains(text(),'BranchNet')]";
	
	/** ASAT Clients Menu table Xpath  */
    public String strClientsMenuTable_xpath = "//table[@id='tabContainerASAT_tabBranchnet_datlstAppCategory_ctl03_tblApplication']";
	
	/** ASAT Branchnet Save Button   */
	public String strSave_id = "btnAllSave";
	
	
	// -------------------------------------------------End of Page Objects--------------------------------------------------------//

	public ASATPage(WebDriver driver) {

		lplCoreConstents = LPLCoreConstents.getInstance();

		this.driver = driver;

		HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

		lplCoreConstents = LPLCoreConstents.getInstance();
		if(PageObjectsMap.get("strLoginButton").get("XPATH")!=null)
			strLoginButton_xpath = PageObjectsMap.get("strLoginButton").get("XPATH");
		
		if(PageObjectsMap.get("strLoginNameEdit").get("XPATH")!=null)
			strLoginNameEdit_xpath = PageObjectsMap.get("strLoginNameEdit").get("XPATH");
		
		if(PageObjectsMap.get("strSearchButton").get("XPATH")!=null)
			strSearchButton_xpath = PageObjectsMap.get("strSearchButton").get("XPATH");
		
		if(PageObjectsMap.get("strFullNameLink").get("XPATH")!=null)
			strFullNameLink_xpath = PageObjectsMap.get("strFullNameLink").get("XPATH");
		
		if(PageObjectsMap.get("strBranchnetTab").get("XPATH")!=null)
			strBranchnetTab_xpath = PageObjectsMap.get("strBranchnetTab").get("XPATH");
	
		if(PageObjectsMap.get("strClientsMenuTable").get("XPATH")!=null)
			strClientsMenuTable_xpath = PageObjectsMap.get("strClientsMenuTable").get("XPATH");
		
		if(PageObjectsMap.get("strSave").get("ID")!=null)
			strSave_id = PageObjectsMap.get("strSave").get("ID");
}

	/**
	 * Method to Login to ASAT
	 * 
	 * @author Ravneet Kaur
	 * @since 06-12-2017
	 * @param None
	 * @return (boolean) True/False
	 */
	public boolean ASATFlagVerification(String strLoginNameToSearch ,String strUserFullName){
		boolean blnResult = false;
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			// Clicking on ASAT Login button
			LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.xpath(strLoginButton_xpath)).click();

			
			WebElement objLoginNameEdit = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.xpath(strLoginNameEdit_xpath));
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", objLoginNameEdit);
			LPLCoreSync.staticWait(lplCoreConstents.FAIR);
			objLoginNameEdit.sendKeys(Keys.SHIFT+""+Keys.HOME);
			objLoginNameEdit.sendKeys(Keys.DELETE);
			objLoginNameEdit.sendKeys(strLoginNameToSearch); 

			
			/*WebElement objLoginNameEdit = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.xpath(strLoginNameEdit_xpath));
	        
			js.executeScript("arguments[0].click();", objLoginNameEdit);
			LPLCoreSync.staticWait(lplCoreConstents.FAIR);
			objLoginNameEdit.sendKeys(strLoginNameToSearch);*/
			
			/*Robot r = (Robot) driver;
			r.keyPress(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_HOME);
			r.keyRelease(KeyEvent.VK_HOME);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_DELETE);
			r.keyRelease(KeyEvent.VK_DELETE);*/
		

		
			//Clicking on Search Button
			WebElement objSearchElement= LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.xpath(strSearchButton_xpath));	
			objSearchElement.click();
			
			//Clicking on Full Name  Link from  Search Results
			WebElement objFullNameLink = LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.xpath(strFullNameLink_xpath.replace("xxx", strUserFullName)));
			objFullNameLink.click();
			
			
			//Clicking on Branchnet Button
			WebElement objBranchnetTab= LPLCoreUtil.waitForWebElement(lplCoreConstents.FAIR,By.xpath(strBranchnetTab_xpath));	
			objBranchnetTab.click();
			
			// Creating Java script executor object to perform Scroll into view
            // operation
            WebElement objClientsMenuTable = LPLCoreUtil.waitForWebElement(lplCoreConstents.FAIR,By.xpath(strClientsMenuTable_xpath));
            List<WebElement> objAllTDs = objClientsMenuTable.findElements(By.xpath(".//td"));
            for (WebElement thisTd : objAllTDs) {
                  if(thisTd.getText().contains("Goal Based Planning")){
                         WebElement checkBox = thisTd.findElement(By.tagName("input"));
                         if(checkBox.isSelected()){
                                blnResult = true;
                                break;
                         }else{
                                blnResult = false;
                                break;
                         }
                  }
            }

		} catch (Exception e) {
			strError = strError + e.getMessage();
			blnResult = false;
			e.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * Method to Login to ASAT
	 * 
	 * @author Ravneet Kaur
	 * @since 06-12-2017
	 * @param None
	 * @return (boolean) True/False
	 */
	public boolean ASATFlagOFFGoalBasedPlanning() throws InterruptedException {
		boolean blnResult = false;
		try {
			
			//// Creating Java script executor object to perform Scroll into view
            // operation
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement objClientsMenuTable = LPLCoreUtil.waitForWebElement(lplCoreConstents.FAIR,By.xpath(strClientsMenuTable_xpath));
            List<WebElement> objAllTDs = objClientsMenuTable.findElements(By.xpath(".//td"));
            for (WebElement thisTd : objAllTDs) {
                  if(thisTd.getText().contains("Goal Based Planning")){
                         WebElement checkBox = thisTd.findElement(By.tagName("input"));
                         if(checkBox.isSelected()){
                        	 js.executeScript("arguments[0].scrollIntoView(true);", checkBox);
                             checkBox.click();
                             
                           //Clicking on Branchnet Button
             				WebElement objstrSave= LPLCoreUtil.waitForWebElement(lplCoreConstents.BASE,By.id(strSave_id));	
             				objstrSave.click();
             				LPLCoreSync.staticWait(lplCoreConstents.FAIR);
                                blnResult = true;
                                break;
                         }else{
                                blnResult = true;
                                break;
                         }
                  }
            }
			
		} catch (Exception ex) {
			strError = strError + ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}
	
}
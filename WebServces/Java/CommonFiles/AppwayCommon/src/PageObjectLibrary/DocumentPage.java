package PageObjectLibrary;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngular;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreReporter;


/**
 * <p>
 * <br><b> Title: </b>DocumentPage.java</br>
 * <br><b> Description: </B> Field functions for Document Page. </br>
 * <br><b>Usage:</br></b>
 * <br>clickSubmitBtn: This function is used to click on Submit Button, accept dialog box and capture Account Number.</br>
 * <br>getText: This function is used to capture the text(RequestID , Account Number).</br>
 * @author Jyothi Jyothi,Megha Megha
 * @since 10-07-2016 
 * </p>
 */
public class DocumentPage extends LPLCoreDriver{

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;

	public LPLCoreConstents lplCoreConstents;

	/** Xpath property value of NotValidGovtID Text Box Object */
	public String strAccountNumber_XPATH;

	/** Xpath property value 0f strRequestIDTxt object */
	public String strRequestIDTxt_XPATH;

	public StartAccountOpeningPage startaccount;
	public NAOCommon common;
	public FinancialPage FinPage;
	public  HomePage homePage ;
	public JavascriptExecutor jse;


	public int INT_PAGEID=116;
	public DocumentPage(WebDriver driver){

		try {
			this.driver = driver;
			common = new NAOCommon(driver);
			startaccount = new StartAccountOpeningPage(driver);
			jse = (JavascriptExecutor)driver;
			FinPage = new FinancialPage(driver);
			lplCoreConstents = LPLCoreConstents.getInstance();
			homePage = new HomePage(driver);


			/** Fetching the page objects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

			if(PageObjectsMap.get("strAccountNumber").get("XPATH")!=null)
				strAccountNumber_XPATH = PageObjectsMap.get("strAccountNumber").get("XPATH");

			if(PageObjectsMap.get("strRequestIDTxt").get("XPATH")!=null)
				strRequestIDTxt_XPATH = PageObjectsMap.get("strRequestIDTxt").get("XPATH");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to click on Submit Button , accept dialog box and capture Account Number
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 * @modifiedBy Anshu Suman
	 **/
	public boolean  clickSubmitBtn(String strSubmitFlag){
		boolean blnResult=false;
		if (strSubmitFlag.equalsIgnoreCase("Y")){
			try{
				common.ClickOnBtn(testData.get("strSubmitBtnTxt"));
				common.acceptDialog();
				String  getAccountNumber = getText(By.xpath(strAccountNumber_XPATH));
				//Capture Account Number if account is submitted
				if (!getAccountNumber.isEmpty()) 
					LPLCoreReporter.WriteReport("Step : Should get account number ", "User should be able to  get account number. Account Number is : " + getAccountNumber  , "account number generated    Sucessfullly", "Passed",""); 
				else
					LPLCoreReporter.WriteReport("Step : Should  get account number", "User should able to  get account number", "Failed to get account number . Error message:"+NAOCommon.strError, "Failed",LPLCoreReporter.captureScreenShot(driver, "Step _"+dateFormat.format(date).toString())); 
				strError ="";
				blnResult=true;
			}
			catch (Exception ex) {
				strError = strError+ex.getMessage();
				ex.printStackTrace();
				blnResult=false;
			}
		}
		else{
			//Validate that the submit button is enabled
			if(driver.findElement(ByAngular.buttonText(testData.get("strSubmitBtnTxt"))).isEnabled())
				blnResult=true;
		}
		return blnResult;
	}

	/**
	 * This function is used to capture the text(RequestID , Account Number).
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 06/26/2017
	 * @param By
	 * @return String
	 **/
	public String getText(By strLocator){
		String strGetValue = null;
		try{
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated(strLocator));
			WebElement strTextValue = driver.findElement(strLocator);
			strGetValue = strTextValue.getText();							
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return strGetValue;
	}

}
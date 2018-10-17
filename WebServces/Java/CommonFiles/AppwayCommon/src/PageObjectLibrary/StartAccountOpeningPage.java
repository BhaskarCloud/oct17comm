package PageObjectLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> StartAccountOpeningPage.java</br>
 * <br><b> Description: </B> Field functions for Start Account Opening Page. </br>
 * <br><b>Usage:</br></b>
 * <br>setRepIDLstOrTxt: This function is used to Click on Rep ID DropDown field.</br>
 * <br>selectClientTypeLst: This function is used to Click on Client Type DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectAccountTypeLst: This function is used to Click on Account Type DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectProgramTypeLst: This function is used to Click on Program Type DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectRegistrationTypeLst: This function is used to Click on Registration Type DropDown Field and to select Element from the Drop Down.</br>
 * <br>setFirstNameTxt: This function is used to set value to the First Name text Field.</br>
 * <br>setMiddleNameTxt: This function is used to set Value to the Middle Name text Field.</br>
 * <br>setLastNameTxt: This function is used to set Value to the Last Name text Field.</br>
 * <br>selectTODRdoGrp: This function is used to select Value from Radio group.</br>
 * <br>setDecedentNameTxt: This function is used to set Value to the Decedent Name text Field.</br>
 * <br>selectMinorCustodialStateLst: This function is used to Click on Minor Custodial State DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectInstitutioBranchLst: This function is used to Click on Institution Branch DropDown Field and to select Element from the Drop Down.</br>
 * <br>setSecRepIDTxtOrLst: This function is used to set Value to Secondary Rep ID Text Box or Dropdown.</br>
 * <br>setRefferalIDTxt: This function is used to set Value to the Referrel ID text Field.</br>
 * <br>selectIRABeneRdoGrp: This function is used to select Value from IRA Beneficiary Is Radio group.</br>
 * <br>verifyCreateNewClient: This function is used to Verify Create New Client.</br>
 * <br>selectBestInterestRationaleRdoGrp: This function is used to  select Radio button from  Best Interest Rationale .</br>
 * <br>selectRepIdAccountSetupStartAccPage: To perform actions on Repid and account setup fields in start account opening page .</br>
 * <br>selectRegDetailsClientBestInterestStartAccPage: To perform actions on registration details and Client best interest fields in start account opening  page .</br>
 * <br>selectUTMAorUGMAInfoStartAccPage: To perform actions on UTMA/UGMA information in start account opening  page .</br>
 * <br>selectInstitutionBranchStartAccPage:To perform actions on Institution branch fields in start account opening  page .</br>
 * <br>selectClientNameStartAccPage: o perform actions on Client name fields in start account opening  page.</br>
 * <br>generateRandomNumber: This function is used to generate random numbers.</br>
 * <br>generateRandomEmail: This function is used to generate random Email Id.</br>
 * <br>clickOnContinueCertificationError: This function is used to select certification error.</br>
 * <br>ClickOnStartAOPage: This function is used to click on start Account Opening Page of Back Office.</br>
 * <br>verifyProgramTypeOption:This function is used to verify the program type drop down option for all the repid .</br>
 * <br>getAllOptions: This function is used to get all values from a Drop Down. </br>
 * <br>compareList: This function is used to compare 2 lists. </br>
 * <br>performContextMenu: This function is used to perform Context Menu Operation. </br>
 * @author Jyothi Jyothi
 * @since 10-05-2016
 * </p>
 */
public class StartAccountOpeningPage extends LPLCoreDriver {

	public WebDriver driver;
	public String strError;
	
	public static Logger log = Logger.getLogger(StartAccountOpeningPage.class); 

	/** Xpath property value of Dropdown Box Object with 2 parameters*/
	public	String strToclickCommAcc_XPATH;

	/** Xpath property value of Dropdown Box Object */
	public	String strToclickComm_XPATH;

	/** Xpath property value of Text Box Object */
	public String strTxtBox_XPATH;

	/** Xpath property value of Radio Button Object */
	public String objClientsBestInterest_XPATH;

	/** Xpath property value of Radio Button Object */
	public String strClientBestInterestCommon_XPATH;

	/**Xpath Property value for Start Account Opening page for Back Office **/
	public String strSAOPage_XPATH="";
	
	/** Program Type Drop Down Text */
	public static final String STRPROGRAMTYPEDROPDOWN="Program Type";

	/** Accont Type Drop Down element Text */
	public static  final String STRACCOUNTTYPEELEMENT="Individual";

	/** Program Type Drop Down element Text */
	public static final String STRBROKERAGEMF="Brokerage - MF";
	
	/**Xpath property of Client Name */
	public String strClientName_XPATH;

	/**Xpath property of Hamburger Menu */
	public String strHamburger_XPATH;

	/**Xpath Property of Main menu of Hamburger */
	public String strMainMenu_CSS;

	/**Xpath Property of Sub Menu of Hamburger */
	public String strSubMenu_CSS;
	
	/** Result */
	public String strResult=null;
	
	/** Program Type drop down Xapth */
	public String strProgramTypeDropXPATH;

	public NAOCommon common;
	public HomePage homePage;

	public LPLCoreConstents lplCoreConstents;
	public JavascriptExecutor jse;
	public int INT_PAGEID=116;
	public StartAccountOpeningPage(WebDriver driver){

		try {
			this.driver = driver;
			homePage = new HomePage(driver);
			common = new NAOCommon(driver);
			jse = (JavascriptExecutor)driver;
			lplCoreConstents = LPLCoreConstents.getInstance();
			this.driver = driver;

			/** Fetching the page objects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

			if(PageObjectsMap.get("strToclickComm").get("XPATH")!=null)
				strToclickComm_XPATH = PageObjectsMap.get("strToclickComm").get("XPATH");

			if(PageObjectsMap.get("strTxtBox").get("XPATH")!=null)
				strTxtBox_XPATH = PageObjectsMap.get("strTxtBox").get("XPATH");

			if(PageObjectsMap.get("objClientsBestInterest").get("XPATH")!=null)
				objClientsBestInterest_XPATH = PageObjectsMap.get("objClientsBestInterest").get("XPATH");

			if(PageObjectsMap.get("strClientBestInterestCommon").get("XPATH")!=null)
				strClientBestInterestCommon_XPATH = PageObjectsMap.get("strClientBestInterestCommon").get("XPATH");

			if(PageObjectsMap.get("strToclickCommAcc").get("XPATH")!=null)
				strToclickCommAcc_XPATH = PageObjectsMap.get("strToclickCommAcc").get("XPATH");

			if(PageObjectsMap.get("strSAOPage").get("XPATH")!=null)
				strSAOPage_XPATH = PageObjectsMap.get("strSAOPage").get("XPATH");
			
			if(PageObjectsMap.get("strClientName").get("XPATH")!=null)
				strClientName_XPATH = PageObjectsMap.get("strClientName").get("XPATH");

			if(PageObjectsMap.get("strHamburger").get("XPATH")!=null)
				strHamburger_XPATH = PageObjectsMap.get("strHamburger").get("XPATH");

			if(PageObjectsMap.get("strMainMenu").get("CSS")!=null)
				strMainMenu_CSS = PageObjectsMap.get("strMainMenu").get("CSS");

			if(PageObjectsMap.get("strSubMenu").get("CSS")!=null)
				strSubMenu_CSS = PageObjectsMap.get("strSubMenu").get("CSS");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/****************************************************RepID Section****************************************************************/

	/**
	 * This function is used to click on Rep ID DropDown field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String, String
	 * @return boolean
	 **/

	public boolean  setRepIDLstOrTxt(String strRepIDEle,String strLoginType ){
		boolean blnResult = false;
		try{
			if(strLoginType.equalsIgnoreCase("A")){
				//Wait for the page to load
				LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
				String strRepIDDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strRepIDDrop"));
				new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strRepIDDrop_XPATH))));
				//Wait for the page to load
				LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
				blnResult =common.selectDropDownBox(strRepIDDrop_XPATH,strRepIDEle,"");
				common.waitforProcessing();
				homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			}

			else{
				//Wait for the page to load
				LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
				String strRepIDDrop_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strRepIDSection")).replace("yyy",testData.get("strRepIDDrop"));
				new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strRepIDDrop_XPATH))));
				blnResult =common.setValue(strRepIDDrop_XPATH,strRepIDEle );
				driver.findElement(ByAngular.buttonText("Submit")).click();
				//Wait for the page to load
				LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);		
			}
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/****************************************************Account Set Up Section**********************************************************/

	/**
	 * This function is used to click on Client Type DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectClientTypeLst(String strClientTypeEle ){
		boolean blnResult = false;
		try{
			String strClientTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strClientTypeDrop"));
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strClientTypeDrop_XPATH))));
			blnResult =common.selectDropDownBox(strClientTypeDrop_XPATH, strClientTypeEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Account Type DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAccountTypeLst(String strAccountTypeEle ){
		boolean blnResult = false;
		try{
			String strAccountTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strAccountTypeDrop"));
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAccountTypeDrop_XPATH))));
			blnResult =common.selectDropDownBox(strAccountTypeDrop_XPATH, strAccountTypeEle,"");	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Program Type DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectProgramTypeLst(String strProgramTypeEle ){
		boolean blnResult = false;
		try{
			String strProgramTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strProgramTypeDrop"));
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strProgramTypeDrop_XPATH))));
			blnResult =common.selectDropDownBox(strProgramTypeDrop_XPATH, strProgramTypeEle,"");
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strProgramTypeDrop_XPATH))));
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Registration Type DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectRegistrationTypeLst(String strRegistrationTypeEle ){
		boolean blnResult = false;
		try{
			String strRegistrationTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strRegistrationTypeDrop"));
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strRegistrationTypeDrop_XPATH))));
			blnResult =common.selectDropDownBox(strRegistrationTypeDrop_XPATH, strRegistrationTypeEle,"");	
			common.waitforProcessing();
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/********************************************************Client Name Section*******************************************************/

	/**
	 * This function is used to set value to the First Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param 
	 * @return boolean
	 **/
	public boolean  setFirstNameTxt( ){
		boolean blnResult = false;
		try{
			if(ocfg.getFirmId() == 1){
				//Wait for the page to load
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				String strFirstName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strFirstName"));
				String strFNValue=common.generateRandomAlphabets();
				blnResult =common.setValue(strFirstName_XPATH, strFNValue);	
			}
			else{
				//Wait for the page to load
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				String strFirstName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strFirstName"));
				blnResult =common.setValue(strFirstName_XPATH, testData.get("strFNValue"));
			}
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Middle Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param 
	 * @return boolean
	 **/
	public boolean  setMiddleNameTxt(){
		boolean blnResult = false;
		try{
			if(ocfg.getFirmId() == 1){
				String strMiddleName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strMiddleName"));
				String strMNValue=common.generateRandomAlphabets();
				blnResult =common.setValue(strMiddleName_XPATH, strMNValue);	
			}
			else{
				String strMiddleName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strMiddleName"));
				blnResult =common.setValue(strMiddleName_XPATH, testData.get("strMNValue"));
			}
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Last Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param 
	 * @return boolean
	 **/
	public boolean  setLastNameTxt(){
		boolean blnResult = false;
		try{
			if(ocfg.getFirmId() == 1){
				String strLastName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strLastName"));
				String strLNValue=common.generateRandomAlphabets();
				blnResult =common.setValue(strLastName_XPATH, strLNValue);	
			}
			else{
				String strLastName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strLastName"));
				blnResult =common.setValue(strLastName_XPATH, testData.get("strLNValue"));
			}
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Transfer On Death from Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectTODRdoGrp(String strTODValue ){
		boolean blnResult = false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			blnResult=common.selectRadiobutton(testData.get("strTODRdoGrp"), strTODValue);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;		
	}

	/**
	 * This function is used to set Value to the Decedent Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  setDecedentNameTxt(String strDecedentSection, String strDecedentNameValue){
		boolean blnResult = false;

		try{
			if(ocfg.getFirmId() == 1){
				//Wait for the page to load
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				strDecedentNameValue=common.generateRandomAlphabets();
				String strDecedentName_XPATH=strTxtBox_XPATH.replace("xxx",strDecedentSection).replace("yyy",testData.get("strDecedentNameTxt"));
				blnResult =common.setValue(strDecedentName_XPATH, strDecedentNameValue);	
			}
			else{
				//Wait for the page to load
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				String strDecedentName_XPATH=strTxtBox_XPATH.replace("xxx",strDecedentSection).replace("yyy",testData.get("strDecedentNameTxt"));
				blnResult =common.setValue(strDecedentName_XPATH, strDecedentNameValue);
			}
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Minor Custodial State DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectMinorCustodialStateLst(String strCustodialStateEle ){
		boolean blnResult = false;
		try{
			String strCustodialStateDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strCustodialState"));
			blnResult =common.selectDropDownBox(strCustodialStateDrop_XPATH, strCustodialStateEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/********************************************************Institution Information*******************************************************/

	/**
	 * This function is used to click on Institution Branch DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectInstitutioBranchLst(String strInstitutioBranchEle ){
		boolean blnResult = false;
		try{
			String strInstitutionBranchDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strInstitutionBranchDrop"));
			blnResult =common.selectDropDownBox(strInstitutionBranchDrop_XPATH, strInstitutioBranchEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to Secondary Rep ID Text Box or Dropdown
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  setSecRepIDTxtOrLst(String strLoginType,String strSecRepIDValue){
		boolean blnResult = false;
		try{
			if(strLoginType.equalsIgnoreCase("A")){
				String strSecRepIDDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strSecRepID"));
				blnResult =common.selectDropDownBox(strSecRepIDDrop_XPATH, strSecRepIDValue,"");	
				homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			}
			else{
				String strSecRepID_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strInstitutionInfoSection")).replace("yyy",testData.get("strSecRepID"));
				blnResult =common.setValue(strSecRepID_XPATH, strSecRepIDValue);	
			}
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Referrel ID text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setRefferalIDTxt(String strReferrelIDValue){
		boolean blnResult = false;
		try{
			String strReferrelID_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strInstitutionInfoSection")).replace("yyy",testData.get("strReferralIDTxt"));
			blnResult =common.setValue(strReferrelID_XPATH, strReferrelIDValue);				
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value from IRA Beneficiary Is Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectIRABeneRdoGrp(String strIRABeneValue ){
		boolean blnResult = false;
		try{
			blnResult=common.selectRadiobutton(testData.get("strIRABeneIs"), strIRABeneValue);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;		
	}

	/**
	 * This function is used to Verify Create New Client
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param 
	 * @return boolean
	 **/
	public boolean verifyCreateNewClient()
	{
		boolean blnResult=false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			driver.findElement(ByAngular.buttonText(testData.get("strCreateNewClntBtnTxt")));
			blnResult=true;
		}catch(Exception e){
			blnResult=false;
		}
		return blnResult;
	}

	/**
	 * This function is used to select Radio button from  Best Interest Rationale 
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectBestInterestRationaleRdoGrp(String strRdoGrp_XPATH){
		boolean blnResult=false;
		String strPrudentProcessFlag="Y";
		if (strPrudentProcessFlag.equalsIgnoreCase("Y")){
			try{
				if((ocfg.getBrowserType().toUpperCase().trim().equals("IEXPLORE")) || (ocfg.getBrowserType().toUpperCase().trim().equals("IE"))){
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strRdoGrp_XPATH), LPLCoreConstents.getInstance().MEDIUM);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					WebElement obj = driver.findElement(By.xpath(strRdoGrp_XPATH));
					js.executeScript("arguments[0].click();", obj);
					blnResult=true;
				}
				else{
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strRdoGrp_XPATH))));
					driver.findElement(By.xpath(strRdoGrp_XPATH));
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strRdoGrp_XPATH)));
					driver.findElement(By.xpath(strRdoGrp_XPATH)).click();
					blnResult=true;
				}
			}
			catch (Exception ex) {
				strError = strError+ex.getMessage();
				ex.printStackTrace();
				blnResult=false;
			}
		}
		else{
			blnResult=true;
		}
		return blnResult;
	}	

	/**
	 * This function is used to perform actions on Repid and account setup fields in start account opening page
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String[],String...
	 * @return String
	 **/
	public String  selectRepIdAccountSetupStartAccPage(String[] strStartPage,String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){

				case "REPID":
					blnResult=setRepIDLstOrTxt(strStartPage[0], strStartPage[1]);			
					break;

				case "CLIENTTYPE":
					String strClientTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strClientTypeDrop"));
					blnResult=common.selectDropDownBox(strClientTypeDrop_XPATH, strStartPage[2], "");
					break;

				case "RESIDENCYSTATUS":
					String strResidencyStatusDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strResidencyStatusDrop"));
					blnResult=common.selectDropDownBox(strResidencyStatusDrop_XPATH, strStartPage[3], "");
					break;

				case "ACCOUNTTYPE":
					String strAccountTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strAccountTypeDrop"));
					blnResult=common.selectDropDownBox(strAccountTypeDrop_XPATH, strStartPage[4], "");
					break;

				case "PROGRAMTYPE":
					String strProgramTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strProgramTypeDrop"));
					blnResult=common.selectDropDownBox(strProgramTypeDrop_XPATH, strStartPage[5], "");
					break;

				case "REGISTRATIONTYPE":
					String strRegistrationTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strRegistrationTypeDrop"));
					blnResult=common.selectDropDownBox(strRegistrationTypeDrop_XPATH, strStartPage[6], "");
					break;

				case "MINORCUSTODIALSTATE":
					String strCustodialStateDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strCustodialState"));
					blnResult=common.selectDropDownBox(strCustodialStateDrop_XPATH, strStartPage[7], "");
					break;

				case "IRABENEFICIARY":
					String strInstitutionBranchDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strInstitutionBranchDrop"));
					blnResult =common.selectDropDownBox(strInstitutionBranchDrop_XPATH,strStartPage[8], "");
					break;
				}
				if(blnResult){
					strResult= strResult + " Next Result:" + strPanel+" "+blnResult +",";
				}else{
					strError = strError + " Error in processing case: " + strPanel;
					return strResult=null;
				}
			}
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			blnResult=false;
			strResult=null;
		}
		return strResult;
	}

	/**
	 * This function is used to perform actions on registration details and Client best interest fields in Start Account Opening  page
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String[],String...
	 * @return String
	 **/
	public String  selectRegDetailsClientBestInterestStartAccPage(String[] strStartPage,String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){

				case "PLANDIRECTED":
					String strPlanDirectedDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strPlnDirected"));
					blnResult=common.selectDropDownBox(strPlanDirectedDrop_XPATH, strStartPage[0], "");
					break;

				case "PLANTYPE":
					String strPlanTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strPlnType"));
					blnResult=common.selectDropDownBox(strPlanTypeDrop_XPATH, strStartPage[1], "");
					break;

				case "SUBTOERISA":
					blnResult=common.selectRadiobutton(testData.get("strPlnSubERSIA"), strStartPage[2]);
					break;

				case "CLIENTSBESTINTEREST":
					String strClientBestInterest_XPATH=strClientBestInterestCommon_XPATH.replace("xxx", strStartPage[3]);
					blnResult=selectBestInterestRationaleRdoGrp(strClientBestInterest_XPATH);
					break;

				case "SPONSOR":
					String strSpnsr_XPATH = strToclickCommAcc_XPATH.replace("xxx",testData.get("strSpnsrInfo")).replace("yyy",testData.get("strSpnsor"));
					blnResult = common.selectDropDownBox(strSpnsr_XPATH, testData.get("strSpnsrVal"), "");
					break;

				case "TAMP/TPIA":
					String strTampName_XPATH = strToclickCommAcc_XPATH.replace("xxx",testData.get("strTampHeader")).replace("yyy",testData.get("strTampName"));
					blnResult = common.selectDropDownBox(strTampName_XPATH, testData.get("strTampVal"), ""); 
					blnResult=common.selectRadiobutton(testData.get("strTampFirm"), testData.get("strTampFirmVal"));
					String strTampAccNum_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strTampHeader")).replace("yyy",testData.get("strTampAcctNum"));
					blnResult =common.setValue(strTampAccNum_XPATH, testData.get("strTampAcctNumVal"));
					break;
					
				case "529PLANTYPE":
					String strPlanType_XPATH = strToclickCommAcc_XPATH.replace("xxx",testData.get("strPlanInfo")).replace("yyy",testData.get("strPlanTypeDrp"));
					blnResult = common.selectDropDownBox(strPlanType_XPATH, testData.get("strPlanTypeVal"), "");
					break;
				}
				if(blnResult){
					strResult= strResult + " Next Result:" + strPanel+" "+blnResult +",";
				}else{
					strError = strError + " Error in processing case: " + strPanel;
					return strResult=null;
				}
			}
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			blnResult= false;
			strResult=null;
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on UTMA/UGMA information in Start Account Opening  page
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String[],String...
	 * @return String
	 **/
	public String  selectUTMAorUGMAInfoStartAccPage(String[] strStartPage,String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){		
				case "MINORCUSTODIALSTATE":
					String strCustodialStateDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strCustodialState"));
					blnResult =common.selectDropDownBox(strCustodialStateDrop_XPATH, strStartPage[0],"");	
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "TYPE":
					String strTypeDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strType"));
					blnResult =common.selectDropDownBox(strTypeDrop_XPATH, strStartPage[1],"");	
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;
				}
				if(blnResult){
					strResult= strResult + " Next Result:" + strPanel+" "+blnResult +",";
				}else{
					strError = strError + " Error in processing case: " + strPanel;
					return strResult=null;
				}
			}
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			strResult=null;
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on Institution branch fields in Start Account Opening  page
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectInstitutionBranchStartAccPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){		
				case "INSTITUTIONBRANCH":
					String strInstitutionBranchDrop_XPATH=strToclickComm_XPATH.replace("yyy", testData.get("strInstitutionBranchDrop"));
					blnResult =common.selectDropDownBox(strInstitutionBranchDrop_XPATH, testData.get("strInstitutioBranchEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "SECREPID":
					setSecRepIDTxtOrLst(testData.get("strLoginType"),testData.get("strSecRepIDValue"));
					break;

				case "REFERRALID":
					String strReferrelID_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strInstitutionInfoSection")).replace("yyy",testData.get("strReferralIDTxt"));	
					blnResult=common.setValue(strReferrelID_XPATH, testData.get(""));
					break;

				}
				if(blnResult){
					strResult= strResult + " Next Result:" + strPanel+" "+blnResult +",";
				}else{
					strError = strError + " Error in processing case: " + strPanel;
					return strResult=null;
				}
			}
		}catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			strResult=null;
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on Client name fields in Start Account Opening  page
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectClientNameStartAccPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "DECENDENTNAME":
					String strDecedentName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strDecedentNameTxt"));
					blnResult=common.setValue(strDecedentName_XPATH, common.generateRandomAlphabets());
					break;

				case "PLANNAME":
					String strPlanName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strPlanName"));
					blnResult=common.setValue(strPlanName_XPATH, common.generateRandomAlphabets());
					break;

				case "FIRSTNAME":
					String strFirstName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strFirstName"));
					blnResult=common.setValue(strFirstName_XPATH, common.generateRandomAlphabets());
					break;

				case "MIDDLENAME":
					String strMiddleName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strMiddleName"));
					blnResult=common.setValue(strMiddleName_XPATH, common.generateRandomAlphabets());
					break;

				case "LASTNAME":
					String strLastName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strLastName"));
					blnResult=common.setValue(strLastName_XPATH, common.generateRandomAlphabets());
					break;

				case "ENTITYNAME":
					String strEntityName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strEntityName"));
					blnResult=common.setValue(strEntityName_XPATH, common.generateRandomAlphabets());
					break;

				case "ENTITYNAMECONT":
					String strEntityNameCont_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strEntityNameCont"));
					blnResult=common.setValue(strEntityNameCont_XPATH, common.generateRandomAlphabets());
					break;

				case "NEXT":
					blnResult=common.ClickOnBtn(testData.get("strNextBtnTxt"));
					break;

				case "EXISTINGFIRSTNAME":
					String strExFirstName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strFirstName"));
					blnResult=common.setValue(strExFirstName_XPATH, testData.get("strFNVal"));
					break;

				case "EXISTINGLASTNAME":
					String strExLastName_XPATH=strTxtBox_XPATH.replace("xxx",testData.get("strCNSection")).replace("yyy",testData.get("strLastName"));
					blnResult=common.setValue(strExLastName_XPATH, testData.get("strLNVal"));
					break;

				}
				if(blnResult){
					strResult= strResult + " Next Result:" + strPanel+" "+blnResult +",";
				}else{
					strError = strError + " Error in processing case: " + strPanel;
					return strResult=null;	
				}
			}
		}catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return strResult=null;	
		}
		return strResult;
	}

	/**
	 * This function is used to generate random numbers
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 04-07-2017
	 * @param 
	 * @return String
	 */
	public String generateRandomNumber(){
		try{
			String strRandomNum =RandomStringUtils.randomNumeric(9);
			return strRandomNum;
		}
		catch (Exception ex) {
			strError = strError + ex.getMessage();
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * This function is used to generate random Email Id
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 04-07-2017
	 * @param String,String
	 * @return String
	 */
	public String generateRandomEmail(String strUserName,String strAddress ){
		//get random 2 digit num 
		String strNum= RandomStringUtils.randomNumeric(2);

		//Append strUserName,strNum and strAddress to email id
		String strEmailID = strUserName + strNum + strAddress;
		return strEmailID;
	}

	/**
	 * This function is used to select certification error
	 * @author Anshu Suman 
	 * @version 1.0
	 * @since 03-30-2017
	 * @param 
	 * @return boolean
	 */

	public boolean clickOnContinueCertificationError()
	{
		LPLConfig ocfg = new LPLConfig();
		boolean status=false;
		if(ocfg.getBrowserType().equalsIgnoreCase("IE") || ocfg.getBrowserType().equalsIgnoreCase("iexplore"))
		{
			homePage.switchTo("Window","Certificate Error");
			try{
				if(driver.findElements(By.id("overridelink")).size()>0)

					driver.findElement(By.id("overridelink"));
				status= true;
				if(status)
					driver.findElement(By.id("overridelink")).click();
			}catch(Exception e){
				e.printStackTrace();
			}
		}else 
			status=true;
		return status;
	}

	/**
	 * This function is used to click on start Account Opening Page of Back Office
	 * @author Anshu Suman 
	 * @version 1.0
	 * @since 06-27-2016
	 * @param 
	 * @return boolean
	 */
	public boolean  ClickOnStartAOPage(){
		boolean blnResult = false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strSAOPage_XPATH), LPLCoreConstents.getInstance().MEDIUM);
			WebElement SAOPAge = driver.findElement(By.xpath(strSAOPage_XPATH));
			SAOPAge.click();
			blnResult = true;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
		return blnResult;
	}
	
	/**
	 * This function is used to verify the program type drop down option for all the repid 
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 02-06-2018
	 * @param String(User type Emp or Advisor), List<String>(Repids),List<String[]>(Actual values),List<String[]> (Expected Values)
	 * @return String
	 */
	public String verifyProgramTypeOption(String strUserType, List<String> strRepIdList , List<String[]> strExpectedList){//,List<String[]> strUnexpectedList
		boolean blnResult = false;
		boolean blnRepIdDrop=false;
		boolean blnAccountType =false;
		int intExpectedListSize;
		try{
			//initialize the array list store the actual elements getting from Program Type drop down
			ArrayList<String> strAcutalValues = new ArrayList<>();

			//Get the sizee of Repid List
			int intListSize=strRepIdList.size();

			//get the locator for Program Type drop down
			strProgramTypeDropXPATH=strToclickComm_XPATH.replace("yyy", STRPROGRAMTYPEDROPDOWN);
			for(int i=0;i<intListSize;i++){					
				//select the repid from the drowdown 
				blnRepIdDrop= setRepIDLstOrTxt(strRepIdList.get(i), strUserType);

				//select individul from Account Type
				if(Arrays.asList(strExpectedList.get(i)).contains(STRBROKERAGEMF)){
					blnAccountType= selectAccountTypeLst(STRACCOUNTTYPEELEMENT);
				}
				else{
					blnAccountType=true;
				}
				//if repid is selected then click on Program Type drop down
				if(blnRepIdDrop && blnAccountType){
					driver.findElement(By.xpath(strProgramTypeDropXPATH)).click();
					blnResult=true;

					//if Program Type drop down is clicked 
					if(blnResult){
						String strProgramTypeEleXPATH=common.strForLstOfEle_XPATH;
						//list of webelements for Program type dropdown options
						List<WebElement> strProgramTypeEle=driver.findElements(By.xpath(strProgramTypeEleXPATH));
						LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);

						//get the text of Program Type option and add it list
						strAcutalValues.clear();
						for (WebElement actual : strProgramTypeEle) {
							String strActualText=actual.getText();
							strAcutalValues.add(strActualText);
						}

						//verify that all the values of expected list  are present actual list
						if(strAcutalValues.containsAll(Arrays.asList(strExpectedList.get(i)))){
							intExpectedListSize=Arrays.asList(strExpectedList.get(i)).size();
							blnResult=true;

							//verify that actual and expected list are equal
							if(strProgramTypeEle.size()==intExpectedListSize){
								//close the program type dropdown
								WebElement RepID = driver.findElement(By.xpath(common.strRepId_XPATH));
								LPLCoreUtil.mouseHoverAndClickJScript(RepID);
							}	
							else{
								log.info("Lists are not equal" + " " +strRepIdList.get(i));
								blnResult=false;
							}
						}
						else{
							log.info("Not contains all the elements for the repid" + " " +strRepIdList.get(i));
							blnResult=false;
						}

					}
					else{
						log.info("Program Type dropdown not clicked for the repid" + " " +strRepIdList.get(i));
						blnResult=false;
					}
				}
				else{
					log.info("Repid and account type not selected for the repid" + " " +strRepIdList.get(i));
					blnResult=false;

				}

				if(!blnResult){
					//store all the failed results
					strResult= strResult+ " "+strRepIdList.get(i) +" " + blnResult + "Next Results";

					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					//refresh the page
					driver.navigate().refresh();
					boolean blnResult1=false;
					boolean blnResult2=false;
					LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
					//click on create client and account
					blnResult1 =common.ClickOnBtn(testData.get("strCreateClntAccBtnTxt"));
					//switch to NAO Page
					blnResult2 = common.SwitchtoModalDialogue();
					if(blnResult1 && blnResult2){
						blnResult=true;
					}
					else{
						log.info("Not switched to NAo Page for the Repid" + " " +strRepIdList.get(i));
						blnResult=false;
					}
				}
			}
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			strResult = null;
		}
		return strResult;
	}

	
	/**
	 * This function is used to compare 2 lists
	 * @author Anshu Suman 
	 * @version 1.0
	 * @since 10-23-2016
	 * @param List (list1), List(list2)
	 * @return boolean(true/false)
	 */
	public boolean compareList(List<String> list1 , List<String> list2){
		boolean blnResult = false;
		try{
			if(list1.equals(list2) || list1.containsAll(list2)){
				blnResult = true;
			}
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			blnResult = false;
		}
		return blnResult;
	}
	
	
	/**
	 * This function is used perform Context menu operation
	 * @author Anshu Suman 
	 * @version 1.0
	 * @since 10-23-2016
	 * @param String (client Name), String (element to Hover), String (Element to click)
	 * @return boolean(true/false)
	 */
	public boolean performContextMenu(String clientName,String eleToHover,String eleToClick){
		boolean blnResult = false;
		try{
			
			// Wait for the page to load
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			
			// Mouse hover on Client Name
			LPLCoreUtil.mouseHoverJScript(driver.findElement(By.xpath(strClientName_XPATH.replace("xxx",clientName))));
			
			// Wait for the option to appear
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			
			// Maouse Hover on hamburger Button
			LPLCoreUtil.mouseHoverAndClickJScript(driver.findElement(By.xpath(strHamburger_XPATH.replace("xxx",clientName))));
			
			// Wait for the options to appear 
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			
			// Mouse Hover on Main Menu
			LPLCoreUtil.mouseHoverJScript(driver.findElement(ByAngular.cssContainingText(strMainMenu_CSS, eleToHover)));
			
			// Wait for the Option to appear
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			
			// Mouse Hover and click on Sub Menu
			LPLCoreUtil.mouseHoverAndClickJScript(driver.findElement(ByAngular.cssContainingText(strSubMenu_CSS, eleToClick)));
			
			// Wait for the Page to load
			LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
			blnResult = true;
		}catch(Exception ex){
			strError = strError +ex.getMessage();
			blnResult = false;
		}
		return blnResult ;
	}
	
	/**
	 * This function is used to get all values from a dropdown
	 * @author Anshu Suman 
	 * @version 1.0
	 * @since 10-23-2016
	 * @param By (object of the drop down), By (object of the values), String (tag name that contains the values)
	 * @return List (All values in the drop down)
	 */
	public List<String> getAllOptions(By locator,By dropdown,String tagName){
		try{
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			String listVal;
			
			// click on the dropdown to get all the values
			driver.findElement(locator).click();
			WebElement dropdownVal = driver.findElement(dropdown);
			
			// Get the list of matching WebElements
			List<WebElement> dropdownValues = dropdownVal.findElements(By.tagName(tagName));
			List<String> objValues = new ArrayList<>();
			for (WebElement object : dropdownValues) {
				// get the text values
				listVal = object.getText();
				
				// Add the text values to a List
				objValues.add(listVal);
			}
			return objValues;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return null;
		}
	}

}


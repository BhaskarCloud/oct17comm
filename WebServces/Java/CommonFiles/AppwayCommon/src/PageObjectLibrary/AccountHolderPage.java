package PageObjectLibrary;

import java.util.HashMap;

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
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> AccountHolderPage.java</br>
 * <br><b> Description: </B> Field functions for Account Holder Page</br>
 * <br><b>Usage:</br></b> 
 * <br>setAliasesTxt: This function is used to set Value of the Aliases Name text Field.</br>
 * <br>setNumberOfDependenciesTxt: This function is used to set Value of the Number of Dependencies text Field.</br>
 * <br>setSSNTxt: This function is used to set Value of the SSN  text Field.</br>
 * <br>setDateOfBirthTxt: This function is used to set date Of Birth.</br>
 * <br>selectCitizenshipLst: This function is used to Click on Citizenship DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectMaritalStatus: This function is used to Click on marital Status DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectGenderRdoGrp: This function is used to select gender option from gender radio group.</br>
 * <br>setTINTxt: This function is used to set Value of the TIN text Field.</br>
 * <br>selectAccUnderSSnOrTINRdo: This function is used to Click on Account Under SSN Or TIN Radio Button Field.</br>
 * <br>selectLegalCountryLst: This function is used to Click on Legal Country DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectLegalUSAddressLst: This function is used to Click on Search US Address DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectYearsAtThisLst: This function is used to Click on Years At This DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectAccMailingAddrRdo: This function is used to Click on Account Mailing Address Radio Button Field.</br>
 * <br>selectPreCountryLst: This function is used to Click on Legal Country DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectPreUSAddressLst: This function is used to Click on Previous address Country DropDown Field and to select Element from the Drop Down.</br> 
 * <br>selectMailingCountryLst: This function is used to Click on Mailing address Country DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectMailingUSAddressLst: This function is used to Click on Mailing address Country DropDown Field and to select Element from the Drop Down.</br>
 * <br>setEmailAddressTxt: This function is used to set Value of the Email Address  text Field.</br>
 * <br>clickEmailAddChkBox: This function is used to check or uncheck the Is Email address provided check box.</br>
 * <br>selectPhoneTypeLst: This function is used to Click on Phone Type DropDown Field and to select Element from the Drop Down</br>
 * <br>setPhoneNumberTxt: This function is used to set Phone number.</br>
 * <br>clickPrimaryPhoneChkBox: This function is used to check or uncheck the  Primary Phone provided check box.</br>
 * <br>selectIDTypeLst: This function is used to Click on ID Type DropDown Field and to select Element from the Drop Down.</br>
 * <br>setNotValidGovtIDxt: This function is used to set Value of the Not valid Govt ID text Field.</br>
 * <br>selectPlaceOfIssuanceLst: This function is used to Click on Place of Issuance DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectAlternativeDocLstString: This function is used to Click on Alternative Document Field and to select Element from the Drop Down.</br>
 * <br>setIDNumberTxt: This function is used to set Value of the ID Number text Field.</br>
 * <br>setIssuanceDateTxt: This function is used to set Issuance Date.</br>
 * <br>setExpirationDateTxt: This function is used to set Expiration Date.</br>
 * <br>selectHasIDVerifiedRdo: This function is used to Click on Has ID Been Verified Radio Button Field and to select Element from the Drop Down.</br>
 * <br>clickIssuanceDateExceChkBox: This function is used to check or uncheck the  Issuance Date Exception check box.</br>
 * <br>selectEmploymentStatusLst: This function is used to Click on Employment Status DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectIndustryLst: This function is used to Click on Industry DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectOccupationLst: This function is used to Click on Occupation DropDown Field and to select Element from the Drop Down.</br>
 * <br>setEmployeeNameTxt: This function is used to set Value to the Employee Name text Field.</br>
 * <br>selectEmpCountryLst: This function is used to Click on Employee Country DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectEmpUSAddressLst: This function is used to Click on Employee Country DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectAffiliationTypeLst: This function is used to Click on Affiliation DropDown Field and to select Element from the Drop Down.</br>
 * <br>setAssoFirmNameTxt: This function is used to set Value to the Name of associated Firm text Field.</br>
 * <br>selectAssofirmCountryLst: This function is used to Click on Associated Person  Country DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectAssoFirmUSAddressLst: This function is used to Click on Associated Person Address DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectRelationshipToAssoPersonLst: This function is used to Click onRelationship To Associated Person  Dropdown DropDown Field and to select Element from the Drop Down.</br>
 * <br>setNameOfCorporationTxt: This function is used to set Name of Corporation.</br>
 * <br>setCommonStockSymbolTxt: This function is used to set Common Stock Symbol.</br>
 * <br>selectImmFamilyMemRdoGrp: This function is used to Click on Account Mailing Address Radio Button Field and to select Element from the Rdo Group.</br>
 * <br>selectPEPRdo: This function is used to Click on PEP Radio Button Field and to select Element from the Rdo Group.</br>
 * <br>setDefinePEPPositionTxt: This function is used to set Value to the Define PEP Position text Field.</br>
 * <br>setAssoPersonNameTxt: This function is used to set Value to the Name of associated Person text Field</br>
 * <br>selectAssoPersonCountryLst: This function is used to Click on Associated Person  Country DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectAssoPersonUSAddressLst: This function is used to Click on Associated Person Address DropDown Field and to select Element from the Drop Down.</br>
 * <br>setExistingClntFirstNameTxt: This function is used to set value to the Existing Client First Name text Field.</br>
 * <br>setExistingClnLastNameTxt: This function is used to set Value to the Existing Client Last Name text Field.</br>
 * <br>setDecedentFirstNameTxt: This function is used to set Value to the Decedent FirstName text Field.</br>
 * <br>setDecedentMiddleNameTxt: This function is used to set Value to the Decedent Middle Name text Field.</br>
 * <br>setDecedentLastNameTxt: This function is used to set Value to the Decedent LastName text Field.</br>
 * <br>verifyAndClickCreateNewClient: This function is used to Verify client name has already an account.</br>
 * <br>selectAddInterestedPartyLst: This function is used to Click on Add Interested party DropDown Field and to select Element from the Drop Down</br>
 * <br>setPartytFirstNameTxt: This function is used to set Value to the Party First Name text Field.</br>
 * <br>setPartytLastNameTxt: This function is used to set Value to the Party First Name text Field.</br>
 * <br>selectPrimaryAccHolderAccHolderPage: To perform actions on Primary Account Holder fields in Primary account Holder  page.</br>
 * <br>selectLegalAddressAccHolderPage: To perform actions on Legal Address Holder fields in Primary account Holder  page.</br>
 * <br>selectEmailAddressAccHolderPage:To perform actions on Email Address  fields in Primary account Holder  page.</br>
 * <br>selectGovtIdentificationAccHolderPage: This function is used to perform actions on Government Identification fields in Primary account Holder's  page.</br>
 * <br>selectPartyLegalAddressAccHolderPage: This function is used to perform actions on Legal Address Holder fields in Primary account Holder  page.</br>
 * <br>selectEmploymentInfoAccHolderPage: This function is used to perform action on Employment Information in Primary Account Holder's Page.</br>
 * <br>selectIndustryAffiliationAccHolderPage: This function is used to perform action on Employment Information in Primary Account Holder's Page.</br>
 * <br>selectEmpBeneOwnershipAccHolderPage: This function is used to perform action on Employee Beneficiary owners Header and verify the availability of other radio fields.</br>
 * <br>verifyEmpBeneOwnershipAccHolderPage: This function is used to add Beneficial Owner and verify that an error message is displayed.</br>
 * <br>selectNewPartyAccHolderPage: This function is used to perform actions on Add new Party field in Primary account Holder  page.</br>
 * <br>selectPartySecAccHolderAccHolderPage: This function is used to perform action on New Party Section in Primary account Holder Field.</br>
 * <br>selectPartyGovtIdentificationAccHolderPage: This function is used to perform actions on Party Government Identification fields in Primary account Holder's  page.</br>
 * <br>selectPartyEmploymentInfoAccHolderPage: This function is used to perform action on Employment Information in Primary Account Holder's Page.</br>
 * <br>selectPartyIndustryAffiliationAccHolderPage: This function is used to perform action on Employment Information in Primary Account Holder's Page.</br>
 * @author Jyothi Jyothi,Megha Megha
 * @since 10-07-2016 
 * </p>
 */
public class AccountHolderPage extends LPLCoreDriver{

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;

	public LPLCoreConstents lplCoreConstents;

	/** Xpath property value of Dropdown Box Object */
	public	String strToclickCommAcc_XPATH;

	/** Xpath property value of Other Text  Box Object */
	public String strOtherTxtBox_XPATH;

	/** Xpath property value of searchUSAddress Dropdown Box Object */
	public String strsearchUSAdd_XPATH;

	/** Xpath property value of NotValidGovtID Text Box Object */
	public String strNotValidGovtIDTxt_XPATH;

	/** Xpath property value of Check  Box Object */
	public String strCommonChk_XPATH;

	public String strAddBeneOwner_XPATH;

	/** Xpath property value of Add Beneficiary Owner in Primary Account holder Page Object */
	public String strClickAddBO_XPATH;

	/** Xpath property value of Button text Object */
	public String strContinueCreatingNewParty_ANGULARREF;
	
	/** Xpath property value of Trusted Contacts in Primary Account Holder Page */
	public String strTrustedContactsXPATH;

	public HomePage homePage;
	public StartAccountOpeningPage startaccount;
	public NAOCommon common;
	public FinancialPage FinPage;
	public JavascriptExecutor jse;


	public int INT_PAGEID=116;
	public AccountHolderPage(WebDriver driver){

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

			if(PageObjectsMap.get("strToclickCommAcc").get("XPATH")!=null)
				strToclickCommAcc_XPATH = PageObjectsMap.get("strToclickCommAcc").get("XPATH");

			if(PageObjectsMap.get("strCommonChk").get("XPATH")!=null)
				strCommonChk_XPATH = PageObjectsMap.get("strCommonChk").get("XPATH");

			if(PageObjectsMap.get("strsearchUSAdd").get("XPATH")!=null)
				strsearchUSAdd_XPATH = PageObjectsMap.get("strsearchUSAdd").get("XPATH");

			if(PageObjectsMap.get("strNotValidGovtIDTxt").get("XPATH")!=null)
				strNotValidGovtIDTxt_XPATH = PageObjectsMap.get("strNotValidGovtIDTxt").get("XPATH");

			if(PageObjectsMap.get("strOtherTxtBox").get("XPATH") !=null)
				strOtherTxtBox_XPATH=PageObjectsMap.get("strOtherTxtBox").get("XPATH");

			if(PageObjectsMap.get("strContinueCreatingNewParty").get("ANGULARREF") !=null)
				strContinueCreatingNewParty_ANGULARREF=PageObjectsMap.get("strContinueCreatingNewParty").get("ANGULARREF");

			if(PageObjectsMap.get("strAddBeneOwner").get("XPATH") !=null)
				strAddBeneOwner_XPATH=PageObjectsMap.get("strAddBeneOwner").get("XPATH");

			if(PageObjectsMap.get("strClickAddBO").get("XPATH") !=null)
				strClickAddBO_XPATH=PageObjectsMap.get("strClickAddBO").get("XPATH");
			
			if(PageObjectsMap.get("strTrustedContacts").get("XPATH") !=null)
				strTrustedContactsXPATH=PageObjectsMap.get("strTrustedContacts").get("XPATH");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/******************************************Primary account Holder Section********************************************************/

	/**
	 * This function is used to set Value of the Aliases Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  setAliasesTxt(String strSection,String strAliasesValue ){
		boolean blnResult = false;
		try{
			String strAliasesName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strSection).replace("yyy",testData.get("strAliasesName"));
			blnResult = common.setValue(strAliasesName_XPATH, strAliasesValue);							
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}


	/**
	 * This function is used to set Value of the Number of Dependencies text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  setNumberOfDependenciesTxt(String strSection,String strNoOfDependenciesValue ){
		boolean blnResult = false;
		try{				
			String strNumberOfDependencies_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strSection).replace("yyy",testData.get("strNumberOfDependencies"));
			blnResult = common.setValue(strNumberOfDependencies_XPATH, strNoOfDependenciesValue);
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value of the SSN  text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  setSSNTxt(String strSection, String strSSNValue ){
		boolean blnResult = false;
		try{	
			String strSSN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strSection).replace("yyy",testData.get("strSSN"));
			blnResult = common.setValue(strSSN_XPATH, strSSNValue);							
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set set date Of Birth
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,int,int
	 * @return boolean
	 **/
	public boolean  setDateOfBirthTxt(String strSection,int intYearStart,int intYearEnd){
		boolean blnResult = false;
		try{													
			String strDatemmdyyyy=NAOCommon.getRandomDate(intYearStart,intYearEnd);
			System.out.println(strDatemmdyyyy);
			blnResult = common.setPickdate(strSection, testData.get("strDateOfBirth"), strDatemmdyyyy);	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Citizenship DropDown Field and to select Element from the Drop Down
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  selectCitizenshipLst(String strSection, String strCitizenshipEle){
		boolean blnResult = false;
		try{		
			String strCitizenshipDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",strSection).replace("yyy", testData.get("strCitizenshipDrop"));
			blnResult = common.selectDropDownBox(strCitizenshipDrop_XPATH, strCitizenshipEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on marital Status DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean selectMaritalStatus(String strSection,String maritalStatus)
	{
		boolean blnResult=false;
		try{
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strMaritalStatusDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", strSection).replace("yyy", testData.get("strMaritalStatusDrop"));
			blnResult = common.selectDropDownBox(strMaritalStatusDrop_XPATH, maritalStatus,"");
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select gender option from gender radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean selectGenderRdoGrp(String strGenderValue)
	{
		boolean blnResult=false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			blnResult = common.selectRadiobutton(testData.get("strGenderRdoGrp"), strGenderValue);				
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/********************************************Estate information********************************************************************************/

	/**
	 * This function is used to set Value of the TIN text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  setTINTxt(String strSection,String strTINValue ){
		boolean blnResult = false;
		try{	
			String strTIN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strSection).replace("yyy",testData.get("strTINTxt"));
			blnResult = common.setValue(strTIN_XPATH, strTINValue);							
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			blnResult = false;
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Account Under SSN Or TIN Radio Button Field 
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAccUnderSSnOrTINRdo(String strAccSSNOrTINRdobtnValue ){
		boolean blnResult = false;
		try{	
			blnResult = common.selectRadiobutton(testData.get("strAccUnderSSNOrTINRdoGrp"),strAccSSNOrTINRdobtnValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}
	/**********************************************Legal Address Section**************************************************************/

	/**
	 * This function is used to Click on Legal Country DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectLegalCountryLst(String strCountryEle ){
		boolean blnResult = false;
		try{
			String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strLegalAddsection")).replace("yyy", testData.get("strCountryDropComm"));
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strCountryDropComm_XPATH, 20);
			blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, strCountryEle,"");
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			common.waitforProcessing();
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		} catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Search US Address DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectLegalUSAddressLst(String strAddressEle ){
		boolean blnResult = false;
		try{		
			String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strLegalAddsection"));
			blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, strAddressEle,"");	
			common.waitforProcessing();
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strUSAddressDropComm_XPATH))));
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		} catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Years At This DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectYearsAtThisLst(String strYearsAtThisEle ){
		boolean blnResult = false;
		try{		
			String strYearsAtThisDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strLegalAddsection")).replace("yyy", testData.get("strYearsAtThisDrop"));
			blnResult = common.selectDropDownBox(strYearsAtThisDrop_XPATH, strYearsAtThisEle,"");	
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strYearsAtThisDrop_XPATH))));
			common.waitforProcessing();		
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Account Mailing Address Radio Button Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAccMailingAddrRdo(String strMailingAddrRdobtnValue ){
		boolean blnResult = false;
		try{	
			common.waitforProcessing();
			blnResult = common.selectRadiobutton(testData.get("strAccMailingAddrRdoGrp"),strMailingAddrRdobtnValue);
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**********************************************Previous Address Section****************************************************************/

	/**
	 * This function is used to Click on Previous address Country DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectPreCountryLst(String strPreAddCountryEle ){
		boolean blnResult = false;
		try{
			String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strPreAddsection")).replace("yyy", testData.get("strCountryDropComm"));
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strCountryDropComm_XPATH, 20);
			blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, strPreAddCountryEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Previous address Country DropDown List Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectPreUSAddressLst(String strPreUSAddressEle ){
		boolean blnResult = false;
		try{	
			String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strPreAddsection"));
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strUSAddressDropComm_XPATH, 20);
			blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, strPreUSAddressEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			common.waitforProcessing();
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/************************************************Mailing Address Section**********************************************************/

	/**
	 * This function is used to Click on Mailing address Country DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectMailingCountryLst(String strMailingCountryEle ){
		boolean blnResult = false;
		try{	
			String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strMailingAddsection")).replace("yyy", testData.get("strCountryDropComm"));
			blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, strMailingCountryEle,"");
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Mailing address Country DropDown List Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectMailingUSAddressLst(String strMailingUSAddressEle ){
		boolean blnResult = false;
		try{	
			String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strMailingAddsection"));
			blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, strMailingUSAddressEle,"");
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/********************************************Email Address Section**************************************************************/

	/**
	 * This function is used to set Value of the Email Address  text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setEmailAddressTxt(String strEmailAddrValue ){
		boolean blnResult = false;
		try{	
			String strEmailAddr_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strEmailAddsection")).replace("yyy",testData.get("strEmailAddr"));
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strEmailAddr_XPATH, 20);
			blnResult = common.setValue(strEmailAddr_XPATH, strEmailAddrValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to check or uncheck the Is Email address provided check box
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  clickEmailAddChkBox(String strChkstate){
		boolean blnResult = false;
		try{
			String strChkBox_XPATH=strCommonChk_XPATH.replace("xxx", testData.get("strEmailProvidedChk"));
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox_XPATH)));
			blnResult = common.clickChechBox(strChkBox_XPATH, strChkstate);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**********************************************Phone 1 Section********************************************************************/

	/**
	 * This function is used to Click on Phone Type DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectPhoneTypeLst(String strPhoneTypeEle ){
		boolean blnResult = false;
		String strPhoneTypeFlag="N";
		if (strPhoneTypeFlag.equalsIgnoreCase("Y")){
			try{   
				String strPhoneTypeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strPhone1Addsection")).replace("yyy", testData.get("strPhoneTypeDrop"));
				blnResult = common.selectDropDown1(strPhoneTypeDrop_XPATH, strPhoneTypeEle,"YES"); 
			}
			catch(Exception ex){
				strError = strError+ex.getMessage();
				ex.printStackTrace();
			}
		}
		else{
			blnResult=true;
		}
		return blnResult;
	}

	/**
	 * This function is used to set Phone number
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setPhoneNumberTxt(String strPhnNumberValue ){
		boolean blnResult = false;
		try{	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strPhnNumberTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPhone1Addsection")).replace("yyy",testData.get("strPhnNumberTxt"));
			blnResult = common.setValue(strPhnNumberTxt_XPATH, strPhnNumberValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to check or uncheck the  Primary Phone provided check box
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  clickPrimaryPhoneChkBox(String strChkstate){
		boolean blnResult = false;
		try{
			String strChkBox_XPATH=strCommonChk_XPATH.replace("xxx",testData.get("strPrimaryPhoneChk"));
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox_XPATH)));
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strChkBox_XPATH, 20);
			blnResult = common.clickChechBox(strChkBox_XPATH, strChkstate);
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strChkBox_XPATH, 10);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/****************************************Government Identification Section**********************************************************/

	/**
	 * This function is used to Click on ID Type DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectIDTypeLst(String strIDTypeEle ){
		boolean blnResult = false;
		try{	
			String strIDTypeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy", testData.get("strIDTypeDrop"));
			blnResult = common.selectDropDownBox(strIDTypeDrop_XPATH, strIDTypeEle,"");	
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value of the Not valid Govt ID text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setNotValidGovtIDxt(String strNotValidGovtIDValue ){
		boolean blnResult = false;
		try{
			String strNotValidGovtIDTxt_XPATH1 =strNotValidGovtIDTxt_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy", testData.get("strNotValidGovtIDTxt"));
			blnResult = common.setValue(strNotValidGovtIDTxt_XPATH1, strNotValidGovtIDValue);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Place of Issuance DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectPlaceOfIssuanceLst(String strPlaceOfIssuanceEle ){
		boolean blnResult = false;
		try{		
			String strPlaceOfIssuanceDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy", testData.get("strPlaceOfIssuanceDrop"));
			blnResult = common.selectDropDownBox(strPlaceOfIssuanceDrop_XPATH, strPlaceOfIssuanceEle,"");	
			common.waitforProcessing();
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Alternative Document Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAlternativeDocLstString(String strAltrDocEle ){
		boolean blnResult = false;
		try{		
			String strAltrDocDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy", testData.get("strAltrDocDrop"));
			blnResult = common.selectDropDownBox(strAltrDocDrop_XPATH, strAltrDocEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value of the ID Number text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setIDNumberTxt(String strIDNumberValue ){
		boolean blnResult = false;
		try{	
			String strIDNumberTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy",testData.get("strIDNumberTxt"));
			blnResult = common.setValue(strIDNumberTxt_XPATH, strIDNumberValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Issuance Date
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param int,int
	 * @return boolean
	 **/
	public boolean  setIssuanceDateTxt(int yearStart,int yearend ){
		boolean blnResult = false;
		try{													
			String strDatemmdyyyy=NAOCommon.getRandomDate(yearStart,yearend);
			System.out.println(strDatemmdyyyy);
			blnResult = common.setPickdate(testData.get("strGovtIdsection"), testData.get("strIssuanceDateTxt"), strDatemmdyyyy);														
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Expiration Date
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param int,int
	 * @return boolean
	 **/
	public boolean  setExpirationDateTxt(int yearStart,int yearend ){
		boolean blnResult = false;
		try{	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			String strDatemmdyyyy=NAOCommon.getRandomDate(yearStart, yearend);
			System.out.println(strDatemmdyyyy);
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			blnResult = common.setPickdate(testData.get("strGovtIdsection"), testData.get("strExpirationDateTxt"), strDatemmdyyyy);														
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Has ID Been Verified Radio Button Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectHasIDVerifiedRdo(String strIDVerifiedRdobtnValue ){
		boolean blnResult = false;
		try{	
			blnResult = common.selectRadiobutton(testData.get("strHasIDVerifiedRdoGrp"), strIDVerifiedRdobtnValue);	
			common.waitforProcessing();
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to check or uncheck the  Issuance Date Exception check box
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  clickIssuanceDateExceChkBox(String strChkstate){
		boolean blnResult = false;
		try{
			String strChkBox_XPATH=strCommonChk_XPATH.replace("xxx", testData.get("strIssuanceDateExceChk"));
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strChkBox_XPATH))));
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strChkBox_XPATH, 20);
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox_XPATH)));
			blnResult = common.clickChechBox(strChkBox_XPATH, strChkstate);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strChkBox_XPATH))));
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**********************************************Employment Information Section***************************************************************/

	/**
	 * This function is used to Click on Employment Status DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectEmploymentStatusLst(String strEmploymentStatusEle ){
		boolean blnResult = false;
		try{		
			String strEmploymentStatusDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy", testData.get("strEmploymentStatusDrop"));
			blnResult = common.selectDropDownBox(strEmploymentStatusDrop_XPATH, strEmploymentStatusEle,"");
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strEmploymentStatusDrop_XPATH))));
			common.waitforProcessing();
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Industry DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectIndustryLst(String stIndustryEle ){
		boolean blnResult = false;
		try{
			String strIndustryDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy", testData.get("strIndustryDrop"));
			blnResult = common.selectDropDownBox(strIndustryDrop_XPATH, stIndustryEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Occupation DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectOccupationLst(String stOccupationEle ){
		boolean blnResult = false;
		try{
			String strOccupationDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strEmpInfosection")).replace("yyy", testData.get("strOccupationDrop"));
			blnResult = common.selectDropDownBox(strOccupationDrop_XPATH, stOccupationEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Employee Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setEmployeeNameTxt(String strEmployeeNameValue ){
		boolean blnResult = false;
		try{
			String strEmpNameTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy",testData.get("strEmpNameTxt"));
			blnResult = common.setValue(strEmpNameTxt_XPATH, strEmployeeNameValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Employee Country DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectEmpCountryLst(String stEmployeeCountryEle ){
		boolean blnResult = false;
		try{		
			String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy", testData.get("strCountryDropComm"));
			blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, stEmployeeCountryEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Employee Country DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectEmpUSAddressLst(String strEmpUSAddEle ){
		boolean blnResult = false;
		try{		
			String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strEmpInfosection"));
			blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, strEmpUSAddEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			common.waitforProcessing();
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**************************************Industry/Affiliation Section******************************************************************/

	/**
	 * This function is used to Click on Affiliation Dropdown DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAffiliationTypeLst(String strAffiliationtype ){
		boolean blnResult = false;
		try{		
			String strAffiliationtypeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy", testData.get("strAffiliationtypeDrop"));
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAffiliationtypeDrop_XPATH))));
			blnResult = common.selectDropDownBox(strAffiliationtypeDrop_XPATH, strAffiliationtype,"");
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAffiliationtypeDrop_XPATH))));
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);	
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Name of associated Firm text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setAssoFirmNameTxt(String strAssoFirmNameValue ){
		boolean blnResult = false;
		try{
			String strFirmNameTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strAssoFirmNameTxt"));
			blnResult = common.setValue(strFirmNameTxt_XPATH, strAssoFirmNameValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Associated Person  Country DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAssofirmCountryLst(String strAssoFirmCountryEle ){
		boolean blnResult = false;
		try{		
			String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strCountryDropComm"));
			blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, strAssoFirmCountryEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Associated Person Address List DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAssoFirmUSAddressLst(String strAssoFirmUSAddEle ){
		boolean blnResult = false;
		try{		
			String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx", testData.get("strIndustryAffiliationsection"));
			blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, strAssoFirmUSAddEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Relationship To Associated Person  Dropdown DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectRelationshipToAssoPersonLst(String strRelationshipToAsso ){
		boolean blnResult = false;
		try{		
			String strRelationshipToAssoDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strIndustryAffiliationsection")).replace("yyy", testData.get("strRelationshipToAssoPersonDrop"));
			blnResult = common.selectDropDownBox(strRelationshipToAssoDrop_XPATH, strRelationshipToAsso,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Name of Corporation 
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setNameOfCorporationTxt(String strCorporationValue ){
		boolean blnResult = false;
		try{	
			String strNameOfCorporationTxt_XPATH=FinPage.strOtherTxtBox_XPATH.replace("xxx",testData.get("strNameOfCorporationTxt"));
			blnResult = common.setValue(strNameOfCorporationTxt_XPATH, strCorporationValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Common Stock Symbol
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setCommonStockSymbolTxt(String strCommonStockSymbolValue){
		boolean blnResult = false;
		try{		
			String strCommonStockSymbolTxt_XPATH=FinPage.strOtherTxtBox_XPATH.replace("xxx",testData.get("strCommonStockSymbol"));
			blnResult = common.setValue(strCommonStockSymbolTxt_XPATH, strCommonStockSymbolValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Account Mailing Address Radio Button Field and to select Element from the Rdo Group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectImmFamilyMemRdoGrp(String strImmFamilyMemRdobtnValue ){
		boolean blnResult = false;
		try{	
			blnResult = common.selectRadiobutton(testData.get("strImmFamilyMemRdoGrp"),strImmFamilyMemRdobtnValue);		
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on PEP Radio Button Field and to select Element from the Rdo Group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectPEPRdo(String strPEPRdobtnValue ){
		boolean blnResult = false;
		try{	
			blnResult = common.selectRadiobutton(testData.get("strPEPRdoGrp"), strPEPRdobtnValue);		
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Define PEP Position text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setDefinePEPPositionTxt(String strDefinePEPPostionValue ){
		boolean blnResult = false;
		try{
			String strDefinePEPTxt_XPATH=FinPage.strOtherTxtBox_XPATH.replace("xxx",testData.get("strDefinePEPTxt"));
			blnResult = common.setValue(strDefinePEPTxt_XPATH, strDefinePEPPostionValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Name of associated Person text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setAssoPersonNameTxt(String strAssoPersonNameValue ){
		boolean blnResult = false;
		try{
			String strEmpNameTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strAssoPersonNameTxt"));
			blnResult = common.setValue(strEmpNameTxt_XPATH, strAssoPersonNameValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Associated Person  Country DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAssoPersonCountryLst(String strAssoPersonCountryEle ){
		boolean blnResult = false;
		try{		
			String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strCountryDropComm"));
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strCountryDropComm_XPATH, 10);
			String strBlnFlag = "YES";
			blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, strAssoPersonCountryEle,strBlnFlag);
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strCountryDropComm_XPATH, 10);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Associated Person Address Element DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAssoPersonUSAddressLst(String strAssoPersonUSAddEle ){
		boolean blnResult = false;
		try{		
			String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection"));
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strUSAddressDropComm_XPATH, 10);
			String strBlnFlag = "YES";
			blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, strAssoPersonUSAddEle,strBlnFlag);
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver, "xpath", strUSAddressDropComm_XPATH, 10);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/*******************************************Search For Existing Clients************************************************************************/
	/**
	 * This function is used to set value to the Existing Client First Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExistingClntFirstNameTxt(String strExistingClntFNValue ){
		boolean blnResult = false;
		try{
			String strFirstName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strSearchExistingClntSection")).replace("yyy",testData.get("strFirstName"));
			strExistingClntFNValue=common.generateRandomAlphabets();
			blnResult =common.setValue(strFirstName_XPATH, strExistingClntFNValue);				
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Existing Client Last Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/

	public boolean  setExistingClnLastNameTxt(String strExistingClntLNValue ){
		boolean blnResult = false;
		try{
			String strMiddleName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strSearchExistingClntSection")).replace("yyy",testData.get("strLastName"));
			strExistingClntLNValue=common.generateRandomAlphabets();
			blnResult =common.setValue(strMiddleName_XPATH, strExistingClntLNValue);			
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Decedent FirstName text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  setDecedentFirstNameTxt(String strDecedentSection, String strDecedentNameValue){
		boolean blnResult = false;

		try{
			String strDecedentName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strDecedentSection).replace("yyy",testData.get("strFirstName"));
			blnResult =common.setValue(strDecedentName_XPATH, strDecedentNameValue);

		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Decedent Middle Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  setDecedentMiddleNameTxt(String strDecedentSection, String strDecedentNameValue){
		boolean blnResult = false;

		try{
			String strDecedentName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strDecedentSection).replace("yyy",testData.get("strMiddleName"));
			blnResult =common.setValue(strDecedentName_XPATH, strDecedentNameValue);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value to the Decedent LastName text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  setDecedentLastNameTxt(String strDecedentSection, String strDecedentNameValue){
		boolean blnResult = false;
		try{
			String strDecedentName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strDecedentSection).replace("yyy",testData.get("strLastName"));
			blnResult =common.setValue(strDecedentName_XPATH, strDecedentNameValue);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Verify client name has already an account
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param 
	 * @return boolean
	 **/
	public boolean  verifyAndClickCreateNewClient(){
		boolean blnResult = false;
		try{
			blnResult = common.ClickOnPlus(testData.get("strCreateNewClntBtnTxt"));
			if(driver.findElement(ByAngular.buttonText(strContinueCreatingNewParty_ANGULARREF)).isDisplayed())
			{
				driver.findElement(ByAngular.buttonText(strContinueCreatingNewParty_ANGULARREF)).click();
			}
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			blnResult = true;
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Add Interested party DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String, String
	 * @return boolean
	 **/
	public boolean  selectAddInterestedPartyLst(String strSection,String  strAddInterestedPartyEle){
		boolean blnResult = false;
		try{          
			String strAddInterestedPartyDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",strSection).replace("yyy",testData.get("strAddInterestedPartyDrop"));
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAddInterestedPartyDrop_XPATH))));
			blnResult = common.selectDropDownBox(strAddInterestedPartyDrop_XPATH, strAddInterestedPartyEle,"");
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAddInterestedPartyDrop_XPATH))));
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);   
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set value to the Party First Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param 
	 * @return boolean
	 **/
	public boolean  setPartytFirstNameTxt(){
		boolean blnResult = false;
		try{
			String strFirstName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strCreateNewParty")).replace("yyy",testData.get("strFirstName"));
			String strPartyFNValue=common.generateRandomAlphabets();
			blnResult =common.setValue(strFirstName_XPATH, strPartyFNValue);                           
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set value to the Party Last Name text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param 
	 * @return boolean
	 **/
	public boolean  setPartytLastNameTxt(){
		boolean blnResult = false;
		try{
			String strLastName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strCreateNewParty")).replace("yyy",testData.get("strLastName"));
			String strPartyLNValue=common.generateRandomAlphabets();
			blnResult =common.setValue(strLastName_XPATH, strPartyLNValue);                           
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to perform actions on Primary Account Holder fields in Primary account Holder  page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectPrimaryAccHolderAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	

				case "NUMOFDEPENDENTS":
					String strNumberOfDependencies_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPAHSection")).replace("yyy",testData.get("strNumberOfDependencies"));
					blnResult=common.setValue(strNumberOfDependencies_XPATH, testData.get("strNoOfDependenciesValue"));
					break;

				case "DOB":
					setDateOfBirthTxt(testData.get("strPAHSection"),Integer.parseInt(testData.get("intYearStart1")),Integer.parseInt(testData.get("intYearEnd1")));
					break;

				case "CITIZENSHIP":
					String strCitizenshipDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strPAHSection")).replace("yyy", testData.get("strCitizenshipDrop"));
					blnResult = common.selectDropDownBox(strCitizenshipDrop_XPATH, testData.get("strCitizenshipEle"),"");	
					break;

				case "SSN":
					String strSSN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPAHSection")).replace("yyy",testData.get("strSSN"));
					blnResult = common.setValue(strSSN_XPATH, testData.get("strSSNValue"));		
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
					break;

				case "TIN":
					String strTIN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPAHSection")).replace("yyy",testData.get("strTINTxt"));
					blnResult = common.setValue(strTIN_XPATH, testData.get("strTINValue"));							
					break;

				case "GENDER":
					blnResult = selectGenderRdoGrp(testData.get("strGenderValue"));
					break;

				case "MARITALSTATUS":
					blnResult = selectMaritalStatus(testData.get("strPAHSection"),testData.get("strMaritalStatus"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on Legal Address Holder fields in Primary account Holder  page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectLegalAddressAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "COUNTRY":
					String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strLegalAddsection")).replace("yyy", testData.get("strCountryDropComm"));
					blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, testData.get("strLegalCountryEle"),"");	
					break;

				case "SEARCHUSADDRESS":
					String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strLegalAddsection"));
					blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, testData.get("strLegalAddressEle"),"");	
					break;

				case "YEARATTHIS":
					String strYearsAtThisDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strLegalAddsection")).replace("yyy", testData.get("strYearsAtThisDrop"));
					blnResult = common.selectDropDownBox(strYearsAtThisDrop_XPATH, testData.get("strYearsAtThisEle"),"");			
					break;

				case "ACCMAILRDO":
					blnResult = common.selectRadiobutton(testData.get("strAccMailingAddrRdoGrp"),testData.get("strAccMailingAddrRdoGrpVal"));
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on Mailing Address Holder fields in Primary account Holder  page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectMailingAddressAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "COUNTRY":
					String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strMailingAddsection")).replace("yyy", testData.get("strCountryDropComm"));
					blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, testData.get("strMailingCountryEle"),"");
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
					break;

				case "SEARCHUSADDRESS":
					String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strMailingAddsection"));
					blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, testData.get("strMailingUSAddressEle"),"");
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on Email Address  fields in Primary account Holder  page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectEmailAddressAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "EMAILADDRESS":
					String strEmailAddr_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strEmailAddsection")).replace("yyy",testData.get("strEmailAddsection"));
					blnResult = common.setValue(strEmailAddr_XPATH, testData.get("strEmailAddrValue"));	
					break;

				case "EMAILADRESSCHK":
					String strChkBox_XPATH=strCommonChk_XPATH.replace("xxx", testData.get("strEmailProvidedChk"));
					blnResult = common.clickChechBox(strChkBox_XPATH, testData.get("strEmailChk"));
					break;

				case "PHONENUM":
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					String strPhnNumberTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPhone1Addsection")).replace("yyy",testData.get("strPhnNumberTxt"));
					blnResult = common.setValue(strPhnNumberTxt_XPATH, testData.get("strPhnNumberValue"));
					break;

				case "PHONENUMCHK":
					String strChkBox1_XPATH=strCommonChk_XPATH.replace("xxx",testData.get("strPrimaryPhoneChk"));
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox1_XPATH)));
					//Wait for the page to load
					LPLCoreSync.waitForWebElement(driver, "xpath", strChkBox1_XPATH, 20);
					blnResult = common.clickChechBox(strChkBox1_XPATH, testData.get("strChkstate"));
					//Wait for the page to load
					LPLCoreSync.waitForWebElement(driver, "xpath", strChkBox1_XPATH, 10);
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
					break;

				case "NEXT":
					blnResult=common.ClickOnBtn(testData.get("strNextBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on Government Identification fields in Primary account Holder's  page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectGovtIdentificationAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "IDTYPE":
					String strIDTypeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy", testData.get("strIDTypeDrop"));
					blnResult = common.selectDropDownBox(strIDTypeDrop_XPATH, testData.get("strIDTypeEle"),"");	
					break;

				case "PLACEOFISSUANCE":
					String strPlaceOfIssuanceDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy", testData.get("strPlaceOfIssuanceDrop"));
					blnResult = common.selectDropDownBox(strPlaceOfIssuanceDrop_XPATH, testData.get("strPlaceOfIssuanceEle"),"");	
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "IDNUMVAL":
					String strIDNumberTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy",testData.get("strIDNumberTxt"));
					blnResult = common.setValue(strIDNumberTxt_XPATH, testData.get("strIDNumberValue"));
					break;

				case "ISSUANCEDATE":
					setIssuanceDateTxt(Integer.parseInt(testData.get("intIssuanceStart")),Integer.parseInt(testData.get("intIssuanceEnd")));
					break;

				case "ISSUANCEDATEEXPCHK":
					String strChkBox_XPATH=strCommonChk_XPATH.replace("xxx", testData.get("strIssuanceDateExceChk"));
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strChkBox_XPATH))));
					//Wait for the page to load
					LPLCoreSync.waitForWebElement(driver, "xpath", strChkBox_XPATH, 20);
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox_XPATH)));
					blnResult = common.clickChechBox(strChkBox_XPATH, testData.get("strChkstate"));
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strChkBox_XPATH))));
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
					break;

				case "EXPIRATIONDATE":
					setExpirationDateTxt(Integer.parseInt(testData.get("intExpirationStart")),Integer.parseInt(testData.get("intExpirationEnd")));
					break;

				case "IDVERIFYRDO":
					blnResult = common.selectRadiobutton(testData.get("strHasIDVerifiedRdoGrp"), testData.get("strIDVerifiedRdobtnValue"));	
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "FORMDOCUMENT":
					blnResult = common.selectRadiobutton(testData.get("strFormationDocIRS"), testData.get("strFormationDocIRSValue"));	
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "IDENTIFYDOC":
					blnResult = common.selectRadiobutton(testData.get("strIdentifyDoc"), testData.get("strIdentifyDocValue"));	
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on Legal Address Holder fields in Primary account Holder  page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectPartyLegalAddressAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "COUNTRY":
					String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strLegalAddsection")).replace("yyy", testData.get("strCountryDropComm"));
					blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, testData.get("strPartyLegalCountryEle"),"");	
					break;

				case "SEARCHUSADDRESS":
					String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strLegalAddsection"));
					blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, testData.get("strPartyLegalAddressEle"),"");	
					break;

				case "YEARATTHIS":
					String strYearsAtThisDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strLegalAddsection")).replace("yyy", testData.get("strYearsAtThisDrop"));
					blnResult = common.selectDropDownBox(strYearsAtThisDrop_XPATH, testData.get("strPartyYearsAtThisEle"),"");			
					break;

				case "ACCMAILRDO":
					blnResult = common.selectRadiobutton(testData.get("strAccMailingAddrRdoGrp"),testData.get("strAccMailingAddrRdoGrpVal"));
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform action on Employment Information in Primary Account Holder's Page.
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectEmploymentInfoAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "EMPLOYMENTSTATUS":
					String strEmploymentStatusDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy", testData.get("strEmploymentStatusDrop"));
					blnResult = common.selectDropDownBox(strEmploymentStatusDrop_XPATH, testData.get("strEmploymentStatusEle"),"");
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strEmploymentStatusDrop_XPATH))));
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "INDUSTRY":
					String strIndustryDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy", testData.get("strIndustryDrop"));
					blnResult = common.selectDropDownBox(strIndustryDrop_XPATH, testData.get("stIndustryEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "OCCUPATION":
					String strOccupationDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strEmpInfosection")).replace("yyy", testData.get("strOccupationDrop"));
					blnResult = common.selectDropDownBox(strOccupationDrop_XPATH, testData.get("stOccupationEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "EMPLOYEENAME":
					String strEmpNameTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy",testData.get("strEmpNameTxt"));
					blnResult = common.setValue(strEmpNameTxt_XPATH, testData.get("strEmployeeNameValue"));
					break;

				case "COMPANYSTOCK":
					blnResult = common.selectRadiobutton(testData.get("strCompanyStock"), testData.get("strCompanyStockValue"));	
					break;

				case "EMPLOYEECOUNTRY":
					String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy", testData.get("strCountryDropComm"));
					blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, testData.get("stEmployeeCountryEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "EMPLOYEEADDRESS":
					String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strEmpInfosection"));
					blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, testData.get("strEmpUSAddEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					common.waitforProcessing();
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
					break;

				case "NEXT":
					blnResult=common.ClickOnBtn(testData.get("strNextBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform action on Employment Information in Primary Account Holder's Page.
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectIndustryAffiliationAccHolderPage(String... strStartAccountPagePanels){
        boolean blnResult=false;
        String strResult= null;
        try{
            for(String strPanel:strStartAccountPagePanels){
                switch(strPanel.toUpperCase()){              
                case "AFFILIATIONTYPE":
                    String strAffiliationtypeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy", testData.get("strAffiliationtypeDrop"));
                    new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAffiliationtypeDrop_XPATH))));
                    blnResult = common.selectDropDownBox(strAffiliationtypeDrop_XPATH, testData.get("strAffiliationtype"),"");
                    new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAffiliationtypeDrop_XPATH))));
                    homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);      
                    break;

                case "TRUSTEDCONTACT":
                    blnResult = selectTrustedContact();
                    break;

                case "ASSOFIRMNAME":
                    String strFirmNameTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strAssoFirmNameTxt"));
                    blnResult = common.setValue(strFirmNameTxt_XPATH, testData.get("strAssoFirmNameValue"));
                    break;

                case "ASSOCOUNTRY":
                    String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strCountryDropComm"));
                    blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, testData.get("strAssoFirmCountryEle"),"");         
                    homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
                    break;

                case "ASSOCOUNTRYADD":
                    String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx", testData.get("strIndustryAffiliationsection"));
                    blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, testData.get("strAssoFirmUSAddEle"),"");
                    homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
                    break;

                case "RELATIONASSOFIRM":
                    String strRelationshipToAssoDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strIndustryAffiliationsection")).replace("yyy", testData.get("strRelationshipToAssoPersonDrop"));
                    blnResult = common.selectDropDownBox(strRelationshipToAssoDrop_XPATH, testData.get("strRelationshipToAsso"),"");
                    homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
                    break;

                case "ASSOPERSONNAME":
                    String strEmpNameTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strAssoPersonNameTxt"));
                    blnResult = common.setValue(strEmpNameTxt_XPATH, testData.get("strAssoPersonNameValue"));
                    break;

                case "IMMEFAMILYMEM":
                    blnResult = common.selectRadiobutton(testData.get("strImmFamilyMemRdoGrp"),testData.get("strImmFamilyMemRdobtnValue"));                                
                    homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
                    break;

                case "PEPRDO":
                    blnResult = common.selectRadiobutton(testData.get("strPEPRdoGrp"), testData.get("strPEPRdobtnValue"));                     
                    homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
                    break;


                case "VALIDATE":
                    blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
                    break;

                case "NEXT":
                    blnResult=common.ClickOnBtn(testData.get("strNextBtnTxt"));
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
            return strResult=null;     
        }
     return strResult;
}
	

	/**
	 * This function is used to perform action on Employee Beneficiary owners Header and verify the availability of other radio fields
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectEmpBeneOwnershipAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	

				//To perform action on Is the Plan Sponsor/Employer a Corporation, Non-Profit, Partnership or Limited Liability Company?
				case "PLANSPONSEREMP":
					String strPlusSign_XPATH =common.strPlusCommn_XPATH.replace("xxx",testData.get("strEmpBOHeader"));
					String strTableDropDown_XPATH = common.objTableDropDown_XPATH.replace("xxx",testData.get("strIsPlnOrSpnsr"));
					if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strPlusSign_XPATH), LPLCoreConstents.getInstance().LOW)){
						if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strTableDropDown_XPATH), LPLCoreConstents.getInstance().LOW)){
							blnResult = common.selectRadiobutton(testData.get("strIsPlnOrSpnsrLiaComp"),testData.get("strIsPlnOrSpnsrLiaCompVal"));
						}
					}
					break;

					//To verify other radio fields are hidden when Plan sponsor radio button is marked No
				case "VERIFYPLANSPORNSER" :
					String strTableDropDown1_XPATH = common.objTableDropDown_XPATH.replace("xxx",testData.get("strLegalENTTradExmp"));
					if(!LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strTableDropDown1_XPATH), LPLCoreConstents.getInstance().LOW)){
						LPLCoreReporter.WriteReport("Step  : Verify objects", "User should not be able to find objects", "Performed" + strResult+ " Successfully", "Passed",""); 
					}
					String strTableDropDown2_XPATH = common.objTableDropDown_XPATH.replace("xxx",testData.get("strLegalENTNPExmp"));
					if(!LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strTableDropDown2_XPATH), LPLCoreConstents.getInstance().LOW)){
						LPLCoreReporter.WriteReport("Step  : Verify objects", "User should not be able to find objects", "Performed" + strResult+ " Successfully", "Passed",""); 
					}
					String strTableDropDown3_XPATH = common.objTableDropDown_XPATH.replace("xxx",testData.get("strLegalENTBO"));
					if(!LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strTableDropDown3_XPATH), LPLCoreConstents.getInstance().LOW)){
						LPLCoreReporter.WriteReport("Step  : Verify objects", "User should not be able to find objects", "Performed" + strResult+ " Successfully", "Passed",""); 
					}
					break;

					//To perform action on Does the Legal Entity meet the charity or non-profit exemption? radio group	
				case "BONONPROFITEXE":
					blnResult = common.selectRadiobutton(testData.get("strIsPlnOrSpnsrLiaComp"),testData.get("strIsPlnOrSpnsrLiaCompVal2"));
					blnResult = common.selectRadiobutton(testData.get("strLegalENTNPExmp"),testData.get("strLegalENTNPExmpVal"));
					break;

					//To perform action on Does the Legal Entity have Beneficial Owners with 25% or more ownership? radio group	
				case "BOMOREOWNERSHIP":
					blnResult = common.selectRadiobutton(testData.get("strLegalENTBO"),testData.get("strLegalENTBOVal"));
					break;

					//To perform action on How many beneficial owners are there? drop down box
				case "HOWMANYBO":
					String strHowManyBODrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpBOHeader")).replace("yyy", testData.get("strBOCount"));
					blnResult = common.selectDropDownBox(strHowManyBODrop_XPATH, testData.get("strBOCountVal"),"");			
					break;

					//To validate the presence of Beneficial Owner Header	
				case "PLNSPONSRHEADER":
					String strPlusSign1_XPATH =common.strPlusCommn_XPATH.replace("xxx",testData.get("strEmpBOHeader"));
					if(!LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strPlusSign1_XPATH), LPLCoreConstents.getInstance().LOW)){
						blnResult = true;
					}
					break;

				case "NEXT":
					blnResult=common.ClickOnBtn(testData.get("strNextBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}

	/**
	 * This function is used to add Beneficial Owner and verify that an error message is displayed
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  verifyEmpBeneOwnershipAccHolderPage(String... strAccountHolderPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strAccountHolderPagePanels){
				switch(strPanel.toUpperCase()){	

				//To validate the number of Beneficial Owners added
				case "VERIFYBOTEXT":
					String strGetBOText = null;
					String strAddBenefOwner_XPATH = strAddBeneOwner_XPATH.replace("xxx",testData.get("strAddEx")).replace("yyy", testData.get("strBeneOwn"));
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAddBenefOwner_XPATH))));
					WebElement strGetBOText1 = driver.findElement(By.xpath(strAddBenefOwner_XPATH));
					strGetBOText = strGetBOText1.getText();	
					if(strGetBOText.equals("Add exactly 2 Beneficial Owner")){
						//Wait for the page to load
						LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
						common.waitforProcessing();
						String strClick = strClickAddBO_XPATH.replace("xxx",testData.get("strBOTxt"));
						new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strClick))));
						driver.findElement(By.xpath(strClick)).click();
						//Wait for the page to load
						LPLCoreSync.staticWait(homePage.lplCoreConstents.MediumInMiliSec);
						blnResult = true;	
					}
					break;

					//To add Beneficial Owners and select the client Type
				case "ADDBO":
					String strAddBODrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strAddBO")).replace("yyy",testData.get("strPartyTxt"));
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAddBODrop_XPATH))));
					blnResult = common.selectDropDownBox(strAddBODrop_XPATH, testData.get("strEntity"),"");
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAddBODrop_XPATH))));
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW); 
					blnResult = true;
					break;

					//To select new party type and click on create new Party
				case "VERIFYRDO":
					blnResult = common.selectRadiobutton(testData.get("strIsBOPartAcc"), testData.get("strIsBOPartAccVal"));
					String strEntityName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strCreateNewParty")).replace("yyy",testData.get("strEntityName"));
					blnResult=common.setValue(strEntityName_XPATH, common.generateRandomAlphabets());
					verifyAndClickCreateNewClient();
					blnResult = true;
					break;

					//To verify the error message in Account Holder's Page
				case "VERIFYERRMSG":
					blnResult = common.selectRadiobutton(testData.get("strPvtHld"), testData.get("strPvtHldVal"));
					String strErrMsg_XPATH = strClickAddBO_XPATH.replace("xxx",testData.get("strErrMsg"));
					if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strErrMsg_XPATH), LPLCoreConstents.getInstance().LOW)){
						blnResult = true ;
					}
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
			return strResult=null;	
		}
		return strResult;
	}

	/**
	 * This function is used to perform actions on Add new Party field in Primary account Holder  page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectNewPartyAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "CLICKONPLUS":
					blnResult = common.ClickOnPlus(testData.get("strAddPartyPlusSign"));	
					break;

				case "ADDINTERESTEDPARTY":
					String strAddInterestedPartyDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strAddPartyPlusSign")).replace("yyy",testData.get("strAddInterestedPartyDrop"));
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAddInterestedPartyDrop_XPATH))));
					blnResult = common.selectDropDownBox(strAddInterestedPartyDrop_XPATH, testData.get("strCreateNewParty"),"");
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAddInterestedPartyDrop_XPATH))));
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);   
					break;

				case "FIRSTNAME":
					String strFirstName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strCreateNewParty")).replace("yyy",testData.get("strFirstName"));
					String strPartyFNValue=common.generateRandomAlphabets();
					blnResult =common.setValue(strFirstName_XPATH, strPartyFNValue);                           
					break;

				case "LASTNAME":
					String strLastName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strCreateNewParty")).replace("yyy",testData.get("strLastName"));
					String strPartyLNValue=common.generateRandomAlphabets();
					blnResult =common.setValue(strLastName_XPATH, strPartyLNValue);                           
					break;

				case "CREATENEWPARTYBTN":
					blnResult = common.ClickOnPlus(testData.get("strCreateNewClntBtnTxt"));
					try {
						if(driver.findElement(ByAngular.buttonText(strContinueCreatingNewParty_ANGULARREF)).isDisplayed()){
							driver.findElement(ByAngular.buttonText(strContinueCreatingNewParty_ANGULARREF)).click();
						}
					} catch (Exception ex) {
						strError = strError+ex.getMessage();
						ex.printStackTrace();
					}
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
					break;

				case "NEXT":
					blnResult=common.ClickOnBtn(testData.get("strNextBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform action on New Party Section in Primary account Holder Field
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectPartySecAccHolderAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	

				case "NUMOFDEPENDENTS":
					String strNumberOfDependencies_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPartySection")).replace("yyy",testData.get("strNumberOfDependencies"));
					blnResult=common.setValue(strNumberOfDependencies_XPATH, testData.get("strNoOfDependenciesValue"));
					break;

				case "DOB":
					setDateOfBirthTxt(testData.get("strPartySection"),Integer.parseInt(testData.get("intYearStartcus")),Integer.parseInt(testData.get("intYearEndcus")));
					break;

				case "CITIZENSHIP":
					String strCitizenshipDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strPartySection")).replace("yyy", testData.get("strCitizenshipDrop"));
					blnResult = common.selectDropDownBox(strCitizenshipDrop_XPATH, testData.get("strCitizenshipEle"),"");	
					break;

				case "SSN":
					String strSSN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPartySection")).replace("yyy",testData.get("strSSN"));
					blnResult = common.setValue(strSSN_XPATH, testData.get("strSSNValue"));		
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
					break;

				case "TIN":
					String strTIN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPartySection")).replace("yyy",testData.get("strTINTxt"));
					blnResult = common.setValue(strTIN_XPATH, testData.get("strTINValue"));							
					break;

				case "TITLE":
					String strTitle_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strPartySection")).replace("yyy", testData.get("strTitleTxt"));
					blnResult = common.selectDropDownBox(strTitle_XPATH, testData.get("strTitleValue"),"");
					break;

				case "RELTBENEFICIARY":
					String strRelationToBeneficiary_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPartySection")).replace("yyy",testData.get("strRelationToBeneficiary"));
					blnResult=common.setValue(strRelationToBeneficiary_XPATH, testData.get("strRelationToBeneficiaryVal"));
					break;

				case "GAURDIANDEPOSITOR" :
					blnResult = common.selectRadiobutton(testData.get("strGaurdianDepositor"), testData.get("strGaurdianDepositorVal"));		
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "GENDER":
					blnResult = selectGenderRdoGrp(testData.get("strPartyGenderValue"));
					break;

				case "MARITALSTATUS":
					blnResult = selectMaritalStatus(testData.get("strPartySection"),testData.get("strPartyMaritalStatus"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on Party Government Identification fields in Primary account Holder's  page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectPartyGovtIdentificationAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "IDTYPE":
					String strIDTypeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy", testData.get("strIDTypeDrop"));
					blnResult = common.selectDropDownBox(strIDTypeDrop_XPATH, testData.get("strPartyIDTypeEle"),"");	
					break;

				case "PLACEOFISSUANCE":
					String strPlaceOfIssuanceDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy", testData.get("strPlaceOfIssuanceDrop"));
					blnResult = common.selectDropDownBox(strPlaceOfIssuanceDrop_XPATH, testData.get("strPartyPlaceOfIssuanceEle"),"");	
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "IDNUMVAL":
					String strIDNumberTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strGovtIdsection")).replace("yyy",testData.get("strIDNumberTxt"));
					blnResult = common.setValue(strIDNumberTxt_XPATH, testData.get("strPartyIDNumberValue"));
					break;

				case "ISSUANCEDATE":
					setIssuanceDateTxt(Integer.parseInt(testData.get("intPartyIssuanceStart")),Integer.parseInt(testData.get("intPartyIssuanceEnd")));
					break;
				case "ISSUANCEDATEEXPCHK":
					String strChkBox_XPATH=strCommonChk_XPATH.replace("xxx", testData.get("strIssuanceDateExceChk"));
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strChkBox_XPATH))));
					//Wait for the page to load
					LPLCoreSync.waitForWebElement(driver, "xpath", strChkBox_XPATH, 20);
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox_XPATH)));
					blnResult = common.clickChechBox(strChkBox_XPATH, testData.get("strChkstate"));
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strChkBox_XPATH))));
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
					break;

				case "EXPIRATIONDATE":
					setExpirationDateTxt(Integer.parseInt(testData.get("intPartyExpirationStart")),Integer.parseInt(testData.get("intPartyExpirationEnd")));
					break;

				case "IDVERIFYRDO":
					blnResult = common.selectRadiobutton(testData.get("strHasIDVerifiedRdoGrp"), testData.get("strIDVerifiedRdobtnValue"));	
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "FORMDOCUMENT":
					blnResult = common.selectRadiobutton(testData.get("strFormationDocIRS"), testData.get("strFormationDocIRSValue"));	
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "IDENTIFYDOC":
					blnResult = common.selectRadiobutton(testData.get("strIdentifyDoc"), testData.get("strIdentifyDocValue"));	
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform action on Employment Information in Primary Account Holder's Page.
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectPartyEmploymentInfoAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "EMPLOYMENTSTATUS":
					String strEmploymentStatusDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy", testData.get("strEmploymentStatusDrop"));
					blnResult = common.selectDropDownBox(strEmploymentStatusDrop_XPATH, testData.get("strPartyEmploymentStatusEle"),"");
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strEmploymentStatusDrop_XPATH))));
					common.waitforProcessing();
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "INDUSTRY":
					String strIndustryDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy", testData.get("strIndustryDrop"));
					blnResult = common.selectDropDownBox(strIndustryDrop_XPATH, testData.get("stPartyIndustryEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "OCCUPATION":
					String strOccupationDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strEmpInfosection")).replace("yyy", testData.get("strOccupationDrop"));
					blnResult = common.selectDropDownBox(strOccupationDrop_XPATH, testData.get("stPartyOccupationEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "EMPLOYEENAME":
					String strEmpNameTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy",testData.get("strEmpNameTxt"));
					blnResult = common.setValue(strEmpNameTxt_XPATH, testData.get("strPartyEmployeeNameValue"));
					break;

				case "COMPANYSTOCK":
					blnResult = common.selectRadiobutton(testData.get("strCompanyStock"), testData.get("strPartyCompanyStockValue"));	
					break;

				case "EMPLOYEECOUNTRY":
					String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strEmpInfosection")).replace("yyy", testData.get("strCountryDropComm"));
					blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, testData.get("strEmployeeCountryEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "EMPLOYEEADDRESS":
					String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx",testData.get("strEmpInfosection"));
					blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, testData.get("strEmpUSAddEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					common.waitforProcessing();
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform action on Employment Information in Primary Account Holder's Page.
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectPartyIndustryAffiliationAccHolderPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "AFFILIATIONTYPE":
					String strAffiliationtypeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy", testData.get("strAffiliationtypeDrop"));
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAffiliationtypeDrop_XPATH))));
					blnResult = common.selectDropDownBox(strAffiliationtypeDrop_XPATH, testData.get("strPartyAffiliationtype"),"");
					new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strAffiliationtypeDrop_XPATH))));
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);	
					break;

				case "ASSOFIRMNAME":
					String strFirmNameTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strAssoFirmNameTxt"));
					blnResult = common.setValue(strFirmNameTxt_XPATH, testData.get("strPartyAssoFirmNameValue"));
					break;

				case "ASSOCOUNTRY":
					String strCountryDropComm_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strCountryDropComm"));
					blnResult = common.selectDropDownBox(strCountryDropComm_XPATH, testData.get("strPartyAssoFirmCountryEle"),"");	
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "ASSOCOUNTRYADD":
					String strUSAddressDropComm_XPATH=strsearchUSAdd_XPATH.replace("xxx", testData.get("strIndustryAffiliationsection"));
					blnResult = common.selectDropDownBoxSendKeys(strUSAddressDropComm_XPATH, testData.get("strPartyAssoFirmUSAddEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "RELATIONASSOFIRM":
					String strRelationshipToAssoDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strIndustryAffiliationsection")).replace("yyy", testData.get("strRelationshipToAssoPersonDrop"));
					blnResult = common.selectDropDownBox(strRelationshipToAssoDrop_XPATH, testData.get("strPartyRelationshipToAsso"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "ASSOPERSONNAME":
					String strEmpNameTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strIndustryAffiliationsection")).replace("yyy",testData.get("strAssoPersonNameTxt"));
					blnResult = common.setValue(strEmpNameTxt_XPATH, testData.get("strPartyAssoPersonNameValue"));
					break;

				case "IMMEFAMILYMEM":
					blnResult = common.selectRadiobutton(testData.get("strImmFamilyMemRdoGrp"),testData.get("strPartyImmFamilyMemRdobtnValue"));		
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "PEPRDO":
					blnResult = common.selectRadiobutton(testData.get("strPEPRdoGrp"), testData.get("strPartyPEPRdobtnValue"));		
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;
					
				case "TRUSTEDCONTACT":
					blnResult = selectTrustedContact();
					break;

				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
					break;

				case "NEXT":
					blnResult=common.ClickOnBtn(testData.get("strNextBtnTxt"));
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
			return strResult=null;	
		}
		return strResult;
	}	
	
	/**
	 * This function is used to click on Trusted contact.
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 12/13/2017
	 * @param none
	 * @return boolean
	 **/
	public boolean  selectTrustedContact(){
		boolean blnResult = false;
		try{	
			//Added wait since page takes time to load
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			//Xpath for the Trusted Contact
			driver.findElement(By.xpath(strTrustedContactsXPATH)).click();
			//Added wait since page takes time to load
			LPLCoreSync.staticWait(lplCoreConstents.MediumInMiliSec);
			blnResult = true;

		}
		catch(Exception ex){
			strError = strError+ex.getMessage();

		}
		return blnResult;
	}
	
	
}

package PageObjectLibrary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.WebToolKit.WebTable;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> AccountOptionsPage.java</br>
 * <br><b> Description: </B> Field functions for Account Options Page</br>
 * <br><b>Usage:</br></b>
 * <br>selectAddMarginRdoGrp: This function is used to select Value for Add Margin to this Account Radio group.</br>
 * <br>selectAddStructuredProductRdoGrp: This function is used to select Value for Add Structured Product Trading to this Account Radio group.</br>
 * <br>selectReceiveDocumentsRdoGrp: This function is used to select Value for Receive Documents from the LPL Electronically Radio group.</br>
 * <br>selectReceiveProspectusesRdoGrp: This function is used to select Value for Receive Electronic Delivery of Eligible Prospectuses Radio group.</br>
 * <br>setEmailAddressTxt: This function is used to set Value of the Email Address text Field.</br>
 * <br>selectSuppressConfirmationRdoGrp: This function is used to select Value for Suppress Confirmation Radio group.</br>
 * <br>selectCompleteReviewChkBox: This function is used to select Completed Review Check box.</br>
 * <br>clickOnAddIRABeneficiary: This function is used to click on AddIRABeneficiary.</br>
 * <br>selectBeneficiaryType: This function is used to select the Beneficiary Type from the drop down.</br>
 * <br>selectRelationship: This function is used to select the Relationship Type from the drop down.</br>
 * <br>setPercentage: This function is used to set the Percentage Value in the TextField.</br>
 * <br>setEntityName: This function is used to set the EntityName in the TextField.</br>
 * <br>setTIN: This function is used to set Tin Value in the TextField.</br>
 * <br>setCustomCashTargetAmntTxt: This function is used to set Custom Cash Target Amount.</br>
 * <br>setAccountNumberTxt: This function is used to set Account Number Text Box Field.</br>
 * <br>setRepIDTxt: This function is used to set Rep Id Text Box Field.</br>
 * <br>setRegistrationTxt: This function is used to set registration Text Box Field.</br>
 * <br>VerifyAccountViewAccountOptionPagePage: This function is used to perform actions on e-delivery and account view section in account options  page.</br>
 * <br>CreateAccoViewProfileAccoOptionPagePage: To perform actions on creating an account view profile.</br>
 * <br>AddExistingOrCreateNewAccViewProfie: This function is used to perform actions on creating an Existing account view profile.</br>
 * <br>selectRelatedAccountsAccOptPage: This function is used to perform search action on Accounts section using different parameters in Account Option Page.</br>
 * <br>selectSearchRelatedAccounts: This function is used to validate values and columns of the search accounts in Account Option Page.</br>
 * <br>VerifyRelatedAccountsAccountOptionPage: This function is used to validate Fields of New related Accounts Table in Account Option page.</br>
 * <br>validateRelatedAccountsHeaders: This function is used to validate Headers of the Related Accounts table in Account Option Page.</br>
 * <br>searchRelatedTables: This function is used to select option from search results and verify the option in Related Accounts Table in Account Option page.</br>
 * @author Megha Megha,Jyothi Jyothi
 * @since 11-07-2016 
 * </p>
 */

public class AccountOptionsPage  extends LPLCoreDriver {

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;

	public LPLCoreConstents lplCoreConstents;

	/** Xpath property value of Dropdown List Object */
	public	String strToclickCommAcc_XPATH;

	/** Xpath property value of Review Check box Object */
	public String strCompletedReviewchk_XPATH;

	/** Xpath property value of Account view error msg Object */
	public String strAccViewErrMsg_XPATH ;

	/** Xpath property value of Add account view profile Object */
	public String strAddAccViewProfile_XPATH;

	/** Xpath property value of SSN validation Error MSg Object */
	public String strSSNErrorMsg_XPATH;

	/** Xpath property value of Email Address validation Error MSg Object */
	public String strEmailAddValidationErrorMsg_XPATH;

	/** Xpath property value of Edit Profile Object */
	public String strEditProfile_XPATH;

	/** Xpath property value of select object in table */
	public String strTableForSelect_XPATH;

	/** Xpath property value of Remove object */
	public String strRemove_XPATH;

	/** Xpath property value of Header panel Section of table object */
	public String strHeaderPanel_XPATH;

	/** Xpath property value of Control panel Section of table object */
	public String strControlPanel_XPATH;

	/** Xpath property value of Account Check Box Section of Related accounts table object */
	public String strAccountCHKBox_XPATH;

	/** Xpath property value of extended relation object */
	public String strExtRelation_XPATH;

	/** Xpath property value of Related Accounts Header object */
	public String strRelatedAccountsHeader_XPATH;

	/** Xpath property value of select button in Search accounts table object */
	public String strSelectOption_XPATH;

	/** Xpath property value of search value in Related accounts table object */
	public String strRelatedSearch_XPATH;

	/** Xpath property value of review check box object */
	public String strReviewchkbox_XPATH;

	public JavascriptExecutor jse;
	public int INT_PAGEID=116;
	public FinancialPage FinPage;
	public AccountHolderPage accholder;
	public NAOCommon common;
	public HomePage homePage;
	StartAccountOpeningPage startaccount;
	public  AccountOptionsPage(WebDriver driver){

		try {
			this.driver = driver;
			common = new NAOCommon(driver);
			startaccount = new StartAccountOpeningPage(driver);
			jse = (JavascriptExecutor)driver;
			lplCoreConstents = LPLCoreConstents.getInstance();
			FinPage = new FinancialPage(driver);
			accholder = new  AccountHolderPage(driver);
			homePage = new HomePage(driver);

			/** Fetching the page objects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
			if(PageObjectsMap.get("strToclickCommAcc").get("XPATH")!=null)
				strToclickCommAcc_XPATH = PageObjectsMap.get("strToclickCommAcc").get("XPATH");

			if(PageObjectsMap.get("strCompletedReviewchk").get("XPATH")!=null)
				strCompletedReviewchk_XPATH = PageObjectsMap.get("strCompletedReviewchk").get("XPATH");

			if(PageObjectsMap.get("strAccViewErrMsg").get("XPATH")!=null)
				strAccViewErrMsg_XPATH = PageObjectsMap.get("strAccViewErrMsg").get("XPATH");

			if(PageObjectsMap.get("strAddAccViewProfile").get("XPATH")!=null)
				strAddAccViewProfile_XPATH = PageObjectsMap.get("strAddAccViewProfile").get("XPATH");

			if(PageObjectsMap.get("strSSNErrorMsg").get("XPATH")!=null)
				strSSNErrorMsg_XPATH = PageObjectsMap.get("strSSNErrorMsg").get("XPATH");

			if(PageObjectsMap.get("strEmailAddValidationErrorMsg").get("XPATH")!=null)
				strEmailAddValidationErrorMsg_XPATH = PageObjectsMap.get("strEmailAddValidationErrorMsg").get("XPATH");

			if(PageObjectsMap.get("strEditProfile").get("XPATH")!=null)
				strEditProfile_XPATH = PageObjectsMap.get("strEditProfile").get("XPATH");

			if(PageObjectsMap.get("strTableForSelect").get("XPATH")!=null)
				strTableForSelect_XPATH = PageObjectsMap.get("strTableForSelect").get("XPATH");

			if(PageObjectsMap.get("strRemove").get("XPATH")!=null)
				strRemove_XPATH = PageObjectsMap.get("strRemove").get("XPATH");

			if(PageObjectsMap.get("strHeaderPanel").get("XPATH")!=null)
				strHeaderPanel_XPATH = PageObjectsMap.get("strHeaderPanel").get("XPATH");

			if(PageObjectsMap.get("strControlPanel").get("XPATH")!=null)
				strControlPanel_XPATH = PageObjectsMap.get("strControlPanel").get("XPATH");

			if(PageObjectsMap.get("strAccountCHKBox").get("XPATH")!=null)
				strAccountCHKBox_XPATH = PageObjectsMap.get("strAccountCHKBox").get("XPATH");

			if(PageObjectsMap.get("strExtRelation").get("XPATH")!=null)
				strExtRelation_XPATH = PageObjectsMap.get("strExtRelation").get("XPATH");

			if(PageObjectsMap.get("strRelatedAccountsHeader").get("XPATH")!=null)
				strRelatedAccountsHeader_XPATH = PageObjectsMap.get("strRelatedAccountsHeader").get("XPATH");

			if(PageObjectsMap.get("strSelectOption").get("XPATH")!=null)
				strSelectOption_XPATH = PageObjectsMap.get("strSelectOption").get("XPATH");

			if(PageObjectsMap.get("strRelatedSearch").get("XPATH")!=null)
				strRelatedSearch_XPATH = PageObjectsMap.get("strRelatedSearch").get("XPATH");

			if(PageObjectsMap.get("strReviewchkbox").get("XPATH")!=null)
				strReviewchkbox_XPATH = PageObjectsMap.get("strReviewchkbox").get("XPATH");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//*************************************Trading Options**************************************************************//

	/**
	 * This function is used to select Value for Add Margin to this Account Radio group
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAddMarginRdoGrp(String strAddMarginAccValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strAddMargin"), strAddMarginAccValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return blnResult;
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value for Add Structured Product Trading to this Account Radio group
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAddStructuredProductRdoGrp(String strAddStructuredProductValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strAddStructuredProduct"), strAddStructuredProductValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	//*************************************eDelivery**************************************************************//

	/**
	 * This function is used to select Value for Receive Documents from the LPL Electronically Radio group
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectReceiveDocumentsRdoGrp(String strReceiveDocumentstAccValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strReceiveDocumentsRdoGrp"), strReceiveDocumentstAccValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value for Receive Electronic Delivery of Eligible Prospectuses Radio group
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectReceiveProspectusesRdoGrp(String strReceiveProspectusesValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strReceiveProspectusesRdoGrp"), strReceiveProspectusesValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value of the Email Address text Field
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setEmailAddressTxt(String strEmailAddrValue ){
		boolean blnResult = false;
		try{	
			String strEmailAddr_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("	streDeliverySection")).replace("yyy",testData.get("strEmailAddr"));
			blnResult = common.setValue(strEmailAddr_XPATH, strEmailAddrValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value for Suppress Confirmation Radio group
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectSuppressConfirmationRdoGrp(String strSuppressConfirmationValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strSuppressConfirmationRdoGrp"), strSuppressConfirmationValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Completed Review Check box
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean selectCompleteReviewChkBox(String strChkState){
		boolean blnResult = false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(5);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strReviewchkbox_XPATH)));
			blnResult = common.clickChechBox(strReviewchkbox_XPATH,strChkState);
			common.waitforProcessing();
			common.waitforProcessing();
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Add IRA Beneficiary
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean clickOnAddIRABeneficiary(String addBeneficiary)
	{
		boolean blnResult= false;
		try{
			blnResult=common.ClickOnPlus(addBeneficiary);
		}catch(Exception ex)
		{
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select the Beneficiary Type from the drop down
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean selectBeneficiaryType(String strSection, String strBeneficiaryTypeValue)
	{
		boolean blnResult=false;
		try{
			String strBeneficiaryType_Xpath=accholder.strToclickCommAcc_XPATH.replace("xxx",strSection).replace("yyy", testData.get("strBeneficiaryType"));
			blnResult = common.selectDropDownBox(strBeneficiaryType_Xpath, strBeneficiaryTypeValue,"");
			common.waitforProcessing();
		}catch(Exception ex)
		{
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select the Relationship Type from the drop down 
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean  selectRelationship(String strSection, String strRelationshipValue ){
		boolean blnResult = false;
		try{
			String strRelationship_Xpath=strToclickCommAcc_XPATH.replace("xxx",strSection).replace("yyy", testData.get("strRelationship"));
			blnResult =common.selectDropDownBox(strRelationship_Xpath, strRelationshipValue,"");
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set the Percentage Value in the TextField
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean setPercentage(String strSection,String percentage)
	{
		boolean blnResult = false;
		try{
			common.waitforProcessing();
			String strPercentage_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strSection).replace("yyy",testData.get("strPercentageTxt"));
			blnResult = common.setValue(strPercentage_XPATH, percentage);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set the EntityNamein the TextField
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean setEntityName(String strSection,String strEntityName)
	{
		boolean blnResult = false;
		try{				
			String strEntityName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strSection).replace("yyy",testData.get("strEntityName"));
			blnResult = common.setValue(strEntityName_XPATH, strEntityName);
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Tin Value in the TextField
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String,String
	 * @return boolean
	 **/
	public boolean setTIN(String strSection,String TIN)
	{
		boolean blnResult = false;
		try{				
			String strTIN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",strSection).replace("yyy",testData.get("	strTINTxt"));
			blnResult = common.setValue(strTIN_XPATH, TIN);
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**************************************Advisory Options****************************************************************/

	/**
	 * This function is used to set Custom Cash Target Amount
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean setCustomCashTargetAmntTxt(String strCustomcashTargetAmntValue)
	{
		boolean blnResult = false;
		try{				
			String strCustomcashTargetAmnt_XPATH=FinPage.strTxtBoxCommon_XPATH.replace("yyy",testData.get("strCustomcashTargetAmntTxt"));
			blnResult = common.setValue(strCustomcashTargetAmnt_XPATH, strCustomcashTargetAmntValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Account Number Text Box Field
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setAccountNumberTxt(String strAccountNumberValue ){
		boolean blnResult = false;
		try{   
			String strAccountNumber_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strAdvisoryOptionSection")).replace("yyy",testData.get("strAccountNumberTxt"));
			blnResult = common.setValue(strAccountNumber_XPATH, strAccountNumberValue);
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Rep Id Text Box Field
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setRepIDTxt(String strRepIDValue ){
		boolean blnResult = false;
		try{   
			String strRepID_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strAdvisoryOptionSection")).replace("yyy",testData.get("strRepIDDrop"));
			blnResult = common.setValue(strRepID_XPATH, strRepIDValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set registration Text Box Field
	 *
	 * @author Megha Megha
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setRegistrationTxt(String strRegistrationValue ){
		boolean blnResult = false;
		try{   
			String strRepID_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strAdvisoryOptionSection")).replace("yyy",testData.get("strRegistrationTxt"));
			blnResult = common.setValue(strRepID_XPATH, strRegistrationValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to perform actions on e-delivery and account view section in account options  page
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String[],String...
	 * @return String
	 **/
	public String  VerifyAccountViewAccountOptionPagePage(String[] strAccOptionPage,String... strAccountOptionPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strAccountOptionPagePanels){
				switch(strPanel.toUpperCase()){

				case "ACCOUNTVIEWRDO":
					blnResult=common.selectRadiobutton(strAccOptionPage[0], strAccOptionPage[1]);
					break;

				case "VERIFYERRORMSG":
					common.ClickOnBtn(testData.get("strValidateBtnTxt"));
					if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strAccViewErrMsg_XPATH), LPLCoreConstents.getInstance().LOW)){
						blnResult =common.selectRadiobutton(testData.get("strReceiveDocumentsRdoGrp"), strAccOptionPage[2]);
						blnResult =common.selectRadiobutton(testData.get("strReceiveProspectusesRdoGrp"), strAccOptionPage[3]);
						common.ClickOnBtn(testData.get("strValidateBtnTxt"));
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
		}catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			blnResult= false;
			strResult=null;
		}
		return strResult;
	}

	/**
	 * This function is used to perform actions on creating an account view profile
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String[],String...
	 * @return String
	 **/
	public String  CreateAccoViewProfileAccoOptionPagePage(String[] strAccOptionPage,String... strAccountOptionPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strAccountOptionPagePanels){
				switch(strPanel.toUpperCase()){

				case "VERIFYACCVIEW":
					if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(common.strRdoBtn_XPATH.replace("xxx", testData.get("strEnableAccViewForThisAcc")).replace("yyy", testData.get("strEnableAccViewForThisAccValue"))), LPLCoreConstents.getInstance().LOW)){
						blnResult =common.selectRadiobutton(strAccOptionPage[0], strAccOptionPage[1]);

						//Click on add account view profile
						//wait for object to load
						LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strAddAccViewProfile_XPATH)));
						LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strAddAccViewProfile_XPATH), LPLCoreConstents.getInstance().LOW);
						driver.findElement(By.xpath(strAddAccViewProfile_XPATH)).click();

						//wait for page to load
						LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);

						//click on Create new Profile
						blnResult =common.ClickOnBtn(strAccOptionPage[2]);
					}
					break;

				case "FIRSTNAME":
					String strFirstName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strClientSection")).replace("yyy",testData.get("strFirstName"));
					blnResult=common.setValue(strFirstName_XPATH, common.generateRandomAlphabets());
					break;

				case "MIDDLENAME":
					String strMiddleName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strClientSection")).replace("yyy",testData.get("strMiddleName"));
					blnResult=common.setValue(strMiddleName_XPATH, common.generateRandomAlphabets());
					break;

				case "LASTNAME":
					String strLastName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strClientSection")).replace("yyy",testData.get("strLastName"));
					blnResult=common.setValue(strLastName_XPATH, common.generateRandomAlphabets());
					break;

				case "SSN":
					int i=1;
					for(i=1;i<=5;i++){
						strResult=startaccount.generateRandomNumber();
						String strSSN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strClientSection")).replace("yyy",testData.get("strSSN"));
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strSSN_XPATH)));
						LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strSSN_XPATH),LPLCoreConstents.getInstance().LOW);
						blnResult = common.setValue(strSSN_XPATH, strResult);	
						common.ClickOnBtn(testData.get("strValidateBtnTxt"));
						try{
							if(!LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strSSNErrorMsg_XPATH),LPLCoreConstents.getInstance().LOW)){
								break;
							}
							else{
								i++;
							}
						}
						catch(Exception ex){
							strError = strError+ex.getMessage();
							ex.printStackTrace();
							return null;
						}
					}
					break;

				case "EMAIL":
					int j=1;
					for(j=1;j<=5;j++){
						strResult=startaccount.generateRandomEmail(testData.get("strUserName"),testData.get("strAddress"));
						String strEmailAddr_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strEmailAndUNSection")).replace("yyy",testData.get("strEmailAddr"));
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strEmailAddr_XPATH)));
						LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strEmailAddr_XPATH),LPLCoreConstents.getInstance().LOW);
						blnResult = common.setValue(strEmailAddr_XPATH, strResult);
						common.ClickOnBtn(testData.get("strValidateBtnTxt"));
						try{
							if(!LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strEmailAddValidationErrorMsg_XPATH),LPLCoreConstents.getInstance().LOW)){
								break;
							}
							else{
								j++;
							}
						}
						catch(Exception ex){
							strError = strError+ex.getMessage();
							ex.printStackTrace();
							return null;
						}
					}
					break;

				case "EMAILUNCHECK":
					String strChkBox_XPATH=accholder.strCommonChk_XPATH.replace("xxx",testData.get("strEmailAddAsUserName"));
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox_XPATH)));
					blnResult = common.clickChechBox(strChkBox_XPATH, strAccOptionPage[3]);
					//wait for object to load
					LPLCoreSync.staticWait(lplCoreConstents.UNITINMILLISEC);
					break;

				case "VERIFYEDITPROFILE":
					blnResult =common.ClickOnBtn(testData.get("strNextBtnTxt"));
					//wait for object to load
					LPLCoreSync.staticWait(lplCoreConstents.UNITINMILLISEC);
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strEditProfile_XPATH)));
					if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strEditProfile_XPATH),LPLCoreConstents.getInstance().LOW)){
						blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
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
			blnResult= false;
			strResult=null;
		}
		return strResult;
	}

	/**
	 * This function is used to perform actions on creating an Existing account view profile
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String[],String...
	 * @return String
	 **/
	public String  AddExistingOrCreateNewAccViewProfie(String[] strAccOptionPage,String... strAccountOptionPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strAccountOptionPagePanels){
				String strAccViewFlag=strAccOptionPage[0];
				switch(strPanel.toUpperCase()){


				case "VERIFYACCVIEW":
					if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(common.strRdoBtn_XPATH.replace("xxx", testData.get("strEnableAccViewForThisAcc")).replace("yyy", testData.get("strEnableAccViewForThisAccValue"))), LPLCoreConstents.getInstance().LOW)){
						blnResult =common.selectRadiobutton(strAccOptionPage[1], strAccOptionPage[2]);

						//Click on add account view profile
						//wait for object to load
						LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strAddAccViewProfile_XPATH)));
						LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strAddAccViewProfile_XPATH), LPLCoreConstents.getInstance().LOW);
						driver.findElement(By.xpath(strAddAccViewProfile_XPATH)).click();

						//wait for page to load
						LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);

						if(strAccViewFlag.equalsIgnoreCase("Y")){
							break;
						}
						else{
							//click on Create new Profile
							blnResult =common.ClickOnBtn(strAccOptionPage[3]);
						}
					}
					break;

				case "FIRSTNAME":
					String strFirstName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strClientSection")).replace("yyy",testData.get("strFirstName"));
					blnResult=common.setValue(strFirstName_XPATH, common.generateRandomAlphabets());
					break;

				case "MIDDLENAME":
					String strMiddleName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strClientSection")).replace("yyy",testData.get("strMiddleName"));
					blnResult=common.setValue(strMiddleName_XPATH, common.generateRandomAlphabets());
					break;

				case "LASTNAME":
					String strLastName_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strClientSection")).replace("yyy",testData.get("strLastName"));
					blnResult=common.setValue(strLastName_XPATH, common.generateRandomAlphabets());
					break;

				case "SSN":
					int i=1;	
					if(strAccViewFlag.equalsIgnoreCase("Y")){
						String strSSN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strSearchExistingProfile")).replace("yyy",testData.get("strSSN"));	
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strSSN_XPATH)));

						//clear the data in the SSN field and enter new data(Existing Account view SSN )
						LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strSSN_XPATH),LPLCoreConstents.getInstance().LOW);
						blnResult = common.setValue(strSSN_XPATH, testData.get("strExixtingSSNNum"));

						//Click on Search button
						blnResult = common.ClickOnPlus(testData.get("strSearchBtnTxt"));

						//wait for objects to load
						LPLCoreSync.staticWait(lplCoreConstents.LOWESTInMiliSec);
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strTableForSelect_XPATH)));
						LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strTableForSelect_XPATH),LPLCoreConstents.getInstance().LOW);
						driver.findElement(By.xpath(strTableForSelect_XPATH)).click();
					}
					else{
						for(i=1;i<=5;i++){
							//get random SSN Number
							strResult=startaccount.generateRandomNumber();
							String strSSN_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strClientSection")).replace("yyy",testData.get("strSSN"));
							jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strSSN_XPATH)));
							LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strSSN_XPATH),LPLCoreConstents.getInstance().LOW);
							blnResult = common.setValue(strSSN_XPATH, strResult);	
							common.ClickOnBtn(testData.get("strValidateBtnTxt"));
							try{
								if(!LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strSSNErrorMsg_XPATH),LPLCoreConstents.getInstance().LOW)){
									break;
								}
								else{
									i++;
								}
							}
							catch(Exception ex){
								strError = strError+ex.getMessage();
								ex.printStackTrace();
								return null;
							}
						}
					}
					break;

				case "EMAIL":
					int j=1;

					//clear the email address in the email field
					if(strAccViewFlag.equalsIgnoreCase("Y")){
						String strEmailAddr_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strSearchExistingProfile")).replace("yyy",testData.get("strEmailAddr"));
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strEmailAddr_XPATH)));
						LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strEmailAddr_XPATH),LPLCoreConstents.getInstance().LOW);
						blnResult = common.setValue(strEmailAddr_XPATH, "");
					}
					else{
						for(j=1;j<=5;j++){

							//get random email id
							strResult=startaccount.generateRandomEmail(testData.get("strUserName"),testData.get("strAddress"));
							String strEmailAddr_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strEmailAndUNSection")).replace("yyy",testData.get("strEmailAddr"));
							jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strEmailAddr_XPATH)));
							LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strEmailAddr_XPATH),LPLCoreConstents.getInstance().LOW);
							blnResult = common.setValue(strEmailAddr_XPATH, strResult);
							common.ClickOnBtn(testData.get("strValidateBtnTxt"));
							//chceck email validation error is displayed or not
							try{
								if(!LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strEmailAddValidationErrorMsg_XPATH),LPLCoreConstents.getInstance().LOW)){
									break;
								}
								//if email validation error is displayed generate new email id and check error
								else{
									j++;
								}
							}
							catch(Exception ex){
								strError = strError+ex.getMessage();
								ex.printStackTrace();
								return null;
							}
						}
					}
					break;

				case "EMAILUNCHECK":
					String strChkBox_XPATH=accholder.strCommonChk_XPATH.replace("xxx",testData.get("strEmailAddAsUserName"));
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox_XPATH)));
					blnResult = common.clickChechBox(strChkBox_XPATH, strAccOptionPage[4]);
					//wait for object to load
					LPLCoreSync.staticWait(lplCoreConstents.UNITINMILLISEC);
					break;

				case "VERIFYEDITPROFILE":

					if(strAccViewFlag.equalsIgnoreCase("Y")){
						if(!LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strEditProfile_XPATH),LPLCoreConstents.getInstance().LOW)){
							if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strRemove_XPATH),LPLCoreConstents.getInstance().LOW)){
								blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
							}
						}
					}
					else{
						blnResult =common.ClickOnBtn(testData.get("strNextBtnTxt"));
						//wait for object to load
						LPLCoreSync.staticWait(lplCoreConstents.UNITINMILLISEC);
						jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strEditProfile_XPATH)));
						if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strEditProfile_XPATH),LPLCoreConstents.getInstance().LOW)){
							if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strRemove_XPATH),LPLCoreConstents.getInstance().LOW)){
								blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
							}			
						}
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
			blnResult= false;
			strResult=null;
		}
		return strResult;
	}

	/**
	 * This function is used to perform search action on Accounts section using different parameters in Account Option Page.
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectRelatedAccountsAccOptPage(String... strStartAccountPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strStartAccountPagePanels){
				switch(strPanel.toUpperCase()){	
				case "SEARCHBYTXT":
					//wait for object to load
					LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					String strSearchTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strSearchAccountsSection")).replace("yyy",testData.get("strSearchBySection"));
					blnResult=common.setValue(strSearchTxt_XPATH, testData.get("strSearchByVal"));
					break;

				case "SEARCHBYDRPDOWN":
					//wait for object to load
					LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					String strIndustryDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strSearchAccountsSection")).replace("yyy", testData.get("strSearchByDrpDwn"));
					blnResult = common.selectDropDownBox(strIndustryDrop_XPATH, testData.get("strSearchByDrpVal"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "SEARCHBTN":
					blnResult=common.ClickOnBtn(testData.get("strSearchBtnTxt"));
					break;

				case "ACCOUNTVALCHKBOX":
					//wait for object to load
					LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					String strAccountvalChkBox_XPATH=startaccount.strClientBestInterestCommon_XPATH.replace("xxx", testData.get("strAccountValChkBox"));
					blnResult=startaccount.selectBestInterestRationaleRdoGrp(strAccountvalChkBox_XPATH);
					break;

				case "VALACCVALCHKBOX":
					//wait for object to load
					LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					WebElement strChkBox_XPATH = driver.findElement(By.xpath(strAccountCHKBox_XPATH));
					if(strChkBox_XPATH.isSelected()){
						blnResult = true;
						System.out.println("Account Check Box is selected");
					}
					else
						blnResult = false;
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
	 * This function is used to validate values and columns of the search accounts in Account Option Page.
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public boolean selectSearchRelatedAccounts()
	{
		boolean blnResult = false;
		try {
			//Wait for the page to load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			int counter =0;
			HashMap<String, Integer> colNumDictionary = new HashMap<String, Integer>();
			WebElement firstRow = driver.findElement(By.xpath(strHeaderPanel_XPATH));
			List<WebElement> headers = firstRow.findElements(By.tagName("td"));

			for (WebElement thisHeader : headers) {
				String strheaderName = thisHeader.findElement(By.tagName("div")).getText();
				if(strheaderName.contains("'")){
					strheaderName = strheaderName.replace("'", "");
				}
				counter = counter+1;
				colNumDictionary.put(strheaderName, counter);
			}

			//Wait for the page to load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			WebElement objWebTable = driver.findElement(By.xpath(strControlPanel_XPATH));
			WebTable wt = new WebTable(null, By.tagName("tr"), By.tagName("td"));
			List<WebElement> contentRows = objWebTable.findElements(By.tagName("tr"));

			//Wait for the page to load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			for(int i = 0 ; i<contentRows.size();i++){
				String strAcctName = wt.getCellValue(objWebTable, i, colNumDictionary.get(testData.get("strSearchType")));
				System.out.println(colNumDictionary);
				System.out.println(strAcctName);
				if(testData.get("strSearchType").equals("Account Value"))
				{
					double strAcc = Double.parseDouble(strAcctName);
					if(testData.get("strSearchTypeVal").equals("zero")){
						if(strAcc == 0 || strAcc > 0 || strAcc < 0)
							blnResult = true;
					}
					else{
						if(strAcc > 0 || strAcc < 0)
							blnResult = true;
					}
				}
				else{
					if(strAcctName.toLowerCase().contains(testData.get("strSearchTypeVal")))
						blnResult= true;
					else
						blnResult= false;
				}
			}
		} catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to validate Fields of New related Accounts Table in Account Option page.
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  VerifyRelatedAccountsAccountOptionPage(String... strAccountOptionPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strAccountOptionPagePanels){
				switch(strPanel.toUpperCase()){
				case "RELATEDACCOUNTSHEADER":
					String strPlusSign_XPATH =common.strPlusCommn_XPATH.replace("xxx",testData.get("strRltdAccHeader"));
					if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strPlusSign_XPATH), LPLCoreConstents.getInstance().LOW)){
						blnResult = true;
					}
					break;

				case "SELECTRELATEDACCOUNTSTEXT":
					String strClick_XPATH = accholder.strClickAddBO_XPATH.replace("xxx",testData.get("strSelectAccTxt"));
					if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strClick_XPATH), LPLCoreConstents.getInstance().LOW)){
						blnResult = true;
					}
					break;

				case "SEARCHACCOUNTSDRPDWNFIELDS":
					String strSearchDrpVal[] =testData.get("strSearchByDrpDwn").split(",");
					for(String strSearchVal:strSearchDrpVal){
						String strDropDown_XPATH=strToclickCommAcc_XPATH.replace("xxx",testData.get("strSearchAccountsSection")).replace("yyy", strSearchVal);
						if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strDropDown_XPATH), LPLCoreConstents.getInstance().LOW)){
							blnResult = true;
						}
					}
					break;

				case "SEARCHACCOUNTSTXTFIELDS":
					String strSearchDrpVal1[] =testData.get("strSearchBySection").split(",");
					for(String strSearchVal:strSearchDrpVal1){
						String strSearchTxt_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strSearchAccountsSection")).replace("yyy",strSearchVal);
						if(LPLCoreSync.waitTillVisible(driver, org.openqa.selenium.By.xpath(strSearchTxt_XPATH), LPLCoreConstents.getInstance().LOW)){
							blnResult = true;
						}
					}
					break;

				case "NAVIGATIONBTNS":
					String strNavBtn[] = testData.get("strNavButtons").split(","); 
					for (String strSearchFields : strNavBtn) {
						WebElement SearchField = driver.findElement(ByAngular.buttonText(strSearchFields));
						if(SearchField.isDisplayed())
							blnResult = true;
					}
					break;

				case "SHOWEXTNDRLT":
					//Wait for the page to load
					LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
					WebElement strExtendedRel = driver.findElement(By.xpath(strExtRelation_XPATH));
					strExtendedRel.click();
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
			blnResult= false;
			strResult=null;
		}
		return strResult;
	}

	/**
	 * This function is used to validate Headers of the Related Accounts table in Account Option Page.
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public boolean validateRelatedAccountsHeaders(String... arrExpectedHeaders)
	{
		boolean blnResult = false;
		try {
			//Wait for the page to load
			LPLCoreSync.staticWait(lplCoreConstents.BaseInMiliSec);
			WebElement htmltable = driver.findElement(By.xpath(strRelatedAccountsHeader_XPATH));
			List<WebElement> headers = htmltable.findElements(By.tagName("span"));
			List<String> actualVal = new ArrayList<String>();

			for (WebElement headerVal : headers) {
				String headerVal2 = headerVal.getText();
				actualVal.add(headerVal2);
			}

			List<String> expectedVal = new ArrayList<String>();
			String[] arrExpectedHeader = testData.get("strTableHeader").split(",");
			for (String eachExpectedHeader : arrExpectedHeader){
				expectedVal.add(eachExpectedHeader);
			}

			System.out.println(actualVal);
			System.out.println(expectedVal);
			if (actualVal.equals(expectedVal)){
				blnResult = true;
				System.out.println("Values are equal");
			}
			else
				blnResult = false;
		}catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select option from search results and verify the option in Related Accounts Table in Account Option page.
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String searchRelatedTables(String... strRelatedAccounts){
		boolean blnResult = false;
		String strResult= null;
		try{
			for(String strPanel:strRelatedAccounts){
				switch(strPanel.toUpperCase()){
				case "SELECTVALUE":
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
					jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strSelectOption_XPATH)));
					driver.findElement(By.xpath(strSelectOption_XPATH)).click();
					blnResult = true;
					break;

				case "SEARCHVALUE":
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
					List<WebElement> SearchVal = driver.findElements(By.xpath(strRelatedSearch_XPATH));
					for (WebElement webElement : SearchVal) {
						String strVal = webElement.getText();
						System.out.println(strVal);
						if(strVal.equals(testData.get("strSearchByVal"))){
							blnResult = true;
							break;
						}
						else{
							blnResult = false;
						}
					}
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

		}  catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			blnResult= false;
			strResult=null;
		}
		return strResult;
	}
}


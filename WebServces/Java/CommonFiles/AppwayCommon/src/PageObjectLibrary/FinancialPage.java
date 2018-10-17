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
import LPLCoreDriver.LPLCoreSync;

/**
 * <p>
 * <br><b> Title: </b> FinancialPage.java</br>
 * <br><b> Description: </B> Field functions for Financial Page.</br>
 * <br><b>Usage:</br></b> 
 * <br>selectInstitutionalAccountFinraRdoGrp: This function is used to select Value for Institutional Account Finra Radio group.</br>
 * <br>selectIsThisAccGovtEntityRdoGrp: This function is used to select Value for Is this account for a Govt Entity Radio group.</br>
 * <br>selectSignificantResponsibilityRdoGrp: This function is used to  select Value from significant responsibility for managing the entity employed in any of the following activities radio group.<br>
 * <br>selectProvideSuitabililtyCertRdoGrp: This function is used to select Value for Provide Suitability Certification Radio group.</br>
 * <br>selectInvestmentObjectiveLst: This function is used to Click on Investment Objective DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectAnnualIncomeLst: This function is used to Click on Annual Income DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectTaxBracketLst: This function is used to Click on Tax Bracket DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectNetWorthLst: This function is used to Click on Net Worth DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectLiquidNetWorthLst: This function is used to Click on Liquid Net Worth DropDown Field and to select Element from the Drop Down</br>
 * <br>selectApproximateAccValueLst: This function is used to Click on Approximate Account Value DropDown Field and to select Element from the Drop Down.</br>
 * <br>setApproximateAccountValueTxt: This function is used to set Value for Approximate Account TextBox Value.</br>
 * <br>selectSourceOfWealthAndIncomeLst: This function is used to Click on Source Of Wealth And Income  DropDown Field and to select Element from the Drop Down.</br>
 * <br>setSuitabilityOtherTxt: This function is used to set Value for Others.</br>
 * <br>selectClientOtherInvestmentRdoGrp: This function is used to select Value Client have other investment Radio group.</br>
 * <br>setCheckingTxt: This function is used to set Value for Checking/Savings.</br>
 * <br>setMutualFundsTxt: This function is used to set Value for Mutual Funds.</br>
 * <br>setEquitiesTxt: This function is used to set Value for Equities/Stocks.</br>
 * <br>setBondsTxt: This function is used to set Value for Bonds.</br>
 * <br>setInsuranceTxt: This function is used to set Value for Insurance.</br>
 * <br>setAnnuitiesTxt: This function is used to set Value for Annuities.</br>
 * <br>setRealEstateTxt: This function is used to set Value for Real Estate.</br>
 * <br>setAlternativeInvestmentTxt: This function is used to set Value for Alternative Investments.</br>
 * <br>setOtherTxt: This function is used to set Value for Other.</br>
 * <br>setIfOtherPlTxt:  This function is used to set Value for If Other.</br>
 * <br>selectTimeHorizonLst: This function is used to Click on Clients Time Horizon DropDown Field and to select Element from the Drop Down  Investment Horizon and Liquidity Needs.</br>
 * <br>selectLiquidityNeedsFromFundsRdoGrp: This function is used to select Value for Liquidity Needs From Funds Radio group.</br>
 * <br>selectFundsNeededInLst: This function is used to Click on Funds Needed In Field and to select Element from the Drop Down.</br>
 * <br>setApproximateAmtNeededTxt: This function is used to set Value for Approximate Amount Needed in Specified Time Range.</br>
 * <br>selectPriorInvesmentExpRdoGrp: This function is used to select Value for Client Have any Prior Investment Experience Radio group.</br>
 * <br>setExpAnnuitiesTxt: This function is used to set Value for Annuities for Investment Experience.</br>
 * <br>setExpMutualFundsTxt: This function is used to set Value for Mutual Funds Investment Experience.</br>
 * <br>setExpPartnershipsTxt: This function is used to set Value for Partnerships Investment Experience.</br>
 * <br>setExpMarginTxt: This function is used to set Value for Margin Investment Experience.</br>
 * <br>setExpStocksTxt: This function is used to set Value for Stocks Investment Experience.</br>
 * <br>setExpBondsTxt: This function is used to set Value for Bonds Investment Experience.</br>
 * <br>setExpOptionsTxt: This function is used to set Value for Options Investment Experience.</br>
 * <br>setExpOtherTxt: This function is used to set Value for Other Investment Experience.</br>
 * <br>setExpIfOtherPlTxt: This function is used to set Value for If other Please Investment Experience.</br>
 * <br>selectHowLongClientInvestingLst: This function is used to Click on Funds Needed In Field and to select Element from the Drop Down.</br>
 * <br>selectCostBasisOnLPLRdoGrp: This function is used to select Value for Client Want Cost Basis Reporting on LPL Radio group.</br>
 * <br>selectLotReliefMethodLst: This function is used to Click on Lot Relief Method and to select Element from the Drop Down.</br>
 * <br>selectMFAvgCostLst: This function is used to Click on MF Average Cost and to select Element from the Drop Down.</br>
 * <br>selectDRPAvgCostLst: This function is used to Click on DRP Average Cost and to select Element from the Drop Down.</br>
 * <br>selectMoneyMarketFundSweepLst: This function is used to Click on Money Market Funds Sweep and to select Element from the Drop Down.</br>
 * <br>selectDistributionElectionLst: This function is used to Click on Distribution Election and to select Element from the Drop Down.</br>
 * <br>selectRebalancingFrequencyLst: This function is used to Click on Rebalancing Frequency and to select Element from the Drop Down.</br>
 * <br>clickInvstTechChkBox: This function is used to check and uncheck the check boxes of investment tech.</br>
 * <br>setInvstTechOtherTxt: This function is used to set Value for Others.</br>
 * <br>selectPortfolioSelectionLst: This function is used to Click on Portfolio Selection  and to select Element from the Drop Down.</br>
 * <br>selectShareClassSelectionLst: This function is used to Click on Share Selection  and to select Element from the Drop Down.</br>
 * <br>selectStrategistAllocationLst: This function is used to Click on Strategist Allocation DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectPortfolioTableLst: This function is used to select multiple dropdown from the table.</br>
 * <br>selectManagerFundETFTableLst: This function is used to select multiple dropdown from the table.</br>
 * <br>selectPortFolioManagerTableLst: This function is used to select multiple dropdown from the table.</br>
 * <br>selectModelLst: This function is used to Click on Model List DropDown Field and to select Element from the Drop Down.</br>
 * <br>selectInvestmentOptionLst: This function is used to Select Investment Options.</br>
 * <br>selectAdvisoryFeeTypeLst: This function is used to Click on Advisory fee Type  and to select Element from the Drop Down.</br>
 * <br>selectBillingLst: This function is used to Click on Billing  and to select Element from the Drop Down.</br>
 * <br>selectFeeAndStatementLst: This function is used to Click on Fee and Statement Cycle Dropdown and to select Element from the Drop Down.</br>
 * <br>selectTieredBillingLst: This function is used to Click on  Tiered Billing Dropdown and to select Element from the Drop Down.</br>
 * <br>setFlatFee: This function is used to set the FlatFee Value.</br>
 * <br>selectApplyCustomCashRdoGrp: This function is used to select the Radio Button for the ApplyCustomCash.</br>
 * <br>selectTradingOptionsRdoGrp: This function is used to Select Trading Options Radio Button.</br>
 * <br>selectSuspendTradingRdoGrp: This function is used to select Value from Suspend Trading Radio group.</br>
 * <br>setCustomCashAmount: This function is used to set the value for the Custom Cash Amount.</br>
 * <br>selectCommisionOnTradeRdoGrp: This function is used to select Value for Commission On Trade  Radio group.</br>
 * <br>clickAddCommissionBtn: This function is used to click on the  AddCommission Button.</br>
 * <br>setSymbolCUSIPTxt: This function is used to set the value for the SymbolCUSIP.</br>
 * <br>setPurchaseDateTxt: This function is used to set the value for the PurchaseDate.</br>
 * <br>setDateCharacteristics: This function is used to set Date Characteristics.</br>
 * <br>setPurchaseAmntTxt: This function is used to set the value for the Purchased Amount.</br>
 * <br>setCommissionTxt: This function is used to set the value for the Commission.</br>
 * <br>setClassTxt: This function is used to set the value for the Class.</br>
 * <br>clickMutualFundChk: This function is used to select the checkbox on MutualFund.</br>
 * <br>setAdvisorFee: This function is used to set Value to the AdvisorFee text Field.</br>
 * <br>selectDollarRangeLst: This function is used to Click on  Tiered Billing Dropdown and to select Element from the Drop Down.</br>
 * <br>selectWireTransferLst: This function is used to Click on  WireTransfers Dropdown and to select Element from the Drop Down.</br>
 * <br>selectEnableMoneyMarketFundSweepRdoGrp: This function is used to select Value for Enable Money Market Fund Sweep Radio Group.</br>
 * <br>selectTransactionPerMonthRdoGrp: This function is used to select Radio Button  value from  TransactionPerMonth Group.</br>
 * <br>selectJournalsPerMonthRdoGrp: This function is used to select Radio Button Value  from  JournalsPerMonth Group.</br>
 * <br>selectScheduleAgreeToAnRdoGrp: This function is used to select Radio Button from Schedule A Agreed To On.</br>
 * <br>selectRegulatoryQuestionsFinancialPage: This function is used to perform actions on Regulatory Questions section In Financial Page.</br>
 * <br>selectSuitabilityFinancialPage: This function is used to perform actions on Suitability section In Financial Page.</br>
 * <br>selectInvestmentExperiencePage: This function is used to perform actions on Investment Experience section In Financial Page.</br>
 * <br>selectInvestmentTechniquesPage: This function is used to perform actions on Investment Techniques from the check boxes.</br>
 * <br>selectInvestmentHorizonandLiquidityNeedsPage: This function is used to perform actions on Investment Horizon and Liquidity Needs section In Financial Page.</br>
 * <br>selectAccountInformationandSettingsPage: This function is used to perform actions on Account Information and Settings section in Financial Page. </br>
 * <br>selectFinancialInformationPage: This function is used to perform actions on Financial Information section in Financial Page. </br>
 * <br>selectTAMPTPIAConsultingFeePage: This function is used to perform actions on TAMP/TPIA Consulting fee field section In Financial Page.</br>
 * <br>selectSponsorDirectedPlnPage: This function is used to perform actions on Sponsor Directed Plan Account field section In Financial Page.</br>
 * @author Megha Megha,Jyothi Jyothi
 * @since 10-19-2016 
 * </p>
 */


public class FinancialPage extends LPLCoreDriver {

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type...To be used to capture any error occurred at runtime. */
	public String strError;

	public LPLCoreConstents lplCoreConstents;

	/** Xpath property value of Dropdown Box Object */
	public	String strToclickCommAcc_XPATH;

	/** Xpath property value of Dropdown Box Object */
	public String strToclickComm_XPATH;

	/** Xpath property value of Text Box Object */
	public String strIndPerTxtBox_XPATH;

	/** Xpath property value of Check Box Object */
	public String strInvstTechStrategiesChk_XPATH;

	/** Xpath property value of List of Elements in the dropdown Object */
	public String strListOfEle_XPATH;

	/** Xpath property value of if Other text box */
	public String strifOtherPl;

	/** Xpath property value of InvstTechOther text Box Object */
	public String strInvstTechOtherTxt_XPATH;

	/** Xpath property value of SuitabilityOtherTxt Box Object */
	public String strSuitabilityOtherTxt_XPATH;

	/** Xpath property value of IndicateExpTxt Box Object */
	public String strIndicateExpTxtBox_XPATH;

	/** Xpath property value of OtherTxt Box Object */
	public String strOtherTxtBox_XPATH;

	/** Xpath property value of AddCommision Plus sign Object */
	public String strAddCommision_XPATH;

	/** Xpath property value of PlusCommn plus sign Object */
	public String strPlusCommn_XPATH;

	/** Xpath property value of TableInputTxt Box Object */
	public String strTableInputTxtBox_XPATH;

	/** Xpath property value of DatePickerInTable Object */
	public String strDatePickerInTable_XPATH;

	/** Xpath property value of DatePickYear Object */
	public String strDatePickYear_XPATH;

	/** Xpath property value of OtherInvstIfOther text Box Object */
	public String strOtherInvstIfOtherTxt_XPATH;

	/** Xpath property value of InvstExpIfOther text Box Object */
	public String strInvstExpIfOtherTxt_XPATH;

	/** Xpath property value of ManagerFundTable dropdown Box Object */
	public String strManagerFundTable_XPATH;

	StartAccountOpeningPage startaccount;

	/** Xpath property value of PortfolioTable dropdown Box Object */
	public String strPortfolioTable_XPATH;

	/** Xpath property value of PurchaseDate Object */
	public String strPurchaseDate_XPATH;

	/** Xpath property value of Advisor fee Object */
	public String strAdvisorFee_XPATH;

	/** Xpath property value of Tiered billing Object */
	public String strTieredBillingDrop_XPATH;

	/** Xpath property value of Custom Cash Amount Object */
	String strCustomCashAmt_XPATH;

	public JavascriptExecutor jse;
	public int INT_PAGEID=116;
	public int INT_FINPAGEID=21;
	public HomePage homePage;
	public NAOCommon common;

	/** Xpath property value of Common text  Box Object */
	public String strTxtBoxCommon_XPATH;
	public  FinancialPage(WebDriver driver){

		try {
			this.driver = driver;
			homePage=new HomePage(driver);
			common = new NAOCommon(driver);
			startaccount = new StartAccountOpeningPage(driver);
			jse = (JavascriptExecutor)driver;
			lplCoreConstents = LPLCoreConstents.getInstance();
			this.driver = driver;

			/** Fetching the page objects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());
			if(PageObjectsMap.get("strToclickCommAcc").get("XPATH")!=null)
				strToclickCommAcc_XPATH = PageObjectsMap.get("strToclickCommAcc").get("XPATH");

			if(PageObjectsMap.get("strInvstTechStrategiesChk").get("XPATH")!=null)
				strInvstTechStrategiesChk_XPATH = PageObjectsMap.get("strInvstTechStrategiesChk").get("XPATH");

			if(PageObjectsMap.get("strInvstTechOtherTxt").get("XPATH")!=null)
				strInvstTechOtherTxt_XPATH = PageObjectsMap.get("strInvstTechOtherTxt").get("XPATH");

			if(PageObjectsMap.get("strSuitabilityOtherTxt").get("XPATH")!=null)
				strSuitabilityOtherTxt_XPATH = PageObjectsMap.get("strSuitabilityOtherTxt").get("XPATH");

			if(PageObjectsMap.get("strIndPerTxtBox").get("XPATH")!=null)
				strIndPerTxtBox_XPATH = PageObjectsMap.get("strIndPerTxtBox").get("XPATH");

			if(PageObjectsMap.get("strIndicateExpTxtBox").get("XPATH")!=null)
				strIndicateExpTxtBox_XPATH = PageObjectsMap.get("strIndicateExpTxtBox").get("XPATH");

			if(PageObjectsMap.get("strOtherTxtBox").get("XPATH") !=null)
				strOtherTxtBox_XPATH=PageObjectsMap.get("strOtherTxtBox").get("XPATH");

			if(PageObjectsMap.get("strPlusCommn").get("XPATH") !=null)
				strPlusCommn_XPATH=PageObjectsMap.get("strPlusCommn").get("XPATH");

			if(PageObjectsMap.get("strTableInputTxtBox").get("XPATH") !=null)
				strTableInputTxtBox_XPATH=PageObjectsMap.get("strTableInputTxtBox").get("XPATH");

			if(PageObjectsMap.get("strDatePickInTable").get("XPATH") !=null)
				strDatePickerInTable_XPATH=PageObjectsMap.get("strDatePickInTable").get("XPATH");

			if(PageObjectsMap.get("strOtherInvstIfOtherTxt").get("XPATH") !=null)
				strOtherInvstIfOtherTxt_XPATH=PageObjectsMap.get("strOtherInvstIfOtherTxt").get("XPATH");

			if(PageObjectsMap.get("strInvstExpIfOtherTxt").get("XPATH") !=null)
				strInvstExpIfOtherTxt_XPATH=PageObjectsMap.get("strInvstExpIfOtherTxt").get("XPATH");

			if(PageObjectsMap.get("strTxtBoxCommon").get("XPATH") !=null)
				strTxtBoxCommon_XPATH=PageObjectsMap.get("strTxtBoxCommon").get("XPATH");

			if(PageObjectsMap.get("strListOfEle").get("XPATH") !=null)
				strListOfEle_XPATH=PageObjectsMap.get("strListOfEle").get("XPATH");

			if(PageObjectsMap.get("strPurchaseDate").get("XPATH") !=null)
				strPurchaseDate_XPATH=PageObjectsMap.get("strPurchaseDate").get("XPATH");

			if(PageObjectsMap.get("strPortfolioTable").get("XPATH") !=null)
				strPortfolioTable_XPATH=PageObjectsMap.get("strPortfolioTable").get("XPATH");

			if(PageObjectsMap.get("strManagerFundTable").get("XPATH") !=null)
				strManagerFundTable_XPATH=PageObjectsMap.get("strManagerFundTable").get("XPATH");

			if(PageObjectsMap.get("strAdvisorFee").get("XPATH") !=null)
				strAdvisorFee_XPATH=PageObjectsMap.get("strAdvisorFee").get("XPATH");

			if(PageObjectsMap.get("strTieredBillingDrop").get("XPATH") !=null)
				strTieredBillingDrop_XPATH=PageObjectsMap.get("strTieredBillingDrop").get("XPATH");

			if(PageObjectsMap.get("strCustomCashAmt").get("XPATH") !=null)
				strCustomCashAmt_XPATH = PageObjectsMap.get("strCustomCashAmt").get("XPATH");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to select Value for Institutional Account FINRA Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectInstitutionalAccountFinraRdoGrp(String strInstitutionalAccValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strInstitutionalAccRdoGrp"), strInstitutionalAccValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value for Is this account for a Govt Entity Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectIsThisAccGovtEntityRdoGrp(String strGovtEntityValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strGovtEntityRdoGrp"), strGovtEntityValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value from significant responsibility for managing the entity employed in any of the following activities radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectSignificantResponsibilityRdoGrp(String strSignificantResponsibilityValue ){
		boolean blnResult = false;
		String strFlag="N";
		if(strFlag.equalsIgnoreCase("Y")){
			try{
				blnResult =common.selectRadiobutton(testData.get("steBeneOwnerSignificantResponsibilityRdoGrp"), strSignificantResponsibilityValue);
			}
			catch(Exception ex){
				strError = strError+ex.getMessage();
				ex.printStackTrace();
				blnResult = false;
			}
		}
		else{
			blnResult = true;
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value for Provide Suitability Certification Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectProvideSuitabililtyCertRdoGrp(String strProvideCertValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strProvideCertRdoGrp"), strProvideCertValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	//*************************************Suitability**************************************************************//

	/**
	 * This function is used to click on Investment Objective DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectInvestmentObjectiveLst( String strInvestmentObjEle ){
		boolean blnResult = false;
		try{
			String strinvestmentObj_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strInvestmentObjDrop"));
			blnResult =common.selectDropDownBox(strinvestmentObj_XPATH, strInvestmentObjEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Annual Income DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAnnualIncomeLst(String strAnnualIncomeEle ){

		boolean blnResult = false;
		try{
			String strAnnualIncomeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strAnnualIncomeDrop"));
			blnResult =common.selectDropDownBox(strAnnualIncomeDrop_XPATH, strAnnualIncomeEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Tax Bracket DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectTaxBracketLst(String strTaxBracketEle ){
		boolean blnResult = false;
		try{
			String strTaxBracketDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strTaxBracketDrop"));
			blnResult =common.selectDropDownBox(strTaxBracketDrop_XPATH, strTaxBracketEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Net Worth DropDown Field and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectNetWorthLst( String strNetWorthEle ){
		boolean blnResult = false;
		try{
			String strNetWorthDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strNetWorthDrop"));
			blnResult =common.selectDropDownBox(strNetWorthDrop_XPATH, strNetWorthEle,"");
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Liquid Net Worth DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectLiquidNetWorthLst(String strLiquidNetWorthEle ){
		boolean blnResult = false;
		try{
			String strLiquidNetWorthDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strLiquidNetWorthDrop"));
			blnResult =common.selectDropDownBox(strLiquidNetWorthDrop_XPATH, strLiquidNetWorthEle,"");
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Approximate Account Value DropDown Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectApproximateAccValueLst(String strApproximateAccValueEle ){
		boolean blnResult = false;
		try{
			String strApproximateAccValueDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strApproximateAccValueDrop"));
			blnResult =common.selectDropDownBox(strApproximateAccValueDrop_XPATH, strApproximateAccValueEle,"");
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Approximate Account TextBox Value 
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setApproximateAccountValueTxt(String strApproximateAccValue){
		boolean blnResult = false;
		try{				
			String strNumberOfDependencies_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strSuitabilitySection")).replace("yyy",testData.get("strApproximateAccvalueTxt"));
			blnResult = common.setValue(strNumberOfDependencies_XPATH, strApproximateAccValue);
			common.waitforProcessing();
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Source Of Wealth And Income  DropDown Field and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectSourceOfWealthAndIncomeLst(String strSourceOfWealthAndIncomeEle ){

		boolean blnResult = false;
		try{
			String strSourceOfWealthAndIncomeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strSourceOfWealthAndIncomeDrop"));
			blnResult =common.selectDropDownBox(strSourceOfWealthAndIncomeDrop_XPATH, strSourceOfWealthAndIncomeEle,"");
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
	 * This function is used to set Value for Others
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setSuitabilityOtherTxt(String strSuitabilityOtherValue ){
		boolean blnResult = false;
		try{		
			blnResult = common.setValue(strSuitabilityOtherTxt_XPATH, strSuitabilityOtherValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/*************************************Financial Information**************************************************************/

	/**
	 * This function is used to select Value Client have other investment Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectClientOtherInvestmentRdoGrp(String strOtherInvestmentValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strOtherInvestmentRdoGrp"), strOtherInvestmentValue);
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Checking/Savings
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setCheckingTxt(String strCheckingValue ){
		boolean blnResult = false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strCheckingTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strCheckingTxt"));
			blnResult = common.setValue(strCheckingTxt_XPATH, strCheckingValue);
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
	 * This function is used to set Value for Mutual Funds
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setMutualFundsTxt(String strMutualFundsValue ){
		boolean blnResult = false;
		try{		
			String strMutualFundsTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strMutualFundsTxt"));
			blnResult = common.setValue(strMutualFundsTxt_XPATH, strMutualFundsValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Equities/Stocks
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setEquitiesTxt(String strEquitiesValue ){
		boolean blnResult = false;
		try{		
			String strEquitiesTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strEquitiesTxt"));
			blnResult = common.setValue(strEquitiesTxt_XPATH, strEquitiesValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Bonds
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setBondsTxt(String strBondsValue ){
		boolean blnResult = false;
		try{		
			String strBondsTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strBondsTxt"));
			blnResult = common.setValue(strBondsTxt_XPATH, strBondsValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Insurance
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setInsuranceTxt(String strInsuranceValue ){
		boolean blnResult = false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strInsuranceTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strInsuranceTxt"));
			blnResult = common.setValue(strInsuranceTxt_XPATH, strInsuranceValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Annuities
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setAnnuitiesTxt( String strAnnuitiesValue ){
		boolean blnResult = false;
		try{		
			String strAnnuitiesTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strAnnuitiesTxt"));
			blnResult = common.setValue(strAnnuitiesTxt_XPATH, strAnnuitiesValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Real Estate
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setRealEstateTxt(String strRealEstateValue ){
		boolean blnResult = false;
		try{		
			String strRealEstateTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strRealEstateTxt"));
			blnResult = common.setValue(strRealEstateTxt_XPATH, strRealEstateValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Alternative Investments
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setAlternativeInvestmentTxt(String strAlternativeInvestmentValue ){
		boolean blnResult = false;
		try{		
			String strAlternativeInvestmentTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strAlternativeInvestmentTxt"));
			blnResult = common.setValue(strAlternativeInvestmentTxt_XPATH, strAlternativeInvestmentValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Other
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setOtherTxt(String strOtherValue ){
		boolean blnResult = false;
		try{		
			String strOtherTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strOtherTxt"));
			blnResult = common.setValue(strOtherTxt_XPATH, strOtherValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for If Other
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean setIfOtherPlTxt(String strOtherValue)
	{
		boolean blnResult = false;
		try{	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			blnResult = common.setValue(strOtherInvstIfOtherTxt_XPATH, strOtherValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/*************************************Investment Horizon & Liquidity Needs**************************************************************/

	/**
	 * This function is used to click on Clients Time Horizon DropDown Field and to select Element from the Drop Down  Investment Horizon and Liquidity Needs
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectTimeHorizonLst(String strTimeHorizonEle){
		boolean blnResult = false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strTimeHorizonObjDrop_XPATH=startaccount.strToclickComm_XPATH.replace("yyy", testData.get("strTimeHorizonDrop"));
			blnResult = common.selectDropDown1(strTimeHorizonObjDrop_XPATH, strTimeHorizonEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);

		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value for Liquidity Needs From Funds Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectLiquidityNeedsFromFundsRdoGrp( String strLiquidityNeedsFundsValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strLiquidityNeedsFundsRdoGrp"), strLiquidityNeedsFundsValue);	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Funds Needed In Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectFundsNeededInLst(String strFundsNeededInEle){
		boolean blnResult = false;
		try{		
			String strFundsNeededInObjDrop_XPATH=startaccount.strToclickComm_XPATH.replace("yyy", testData.get("strFundsNeededInDrop"));
			blnResult = common.selectDropDownBox(strFundsNeededInObjDrop_XPATH, strFundsNeededInEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Approximate Amount Needed in Specified Time Range
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setApproximateAmtNeededTxt(String strApprxAmtValue ){
		boolean blnResult = false;
		try{		
			String strApproximateAmtNeededTxt_XPATH=strTxtBoxCommon_XPATH.replace("xxx",testData.get("strApprxAmtTxt"));
			blnResult = common.setValue(strApproximateAmtNeededTxt_XPATH, strApprxAmtValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/*************************************Investment Experience**************************************************************/

	/**
	 * This function is used to select Value for Client Have any Prior Investment Experience Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectPriorInvesmentExpRdoGrp( String strPriorInvesmentExpValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strPriorInvesmentExpRdoGrp"),strPriorInvesmentExpValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Annuities for Investment Experience
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExpAnnuitiesTxt( String strAnnuitiesValue ){
		boolean blnResult = false;
		try{		
			String strExpAnnuitiesTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strAnnuitiesTxt"));
			blnResult = common.setValue(strExpAnnuitiesTxt_XPATH, strAnnuitiesValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Mutual Funds Investment Experience
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExpMutualFundsTxt( String strMutualFundsValue ){
		boolean blnResult = false;
		try{		
			String strExpExpMutualFundsTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strMutualFundsTxt"));
			blnResult = common.setValue(strExpExpMutualFundsTxt_XPATH, strMutualFundsValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Partnerships Investment Experience
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExpPartnershipsTxt( String strPartnershipValue ){
		boolean blnResult = false;
		try{		
			String strExpPartnershipsTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strPartnershipsTxt"));
			blnResult = common.setValue(strExpPartnershipsTxt_XPATH, strPartnershipValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Margin Investment Experience
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExpMarginTxt( String strMarginValue ){
		boolean blnResult = false;
		try{		
			String strExpMarginTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strMarginTxt"));
			blnResult = common.setValue(strExpMarginTxt_XPATH, strMarginValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Stocks Investment Experience
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExpStocksTxt( String strStocks ){
		boolean blnResult = false;
		try{		
			String strExpStocksTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strStocksTxt"));
			blnResult = common.setValue(strExpStocksTxt_XPATH, strStocks);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Bonds Investment Experience
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExpBondsTxt( String strBonds ){
		boolean blnResult = false;
		try{		
			String strExpBondsTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strBondsTxt"));
			blnResult = common.setValue(strExpBondsTxt_XPATH, strBonds);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}	

	/**
	 * This function is used to set Value for Options Investment Experience
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExpOptionsTxt( String strOptions ){
		boolean blnResult = false;
		try{		
			String strExpOptionsTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strOptionsTxt"));
			blnResult = common.setValue(strExpOptionsTxt_XPATH, strOptions);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}	

	/**
	 * This function is used to set Value for Other Investment Experience
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExpOtherTxt( String strOther ){
		boolean blnResult = false;
		try{		
			String strExpOtherTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strOtherTxt"));
			blnResult = common.setValue(strExpOtherTxt_XPATH, strOther);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}	

	/**
	 * This function is used to set Value for If other Please Investment Experience
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setExpIfOtherPlTxt( String strIfOtherValue ){
		boolean blnResult = false;
		try{		
			String strExpOtherTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",strifOtherPl);
			blnResult = common.setValue(strExpOtherTxt_XPATH, strIfOtherValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}	

	/**
	 * This function is used to Click on Funds Needed In Field and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectHowLongClientInvestingLst( String strClientInvestingEle ){
		boolean blnResult = false;
		try{
			String strClientInvesting_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strInvestmentExpSection")).replace("yyy", testData.get("strClientInvestingEleDrop"));
			blnResult =common.selectDropDownBox(strClientInvesting_XPATH, strClientInvestingEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value for Client Want Cost Basis Reporting on LPL Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectCostBasisOnLPLRdoGrp( String strCostBasisOnLPLValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strCostBasisOnLPLRdoGrp"), strCostBasisOnLPLValue);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Lot Relief Method and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectLotReliefMethodLst(String strLotReliefMethodEle){
		boolean blnResult = false;
		try{		
			String strLotReliefMethodDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strCostBasisSection")).replace("yyy", testData.get("strLotReliefMethodDrop"));
			blnResult = common.selectDropDownBox(strLotReliefMethodDrop_XPATH, strLotReliefMethodEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on MF Average Cost and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectMFAvgCostLst(String strMFAvgCostEle){
		boolean blnResult = false;
		try{		
			String strMFAvgCostDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strCostBasisSection")).replace("yyy", testData.get("strMFAvgCostDrop"));
			blnResult = common.selectDropDownBox(strMFAvgCostDrop_XPATH, strMFAvgCostEle,"");					
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on DRP Average Cost and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectDRPAvgCostLst(String strDRPAvgCostEle){
		boolean blnResult = false;
		try{		
			String strDRPAvgCostObjDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strCostBasisSection")).replace("yyy", testData.get("strDRPAvgCostDrop"));
			blnResult = common.selectDropDownBox(strDRPAvgCostObjDrop_XPATH, strDRPAvgCostEle,"");					
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}			

	/**
	 * This function is used to Click on Money Market Funds Sweep and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectMoneyMarketFundSweepLst(String strMoneyMarketFundsSweeptEle){
		boolean blnResult = false;
		try{		
			String strMoneyMarketFundSweepDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strAccInfoSettingsSection")).replace("yyy", testData.get("strMoneyMarketFundsSweepDrop"));
			blnResult = common.selectDropDownBox(strMoneyMarketFundSweepDrop_XPATH, strMoneyMarketFundsSweeptEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Distribution Election and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectDistributionElectionLst(String strDistributionSelection){
		boolean blnResult = false;
		try{		
			common.ClickOnBtn(testData.get("strValidateBtnTxt"));
			String strDistributionSelectionDrop_XPATH=startaccount.strToclickComm_XPATH.replace("yyy", testData.get("strDistributionElectionDrop"));
			new WebDriverWait(driver, lplCoreConstents.HIGH).until(ExpectedConditions.visibilityOfElementLocated((By.xpath(strDistributionSelectionDrop_XPATH))));
			blnResult = clickOnDistributionElectionLst(strDistributionSelectionDrop_XPATH,strDistributionSelection);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.MediumInMiliSec);
			blnResult = true;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Rebalancing Frequency and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectRebalancingFrequencyLst(String strRebalancingFrequencyEle){
		boolean blnResult = false;
		try{	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			String strRebalancingFrequencyDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strPortFolioSelectionSection")).replace("yyy", testData.get("strRebalancingFrequencyDrop"));
			blnResult = common.selectDropDown1(strRebalancingFrequencyDrop_XPATH, strRebalancingFrequencyEle,"YES");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/***********************************************Investment Techniques Section*****************************************************************************************/	

	/**
	 * This function is used to check and uncheck the check boxes of investment tech
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,String[],String[],String
	 * @return boolean
	 **/
	public boolean  clickInvstTechChkBox(String strInvstTechSection,String[] strChkBox,String[] strUnChkBox,String strChkstate){
		boolean blnResult = false;
		try{
			for (String s:strChkBox){
				String strChkBox_XPATH=strInvstTechStrategiesChk_XPATH.replace("xxx", strInvstTechSection).replace("yyy", s);
				jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox_XPATH)));
				common.clickChechBox(strChkBox_XPATH, strChkstate);
			}
			for (String s:strUnChkBox){
				String strUnChkBox_XPATH=strInvstTechStrategiesChk_XPATH.replace("xxx", strInvstTechSection).replace("yyy", s);
				jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strUnChkBox_XPATH)));
				common.clickChechBox(strUnChkBox_XPATH, strChkstate);
			}
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Value for Others
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  setInvstTechOtherTxt(String strInvstTechOtherValue ){
		boolean blnResult = false;
		try{		
			blnResult = common.setValue(strInvstTechOtherTxt_XPATH, strInvstTechOtherValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}
	/***********************************************Portfolio Selection Section*****************************************************************************************/	

	/**
	 * This function is used to Click on Portfolio Selection  and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectPortfolioSelectionLst(String strPortfolioSelectionEle){
		boolean blnResult = false;
		try{		
			String strPortfolioSelectionEleDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strPortFolioSelectionSection")).replace("yyy", testData.get("strPortfolioSelectionEleDrop"));
			blnResult = common.selectDropDownBox(strPortfolioSelectionEleDrop_XPATH, strPortfolioSelectionEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Share Selection  and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectShareClassSelectionLst(String strShareSelectionEle){
		boolean blnResult = false;
		try{		
			String strShareSelectionEleDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strPortFolioSelectionSection")).replace("yyy", testData.get("strShareSelectionEleDrop"));
			blnResult = common.selectDropDownBox(strShareSelectionEleDrop_XPATH, strShareSelectionEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;

	}

	/**
	 * This function is used to Click on Strategist Allocation DropDown Field and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectStrategistAllocationLst( String strStrategistAllocationEle ){
		boolean blnResult = false;
		try{
			String strStrategistAllocation_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strPortFolioSelectionSection")).replace("yyy", testData.get("strStrategisAllocationDrop"));
			blnResult =common.selectDropDownBox(strStrategistAllocation_XPATH, strStrategistAllocationEle,"");
			common.acceptDialog();
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.MediumInMiliSec);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select multiple dropdown from the table for Strategist Allocation
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String[]
	 * @return boolean
	 **/
	public boolean selectPortfolioTableLst(String[] strPortfolioTabledropValue) {
		boolean blnResult = false;
		try {
			String strDropDown_XPATH ="]//div";
			blnResult = common.selectCommonTableLst(strPortfolioTabledropValue, strPortfolioTable_XPATH,"",strDropDown_XPATH);
		} 
		catch (Exception ex) {
			strError = strError + ex.getMessage();
			ex.printStackTrace();
			return blnResult;
		}
		return blnResult;
	}	

	/**
	 * This function is used to select multiple dropdown from the table for Manager Styles
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String[]
	 * @return boolean
	 **/
	public boolean selectManagerFundETFTableLst(String[] strManagerFundETFdropValue) {
		boolean blnResult = false;
		try {
			String strDropDown_XPATH ="]//div";
			blnResult = common.selectCommonTableLst(strManagerFundETFdropValue, strManagerFundTable_XPATH,"YES",strDropDown_XPATH);
		} 
		catch (Exception ex) {
			strError = strError + ex.getMessage();
			ex.printStackTrace();
			return blnResult;
		}
		return blnResult;
	}

	/**
	 * This function is used to select multiple dropdown from the table for Portfolio Manager Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String[]
	 * @return boolean
	 **/
	public boolean selectPortFolioManagerTableLst(String[] strPortFoliManagerdropValue) {
		boolean blnResult = false;
		try {
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			String strDropDown_XPATH ="]//a";
			blnResult = common.selectCommonTableLst(strPortFoliManagerdropValue, strManagerFundTable_XPATH,"",strDropDown_XPATH);
		} 
		catch (Exception ex) {
			strError = strError + ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Model List DropDown Field and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectModelLst( String strModelEle ){
		boolean blnResult = false;
		try{
			String strModelList_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strPortFolioSelectionSection")).replace("yyy", testData.get("strModelEleDrop"));
			blnResult =common.selectDropDownBox(strModelList_XPATH, strModelEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.MediumInMiliSec);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on Select Investment Options 
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectInvestmentOptionLst(String strInvestmentOptionsEle){
		boolean blnResult = false;
		try{	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strInvestmentOptionsDrop_XPATH=startaccount.strToclickComm_XPATH.replace("yyy", testData.get("strInvestmentOptionsDrop"));
			blnResult = common.selectDropDown1(strInvestmentOptionsDrop_XPATH, strInvestmentOptionsEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/***********************************************Advisory Option Section*****************************************************************************************/	

	/**
	 * This function is used to Click on Advisory fee Type  and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectAdvisoryFeeTypeLst(String strAdvisoryFeeTypeEle){
		boolean blnResult = false;
		try{	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strAdvisoryFeeTypeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strAdvisoryOptionSection")).replace("yyy", testData.get("strAdvisoryFeeTypeDrop"));
			blnResult = common.selectDropDown1(strAdvisoryFeeTypeDrop_XPATH, strAdvisoryFeeTypeEle,"YES");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}	

	/**
	 * This function is used to Click on Billing  and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectBillingLst(String strBillingTypeEle){
		boolean blnResult = false;
		try{		
			String strBillingDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strAdvisoryOptionSection")).replace("yyy", testData.get("strBillingTypeDrop"));
			blnResult = common.selectDropDown1(strBillingDrop_XPATH, strBillingTypeEle,"YES");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Fee and Statement Cycle Dropdown and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectFeeAndStatementLst(String strFeeAndStatementEle){
		boolean blnResult = false;
		try{		
			String strFeeAndStatementDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strAdvisoryOptionSection")).replace("yyy", testData.get("strFeeAndStatementDrop"));
			blnResult = common.selectDropDownBox(strFeeAndStatementDrop_XPATH, strFeeAndStatementEle,"");
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to Click on Tiered Billing Dropdown and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectTieredBillingLst(String strTieredBillingEle){
		boolean blnResult = false;
		try{		
			blnResult = common.selectDropDownBox(strTieredBillingDrop_XPATH, strTieredBillingEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}	

	/**
	 * This function is used to set the FlatFee Value 	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean setFlatFee(String fee)
	{
		boolean blnResult = false;
		try{				
			String strFlatFee_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strAdvisoryOptionSection")).replace("yyy",testData.get("strFlatFeeTxt"));
			blnResult = common.setValue(strFlatFee_XPATH, fee);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select the Radio Button for the ApplyCustomCash
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectApplyCustomCashRdoGrp( String strApplyCustomCashoption ){
		boolean blnResult = false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			blnResult =common.selectRadiobutton(testData.get("strApplyCustomCashRdoGrp"), strApplyCustomCashoption);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select the Radio Button for the Trading Options
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectTradingOptionsRdoGrp( String strTradingOptions ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strTradingRdoGrp"), strTradingOptions);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value from Suspend Trading Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectSuspendTradingRdoGrp(String strSuspendTradingValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strSuspendTrading"), strSuspendTradingValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set the value for the Custom Cash Amount
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean setCustomCashAmount(String customCash){
		boolean blnResult=false;
		try{
			blnResult = common.setValue(strCustomCashAmt_XPATH, customCash);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return blnResult;	
	}

	/**
	 * This function is used to select Value for Commission On Trade  Radio group
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectCommisionOnTradeRdoGrp(String strCommissionOnTradeValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strCommissionOnTradeRdoGrp"), strCommissionOnTradeValue);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to click on the Add Commission Button
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean clickAddCommissionBtn(String addCommission)
	{
		boolean status=false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(2);
			strAddCommision_XPATH=this.strPlusCommn_XPATH.replace("xxx", addCommission);
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.MediumInMiliSec);
			WebElement objAddComm = driver.findElement(By.xpath(strAddCommision_XPATH));
			objAddComm.click();
			status=true;

		}catch(Exception e){
			status=false;
		}
		return status;
	}   

	/**
	 * This function is used to set the value for the SymbolCUSIP
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean setSymbolCUSIPTxt(String strSymbol)
	{
		boolean status=false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(1);
			String strSymbolCUSIPTxtBox_XPATH=this.strTableInputTxtBox_XPATH.replace("xxx", testData.get("strCommissonInclude")).replace("yyy", testData.get("strCUSIPSymbol"));//CommissionsInclude.CUSIPSymbol
			//Wait for the page to load
			LPLCoreSync.waitForWebElement(driver,"xpath",strSymbolCUSIPTxtBox_XPATH, 30);
			status = common.setValue(strSymbolCUSIPTxtBox_XPATH, strSymbol);
		}
		catch(Exception e){
			status=false;
		}
		return status;
	}

	/**
	 * This function is used to set the value for the PurchaseDate
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,int,int
	 * @return boolean
	 **/
	public boolean setPurchaseDateTxt(String strSection,int intYearStart,int intYearEnd)
	{
		boolean blnResult = false;
		try{	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.MediumInMiliSec);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strDatemmdyyyy=NAOCommon.getRandomDate(intYearStart, intYearEnd);
			System.out.println(strDatemmdyyyy);
			String[] strPurchaseDate = {strPurchaseDate_XPATH,""};
			blnResult = common.setPickdate(strSection,testData.get("strPurchaseDate"), strDatemmdyyyy,strPurchaseDate[0]);														
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set Date Characteristics
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String,int,int
	 * @return boolean
	 **/
	public boolean  setDateCharacteristics(String strSection,int intYearStart,int intYearEnd){

		boolean blnResult = false;
		try{	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.MediumInMiliSec);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strDatemmdyyyy=NAOCommon.getRandomDate(intYearStart, intYearEnd);
			System.out.println(strDatemmdyyyy);
			blnResult = common.setPickdate(strSection,testData.get("strDateCharacteristics"), strDatemmdyyyy);														
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to set value for the Purchased Amount
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean setPurchaseAmntTxt(String purchaseAmnt)
	{
		boolean status=false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			String strpurchaseAmountTxtBox_XPATH=this.strTableInputTxtBox_XPATH.replace("xxx", testData.get("strCommissonInclude")).replace("yyy", testData.get("strPurchaseAmt"));
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			status = common.setValue(strpurchaseAmountTxtBox_XPATH, purchaseAmnt);
		}
		catch(Exception e){
			status=false;
		}
		return status;
	}

	/**
	 * This function is used to set value for Commission
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean setCommissionTxt(String strCommission)
	{
		boolean status=false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(1);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			String strCommissionTxtBox_XPATH=this.strTableInputTxtBox_XPATH.replace("xxx", testData.get("strCommissonInclude")).replace("yyy", testData.get("strCommissionTxt"));
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			status = common.setValue(strCommissionTxtBox_XPATH, strCommission);
		}
		catch(Exception e){
			status=false;
		}
		return status;
	}

	/**
	 * This function is used to set the value for the Class
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean setClassTxt(String strClass)
	{
		boolean status=false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(1);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			String strClassTxtBox_XPATH=this.strTableInputTxtBox_XPATH.replace("xxx", testData.get("strCommissonInclude")).replace("yyy", testData.get("strClassTxt"));
			LPLCoreSync.waitForWebElement(driver,"xpath",strClassTxtBox_XPATH, 30);
			status = common.setValue(strClassTxtBox_XPATH, strClass);
		}
		catch(Exception e){
			status=false;
		}
		return status;
	}

	/**
	 * This function is used to select the checkbox on MutualFund
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean clickMutualFundChk(String strChkstate)
	{
		boolean blnResult=false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			String strChkBox_XPATH=this.strTableInputTxtBox_XPATH.replace("xxx", testData.get("strCommissonInclude")).replace("yyy", testData.get("strClassTxt"));
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strChkBox_XPATH)));
			blnResult=common.clickChechBox(strChkBox_XPATH, strChkstate);
		}
		catch(Exception ex){
			blnResult=false;
		}
		return blnResult;
	}

	/**************************************************************Advisory Options***********************************************************************/

	/**
	 * This function is used to set Value to the AdvisorFee text Field
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean setAdvisorFee(String strAdvisorFeeValue){
		boolean blnResult=false;
		try{
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			blnResult = common.setValue(strAdvisorFee_XPATH, strAdvisorFeeValue);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);		
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/*************************************Electronic Fund Transfers section************************************************/
	/**
	 * This function is used to Click on Tiered Billing Dropdown and to select Element from the Drop Down
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectDollarRangeLst(String strDollarRangeEle){
		boolean blnResult = false;
		try{		
			String strTieredBillingDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strEleFundTransferSection")).replace("yyy", testData.get("strDollarRangePerMonthDrop"));
			blnResult = common.selectDropDownBox(strTieredBillingDrop_XPATH, strDollarRangeEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}	

	/**
	 * This function is used to Click on WireTransfers Dropdown and to select Element from the Drop Down	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectWireTransferLst(String strWireTransferEle){
		boolean blnResult = false;
		try{		
			String strWireTransferDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strWireTransferSection")).replace("yyy", testData.get("strWireTransferDrop"));
			blnResult = common.selectDropDownBox(strWireTransferDrop_XPATH, strWireTransferEle,"");	
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Value for Enable Money Market Fund Sweep Radio Group	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectEnableMoneyMarketFundSweepRdoGrp(String strEnableMoneyMarketFundSweepValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strDollarRangePerMonthDrop"), strEnableMoneyMarketFundSweepValue);
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Radio Button  value from  TransactionPerMonth Group	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectTransactionPerMonthRdoGrp(String strTransactionValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strTransactionPerMonth"), strTransactionValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Radio Button Value  from  JournalsPerMonth Group	
	 *
	 * @author Jyothi
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  selectJournalsPerMonthRdoGrp(String strJournalsValue ){
		boolean blnResult = false;
		try{
			blnResult =common.selectRadiobutton(testData.get("strJournalsPerMonth"), strJournalsValue);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to select Radio Button from Schedule A Agreed To On
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String,int,int
	 * @return boolean
	 **/
	public boolean  selectScheduleAgreeToAnRdoGrp(String strSection,int intYearStart,int intYearEnd){

		boolean blnResult = false;
		try{	
			//Wait for the page to load
			LPLCoreSync.staticWait(homePage.lplCoreConstents.MediumInMiliSec);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strDatemmdyyyy=NAOCommon.getRandomDate(intYearStart, intYearEnd);
			System.out.println(strDatemmdyyyy);
			blnResult = common.setPickdate(strSection,testData.get("ScheduleAgreeToAn"), strDatemmdyyyy);														
			homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return blnResult;
	}

	/**
	 * This function is used to perform actions on Regulatory Questions section In Financial Page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectRegulatoryQuestionsFinancialPage(String... strFinancialPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strFinancialPagePanels){
				switch(strPanel.toUpperCase()){
				case "INSTITUTIONALACCOUNTFINRA":
					blnResult =common.selectRadiobutton(testData.get("strInstitutionalAccRdoGrp"), testData.get("strInstitutionalAccValue"));
					break;

				case "PROVIDECERT":
					blnResult =common.selectRadiobutton(testData.get("strProvideCertRdoGrp"), testData.get("strProvideCertValue"));
					break;

				case "GOVERNMENTENTITY":
					blnResult =common.selectRadiobutton(testData.get("strGovtEntityRdoGrp"), testData.get("strGovtEntityValue"));
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
	 * This function is used to perform actions on Suitability section In Financial Page
	 *
	 * @author Ravneet Kaur
	 * @version 1.0
	 * @since 
	 * @param String[],String...
	 * @return String
	 **/
	public String  selectSuitabilityFinancialPage(String[] strFinPage,String... strFinancialPagePanels){
		boolean blnResult=false;
		String strResult=null;
		try{
			for(String strPanel:strFinancialPagePanels){
				switch(strPanel.toUpperCase()){

				case "INVESTMENTOBJECTIVE":
					String strinvestmentObj_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strInvestmentObjDrop"));
					blnResult =common.selectDropDownBox(strinvestmentObj_XPATH, strFinPage[0],"");
					break;

				case "ANNUALINCOME":
					String strAnnualIncomeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strAnnualIncomeDrop"));
					blnResult =common.selectDropDownBox(strAnnualIncomeDrop_XPATH, strFinPage[1],"");
					break;

				case "TAXBRACKET":
					String strTaxBracketDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strTaxBracketDrop"));
					blnResult =common.selectDropDownBox(strTaxBracketDrop_XPATH, strFinPage[2],"");
					break;

				case "NETWORTH":
					String strNetWorthDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strNetWorthDrop"));
					blnResult =common.selectDropDownBox(strNetWorthDrop_XPATH, strFinPage[3],"");
					break;

				case "LIQUIDNETWORTH":
					String strLiquidNetWorthDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strLiquidNetWorthDrop"));
					blnResult =common.selectDropDownBox(strLiquidNetWorthDrop_XPATH, strFinPage[4],"");

					break;

				case "APPROXIMATEACCOUNTVALUE":
					String strNumberOfDependencies_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strSuitabilitySection")).replace("yyy",testData.get("strApproximateAccvalueTxt"));
					blnResult = common.setValue(strNumberOfDependencies_XPATH, strFinPage[5]);
					break;

				case "APPROXIMATEACCVAL":
					String strApproximateAccVal_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strApproximateAccvalueTxt"));
					blnResult =common.selectDropDownBox(strApproximateAccVal_XPATH, strFinPage[5],"");
					break;

				case "SOURCEOFWEALTHANDINCOME":
					String strSourceOfWealthAndIncomeDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSuitabilitySection")).replace("yyy", testData.get("strSourceOfWealthAndIncomeDrop"));
					blnResult =common.selectDropDownBox(strSourceOfWealthAndIncomeDrop_XPATH, strFinPage[6],"");
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
			blnResult=false;
			strResult=null;
		}
		return strResult;
	}

	/**
	 * This function is used to perform actions on Investment Experience section In Financial Page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectInvestmentExperiencePage(String... strFinancialPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strFinancialPagePanels){
				switch(strPanel.toUpperCase()){	
				case "PRIORINVESTMENT":
					blnResult =common.selectRadiobutton(testData.get("strPriorInvesmentExpRdoGrp"),testData.get("strPriorInvesmentExpValue"));
					break;

				case "HOWLONGINVT":
					String strClientInvesting_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strInvestmentExpSection")).replace("yyy", testData.get("strClientInvestingEleDrop"));
					blnResult =common.selectDropDownBox(strClientInvesting_XPATH, testData.get("strClientInvestingEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "ANNUITIES":
					String strExpAnnuitiesTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strAnnuitiesTxt"));
					blnResult = common.setValue(strExpAnnuitiesTxt_XPATH, testData.get("strAnnuitiesValue"));
					break;

				case "MUTUALFUNDS":
					String strExpExpMutualFundsTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strMutualFundsTxt"));
					blnResult = common.setValue(strExpExpMutualFundsTxt_XPATH, testData.get("strMutualFundsValue"));
					break;

				case "PARTNERSHIP":
					String strExpPartnershipsTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strPartnershipsTxt"));
					blnResult = common.setValue(strExpPartnershipsTxt_XPATH, testData.get("strPartnershipValue"));
					break;

				case "MARGIN":
					String strExpMarginTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strMarginTxt"));
					blnResult = common.setValue(strExpMarginTxt_XPATH, testData.get("strMarginValue"));
					break;

				case "STOCKS":
					String strExpStocksTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strStocksTxt"));
					blnResult = common.setValue(strExpStocksTxt_XPATH, testData.get("strStocks"));
					break;

				case "BONDS":
					String strExpBondsTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strBondsTxt"));
					blnResult = common.setValue(strExpBondsTxt_XPATH, testData.get("strBonds"));
					break;

				case "OPTIONS":
					String strExpOptionsTxt_XPATH=strIndicateExpTxtBox_XPATH.replace("xxx",testData.get("strOptionsTxt"));
					blnResult = common.setValue(strExpOptionsTxt_XPATH, testData.get("strOptions"));
					break;

				case "529PLANQUESTION":
					String strPlanQuestion_XPATH=startaccount.strTxtBox_XPATH.replace("xxx",testData.get("strPlanQuestion")).replace("yyy", testData.get("strShareClass"));
					blnResult = common.setValue(strPlanQuestion_XPATH, testData.get("strShareClassVal"));
					break;

				case "TAXCONSIDERATION":
					blnResult =common.selectRadiobutton(testData.get("strTaxConsideration"), testData.get("strTaxConsiderationVal"));
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
	 * This function is used to perform actions on Investment Techniques from the check boxes
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectInvestmentTechniquesPage(String... strFinancialPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strFinancialPagePanels){
				switch(strPanel.toUpperCase()){	
				case "DOLLARCSTAVG":
					String strDollarCostAvg_XPATH=startaccount.strClientBestInterestCommon_XPATH.replace("xxx", testData.get("strDollarCostAvg"));
					blnResult=startaccount.selectBestInterestRationaleRdoGrp(strDollarCostAvg_XPATH);
					break;

				case "LIQUIDATIONS":
					String strLiquidation_XPATH=startaccount.strClientBestInterestCommon_XPATH.replace("xxx", testData.get("strLiquidations"));
					blnResult=startaccount.selectBestInterestRationaleRdoGrp(strLiquidation_XPATH);
					break;

				case "ASSETALLOC":
					String strAssetAlloc_XPATH=startaccount.strClientBestInterestCommon_XPATH.replace("xxx", testData.get("strAssetAlloc"));
					blnResult=startaccount.selectBestInterestRationaleRdoGrp(strAssetAlloc_XPATH);
					break;

				case "BUYNHOLD":
					String strBuyNHold_XPATH=startaccount.strClientBestInterestCommon_XPATH.replace("xxx", testData.get("strButNHold"));
					blnResult=startaccount.selectBestInterestRationaleRdoGrp(strBuyNHold_XPATH);
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
	 * This function is used to perform actions on Investment Horizon and Liquidity Needs from the check boxes
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectInvestmentHorizonandLiquidityNeedsPage(String... strFinancialPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strFinancialPagePanels){
				switch(strPanel.toUpperCase()){	
				case "VALIDATE":
					blnResult =common.ClickOnBtn(testData.get("strValidateBtnTxt"));
					break;

				case "TIMEHORIZON":
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					String strTimeHorizonObjDrop_XPATH=startaccount.strToclickComm_XPATH.replace("yyy", testData.get("strTimeHorizonDrop"));
					blnResult = common.selectDropDown1(strTimeHorizonObjDrop_XPATH, testData.get("strTimeHorizonEle"),"");	
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "LIQUIDUITY":
					blnResult =common.selectRadiobutton(testData.get("strLiquidityNeedsFundsRdoGrp"), testData.get("strLiquidityNeedsFundsValue"));						
					//Wait for the page to load
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "FUNDSNEEDEDLIST":
					String strFundsNeededInObjDrop_XPATH=startaccount.strToclickComm_XPATH.replace("yyy", testData.get("strFundsNeededInDrop"));
					blnResult = common.selectDropDownBox(strFundsNeededInObjDrop_XPATH, testData.get("strFundsNeededInEle"),"");
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
					break;

				case "APPOXAMTNEED":
					String strApproximateAmtNeededTxt_XPATH=strTxtBoxCommon_XPATH.replace("xxx",testData.get("strApprxAmtTxt"));
					blnResult = common.setValue(strApproximateAmtNeededTxt_XPATH, testData.get("strApprxAmtValue"));
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
	 * This function is used to perform actions on Account Information Settings section In Financial Page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectAccountInformationandSettingsPage(String... strFinancialPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strFinancialPagePanels){
				switch(strPanel.toUpperCase()){	

				case "MONEYMARKETFUNDSWEEP":
					String strMoneyMarketFundSweepDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strAccInfoSettingsSection")).replace("yyy", testData.get("strMoneyMarketFundsSweepDrop"));
					blnResult = common.selectDropDownBox(strMoneyMarketFundSweepDrop_XPATH, testData.get(""),"");
					break;

				case "DISTRIBUTIONELECTION":
					String strDistributionSelectionDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strAccInfoSettingsSection")).replace("yyy", testData.get("strDistributionElectionDrop"));
					blnResult = common.selectDropDownBox(strDistributionSelectionDrop_XPATH, testData.get(""),"");
					break;

				case "ENABLEMARKETSWEEP":
					blnResult = common.selectRadiobutton(testData.get("strEnableMarketSweepRdoGrp"),testData.get("strEnableMarketSweepVal"));		
					homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
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
			return strResult=null;	
		}
		return strResult;
	}	

	/**
	 * This function is used to perform actions on Financial Information section In Financial Page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectFinancialInformationPage(String... strFinancialPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strFinancialPagePanels){
				switch(strPanel.toUpperCase()){	
				case "OTHERCLIENTINVESTMENT":
					blnResult =common.selectRadiobutton(testData.get("strOtherInvestmentRdoGrp"),testData.get("strOtherInvestmentValue"));
					break;

				case "CHECKING":
					String strCheckingTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strCheckingTxt"));
					blnResult = common.setValue(strCheckingTxt_XPATH, testData.get("strCheckingValue"));
					break;

				case "INSURANCE":
					String strInsuranceTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strInsuranceTxt"));
					blnResult = common.setValue(strInsuranceTxt_XPATH, testData.get("strInsuranceValue"));
					break;

				case"MUTUALFUNDS":
					String strMutualFundsTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strMutualFundsTxt"));
					blnResult = common.setValue(strMutualFundsTxt_XPATH, testData.get("strMutualFundsValue"));
					break;

				case"EQUITIES":
					String strEquitiesTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strEquitiesTxt"));
					blnResult = common.setValue(strEquitiesTxt_XPATH,testData.get("strEquitiesValue"));
					break;

				case"BONDS":
					String strBondsTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strBondsTxt"));
					blnResult = common.setValue(strBondsTxt_XPATH,testData.get("strBondsValue"));
					break;

				case"ALTERNATEINVESTMENT":
					String strAlternativeInvestmentTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strAlternativeInvestmentTxt"));
					blnResult = common.setValue(strAlternativeInvestmentTxt_XPATH, testData.get("strAlternativeInvestmentValue"));
					break;

				case"OTHER":
					String strOtherTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strOtherTxt"));
					blnResult = common.setValue(strOtherTxt_XPATH, testData.get("strOtherValue"));
					break;

				case"ANNUITIES":
					String strAnnuitiesTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strAnnuitiesTxt"));
					blnResult = common.setValue(strAnnuitiesTxt_XPATH, testData.get("strAnnuitiesValue"));
					break;

				case"REALESTATE":
					String strRealEstateTxt_XPATH=strIndPerTxtBox_XPATH.replace("xxx",testData.get("strRealEstateTxt"));
					blnResult = common.setValue(strRealEstateTxt_XPATH, testData.get("strRealEstateValue"));
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
	 * This function is used to perform actions on TAMP/TPIA Consulting fee field section In Financial Page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectTAMPTPIAConsultingFeePage(String... strFinancialPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strFinancialPagePanels){
				switch(strPanel.toUpperCase()){	

				case "CONSULTINGFEE":
					String strConsltFeeTxt_XPATH=strTxtBoxCommon_XPATH.replace("xxx",testData.get("strConsltFeeTxt"));
					blnResult = common.setValue(strConsltFeeTxt_XPATH, testData.get("strConsltFeeValue"));
					break;

				case "SCHEDULEAGREE":
					blnResult = selectScheduleAgreeToAnRdoGrp(testData.get("strTampTpiaSec"),Integer.parseInt(testData.get("intYearStartAgree")),Integer.parseInt(testData.get("intYearEndAgree")));
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
	 * This function is used to perform actions on Sponsor Directed Plan Account field section In Financial Page
	 *
	 * @author Anshu Suman
	 * @version 1.0
	 * @since 
	 * @param String...
	 * @return String
	 **/
	public String  selectSponsorDirectedPlnPage(String... strFinancialPagePanels){
		boolean blnResult=false;
		String strResult= null;
		try{
			for(String strPanel:strFinancialPagePanels){
				switch(strPanel.toUpperCase()){	

				case "SPNSRDIRRTRDPLN":
					blnResult =common.selectRadiobutton(testData.get("strSponsorRtrPlnRdoGrp"),testData.get("strSponsorRtrPlnValue"));
					break;

				case "TOTALVALPLN":
					String strTotalPlanDrop_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSponsorDirectedSection")).replace("yyy", testData.get("strTotalPlanValDrop"));
					blnResult = common.selectDropDownBox(strTotalPlanDrop_XPATH, testData.get("strTotalPlanVal"),"");
					break;

				case "MAJORPART":
					blnResult =common.selectRadiobutton(testData.get("strMajorPartRdoGrp"),testData.get("strMajorPartValue"));
					break;

				case "CLASSIFYEMP":
					String strTotalPlanDrop1_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSponsorDirectedSection")).replace("yyy", testData.get("strClassifyEmpDrop"));
					blnResult = common.selectDropDownBox(strTotalPlanDrop1_XPATH, testData.get("strClassifyEmpVal"),"");
					break;

				case "CONTDISRELATION":
					String strTotalPlanDrop2_XPATH=strToclickCommAcc_XPATH.replace("xxx", testData.get("strSponsorDirectedSection")).replace("yyy", testData.get("strConDisRelDrop"));
					blnResult = common.selectDropDownBox(strTotalPlanDrop2_XPATH, testData.get("strConDisRelVal"),"");
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
			return strResult=null;	
		}
		return strResult;
	}
	
	/**
	 * This function is used to Click on Distribution Election Dropdown and to select Element from the Drop Down
	 *
	 * @author Sandeep
	 * @version 1.0
	 * @since 
	 * @param String
	 * @return boolean
	 **/
	public boolean  clickOnDistributionElectionLst(String strToClick , String strValue){
		boolean blnResult = false;
			try{
				//if strEle is empty directly click on the dropdown
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				LPLCoreSync.waitTillVisible(driver,By.xpath(strToClick), lplCoreConstents.HIGH);
				WebElement objXpathScroll = driver.findElement(By.xpath(strToClick));
				jse.executeScript("arguments[0].scrollIntoView(true);", objXpathScroll);			
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				objXpathScroll.click();
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				String  objxpathRepId = "//div[contains(@class,'aw_ext_componentextension_dropdownlist2')]//ul/li" +"[contains(text(),'" + strValue +"')]";
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				driver.findElement(By.xpath(objxpathRepId)).click();
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			blnResult = false;
		}
		return blnResult;
	}

}

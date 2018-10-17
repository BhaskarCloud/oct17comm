package PageObjectLibrary;


import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreSync;

import com.paulhammant.ngwebdriver.ByAngular;

/**
 * <p>
 * <br><b> Title: </b> NAOCommon.java</br>
 * <br><b> Description: </B> Page Object Library For creating New accounts </br>
 * <br><b>Usage:</br></b> 
 * <br>selectDropDownBox: This function is used to select an element from the dropdown.</br>
 * <br>selectDropDownBoxSendKeys: This function is used to select an element from the dropdown by sending the keys in the search field.</br>
 * <br>selectDropDown1: This function is used to select an element from the dropdown by scroliing to element.</br>
 * <br>setValue: This function is used to set an value to the text field.</br>
 * <br>selectRadiobutton: This function is used to select an radio option.</br>
 * <br>setPickdate: This function is used to pick the date from the date field.</br>
 * <br>ClickOnBtn: This function is used to Click on button using button text.</br>
 * <br>SwitchtoModalDialogue: This function is used to Switch to frame.</br>
 * <br>getRandomDate: This function is used to generate ranadom dates.</br>
 * <br>clickChechBox: This function is used to check or uncheck the checkbox.</br>
 * <br>ClickOnPlus: This function is used to click on  Object Starting with Plus Sign.</br>
 * <br>waitforProcessing: This function is used to wait for proccessing.</br>
 * <br>acceptDialog: This function is used to accept the dialog box.</br>
 * <br>generateSSN: This function is used to generate random SSN.</br>
 * <br>ClickOnREPID: This function is close automatic opening of dropdown.</br> 
 * <br>selectCommonTableLst: This function is used to handle dropdown boxx present in the table.</br>
 * <br>generateRandomAlphabets:This function is used to generate ransdom Alphabets.</br>
 * @author Jyothi Jyothi,Megha Megha,Jayant Bildani
 * @since 10-05-2016
 * </p>
 */

public class NAOCommon {
	public static HashMap<String, String> testData;
	private static final boolean True = false;

	/** Web Driver Reference */
	public WebDriver driver;

	/** String type...To be used to capture any error occurred at runtime. */
	public static String strError;

	/**Xpath property value of Dropdown List present in a table*/
	public String[] strTableDropDown_XPATH;

	public LPLCoreConstents lplCoreConstents;

	/** Xpath property value of Dropdown List Object */
	public String strForLstOfEle_XPATH;

	/** Xpath property value of Dropdown List Object */
	public String strListOfEle_XPATH;

	/** Xpath property value of Search Field Object */
	public String strDropdownSearchField_XPATH;

	/** Xpath property value of Radio Button Object */
	public String strRdoBtn_XPATH;

	/** Xpath property value of Date Picker Object */
	public String strDatePickersvg_XPATH;

	/** Xpath property value of Date Picker Year object */
	public String strDatePickYear_XPATH;

	/**Xpath Property value for search field present in the Search US address field**/
	public String strSearchField_XPATH;

	/**Xpath Property value for object starting with plus sign**/
	public String strPlusCommn_XPATH;

	/**Xpath Property value for Tsble dropdown**/
	public String objTableDropDown_XPATH;

	public static String strChkState="CHECK";

	/**Xpath Property value for Repid dropdown**/
	public String strRepId_XPATH;

	/**Xpath Property for Table Dropdown Elements**/
	public String strTableDropEle_XPATH; 

	/**Xpath Property for Wait for processing Elements**/
	public String strWaitForProcess_XPATH;

	/**Xpath Property for Wait for Load Elements**/
	public String strWaitForLoad_XPATH;

	public String strSVOKButton_Xpath="";

	public String strSVMasterRepID_xpath="";

	public String strSVLoginName_xpath="";

	public HomePage homePage;
	public String strValidateBtnTxt;
	public JavascriptExecutor jse;
	public int INT_PAGEID=116;

	public NAOCommon(WebDriver driver){

		try {
			this.driver = driver;
			homePage = new HomePage(driver);
			jse = (JavascriptExecutor)driver;
			lplCoreConstents = LPLCoreConstents.getInstance();

			/** Fetching the page objects from FARM */
			HashMap<String, HashMap<String, String>> PageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INT_PAGEID, new LPLConfig().getEnvId());

			if(PageObjectsMap.get("strForLstOfEle").get("XPATH")!=null)
				strForLstOfEle_XPATH = PageObjectsMap.get("strForLstOfEle").get("XPATH");

			if(PageObjectsMap.get("strDropdownSearchField").get("XPATH")!=null)
				strDropdownSearchField_XPATH = PageObjectsMap.get("strDropdownSearchField").get("XPATH");

			if(PageObjectsMap.get("strRdoBtn").get("XPATH")!=null)
				strRdoBtn_XPATH = PageObjectsMap.get("strRdoBtn").get("XPATH");


			if(PageObjectsMap.get("strDatePickersvg").get("XPATH")!=null)
				strDatePickersvg_XPATH = PageObjectsMap.get("strDatePickersvg").get("XPATH");

			if(PageObjectsMap.get("strDatePickYear").get("XPATH")!=null)
				strDatePickYear_XPATH = PageObjectsMap.get("strDatePickYear").get("XPATH");

			if(PageObjectsMap.get("strSearchField").get("XPATH")!=null)
				strSearchField_XPATH = PageObjectsMap.get("strSearchField").get("XPATH");

			if(PageObjectsMap.get("strPlusCommn").get("XPATH")!=null)
				strPlusCommn_XPATH = PageObjectsMap.get("strPlusCommn").get("XPATH");

			if(PageObjectsMap.get("objTableDropDown").get("XPATH")!=null)
				objTableDropDown_XPATH = PageObjectsMap.get("objTableDropDown").get("XPATH");

			if(PageObjectsMap.get("strListOfEle").get("XPATH")!=null)
				strListOfEle_XPATH = PageObjectsMap.get("strListOfEle").get("XPATH");

			if(PageObjectsMap.get("strRepId").get("XPATH")!=null)
				strRepId_XPATH = PageObjectsMap.get("strRepId").get("XPATH");

			if(PageObjectsMap.get("strTableDropEle").get("XPATH")!=null)
				strTableDropEle_XPATH = PageObjectsMap.get("strTableDropEle").get("XPATH");

			String[] strTableDropDown_XPATH = {strSearchField_XPATH,strTableDropEle_XPATH};
			this.strTableDropDown_XPATH = strTableDropDown_XPATH;

			if(PageObjectsMap.get("strWaitForProcess").get("XPATH")!=null)
				strWaitForProcess_XPATH = PageObjectsMap.get("strWaitForProcess").get("XPATH");

			if(PageObjectsMap.get("strWaitForLoad").get("XPATH")!=null)
				strWaitForLoad_XPATH = PageObjectsMap.get("strWaitForLoad").get("XPATH");

			if(PageObjectsMap.get("strSVMasterRepID").get("XPATH") != null)
				strSVMasterRepID_xpath=PageObjectsMap.get("strSVMasterRepID").get("XPATH");

			if(PageObjectsMap.get("strSVOKButton").get("XPATH") != null)
				strSVOKButton_Xpath=PageObjectsMap.get("strSVOKButton").get("XPATH");

			if(PageObjectsMap.get("strSVLoginName").get("XPATH") != null)
				strSVLoginName_xpath=PageObjectsMap.get("strSVLoginName").get("XPATH");

		} catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();	
		}
	}

	/**
	 * This function is used to select an element from the dropdown.
	 * @author Jyothi Jyothi
	 * @version 1.0
	 * @since 10-05-2016
	 * @return List<WebElement> list of dropdowns
	 */
	public boolean  selectDropDownBox(String strToClick , String strValue,String strEle , String...strList_xpath){
		try{ 
			if(strList_xpath.length>0){
				//replace current xpath with the xpath in the the strList(if the below xpaths are different for the dropdown)
				strDropdownSearchField_XPATH =strList_xpath[0];
				strForLstOfEle_XPATH = strList_xpath[1];
			}	
			boolean blnResult =True;
			if (blnResult==True){
				if(strEle.isEmpty()){
					//if strEle is empty directly click on the dropdown
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					LPLCoreSync.waitTillVisible(driver,By.xpath(strToClick), lplCoreConstents.HIGH);
					WebElement objXpathScroll = driver.findElement(By.xpath(strToClick));
					jse.executeScript("arguments[0].scrollIntoView(true);", objXpathScroll);			
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					objXpathScroll.click();
				}
				else{
					//if strEle is not empty get the list of Webelements
					List<WebElement> strToClick_XPATH = driver.findElements(By.xpath(strToClick));
					//get the size of that webelement
					int strToClickSize=driver.findElements(By.xpath(strToClick)).size();
					//decrease the size and click on the dropdown
					strToClick_XPATH.get(--strToClickSize).click();
				}
			}
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			int searchFieldSize = driver.findElements(By.xpath(strDropdownSearchField_XPATH)).size();
			//If the List has more than 10 elemets search field should appear after clicking on the drop down box

			if(driver.findElements(By.xpath(strForLstOfEle_XPATH)).size()>10){

				List<WebElement> objRepDropdownSearchField = driver.findElements(By.xpath(strDropdownSearchField_XPATH));

				if( searchFieldSize>0 ){
					objRepDropdownSearchField.get(--searchFieldSize).sendKeys(strValue);
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					String 	objxpathRepId = strForLstOfEle_XPATH + "/span[text()='" + strValue +"']";
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					driver.findElement(By.xpath(objxpathRepId)).click();
				}
				else{
					int objRepDropdownSearchFieldsize=driver.findElements(By.xpath(strDropdownSearchField_XPATH)).size();
					if(objRepDropdownSearchFieldsize>0){
						objRepDropdownSearchField.get(--objRepDropdownSearchFieldsize).sendKeys(strValue);
					}
					String 	objxpathRepId = strForLstOfEle_XPATH + "/span[text()='" + strValue +"']";
					LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
					driver.findElement(By.xpath(objxpathRepId)).click();
				}
			}
			else{

				//If the List has more than 4 elemets Scroll bar should be visible after clicking on the dropdown box

				if(driver.findElements(By.xpath(strForLstOfEle_XPATH)).size()> 4){
					if(driver.findElements(By.xpath(strForLstOfEle_XPATH +"[contains(text(),'" + strValue +"')]")).size()==1){
						String  objxpath = strForLstOfEle_XPATH +"[contains(text(),'" + strValue +"')]";
						WebElement objxpathScroll = driver.findElement(By.xpath(objxpath));
						jse.executeScript("arguments[0].scrollIntoView(true);", objxpathScroll);
						LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
						objxpathScroll.click();
					}
					else{
						String objxpath = strForLstOfEle_XPATH + "[starts-with(text(),'" + strValue +"')]";
						WebElement objxpathScroll=driver.findElement(By.xpath(objxpath));

						jse.executeScript("arguments[0].scrollIntoView(true);", objxpathScroll);
						LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
						objxpathScroll.click();
					}
				}
				else{
					//If the List has less than 4 elemets it should be visible to Click
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					String  objxpathRepId = strForLstOfEle_XPATH +"[contains(text(),'" + strValue +"')]";
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					driver.findElement(By.xpath(objxpathRepId)).click();
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				}
			}   
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
		return true;
	}


	/**
	 * This function is used to select an element from the dropdown by sending the keys in the search field.
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 10-05-2016
	 * @return List<WebElement> list of dropdowns
	 */
	public boolean  selectDropDownBoxSendKeys(String strToClick , String strValue,String strFlag){
		try{
			if(strFlag.isEmpty()){
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				LPLCoreSync.waitTillVisible(driver,By.xpath(strToClick), lplCoreConstents.HIGH);
				WebElement objSearchUS = driver.findElement(By.xpath(strToClick));
				objSearchUS.click();
			}
			else{
				//get list of webelements
				List<WebElement> strToClick_XPATH = driver.findElements(By.xpath(strToClick));
				int strToClickSize=driver.findElements(By.xpath(strToClick)).size();
				strToClick_XPATH.get(--strToClickSize).click();
			}
			LPLCoreSync.waitTillVisible(driver,By.xpath(strSearchField_XPATH), lplCoreConstents.HIGH);
			WebElement strSearchField =driver.findElement(By.xpath(strSearchField_XPATH));
			strSearchField.click();
			//Enter value in the search field
			strSearchField.sendKeys(strValue);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			LPLCoreSync.waitTillVisible(driver,By.xpath(strSearchField_XPATH), lplCoreConstents.HIGH);
			//click on the element
			strSearchField.sendKeys(Keys.RETURN);
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This function is used to select an element from the dropdown by scroliing to element.(use in execeptional cases like Phone type slection )
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean  selectDropDown1(String strToClick , String strValue,String strListXPATH ){
		try{
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			LPLCoreSync.waitTillVisible(driver,By.xpath(strToClick), lplCoreConstents.HIGH);
			WebElement objSearchUS = driver.findElement(By.xpath(strToClick));
			//click on the dropdown box
			objSearchUS.click();
			if(strListXPATH.isEmpty()){
				String  objxpathRepId = strForLstOfEle_XPATH +"[text()='" + strValue +"']";
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				//click on the element
				driver.findElement(By.xpath(objxpathRepId)).click();
			}
			else{
				String  objxpathRepId = strListOfEle_XPATH +"[text()='" + strValue +"']";
				LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
				driver.findElement(By.xpath(objxpathRepId)).click();
			}		   
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This function is used to set an value to the text field.
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean  setValue( String strTxtBox, String strTxtValue ){
		try{
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			LPLCoreSync.waitTillVisible(driver,By.xpath(strTxtBox), lplCoreConstents.HIGH);
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strTxtBox)));
			driver.findElement(By.xpath(strTxtBox)).click();
			driver.findElement(By.xpath(strTxtBox)).clear();
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			driver.findElement(By.xpath(strTxtBox)).clear();
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			//set value to the text field
			driver.findElement(By.xpath(strTxtBox)).sendKeys(strTxtValue);
			return true;
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
	}


	/**
	 * This function is used to select an radio option.
	 * @author Jyothi Jyothi
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean  selectRadiobutton(  String strRdoGrp, String strValue ){
		try{
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			String strRdobtn=strRdoBtn_XPATH.replace("xxx", strRdoGrp).replace("yyy", strValue);
			LPLCoreSync.waitTillVisible(driver,By.xpath(strRdobtn), lplCoreConstents.HIGH);
			driver.findElement(By.xpath(strRdobtn));
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(strRdobtn)));
			driver.findElement(By.xpath(strRdobtn)).click();
			LPLCoreSync.waitTillVisible(driver,By.xpath(strRdobtn), lplCoreConstents.HIGH);
			return true;
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
	}	


	/**
	 * This function is used to pick the date from the date field
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean  setPickdate( String strSection,String strValue, String strDatemmdyyyy,String... strDate_xpath ){
		try{
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			if(strDate_xpath.length>0){
				strDatePickersvg_XPATH =strDate_xpath[0];
			}
			String strxpathDatePicker =strDatePickersvg_XPATH.replace("xxx", strSection).replace("yyy", strValue);
			LPLCoreSync.waitTillVisible(driver,By.xpath(strxpathDatePicker), lplCoreConstents.HIGH);
			//SPlit the date string for Month/Date and Year
			LPLCoreSync.waitTillVisible(driver,By.xpath(strxpathDatePicker), lplCoreConstents.HIGH);
			String[] strDateArray=strDatemmdyyyy.split("/");
			//Click on the Date picker element
			driver.findElement(By.xpath(strxpathDatePicker)).click();
			//Clear the content in year  fiand type the new value for year/ Month and date is clicked
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			driver.findElement(By.xpath(strDatePickYear_XPATH)).clear();
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			driver.findElement(By.xpath(strDatePickYear_XPATH)).sendKeys(strDateArray[2]) ;
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			driver.findElement(By.xpath("//div[contains(@class,'componentextension_datepicker')][contains(@class,'widget')]//option["+ strDateArray[0] + "]")).click();
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			driver.findElement(By.xpath("//div[contains(@class,'componentextension_datepicker')][contains(@class,'widget')]//td[(text()='"+ strDateArray[1]+"')][not ((contains(@class,'prev')) or (contains(@class,'next')))]")).click();
			return true;
		}
		catch (Exception ex) {
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}       
	}

	/**
	 * This function is used to Click on button using button text.
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean  ClickOnBtn(String strBtnTxt){
		boolean blnResult = false;
		try{
			//Wait for the Objects to get loaded...
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			waitforProcessing();
			LPLCoreSync.waitTillVisible(driver,ByAngular.buttonText(strBtnTxt), lplCoreConstents.HIGH);
			driver.findElement(ByAngular.buttonText(strBtnTxt)).click();
			LPLCoreSync.staticWait(homePage.lplCoreConstents.MediumInMiliSec);
			blnResult = true;	 
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
		return blnResult;
	}

	/**
	 * This function is used to Switch to frame.
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean  SwitchtoModalDialogue(){
		boolean blnResult = false;
		try{
			blnResult = homePage.switchTo("Frame", "modaliframe");
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			blnResult = true;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
		return blnResult;
	}


	/**
	 * This function is used to generate ranadom dates.
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public static String getRandomDate(int intYearStart ,int intYearEnd)
	{
		try{
			//intialize date with null
			String date="";
			int yearEnd=intYearEnd-intYearStart;
			date=""+(1 + (int)(Math.random() * 12)+"/"+(1 + (int)(Math.random() * 28)+"/"+(intYearStart + (int)(Math.random() * yearEnd))));
			return date;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
		}
		return strError;
	}	


	/**
	 * This function is used to check or uncheck the checkbox
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean  clickChechBox(String strChechBox,String strChkState){

		try{
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			WebElement strChkBoxXPATH = driver.findElement(By.xpath(strChechBox));
			LPLCoreSync.waitTillVisible(driver,By.xpath(strChechBox), lplCoreConstents.HIGH);
			if(strChkState.equalsIgnoreCase("CHECK")){
				//if check box is not checked ,check the check box
				if(!strChkBoxXPATH.isSelected()){
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					strChkBoxXPATH.click();
				}
				else{
					return true;
				}	
			}
			else{
				//if check box is  checked ,Uncheck the check box
				if(strChkBoxXPATH.isSelected()){
					LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
					strChkBoxXPATH.click();
				}
				else{
					return true;
				}
			}
			return true;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
	}


	/**
	 * This function is used to click on  Object Starting with Plus Sign.
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean  ClickOnPlus(String strOnPlus){
		boolean blnResult = false;
		try{
			//Wait for the Objects to get loaded...
			String strPlusSign_XPATH =strPlusCommn_XPATH.replace("xxx",strOnPlus);

			LPLCoreSync.waitTillVisible(driver,By.xpath(strPlusSign_XPATH), lplCoreConstents.HIGH);
			driver.findElement(By.xpath(strPlusSign_XPATH)).click();

			blnResult = true;
		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
		return blnResult;
	}

	/**
	 * This function is used to wait for proccessing.
	 *  @author Jayant bildani
	 *  @version 1.0
	 * @since 10-05-2016
	 */
	public void waitforProcessing()
	{
		LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
		LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
	}

	/**
	 * This function is used to accept the dialog box.
	 * @author Megha
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean acceptDialog(){
		boolean blnResult = false;
		try{
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			Alert alert= driver.switchTo().alert();
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			alert.accept();
			LPLCoreSync.staticWait(homePage.lplCoreConstents.BaseInMiliSec);
			blnResult = true;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			blnResult = false;
		}
		return blnResult;
	}

	/**
	 * This function is close automatic opening of dropdown.
	 * @author Megha Megha 
	 * @version 1.0
	 * @since 10-05-2016
	 */
	public boolean  ClickOnREPID(){
		boolean blnResult = false;
		try{
			LPLCoreSync.staticWait(homePage.lplCoreConstents.LOWESTInMiliSec);
			WebElement RepID = driver.findElement(By.xpath(strRepId_XPATH));
			RepID.click();

		}catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
		}
		return blnResult;
	}


	/**
	 * This function is used to handle dropdown box present in the table
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 02-07-2017
	 */
	public boolean selectCommonTableLst(String[] strPortfolioTabledropValue,String strTable_XPATH,String strVal,String strDropDown_XPATH) {
		boolean blnResult = false;
		try {
			LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
			List<WebElement>elements=driver.findElement(By.xpath(strTable_XPATH)).findElements(By.tagName("tr"));
			int i = elements.size();
			int j = 1;
			int l = 0;
			for (j = 1; j <= i; j++) {
				if(strVal.isEmpty()){

					for ( int k = 1; k <= 2; k++) {
						String strXpath = strTable_XPATH +"//tr["+Integer.toString(j)+"]/td[" + Integer.toString(k) + strDropDown_XPATH;
						LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
						selectDropDownBox(strXpath,strPortfolioTabledropValue[l], "",strTableDropDown_XPATH[0], strTableDropDown_XPATH[1]);
						l++;
						homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
						blnResult = true;
					}
				}
				else{
					for ( int k = 2; k <= 2; k++) {
						String strXpath = strTable_XPATH +"//tr["+Integer.toString(j)+"]/td[" + Integer.toString(k) + strDropDown_XPATH;
						LPLCoreSync.staticWait(homePage.lplCoreConstents.UNITINMILLISEC);
						selectDropDownBox(strXpath,strPortfolioTabledropValue[l], "",strTableDropDown_XPATH[0], strTableDropDown_XPATH[1]);
						l++;
						homePage.waitForPageLoading(homePage.lplCoreConstents.LOW);
						blnResult = true;
					}
				}
			}
			return blnResult;
		} catch (Exception ex) {
			strError = strError + ex.getMessage();
			ex.printStackTrace();
			return blnResult;
		}
	}

	/**
	 * This function is used to generate ransdom Alphabets
	 * @author Jyothi Jyothi 
	 * @version 1.0
	 * @since 03-10-2017
	 */
	public String generateRandomAlphabets()
	{
		try{
			String s = RandomStringUtils.randomAlphabetic(8);
			return s; 
		}
		catch (Exception ex) {
			strError = strError + ex.getMessage();
			ex.printStackTrace();
			return null;}
	}
}

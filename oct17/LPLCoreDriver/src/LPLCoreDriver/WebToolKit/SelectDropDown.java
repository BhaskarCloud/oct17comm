package LPLCoreDriver.WebToolKit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;

/**
 * <p>
 * <br><b> Title: </b> SelectDropDown.java</br>
 * <br><b> Description: </B> Drop down Utility Class</br>
 * <br><b>Usage:</br></b>
 * <br>1. SelectDropDown: Constructor to initiate the Dropdown object.</br>
 * <br>2. selectDropDownByValue: This function is used to select the drop down by value.</br>
 * <br>3. selectInputDropDownByValue: This function is used to select the value in an Input type drop down.</br>
 * <br>4. selectDropDownByIndex: This function is used to select the drop down by index.</br>
 * <br>5. selectValueByVisibleText: This function is used to select the value by visible text.</br>
 * <br>6. getAllOptions: This function is used to get the list of all the drop down values.</br>
 * <br>7. selectValueByCheckBox: This function is used to select the value by selecting the check box in the drop down.</br>
 * @author Ambarish Khatua
 * @since 05-25-2016 
 * </p>
 */
public class SelectDropDown {
	
	/** WebDriver Instance */
	public WebDriver driver;
	
	/** By Identification Property */
	public By byIdentificationProeprty;
	
	/** WebElement */
	public WebElement objSelectElement = null;
	
	/** DropDown WebElement  */
	public Select objSelect = null;
	
	/** Error String  */
	public String strError;
	
	JavascriptExecutor js;
	
	public SelectDropDown(WebDriver driver, By byIdentificationProeprty){
		this.byIdentificationProeprty = byIdentificationProeprty;
		this.driver			  		  = driver;
	}
	
	/**
	* This function is used to select the drop down by value  
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   08-22-2016
	* @param   String value - DropDown value to select 
	* @return  boolean true/false
	*/
	public boolean selectDropDownByValue(String strValue){
		try{
			LPLCoreSync.waitTillVisible(driver, byIdentificationProeprty, LPLCoreConstents.getInstance().BaseInMiliSec);
			objSelectElement = driver.findElement(byIdentificationProeprty);
			if(objSelectElement.isDisplayed()){
				objSelect = new Select(objSelectElement);
				objSelect.selectByValue(strValue);
				return true;
			}else{
				strError = "DropDown object is not displayed.";
				return false;
			}
		}catch(Exception ex){
			strError = ex.toString();
			return false;
		}
	}
	
	/**
	* This function is used to select the value in an Input type drop down 
	*
	* @author  Aiswarya Srinivasan
	* @version 1.0
	* @since   11-22-2016
	* @param   String value - DropDown value to select 
	* @return  boolean true/false
	*/
	public boolean selectInputDropDownByValue(By ComboBoxArrow,By DDList, String strValue){
		boolean blnResult =false;
		try{
			js = (JavascriptExecutor) driver;
			LPLCoreUtil.waitForWebElement(LPLCoreConstents.getInstance().BASE, ComboBoxArrow);
			WebElement objSelectArrow = driver.findElement(byIdentificationProeprty);
			if(objSelectArrow.isEnabled()){
				js.executeScript("arguments[0].scrollIntoView(true);", objSelectArrow);
				js.executeScript("arguments[0].click();", objSelectArrow);
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
				List<WebElement> objDDlist = driver.findElements(DDList);
				for(WebElement thisDDElement: objDDlist){
					if(thisDDElement.getText().trim().equalsIgnoreCase(strValue.trim())){
						js.executeScript("arguments[0].scrollIntoView(true);", thisDDElement);
						js.executeScript("arguments[0].click();", thisDDElement);
						blnResult = true;
						break;
					}
				}
				return blnResult;
			}
				
			else{
				strError = "DropDown object is not displayed.";
				return false;
			}
		}catch(Exception ex){
			strError = ex.toString();
			return false;
		}
	}
	
	/**
	* This function is used to select the drop down by index  
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   08-22-2016
	* @param   int inIndex - Index of the dropdown value to select 
	* @return  boolean true/false
	*/
	public boolean selectDropDownByIndex(int inIndex){
		try{
			LPLCoreSync.waitTillVisible(driver, byIdentificationProeprty, LPLCoreConstents.getInstance().BaseInMiliSec);
			objSelectElement = driver.findElement(byIdentificationProeprty);
			if(objSelectElement.isDisplayed()){
				objSelect = new Select(objSelectElement);
				objSelect.selectByIndex(inIndex);
				return true;
			}
			else{
				strError = "DropDown object is not displayed.";
				return false;
			}
		}catch(Exception ex){
			strError = ex.toString();
			return false;
		}
	}
	
	/**
	* This function is used to select the value by visible text  
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   08-22-2016
	* @param   String strVisibletext - Visible text to be selected 
	* @return  boolean true/false
	*/
	public boolean selectValueByVisibleText(String strVisibletext){
		try{
			LPLCoreSync.waitTillVisible(driver, byIdentificationProeprty, LPLCoreConstents.getInstance().BaseInMiliSec);
			objSelectElement = driver.findElement(byIdentificationProeprty);
			if(objSelectElement.isDisplayed()){
				objSelectElement.click();
				objSelect = new Select(objSelectElement);
				objSelect.selectByVisibleText(strVisibletext);
				return true;
			}
			else{
				strError = "DropDown object is not displayed.";
				return false;
			}
		}catch(Exception ex){
			strError = ex.toString();
			return false;
		}
	}
	
	/**
	* This function is used to get the list of all the drop down values  
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   08-22-2016
	* @param   N/A 
	* @return  List<WebElement> lstAllOptions 
	*/
	public List<WebElement> getAllOptions(){
		try{
			LPLCoreSync.waitTillVisible(driver, byIdentificationProeprty, LPLCoreConstents.getInstance().BaseInMiliSec);
			objSelectElement = driver.findElement(byIdentificationProeprty);
			if(objSelectElement.isDisplayed()){
				objSelect = new Select(objSelectElement);
				List<WebElement> lstAllOptions = objSelect.getOptions();
				return lstAllOptions;
			}
			else{
				strError = "DropDown object is not displayed.";
				return null;
			}
		}catch(Exception ex){
			strError = ex.toString();
			return null;
		}
	}
	
	/**
	* This function is used to select the value by selecting the check box in the drop down 
	*
	* @author  Rahul Agarwal
	* @version 1.0
	* @since   12-13-2016
	* @param   dropDownArrow - locator property for the dropdown arrow.
	* 			 strLocatorProperty - locator property for the check box against that value.
	* @return  boolean - true/false 
	*/
	public boolean selectValueByCheckBox(By dropDownArrow, By strLocatorProperty){
		boolean blnResult = false;
		JavascriptExecutor je = ((JavascriptExecutor) driver);
		try{
			LPLCoreSync.waitTillVisible(driver, dropDownArrow, LPLCoreConstents.getInstance().BaseInMiliSec);
			driver.findElement(dropDownArrow).click();
			LPLCoreSync.waitTillVisible(driver, strLocatorProperty, LPLCoreConstents.getInstance().BaseInMiliSec);
			WebElement checkBoxDD = driver.findElement(strLocatorProperty);
			je.executeScript("arguments[0].scrollIntoView(true);", checkBoxDD);
			if(!checkBoxDD.isSelected())
				driver.findElement(strLocatorProperty).click();
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
			driver.findElement(dropDownArrow).click();
			blnResult = true;
		}catch(Exception ex){
			strError = strError + ex.getMessage();
			blnResult = false;
		}
		return blnResult;
	}
}

package LPLCoreDriver.WebToolKit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreUtil;

/**
 * <p>
 * <br><b> Title: </b> WebEdit.java</br>
 * <br><b> Description: </B> Web Edit Utility Class</br>
 * <br><b>Usage:</br></b>
 * <br>1. setWebEditValue: This function is used to Set value in any web edit in Any page , Throws Exception,when not found.</br>
 * <br>2. clearWebEditValue: This function is used to clear the value in any web edit in Any page , Throws Exception,when not found. </br>
 * @author Aiswarya Srinivasan
 * @since 04-17-2017 
 * </p>
 */
public class WebEdit {
	
	public String strError;
	
	/**
	 * This function is used to Set value in any web edit in Any page , Throws Exception,when not found.
	 * @author Aiswarya
	 * @version 1.0
	 * @since 04-17-2017
	 * @param Webdriver driver - driver Control, By TextBoxbyProperty - By Property of the Text box, strValue - Value to be set in the text box
	 * @return boolean (true/false)
	 */
	public boolean setWebEditValue(WebDriver driver, By TextBoxbyProperty, String strValue){
		boolean blnWebEditFound = false;
		try{
			WebElement objWebEdit = LPLCoreUtil.waitForWebElement(
					LPLCoreConstents.getInstance().FAIR,
					TextBoxbyProperty);
			if (objWebEdit.isDisplayed()) {
					objWebEdit.sendKeys(strValue);
					blnWebEditFound = true;
			}
			return blnWebEditFound;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
	   }
	}
	
	/**
	 * This function is used to clear the value in any web edit in Any page , Throws Exception,when not found.
	 * @author Sunitha
	 * @version 1.0
	 * @since 01-02-2018
	 * @param Webdriver driver - driver Control, By TextBoxbyProperty - By Property of the Text box
	 * @return boolean (true/false)
	 */
	public boolean clearWebEditValue(WebDriver driver, By textBoxbyProperty){
		boolean blnClearWebEditValue = false;
		try{
			WebElement objWebEdit = LPLCoreUtil.waitForWebElement(
					LPLCoreConstents.getInstance().FAIR,
					textBoxbyProperty);
			if (objWebEdit.isDisplayed()) {
					objWebEdit.clear();
					blnClearWebEditValue = true;
			}
			return blnClearWebEditValue;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			return false;
	   }
	}
}

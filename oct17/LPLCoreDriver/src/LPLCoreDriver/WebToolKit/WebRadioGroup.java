package LPLCoreDriver.WebToolKit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreSync;
import LPLCoreDriver.LPLCoreUtil;

/**
 * <p>
 * <br><b> Title: </b> WebRadioGroup.java</br>
 * <br><b> Description: </B> Web Radio Group Utility Class</br>
 * <br><b>Usage:</br></b>
 * <br>1. clickRadioButton: This function is used to click on Radio webelement in Any page , Throws Exception,when not found.</br>
 * @author Aiswarya Srinivasan
 * @since 04-17-2017 
 * </p>
 */
public class WebRadioGroup {
	
	public String strError;
	
	/**
	 * This function is used to click on Radio webelement in Any page , Throws Exception,when not found.
	 * @author Aiswarya
	 * @version 1.0
	 * @since 04-17-2017
	 * @param Webdriver driver - driver Control, By RadiobyProperty - By Property of the Radio button
	 * @return boolean (true/false)
	 */
	public boolean clickRadioButton(WebDriver driver, By RadiobyProperty){
		boolean blnRadioButtonFound = false;
		try{
			blnRadioButtonFound = LPLCoreSync.waitTillVisible(driver, RadiobyProperty, LPLCoreConstents.getInstance().FAIR);
			if (blnRadioButtonFound) {
				LPLCoreUtil.waitForWebElement(LPLCoreConstents.getInstance().FAIR, RadiobyProperty).click();
			}
			return blnRadioButtonFound;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
	   }
	}
}

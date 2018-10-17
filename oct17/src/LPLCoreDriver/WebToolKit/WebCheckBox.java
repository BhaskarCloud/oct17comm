package LPLCoreDriver.WebToolKit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreUtil;

/**
 * <p>
 * <br><b> Title: </b> WebCheckBox.java</br>
 * <br><b> Description: </B> Web Check Box Utility Class</br>
 * <br><b>Usage:</br></b>
 * <br>1. selectCheckBox: This function is used to click on Check box in Any page , Throws Exception,when not found..</br>
 * @author Aiswarya Srinivasan
 * @since 04-17-2017 
 * </p>
 */
public class WebCheckBox {
	
	public String strError;
	
	/**
	 * This function is used to click on Check box in Any page , Throws Exception,when not found.
	 * @author Aiswarya
	 * @version 1.0
	 * @since 04-17-2017
	 * @param Webdriver driver - driver Control, By checkBoxByProperty - By Property of the Check box
	 * @return boolean (true/false)
	 */
	public boolean selectCheckBox(WebDriver driver, By checkBoxByProperty){
		boolean blnCheckBoxFound = false;
		try{
			WebElement objCheckBox = LPLCoreUtil.waitForWebElement(
					LPLCoreConstents.getInstance().FAIR,
					checkBoxByProperty);
			if (objCheckBox.isDisplayed()) {
				if (!objCheckBox.isSelected()) {
					objCheckBox.click();
					blnCheckBoxFound = true;
				}else{
					blnCheckBoxFound = true;
				}
			}
			return blnCheckBoxFound;
		}
		catch(Exception ex){
			strError = strError+ex.getMessage();
			ex.printStackTrace();
			return false;
	   }
	}
}

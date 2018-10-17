package LPLCoreDriver.WebToolKit;

/** Import Selenium related Class */
import org.openqa.selenium.WebElement;


/**
 * <p>
 * <br><b> Title: </b> Link.java</br>
 * <br><b> Description: </B> Link Utility Class</br>
 * <br><b>Usage:</br></b>
 * <br>1. clickLink: This function is used to  click on the Link.</br>
 * <br>2. getLinkAttribute: This function is used to  get the attribute value of a link.</br>
 * @author Ambarish Khatua
 * @since 05-25-2016 
 * </p>
 */
public class Link {
 public static String attributeValue;
	/**
	* This function is used to  click on the Link 
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   05-30-2016
	* @param   WebElement link - Link object 
	* @return  boolean blnReturn - True/False
	*/
	public static boolean clickLink(WebElement link){
		boolean blnReturn = false;
		
		try{
			//If the link is displayed, click on it.
			if (link.isDisplayed()){
				link.click();
				blnReturn = true;
			}
			else{
				blnReturn = false;
			}
			return blnReturn;			
		} 
		catch(Exception e){
			return blnReturn;
		}
	}
	
	/**
	* This function is used to  get the attribute value 
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   05-30-2016
	* @param   WebElement link - Link object, String attributeName - Attribute Name
	 * @return 
	* @return  String attributeValue - Attribute Value
	*/
	public static String getLinkAttribute(WebElement link, String attributeName){
		
		try{
			//If the link is displayed, get the attribute value.
			if (link.isDisplayed()){
				switch(attributeName.toUpperCase()){
				case "TEXT":
					attributeValue = link.getText();
					break;
				case "CLASS":
				case "VALUE":
					attributeValue = link.getAttribute(attributeName);
					break;
				}
			}
			return attributeValue;			
		} 
		catch(Exception e){
			return attributeValue;
		}
	}
	
}

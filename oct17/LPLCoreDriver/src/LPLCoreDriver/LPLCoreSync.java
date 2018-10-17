package LPLCoreDriver;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

/**
 * <p>
 * <br>
 * <b> Title: </b> LPLCoreSync.java</br> <br>
 * <b> Description: </B> LPL Core Library - Sync Methods common for all Applications</br> <br>
 * <b>Usage:</br></b> 
 * <br>1. waitTillVisible: This function is used to wait till the WebElement is Visible</br>
 * <br>2. waitTillInVisible: This function is used to wait till the WebElement is Invisible</br>
 * <br>3. waitTillAttributeContains: This function is used to wait till the WebElement's Attribute contains some specified value</br>
 * <br>4. staticWait: This function is used to keep the thread in sleep for few seconds</br>
 * <br>5. waitForWebElements: This function is used to get a webelement by atleast one of the locators specified</br>
 * <br>6. waitForWebElement: This function is used to get a webelement by mentioned locator within the max time specified</br>
 * <br>7. waitForFrameToBeAvailableAndSwitchToIt: This function is used to wait for farm to be available and to switch to it</br>
 * <br>8. waitForAlert: This function is to wait for an alert</br>
 * @author Aiswarya Srinivasan
 * @since 02-24-2017
 *        </p>
 */
public class LPLCoreSync{

	/**
	 * This function is used to wait till the WebElement is Visible
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 07-05-2016
	 * @param WebDriver driver - Driver control, 
	 * 			By byLocator - By locator of the Webelement to find, 
	 * 			intTimeOutInSeconds - Time out in Seconds
	 * @return Boolean true if the attribute value is achieved, else false
	 */
	public static boolean waitTillVisible(WebDriver driver, By byLocator, int intTimeOutInSeconds){
		try{
			new WebDriverWait(driver, intTimeOutInSeconds).until(new Function<WebDriver, Boolean>() {
		        @Override
		        public Boolean apply(WebDriver driver) {
		        	boolean isElementDisplayed = false;
		        	StopWatch sw = new StopWatch();
		    		sw.start();
		    		try {
		    			while (!isElementDisplayed && sw.getTime() < intTimeOutInSeconds * 1000) {
		    				try {
		    					if (driver.findElement(byLocator).isDisplayed()) {
		    						isElementDisplayed = true;
								}
		    					break;
		    				} catch (Exception e) {

		    				}
		    			}
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    		return isElementDisplayed;
		        }
		    });
//			new WebDriverWait(driver, intTimeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(byLocator));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * This function is used to wait till the WebElement is Invisible
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 07-05-2016
	 * @param WebDriver driver - Driver control, 
	 * 			By byLocator - By locator of the Webelement to find, 
	 * 			intTimeOutInSeconds - Time out in Seconds
	 * @return Boolean true if the attribute value is achieved, else false
	 */
	public static boolean waitTillInVisible(WebDriver driver, By byLocator, int intTimeOutInSeconds){
		try{
			new WebDriverWait(driver, intTimeOutInSeconds).until(new Function<WebDriver, Boolean>() {
		        @Override
		        public Boolean apply(WebDriver driver) {
		        	boolean isElementNotDisplayed = false;
		        	StopWatch sw = new StopWatch();
		    		sw.start();
		    		try {
		    			while (isElementNotDisplayed && sw.getTime() < intTimeOutInSeconds * 1000) {
		    				try {
		    					if (!driver.findElement(byLocator).isDisplayed()) {
		    						isElementNotDisplayed = true;
								}
		    					break;
		    				} catch (Exception e) {

		    				}
		    			}
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    		return isElementNotDisplayed;
		        }
		    });
			//new WebDriverWait(driver, intTimeOutInSeconds).until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * This function is used to wait till the WebElement is Visible
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 07-05-2016
	 * @param WebDriver driver - Driver control, 
	 * 			By byLocator - By locator of the Webelement to find, 
	 * 			intTimeOutInSeconds - Time out in Seconds
	 * @return Boolean true if the attribute value is achieved, else false
	 */
	public static boolean waitTillClickable(WebDriver driver, By byLocator, int intTimeOutInSeconds){
		try{
			new WebDriverWait(driver, intTimeOutInSeconds).until(new Function<WebDriver, Boolean>() {
		        @Override
		        public Boolean apply(WebDriver driver) {
		        	boolean isElementDisplayed = false;
		        	StopWatch sw = new StopWatch();
		    		sw.start();
		    		try {
		    			while (!isElementDisplayed && sw.getTime() < intTimeOutInSeconds * 1000) {
		    				try {
		    					if (driver.findElement(byLocator).isEnabled() && driver.findElement(byLocator).isDisplayed()) {
		    						isElementDisplayed = true;
								}
		    					break;
		    				} catch (Exception e) {

		    				}
		    			}
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    		return isElementDisplayed;
		        }
		    });
//			new WebDriverWait(driver, intTimeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(byLocator));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	/**
	 * This function is used to wait till the WebElement's Attribute contains some specified value
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 07-05-2016
	 * @param WebDriver driver - Driver control, 
	 * 			By byLocator - By locator of the Webelement to find, 
	 * 			String strAttribute - Attribute to check, 
	 * 			String strValue - Expected Value of the Attribute mentioned, 
	 * 			intTimeOutInSeconds - Time out in Seconds
	 * @return Boolean true if the attribute value is achieved, else false
	 */
	public static boolean waitTillAttributeContains(WebDriver driver, By byLocator, String strAttribute, String strValue, int intTimeOutInSeconds){
		try{
			new WebDriverWait(driver, intTimeOutInSeconds).until(new Function<WebDriver, Boolean>() {
		        @Override
		        public Boolean apply(WebDriver driver) {
		        	boolean blnAttributeContain = false;
		        	StopWatch sw = new StopWatch();
		    		sw.start();
		    		try {
		    			while (!blnAttributeContain && sw.getTime() < intTimeOutInSeconds * 1000) {
		    				try {
		    					if (driver.findElement(byLocator).getAttribute(strAttribute).contains(strValue)) {
		    						blnAttributeContain = true;
								}
		    					break;
		    				} catch (Exception e) {

		    				}
		    			}
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    		return blnAttributeContain;
		        }
		    });
			//new WebDriverWait(driver, intTimeOutInSeconds).until(ExpectedConditions.attributeContains(byLocator, strAttribute, strValue));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * This function is used to keep the thread in sleep for few seconds
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 07-05-2016
	 * @param intTimeOutInMilliSeconds - Time out in MilliSeconds
	 * @return None
	 */
	public static void staticWait( int intTimeOutInMilliSeconds){
		try{
			Thread.sleep(intTimeOutInMilliSeconds);
		}catch(Exception e){
			
		}
	}
	
	/**
	 * This function is used to get a webelement by atleast one of the locators specified
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 07-05-2016
	 * @param intMaxTimeInSeconds - Maximum time to wait for all the locators, strLocators - All the locators in an array
	 * @return WebElement - The Element which is found in the application within the specified ones
	 */
	public static WebElement waitForWebElements(WebDriver driver, int intMaxTimeInSeconds, By... strLocators) throws Exception {
		try {
			Boolean isElementFound = false;
			By foundLocator = null;
			StopWatch sw = new StopWatch();
			try {
				while (!isElementFound && sw.getTime() < intMaxTimeInSeconds * 1000) {
					for (int i = 0; i < strLocators.length; i++) {
						if (driver.findElements(strLocators[i]).size() > 0) {
							isElementFound = true;
							foundLocator = strLocators[i];
							break;
						}
					}

				}
			} catch (Exception e) {
				throw new Exception();
			}
			if (!isElementFound) {
				throw new Exception();
			}
			return driver.findElement(foundLocator);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * This function is used to get a webelement by mentioned locator within the max time specified
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 07-05-2016
	 * @param strLocatorType - Locator type of the web element we are trying to find, 
	 * strLocator - Locator string, intMaxTime - Maximum time to wait for the Webelement
	 * @return By foundLocator - The Locator which is found in the application within the specified ones
	 */
	public static WebElement waitForWebElement(WebDriver driver, String strLocatorType, String strLocator, int intMaxTimeInSeconds) {
		Boolean isElementFound = false;
		By byLocator = null;
		try {
			switch (strLocatorType.toUpperCase()) {
			case "CLASS":
				byLocator = By.className(strLocator);
				break;
			case "XPATH":
				byLocator = By.xpath(strLocator);
				break;
			case "TAGNAME":
				byLocator = By.tagName(strLocator);
				break;
			case "CSS":
				byLocator = By.cssSelector(strLocator);
				break;
			case "ID":
				byLocator = By.id(strLocator);
				break;
			case "NAME":
				byLocator = By.name(strLocator);
				break;
			case "LINKTEXT":
				byLocator = By.linkText(strLocator);
				break;
			case "PARTIALLINKTEXT":
				byLocator = By.partialLinkText(strLocator);
				break;
			}
			StopWatch sw = new StopWatch();
			sw.start();
			mywhile: while (!isElementFound && sw.getTime() < intMaxTimeInSeconds * 1000) {
				if (driver.findElements(byLocator).size() > 0) {
					isElementFound = true;
					Thread.sleep(1000);
					break mywhile;
				}
			}
			return driver.findElement(byLocator);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * This function is used to wait for frame to be available and switch to it
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 08-03-2017
	 * @param WebDriver driver - Driver control, 
	 * 			String handler - Handler of the frame to switch to, 
	 * 			intTimeOutInSeconds - Time out in Seconds
	 * @return Boolean true if the frame is available, else false
	 */
	public static boolean waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver, String handler, int intTimeOutInSeconds){
		try{
			new WebDriverWait(driver, intTimeOutInSeconds).until(new Function<WebDriver, Boolean>() {
		        @Override
		        public Boolean apply(WebDriver driver) {
		        	boolean isFrameAvailable = false;
		        	StopWatch sw = new StopWatch();
		    		sw.start();
		    		try {
		    			while (!isFrameAvailable && sw.getTime() < intTimeOutInSeconds * 1000) {
		    				try {
	    						driver.switchTo().frame(handler);
	    						isFrameAvailable = true;
		    					break;
		    				} catch (Exception e) {

		    				}
		    			}
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    		return isFrameAvailable;
		        }
		    });
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	/**
	 * This function is used to wait for Alert to be available and switch to it
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 08-03-2017
	 * @param WebDriver driver - Driver control, 
	 * 			intTimeOutInSeconds - Time out in Seconds
	 * @return Boolean true if the Alert is available, else false
	 */
	public static boolean waitForAlert(WebDriver driver, int intTimeOutInSeconds){
		try{
			new WebDriverWait(driver, intTimeOutInSeconds).until(new Function<WebDriver, Boolean>() {
		        @Override
		        public Boolean apply(WebDriver driver) {
		        	boolean isAlertAvailable = false;
		        	StopWatch sw = new StopWatch();
		    		sw.start();
		    		try {
		    			while (!isAlertAvailable && sw.getTime() < intTimeOutInSeconds * 1000) {
		    				try {
	    						driver.switchTo().alert();
	    						isAlertAvailable = true;
		    					break;
		    				} catch (Exception e) {

		    				}
		    			}
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    		return isAlertAvailable;
		        }
		    });
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * This function is used to wait for frame to be available and switch to it
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 08-03-2017
	 * @param WebDriver driver - Driver control, 
	 * 			String handler - Handler of the frame to switch to, 
	 * 			intTimeOutInSeconds - Time out in Seconds
	 * @return Boolean true if the frame is available, else false
	 */
	public static boolean waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver, By byLocator, int intTimeOutInSeconds){
		try{
			new WebDriverWait(driver, intTimeOutInSeconds).until(new Function<WebDriver, Boolean>() {
		        @Override
		        public Boolean apply(WebDriver driver) {
		        	boolean isFrameAvailable = false;
		        	StopWatch sw = new StopWatch();
		    		sw.start();
		    		try {
		    			while (!isFrameAvailable && sw.getTime() < intTimeOutInSeconds * 1000) {
		    				try {
	    						driver.switchTo().frame(driver.findElement(byLocator));
	    						isFrameAvailable = true;
		    					break;
		    				} catch (Exception e) {

		    				}
		    			}
		    		} catch (Exception e) {
		    			e.printStackTrace();
		    		}
		    		return isFrameAvailable;
		        }
		    });
			return true;
		}catch(Exception e){
			return false;
		}
	}
}

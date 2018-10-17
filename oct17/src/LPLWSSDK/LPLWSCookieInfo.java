package LPLWSSDK;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class LPLWSCookieInfo {

	public static String strUser_CSS = "#username";

	public static String strPass_CSS = "#password";

	public static String strLogin_BT = "Log In";

	public static String appUrl = "https://clientworksdevint.lpl.com/";

	private String cookie_ip_enc;

	private String cookie_XSRF_TOKEN;

	private String cookie_userName;

	private String cookie_BN20;

	private String cookie_cg;

	private String cookie_zCookie;

	private String cookie_auth;

	private int cookie_userFirmID;

//	public static WebDriver startDriver() throws IOException, InterruptedException{
//		
//
//		
//	DesiredCapabilities caps = new DesiredCapabilities();
//	caps.setJavascriptEnabled(true);
//	caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:/Users/graju/workspace/phantomjs-2.1.1-windows/bin/phantomjs.exe");
//	WebDriver driver = new PhantomJSDriver(caps);
//	driver.get(appUrl);
//	
//	System.out.println("pageTitle: "+driver.getTitle());
//	
//	
//	driver.findElement(By.id("username")).sendKeys("vigilius.booke");
//	driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
//	driver.findElement(By.id("submitBtn")).click();
//	
//	return driver;
//	
//
//	}

	/*
	 * 
	 * Method to capture the cookie after session is created
	 */

	public static Set<Cookie> captureCookie(WebDriver driver) throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Set<Cookie> cookies = driver.manage().getCookies();
		return cookies;

	}

	/*
	 * 
	 * Method to get the components of a session cookie
	 */

	public static String[] getCookieString(Set<Cookie> cookies) {

		String cookieString = "";
		cookieString = cookies.toString();
		String cookieArray[] = cookieString.split(";");
		return cookieArray;
	}

	/*
	 *
	 * Method to get the value of the specific cookie property
	 */

	public static String getCookieProperty(String propertyName, String cookieArray[]) {

		String propertyValue = "";

		for (int i = 0; i < cookieArray.length; i++) {
			if (cookieArray[i].contains(propertyName)) {

				propertyValue = cookieArray[i]
						.substring(cookieArray[i].indexOf(propertyName + "=") + (propertyName.length() + 1));

			}
		}

		return propertyValue;

	}

	/*
	 *
	 * Method to get the value of the specific cookie property
	 */

	/**
	 * @return the cookie_ip_enc
	 */
	public String getCookie_ip_enc() {
		return cookie_ip_enc;
	}

	/**
	 * @param cookie_ip_enc the cookie_ip_enc to set
	 */
	public void setCookie_ip_enc(String cookie_ip_enc) {
		this.cookie_ip_enc = cookie_ip_enc;
	}

	/**
	 * @return the cookie_XSRF_TOKEN
	 */
	public String getCookie_XSRF_TOKEN() {
		return cookie_XSRF_TOKEN;
	}

	/**
	 * @param cookie_XSRF_TOKEN the cookie_XSRF_TOKEN to set
	 */
	public void setCookie_XSRF_TOKEN(String cookie_XSRF_TOKEN) {
		this.cookie_XSRF_TOKEN = cookie_XSRF_TOKEN;
	}

	/**
	 * @return the cookie_userName
	 */
	public String getCookie_userName() {
		return cookie_userName;
	}

	/**
	 * @param cookie_userName the cookie_userName to set
	 */
	public void setCookie_userName(String cookie_userName) {
		this.cookie_userName = cookie_userName;
	}

	/**
	 * @return the cookie_BN20
	 */
	public String getCookie_BN20() {
		return cookie_BN20;
	}

	/**
	 * @param cookie_BN20 the cookie_BN20 to set
	 */
	public void setCookie_BN20(String cookie_BN20) {
		this.cookie_BN20 = cookie_BN20;
	}

	/**
	 * @return the cookie_cg
	 */
	public String getCookie_cg() {
		return cookie_cg;
	}

	/**
	 * @param cookie_cg the cookie_cg to set
	 */
	public void setCookie_cg(String cookie_cg) {
		this.cookie_cg = cookie_cg;
	}

	/**
	 * @return the cookie_zCookie
	 */
	public String getCookie_zCookie() {
		return cookie_zCookie;
	}

	/**
	 * @param cookie_zCookie the cookie_zCookie to set
	 */
	public void setCookie_zCookie(String cookie_zCookie) {
		this.cookie_zCookie = cookie_zCookie;
	}

	/**
	 * @return the cookie_userFirmID
	 */
	public int getCookie_userFirmID() {
		return cookie_userFirmID;
	}

	/**
	 * @param cookie_userFirmID the cookie_userFirmID to set
	 */
	public void setCookie_userFirmID(int cookie_userFirmID) {
		this.cookie_userFirmID = cookie_userFirmID;
	}

	/**
	 * @return the cookie_auth
	 */
	public String getCookie_auth() {
		return cookie_auth;
	}

	/**
	 * @param cookie_auth the cookie_auth to set
	 */
	public void setCookie_auth(String cookie_auth) {
		this.cookie_auth = cookie_auth;
	}

}

package LPLWSSDK;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreReporter;

/**
 * <p>
 * <br>
 * <b> Title: </b> LPLWSUtilities.java</br> <br>
 * <b> Description: </B> LPL WS Utilities Library</br> <br>
 * <b>Usage:</br></b> <br>
 * 1. HttpURLConnection: Method to create the Http connection</br> <br>
 * 2. validateWSResponseData: Method to verify the expected and actual
 * WebService property if the property data type is integer</br> <br>
 * 3. validateWSResponseData: Method to verify the expected and actual
 * WebService property if the property data type is boolean</br> <br>
 * 4. validateWSResponseData: Method to verify the expected and actual
 * WebService property if the property data type is String</br> <br>
 * 5. regxValidations: This function Compares The Format of the value Passed and
 * returns the status</br> <br>
 * 6. wsValuevalidation: This function Compares the run time value with the
 * value passed</br> <br>
 * 7. arrayToMap: This method is used to Capture all the keys and values in a
 * single record out of the JSON array that is present in the Service
 * Response</br> <br>
 * 8. getComputerName: This function is to get the system host name</br> <br>
 * 9. createContextInstance: This function is to create set HTTP Client context
 * and to set credentials</br> <br>
 * 10. getCredentialsProvider: This function is to set credentials for
 * HTTPResponse basic credentials provider</br> <br>
 * 
 * @author Gopu Raju
 * @since 10-21-2016
 *        </p>
 */
public class LPLWSUtilities {

	public static String strUser_CSS = "#username";

	public static String strPass_CSS = "#password";

	public static String strLogin_BT = "Log In";

	public static String appUrl = "https://clientworksdevint.lpl.com/";

	public static LPLConfig ocfg;

	public static WebDriver driver;

	public static final String MANDATORY = "M";
	public static final String NONMANDATORY = "NM";
	public static final String DECIMAL = "DECIMAL";
	public static final String INTEGER = "INTEGER";
	public static final String INTEGERORDECIMAL = "INTEGERORDECIMAL";
	public static final String SIMPLEDATE = "SIMPLEDATE";
	public static final String SIMPLEDATEYYYYMMDD = "SIMPLEDATEYYYYMMDD";
	public static final String SIMPLESLASHDATEYYYYMMDD = "SIMPLESLASHDATEYYYYMMDD";
	public static final String SIMPLEDATEMMDDYYYY = "SIMPLEDATEMMDDYYYY";
	public static final String SIMPLEDATEDDMMYYYY = "SIMPLEDATEDDMMYYYY";
	public static final String SIMPLESLASHDATEDDMMYYYY = "SIMPLESLASHDATEDDMMYYYY";
	public static final String SIMPLESLASHDATEMMDDYYYY = "SIMPLESLASHDATEMMDDYYYY";
	public static final String SIMPLEDATEYYYYMMDDWITHTIME = "SIMPLEDATEYYYYMMDDWITHTIME";
	public static final String SIMPLEDATEMMDDYYYYWITHTIME = "SIMPLEDATEMMDDYYYYWITHTIME";
	public static final String SIMPLEDATEDDMMYYYYWITHTIME = "SIMPLEDATEDDMMYYYYWITHTIME";
	public static final String EMAIL = "EMAIL";
	public static final String STRING = "STRING";

	public static String strError;

	/**
	 * Method to create the Http connection
	 * 
	 * @author Gopu Raju
	 * @since 10-21-2016
	 * @param String
	 *            payloadUrl, String requestType,String propertyKey,String
	 *            propertyValueString connection, int expectedStatusCode
	 * @return HttpURLConnection connection
	 */

	public static HttpURLConnection createHttpConnection(String payloadUrl,
			String requestType, String propertyKey, String propertyValue)
			throws IOException {

		HttpURLConnection connection = null;
		try {

			URL url = new URL(payloadUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(requestType);
			connection.setRequestProperty(propertyKey, propertyValue);
			return connection;

		}

		catch (Exception e) {
			e.printStackTrace();
			return connection;
		}

	}

	/**
	 * Method to set the value of cookie elements
	 * 
	 * @author Gopu Raju
	 * @since 10-20-2016
	 * @param WebDriver
	 *            driver
	 * @return LPLWSCookieInfo Cookie
	 */

	// public LPLWSCookieInfo setCookieProperties(WebDriver driver) throws
	// IOException, InterruptedException{
	//
	// LPLWSCookieInfo Cookie = new LPLWSCookieInfo();
	// try{
	// String cookieProperties[] =
	// LPLWSCookieInfo.getCookieString(LPLWSCookieInfo.captureCookie(driver),";");
	//
	// Cookie.setCookie_ip_enc(LPLWSCookieInfo.getCookieProperty("ip_enc",cookieProperties,"="));
	// Cookie.setCookie_XSRF_TOKEN(LPLWSCookieInfo.getCookieProperty("XSRF-TOKEN",cookieProperties,"="));
	// Cookie.setCookie_userName(LPLWSCookieInfo.getCookieProperty("UserName",cookieProperties,"="));
	// Cookie.setCookie_BN20(LPLWSCookieInfo.getCookieProperty("BN20",cookieProperties,"="));
	// Cookie.setCookie_cg(LPLWSCookieInfo.getCookieProperty("cg",cookieProperties,"="));
	// Cookie.setCookie_zCookie(LPLWSCookieInfo.getCookieProperty("z",cookieProperties,"z="));
	// Cookie.setCookie_auth(LPLWSCookieInfo.getCookieProperty("Auth",cookieProperties,"="));
	// Cookie.setCookie_userFirmID(Integer.parseInt(LPLWSCookieInfo.getCookieProperty("UserFirmID",cookieProperties,"=")));
	// return Cookie;
	// }
	//
	// catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	//
	// }

	/**
	 * Method to verify the expected and actual WebService property if the
	 * property data type is integer
	 * 
	 * @author Gopu Raju
	 * @since 10-27-2016
	 * @param double stepNo, String fieldName, int expected, int actual
	 * @return
	 */

	public static void validateWSResponseData(double stepNo, String fieldName,
			int expected, int actual) {

		if (expected == actual)
			LPLCoreReporter.WriteReport("Step " + stepNo + " : "
					+ "Validate the field - " + fieldName, "Expected - "
					+ fieldName + " : " + expected, "Actual - " + fieldName
					+ " : " + actual, LPLCoreConstents.PASSED, "");
		else
			LPLCoreReporter.WriteReport("Step " + stepNo + " : "
					+ "Validate the field - " + fieldName, "Expected - "
					+ fieldName + " : " + expected, "Actual - " + fieldName
					+ " : " + actual, LPLCoreConstents.FAILED, "");

	}

	/**
	 * Method to verify the expected and actual WebService property if the
	 * property data type is Boolean
	 * 
	 * @author Gopu Raju
	 * @since 10-27-2016
	 * @param double stepNo, String fieldName, Boolean expected, Boolean actual
	 * @return
	 */

	public static void validateWSResponseData(double stepNo, String fieldName,
			Boolean expected, Boolean actual) {

		if (expected == actual)
			LPLCoreReporter.WriteReport("Step " + stepNo + " : "
					+ "Validate the field - " + fieldName, "Expected - "
					+ fieldName + " : " + expected, "Actual - " + fieldName
					+ " : " + actual, LPLCoreConstents.PASSED, "");
		else
			LPLCoreReporter.WriteReport("Step " + stepNo + " : "
					+ "Validate the field - " + fieldName, "Expected - "
					+ fieldName + " : " + expected, "Actual - " + fieldName
					+ " : " + actual, LPLCoreConstents.FAILED, "");
	}

	/**
	 * Method to verify the expected and actual WebService property if the
	 * property data type is String
	 * 
	 * @author Gopu Raju
	 * @since 10-27-2016
	 * @param double stepNo, String fieldName, String expected, String actual
	 * @return
	 */
	public static void validateWSResponseData(double stepNo, String fieldName,
			String expected, String actual) {

		if (expected.equals(actual))
			LPLCoreReporter.WriteReport("Step " + stepNo + " : "
					+ "Validate the field - " + fieldName, "Expected - "
					+ fieldName + " : " + expected, "Actual - " + fieldName
					+ " : " + actual, LPLCoreConstents.PASSED, "");
		else
			LPLCoreReporter.WriteReport("Step " + stepNo + " : "
					+ "Validate the field - " + fieldName, "Expected - "
					+ fieldName + " : " + expected, "Actual - " + fieldName
					+ " : " + actual, LPLCoreConstents.FAILED, "");

	}

	/**
	 * This function Compares The Format of the value Passed and returns the
	 * Status
	 * 
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 06-22-2016
	 * @param (String) strValueType,strActualVal,strMandatoryVal
	 * @return (String,String) Map
	 */
	public static boolean regxValidations(String strValueType,
			String strActualVal, String strMandatoryVal) {
		boolean blnResult = false;
		String pattern;
		try {
			if ((strMandatoryVal.equalsIgnoreCase(MANDATORY))
					|| (!strActualVal.equalsIgnoreCase("null") && strMandatoryVal
							.equalsIgnoreCase(NONMANDATORY))) {
				switch (strValueType.toUpperCase()) {
				case DECIMAL:
					pattern = "(\\+|-)?([0-9]+(\\.[0-9]+))";
					break;
				case INTEGER:
					pattern = "(^\\d*$)";
					break;
				case INTEGERORDECIMAL:
					pattern = "^\\d*$|^\\d*.\\d*$";
					break;
				case SIMPLEDATE:
				case SIMPLEDATEYYYYMMDD:
					pattern = "\\d{4}-\\d{2}-\\d{2}";
					break;
				case SIMPLESLASHDATEYYYYMMDD:
					pattern = "\\d{4}/\\d{2}/\\d{2}";
					break;
				case SIMPLEDATEMMDDYYYY:
				case SIMPLEDATEDDMMYYYY:
					pattern = "\\d{2}-\\d{2}-\\d{4}";
					break;
				case SIMPLESLASHDATEDDMMYYYY:
				case SIMPLESLASHDATEMMDDYYYY:
					pattern = "\\d{2}/\\d{2}/\\d{4}";
					break;
				case SIMPLEDATEYYYYMMDDWITHTIME:
					pattern = "\\d{4}-\\d{2}-\\d{2}T(\\d{2}):(\\d{2}):(\\d{2})-\\d{2}:\\d{2}";
					break;
				case SIMPLEDATEMMDDYYYYWITHTIME:
				case SIMPLEDATEDDMMYYYYWITHTIME:
					pattern = "\\d{2}-\\d{2}-\\d{4}T(\\d{2}):(\\d{2}):(\\d{2})-\\d{2}:\\d{2}";
					break;
				case EMAIL:
					pattern = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
					break;
				case STRING:
				default:
					pattern = "[\\s\\S]";
					break;
				}
				Pattern patternMatcher = Pattern.compile(pattern);
				Matcher patternOv = patternMatcher.matcher(strActualVal);
				if (patternOv.find()) {
					blnResult = true;
				}
			} else if (strActualVal.equalsIgnoreCase("null")
					&& strMandatoryVal.equalsIgnoreCase(NONMANDATORY)) {
				blnResult = true;
			}
		} catch (Exception e) {
			strError = e.getMessage();
		}
		return blnResult;
	}

	/**
	 * This function Compares the run time value with the value passed
	 * 
	 * @author Vikram Balwadgi
	 * @version 1.0
	 * @since 06-22-2016
	 * @param (String) strExpectedVal,strActualVal
	 * @return (boolean) -True/False
	 */
	public static boolean wsValuevalidation(String strExpectedVal,
			String strActualVal) {
		boolean blnResult = false;
		try {
			if (strExpectedVal.equalsIgnoreCase(strActualVal)) {
				blnResult = true;
			}
		} catch (Exception e) {
			strError = e.getMessage();
		}
		return blnResult;
	}

	/**
	 * This method is used to Capture all the keys and values in a single record
	 * out of the JSON array that is present in the Service Response
	 * 
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 12-27-2017
	 * @param ja
	 *            - JSONArray from the response
	 * @param strUniqueKey
	 *            - Unique data key if you require to filter results by a unique
	 *            key value pair
	 * @param strUniqueValue
	 *            - Unique data value if you require to filter results by a
	 *            unique key value pair
	 * @return Map - Map that has a single record of all keys and values in that
	 *         record
	 */
	public static Map<String, String> arrayToMap(JSONArray ja,
			String strUniqueKey, String strUniqueValue) {
		// Declaration Of Map, values Captured in Keys and Values
		Map<String, String> map = new HashMap<>();
		try {
			if (strUniqueKey.length() > 0) {
				for (int i = 0; i < ja.length(); i++) {
					JSONObject objectInArray = ja.getJSONObject(i);

					// capturing outputs from the services.
					String uniqueKey = String.valueOf((Object) objectInArray
							.get(strUniqueKey));
					if (uniqueKey.equalsIgnoreCase(strUniqueValue)) {
						for (Iterator<?> keys = objectInArray.keys(); keys
								.hasNext();) {
							String key = (String) keys.next();
							map.put((key), String
									.valueOf((Object) objectInArray.get(key)));
						}
						break;
					}
				}
			} else {
				JSONObject objectInArray = ja.getJSONObject(0);
				for (Iterator<?> keys = objectInArray.keys(); keys.hasNext();) {
					String key = (String) keys.next();
					map.put((key),
							String.valueOf((Object) objectInArray.get(key)));
				}
			}
		} catch (Exception e) {
			map = null;
		}
		return map;
	}

	/**
	 * getComputerName: This function is to get the system host name
	 * 
	 * @author Priyan
	 * @version 1.0
	 * @since 03-29-2018
	 * @param N
	 *            /A
	 * @return String
	 */
	protected static String getComputerName() {
		String hostname = "";
		try {
			InetAddress addr = java.net.InetAddress.getLocalHost();
			hostname = addr.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return hostname;
	}

	/**
	 * createContextInstance: This function is to create set HTTP Client context
	 * and to set credentials provider to it
	 * 
	 * @author Priyan
	 * @version 1.0
	 * @since 03-29-2018
	 * @param (CredentialsProvider) credsProvider
	 * @return HttpClientContext
	 */
	protected static HttpClientContext createContextInstance(
			CredentialsProvider credsProvider) {
		HttpClientContext context = null;
		try {
			context = HttpClientContext.create();
			context.setCredentialsProvider(credsProvider);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return context;
	}

	/**
	 * getCredentialsProvider: This function is to set credentials for basic
	 * credentials provider
	 * 
	 * @author Priyan
	 * @version 1.0
	 * @since 03-29-2018
	 * @param (String) userName, (String)password, (String)domain - System's
	 *        domain name
	 * @return CredentialsProvider
	 */
	protected static CredentialsProvider getCredentialsProvider(
			String userName, String password, String domain) {
		CredentialsProvider credsProvider = null;
		try {
			credsProvider = new BasicCredentialsProvider();
			credsProvider.setCredentials(AuthScope.ANY, new NTCredentials(
					userName, password, getComputerName(), domain));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return credsProvider;
	}
}

/**
 * 
 */
package LPLWSSDK;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreDriver;
import LPLCoreDriver.LPLCoreReporter;
import PageObjectLibrary.HomePage;
import PageObjectLibrary.LoginPage;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * @author graju
 *
 */

public class LPLWSRestTest extends LPLCoreDriver {

	public static Set<Cookie> sessionCookie = null;
	public String transactionCookie = null;
	static OkHttpClient client = new OkHttpClient();

	public static LPLCoreConstents lplCoreConstents;

	public static Response RestTestTokenAuth(WebDriver driver, String userName, String password, String endPointURL,
			String serviceCall, String host, String transactionID, String timeStamp, String sourceSystem, String origin,
			String userAgent, String referrer, String cookie, String xsrfToken, String cacheControl,
			String requestBodyString, String... strSupportViewData) throws IOException, InterruptedException {

		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(userName, password);
		homePage.waitForPageLoading(homePage.lplCoreConstents.HIGH);

		if ((ocfg.getEnvId() == 7) && strSupportViewData.length > 0) {
			homePage.performCWSupportView(strSupportViewData[0], strSupportViewData[1]);
		}
		sessionCookie = LPLWSCookieInfo.captureCookie(driver);

		String zCookie = LPLWSCookieInfo.getCookieProperty("z", LPLWSCookieInfo.getCookieString(sessionCookie));
		String Auth = LPLWSCookieInfo.getCookieProperty("Auth", LPLWSCookieInfo.getCookieString(sessionCookie));
		String XSRFToken1 = LPLWSCookieInfo.getCookieProperty("XSRF-TOKEN",
				LPLWSCookieInfo.getCookieString(sessionCookie));

		String transactionCookie = "Auth=" + Auth + "; XSRF-TOKEN=" + XSRFToken1 + "; z=" + zCookie;

		Response response = null;

		switch (serviceCall.toUpperCase()) {

		case "GET":

			Request getRequest = new Request.Builder().url(endPointURL).get().addHeader("host", host)
					.addHeader("transactionid", transactionID).addHeader("timestamp", timeStamp)
					.addHeader("sourcesystem", sourceSystem).addHeader("origin", origin)
					.addHeader("user-agent", userAgent).addHeader("referer", referrer)
					.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1)
					.addHeader("cache-control", cacheControl).build();
			try {
				response = client.newCall(getRequest).execute();

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case "POST":

			Request postRequest = new Request.Builder().url(endPointURL).post(buildRequestBody(requestBodyString))
					.addHeader("host", host).addHeader("transactionid", transactionID).addHeader("timestamp", timeStamp)
					.addHeader("sourcesystem", sourceSystem).addHeader("origin", origin)
					.addHeader("user-agent", userAgent).addHeader("referer", referrer)
					.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1)
					.addHeader("cache-control", cacheControl).build();
			try {
				response = client.newCall(postRequest).execute();

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case "DELETE":

			Request deleteRequest = new Request.Builder().url(endPointURL).delete().addHeader("host", host)
					.addHeader("transactionid", transactionID).addHeader("timestamp", timeStamp)
					.addHeader("sourcesystem", sourceSystem).addHeader("origin", origin)
					.addHeader("user-agent", userAgent).addHeader("referer", referrer)
					.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1)
					.addHeader("cache-control", cacheControl).build();
			try {
				response = client.newCall(deleteRequest).execute();

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case "PUT":
			Request putRequest = new Request.Builder().url(endPointURL).put(buildRequestBody(requestBodyString))
					.addHeader("host", host).addHeader("transactionid", transactionID).addHeader("timestamp", timeStamp)
					.addHeader("sourcesystem", sourceSystem).addHeader("origin", origin)
					.addHeader("user-agent", userAgent).addHeader("referer", referrer)
					.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1)
					.addHeader("cache-control", cacheControl).build();
			try {
				response = client.newCall(putRequest).execute();

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		}

		return response;

	}

	@SuppressWarnings("unused")
	public static Response RestTestTokenAuth(WebDriver driver, String userName, String password, String endPointURL,
			String serviceCall, HashMap<String, String> headerParameters, String requestBodyString)
			throws IOException, InterruptedException {

		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(userName, password);
		homePage.waitForPageLoading(homePage.lplCoreConstents.HIGH);

		sessionCookie = LPLWSCookieInfo.captureCookie(driver);

		String zCookie = LPLWSCookieInfo.getCookieProperty("z", LPLWSCookieInfo.getCookieString(sessionCookie));
		String Auth = LPLWSCookieInfo.getCookieProperty("Auth", LPLWSCookieInfo.getCookieString(sessionCookie));
		String XSRFToken1 = LPLWSCookieInfo.getCookieProperty("XSRF-TOKEN",
				LPLWSCookieInfo.getCookieString(sessionCookie));

		String transactionCookie = "Auth=" + Auth + "; XSRF-TOKEN=" + XSRFToken1 + "; z=" + zCookie;

		ArrayList<String> headerParameterKeys = new ArrayList<String>(headerParameters.keySet());
		Set<Map.Entry<String, String>> headerParameterEntries = headerParameters.entrySet();

		Response response = null;

		switch (serviceCall.toUpperCase()) {

		case "GET":

			Builder buildRequestGet = new Request.Builder().url(endPointURL).get()
					.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1);

			for (Map.Entry<String, String> entry : headerParameterEntries) {

				buildRequestGet = buildRequestGet.addHeader(entry.getKey(), entry.getValue());
			}
			Request getRequest = buildRequestGet.build();

			try {
				response = client.newCall(getRequest).execute();

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case "POST":

			Builder buildRequestPost = new Request.Builder().url(endPointURL).post(buildRequestBody(requestBodyString))
					.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1);

			for (Map.Entry<String, String> entry : headerParameterEntries) {

				buildRequestPost = buildRequestPost.addHeader(entry.getKey(), entry.getValue());
			}
			Request postRequest = buildRequestPost.build();

			try {
				response = client.newCall(postRequest).execute();

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case "DELETE":

			Builder buildRequestDelete = new Request.Builder().url(endPointURL).delete()
					.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1);

			for (Map.Entry<String, String> entry : headerParameterEntries) {

				buildRequestDelete = buildRequestDelete.addHeader(entry.getKey(), entry.getValue());
			}
			Request deleteRequest = buildRequestDelete.build();

			try {
				response = client.newCall(deleteRequest).execute();

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		case "PUT":

			Builder buildRequestPut = new Request.Builder().url(endPointURL).put(buildRequestBody(requestBodyString))
					.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1);

			for (Map.Entry<String, String> entry : headerParameterEntries) {

				buildRequestPut = buildRequestPut.addHeader(entry.getKey(), entry.getValue());
			}
			Request putRequest = buildRequestPut.build();

			try {
				response = client.newCall(putRequest).execute();

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;

		}

		return response;

	}

	public static RequestBody buildRequestBody(String requestBodyString) {

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody requestBody = RequestBody.create(mediaType, requestBodyString);

		return requestBody;

	}

	public static Response RestTestTokenAuth(WebDriver driver, String userName, String password, String endPointURL,
			String serviceCall, HashMap<String, String> headerParameters, String requestBodyString,
			boolean blnNeedLogin) throws IOException, InterruptedException {
		if (blnNeedLogin) {
			return RestTestTokenAuth(driver, userName, password, endPointURL, serviceCall, headerParameters,
					requestBodyString);
		} else {
			sessionCookie = LPLWSCookieInfo.captureCookie(driver);

			String zCookie = LPLWSCookieInfo.getCookieProperty("z", LPLWSCookieInfo.getCookieString(sessionCookie));
			String Auth = LPLWSCookieInfo.getCookieProperty("Auth", LPLWSCookieInfo.getCookieString(sessionCookie));
			String XSRFToken1 = LPLWSCookieInfo.getCookieProperty("XSRF-TOKEN",
					LPLWSCookieInfo.getCookieString(sessionCookie));

			String transactionCookie = "Auth=" + Auth + "; XSRF-TOKEN=" + XSRFToken1 + "; z=" + zCookie;

			Set<Map.Entry<String, String>> headerParameterEntries = headerParameters.entrySet();

			Response response = null;
			long startTime = 0;
			switch (serviceCall.toUpperCase()) {
			case "GET":
				Builder buildRequestGet = new Request.Builder().url(endPointURL).get()
						.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1);

				for (Map.Entry<String, String> entry : headerParameterEntries) {

					buildRequestGet = buildRequestGet.addHeader(entry.getKey(), entry.getValue());
				}
				Request getRequest = buildRequestGet.build();

				try {
					startTime = System.currentTimeMillis();
					response = client.newCall(getRequest).execute();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "POST":
				Builder buildRequestPost = new Request.Builder().url(endPointURL)
						.post(buildRequestBody(requestBodyString)).addHeader("cookie", transactionCookie)
						.addHeader("x-xsrf-token", XSRFToken1);

				for (Map.Entry<String, String> entry : headerParameterEntries) {

					buildRequestPost = buildRequestPost.addHeader(entry.getKey(), entry.getValue());
				}
				Request postRequest = buildRequestPost.build();
				try {
					startTime = System.currentTimeMillis();
					response = client.newCall(postRequest).execute();

				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "DELETE":
				Builder buildRequestDelete = new Request.Builder().url(endPointURL).delete()
						.addHeader("cookie", transactionCookie).addHeader("x-xsrf-token", XSRFToken1);

				for (Map.Entry<String, String> entry : headerParameterEntries) {

					buildRequestDelete = buildRequestDelete.addHeader(entry.getKey(), entry.getValue());
				}
				Request deleteRequest = buildRequestDelete.build();

				try {
					startTime = System.currentTimeMillis();
					response = client.newCall(deleteRequest).execute();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "PUT":
				Builder buildRequestPut = new Request.Builder().url(endPointURL)
						.put(buildRequestBody(requestBodyString)).addHeader("cookie", transactionCookie)
						.addHeader("x-xsrf-token", XSRFToken1);
				for (Map.Entry<String, String> entry : headerParameterEntries) {

					buildRequestPut = buildRequestPut.addHeader(entry.getKey(), entry.getValue());
				}
				Request putRequest = buildRequestPut.build();
				try {
					startTime = System.currentTimeMillis();
					response = client.newCall(putRequest).execute();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			long endTime = System.currentTimeMillis() - startTime;
			LPLCoreReporter.WriteReport("Response Time : " + endTime / 1000.0 + " Seconds.", "", "", "", "");
			return response;
		}
	}
}

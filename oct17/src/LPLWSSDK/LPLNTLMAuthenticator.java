/**
 * 
 */
package LPLWSSDK;

/**
 * <p>
 * <br><b> Title: </b> LPLNTLMAuthenticator.java</br>
 * <br><b> Description: </B> Library to handle webservices request through NTLM/Windows authentication </br>
 * <br><b>Usage:</br></b>
 * <br>1. restTestTokenAuthForHttp: This function is used to get the HttpResponse </br>
 * @author Shunmugapriyan Perumal
 * @since 03-27-2018 
 * </p>
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class LPLNTLMAuthenticator extends LPLWSUtilities {

	public static HttpResponse response = null;
	public static HttpClient client = HttpClientBuilder.create().build();
	public static HttpClientContext context = HttpClientContext.create();
	public static HttpUriRequest request = null;
	public static HttpEntityEnclosingRequest entityEncReq = null;

	public static HttpResponse restTestTokenAuthForHttp(String serviceCall, String endPointURL, String username,
			String password, String domain, HashMap<String, String> headerParameters, String requestBodyString) {

		try {

			// Setting the credentials with username, password and domain
			CredentialsProvider credsProvider;
			credsProvider = getCredentialsProvider(username, password, domain);

			// Creating HTTP Client Context and setting the credentials provide
			context = createContextInstance(credsProvider);
			Set<Map.Entry<String, String>> headerParameterEntries = headerParameters.entrySet();

			switch (serviceCall.toUpperCase()) {

			// Http Get request
			case "GET":
				request = new HttpGet(endPointURL);
				for (Map.Entry<String, String> entry : headerParameterEntries) {
					request.addHeader(entry.getKey(), entry.getValue());
				}
				break;

			// Http Post request
			case "POST":

				StringEntity entity = new StringEntity(requestBodyString);
				request = new HttpPost(endPointURL);

				// Tobe Parameterized
				for (Map.Entry<String, String> entry : headerParameterEntries) {
					request.addHeader(entry.getKey(), entry.getValue());
				}
				entityEncReq = (HttpEntityEnclosingRequest) request;
				entityEncReq.setEntity(entity);
				break;

			// Http Put request
			case "PUT":
				request = new HttpPut(endPointURL);
				for (Map.Entry<String, String> entry : headerParameterEntries) {
					request.addHeader(entry.getKey(), entry.getValue());
				}
				entityEncReq = (HttpEntityEnclosingRequest) request;
				break;

			// Http Delete request
			case "DELETE":
				request = new HttpDelete(endPointURL);
				for (Map.Entry<String, String> entry : headerParameterEntries) {
					request.addHeader(entry.getKey(), entry.getValue());
				}
				// Currently No Need of Entity request for Delete
				// entityEncReq = (HttpEntityEnclosingRequest) request;
				break;

			default:
				throw new Exception(
						"No appropriate method specified for the \"serviceCall\" Parameter. Please specify one of the following types for the serviceCall GET/POST/PUT/DELETE");

			}

			response = client.execute(request, context);
			// Returning the response
		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
}

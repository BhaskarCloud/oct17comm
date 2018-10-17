package LPLWSSDK;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.http.client.ClientProtocolException;


public class LPLWSStatusValidation {
	
	
	/**
	 * Method to verify the http response status code
	 * @author Gopu Raju
	 * @since 10-26-2016
	 * @param HttpsURLConnection connection, int expectedStatusCode
	 * @return 
	 */
	
	
	public static Boolean ValidateWebServiceStatusCode(HttpURLConnection connection ,int expectedStatusCode ) throws ClientProtocolException, IOException{
		

		int actualStatusCode = connection.getResponseCode();  			//Get the actual status code from the connection

		
		try
		{
		if(actualStatusCode != 0){
			
			if(actualStatusCode==expectedStatusCode){                    //compare the expected and actual status code to confirm the 
							
				System.out.println("Passed - the actual Status code("+actualStatusCode+") is same as expected");
				return true;
			}  
			else
				System.out.println("Failed -  Actual Status Code received is : "+actualStatusCode);
				return false;
			}
		
		else{
			System.out.println("Failed -  Actual Status Code received is : "+actualStatusCode);
			return false;
			}
		}
		
		 catch (Exception e) {
			e.printStackTrace();
			return false;
		 }
	
	}

}

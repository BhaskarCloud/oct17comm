package LPLWSSDK;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class LPLWSJSONParser {

	
	
	/**
	 * Method to get the JSON object
	 * @author Gopu Raju
	 * @since 10-19-2016
	 * @param HttpURLConnection connection
	 * @return 
	 */
	
	public static JSONObject getJSONOutputObject(HttpURLConnection connection) throws ClientProtocolException, IOException, JSONException{
		
		Scanner scan = new Scanner(connection.getInputStream());
		String response = new String();
		
		try{
		
			while (scan.hasNext())
			response += scan.nextLine();;
			
			scan.close();
		
			JSONObject responseJsonObject = new JSONObject(response);
			return responseJsonObject;
		}
		
		 catch (Exception e) {
			e.printStackTrace();
			return null;
		 }	
	}
	
	
	
	/**
	 * Method to get the Response in JSON Array
	 * @author Gopu Raju
	 * @since 10-19-2016
	 * @param HttpURLConnection connection,String arrayKey
	 * @return 
	 */
	
	public static JSONArray getJSONArray(HttpURLConnection connection,String arrayKey) throws IOException, JSONException{
		
		Scanner scan = new Scanner(connection.getInputStream());
		String response = new String();

		try{
			while (scan.hasNext())
			response += scan.nextLine();
			
			scan.close();
			
			JSONObject responseJsonObject = new JSONObject(response);
			JSONArray responseJsonArray = responseJsonObject.getJSONArray(arrayKey);
			return responseJsonArray; 
		}
		
		 catch (Exception e) {
			e.printStackTrace();
			return null;
		 }	
	}
	
	/**
	 * Method to Map the JSON Array
	 * @author Gopu Raju
	 * @since 10-19-2016
	 * @param JSONArray responseJsonArray,String primaryKey,String primaryKeyDataType
	 * @return 
	 */
	
	@SuppressWarnings("rawtypes")
	public static Map getJSONMap(JSONArray responseJsonArray,String primaryKey,String primaryKeyDataType) throws JSONException{
		
		try{
		if(primaryKeyDataType.equals("int")){
			
			Map<Integer,JSONObject> objectMap = new HashMap<Integer,JSONObject>();
		
			for(int i = 0; i < responseJsonArray.length(); i++){
				JSONObject object = responseJsonArray.getJSONObject(i);
			
			Integer compareKey = object.getInt(primaryKey);
				objectMap.put(compareKey, responseJsonArray.getJSONObject(i));
			}	
			return objectMap;
			}
			
		
		else
			
		{
			Map<String,JSONObject> objectMap = new HashMap<String,JSONObject>();
		
			for(int i = 0; i < responseJsonArray.length(); i++){
				JSONObject object = responseJsonArray.getJSONObject(i);
				
			String compareKey = object.getString(primaryKey);
				objectMap.put(compareKey, responseJsonArray.getJSONObject(i));
			}	
					
			return objectMap;
		}
        

   	     }  
	       catch (Exception e) {
   		     e.printStackTrace();     
   		     return null;
		}		
	
	}
	
	
	
	/**
	 * Method to get specific JSON object where primary Key value is an integer
	 * @author Gopu Raju
	 * @since 10-19-2016
	 * @param Map outputJSONMap,int primaryKeyValue
	 * @return 
	 */
	
	@SuppressWarnings("rawtypes")
	public static JSONObject getJSONObject(Map outputJSONMap,int primaryKeyValue) throws JSONException{
		
		try{
			JSONObject jsonObject = new JSONObject();
			jsonObject = (JSONObject) outputJSONMap.get(primaryKeyValue);		
			return 	jsonObject;
		}
		
		 catch (Exception e) {
			e.printStackTrace();
			return null;
		 }	
		
	}
	
	
	/**
	 * Method to get specific JSON object where primary Key value is String
	 * @author Gopu Raju
	 * @since 10-19-2016
	 * @param Map outputJSONMap,String primaryKeyValue
	 * @return 
	 */
	
	@SuppressWarnings("rawtypes")
	public static JSONObject getJSONObject(Map outputJSONMap,String primaryKeyValue){
		
		try{
			JSONObject jsonObject = new JSONObject();
			jsonObject = (JSONObject) outputJSONMap.get(primaryKeyValue);		
			return 	jsonObject;
		}
		
		 catch (Exception e) {
			e.printStackTrace();
			return null;
		 }	
	}
	

	/**
	 * Method to get integer value from JSON Object
	 * @author Gopu Raju
	 * @since 10-24-2016
	 * @param JSONObject jsonObject,String valueKey
	 * @return 
	 */
	
	public static int getJSONObjectPropertyInt(JSONObject jsonObject,String valueKey) throws JSONException{
		try{
			int jsonObjectProperty = 0;
			jsonObjectProperty =  jsonObject.getInt(valueKey);
			return jsonObjectProperty;
		}
		
		 catch (Exception e) {
			e.printStackTrace();
			return 0;
		 }	
	}
	
	/**
	 * Method to get Boolean value from JSON Object
	 * @author Gopu Raju
	 * @since 10-24-2016
	 * @param JSONObject jsonObject,String valueKey
	 * @return 
	 */	
	
	public static Boolean getJSONObjectPropertyBol(JSONObject jsonObject,String valueKey) throws JSONException{
		
		try{
			Boolean jsonObjectProperty = null;
			jsonObjectProperty = jsonObject.getBoolean(valueKey);
			return jsonObjectProperty;
			}
	
	 catch (Exception e) {
			e.printStackTrace();
			return null;
	 }	
		
	}
	
	/**
	 * Method to get String value from JSON Object
	 * @author Gopu Raju
	 * @since 10-24-2016
	 * @param JSONObject jsonObject,String valueKey
	 * @return 
	 */	
	
	public static String getJSONObjectPropertyStr(JSONObject jsonObject,String valueKey) throws JSONException{
		
		try{
			String jsonObjectProperty = null;
			jsonObjectProperty = jsonObject.getString(valueKey);
			return jsonObjectProperty;
		}
		
		 catch (Exception e) {
			e.printStackTrace();
			return null;
		 }	
		
	}
	
	
	/**
	 * Method to get the JSON String
	 * @author Gopu Raju
	 * @since 10-25-2016
	 * @param HttpURLConnection connection
	 * @return 
	 */	
	
	public static String getJSONOutputString(HttpURLConnection connection) throws ClientProtocolException, IOException, JSONException{
		
		Scanner scan = new Scanner(connection.getInputStream());
		
		String responseJsonString = new String();
		try{
			while (scan.hasNext())
				responseJsonString += scan.nextLine();;
			scan.close();

			return responseJsonString;
		}
		
		 catch (Exception e) {
			e.printStackTrace();
			return null;
		 }	
	}
	
	/**
	 * Method to get the output property from JSON output
	 * @author Gopu Raju
	 * @since 10-28-2016
	 * @param String jsonString,String arrayKey,String objectKey
	 * @return 
	 */
	
	public static String getJsonObjectProperty(String jsonString,String arrayKey,String objectKey){
		
		try{
			JsonElement root = new JsonParser().parse(jsonString);
			String jsonObjectProperty = root.getAsJsonObject().get(arrayKey).getAsJsonObject().get(objectKey).getAsString();
			return jsonObjectProperty;
		}
		
		 catch (Exception e) {
			e.printStackTrace();
			return null;
		 }	
	
	}
	
}

package PageObjectLibrary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paulhammant.ngwebdriver.ByAngular;

import LPLCoreDriver.LPLConfig;
import LPLCoreDriver.LPLCoreDBConnect;
import LPLCoreDriver.LPLCoreDriver;

public class IASCWESignature extends LPLCoreDriver{

	public WebDriver driver;
	
	public String strError = null;
	
	/** ID Property Value of Page Border. */
	public String strDocSignTabsHolder_ID = "ds_Tabs";
	
	/** ID property value of Logout button*/
	public String strDocSignLogout_ID = "ds_LogoutNew";
	
	/** ID property value of Logout button*/
	public String strStartNewEnvelopeBtn_ID = "ds_hldrHC_btnNew_btnInline";
	
	/** CSS Selector property value of Logout button*/
	public String strEnvelopeStatus_CSS = "#ds_hldrBdy_dstTile1_tcTileHeaderText";
	
	/** CSS Selector property value of Logout button*/
	public String strGettingStarted_CSS = "#getStartedTile_tcTileHeaderText";
	
	/** CSS Selector property value of Logout button*/
	public String strDocSignIDCard_CSS = "ds_hldrBdy_dstTile4_tcTileHeaderText";
	
	/** CSS Selector property value of Logout button*/
	public String strSearchEnvelope_CSS = "#txtFind";
	
	public static final int INTPAGEID =  452;
	
	public String[][] allObjects;
	
	public String[][] angularObjects;
	public String strObjectsNotFound;
	
	public IASCWESignature(WebDriver driver){
		this.driver =driver;
		
		try{
			
			/** Fetching the page objects from FARM */
			HashMap<String, HashMap<String, String>> pageObjectsMap = LPLCoreDBConnect.getObjectsFromDB(INTPAGEID, new LPLConfig().getEnvId());
			if(pageObjectsMap.get("strDocSignTabsHolder").get("ID")!= null)
				strDocSignTabsHolder_ID = pageObjectsMap.get("strDocSignTabsHolder").get("ID");
			
			if(pageObjectsMap.get("strDocSignLogout").get("ID")!= null)
				strDocSignLogout_ID = pageObjectsMap.get("strDocSignLogout").get("ID");
			
			if(pageObjectsMap.get("strStartNewEnvelopeBtn").get("ID")!= null)
				strStartNewEnvelopeBtn_ID = pageObjectsMap.get("strStartNewEnvelopeBtn").get("ID");
			
			if(pageObjectsMap.get("strEnvelopeStatus").get("CSS")!= null)
				strEnvelopeStatus_CSS = pageObjectsMap.get("strEnvelopeStatus").get("CSS");
			
			if(pageObjectsMap.get("strGettingStarted").get("CSS")!= null)
				strGettingStarted_CSS = pageObjectsMap.get("strGettingStarted").get("CSS");
			
			if(pageObjectsMap.get("strDocSignIDCard").get("CSS")!= null)
				strDocSignIDCard_CSS = pageObjectsMap.get("strDocSignIDCard").get("CSS");
			
			if(pageObjectsMap.get("strSearchEnvelope").get("CSS")!= null)
				strSearchEnvelope_CSS = pageObjectsMap.get("strSearchEnvelope").get("CSS");
			
			String[][] allPageObjects = {{strDocSignTabsHolder_ID, "Header Tabs","ID"},
								{strDocSignLogout_ID, "Logout button", "ID"},
								{strStartNewEnvelopeBtn_ID, "start new envelope button", "ID"},
								{strSearchEnvelope_CSS, "Search button", "CSS"}};
			String[][] otherObjects = {{strEnvelopeStatus_CSS, testData.get("strEnvelopeStatustxt"), "CSS"},
										{strGettingStarted_CSS, testData.get("strGettingStartedtxt"), "CSS"},
										{strDocSignIDCard_CSS, testData.get("strDocSignIDCardtxt"), "CSS"}};
			this.allObjects = allPageObjects;
			this.angularObjects = otherObjects;
		
		}catch(Exception ex){
		
			strError = strError+ex.getMessage();
		}
	}
	
	/**
	 * Method to Verify All Angular Objects in a page using an object array
	 * 
	 * @author Sunitha Appaiah
	 * @since 09-21-2017
	 * @param arrAngularObjects - page Objects to be verified.
	 * @return (boolean) True/False
	 * 
	 */
		
		public boolean verifyAngularObjects(String[][] arrAngularObjects){
			By byVar = null;
			
			boolean blnResult = false;
				for(String[] eachAngularObject : arrAngularObjects){
					List<String> objAngularObject = Arrays.asList(eachAngularObject);
					switch(objAngularObject.get(2).toUpperCase()){
						case "CSS":
							byVar = ByAngular.cssContainingText(objAngularObject.get(0), objAngularObject.get(1));
							break;
						case "BINIDING":
							byVar = ByAngular.binding(objAngularObject.get(0));
							break;
						case "EXACTBINDING":
							byVar = ByAngular.exactBinding(objAngularObject.get(0));
							break;
						case "REPEATER":
							byVar = ByAngular.repeater(objAngularObject.get(0));
							break;
						case "EXACTREPEATER":
							byVar = ByAngular.exactRepeater(objAngularObject.get(0));
							break;
						case "BUTTONTEXT":
							byVar = ByAngular.buttonText(objAngularObject.get(0));
							break;
						case "PARTIALBUTTONTEXT":
							byVar = ByAngular.partialButtonText(objAngularObject.get(0));
							break;
						case "MODEL":
							byVar = ByAngular.model(objAngularObject.get(0));
							break;
						case "OPTIONS":
							byVar = ByAngular.options(objAngularObject.get(0));
							break;
						default:
								break;
					}
					try {
						driver.findElement(byVar);
						blnResult= true;
					} catch (Exception e) {
						StringBuilder bld = new StringBuilder();
						bld.append(objAngularObject.get(0));
						strObjectsNotFound = bld.toString();
						strError = strError + e.getMessage();
						blnResult= false;
						break;
					}
				}
			return blnResult;
		}

}

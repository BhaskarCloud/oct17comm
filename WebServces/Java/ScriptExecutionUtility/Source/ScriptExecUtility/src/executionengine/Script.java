package executionengine;

/**
 * @author graju
 *
 */
public class Script {

	public String scriptID;
	public String firmName;
	public int firmID;
	public int productID;
	public String appName;
	public int EnvID;
	public String url;
	
	/**
	 * @return the envID
	 */
	public int getEnvID() {
		return EnvID;
	}

	/**
	 * @param envID
	 *            the envID to set
	 */
	public void setEnvID(int envID) {
		EnvID = envID;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	

	/**
	 * @return the scriptID
	 */
	public String getScriptID() {
		return scriptID;
	}

	/**
	 * @param scriptID
	 *            the scriptID to set
	 */
	public void setScriptID(String scriptID) {
		this.scriptID = scriptID;
	}

	/**
	 * @return the firmName
	 */
	public String getFirmName() {
		return firmName;
	}

	/**
	 * @param firmName
	 *            the firmName to set
	 */
	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	/**
	 * @return the firmID
	 */
	public int getFirmID() {
		return firmID;
	}

	/**
	 * @param firmID
	 *            the firmID to set
	 */
	public void setFirmID(int firmID) {
		this.firmID = firmID;
	}

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @param productID
	 *            the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @param appName
	 *            the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

}

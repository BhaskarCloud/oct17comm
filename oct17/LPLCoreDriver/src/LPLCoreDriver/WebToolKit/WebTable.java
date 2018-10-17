package LPLCoreDriver.WebToolKit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreSync;


/**
 * <p>
 * <br><b> Title: </b> WebTable.java</br>
 * <br><b> Description: </B> WebTable Utility Class</br>
 * <br><b>Usage:</br></b>
 * <br>1. getColumnHeaders: This function is used to  get the list of Column header objects.</br>
 * <br>2. getChildItem: This function is used to  get the child item from the specified cell of WebTable.</br>
 * <br>3. getRowCount: This function is used to  get the total Row count of Web Table.</br>
 * <br>4. getColumnIndex: This function is used to  get the total Row count of Web Table. </br>
 * <br>5. getCellValue: This function is used to  get the cell value.</br>
 * <br>6. getCellIndex: This function is used to  get the index of the cell containing the specific value .</br>
 * <br>7. waitTillTableLoaded: This function is used to wait till the table gets loaded properly  .</br>
 * @author Ambarish Khatua
 * @since 05-25-2016 
 * </p>
 */
public class WebTable {
	private By objByHeader;
	private By objByRow;
	private By objByColumn;
	
	public WebTable(By objByHeader, By objByRow, By objByColumn){
		this.objByHeader = objByHeader;
		this.objByRow = objByRow;
		this.objByColumn = objByColumn;
	}
	
	/**
	* This function is used to  get the list of Column header objects 
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   05-25-2016
	* @param   WebElement objWebTableHeader - WebTable Header Object 
	* @return  List<WebElement> lstColumnHeaders - List of Column Header objects
	*/
	public List<WebElement> getColumnHeaders(WebElement objWebTableHeader){
		List<WebElement> lstColumnHeaders = null;
		
		try{
			if (objWebTableHeader.isDisplayed()){
				lstColumnHeaders = objWebTableHeader.findElements(objByHeader);
				return lstColumnHeaders;
			}else{
				return lstColumnHeaders;
			}
			
		}catch(Exception e){
			return lstColumnHeaders;
		}		
	}
	
	/**
	* This function is used to click on column header 
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   05-31-2016
	* @param   WebElement objWebTableHeader - WebTable Header Object, String strColumnName
	* @return  boolean - True/False
	*/
	public boolean clickColumnHeader(WebElement objWebTableHeader, String strColumnName){
		boolean blnResult = false;
		List<WebElement> lstColumnHeaders = null;
		
		try{
			if (objWebTableHeader.isDisplayed()){
				lstColumnHeaders = objWebTableHeader.findElements(objByHeader);
				
				for(WebElement objColumnHeader : lstColumnHeaders){
					if (objColumnHeader.getText().trim().equalsIgnoreCase(strColumnName)){
						objColumnHeader.click();
						blnResult = true;
						break;
					}
				}
				return blnResult;
			}else{
				return blnResult;
			}
		}catch(Exception e){
			return blnResult;
		}		
	}
	
	/**
	* This function is used to  get the child item from the specified cell of WebTable.  
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   05-25-2016
	* @param   WebElement objWebTable - Web Table object, int rowIndex - Row Index,  int colIndex - Column Index, String elementTag - HTML Element Tag
	* @return  WebElement objChildItem - Child Item object
	*/
	public WebElement getChildItem(WebElement objWebTable, int rowIndex, int colIndex, String elementTag){
		WebElement objChildItem = null;
		String strChildItemTag = ".//tr["+rowIndex+"]/td["+colIndex+"]//"+elementTag;
		try{
			if (objWebTable.isDisplayed()){
				objChildItem = objWebTable.findElement(By.xpath(strChildItemTag));
				return objChildItem;
			}else{
				return objChildItem;
			}
			
		}catch(Exception e){
			return objChildItem;
		}		
	}
	
	/**
	* This function is used to  get the total Row count of Web Table.  
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   05-26-2016
	* @param   WebElement objWebTable - Web Table object
	* @return  int intRows - Total rows count
	*/
	public int getRowCount(WebElement objWebTable){
		int intRows = -1;
		try{
			intRows = objWebTable.findElements(objByRow).size();
			return intRows;
		}catch(Exception e){
			return intRows;
		}
	}
	
	/**
	* This function is used to  get the total Row count of Web Table.  
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   06-02-2016
	* @param   WebElement objTableHeader - Table Header object, String strColumnName - Column Name
	* @return  int intColumnIndex - Column Index
	*/
	public int getColumnIndex(WebElement objTableHeader, String strColumnName){
		int intColumnIndex = 0;
		
		try{
			List<WebElement> lstColumnHeader = getColumnHeaders(objTableHeader);
			for(WebElement objColumn : lstColumnHeader){
				intColumnIndex++;
				if(objColumn.getText().trim().equalsIgnoreCase(strColumnName)){
					return intColumnIndex;
				}
			}
			return intColumnIndex;
		}catch(Exception e){
			return intColumnIndex;
		}
		
	}
	
	/**
	* This function is used to  get the cell value  
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   06-01-2016
	* @param   WebElement objWebTable - Web Table object, int intRow - Row Index, int intCol - Col Index
	* @return  String - Cell value
	*/
	public String getCellValue(WebElement objWebTable, int intRow, int intCol){
		String strCellValue = "";
		try{
			List<WebElement> lstRows = objWebTable.findElements(objByRow);
			WebElement objCell = lstRows.get(intRow).findElements(objByColumn).get(intCol-1);
			strCellValue = objCell.getText();
			return strCellValue;
		}catch(Exception e){
			return strCellValue;
		}
		
	}
	
	/**
	* This function is used to  get the index of the cell containing the specific value  
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   06-01-2016
	* @param   WebElement objWebTable - Web Table object, String strCellValue
	* @return  Integer[] cellIndex - Integer array of Row and Column Index
	*/
	public Integer[] getCellIndex(WebElement objWebTable, String strCellValue){
		int intRows;
		int intCols;
		Integer[] cellIndex = null;
		try{
			intRows = objWebTable.findElements(objByRow).size();
			intCols = objWebTable.findElements(objByColumn).size();
			boolean blnFlag = false;
			for(int intRowIndex = 1; intRowIndex<=intRows; intRowIndex++){
				for(int intColIndex = 1; intColIndex<=intCols; intColIndex++){
					if(strCellValue.equalsIgnoreCase(getCellValue(objWebTable, intRowIndex, intColIndex))){
						cellIndex = new Integer[]{intRowIndex, intColIndex};
						blnFlag = true;
						break;
					}
				}
				if(blnFlag)
					break;
			}
			return cellIndex;
		}catch(Exception e){
			return cellIndex;
		}
		
	}
	
	/**
	* This function is used to wait till the table gets loaded properly  
	*
	* @author  Ambarish Khatua
	* @version 1.0
	* @since   06-02-2016
	* @param   WebElement objWebTable - Web Table object, int intTimeOut - TimeOut Value
	* @return  boolean - True/False
	*/
	public boolean waitTillTableLoaded(WebDriver driver, By byTable, int intTimeOut){
		boolean blnResult = false;
		try{
			LPLCoreConstents lplCoreConstents = new LPLCoreConstents();
			LPLCoreSync.waitTillVisible(driver, byTable, lplCoreConstents.MEDIUM);
			while(intTimeOut > 0){
				if (driver.findElement(byTable).findElements(objByRow).size() > 1){
					blnResult = true;
					break;
				}
				intTimeOut--;
			}
			return blnResult;
		}catch(Exception e){
			return blnResult;
		}
		
	}

}

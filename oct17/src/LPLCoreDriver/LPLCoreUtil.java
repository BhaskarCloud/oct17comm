package LPLCoreDriver;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.UserAuthenticator;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * <p>
 * <br>
 * <b> Title: </b> LPLCoreUtil.java</br> <br>
 * <b> Description: </B> LPL Core Library - Utility Methods useful for
 * anyone</br> <br>
 * <b>Usage:</br></b> <br>
 * 1. mouseHoverJScript: Method to Mouse over using Java script Executor</br> <br>
 * 2. mouseHoverAndClickJScript: Method to Mouse over and Click using Java
 * script Executor</br> <br>
 * 3. isElementPresent: Method to Verify if Web Element is Present in the
 * current page</br> <br>
 * 4. waitForWebElements: Method to Close all browser processes running if the
 * executions happens in Farm</br> <br>
 * 5. waitForWebElement: This function is used to handle login certificates in
 * PRODVIP environment for BranchNet Application</br> <br>
 * 6. DownloadAndOpenDocument: This function is used to select login
 * certificates in PRODVIP environment after BN menu navigation</br> <br>
 * 7. getLatestFilefromDir: This method is to Find the Latest Document in a Directory</br> <br>
 * 8. getCurrentDay: This function is used to get the current day in a particular format</br> <br>
 * 9. uploadFile: This function is used to handle Upload Popup</br> <br>
 * 10. verifyFilePresentInDir: This method is to Verify if a file is present in a given directory using Path, File name and Authentication user details</br> <br>
 * 11. verifyFilePresentInDir: This method is to Verify if a file is present in a given directory using Host name,Directory under that host, File name and Authentication user details</br> <br>
 * 12. verifyFilePresentInDir: This method is to Verify if a file is present in a given directory without authentication</br> <br>
 * 13. verifyFolderPresentInDir: This method is to Verify if a Folder is present in a given directory without authentication</br> <br>
 * 14. copyAndReplaceFile : This method is to Copy a file from a source directory to Destination . If the file already exists, it gets replaced </br> <br>
 * 15. switchToAnyExistingChildWindow: This function is used to Switch to child window which doesn't contains window title (Basically which is not the Parent window) </br><br>
 * 16. waitForListOfWebElements: This function is used to get a list of webelements by atleast one of the locators specified using By Locators as Parameters</br>
 * 17. getPreviousBusinessDay(String dayFormat, String DateFormat): This Function is used to get the previous Business day in required Format.
 * 18. acceptAlertDialog: This function is used to accept alert dialog
 * 19. cancelIESavePasswordPopUp: To Cancel IE Save Password Popup as soon as we login
 * 20. browserSpecificDownload: This function is perform browser Specific download by handling the Download popups specific to each browser
 * 21. deleteDownloadedFile: This Method is to Delete the Downloaded File
 * 22. generateRandomData: This function is used to generate random numbers, Alphabets and AlphaNumeric
 * 23. clickOnElement: This method is used to click on any web element by using Java script executor click or normal click and this method is used when mutliple clicks are required with in a method.
 * @author Aiswarya Srinivasan
 * @since 02-24-2017
 *        </p>
 */
public class LPLCoreUtil extends LPLCoreDriver {
	
	/** String type...To be used to capture any error occurred at runtime. */
	public static String strError;

	/**
	 * Method to Mouse over using Java script Executor
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 02-24-2017
	 * @param WebElement
	 *            HoverElement - The Web Element to Hover
	 * @return None
	 */
	public static void mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				((JavascriptExecutor) driver).executeScript(mouseOverScript,
						HoverElement);
			} else {
				System.out.println("Element was not visible to hover " + "\n");

			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement
					+ "is not attached to the page document"
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement
					+ " was not found in DOM" + e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering"
					+ e.getStackTrace());
		}
	}

	/**
	 * Method to Mouse over and Click using Java script Executor
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 02-24-2017
	 * @param WebElement
	 *            HoverElement - The Web Element to Hover
	 * @return None
	 */
	public static void mouseHoverAndClickJScript(WebElement HoverElement) {
		try {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			if (isElementPresent(HoverElement)) {

				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				js.executeScript(mouseOverScript, HoverElement);
				js.executeScript("arguments[0].click()", HoverElement);
			} else {
				System.out.println("Element was not visible to hover " + "\n");

			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement
					+ "is not attached to the page document"
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement
					+ " was not found in DOM" + e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering"
					+ e.getStackTrace());
		}
	}

	/**
	 * Method to Verify if Web Element is Present in the current page
	 * 
	 * @author Aiswarya Srinivasan
	 * @since 02-24-2017
	 * @param WebElement
	 *            element - The Web Element to Verify
	 * @return Boolean true if Found else false
	 */
	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed() || element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * This function is used to get a webelement by atleast one of the locators
	 * specified using By Locators as Parameters
	 * 
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 07-05-2016
	 * @param maxTimeSeconds
	 *            - Maximum time to wait for all the locators, locators - All
	 *            the By locators in an array
	 * @return WebElement - The Element which is found in the application within
	 *         the specified ones
	 */
	public static WebElement waitForWebElements(int maxTimeSeconds,
			By... locators) throws Exception {
		Boolean isElementFound = false;
		StopWatch sw = new StopWatch();
		By foundLocator = null;
		sw.start();
		try {
			while (!isElementFound && sw.getTime() < maxTimeSeconds * 1000) {
				for (int i = 0; i < locators.length; i++) {
					if (driver.findElements(locators[i]).size() > 0) {
						isElementFound = true;
						foundLocator = locators[i];
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
	}

	/**
	 * This function is used to get a webelement by mentioned locator within the
	 * max time specified
	 * 
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 07-05-2016
	 * @param strLocatorType
	 *            - Locator type of the web element we are trying to find,
	 *            strLocator - Locator string, intMaxTime - Maximum time to wait
	 *            for the Webelement
	 * @return By foundLocator - The Locator which is found in the application
	 *         within the specified ones
	 */
	public static WebElement waitForWebElement(int maxTimeSeconds, By strLocator)
			throws Exception {
		Boolean isElementFound = false;
		StopWatch sw = new StopWatch();
		sw.start();
		try {
			while (!isElementFound && sw.getTime() < maxTimeSeconds * 1000) {
				try {
					driver.findElement(strLocator);
					isElementFound = true;
					break;
				} catch (Exception e) {

				}
			}
		} catch (Exception e) {
			throw new Exception();
		}
		if (!isElementFound) {
			throw new Exception();
		}
		return driver.findElement(strLocator);
	}

	/**
	 * DownloadOpenDocument : This method is to Download and open a document in
	 * IE
	 * 
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 01-19-2017
	 * @param None
	 * @return boolean True if Document opened successfully and False if failed
	 */
	public static boolean DownloadAndOpenDocument(String strPopUpOptions) {
		try {
			if (ocfg.getBrowserType().equalsIgnoreCase("IE")
					|| ocfg.getBrowserType().equalsIgnoreCase("IEXPLORE")) {
				Actions action = new Actions(driver);
				action.keyDown(Keys.CONTROL).sendKeys("j").build().perform();
				action.keyUp(Keys.CONTROL).build().perform();
				LPLCoreSync
						.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
				try {
					switch (strPopUpOptions.toUpperCase()) {
					case "SAVE":
						//If popup has Save & Cancel options
						Runtime.getRuntime()
						.exec(LPLCoreConstents.getInstance().strIEDownloadCommand);
						break;
						
					case "OPENSAVE":
						//If popup has Open, Save & Cancel options
						Runtime.getRuntime()
						.exec(LPLCoreConstents.getInstance().strIEOpenSaveDownloadCommand);
						break;
							
					default:
						break;
					}
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				LPLCoreSync
						.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
				return true;
			} else {
				System.out
						.println("Browser is not IE. Hence Download is not supported yet");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * getLatestFilefromDir : This method is to Find the Latest Document in a
	 * Directory
	 * 
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 01-23-2017
	 * @param None
	 * @return File The File Object which is latest on the stated Directory
	 */
	public static File getLatestFilefromDir(String strDirPath) {
		File dir = new File(strDirPath);
		File[] arrFiles = dir.listFiles();
		if (arrFiles == null || arrFiles.length == 0) {
			return null;
		}

		File lastModifiedFile = arrFiles[0];
		for (int i = 1; i < arrFiles.length; i++) {
			if (lastModifiedFile.lastModified() < arrFiles[i].lastModified()) {
				lastModifiedFile = arrFiles[i];
			}
		}
		return lastModifiedFile;
	}

	/**
	 * getLatestFilefromDir : This method is to get the newest file for a
	 * specific extension in a directory
	 * 
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 01-23-2017
	 * @param None
	 * @return File The File Object which is latest on the stated Directory
	 */
	public static File getTheNewestFile(String strDirectory, String strExtn) {
		File theNewestFile = null;
		File dir = new File(strDirectory);
		FileFilter fileFilter = new WildcardFileFilter("*." + strExtn);
		File[] files = dir.listFiles(fileFilter);

		if (files.length > 0) {
			/** The newest file comes first **/
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
		}

		return theNewestFile;
	}

	/**
	 * This function is used to get the current day
	 *
	 * @author Sunitha
	 * @version 1.0
	 * @since 02/08/2017
	 * @return String - current day
	 * @param String
	 *            dayFormat - Search for Required day format e.g., EEE(Mon) or
	 *            EEEE(Monday)
	 */
	public static String getCurrentDay(String dayFormat) {

		SimpleDateFormat dayformat = new SimpleDateFormat(dayFormat);
		Date date = new Date();

		// Converts the current date to required day format e.g., EEE(Mon) or
		// EEEE(Monday)
		String currentDay = dayformat.format(date);

		// Return's the current day
		return currentDay;
	}

	/**
	 * This function is used to handle Upload Popup
	 *
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 02-15-2017
	 * @param strFullAbsoluteFilePath
	 *            - Absolute file path of the file to Upload. Example:
	 *            C:\\Book1.xls
	 * @return N/A
	 */
	public static boolean uploadFile(String strFullAbsoluteFilePath) {
		try {
			/**
			 * Create the Upload handling windows command to execute the AutoIT
			 * exe file.
			 */
			String strCertCommand = LPLCoreConstents.getInstance().strWinUploadHandleCommand
					+ "," + "\"" + strFullAbsoluteFilePath + "\"";
			String[] strUploadHandleCommand = strCertCommand.split(",");

			// Create JAVA Runtime class to execute the windows command to
			// execute the AutoIT exe file to select the required Certificate
			Runtime runtime = Runtime.getRuntime();
			try {
				Process process = runtime.exec(strUploadHandleCommand);
				try {
					int value = process.waitFor();
					if (value != 0) {
						LPLCoreReporter
								.WriteReport(
										"File Upload Command Execution Process",
										"File Upload Command Execution Process should be successful",
										"File Upload Command Execution Process terminated abnormally.",
										LPLCoreConstents.FAILED, "");
						return false;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					LPLCoreReporter
							.WriteReport(
									"File Upload Command Execution Process",
									"File Upload Command Execution Process should be successful",
									"File Upload Command Execution Process terminated abnormally. Error: "
											+ e.getMessage(), LPLCoreConstents.FAILED, "");
					return false;
				}
			} catch (IOException e) {
				e.printStackTrace();
				LPLCoreReporter
						.WriteReport(
								"File Upload Command Execution Process",
								"File Upload Command Execution Process should be successful",
								"File Upload Command Execution Process terminated abnormally. Error: "
										+ e.getMessage(), LPLCoreConstents.FAILED, "");
				return false;
			}
			LPLCoreSync
					.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			LPLCoreReporter
					.WriteReport(
							"File Upload Command Execution Process",
							"File Upload Command Execution Process should be successful",
							"File uploaded successfully from path:[."
									+ strFullAbsoluteFilePath + "]", LPLCoreConstents.PASSED,
							"");
			return true;
		} catch (Exception ex) {
			LPLCoreReporter
					.WriteReport(
							"File Upload Command Execution Process",
							"File Upload Command Execution Process should be successful",
							"File Upload Command Execution Process terminated abnormally. Error: "
									+ ex.getMessage(), LPLCoreConstents.FAILED, "");
			return false;
		}
	}

	/**
	 * verifyFilePresentInDir : This method is to Verify if a file is present in a given directory using Path, File name and Authentication user details
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 02-15-2017
	 * @param strDirPath - Directory path to check for the file, 
	 *            strFileName - File to check for
	 *            strAuthenticationuser - User to authenticate while searching
	 *            strAuthenticationPassword - Password to authenticate while searching the file
	 * @return boolean true if found and false if not found
	 */
	public static boolean verifyFilePresentInDir(String strDirPath,
			String strFileName, String strAuthenticationuser,
			String strAuthenticationPassword) {
		try {
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("corp",strAuthenticationuser, strAuthenticationPassword);
			String path = "smb:"+ strDirPath+ "/" + strFileName;
			SmbFile sFile = new SmbFile(path, auth);
			if (sFile.exists()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * verifyFilePresentInDir : This method is to Verify if a file is present in a given directory using Host name,Directory under that host, File name and Authentication user details
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 02-28-2017
	 * @param strHost - Host machine in which the file is located, 
	 * 			strUser - User to Authenticate, 
	 * 			strPassword - Password to Authenticate,
	 *          strRemoteDirInTheHost - Directory path to check for the file,
	 *          strFileName - File to check for
	 * @return boolean true if found and false if not found
	 */
	public static boolean verifyFilePresentInDir(String strHost,
			String strUser, String strPassword, String strRemoteDirInTheHost,
			String strFileName) {
		boolean blnFileFound = false;
		FileSystemManager fsManager = null;
		FileSystemOptions opts = null;
		FileObject sftpFile;

		// Getting the File manager
		try {
			fsManager = VFS.getManager();
		} catch (FileSystemException ex) {
			throw new RuntimeException("failed to get fsManager from VFS", ex);
		}

		// Setting the User Authentication
		UserAuthenticator auth = new StaticUserAuthenticator(null, strUser,
				strPassword);
		opts = new FileSystemOptions();
		try {
			DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(
					opts, auth);
		} catch (FileSystemException ex) {
			throw new RuntimeException("setUserAuthenticator failed", ex);
		}

		// Setting the FTP URL
		String strStartPath = "file://" + strHost + strRemoteDirInTheHost;
		FileObject[] children;

		// Set starting path on remote SFTP server.
		try {
			sftpFile = fsManager.resolveFile(strStartPath, opts);

			System.out.println("SFTP connection successfully established to "
					+ strStartPath);
		} catch (FileSystemException ex) {
			throw new RuntimeException("SFTP error parsing path "
					+ strRemoteDirInTheHost, ex);
		}

		// Get a directory listing
		try {
			children = sftpFile.getChildren();
		} catch (FileSystemException ex) {
			throw new RuntimeException("Error collecting directory listing of "
					+ strStartPath, ex);
		}

		// For each in the list , verify if the file name has a match
		for (FileObject f : children) {
			try {
				if (f.getPublicURIString().toLowerCase().endsWith(strFileName.toLowerCase())) {
					blnFileFound = true;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				LPLCoreReporter.WriteReport("Finding File in a directory", "File should be present in the given directory",
						"Finding File Failed. Path: " + strStartPath+ "File missing: " + strFileName+"  User trying to authenticate: " +strUser + " Error: " + e.getMessage(), LPLCoreConstents.FAILED, "");
			}
		}

		return blnFileFound;
	}

	/**
	 * verifyFilePresentInDir : This method is to Verify if a file is present in a given directory without authentication
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 02-15-2017
	 * @param strDirPath
	 *            - Directory path to check for the file, strFileName - File to
	 *            check for
	 * @return boolean true if found and false if not found
	 */
	public static boolean verifyFilePresentInDir(String strDirPath,
			String strFileName) {
		try {
			boolean blnFound = false;
			File dir = new File(strDirPath);
			FileFilter fileFilter = new WildcardFileFilter("*.*");
			File[] files = dir.listFiles(fileFilter);
			for (File thisFile : files) {
				if (thisFile.getName().equalsIgnoreCase(strFileName)) {
					blnFound = true;
					break;
				}
			}
			return blnFound;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * verifyFolderPresentInDir : This method is to Verify if a folder is present in a given directory without authentication
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-02-2017
	 * @param strDirPath
	 *            - Directory path to check for the file, strFolderName - Folder to
	 *            check for
	 * @return boolean true if found and false if not found
	 */
	public static boolean verifyFolderPresentInDir(String strDirPath,
			String strFolderName) {
		try {
			boolean blnFound = false;
			File dir = new File(strDirPath);
			File DirToCheck = new File(strFolderName);
			if (FileUtils.directoryContains(dir, DirToCheck)) {
				blnFound = true;
			}
			return blnFound;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * copyAndReplaceFile : This method is to Copy a file from a source directory to Destination . If the file already exists, it gets replaced
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 02-28-2017
	 * @param strSourceFilePath - Directory path to copy the file from, 
	 * 			strDestinationPath - Directory path to copy the file to, 
	 * 			strFileName - File to Copy
	 * @return boolean true if Copied and replaced else false
	 */
	public static void copyAndReplaceFile(String strSourceFilePath,
			String strDestinationPath, String strFileName) throws IOException {
		File objDestnPath = new File(strDestinationPath);
		File objSrcFile = new File(strSourceFilePath + "/" + strFileName);
		// Check if both source and destination paths are available
		if ((objDestnPath.isDirectory()) && (objSrcFile.isFile())) {
			// creating object for Destination File
			File objDestnFile = new File(strDestinationPath + "/" + strFileName);
			// Already if file is exists in Destination path,
			if (objDestnFile.isFile()) {
				// delete it
				objDestnFile.delete();
				// paste file from source to Destination path with fileName as
				// value of fileName argument
				FileUtils.copyFile(objSrcFile, objDestnFile);
			} else
			// If File does not exists in Destination path.
			{
				// paste file from source to Destination path with fileName as
				// value of fileName argument
				FileUtils.copyFile(objSrcFile, objDestnFile);
			}
		}
	}

	/**
	 * This function is used to Switch to child window which doesn't contains window title (Basically which is not the Parent window)
	 * @author Sunitha
	 * @version 1.0
	 * @since 03/02/2017 
	 * @return boolean - True/False
	 * @param strParentHandle - String Parent window name
	 */
	public static boolean switchToAnyExistingChildWindow(String strParentHandle) {
		
		boolean blnResult = false;
		try{
		//Get all the Window Handles
		Set<String> arrAllHandles = driver.getWindowHandles();
        
		//Switch to Child Window 
		if (arrAllHandles.size()>1) {
               for (String currentHandle : arrAllHandles) {
                      if (!currentHandle.trim().equalsIgnoreCase(strParentHandle.trim())) {
                             driver.switchTo().window(currentHandle);
                             blnResult = true;
                             break;
                      		}
               		}      
        	}
		return blnResult;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * This function is used to get a list of webelements by atleast one of the locators
	 * specified using By Locators as Parameters
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-14-2017
	 * @param maxTimeSeconds
	 *            - Maximum time to wait for all the locators, locators - All
	 *            the By locators in an array
	 * @return List<WebElement> - The list of Elements first found in the application with atleast one of the locators
	 */
	public static List<WebElement> waitForListOfWebElements(int maxTimeSeconds,
			By... locators) throws Exception {
		Boolean isElementFound = false;
		StopWatch sw = new StopWatch();
		By foundLocator = null;
		sw.start();
		try {
			while (!isElementFound && sw.getTime() < maxTimeSeconds * 1000) {
				for (int i = 0; i < locators.length; i++) {
					if (driver.findElements(locators[i]).size() > 0) {
						isElementFound = true;
						foundLocator = locators[i];
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
		return driver.findElements(foundLocator);
	}
	
	/**
	 * roundDoubleValue - This function is used to round a double variable with specified number oafter the point
	 * @author Aiswarya Srinivasan
	 * @version 1.0
	 * @since 03-14-2017
	 * @param dblValue - The Double value to round, intNumOfPlaces - Number of places required after point
	 * @return double - the rounded Double value
	 */
	public static double roundDoubleValue(double dblValue, int intNumOfPlaces) {
	    if (intNumOfPlaces < 0) 
	    	throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, intNumOfPlaces);
	    dblValue = dblValue * factor;
	    long tmp = Math.round(dblValue);
	    return (double) tmp / factor;
	}
	
	/**
	 * getPreviousBusinessDay - This function is used to get the previous business day
	 * @author Sunitha
	 * @version 1.0
	 * @since 03/22/2017
	 * @param String dayFormat - Search for Required day format e.g., EEE(Mon) or EEEE(Monday)
	 * 		  String DateFormat - Search for Required Date Format e.g., M/d/YYYY or M/d/YY
	 * @return boolean - True/False
	 * @param N/A
	 */
	public static String getPreviousBusinessDay(String strDayFormat, String strDateFormat) {
		Date strSysDate;
		try{
		
		//Convert the current date to any Date (M/d/yyyy) format
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		Date date = new Date();
		
		//Gets the current day 
		String currentDay = getCurrentDay(strDayFormat);
		
		//If current day is monday it will subtract 3 days then we will get friday (previous business day) 
		if(currentDay.equalsIgnoreCase("Monday")){
				strSysDate = DateUtils.addDays(date,-3);	
			
			//If current day is Sunday it will subtract 2 days then we will get friday (previous business day) 
			}else if(currentDay.equalsIgnoreCase("Sunday")){
				strSysDate = DateUtils.addDays(date,-2);
			
			//else it will subtract 1 day from current day then we will get the Previous business day 
			}else{
				strSysDate = DateUtils.addDays(date,-1);		
		}
		LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
		
		//Converting previous business date to String
		String strpreviousBusinessDay =dateFormat.format(strSysDate);
		return 	strpreviousBusinessDay;
		
		} catch (Exception e) {
			String fail = "Problem in getting the previous Business date. Error Details: "
					+ e.getMessage();
			return fail;
			}
	}
	
	/**
	 * This function is used to accept alert dialog
	 * @author Aiswarya
	 * @version 1.0
	 * @since 04-17-2017
	 * @param None
	 * @return boolean true/False
	 *  */
	public boolean acceptAlertDialog()
	{
		boolean blnResult=false;
		try
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
			blnResult=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return blnResult;
	}
	
	/**
	 * Method to Cancel SavePassword Pop-Up in Internet Explorer Browser 
	 * 
	 * @author Ravneet Kaur
	 * @since 06-19-2017
	 * @param None
	 * @return blnVerified - Boolean type
	 */
	public static boolean cancelIESavePasswordPopUp() {
		if ((ocfg.getBrowserType().toUpperCase().trim().equals("IEXPLORE")) || (ocfg.getBrowserType().toUpperCase().trim().equals("IE"))) {
			try {
				LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
				String[] strIEPopUpHandleCommand = LPLCoreConstents
						.getInstance().CancelIEPwdPopUPCommand.split(",");

				// Create JAVA Runtime class to execute the windows command to
				// execute the AutoIT exe file to select the required
				// Certificate
				Runtime runtime = Runtime.getRuntime();
				try {
					Process process = runtime.exec(strIEPopUpHandleCommand);
					try {
						int value = process.waitFor();
						if (value != 0)
							LPLCoreReporter.WriteReport("To Cancel SavePassword Pop-Up in Internet Explorer Browser",
											"To Cancel SavePassword Pop-Up in Internet Explorer Browser should be successful",
											"To Cancel SavePassword Pop-Up in Internet Explorer Browser terminated abnormally.",
											LPLCoreConstents.FAILED, "");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					} catch (IOException e) {
						e.printStackTrace();
					}
					LPLCoreSync
							.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
					LPLCoreReporter.WriteReport("To Cancel SavePassword Pop-Up in Internet Explorer Browser",
									"To Cancel SavePassword Pop-Up in Internet Explorer Browser should be successful",
									"To Cancel SavePassword Pop-Up in Internet Explorer Browser should be successful",
									LPLCoreConstents.PASSED, "");
				return true;

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			}else{
				return true;
			}
	}

	/**
     * This function is perform browser Specific download by handling the Download popups specific to each browser
     * @author Aiswarya Srinivasan
     * @version 1.0
     * @since 06-09-2017
     * @return blnResult
     */
     public static boolean browserSpecificDownload() {
            boolean blnResult = false;
            try {
                   //Waiting for Download popup to appear Completely for any type of browser. 
                   //This is a static wait because dynamic waits failed here
                   LPLCoreSync.staticWait(LPLCoreConstents.getInstance().MediumInMiliSec);
                   
                   //If the Browser is IE, Click on Ctrl+j keys, and click on save in the popup. (Exe call) 
                   String strBrowser = LPLCoreDriver.ocfg.getBrowserType().toUpperCase();
                   if(strBrowser.toUpperCase().contains("IE") || strBrowser.toUpperCase().contains("IEXPLORE")) {  
                         blnResult=    LPLCoreUtil.DownloadAndOpenDocument("OPENSAVE");
                   }else if(strBrowser.toUpperCase().contains("FIREFOX")) {
                         //This is to press enter in case if Firefox download pop up comes up
                         Robot r = new Robot();
                         r.keyPress(KeyEvent.VK_ENTER);
                         r.keyRelease(KeyEvent.VK_ENTER);
                         return true;
                   }else if(strBrowser.toUpperCase().contains("CHROME")){
                         //If the Browser is Chrome, All files automatically gets downloaded
                         return true;
                   }
            }catch (Exception e) {
                   strError = e.getMessage();
                   return blnResult;
            }
            return blnResult;
     }
     
     /**
      * Method to Delete the Downloaded File
      * @author Aiswarya Srinivasan
      * @version 1.0
      * @since 06-09-2017
      * @param strDownloadedFileFullPath
      * @return (boolean) True/False
      */
      public static boolean deleteDownloadedFile(String strDownloadedFileFullPath) {
             boolean blnReturn = false;
             try {
                    //Delete the Downloaded File by using absolute path
                    File dir = new File(strDownloadedFileFullPath);
                    blnReturn = dir.delete();
             }catch(Exception e){
                    strError = e.getMessage();
                    blnReturn = false;
             }
             return blnReturn;
      }
      /**
       * This function is used to generate random numbers, Alphabets and AlphaNumeric
       * @author Jyothi Jyothi 
        * @version 1.0
       * @param String strRandomData -CaseName, strRandomNum-Number of Alphabets or Number Needed
       * @since 09-05-2017
       */
       public String  generateRandomData(String strRandomData, String... strRandomNum){
              String strRandomString= null;
              try{
                     int intRandomNumber=Integer.parseInt(strRandomNum[0]);
                     
                     switch(strRandomData.toUpperCase()){
                     case "NUMBER":
                           strRandomString =RandomStringUtils.randomNumeric(intRandomNumber);
                           return strRandomString;
                           
                     case "ALPHABET":
                           strRandomString = RandomStringUtils.randomAlphabetic(intRandomNumber);
                           return strRandomString;
                           
                     case "ALPHANUMERIC":
                           int intRandomAlphabet=Integer.parseInt(strRandomNum[1]);
                           strRandomString = RandomStringUtils.randomAlphabetic(intRandomAlphabet)+RandomStringUtils.randomNumeric(intRandomNumber);       
                           return strRandomString;
                     }
                     return strRandomString;
              }
              catch (Exception ex) {
                     strError = ex.getMessage();
                     return strRandomString;    
              }
       }   

    /**
   	 * clickOnElement: This method is used to click on any web element by using Java script executor click or normal click and this method is used when mutliple clicks are required with in a method
   	 * @author  Sunitha Appaiah
   	 * @since   11-27-2017
   	 * @parameter maxTimeSeconds - Maximum time to wait for the Webelement  
   	 * 				byLocator - To click on any By locator 	     
   	 * @return  N/A
   	 */
   	public static void clickOnElement(int maxTimeSecondsToWaitForElement ,By byLocator){
   		try{
   			//wait for webelement
   			WebElement objWebElement = waitForWebElement(maxTimeSecondsToWaitForElement, byLocator);
   			try {
   				//Normal click on webelement
   				objWebElement.click();
   				
   			} catch(Exception ex){
   				
   				//Java Executor click on by locator
   				JavascriptExecutor js = (JavascriptExecutor) driver;
   				js.executeScript(LPLCoreConstents.JSCLICK,objWebElement);
   			}
   			
   		}catch(Exception e){
   			LPLCoreReporter.WriteReport("Click on WebElement with locator " + byLocator.toString(), "Click on WebElement should be successful",
					"Failed to Click on WebElement with locator " + byLocator.toString() + ".Error: " + e.getMessage(), LPLCoreConstents.FAILED, "");
   		}
   		
   	}

}

package removeCompatibility;

import java.io.IOException;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;

import LPLCoreDriver.LPLCoreConstents;
import LPLCoreDriver.LPLCoreReporter;
import LPLCoreDriver.LPLCoreSync;

public class removeCompatibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


        System.setProperty("webdriver.ie.driver", "C:\\FarmClient\\TestDir\\WebDriverExe\\Win32\\IEDriverServer.exe");
        
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 

		InternetExplorerOptions ieOptions = new InternetExplorerOptions();


		ieOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		ieOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
		ieOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		ieOptions.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
		ieOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		
		WebDriver driver = new InternetExplorerDriver(ieOptions);

		
		
		driver.get("https://branchwebqa.lpl.com");
		
//		driver.findElement(By.xpath("")).sendKeys("UserName");
//		driver.findElement(By.xpath("")).sendKeys("Password");
//		driver.findElement(By.xpath("")).click();
		
		turnOffCompModeIE();
		
	}

	
	public static void turnOffCompModeIE() {
		try {
			String[] strCmpViewCommand = "cmd.exe,/C,Start,C:\\FarmClient\\TestDir\\CertSelectionEXE\\TurnOffCompModeIE.exe".split(",");
			
			//Create JAVA Runtime class to execute the windows command to execute the AutoIT exe file to select the required Certificate
			Runtime runtime = Runtime.getRuntime();
			try {
				Process process = runtime.exec(strCmpViewCommand);
				try {
					int value = process.waitFor();
					if(value!=0)
						LPLCoreReporter.WriteReport("Compatibility View Disabling Process", "Compatibility View disabling Process should be successful","Compatibility View disabling Process terminated abnormally.", LPLCoreConstents.FAILED, "");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			LPLCoreSync.staticWait(LPLCoreConstents.getInstance().BaseInMiliSec);
			LPLCoreReporter.WriteReport("Compatibility View Disabling Process", "Compatibility View disabling Process should be successful","Compatibility View Disabling Process successful", LPLCoreConstents.PASSED, "");
			
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe *32");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

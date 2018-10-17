package LPLCoreDriver;



public class LPLHarness extends LPLCoreDriver {

	public static void main(String[] args) {
		
		String strTestNameWithPackagePath = args[0];
		
		String[] TestScriptName = strTestNameWithPackagePath.split("\\.");
		for(String strItem : TestScriptName){
			strTestName = strItem;
		}
		
		//Running the Current test
		try {
			LPLCoreDriver core = new LPLCoreDriver();
			//Start Browser Session
			LPLCoreDriver.StartSession();
			core.runTest(strTestNameWithPackagePath);
			LPLCoreReporter.writeSummary();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}

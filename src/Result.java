import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Result implements ITestListener,IAuto {
	static int passCount,failCount;
	
	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		Reporter.log("hii",true);
		passCount++;
		
	}

	
	public void onTestFailure(ITestResult result) {
		String name = result.getName();	
		Reporter.log("Bye",true);
		failCount++;
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Pass:"+passCount,true);
		Reporter.log("fail:"+failCount,true);
		Practice.writeXLSheet(RES_PATH, passCount, failCount);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	

}

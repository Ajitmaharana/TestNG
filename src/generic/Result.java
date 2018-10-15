package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Result implements ITestListener {
	static int passCount=0,failCount=0,skipCount=0;
	
	@Override
	public void onTestSuccess(ITestResult result) {
           String name=result.getName();
           Reporter.log("Test:"+name+"is pass",true);
           passCount++;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name=result.getName();
        Reporter.log("Test:"+name+"is fail",true);
        failCount++;
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String name=result.getName();
        Reporter.log("Test:"+name+"is skip",true);
        skipCount++;
	}
	
	@Override
	public void onFinish(ITestContext context) {
            Reporter.log("pass: "+passCount,true);	
            Reporter.log("fail: "+failCount,true);
            Reporter.log("skip: "+skipCount,true);
            Utility.writeResultToXL("./result/summary.xlsx",passCount,failCount,skipCount);
	}

	@Override
	public void onTestStart(ITestResult result) {
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

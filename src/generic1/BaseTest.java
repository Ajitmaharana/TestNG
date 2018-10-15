package generic1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@Listeners(Result.class)
public abstract class BaseTest implements IAutoConst {
	public WebDriver driver;
	public String url=Utility.getPropertyValue(CONFIG_PATH,"URL");
	public String ITO=Utility.getPropertyValue(CONFIG_PATH,"ITO");
	public long lngITO=Long.parseLong(ITO);
	
	public String ETO=Utility.getPropertyValue(CONFIG_PATH,"ETO");
	public long lngETO=Long.parseLong(ETO);
	
	static{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional("localhost")String ip,@Optional("chrome")String browser){
		driver=Utility.openBrowser(ip, browser);
		driver.manage().timeouts().implicitlyWait(lngITO,TimeUnit.SECONDS);
		driver.get(url);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult result){
		String name=result.getName();
		if(result.getStatus()==2){
		
			Utility.getPhoto(driver,PHOTO_PATH);
			Reporter.log("Test:"+name+" is Fail",true);
		}
		else{
			Reporter.log("Test:"+name+" is Pass",true);
		}
		driver.quit();
	}
}











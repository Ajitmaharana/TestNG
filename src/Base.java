import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class Base implements IAuto{
	static{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	public WebDriver driver;
	public String URL=Practice.getPropertyFile(CONFIG_PATH, "URL");
	public String ITO=Practice.getPropertyFile(CONFIG_PATH, "ITO");
	public long l=Long.parseLong(ITO);
	
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional("localhost")String ip,@Optional("chrome")String browser){
		driver=Practice.openBrowser(ip, browser);
		driver.manage().timeouts().implicitlyWait(l,TimeUnit.SECONDS);
		driver.get(URL);
		
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult result){
		String name = result.getName();
		if(result.getStatus()==2){
			Practice.getPhoto(driver,PHOTO_PATH);
			Reporter.log("Test:"+name+"is fail",true);
		}
		else{
			Reporter.log("Test:"+name+"is Pass",true);
		}
	}
	

}

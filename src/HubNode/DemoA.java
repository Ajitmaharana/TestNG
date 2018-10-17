package HubNode;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DemoA {
	@Test
	public static void testGrid() throws Exception{
		URL remoteAddress=new URL("http://localhost:4444/wd/hub");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setBrowserName("firefox");
		WebDriver driver=new RemoteWebDriver(remoteAddress,capabilities);
		driver.get("https://google.com");
		driver.close();
	}
	

}

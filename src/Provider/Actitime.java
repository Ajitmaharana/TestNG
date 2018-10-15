package Provider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Actitime {
	static
	{
		   System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
    }
         @Test
         public void testLogin1() throws InterruptedException{
         WebDriver driver =new ChromeDriver();
         driver.get("http://demo.actitime.com/login.do");
         Thread.sleep(2000);
         String aTitle=driver.getTitle();
         String eTitle="actiTIME - Login";
         SoftAssert s=new SoftAssert();
         s.assertEquals(aTitle, eTitle);
         driver.close();
         s.assertAll();
         }
         
         @Test
         public void testLogin2() throws InterruptedException{
         WebDriver driver =new ChromeDriver();
         driver.get("http://demo.actitime.com/login.do");
         Thread.sleep(2000);
         String aTitle=driver.getTitle();
         Assert.assertEquals(aTitle, "actiTIME - Login");
         driver.close();
         }
}

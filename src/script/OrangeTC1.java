package script;

import org.testng.annotations.Test;
import generic1.BaseTest;
import generic1.Utility;
import generic1.WebGeneric;
import page.DashboardPage;
import page.LoginPage;

public class OrangeTC1 extends BaseTest{
	@Test(priority=1,groups={"smoke"})
	public void testA(){
		
		//Take the input data from excel file
		String un=Utility.getXLData(DATA_PATH,"OrangeTC1",1,0);
		String pwd=Utility.getXLData(DATA_PATH,"OrangeTC1",1,1);
		
		String homePageURL=Utility.getXLData(DATA_PATH,"OrangeTC1",1,2);
		String loginPageURL=Utility.getXLData(DATA_PATH,"OrangeTC1",1,3);
		//Enetr valid user name,password click login
		LoginPage login=new LoginPage(driver);
        login.setUserName(un);
        login.setPassWord(pwd);
        login.clickLogin();
        //verify that Dashboard Page is Displayed
        
        WebGeneric.verifyURL(driver,lngETO,homePageURL);
        
        //Click welcome-> logout
        DashboardPage d=new DashboardPage(driver);
        d.clickWelcome();
        d.clickLogout(lngETO);
        //verify that Login page is displayed
        WebGeneric.verifyURL(driver,lngETO,loginPageURL);
	}
}

package Groups;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoA {
       @BeforeClass(alwaysRun=true)
       public void login(){Reporter.log("login",true);}
       
       @Test(priority=1,groups={"user","smoke"})
       public void CreateUser(){Reporter.log("CreateUser",true);}
       
       @Test(priority=2,groups={"user"},enabled=false)
       public void EditUser(){Reporter.log("EditUser",true);}
       
       @Test(priority=3,groups={"user"})
       public void DeleteUser(){Reporter.log("DeleteUser",true);}
       
       @Test(priority=4,groups={"product","smoke"})
       public void CreateProduct(){Reporter.log("CreateProduct",true);}
       
       @Test(priority=5,groups={"product"})
       public void DeleteProduct(){Reporter.log("DeleteProduct",true);}
}

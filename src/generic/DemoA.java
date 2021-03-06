package generic;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Result.class)
public class DemoA {
	
	@Test
	public void createCustomer(){
		Reporter.log("Create a Customer",true);
		Assert.fail();
	}
	
	@Test
	public void deleteCustomer(){
		Reporter.log("Delete a Customer",true);
	}
	
	@Test(dependsOnMethods="createCustomer")
	public void editCustomer(){
		Reporter.log("Edit a Customer",true);
	}

}

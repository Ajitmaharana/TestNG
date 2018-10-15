package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	@FindBy(id="txtUsername")
    private WebElement unTB;
    
    @FindBy(id="txtPassword")
    private WebElement pwdTB;
    
    @FindBy(id="btnLogin")
    private WebElement logIN;
    
    public LoginPage(WebDriver driver){
   	 PageFactory.initElements(driver, this);
    }
    
    public void setUserName(String un){
   	 unTB.sendKeys(un);
    }
    
    public void setPassWord(String pw){
   	 pwdTB.sendKeys(pw);
    }
    
    public void clickLogin(){
   	 logIN.click();
    }

}

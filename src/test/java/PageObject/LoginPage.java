package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='loginFrm_loginname']")
	WebElement loginname;
	
	@FindBy(xpath = "//input[@id='loginFrm_password']")
	WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement login;
	
	@FindBy(xpath = "//div[@class='menu_text']")
	WebElement weltxt;
	
	public void loginname(String s) {
		loginname.sendKeys(s);
	}
	
	public void password(String a) {
		password.sendKeys(a);
	}
	
	public void submit() {
		 login.click();
	}
	
	public String validatemsg() {
		String s=weltxt.getText();
		return s;
	}
	
	

}

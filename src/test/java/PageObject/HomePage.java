package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(xpath = "//a[normalize-space()='Login or register']")
	WebElement logorreg;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement regbutton;
	
	
	public void clickloginorregister() {
		logorreg.click();
	}
	
	public void clickonregister() {
		regbutton.click();
	}

}

package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountRegistrationPage  extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath = "//input[@id='AccountFrm_firstname']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='AccountFrm_lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='AccountFrm_email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='AccountFrm_address_1']")
	WebElement address;
	
	@FindBy(xpath = "//input[@id='AccountFrm_city']")
	WebElement city;
	
	@FindBy(xpath = "//select[@id='AccountFrm_zone_id']")
	WebElement statedropdown;
	
	@FindBy(xpath = "//input[@id='AccountFrm_postcode']")
	WebElement zipcode;
	
	@FindBy(xpath = "//select[@id='AccountFrm_country_id']")
	WebElement countrydropdown;
	
	@FindBy(xpath = "//input[@id='AccountFrm_loginname']")
	WebElement loginname;
	
	@FindBy(xpath = "//input[@id='AccountFrm_password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='AccountFrm_confirm']")
	WebElement confirmpas;
	
	@FindBy(xpath = "//input[@id='AccountFrm_newsletter0']")
	WebElement radiosub;
	
	@FindBy(xpath = "//input[@id='AccountFrm_agree']")
	WebElement checkpol;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement cont;
	
	@FindBy(xpath = "//span[@class='maintext']")
	WebElement confirmmsg;
	
	
	
	
	public void firstname(String a) {
		firstname.sendKeys(a);
	}
	
	public void lastname(String b ) {
		lastname.sendKeys(b);
	}

	public void email(String c) {
		email.sendKeys(c);
		
	}
	
	public void address(String d) {
		address.sendKeys(d);
	}
	
	public void city(String e) {
		city.sendKeys(e);
	}
	
	public void state(String f) {
		Select s= new Select(statedropdown);
		s.selectByContainsVisibleText(f);
		
	}
	
	public void country (String co) {
		Select s= new Select(countrydropdown);
		s.selectByContainsVisibleText(co);
	}
	
	public void zipcode(String zip) {
		zipcode.sendKeys(zip);
		
	}
	
	public void loginname(String g) {
		loginname.sendKeys(g);
	}
	
	public void password(String s) {
		password.sendKeys(s);
	}
	
	public void confirmpassowrd(String cpas) {
		confirmpas.sendKeys(cpas);
	}
	
	public void subscribe() {
		radiosub.click();
		
	}
	
	public void accpetcondition() {
		checkpol.click();
	}
	
	public void submit() {
		cont.click();
	}
	
	public String validatemsg() {
		try {
			return(confirmmsg.getText());
		}
		catch(Exception e ) {
			return(e.getMessage());
		}
	}
}

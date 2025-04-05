package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import TestBase.BaseClass;

public class TC002_LoginTest  extends BaseClass{
	@Test
	public void validlogin() {
		HomePage hp = new HomePage(driver);
		hp.clickloginorregister();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.loginname(p.getProperty("username"));
		lp.password(p.getProperty("password"));
		lp.submit();
		
		//validating it 
		String s = lp.validatemsg();
		if(s.equals("Welcome back Admin")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("*********test case faild***********");
			Assert.assertTrue(false);
		}}
		
		
		
		
		
	

}

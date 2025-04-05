package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import TestBase.BaseClass;

public class TC002_LoginTest  extends BaseClass{
	@Test
	public void validlogin() {
		
		try {
			logger.info("***********Starting Login Test**************************");
		
		HomePage hp = new HomePage(driver);
		hp.clickloginorregister();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.loginname(p.getProperty("username"));
		lp.password(p.getProperty("password"));
		lp.submit();
		
		
		boolean ap=lp.validatemsg();
		if(ap==true) {
			System.out.println("Validation is completed");
		}
		
		//validating it 
		String s = lp.validatemsg1();
		if(s.equals("Welcome back Admin")) {
			Assert.assertTrue(true);
			logger.info("***********Login is verified ****************");
		}
		else {
			logger.error("*********test case faild***********");
			Assert.assertTrue(false);
		}}
		catch(Exception e) {
			logger.error("Test failed due to an exception: ", e);
			Assert.fail();
		}
		
		
		
		
		
	}

}

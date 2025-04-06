package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import TestBase.BaseClass;
import Utilities.DataProvider1;

public class TC003_LoginDataDrivenTest  extends  BaseClass{
	
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProvider1.class,groups = "datadriven")
	public void verify_LoginDDT(String username , String password,String exp) {
		
		logger.info("**********Starting the TC003_LOGINDDT TEST ***************");
		try {
		//home page and click on login 
		HomePage hp = new HomePage(driver);
		hp.clickloginorregister();
		
		//Login 
		LoginPage lp= new LoginPage(driver);
		lp.loginname(username);
		lp.password(password);
		lp.submit();
		
		boolean target=lp.validatemsg();
		System.out.println(target);
		
		
		
		if(exp.equalsIgnoreCase("valid")) {
		    if(target) { 
		    	hp.logout(); 
		        Assert.assertTrue(true, "Login successful as expected.");
		        
		    } else {
		        Assert.fail("Login failed despite valid credentials.");
		    }
		} else if(exp.equalsIgnoreCase("invalid")) {
		    if(!target) {
		        Assert.assertTrue(true, "Login failed as expected.");
		    } else {
		        Assert.fail("Login succeeded despite invalid credentials.");
		    }}}
		 catch (Exception e) {
            logger.error("An error occurred during the test execution: ", e);
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }

		
		logger.info("FINISHED DDT TEST ********************");
	}
	 
	


}

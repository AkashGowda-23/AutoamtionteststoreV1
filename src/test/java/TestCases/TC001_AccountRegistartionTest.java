package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AccountRegistrationPage;
import PageObject.HomePage;
import TestBase.BaseClass;

public class TC001_AccountRegistartionTest  extends BaseClass{
	@Test
	public void verify_Account_registration() {
		
		try {
		
		logger.info("*************Staring the page*********");
		
		HomePage hp = new HomePage(driver);
		hp.clickloginorregister();
		hp.clickonregister();
		logger.info("************clicked on info*********************");
		
		
		AccountRegistrationPage ar = new AccountRegistrationPage(driver);
		ar.firstname(randomStringGen().toUpperCase());
		ar.lastname(randomStringGen().toUpperCase());
		ar.email(randomStringGen()+"@gmail.com");
		ar.address("bang");
		ar.city("Banglore");
		ar.country("India");
		ar.state("Karnataka");
		ar.zipcode("560100");
		ar.loginname(randomStringGen().toUpperCase());
		
		
		ar.password("Lizzie@123");
		ar.confirmpassowrd("Lizzie@123");
		ar.subscribe();
		ar.accpetcondition();
		ar.submit();
		String s =ar.validatemsg();
		System.out.println(s);
		
		if(s.equals("YOUR ACCOUNT HAS BEEN CREATED!"))
		{
			Assert.assertTrue(true);
		}
		else {
			logger.error("***************Test case failed**********************");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
			 
		}
		
	
		
		
	}
	
	catch(Exception e) {
		Assert.fail();
		
	}
		logger.info("**********sucessfully registered ******************");

	}
}

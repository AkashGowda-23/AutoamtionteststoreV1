package TestBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseClass {
	
	 public static WebDriver driver;
	 public Logger logger;
	 public Properties p;
	 
	 
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os,String bw) throws IOException {
		
		//for Log4j2 
		
		logger=LogManager.getLogger(this.getClass());
		
		
		//Loading config.properties class
		FileReader f= new FileReader("C:\\Users\\akash\\Desktop\\SDET\\Workspace\\AutomationTestStoreV1\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(f);
		
		
		
		switch(bw.toLowerCase())
		{
		
		case "chrome" : driver = new ChromeDriver();   break;// it will iniatlise a chrome browser 
		case "edge"   : driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default       : System.out.println("INVALID BROWSER");
		return;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //implict wait 
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();	//it will maxmize the window 
	}
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	

	public String randomStringGen() {
		String rannum=RandomStringUtils.randomAlphabetic(5);
		return rannum;
		
	}
	
	public String randomnumber() {
		String num=RandomStringUtils.randomNumeric(10);
		return num;
			
	}
	
	public String randomalphanum() {
		String pass1=RandomStringUtils.randomAlphabetic(3);
		String pass2=RandomStringUtils.randomNumeric(4);
		return (pass1+pass2);
	}

}

package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils; // Used for screenshot handling
import org.apache.commons.lang3.RandomStringUtils; // Random data generation
import org.apache.logging.log4j.LogManager; // Log4j
import org.apache.logging.log4j.Logger; // Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver; // Driver instance
    public Logger logger; // Log4j instance
    public Properties p; // Properties for configuration file

    @BeforeClass(groups = {"Regression", "Sanity", "Master"})
    @Parameters({"os", "browser"})
    public void setup(String os, String br) throws IOException {

        // Loading the configuration properties file
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        // Initialize Log4j Logger
        logger = LogManager.getLogger(this.getClass());

        // Execution Environment Check
        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            // Remote Execution Setup
            DesiredCapabilities capabilities = new DesiredCapabilities();

            // Platform Setup
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("linux")) {
                capabilities.setPlatform(Platform.LINUX);
            } else {
                System.out.println("Invalid OS");
                return;
            }

            // Browser Setup
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("edge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("Invalid Browser");
                    return;
            }

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        } else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            // Local Execution Setup
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid Browser");
                    return;
            }
        } else {
            System.out.println("Invalid Execution Environment");
            return;
        }

        // Common WebDriver Configuration
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL")); // Read URL from properties file
        driver.manage().window().maximize(); // Maximize browser window
    }

    @AfterClass(groups = {"Regression", "Sanity", "Master"})
    public void tearDown() {
        driver.quit(); // Quit WebDriver instance
    }

    // Random Data Generation Methods
    public String random() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumbers() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String alphaNumeric() {
        return RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3);
    }

    // Screenshot Capture Method
    public String captureScreen(String testName) throws IOException {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timestamp + ".png";
        File targetFile = new File(targetFilePath);

        FileUtils.copyFile(sourceFile, targetFile); // Use FileUtils for copying the screenshot
        return targetFilePath;
    }
}
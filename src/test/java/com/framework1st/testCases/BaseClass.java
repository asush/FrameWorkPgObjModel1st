package com.framework1st.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.framework1st.utilities.ComPropReadConfig;

public class BaseClass {

	ComPropReadConfig config = new ComPropReadConfig();

	public String baseURL = config.getBaseURL();
	public String userName = config.getUserName();
	public String password = config.getPassword();
	public static WebDriver driver;
	// public static final Logger log = LoggerFactory.getLogger(BaseClass.class);
	// //(vinod- logback-classic)
	public static Logger log;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		log = Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("Log4j.properties");

		if(br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", config.getIEDriverPath());
			driver = new InternetExplorerDriver();
//		}else if(br.equalsIgnoreCase("firefox")){
//			System.setProperty("webdriver.gecko.driver", config.getFireFoxDriverPath());
//			driver = new FirefoxDriver();
		}else if(br.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", config.getChromeDriverPath());
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\Screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		log.info("Screenshot taken for failed test cases");
	}
	
	public String randomString() {
		String randomData = RandomStringUtils.randomAlphabetic(8);
		return randomData;
	}

	public String randomNumber() {
		String randomData = RandomStringUtils.randomNumeric(4);
		return randomData;
	}
}

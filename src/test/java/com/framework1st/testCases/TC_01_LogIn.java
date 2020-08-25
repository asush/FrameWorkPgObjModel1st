package com.framework1st.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework1st.pageObjects.LoginPage;

public class TC_01_LogIn extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		
//		log.info("URL opened");
		
		LoginPage lp = new LoginPage(driver);	
		
//		 WebDriverWait wait = new WebDriverWait(driver, 120);
//         wait.until(ExpectedConditions.titleContains("Twitter"));
		lp.setUserName(userName);
		log.info("Enter UserName");
		
		lp.setPassword(password);
		log.info("Enter Password");
		
		lp.clickSubmit();
		log.info("Submit Login");
//		String title = driver.getTitle();
		
		if(driver.getTitle().trim().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			log.info("Test case passed");
		}else {
			captureScreen(driver, "TC_01_LogIn");
			Assert.assertTrue(false);
			
		}
	}
	
	
	
}

package com.framework1st.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework1st.pageObjects.LoginPage;
import com.framework1st.utilities.XLUtils;

public class TC_02_LogInDDT extends BaseClass{

	@Test (dataProvider="LoginData")
	public void loginTestDDT(String uid,String pwd) throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uid);
		log.info("Enter UserName");
		lp.setPassword(pwd);
		lp.clickSubmit();
		log.info("Enter Password");
		
		if(isAlertPresent() == true) {
			driver.switchTo().alert().accept(); //to close the alert
			driver.switchTo().defaultContent();
			captureScreen(driver, "TC_02_LogInDDT");
			log.warn("Login Failed");
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
			log.info("Login passed");
			lp.clickLogOut();
			driver.switchTo().alert().accept(); //closing logout alert
			driver.switchTo().defaultContent();
			log.info("Logout alert handled");
		}
	}
	
	public boolean isAlertPresent() { //user defined method to check alert present ot not. Can be put n base class also in case
		try {						  //want to handle alert for different pages.
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String xlPath = "D:\\Workspaces\\KickUP\\FRAMEWORK1st\\src\\test\\java\\com\\framework1st\\testData\\LoginData.xlsx";
		int rowNum = XLUtils.getRowCount(xlPath, "Sheet1");
		int colCount = XLUtils.getCellCount(xlPath, "Sheet1", 1); 
		
		String logindata[][] = new String[rowNum][colCount];
		
		for(int i = 1; i <= rowNum; i++) {
			for(int j = 0; j < colCount; j++) {
				
				logindata[i-1][j] = XLUtils.getCellData(xlPath,"Sheet1", i, j);
				
			}
		}
		return logindata; 
	}
	
	
}

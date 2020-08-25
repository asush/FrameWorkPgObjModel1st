package com.framework1st.testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.framework1st.pageObjects.AddCustomerPage;
import com.framework1st.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_03_AddCustomer extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);

		lp.setUserName(userName);
		log.info("Enter UserName");
		lp.setPassword(password);
		log.info("Enter Password");
		lp.clickSubmit();
		log.info("Submit Login");

		AddCustomerPage addcust = new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();
		log.info("Providing Customer details");
		addcust.custName("Sushm");
		addcust.custgender("F");
		addcust.custdob("05", "10", "1977");
		Thread.sleep(3000);
		addcust.custaddress("Santoshpur");
		addcust.custcity("Kolkata");
		addcust.custstate("WB");
		addcust.custpinno("700075");
		addcust.custtelephoneno("8336123456");
		addcust.custemailid(randomString() + "@gmail.com");
		addcust.custpwd("123456");
		addcust.custsubmit();

		Thread.sleep(3000);

		log.info("Validation Started...");
		boolean op = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (op == true) {
			Assert.assertTrue(true);
			log.info("Add Cutomaer testcase PASSED");
		} else {
			captureScreen(driver, "addNewCustomer");
			log.info("Add Customer testcase FAILED");
			Assert.assertTrue(false);
		}
	}

}

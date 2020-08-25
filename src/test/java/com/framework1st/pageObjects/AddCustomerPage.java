package com.framework1st.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using="//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using="rad1")
	WebElement rdGender;
	
	@FindBy(how = How.NAME, using="dob")
	WebElement txtDob;
	
	@FindBy(how = How.NAME, using="addr")
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using="city")
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using="state")
	WebElement txtState;
	
	@FindBy(how = How.NAME, using="pinno")
	WebElement txtPinno;
	
	@FindBy(how = How.NAME, using="telephoneno")
	WebElement txtTeleph;
	
	@FindBy(how = How.NAME, using="emailid")
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using="password")
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using="sub")
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custgender (String cgender) {
		rdGender.click();
	}
	
	public void custdob(String mm, String dd, String yy) {
		txtDob.sendKeys(mm);
		txtDob.sendKeys(dd);
		txtDob.sendKeys(yy);
	}
	
	public void custaddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	
	public void custstate(String cstate) {
		txtState.sendKeys(cstate);
	}
	
//For info - .sendKeys takes Strign value always--	
//	public void custpinno(int cpinno) {
//		txtPinno.sendKeys(String.valueOf(cpinno)); 
//	}
	
	public void custpinno(String cpinno) {
		txtPinno.sendKeys(cpinno); 
	}
	
	public void custtelephoneno(String ctelephno) {
		txtTeleph.sendKeys(ctelephno);
	}
	
	public void custemailid(String cemailid) {
		txtEmail.sendKeys(cemailid);
	}
	
	public void custpwd(String cpwd) {
		txtPassword.sendKeys(cpwd);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}

}

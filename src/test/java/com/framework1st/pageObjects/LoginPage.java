package com.framework1st.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	//Constructor creation
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this); //refer PgObjMdl in Java Excel for details
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using="//a[text()='Log out']")
	WebElement lnkLogout;
//	By logoutLnk = By.xpath("//a[text()='Log out']");
	
	public void setUserName(String uName) {
		txtUserName.clear();
		txtUserName.sendKeys(uName);
	}
	
	public void setPassword(String pswd) {
		pwd.clear();
		pwd.sendKeys(pswd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickLogOut() {
//		this.ldriver.findElement(logoutLnk).click();
		lnkLogout.click();
	}
}

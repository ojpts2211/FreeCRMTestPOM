package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
     //Page FActory--OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginBtn;
	
	@FindBy(xpath="button[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Objects
	public  LoginPage() {
		PageFactory.initElements(driver, this); 
		///this=It stands for current object class
		//in a LoginPage PageFactory it will initialise it 
		}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		//String Aaba=prop.getProperty("username");
		//String Babu=prop.getProperty("password");
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		return new HomePage();
	}
	
	
	
	
}

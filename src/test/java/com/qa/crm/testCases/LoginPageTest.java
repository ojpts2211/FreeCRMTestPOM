package com.qa.crm.testCases;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
     LoginPage loginPage;
     HomePage homePage;
     //WebDriver driver;
     
     public LoginPageTest() {
    	 super();
    	 //Why used Super() Constructor??-->>Because of that property initialization one by one thats y..
    	 
     }
	@BeforeMethod
	public void Setup(){
		  TestBase base = new TestBase();
		  base.initialization();
		loginPage=new LoginPage();
		
	}
	
	@Test
	public void loginPageTitleTest(){
	 String title=loginPage.validateLoginPageTitle();
	 Assert.assertEquals(title,"Free CRM - CRM software for customer relationship management, sales, and support.");
	 System.out.println(title);
	}

	/*
	@Test()
	 public void CRMLogoImageTest() {
    	boolean flag= loginPage.validateCRMImage();
    	 Assert.assertTrue(flag);
     }
	*/
	@Test(priority =1)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}

package com.qa.crm.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage taskPage;
	TestUtil testUtil;
	public HomePageTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		TestBase base=new TestBase();
		base.initialization();
		TestUtil testUtil;
		loginPage=new LoginPage();
		taskPage=new TasksPage();
		dealsPage=new DealsPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		
		String homeTitle=homePage.verifyHomePageTitle();
		System.out.println(homeTitle);
		Assert.assertEquals(homeTitle, "CRMPRO", "Home Page Title not matched");
	}
	
	@Test(priority = 2)
	public void verifyCorrectUserNameTest() {
		testUtil=new TestUtil();
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void clickOnContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void clickOnDealsLinkTest() {
		testUtil.switchToFrame();
		dealsPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority=5)
	public void clickOnTasksLinkTest() {
		testUtil.switchToFrame();
		taskPage=homePage.clickOnTasksLink();
	}
	
	@Test(priority=5)
	public void clickOnNewContactsLinkTest() {
		testUtil.switchToFrame();
		homePage.clickOnNewContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

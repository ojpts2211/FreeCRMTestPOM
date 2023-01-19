package com.qa.crm.testCases;

import java.lang.annotation.Annotation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtil testUtil;
    String sheetName="Contacts";
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil=new TestUtil();
		TestBase base=new TestBase();
		loginPage=new LoginPage();
		homePage=new HomePage();
		contactsPage=new ContactsPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginPage.validateLoginPageTitle();
		testUtil.switchToFrame();
	    contactsPage= homePage.clickOnContactsLink();
	}
	
	@Test
	public void verifyContactsLabelTest() {
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact Name label is missing on the page");
				
	}
	
	@Test(priority = 2)
	public void SelectContactTest() {
		
		contactsPage.selectContactsByName("Amit Kare");
		contactsPage.selectContactsByName("Abhijit Deshmukh");

	}
	
	@DataProvider
	public Object[][] getTestData() {
	Object data[][]=testUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=3, dataProvider = "getTestData")
	public void validateCreateNewContacts(String title, String firstName, String surName,String companyName) {
		homePage.clickOnNewContactsLink();
		//contactsPage.createNewContact("Mr.", "Chaitanya", "Anpat", "Infosys");
		contactsPage.createNewContact(title, firstName, surName, companyName);
	
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}

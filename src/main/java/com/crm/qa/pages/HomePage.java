package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	//Object Repository:
	
	@FindBy(xpath="//td[contains(text(),'User: Omkar Jagdale')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement CrmLogo;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	 
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername() {
		return userNameLabel.isDisplayed();
	}
	
    public ContactsPage clickOnContactsLink() {
    	Actions action=new Actions(driver);
    	action.moveToElement(contactsLink).build().perform();
		contactsLink.click();
		return new ContactsPage();
	}
	
    public DealsPage clickOnDealsLink() {
    	Actions action=new Actions(driver);
    	action.moveToElement(dealsLink).build().perform();
		dealsLink.click();
		return new DealsPage();
	}
    
    public TasksPage clickOnTasksLink() {
    	Actions action=new Actions(driver);
    	action.moveToElement(tasksLink).build().perform();
		tasksLink.click();
		return new TasksPage();
	}

    public void clickOnNewContactsLink() {
    	Actions action=new Actions(driver);
    	action.moveToElement(contactsLink).build().perform();
    	newContact.click();
    }

	
	
	
	
	

}

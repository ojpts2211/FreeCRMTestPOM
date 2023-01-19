package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//Object Repository
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//input[@value='New Contact']")
	WebElement newContact;
	
	@FindBy(name="title")
	WebElement Title;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="middle_initial")
	WebElement middleName;
	
	@FindBy(name="surname")
	 WebElement surName;
	
	@FindBy(name="suffix")
	WebElement suffix;
	
	
	@FindBy(name="nickname")
	WebElement nickName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//input[@value='Save and Create Another (same company)']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String titleName, String ftname, String ltname, String comp) {
    	Select select=new Select(driver.findElement(By.name("title")));
    	select.selectByVisibleText(titleName);
    	
    	Title.sendKeys(titleName);
    	firstName.sendKeys(ftname);
    	surName.sendKeys(ltname);
    	companyName.sendKeys(comp);
    	saveBtn.click();
    	
    	
    }

}

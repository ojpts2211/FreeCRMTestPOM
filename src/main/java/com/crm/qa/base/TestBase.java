package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;




public class TestBase {
	public static WebDriver driver;
    public static Properties prop;
	public TestBase(){
		try {
			prop=new Properties();
			FileInputStream file=new FileInputStream("C:\\Users\\OJPTS\\eclipse-workspace\\FreeCRMTestPOM\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
		 e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("GeckoDriver")) {
			System.setProperty("WebDriver.Gecko.Driver", "C:\\Users\\OJPTS\\eclipse-workspace\\FreeCRMTestPOM\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("chrome")){
			System.setProperty("WebDriver.chrome.Driver", "C:\\Users\\OJPTS\\eclipse-workspace\\FreeCRMTestPOM\\chromedriver.exe");
			driver=new ChromeDriver();}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
			
		}
	}








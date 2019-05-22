package com.actitime.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.objectrepositorylib.Home;
import com.actitime.objectrepositorylib.Login;
/**
 * 
 * @author Ashutosh
 *
 */
public class BaseClass {
	public static WebDriver driver;
	public FileLib flib = new FileLib();

	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("Connect to DB");
	}

	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("=====launch Browser=====");
		String BROWSER = flib.getPropertyKeyValue("browser");
		if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void configBeforeMethod() throws Throwable {
		System.out.println("login");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(flib.getPropertyKeyValue("url"));
		Login lp = PageFactory.initElements(driver, Login.class);
		lp.loginToApp();
	}
	@AfterMethod
	public void configAfterMethod() throws Throwable {
		System.out.println("logout");
		Home hp=PageFactory.initElements(driver, Home.class);
		hp.logout();
	}
	@AfterClass
	public void conficAfterClass() {
		System.out.println("=====Close Browser=====");
		
	}
}

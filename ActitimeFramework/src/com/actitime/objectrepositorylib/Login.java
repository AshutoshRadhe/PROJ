package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.actitime.genericlib.FileLib;



/**
 * 
 * @author Ashutosh
 *
 */

public class Login {
	@FindBy(name = "username")
	private WebElement usernameEdt;
	@FindBy(name = "pwd")
	private WebElement passwordEdt;
	@FindBy(id="loginButton")
	private WebElement loginbtn;

	public void loginToApp() throws Throwable {
		FileLib flib = new FileLib();
		usernameEdt.sendKeys(flib.getPropertyKeyValue("username"));
		passwordEdt.sendKeys(flib.getPropertyKeyValue("password"));
		loginbtn.click();

	}

	public void LoginToApp(String username, String password) throws InterruptedException {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbtn.click();
	}

	public WebElement getusernameEdt() {
		return usernameEdt;

	}

	public WebElement getpasswordEdt() {
		return passwordEdt;

	}

	public WebElement getloginButton() {
		return loginbtn;

	}

}

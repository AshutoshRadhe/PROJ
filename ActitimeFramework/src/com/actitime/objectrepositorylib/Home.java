package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 
 * @author Ashutosh
 *
 */

public class Home {
	@FindBy(xpath="//div[text()='TASKS']/..")
	private WebElement taskImg;
	@FindBy(id="logoutLink")//(xpath= "//a[text()='Logout' and @class='logout' and @id='logoutLink']")
	private WebElement logoutlnk;
	
	public void clickOnTaskImage() {
		taskImg.click();
		}
    public void logout() throws Throwable {
    	logoutlnk.click();
    	Thread.sleep(2000);
    }
}

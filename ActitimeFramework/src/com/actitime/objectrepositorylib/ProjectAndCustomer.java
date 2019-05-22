package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 
 * @author Ashutosh
 *
 */

public class ProjectAndCustomer {
	@FindBy(xpath="//span[text()='Create Customer']")
	private WebElement createCustomerBtn;
	@FindBy(xpath="//span[@class='successmsg']")
	private WebElement successmsg;
	
	public void clickOnCreateCustomerBtn() {
		createCustomerBtn.click();

	}
	public WebElement getSuccessMsg() {
		return successmsg;
	}

}

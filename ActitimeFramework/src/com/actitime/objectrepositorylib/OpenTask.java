package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 
 * @author Ashutosh
 *
 */

public class OpenTask {
	@FindBy(linkText="Projects & Customers")
	private WebElement projectAndCustomerLink;
	
	public void clickOnProjectAndCustomerLink() {
		projectAndCustomerLink.click();
		
	}

}

package com.actitime.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * 
 * @author Ashutosh
 *
 */

public class CreateCustomer {
	@FindBy(id="customerLightBox_nameField")
	private WebElement customerNameEdt;
	@FindBy(id="customerLightBox_descriptionField")
	private WebElement customerDescriptionEdt;
	@FindBy(xpath="//span[@class='buttonTitle' and text()='Create Customer']")
	private WebElement createCustomerBtn;
	
	public void createCustomer(String customerName ) {
		customerNameEdt.sendKeys(customerName);
		createCustomerBtn.click();
		
	}
	public void createCustomer(String customerNames,String customerDescription ) {
		customerNameEdt.sendKeys(customerNames);
		customerDescriptionEdt.sendKeys(customerDescription);
		createCustomerBtn.click();
		
	}
}




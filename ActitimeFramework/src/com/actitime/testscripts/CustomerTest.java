package com.actitime.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.genericlib.BaseClass;
import com.actitime.objectrepositorylib.CreateCustomer;
import com.actitime.objectrepositorylib.Home;
import com.actitime.objectrepositorylib.OpenTask;
import com.actitime.objectrepositorylib.ProjectAndCustomer;

/**
 * 
 * @author Ashutosh
 *
 */
@Listeners(com.actitime.genericlib.ListImpClass.class)
public class CustomerTest extends BaseClass {

	@Test
	public void createCustomerTest() throws Throwable {
		String customerName = flib.getExcelData("sheet1", 2, 2);
		
		Home hp = PageFactory.initElements(driver, Home.class);
		hp.clickOnTaskImage();
	
		OpenTask op = PageFactory.initElements(driver, OpenTask.class);
		op.clickOnProjectAndCustomerLink();
		
		ProjectAndCustomer pc = PageFactory.initElements(driver, ProjectAndCustomer.class);
		pc.clickOnCreateCustomerBtn();
		
		CreateCustomer cp = PageFactory.initElements(driver, CreateCustomer.class);
		cp.createCustomer(customerName);
		
		String actSuccessMsg = pc.getSuccessMsg().getText();
	    boolean status = actSuccessMsg.contains("successfully created");
		Assert.assertTrue(status);
		Thread.sleep(2000);
	}
	
	@Test
	public void createCustomerWithDescriptionTest() throws Throwable {
		String customerName = flib.getExcelData("sheet1", 6, 2);
		String customerDescription = flib.getExcelData("sheet1", 6, 3);
		Thread.sleep(2000);
		
		Home hp = PageFactory.initElements(driver, Home.class);
		hp.clickOnTaskImage();
		
		OpenTask op = PageFactory.initElements(driver, OpenTask.class);
		op.clickOnProjectAndCustomerLink();
		
		ProjectAndCustomer pc = PageFactory.initElements(driver, ProjectAndCustomer.class);
		pc.clickOnCreateCustomerBtn();
	
		CreateCustomer cp = PageFactory.initElements(driver, CreateCustomer.class);
		cp.createCustomer(customerName, customerDescription );
		
		String actSuccessMsg = pc.getSuccessMsg().getText();
		boolean status = actSuccessMsg.contains("successfully created");
		Assert.assertTrue(status);
		
		
	}

}

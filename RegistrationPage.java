package com.qa.measurabl;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPage extends BaseTest{
	
	@DataProvider
	public Object[][] RegistrationTestData() {
		return new Object[][]  {
			{"shawonfaruk@gmail.com", "Measurabl521151@", "Measurabl521151", "Omar", "Faruk", "QA automation" },
			{"shawonfaruk@gmail.com", "....", ".@@", "Omar", "Faruk", "QA Automation"}
		};
	
	}	
	
	@Test(dataProvider= "RegistrationTestData")
	public void doRegistrationTest(String userEmail, String userPassword, String firstName, String lastName, String companyName) {
		Assert.assertTrue(doRegistration(userEmail,userPassword,firstName, lastName, companyName));
		
	}

	
	
	

	public boolean doRegistration (String Email, String password, String firstName, String lastName, String companyName) {
		
		driver.findElement(By.id("user_email")).sendKeys("Email");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.id("user_password_confirmation")).sendKeys("password");
		driver.findElement(By.id("user_first_name")).sendKeys("firstName");
		driver.findElement(By.id("user_last_name")).sendKeys("lastName");
		driver.findElement(By.id("user_company")).sendKeys("companyName");
		driver.findElement(By.id("user_terms_and_conditions")).click();
		driver.findElement(By.cssSelector("#new_user > button")).click();
		
		String error = driver.findElement(By.cssSelector("#new_user > div.alert.alert-danger.margin-bottom--15 > ul > li"))
				.getText();
		if (error.contains("Email has already been taken")) {
			
			return true;
		}
		return false;

	
		
		
		
		
	}
		
}
	
	
	
	

	
		
		
	
	
	


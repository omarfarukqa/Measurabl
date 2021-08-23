package com.qa.measurabl;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginPage extends BaseTest {
	
	@DataProvider
	public Object[][] loginPageData() {
		return new Object[][]  {
			{"test@gmail.com", "test@123"},
			{" " , "test@123"},
			{" ", " "}
					};	
	}
		
	@Test(dataProvider= "loginPageData")
	public void loginTest(String userName, String password) {
		Assert.assertTrue(doLogin(userName, password));
	}

	public boolean doLogin(String un, String pwd) {
		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_password")).sendKeys(un);
	   
		
		
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("#new_user > div.display--flex.align-items--center.margin-bottom--0 > button")).click();
		String error = driver.
				findElement(By.cssSelector("#new_user > div.alert.alert-danger.margin-bottom--15 > ul > li"))
					.getText();
		if (error.contains("Invalid email or password.")) {
			return true;
		}
		return false;

	}
	
	
	

		
	}
			
		
	



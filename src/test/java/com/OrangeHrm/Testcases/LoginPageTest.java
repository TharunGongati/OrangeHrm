package com.OrangeHrm.Testcases;

import org.testng.annotations.Test; 
import org.testng.Assert;
import com.OrangeHrm.BaseTest.BaseTest;

public class LoginPageTest extends BaseTest {
  @Test (priority=1)
  public void ValidateUrl() {
	  String Url = lp.getCurrentUrl();
	  Assert.assertTrue(Url.contains("login"), " Url is invalid " );
	  System.out.println("Url is Valid ");
  }
  @Test(priority=2)
  
  public void ValidateTitle() {
	  String Title = lp.getAppTitle();
	Assert.assertTrue(Title.contains("OrangeHRM"), " Title  is invalid " );
	  System.out.println("Title is Valid ");
  }
  @Test(priority=3)
  
  public void ValidateLogin() {
	  lp.dologin("Admin","admin123");
	String Verification =  driver.getCurrentUrl();
	  Assert.assertTrue(Verification.contains("dashboard"), " Title  is invalid " );
	  System.out.println("Title is Valid ");
  }
  
  
}

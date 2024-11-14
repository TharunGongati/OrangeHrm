package com.OrangeHrm.Testcases;

import org.testng.annotations.Test; 
import org.testng.annotations.BeforeClass;


import com.OrangeHrm.BaseTest.BaseTest;

public class AdminPageTest extends BaseTest {
	
	
	@BeforeClass
	public void pageSetup() 
	{
		lp.dologin("Admin", "admin123");
	}
  @Test (priority=1)
  public void ValidateSize_and_ClickingOnAdmin() {
	  ap.Options();
  }
  
  @Test (priority=2)
  public void Validate_searchByUserName() {
	  ap.searchByUserName("Admin");
  }



@Test (priority=3)
public void Validate_searchByUserRole() {
	ap.searchByUserRole("Admin");
	
}
@Test (priority=4)
public void Validate_searchByUserStatus() {
	ap.searchByUserStatus("Enabled");
	
}



}
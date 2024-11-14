package com.OrangeHrm.BaseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.OrangeHrm.Pages.AdminPage;
import com.OrangeHrm.Pages.LoginPage;

public class BaseTest {
	public  WebDriver driver;
public 	LoginPage lp;
public AdminPage ap;
	
@BeforeTest	
	public void Setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://www.google.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		lp = new LoginPage(driver);
		ap = new AdminPage(driver);
	}

}

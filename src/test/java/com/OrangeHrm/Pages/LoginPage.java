package com.OrangeHrm.Pages;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;


public class LoginPage {
	 public WebDriver driver ;
	//constructor 
	public LoginPage(WebDriver driver ) {
		this.driver = driver;
	
	}
	
	//Locators

  private     By  Username = By.xpath("//input[@name='username']");
private      By Password = By.xpath("//input[@name='password']");
    private   By loginbtn =  By.xpath("//button[@type='submit']");
    


	//ActionMethods
	
	public String getAppTitle() {
		return driver.getTitle();
		
	}
	
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
		
	}
	
	public AdminPage dologin(String Un ,String Psw) {
		
		driver.findElement(Username).sendKeys(Un);
		driver.findElement(Password).sendKeys(Psw);
		driver.findElement(loginbtn).click();
		System.out.println("Login Success");
		return new AdminPage(driver);
	}
	
	
	
	}




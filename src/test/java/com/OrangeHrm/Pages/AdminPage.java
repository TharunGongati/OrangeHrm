package com.OrangeHrm.Pages;

import java.time.Duration;  
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {

	private WebDriver driver;

//constructor
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}
	//locators
	
	//optionsMenu
	private By menu = By.xpath("//ul[@class='oxd-main-menu']//li");
	//username
	private By UserName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	private By SearchBtn =By.xpath("//button[@type='submit']");
	private By record = By.xpath("(//div//span[@class='oxd-text oxd-text--span'])[1]");
	//Userrole
	private By UserRoleArrow = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
	
	private By DD = By.xpath("//div[contains(@role,'listbox')]");
	
	private By records = By.xpath("//div[contains(@class,'oxd-table-card')]//div[@role = 'row']");
	
	//searchByUserStatus
	
	private By Arrow2 = By.xpath("(//i[@class = 'oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");

	//actionMethods
	 //  Create testcase to get all 12 options from leftside menu and print the count which should be 12 from that list click on Admin then Admin page get open.
	 
public void Options(){
	
	List<WebElement> list = driver.findElements(menu);
	
	
	System.out.println("Login Test");
	System.out.println("Total Menu Options are : " + list.size());
	 for (WebElement option : list) {
	        String optionText = option.getText();  
	        System.out.println("Option found: " + optionText);  // Print each menu option
	        if (optionText.equals("Admin")) {  // Use equals to match exact text
	           
	            option.click();
	            break;  // Exit loop after clicking
	        }
	    }
	
	
}

 //2. Create test case for search For Existing Employee searchByUserName() : here send username Admin to username text box and click on search button and display total record found and refresh page.



public void searchByUserName(String name) 
{
	System.out.println("Search Employee By UserName");
	driver.findElement(UserName).sendKeys(name);
	
	driver.findElement(SearchBtn).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    try {
        
       wait.until(ExpectedConditions.visibilityOfElementLocated(record));
      WebElement totalRecord = driver.findElement(record);
        System.out.println("Total Records Found: " + totalRecord.getText());
    } catch (Exception e) {
        System.out.println("Failed to locate the total record element: " + e.getMessage());
    }
	driver.navigate().refresh();
}






//3. Create test case for search For Existing Employee searchByUserRole() : here automate dropdown and select Role Admin and click on search button and display total record found and refresh page.

public void searchByUserRole(String Role) {
	
	//userrole
	//arrow
	
	System.out.println("Search Employee By UserRole");
	driver.findElement((UserRoleArrow)).click();
	
	//dropdownOptions
	List<WebElement> UseroleDD= driver.findElements(DD);
	
	for(WebElement i : UseroleDD) {

		if(i.getText().contains(Role)) {
			i.click();
			break;	
		}
	}
	
	driver.findElement(SearchBtn).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    try {
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(record));
        WebElement totalRecord = driver.findElement(record);
        System.out.println("Total Records Found: " + totalRecord.getText());
    } catch (Exception e) {
        System.out.println("Failed to locate the total record element: " + e.getMessage());
    }
	driver.navigate().refresh();
}












//4. Create test case for search For Existing Employee searchByUserStatus() : here automate dropdown and select status Enabled or Disabled then click on search button and display total record found.

public void searchByUserStatus(String Status) {
	
	driver.findElement(Arrow2).click();
	
List<WebElement> UseroleDD= driver.findElements(DD);

	for(WebElement i : UseroleDD) {
		if(i.getText().contains(Status)) {
			i.click();
			break;	
		}
	}
	
	driver.findElement(SearchBtn).click();
	
	System.out.println("Search Employee BY UserStatus ");
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 try {
	        
	         wait.until(ExpectedConditions.visibilityOfElementLocated(records));
	         WebElement totalRecord = driver.findElement(record);
	      
	        System.out.println("Total Records Found : "+totalRecord.getText());
	        
	    } catch (Exception e) {
	        System.out.println("Failed to locate the total record element: " + e.getMessage());
	    }
		driver.navigate().refresh();
	
	
	
	
}
































}

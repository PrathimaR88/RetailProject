package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;

public class AdminLoginPOM {
	//RTTC_011 - To verify whether application allows user to get logged in by entering valid credentials in required field

private WebDriver driver; 
	
	public AdminLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	private WebElement heading;
	
	//Enter the value in Username field
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	//Enter the value in Password Field
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	//Click action performed on the sig-in button
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	//Validation of the the page title
	public void validateTitle()
	{
		String titleDisplayed = this.heading.getText();
		assertEquals(titleDisplayed, "Dashboard");
		System.out.println("Value is asserted");
			}
	
}

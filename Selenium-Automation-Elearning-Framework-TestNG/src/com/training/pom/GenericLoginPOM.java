package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GenericLoginPOM {

private WebDriver driver; 
	
	public GenericLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn; 
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void Login(String uname, String pass){
		this.userName.sendKeys(uname);
		this.password.sendKeys(pass);
		this.clickLoginBtn();
	}
	
	
}

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductLinkPOM {

private WebDriver driver;

	public ProductLinkPOM(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-catalog']/a[1]/i[@class='fa fa-tags fw']")
	private WebElement Catalog;
	
	@FindBy(linkText = "Categories" )
	private WebElement Cat;
	
	@FindBy(linkText = "Products" )
	private WebElement Prod;
	
	@FindBy(linkText = "Recurring Profiles" )
	private WebElement Prof;
	
	public void clickOnProduct() {
		
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(Catalog));
		
		act.moveToElement(Catalog).click().build().perform();
		
		this.Cat.isDisplayed();
		this.Prod.isDisplayed();
		this.Prof.isDisplayed();
		System.out.println("Categories,Products,Recurring Profiles links are displayed in the list");
		
		act.moveToElement(Catalog).moveToElement(Cat).moveToElement(Prod).click().build().perform();
	}
	
}

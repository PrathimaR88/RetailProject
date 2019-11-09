package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditQuantityPOM {
	
	private WebDriver driver;
	
	public EditQuantityPOM(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody[1]/tr[1]/td[8]/a[1]")
	WebElement edit;
	@FindBy(linkText="Data")
	WebElement datatab;
	@FindBy(id = "input-quantity")
	WebElement quanti;
	@FindBy(linkText="Attribute")
	WebElement attr;
	@FindBy(linkText="Option")
	WebElement opt;
	@FindBy(linkText="Recurring")
	WebElement recr;
	@FindBy(linkText="Discount")
	WebElement disc;
	@FindBy(linkText="Special")
	WebElement spl;
	@FindBy(linkText="Image")
	WebElement img;
	@FindBy(linkText="Reward Points")
	WebElement point;
	@FindBy(linkText="Design")
	WebElement desg;
	@FindBy(xpath="//div[@class='pull-right']//button[@class='btn btn-primary']")
	WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement success;
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement failure;
	@FindBy(id="input-keyword")
	WebElement url;
	
	public void editquantity(){
		
	    //3. Click on Edit icon
		this.edit.click();

		//Click on Data tab
		this.datatab.click();

		//Clear Quantity textbox and send a new value
		WebElement quant = this.quanti;
		quant.clear();
		quant.sendKeys("45");

		//13. Keep default values in Attribute, Option, Recurring, Discount, Special, Image, Reward Points and Design tab
		this.attr.click();
		this.opt.click();
		this.recr.click();
		this.disc.click();
		this.spl.click();
		this.img.click();
		this.point.click();
		this.desg.click();

		//14. Click on Save icon
		this.save.click();

		if(this.failure.getText().contains("Warning"))
		{
			this.datatab.click();
			WebElement seo = this.url;
			seo.getText();
			Assert.assertTrue(true, "home");
			seo.clear();
			seo.sendKeys("England");
		}
			else if(this.success.getText().contains("Success"))
			{
				Assert.assertTrue(true, "Success: You have modified");
			}
			else
			{
			//testng fail 
			//catch(AssertionError NullPointerException e){
		            Assert.fail();
				
			}
		
	}
}

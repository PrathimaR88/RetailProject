package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FourFilterProductPOM {

	private WebDriver driver; 
		
//RTTC_014 - To Verify whether application allows the admin to filter the product details
	public FourFilterProductPOM(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Product Name']")
	WebElement ProdName;
	
	@FindBy(css="#button-filter")
	WebElement Filter;
	
	@FindBy(id = "input-price")
	WebElement Price;
	
	public void FilterProduct(){
		
		//Searching for product Integer vitae iaculis massa
		this.ProdName.sendKeys("Integer vitae iaculis massa");

		//Click on Filter button
		this.Filter.click();
		
		int rnum = 1;
		String before = "//table[@class='table table-bordered table-hover']/tbody[1]/tr[";
		String after = "]/td[3]";
		String expname = "Integer vitae iaculis massa";
		int rcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
		System.out.println("Count of row is "+rcount);
		for(rnum = 1; rnum<=rcount; rnum++)
		{
			String name = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody[1]/tr["+ rnum+ "]/td[3]")).getText();
			System.out.println("Displayed name is :  "+name);
			if(name.equalsIgnoreCase(expname) ){
				System.out.println("Name matches and move to next row");
			}
			else
			{
				System.out.println("Name does not match but still move to next row");
			}

		}

		//5. Enter Valid credentials in Price textbox
		this.Price.sendKeys("515");

		//Click on Filter button
		this.Filter.click();

		String expvalue = "515.0000";
		int rpcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
		System.out.println("Count of row is "+rpcount);
		for(rnum = 1; rnum<=rpcount; rnum++)
		{
			String pname = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody[1]/tr["+ rnum+ "]/td[5]")).getText();
			if(pname.equalsIgnoreCase(expvalue) ){
				System.out.println("Value matches and move to next row");
			}
			else
			{
				System.out.println("Value does not match but still move to next row");
			}

		}
	}

}

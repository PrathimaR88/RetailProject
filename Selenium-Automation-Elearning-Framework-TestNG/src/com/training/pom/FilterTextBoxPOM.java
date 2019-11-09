package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FilterTextBoxPOM {
	
	private WebDriver driver;
	
	public FilterTextBoxPOM(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Product Name']")
	WebElement ProdName;
	
	@FindBy(css="#button-filter")
	WebElement Filter;
	
	@FindBy(id = "input-price")
	WebElement Price;
	
	@FindBy(css="#input-status")
	WebElement stat;
	
	@FindBy(css="#input-model")
	WebElement mod;
	
	@FindBy(css="#input-quantity")
	WebElement quan;
	
	@FindBy(css="#input-image")
	WebElement img;
	
	public void Textbox(){
		
		//Searching for product Integer vitae iaculis massa
		this.ProdName.sendKeys("Integer vitae iaculis massa");

		//Click on Filter button
		this.Filter.click();

		int rnum = 1;
		//String before = "//table[@class='table table-bordered table-hover']/tbody[1]/tr[";
		//String after = "]/td[3]";
		String expname = "Integer vitae iaculis massa";
		int rcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
		System.out.println("Count of row is "+rcount);
		for(rnum = 1; rnum<=rcount; rnum++)
		{
			String name = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody[1]/tr["+ rnum+ "]/td[3]")).getText();
			System.out.println("Displayed name is :  "+name);
			if(name.equalsIgnoreCase(expname) ){
				System.out.println("Product Name matches and move to next row");
			}
			else
			{
				System.out.println("Product Name does not match but still move to next row");
			}

		}

		//Enter Valid credentials in Price textbox
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
				System.out.println("Price matches and move to next row");
			}
			else
			{
				System.out.println("Price does not match but still move to next row");
			}

		}
		
		//Select values from Status list box
		Select status = new Select(this.stat);
        status.selectByVisibleText("Enabled");
        
        this.Filter.click();
        
          String stvalue = "Enabled";
          int stcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
        System.out.println("Count of row is " + stcount);
        for (rnum = 1; rnum <= stcount; ++rnum) {
              String sname = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody[1]/tr[" + rnum + "]/td[7]")).getText();
            if (sname.equalsIgnoreCase(stvalue)) {
                System.out.println("Value matches and move to next row");
            }
            else {
                System.out.println("Value does not match but still move to next row");
            }
        }
        
        //Enter Valid credentials in Model textbox
        this.mod.sendKeys(new CharSequence[] { "SKU-003" });
        
        this.Filter.click();
        
          String mvalue = "SKU-003";
          int mcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
        System.out.println("Count of row is " + mcount);
        for (rnum = 1; rnum <= mcount; ++rnum) {
              String mname = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody[1]/tr[" + rnum + "]/td[4]")).getText();
            if (mname.equalsIgnoreCase(mvalue)) {
                System.out.println("Model matches and move to next row");
            }
            else {
                System.out.println("Model does not match but still move to next row");
            }
        }
        
        //Enter Valid credentials in Quantity textbox
        this.quan.sendKeys("49");
        
        this.Filter.click();
        
          String qvalue = "49";
          int qcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
        System.out.println("Count of row is " + qcount);
        for (rnum = 1; rnum <= qcount; ++rnum) {
              String qname = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody[1]/tr[" + rnum + "]/td[6]")).getText();
            if (qname.equalsIgnoreCase(qvalue)) {
                System.out.println("Quantity matches and move to next row");
            }
            else {
                System.out.println("Quantity does not match but still move to next row");
            }
        }
        
        //Validate access of textbox Image
        Select image = new Select(this.img);
        image.selectByVisibleText("Enabled");
        
        this.Filter.click();
        
          int icount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
        System.out.println("Count of row is " + icount);
        for (rnum = 1; rnum <= icount; ++rnum) {
            driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody[1]/tr[" + rnum + "]/td[2]/img[@class='img-thumbnail']")).isDisplayed();
        }


	}


}

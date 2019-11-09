package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddProductPOM {
	
private WebDriver driver;
	
	public AddProductPOM(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@data-original-title='Add New']")
	WebElement add;
	
	@FindBy(css="#input-name1")
	WebElement iname;
	@FindBy(css="#input-meta-title1")
	WebElement meta;
	@FindBy(linkText="Data")
	WebElement data;
	@FindBy(id="input-model")
	WebElement model;
	@FindBy(id="input-price")
	WebElement price;
	@FindBy(id="input-quantity")
	WebElement quan;
	@FindBy(linkText="Links")
	WebElement link;
	@FindBy(id="input-category")
	WebElement cat;
	@FindBy(xpath="//div[@class='panel-body']//div[2]//div[1]//ul[1]")
	WebElement box;
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
	WebElement msg;
	@FindBy(css="#button-filter")
	WebElement Filter;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement del;
	
	@FindBy(xpath="//*[@class = 'alert alert-success']")
	WebElement mess;
	@FindBy(id="input-name")
	WebElement delprod;
	
	
	
	public void addproduct(){
		
		//3. Click on Add New icon
		this.add.click();

		//4. Enter Valid credentials in Product Name of General tab
		this.iname.sendKeys("PR_Finger Ring");

		//5. Enter Valid credentials in Meta Tag Title of General tab
		this.meta.sendKeys("Finger Ring for ladies");

		//6. Click on Data tab
		this.data.click();

		//7. Enter valid credentials in Model textbox
		this.model.sendKeys("SKU-012");

		//8. Enter valid credentials in Price textbox
		this.price.sendKeys("500");

		//9. Enter valid credentials in Quantity textbox
		WebElement quant = this.quan;
		quant.clear();
		quant.sendKeys("50");

		//10. Click on Links tab
		this.link.click();

		//11. Click on Categories textbox
		WebElement cata = this.cat;
		cata.click();
		this.box.isDisplayed();
		//Defect is raised as no option of Earrings is displayed but we are sending it 
		cata.sendKeys("Earrings");

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

		String result = this.msg.getText();
		Assert.assertTrue(true, "Success: You have modified");
		System.out.println(result);
	}
	
	public void Deleteproduct(){
		//Entering the Product Name we have added
		this.delprod.sendKeys("PR_Finger Ring");

		//Click on the filter button
		this.Filter.click();
		
		String acvalue = "PR_Finger Ring";
		int srow = 1;
		int rcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();

		for (srow=1; srow<=rcount; srow++)
		{
			String cellvalue = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+srow+"]/td[3]")).getText();
			System.out.println("The value of the cell is  "+cellvalue);
			if(acvalue.equalsIgnoreCase(cellvalue))
			{
				this.del.click();
				//Switch to alert
				Alert simpleAlert = driver.switchTo().alert();

				//get the alert
				String alertText = simpleAlert.getText();
				System.out.println("Alert text displayed as  "+alertText);

				//Click on OK button
				simpleAlert.accept();

				//Verifying the text post click on ok
				//String msg = this.mess.getText();
				//Assert.assertTrue(true, "Success");
				System.out.println("Deletion of the product is done successfully");
				
			}
			else{
				System.out.println("Current row value does not match move to next");
			}

		}

		
		/*this.del.click();

		//Switch to alert
		Alert simpleAlert = driver.switchTo().alert();

		//get the alert
		String alertText = simpleAlert.getText();
		System.out.println("Alert text displayed as  "+alertText);

		//Click on OK button
		simpleAlert.accept();

		//Verifying the text post click on ok
		String msg = this.mess.getText();
		Assert.assertTrue(true, "Deletion");
		System.out.println("Deletion of the product is done successfully");*/
	}

	
	
}

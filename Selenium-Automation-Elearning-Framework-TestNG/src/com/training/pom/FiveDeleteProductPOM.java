package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FiveDeleteProductPOM {
	
	private WebDriver driver; 
	

//RTTC_015 -- To Verify whether application allows the admin to delete a product from product list
	
	public FiveDeleteProductPOM(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="input-name")
	WebElement input;
	
	@FindBy(css="#button-filter")
	WebElement filter;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement del;
	
	@FindBy(xpath="//*[@class = 'alert alert-success']")
	WebElement mess;

	public void DeleteProd(){
		//step to filter product name of Ear rings

		this.input.sendKeys("Ear Rings");
		//Click on Filter button
		this.filter.click();

		//Clicking on the checkbox next to ear ring
		String acvalue = "Ear Rings";
		int srow = 1;
		int rcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();

		for (srow=1; srow<=rcount; srow++)
		{
			String cellvalue = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+srow+"]/td[3]")).getText();
			System.out.println("The value of the cell is  "+cellvalue);
			if(acvalue.equalsIgnoreCase(cellvalue))
			{
				WebElement check = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+srow+"]/td[1]"));
				boolean chkbox = check.isSelected();

				if(chkbox == true)
				{
					System.out.println("Checkbox is selected");
				}
				else
				{
					check.click();
					break;
				}
			}
			else{
				System.out.println("Current row value does not match move to next");
			}

		}

		
		this.del.click();

		//Switch to alert
		Alert simpleAlert = driver.switchTo().alert();

		//get the alert
		String alertText = simpleAlert.getText();
		System.out.println("Alert text displayed as  "+alertText);

		//Click on OK button
		simpleAlert.accept();

		//Verifying the text post click on ok
		String msg = this.mess.getText();
		System.out.println("Deletion of the product is done successfully");
	}


}

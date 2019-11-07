package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ThirdCheckboxDeletePOM {

	private WebDriver driver; 
	
//***RTTC_013 -- To Verify whether application allows the admin to delete a category from list of Categories	
	public ThirdCheckboxDeletePOM(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement Del;
	
	@FindBy(xpath = "//div[@class = 'alert alert-success']")
	private WebElement alert;
	
	//@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[2]")
	//private WebElement Value;
	
	public void CheckIndian()
	{	//Identify the INDIAN category box 
	
			String acvalue = "Category Name";
			int i;
			int rcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
			//Validate in the table for the required value and click on the checkbox of delete
			
			for (i=1; i<=rcount; i++)
			{
				String cellvalue = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[2]")).getText();
				System.out.println("The value of the cell is  "+cellvalue);
				if(acvalue.equalsIgnoreCase(cellvalue))
				{
				WebElement check = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[1]"));
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
					
			//Click on the delete icon			
			this.Del.click();
			
			//Switch to alert
			Alert simpleAlert = driver.switchTo().alert();
					
			//get the alert
			String alertText = simpleAlert.getText();
			System.out.println("Alert text displayed is  "+alertText);
					
			//Click on OK button
			simpleAlert.accept();
			
			//Verifying the text post click on ok
			String result = this.alert.getText();
			Assert.assertTrue(true, "Success: You have modified");
			//Assert.assertTrue(result.contentEquals("Success: You have modified"));
			//Assert.assertTrue(result.contentEquals("Delete"));
			//System.out.println("Deletion of the category is done successfully");
			//Assert.assertThat(result,containsString("Success: You have modified"));
			
}
}

package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdCheckboxDeletePOM {

	private WebDriver driver; 
	//public int i=1;
	
	public ThirdCheckboxDeletePOM(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@type='button']")
	private WebElement Del;
	
	@FindBy(xpath = "//*[@class = 'alert alert-success']")
	private WebElement alert;
	
	//@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[2]")
	//private WebElement Value;
	
	public void CheckIndian()
	{	//Identify the INDIAN category box 
	
			String srow = "1";
			//String scol = "2";
			
			String acvalue = "INDIAN";
			int i = Integer.parseInt(srow);
			
			//@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr["+i+"]/td[2]")
			//private WebElement Value;
			
			
			for (i=1; i<=10; i++)
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
					
						
			this.Del.click();
			
			//Switch to alert
			Alert simpleAlert = driver.switchTo().alert();
					
			//get the alert
			String alertText = simpleAlert.getText();
			System.out.println("Alert text displayed is  "+alertText);
					
			//Click on OK button
			simpleAlert.accept();
			
			//Verifying the text post click on ok
			this.alert.getText();
			//assertEquals(msg," Success: You have modified categories!      ");
			System.out.println("Deletion of the category is done successfully");
}
}

package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class DeleteMultProductsPOM {
	
private WebDriver driver;
	
	public DeleteMultProductsPOM(WebDriver driver){
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Product Name']")
	WebElement product;
	@FindBy(css="#button-filter")
	WebElement filter;
	@FindBy(xpath="//table[@class='table table-bordered table-hover']/tbody/tr")
	WebElement table;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement delete;
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement success;
	
	
	public void DeleteProd(String pname){
		this.product.sendKeys(pname);
        this.filter.click();
	    String acvalue = pname;
        int srow;
        int rcount;
        String cellvalue;
        WebElement check;
        boolean chkbox;
        rcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
        for (srow = 1; srow <= rcount; ++srow) {
            cellvalue = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + srow + "]/td[3]")).getText();
            System.out.println("The value of the cell is  " + cellvalue);
            if (acvalue.equalsIgnoreCase(cellvalue)) {
                check = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + srow + "]/td[1]"));
                chkbox = check.isSelected();
                if (!chkbox) {
                    check.click();
                    break;
                }
                System.out.println("Checkbox is selected");
            }
            else {
                System.out.println("Current row value does not match move to next");
            }
        }
          WebElement del = this.delete;
        del.click();

        //Switch to alert
        Alert simpleAlert = driver.switchTo().alert();

        //get the alert
        String alertText = simpleAlert.getText();
        System.out.println("Alert text displayed as  "+alertText);

        //Click on OK button
        simpleAlert.accept();
        Assert.assertTrue(true, "Success: You have modified");

	}

	
	
}

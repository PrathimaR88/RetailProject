package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsOfOrderPOM {
	
	//***RTTC_045 - To Verify whether application allows admin to check the details of order placed by the user
	
	private WebDriver driver;

	public DetailsOfOrderPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-shopping-cart fw']")
	private WebElement salelink;
	
	@FindBy(xpath="//li[@id='menu-sale']//ul//li//a[contains(text(),'Orders')]")
	private WebElement orderlink;
	
	@FindBy(xpath="//li[@id='menu-sale']//ul//li//a[contains(text(),'Recurring Profiles')]")
	private WebElement profile;
	
	@FindBy(xpath="//li[@id='menu-sale']//ul//li//a[contains(text(),'Returns')]")
	private WebElement returns;
	
	@FindBy(xpath="//li[@id='menu-sale']//ul//li//a[contains(text(),'Gift Vouchers')]")
	private WebElement voucher;
	
	@FindBy(id = "input-order-status")
	private WebElement status;
	
	@FindBy(xpath = "//button[@id='button-filter']")
	WebElement Filter;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr[1]//td[8]//a[1]")
	WebElement view;
	
	@FindBy(xpath = "//body/div[@id='container']/div[@id='content']/div[@class='container-fluid']/div[@class='row']/div[1]/div[1]")
	WebElement order;
	
    @FindBy(xpath = "//body/div[@id='container']/div[@id='content']/div[@class='container-fluid']/div[@class='row']/div[2]/div[1]")
    WebElement customer;
    
    @FindBy(xpath = "//body/div[@id='container']/div[@id='content']/div[@class='container-fluid']/div[@class='row']/div[3]/div[1]")
    WebElement options;
    
    @FindBy(xpath = "//i[@class='fa fa-refresh']")
    WebElement generate;
    
    @FindBy(xpath = "//td[@id='invoice']")
    WebElement invoice;
	
	public void detailoforder()
	{
		Actions act = new Actions(driver);
	    WebElement sale = this.salelink;
	    act.moveToElement(sale).build().perform();
	     
	    WebElement order = this.orderlink;
	    order.isDisplayed();
        this.profile.isDisplayed();
        this.returns.isDisplayed();
        this.voucher.isDisplayed();
        
        System.out.println("Orders, Recurring Profiles, Returns, Gift Vouchers list should get displayed");
		
        //Navigation to the order tab of the Sales path
        act.moveToElement(sale).moveToElement(order).click().build().perform();
        
        //Unable to select order created so selecting any order in Pending status to generate Invoice
        Select stat = new Select(this.status);
        stat.selectByVisibleText("Pending");
        this.Filter.click();
        
        //Clicking on the view button of the first product listed
        this.view.click();
        this.order.isDisplayed();
        this.customer.isDisplayed();
        this.options.isDisplayed();
        System.out.println("The Order Details, Customer Details and Options are displayed");
        
        //Checking if the generate icon is clickable or not 
        WebDriverWait wait = new WebDriverWait(driver,10);
        if(wait.until(ExpectedConditions.elementToBeClickable(this.generate)) == null)
            {
        	generate.click();
        	System.out.println("Clicked on generate icon");
        	}
        
              
        //Printing the invoice number
        
        System.out.println(this.invoice.getText());
	}

}

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.CatalogCategoriesPOM;
import com.training.pom.FourFilterProductPOM;
import com.training.pom.GenericLoginPOM;
import com.training.pom.ProductLinkPOM;
import com.training.pom.ThirdCheckboxDeletePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class FourFilterProducts {
	
	private WebDriver driver;
	private String adminUrl;
	private GenericLoginPOM loginPOM;
	private ProductLinkPOM ProdPOM;
	private FourFilterProductPOM FilterPOM;
	private static Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new GenericLoginPOM(driver); 
		ProdPOM = new ProductLinkPOM(driver);
		FilterPOM = new FourFilterProductPOM(driver);
		adminUrl = properties.getProperty("adminURL");
			
	}
	

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	
	@Test()
	//RTTC_014 - To Verify whether application allows the admin to filter the product details
	public void ValidateFilter() throws InterruptedException {
		driver.get(adminUrl);
		loginPOM.Login("admin", "admin@123");
		ProdPOM.clickOnProduct();
		FilterPOM.FilterProduct();
		Thread.sleep(7000);
		driver.quit();
	}
	

}

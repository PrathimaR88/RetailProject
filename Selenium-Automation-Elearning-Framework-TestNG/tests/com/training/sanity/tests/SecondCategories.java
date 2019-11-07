package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.training.pom.AdminLoginPOM;
import com.training.pom.CatalogCategoriesPOM;
import com.training.pom.GenericLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SecondCategories {
	
	private WebDriver driver;
	private String adminUrl;
	private GenericLoginPOM loginPOM;
	private CatalogCategoriesPOM CataPOM;
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
		CataPOM = new CatalogCategoriesPOM(driver);
		adminUrl = properties.getProperty("adminURL");
	}
		 
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	
	@Test()
	//******RTTC_012  To Verify whether application allows the admin to display list of Categories
	
	public void ValidateCatalog() throws InterruptedException {
		driver.get(adminUrl);
		loginPOM.Login("admin", "admin@123");
		CataPOM.clickOnCategory();
		Thread.sleep(7000);
		driver.quit();
	}

	
}

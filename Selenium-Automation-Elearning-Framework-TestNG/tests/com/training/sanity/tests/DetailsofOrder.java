package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.DetailsOfOrderPOM;
import com.training.pom.FiveDeleteProductPOM;
import com.training.pom.GenericLoginPOM;
import com.training.pom.ProductLinkPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DetailsofOrder {
	
		private WebDriver driver;
		private String adminUrl;
		private GenericLoginPOM loginPOM;
		private DetailsOfOrderPOM OrderPOM;
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
			OrderPOM = new DetailsOfOrderPOM(driver);
			adminUrl = properties.getProperty("adminURL");
				
		}
		

		@AfterMethod
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			//driver.quit();
		}
		
		
		@Test()
		
	//***RTTC_045 - To Verify whether application allows admin to check the details of order placed by the user
		public void ValidateFilter() throws InterruptedException {
			driver.get(adminUrl);
			loginPOM.Login("admin", "admin@123");
			OrderPOM.detailoforder();
			Thread.sleep(3000);
			driver.quit();
		}


}

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

public class MainPageTests {
    @Test(description = "Manufacturer selection test")
    public void selectManufacturer() {
	try {
	    System.setProperty("browser", "firefox");
	    // WebDriver driver = DriverSingleton.getDriver();
	    WebDriver driver = new FirefoxDriver();
	    MainPage page1 = new MainPage(driver);
	    page1.openPage();
	    page1.SelectCarBrand();
	    Assert.assertEquals(driver.getCurrentUrl(), "https://auto.drom.ru/toyota/");
	    driver.close();
	} catch (Exception e) {
	    e.printStackTrace();  // Log or handle the exception as needed
	    Assert.fail("Test failed: " + e.getMessage());
	}
    }
    
    @Test(description = "VIN number checker test")
    public void VinCheck() {
	try {
	    System.setProperty("browser", "firefox");
	    WebDriver driver = new FirefoxDriver();
	    MainPage page1 = new MainPage(driver);
	    page1.openPage();
	    page1.VinChecker("1HGBH41JXMN109186");
	    Assert.assertEquals(driver.getCurrentUrl(), "https://vin.drom.ru/report/1HGBH41JXMN109186/?utm_source=web_main_page&utm_medium=banner&utm_campaign=report_by_vin");
	    driver.close();
	} catch (Exception e) {
	    e.printStackTrace();
	    Assert.fail("Test failed: " + e.getMessage());
	}
    }
    
    
}

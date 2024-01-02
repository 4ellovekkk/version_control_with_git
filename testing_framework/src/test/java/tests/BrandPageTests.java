package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BrandPage;

public class BrandPageTests {
    @Test(description = "Extended search test")
    public void ExtendedSearch()
    {
        try {
            WebDriver driver = new FirefoxDriver();
            BrandPage page2 = new BrandPage(driver);
            page2.openPage();
            page2.ExtendedSearch();
            driver.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Test filed: "+ e.getMessage());
        }
    }
    @Test(description = "Region search test")
    public void RegionSearch()
    {
        try {
            WebDriver driver = new FirefoxDriver();
            BrandPage page2 = new BrandPage(driver);
            page2.openPage();
            page2.RegionSearch();
            Assert.assertEquals(driver.getCurrentUrl(),"https://moscow.drom.ru/toyota/");
            driver.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Test filed: "+ e.getMessage());
        }
    }
    @Test(description = "Sort order test")
    public void SortOrder()
    {
        try {
            WebDriver driver = new FirefoxDriver();
            BrandPage page2 = new BrandPage(driver);
            page2.openPage();
            page2.SortOrder();
            Assert.assertEquals(driver.getCurrentUrl(),"https://auto.drom.ru/toyota/");
            driver.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Test filed: "+ e.getMessage());
        }
    }
    @Test(description = "Year filtering test")
    public void YearFilter()
    {
        try {
            WebDriver driver = new FirefoxDriver();
            BrandPage page2 = new BrandPage(driver);
            page2.openPage();
            page2.YearFilter();
            Assert.assertEquals(driver.getCurrentUrl(),"https://auto.drom.ru/toyota/all/?minyear=2018&maxyear=2023");
            driver.close();
        }catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail("Test filed: "+ e.getMessage());
        }
    }
    
}

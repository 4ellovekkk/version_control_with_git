package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DromTest {
    
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
	// Initialize WebDriver
	driver = new FirefoxDriver();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	// Open the drom.ru website
	driver.get("https://drom.ru");
    }
    
    @Test
    public void searchToyotaWithFilter() {
	// Create an instance of the HomePage
	HomePage homePage = new HomePage(driver);
	
	// Perform a search for Toyota with a filter for the year range
	SearchResultsPage searchResultsPage = homePage.searchForToyotaWithFilter("2018", "2023");
	
	// Verify that the search results page contains Toyota and the correct year range
	Assert.assertTrue(searchResultsPage.isToyotaDisplayed());
	Assert.assertTrue(searchResultsPage.isYearInRange("2018", "2023"));
	System.out.println("Toyota and correct year range are displayed in the search results.");
    }
    
    @AfterMethod
    public void tearDown() {
	// Close the browser after the test
	driver.quit();
    }
}

class HomePage {
    private WebDriver driver;
    private WebElement autobutton;
    private WebElement jgf;
    
    public HomePage(WebDriver driver) {
	this.driver = driver;
	// Initialize page elements
	autobutton = driver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div[1]/div[2]/div[4]/div[2]"));
    }
    
    public SearchResultsPage searchForToyotaWithFilter(String fromYear, String toYear) {
	// Click on the search button, apply the filter, and return the SearchResultsPage
	autobutton.click();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/form/div/div[2]/div[2]/div/div[1]/div[1]/button")).click();
//	Wait<WebDriver> wait = new FluentWait<>(driver)
//		.withTimeout(Duration.ofSeconds(30))
//		.ignoring(NoSuchElementException.class);
//	wait.until(driver ->driver.findElement(By.id("ty19tu2w0q8-3")).isDisplayed());
	driver.findElement(By.id("//*[@id=\"ty19tu2w0q8-5\"]")).isDisplayed();
	driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/form/div/div[2]/div[2]/div/div[2]/div[1]/button")).click();
	//driver.findElement(By.id("l9xelxs3aplr-3")).click();
	//driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[1]/div[1]/div[2]/form/div/div[4]/div[3]/button")).click();
	
	return new SearchResultsPage(driver);
    }
}

class SearchResultsPage {
    private WebDriver driver;
    private WebElement resultsContainer;
    
    public SearchResultsPage(WebDriver driver) {
	this.driver = driver;
	// Initialize page elements
	resultsContainer = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[6]/div"));
    }
    
    public boolean isToyotaDisplayed() {
	// Check if the search results page contains Toyota
	return resultsContainer.getText().contains("Toyota");
    }
    
    public boolean isYearInRange(String fromYear, String toYear) {
	// Check if the search results page contains the specified year range
	return resultsContainer.getText().contains(fromYear) && resultsContainer.getText().contains(toYear);
    }
}

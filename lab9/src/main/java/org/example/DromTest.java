package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class DromTest {
    
    public static void main(String[] args) {
	// Инициализировать WebDriver
	WebDriver driver = new FirefoxDriver();
	
	// Открыть сайт drom.ru
	driver.get("https://drom.ru");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	// Найти поле поиска марки автомобиля и ввести "Toyota"
	WebElement Autobutton = driver.findElement(By.xpath("/html/body/div[2]/div[6]/div/div[1]/div[2]/div[4]/div[2]"));
	Autobutton.click();
	
	
	
	// Проверить, что страница с результатами поиска содержит объявления о продаже автомобилей марки Toyota
	WebElement resultsPage = driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[1]/div[1]/div[6]/div"));
	boolean isToyotaDisplayed = resultsPage.getText().contains("Toyota");
	//Assert.assertEquals(isToyotaDisplayed,true);
	Assert.assertTrue(isToyotaDisplayed);
	System.out.println(isToyotaDisplayed);
	//Assert.fail("Ты что нажмал?!");
	driver.quit();
    }
}

package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
    private final String BASE_URL = "https://www.drom.ru/";
    
    @FindBy(xpath = "/html/body/div[2]/div[6]/div/div[1]/div[2]/div[4]/div[2]")
    private WebElement CarBrand;
    
    @FindBy(xpath = "/html/body/div[2]/div[6]/div/div[2]/div[2]/form/input")
    private WebElement VinInput;
    
    @FindBy(xpath = "/html/body/div[2]/div[6]/div/div[2]/div[2]/form/button")
    private WebElement VinVerify;
    
    public MainPage openPage() {
	driver.navigate().to(BASE_URL);
	return this;
    }
    
    public void SelectCarBrand()
    {
	CarBrand.click();
    }
    public void VinChecker(String InpitValue)
    {
        VinInput.sendKeys(InpitValue);
        VinVerify.click();
    }
    public MainPage(WebDriver driver) {
	super(driver);
        PageFactory.initElements(this.driver, this);
    }
}

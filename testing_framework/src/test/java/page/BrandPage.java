package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandPage extends AbstractPage {
    private final String BASE_URL = "https://auto.drom.ru/toyota/";
    
    @FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/form/div/div[2]/div[2]/div/div[1]/div[1]/button")
    private WebElement yearFromButton;
    @FindBy(xpath = "//*[@id=\"f8uubvwvb4h-8\"]")
    private WebElement yearFromValue;
    @FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/form/div/div[2]/div[2]/div/div[2]/div[1]/button")
    private WebElement yearToButton;
    @FindBy(xpath = "//*[@id=\"nlm7f37nfoxn-3\"]")
    private WebElement yearToValue;
    
    @FindBy(xpath = "/html/body/div[2]/div[4]/div[1]/div[1]/div[2]/form/div/div[5]/div[3]")
    private WebElement submitParameter;
    
    @FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[1]/div[1]/a[1]")
    private WebElement regionFilter;
    
    @FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[1]/div[5]/div[2]/div/div[1]/button")
    private WebElement sortParameter;
    @FindBy(xpath = "//*[@id=\"y3mzjrvz51of-2\"]")
    WebElement lowerPriceSort;
    
    @FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[1]/div[2]/form/div/div[4]/div[2]/button")
    private WebElement extendedSearch;
    @FindBy(xpath = "//*[@id=\"clr-grp-2\"]")
    private WebElement extendedSearchOwner;
    
    @FindBy(xpath = "/html/body/div[2]/div[5]/div[1]/div[1]/div[6]/div/div[1]/a[1]")
    private WebElement searchResult;
    
    public BrandPage openPage() {
	driver.navigate().to(BASE_URL);
	return this;
    }
    
    
    public void YearFilter() {
	yearFromButton.click();
	yearFromValue.click();
	yearToButton.click();
	yearToValue.click();
    }
    
    public void ExtendedSearch() {
	extendedSearch.click();
	extendedSearchOwner.click();
    }
    
    public void SubmitParameters() {
	submitParameter.click();
    }
    
    public void RegionSearch() {
	regionFilter.click();
    }
    
    public void SortOrder() {
	sortParameter.click();
	//lowerPriceSort.click();
    }
    
    
    public BrandPage(WebDriver driver) {
	super(driver);
	PageFactory.initElements(this.driver, this);
    }
}

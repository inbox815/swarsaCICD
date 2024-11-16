package swarsa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swarsa.AbstractComponents.AbstractComponent;
import swarsa.TestComponents.BaseTest;

public class CheckoutPage {

	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	@FindBy(css=".ta-results")
	WebElement countryList;
	//By results = By.cssSelector(".ta-results");
	AbstractComponent abc = new AbstractComponent(driver);
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		abc.waitForElementToAppear(countryList);
		selectCountry.click();
	}
	public void submitOrder()
	{
		submit.click();
	}
}

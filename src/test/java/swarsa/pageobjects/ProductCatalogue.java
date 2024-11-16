package swarsa.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import swarsa.AbstractComponents.AbstractComponent;
import swarsa.TestComponents.BaseTest;

public class ProductCatalogue {

	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		//initialization code
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".card-body button:last-of-type")
	WebElement addToCart;
	
	@FindBy(css="#toast-container")
	WebElement toastMessage;
	
	AbstractComponent abc = new AbstractComponent(driver);
	public List<WebElement> getProductList()
	{
		return products;
	}
	
	public void addProductToCart(String productName)
	{
		abc.waitForElementToAppear(addToCart);
		for (int i = 0; i < products.size(); i++) 
		{
			if (products.get(i).getText().contains(productName)) 
			{
				addToCart.click();
			}
		}
		abc.waitForElementToDisappear(toastMessage);
	}
	
	

}

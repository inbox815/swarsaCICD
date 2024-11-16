package swarsa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swarsa.TestComponents.BaseTest;

public class CartPage {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbutton;
	
	public void goToCartPage()
	{
		cart.click();
	}
	
	public Boolean verifyProductTitile(String title)
	{
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(title));
		return match;
	}
	
	public void checkout()
	{
		checkoutbutton.click();
	}
	
}

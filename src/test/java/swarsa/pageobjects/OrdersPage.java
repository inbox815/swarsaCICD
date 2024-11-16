package swarsa.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swarsa.TestComponents.BaseTest;

public class OrdersPage {

	WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orders;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderslist;
	
	public void gotoMyOrders()
	{
		orders.click();
	}
	
	public Boolean verifyOrderDisplay(String productName) throws InterruptedException
	{
		Boolean match1 = orderslist.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match1;
	}
	
	
}

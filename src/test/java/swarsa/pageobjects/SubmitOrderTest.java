package swarsa.pageobjects;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import swarsa.AbstractComponents.AbstractComponent;
import swarsa.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

	String myproductName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		landingPage.loginApplication(input.get("email"), input.get("password"));
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cart = new CartPage(driver);
		cart.goToCartPage();
		Boolean match =cart.verifyProductTitile(input.get("product"));
		Assert.assertTrue(match);
		cart.checkout();
		CheckoutPage cp = new CheckoutPage(driver);
		cp.selectCountry("India");
		cp.submitOrder();
		ConfirmationPage conf = new ConfirmationPage(driver);
		String msg = conf.getConfirmationMessage();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		
	}	
	//To verify ZARA COAT 3 is displayed in orders page
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() throws InterruptedException
	{
		landingPage.loginApplication("oscar@empoweredmargins.com", "Password@2");
		OrdersPage ordersPage = new OrdersPage(driver);
		ordersPage.gotoMyOrders();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(myproductName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String,String>> data = getJsonDataToMap();
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	//public void roughtWork()
	//{
//		HashMap<String,String> map = new HashMap<>();
//		map.put("email", "oscar@empoweredmargins.com");
//		map.put("password", "Password@2");
//		map.put("product", "ZARA COAT 3");
//		HashMap<String,String> map1 = new HashMap<>();
//		map1.put("email", "anshika@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("product", "ZARA COAT 3");
//	}
	

}

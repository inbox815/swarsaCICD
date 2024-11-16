package swarsa.pageobjects;

import java.io.IOException;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import swarsa.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest{

	@Test(groups= {"ErrorHandling"})
	public void loginErrorValidation() 
	{
		
		landingPage.loginApplication("sdfs@sdfs.asd", "SDFasdf@1");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}	
	@Test
	public void productErrorValidation() throws IOException
	{
		String myproductName = "ZARA COAT 3";
		
		landingPage.loginApplication("oscar@empoweredmargins.com", "Password@2");
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		productCatalogue.addProductToCart(myproductName);
		CartPage cart = new CartPage(driver);
		cart.goToCartPage();
		Boolean match =cart.verifyProductTitile("ZARA COAT 33");
		Assert.assertFalse(match);
	}	

}

package swarsa.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swarsa.AbstractComponents.AbstractComponent;
import swarsa.TestComponents.BaseTest;

public class LandingPage {

	WebDriver driver;
	LandingPage landingPage;
	public LandingPage(WebDriver driver)
	{
		//initialization code
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail = driver.findElement(By.id("userEmail"));
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(className="login-btn")
	WebElement submit;
	
	@FindBy(xpath="//div[@aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	AbstractComponent abc = new AbstractComponent(driver);
	public LandingPage loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		return landingPage;
	}
	public void openUrl(String url)
	{
		driver.get(url);
	}
	
	public String getErrorMessage()
	{
		abc.waitForElementToAppear(errorMessage);
		return errorMessage.getText();
	}

}

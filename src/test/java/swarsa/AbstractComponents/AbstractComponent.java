package swarsa.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import swarsa.TestComponents.BaseTest;
import swarsa.pageobjects.SubmitOrderTest;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	public void waitForElementToAppear(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForByLocatorToAppear(By findby)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitForElementToDisappear(WebElement element)
	{
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
}

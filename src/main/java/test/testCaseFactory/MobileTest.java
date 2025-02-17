package test.testCaseFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileTest {
	private AndroidDriver<MobileElement> driver;
	private WebDriverWait wait;

	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By submitBtn = By.xpath("//button[@id='submit']");
	
	

	public MobileTest(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}

	public void enterUsername(String un) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(un);
	}
	public void enterPass(String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
	}

	public void selectFirstResult() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
	}
}



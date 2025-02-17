package test.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{



	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement username; 

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement password; 

	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement submitBtn;

	public String Url ="https://practicetestautomation.com/practice-test-login/";


	WebDriver driver;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 20);
	}

	public void openWebApp() throws InterruptedException
	{
//		Adding thread to observe the execution
		Thread.sleep(2000);
		driver.get(Url);

	}

	public void enterUsername() throws InterruptedException {
		Thread.sleep(2000);
	    wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("student");
	    System.out.println("Username entered");
	}

	public void enterPassword() throws InterruptedException{
		Thread.sleep(2000);
	    wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("Password123");
	    System.out.println("Password entered");
	}

	public void clickSubmit() throws InterruptedException{
		Thread.sleep(2000);
	    wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
	    System.out.println("Submit button clicked");
	}



}

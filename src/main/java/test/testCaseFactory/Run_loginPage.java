package test.testCaseFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.testproject.sdk.internal.exceptions.AgentConnectException;
import io.testproject.sdk.internal.exceptions.InvalidTokenException;
import io.testproject.sdk.internal.exceptions.ObsoleteVersionException;
import test.pageFactory.LoginPage;

public class Run_loginPage {

	WebDriver driver;
	LoginPage loginPage;

	@BeforeClass
	public void setUp() throws Exception, AgentConnectException, InvalidTokenException, ObsoleteVersionException {
		// Set up Chrome driver path
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
//		driver = new ChromeDriver();
		driver = new SafariDriver();
		driver.manage().window().maximize();
		// Initialize Page Object
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void openUrl() throws InterruptedException 
	{
		// Use page method to open the app and interact
		
		loginPage.openWebApp();
	}
	@Test(priority = 2)
	public void EtnerUsername() throws InterruptedException
	{
		// here entering valid username
		loginPage.enterUsername();

	}

	@Test(priority = 3)
	public void EnterPassword() throws InterruptedException
	{
		// here entering valid password
		loginPage.enterPassword();
	}
	@Test(priority = 4)
	public void ClickOnSubmit() throws InterruptedException
	{
		// here clicking on submit button
		loginPage.clickSubmit();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}


}




package test.pageFactory;

import java.awt.RenderingHints.Key;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class ToDo_Page {

	@FindBy(how = How.XPATH, using = "//input[@id='todo-input']")
	WebElement todoTextBox;  // Removed static

	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[1]")
	WebElement AllCheckBoxSelectBtn; 

	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[2]")
	WebElement SingleCheckBoxSelectBtn;

	@FindBy(how = How.XPATH, using = " //button[@class='clear-completed']")
	WebElement ClearCompletedBtn;


	WebDriver driver;

	// Constructor
	public ToDo_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);  // Initialize elements here
	}

	// Method to open the URL and perform actions
	public void openWebApp() throws InterruptedException {
		driver.get("https://todomvc.com/examples/react/dist/");

		Thread.sleep(2000);
	}

	//positive scenario
	//1.Adding Valid todo items in list

	public void AddingValidTodoEntry() throws InterruptedException
	{
		Actions action = new Actions(driver);
		todoTextBox.sendKeys("To do item 1");
		Reporter.log("Todo item 1 has been added ", true); 
		Thread.sleep(500);
		action.sendKeys(Keys.RETURN).build().perform(); 
		todoTextBox.sendKeys("To do item 2");
		Reporter.log("Todo item 2 has been added ", true); 
		Thread.sleep(500);
		action.sendKeys(Keys.RETURN).build().perform(); 
		todoTextBox.sendKeys("To do item 3");
		Reporter.log("Todo item 3 has been added ", true); 
		Thread.sleep(500);
		action.sendKeys(Keys.RETURN).build().perform(); 
		todoTextBox.sendKeys("To do item 4");
		Reporter.log("Todo item 4 has been added ", true); 
		Thread.sleep(500);
		action.sendKeys(Keys.RETURN).build().perform(); 
		todoTextBox.sendKeys("To do item 5");
		Reporter.log("Todo item 5 has been added ", true); 
		Thread.sleep(500);
		action.sendKeys(Keys.RETURN).build().perform(); 
		Thread.sleep(2000);

	}
	//positive scenario
	//2.Selecting single checkbox for a single todo item
	public void SelectSingleCheckbox() throws InterruptedException
	{
		Thread.sleep(1000);
		SingleCheckBoxSelectBtn.click();
		Thread.sleep(2000);
		Reporter.log("Single checkbox has been selected", true); 
	}
	//positive scenario
	//3.Selecting all checkbox for a single todo item
	public void SelectAllCheckbox() throws InterruptedException
	{
		Thread.sleep(1000);
		AllCheckBoxSelectBtn.click();
		Thread.sleep(2000);
		Reporter.log("All checkbox has been selected", true); 
	}
	//positive scenario
	//4.Clearing all selected todo items
	public void ClearCompletedTodoItems() throws InterruptedException
	{
		Thread.sleep(1000);
		ClearCompletedBtn.click();
		Thread.sleep(2000);
		Reporter.log("Clear completed btton has been clicked", true); 
	}

	//Negative Scenario 
	//1.To Verify that clear completed button is disable while we have not make any selection

	public void ClearCompletedDisable() throws InterruptedException
	{
		Thread.sleep(2000);
		ClearCompletedBtn.click();
		if (!ClearCompletedBtn.isEnabled()) {
			Reporter.log("The 'Clear Completed' button is disabled.",true);
		} else {
			Reporter.log("The 'Clear Completed' button is enabled.",true);
		}
	}
	//Negative Scenario 
	//2.To Verify that to do box accepting invalid inputs -like alphanumeric value,special char values
	//3.in scenario 3 we are validating character limit to be entered in to do list 
	public void InvalidInput() throws InterruptedException
	{
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		String invalidChar= "253525672##$#@%#$%#%32874278368762fgodhguhfdhgfuher347%$#%$#$%#";
		todoTextBox.sendKeys(invalidChar);
		Reporter.log("Todo item invalid input has been added ", true); 
		Thread.sleep(500);
		action.sendKeys(Keys.RETURN).build().perform(); 

		//for example we are taking 21 as char limit
		int charLimit = 21;

		// Length of the string
		int stringLength = invalidChar.length();

		Thread.sleep(1500);
		// Output result
		if (stringLength > charLimit) {
			System.out.println("The string exceeds the character limit.");
			System.out.println("Total characters: " + stringLength);
			System.out.println("Exceeded by: " + (stringLength - charLimit) + " characters.");
		} 
		else 
		{
			System.out.println("The string is within the limit.");
			System.out.println("Total characters: " + stringLength);
		}

	}
	//Negative Scenario 
	//4.to add single char in todo ,which is not acceptable 

	public void AddSingleChar()throws InterruptedException
	{
		todoTextBox.sendKeys("A");
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		Thread.sleep(1000);
		action.sendKeys(Keys.RETURN).build().perform(); 

		// Wait for a brief period to allow the system to process the item
		Thread.sleep(1000); // You can replace this with WebDriverWait if needed

		// Check if a new ToDo item is added (check if there are any ToDo items listed)
		List<WebElement> todoItems = driver.findElements(By.xpath("//ul[@class='todo-list']//li"));

		// Verify that no new item was added
		if (todoItems.size() == 0) {
			System.out.println("Test Passed: Single character item cannot be added.");
		} else {
			System.out.println("Test Failed: A single character item was added.");
		}

		// Assert to make sure test fails if the item was added
		Assert.assertEquals(todoItems.size(), 0, "Single character should not be allowed as a ToDo item.");
	}
}

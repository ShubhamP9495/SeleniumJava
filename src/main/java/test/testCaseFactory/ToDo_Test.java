package test.testCaseFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.pageFactory.ToDo_Page;

public class ToDo_Test {

    WebDriver driver;
    ToDo_Page toDoPage;

    @BeforeClass
    public void setUp() {
        // Set up Chrome driver path
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Object
        toDoPage = new ToDo_Page(driver);
    }

    @Test(priority = 1)
    public void openUrl() throws InterruptedException 
    {
        // Use page method to open the app and interact
        toDoPage.openWebApp();
    }
    @Test(priority = 2)
    public void ToAddSingleChar() throws InterruptedException
    {
        // here validating negative scenario by adding single char in todo list
        toDoPage.AddSingleChar();
    }
    
    @Test(priority = 3)
    public void inValidItemEntry() throws InterruptedException
    {
        // here validating negative scenario by adding invalid entry-alphanumeric value ,special char value
    	//another scenario here we are validating that check limit of character to be added in todo list 
        toDoPage.InvalidInput();
    }
    @Test(priority = 4)
    public void AddingValidItemEntry() throws InterruptedException
    {
        // here validating positive scenario by adding valid entry
        toDoPage.AddingValidTodoEntry();
    }
    @Test(priority = 5)
    public void ClearCompletedVerify() throws InterruptedException
    {
        // here validating negative scenario clear completed btn is enable or disabled
        toDoPage.ClearCompletedDisable();
    }
    @Test(priority = 6)
    public void SelectSingleCheckBox() throws InterruptedException
    {
        // here validating positive scenario selecting single checkbox
        toDoPage.SelectSingleCheckbox();
    }
    @Test(priority = 7)
    public void SelectAllCheckBox() throws InterruptedException
    {
        // here validating positive scenario selecting All checkbox
        toDoPage.SelectAllCheckbox();
    }
    @Test(priority = 8)
    public void ClearCompleted() throws InterruptedException
    {
        // here validating positive scenario clear completed to do items
        toDoPage.ClearCompletedTodoItems();
    }
   
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

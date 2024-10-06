# README for ToDo Application Automation Test Suite

Find the files with below location
**src/main/java/test**

## Overview
This repository contains an automated test suite designed to validate the functionality of a **ToDo** web application using **Selenium WebDriver** and the **TestNG** framework. The suite employs the **Page Object Model (POM)** design pattern to maintain code organization and facilitate easy updates as the application evolves.

### What is Being Tested?
The test suite covers both **positive** and **negative** test cases for different functionalities in the ToDo app, including:
- Adding valid and invalid ToDo items.
- Selecting individual or all ToDo items using checkboxes.
- Clearing completed ToDo items.
- Verifying that invalid inputs (alphanumeric values, special symbols, and short input strings) are rejected.
- Validating that input character limits are enforced.
- Ensuring that the "Clear Completed" button is disabled unless items are selected.

## Patterns and Approaches Used

### Page Object Model (POM)
The **Page Object Model (POM)** pattern is implemented in this project to create a layer between the test logic and the web elements. This separation improves test code maintainability, scalability, and readability. Changes in the web page's structure will only require updates in the Page Object classes without altering the test cases.

### TestNG Framework
- **TestNG** provides annotations like `@BeforeClass`, `@Test`, and `@AfterClass` for structuring and executing the test cases.
- Tests are organized using **priority** to manage the order of execution, and **assertions** are employed to validate the application's behavior.
- Detailed reporting is enabled using `Reporter.log()` for debugging and result verification.

## Test Organization

### Page Class (`ToDo_Page.java`)
The **Page Class** encapsulates the web elements and actions performed on the ToDo application page. It defines the interactions like adding tasks, selecting checkboxes, and clearing completed tasks.

#### Methods in `ToDo_Page.java`

1. **`openWebApp()`**  
   - Opens the ToDo web application in a browser.

2. **`AddingValidTodoEntry()`**  
   - Adds valid items to the ToDo list.  
   - Logs the addition of each item.

3. **`SelectSingleCheckbox()`**  
   - Selects the checkbox for a single ToDo item.

4. **`SelectAllCheckbox()`**  
   - Selects all the checkboxes for all ToDo items.

5. **`ClearCompletedTodoItems()`**  
   - Clicks the "Clear Completed" button to clear all completed tasks.

6. **`ClearCompletedDisable()`**  
   - Validates that the "Clear Completed" button is disabled when no items are selected.

7. **`InvalidInput()`**  
   - Attempts to add invalid characters (alphanumeric and special symbols) to the ToDo list.
   - Checks that the input is limited to a specific character limit (21 characters in this case).

8. **`AddSingleChar()`**  
   - Adds a single character to the ToDo list and verifies that it is not accepted.

### Test Class (`ToDo_Test.java`)
The **Test Class** initializes the WebDriver, interacts with the Page Object class, and defines the order of execution for the test cases.

#### Methods in `ToDo_Test.java`

1. **`setUp()`**  
   - Initializes the ChromeDriver and maximizes the browser window.
   - Instantiates the `ToDo_Page` class to access page methods.

2. **`openUrl()`**  
   - Opens the ToDo web app by calling the `openWebApp()` method from the `ToDo_Page` class.

3. **`ToAddSingleChar()`**  
   - Tests the negative scenario where a single character is added to the ToDo list and ensures it is rejected.

4. **`inValidItemEntry()`**  
   - Tests adding invalid entries to the ToDo list (alphanumeric characters, special symbols).
   - Validates that inputs exceeding the character limit are handled correctly.

5. **`AddingValidItemEntry()`**  
   - Tests adding valid items to the ToDo list and verifies their presence in the list.

6. **`ClearCompletedVerify()`**  
   - Verifies that the "Clear Completed" button is disabled when no items are selected.

7. **`SelectSingleCheckBox()`**  
   - Tests selecting the checkbox for a single ToDo item.

8. **`SelectAllCheckBox()`**  
   - Tests selecting checkboxes for all ToDo items.

9. **`ClearCompleted()`**  
   - Tests the functionality of the "Clear Completed" button to clear all completed ToDo items.

10. **`tearDown()`**  
    - Closes the browser and quits the WebDriver after all tests are completed.

### Test Reporting
- **TestNG Reporter**: The `Reporter.log()` method is used throughout the test cases to log important actions in the console output. For example, whenever a ToDo item is added, a checkbox is selected, or the "Clear Completed" button is clicked, the actions are logged for better traceability.
- **Console Output**: All logs are displayed in the console while the tests are running, providing real-time feedback for each action performed during test execution.

#### Example Console Logs:
```
Todo item 1 has been added.
Todo item 2 has been added.
The 'Clear Completed' button is disabled.
Single checkbox has been selected.
```

### Test Reporting and Failure Handling
- If any assertion fails, TestNG marks the test as failed and logs the stack trace. A detailed report is generated at the end of the test run, which provides an overview of passed, failed, and skipped tests.
- The **TestNG HTML Report** is automatically generated, summarizing all executed tests, making it easy to debug and analyze test results.

## Test Execution Flow
1. **Positive Test Scenarios**:
   - Adding valid ToDo items to the list.
   - Selecting checkboxes for individual or all ToDo items.
   - Clearing completed tasks.

2. **Negative Test Scenarios**:
   - Attempting to add invalid ToDo items (alphanumeric values, special characters).
   - Adding a single character (which is not accepted as a valid ToDo item).
   - Verifying that the "Clear Completed" button remains disabled if no tasks are selected.

3. **Character Limit Testing**:
   - Validating that the input field enforces a specific character limit when adding ToDo items.

### How to Run the Tests
1. Ensure you have **Java**, **Maven**, and **Selenium WebDriver** installed on your machine.
2. Download or clone this project to your local machine.
3. Place the ChromeDriver executable in the `Drivers` directory.
4. Open the project in your preferred IDE (such as IntelliJ or Eclipse).
5. Execute the test by using TestNG Runner
  

6. After the tests have executed, you can view the detailed HTML report generated by TestNG in the `test-output` directory.

## Prerequisites
- **Java 8 or higher** is required.
- **Maven** is used to manage dependencies and execute tests.
- **Selenium WebDriver**: Ensure ChromeDriver is installed and set up correctly.
- **TestNG**: The TestNG library is necessary to execute the test cases and generate reports.

## Conclusion
This test suite is designed with the **Page Object Model (POM)** pattern to ensure clean separation between the page interactions and test logic. It covers a wide range of both positive and negative test cases to ensure that the ToDo web application works as expected. Test results and logs are captured in real-time for easy debugging, and a comprehensive HTML report is generated after each test execution. This ensures that testing is scalable, maintainable, and easy to understand.

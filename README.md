# README for ToDo Application Automation Test Suite

## Overview
This repository contains an automated test suite designed to test the functionality of a "ToDo" web application using **Selenium WebDriver** and **TestNG** framework. The test suite is built using the **Page Object Model (POM)** design pattern to ensure the separation of concerns, scalability, and maintainability of the test code.

### What is Being Tested?
This test suite automates both **positive** and **negative** scenarios for the ToDo application. It covers the following features:
- Adding valid and invalid ToDo items.
- Selecting individual or all ToDo items using checkboxes.
- Clearing completed ToDo items.
- Verifying that invalid inputs (such as alphanumeric characters and special symbols) are not accepted.
- Ensuring proper limits on the number of characters in the input field.
- Validating that the "Clear Completed" button is disabled when no items are selected.

## Patterns and Approaches Used

### Page Object Model (POM)
- The **Page Object Model (POM)** pattern is employed in this project to maintain separation between the test logic and the interactions with the web elements. Each page of the ToDo application is represented as a separate Java class containing web elements and associated actions that can be performed on the page.
- The benefit of this approach is that the test cases become more readable, reusable, and easy to maintain. If any changes occur in the UI, only the page class needs to be updated without affecting the test logic.

### TestNG Framework
- **TestNG** is used for test execution, reporting, and organizing tests. It provides annotations like `@BeforeClass`, `@Test`, and `@AfterClass` for structuring the tests and test initialization.
- **Assertions** are used to verify the actual behavior of the application against expected results.
- The **priority** attribute of the `@Test` annotation is used to control the order of execution for different test scenarios.

## Test Organization

### Page Class (`ToDo_Page.java`)
The **Page Class** is where the interaction with the UI elements happens. In this case, the `ToDo_Page.java` file defines web elements and methods that simulate user interactions with the ToDo application.
- **Web Elements**: These are located using `@FindBy` annotations to find elements like text boxes, buttons, and checkboxes.
- **Actions**: Methods in this class perform actions like adding ToDo items, selecting checkboxes, and clearing completed tasks.

#### Example Methods in `ToDo_Page.java`:
- `openWebApp()`: Opens the ToDo app in a browser.
- `AddingValidTodoEntry()`: Adds valid ToDo items to the list.
- `SelectSingleCheckbox()`: Selects the checkbox of a single ToDo item.
- `InvalidInput()`: Tests invalid inputs, like alphanumeric and special characters.
- `AddSingleChar()`: Validates that a single character cannot be added as a ToDo item.
- `ClearCompletedDisable()`: Verifies that the "Clear Completed" button is disabled if no items are selected.

### Test Class (`ToDo_Test.java`)
The **Test Class** defines the actual test cases using **TestNG**. This class initializes the WebDriver, invokes methods from the page class, and organizes the test flow.
- Tests are grouped by functionality (adding ToDo items, validating invalid inputs, selecting checkboxes, etc.).
- Tests are prioritized to ensure a logical flow of execution (e.g., opening the app is the first test).

#### Example Test Methods in `ToDo_Test.java`:
- `openUrl()`: Opens the ToDo app.
- `ToAddSingleChar()`: Tests the negative scenario where a single character is added.
- `inValidItemEntry()`: Tests the addition of invalid characters and checks for input limits.
- `AddingValidItemEntry()`: Tests adding valid ToDo items.
- `ClearCompletedVerify()`: Validates that the "Clear Completed" button is disabled for unselected items.

### Reporting Mechanism
- **TestNG Reporter**: TestNG’s `Reporter.log()` method is used extensively throughout the test cases to log important events and steps in the console output. It provides detailed logs about what actions were performed (e.g., adding ToDo items, selecting checkboxes, clicking buttons, etc.).
- **Console Output**: Logs are printed on the console when running the test suite, allowing the tester to monitor progress and failures in real-time.

#### Example Console Logs:
```
Todo item 1 has been added.
Single checkbox has been selected.
The 'Clear Completed' button is disabled.
```

### Reporting Test Failures
- The TestNG framework automatically generates an HTML report after the execution of the test suite. It shows the results of each test, including the total number of tests run, passed tests, and failed tests.
- If any assertion fails, TestNG logs the stack trace and marks the test as failed in the report.

### How Tests Are Organized
1. **Positive Test Scenarios**:
   - Add valid ToDo items to the list.
   - Select individual or all checkboxes.
   - Clear completed tasks.
   
2. **Negative Test Scenarios**:
   - Add invalid ToDo items (alphanumeric/special characters).
   - Add a single character (should not be accepted).
   - Verify if the "Clear Completed" button remains disabled without item selection.
   
3. **Character Limit Testing**:
   - Tests whether the ToDo input box enforces a character limit.

### Important Files:
- **`ToDo_Page.java`**: Contains web elements and actions for interacting with the ToDo application.
- **`ToDo_Test.java`**: Contains test cases for different scenarios.
- **TestNG Configuration**: Test cases are executed based on the priorities set in the `@Test` annotations.

## Pre-requisites for Running the Test Suite
1. **Java 8 or higher** installed on the machine.
2. **Maven**: Ensure Maven is installed and configured for dependencies.
3. **Selenium WebDriver**: ChromeDriver should be downloaded and placed in the `Drivers` folder.
4. **TestNG**: The TestNG library should be included in the project dependencies.

### Running the Tests:
1. Clone or download the project.
2. Ensure the ChromeDriver path is correctly set in the `setUp()` method in the `ToDo_Test.java` file.
3. Use the following Maven command to execute the test suite:
   ```bash
   mvn test
   ```
4. After the test execution, the TestNG report will be generated automatically, providing a summary of all tests executed.

## Conclusion
This test suite provides comprehensive coverage of the core functionalities of the ToDo application using a clean and maintainable Page Object Model structure. It ensures both positive and negative scenarios are validated, making it robust and reliable for automation testing. The reporting and console logging features offer easy monitoring and debugging during test execution.

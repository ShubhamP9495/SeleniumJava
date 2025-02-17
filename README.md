# README for Gravity Asiignment Automation Test Suite

#Find the files with below location
**src/main/java/test**
Page class and the test class for Rest assured and selenium java.

## Overview
This repository contains an automated test suite designed to validate the functionality of a **Gravity** Assignment

### What is Being Tested?
The test suite covers both **positive** and **negative** test cases for different functionalities in the ToDo app, including:
- Added login page webelemtnts and naviget for login. (used safaridriver and chromedriver)
- Added post api test method in test class (RestAssured)
- added mobile test method (which will only support for appium tool)

## Patterns and Approaches Used

### Page Object Model (POM)
The **Page Object Model (POM)** pattern is implemented in this project to create a layer between the test logic and the web elements. This separation improves test code maintainability, scalability, and readability. Changes in the web page's structure will only require updates in the Page Object classes without altering the test cases.

### TestNG Framework
- **TestNG** provides annotations like `@BeforeClass`, `@Test`, and `@AfterClass` for structuring and executing the test cases.
- Tests are organized using **priority** to manage the order of execution, and **assertions** are employed to validate the application's behavior.
- Detailed reporting is enabled using `Reporter.log()` for debugging and result verification.

## Test Organization

### Page Class (`login_Page.java`)
The **Page Class** encapsulates the web elements and actions performed on the ToDo application page. It defines the interactions like adding tasks, selecting checkboxes, and clearing completed tasks.


- **TestNG Reporter**: The `Reporter.log()` method is used throughout the test cases to log important actions in the console output. For example, whenever a ToDo item is added, a checkbox is selected, or the "Clear Completed" button is clicked, the actions are logged for better traceability.
- **Console Output**: All logs are displayed in the console while the tests are running, providing real-time feedback for each action performed during test execution.


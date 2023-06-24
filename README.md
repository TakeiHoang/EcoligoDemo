# EcoligoDemo - Brief Explanation
# [Test Planning]
- **Test Case Identification**: Identify the test cases based on the user registration form requirements and functionality.
- **Test Case Design**: Design each test case with a specific objective and set of steps to follow. Include test data for different input combinations and expected outcomes.
- **Test Script Implementation**: Implement the test scripts using Selenium Java. Write the code to interact with the user registration form, enter data, submit the form, and verify the expected outcomes.
- **Assertions**: Choose appropriate assertions to validate the expected behavior of the user registration form to make sure test cases meet expectation.
- **Reporting and Defect Tracking**: Capture the test execution results, including any failures or issues encountered during the testing process.
# [Framework / Tools]
- IntelliJ: To run Java Maven (Not recommend using Eclipse as it's not really compatiable with IntelliJ Community).
- Selenium + TestNG: Automation framework using Java which TestNG support more annotation.
- Jackson-databind: Serilize / Deserilize json to model object.
- Browser WebDriver: W3C Webdriver to control action to the browser.
- AssertJ: Using for assertion (Fluent Assertion for Java).
- ExtentReport: HTML report after run test.

# [Project Folder Structure]
```
_____________________________________________________________
EcoligoDemo (Project)
├─ Challenge Document [[Contain challenge 1 & 2 answer]]
│   └─ Challenge 1
│   └─ Challenge 2
├─ src
│   └─ test
│       ├─ java
│       │      ├─ core
│       │      │      ├─ browser
│       │      │      │       └─ driver
│       │      │      ├─ helper
│       │      │      ├─ model
│       │      ├─ pages
│       │      └─ tests
│       │             └─ data
│       └─ resources
│              └─ driver
├─ pom.xml
└─ test.properties
_____________________________________________________________
```

# [Testing Approach / Pattern]
- **ATDD**: Acceptance Test Driven Develpoment - A test approach to use Acceptance Criteria to write test scripts 
- **Browser Factory**: For creating and managing instances of web browsers (e.g., Chrome, Firefox, Safari) during test execution. The Browser Factory handles the setup and configuration of the browser instances, such as setting browser options, managing browser profiles, and launching the browsers
- **POM - Page Object Model**: To enhance the maintainability and reusability of automated tests. It can helps to organize and structure test code by separating the test logic from the underlying web page structure.
- **Factory Design Pattern** (Small part applied with Browser Factory): provides an interface for creating objects without specifying their concrete classes. The Factory pattern encapsulates the object instantiation logic
- **Data Driven Testing**: Can make test cases are executed multiple times with different sets of test data, allowing for increased coverage and the ability to test different scenarios.

# [Choice Of Assertion]
- **Successful Registration**: Assert that a successful registration message or confirmation page is displayed after submitting the registration form with valid inputs.
- **Error Messages**: Assert that appropriate error messages are displayed when invalid inputs are provided, such as a username already in use, an invalid email format, or password mismatch.
- **Password Strength Validation**: If there are specific password strength requirements, assert that the form enforces these requirements and displays appropriate messages when the password does not meet the criteria.
- **Mandatory Field Validation**: Assert that the form properly validates and displays error messages for any mandatory fields that are left blank.
- **Field Validation**: Validate specific field-level requirements, such as minimum and maximum length for the username or email field.
- **Unique Username/Email Validation**: If the system requires unique usernames or emails, assert that the form checks for duplicate entries and displays an appropriate error message.

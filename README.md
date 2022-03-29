# Web Automation for List.am
The project is created to demonstrate List.am automation.

## Tools/Frameworks
- https://docs.qameta.io/allure/ - Test reporter for executed test results

## Test Execution
### Precondition
Clean and build the project, run the command:
`mvn install`

# Report analyzing
To see the test execution results using allure reporting tool please run the following command once the tests are executed:

    allure generate allure-results --clean && start allure-report/index.html
           
 


@Regression
  Feature: User Registration
    As a new user
    I want to register to the application
    So that I can access my account to do shopping


  Scenario: Successful Registration

    Given I am on the Automation zone page
    And I am a new user
      | username       | email               | password       |
      | Test19Nov12356 | Test02Dec@gmail.com | Password@123#$ |
    And I log out from the application

@Smoke @Regression
Feature: Login to the account
  Scenario Outline: Login with user credentials
    Given I am on the Automation zone page
    When I enter my username "<username>" and password "<password>"
    Then the user "<username>" login in successfully

    Examples:
      | username | password |
      | Test12user | Password@123#$ |

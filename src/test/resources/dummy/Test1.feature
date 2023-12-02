Feature: User Authentication
  As a user
  I want to be able authenticate myself
  So that I can access my account

  Scenario: Successful login
    Given a registered user with user id "Testuser1" and password "Testpassword123"
    When the user enters the credentials and clicks on the submit button
    Then the system should authenticate the user


  Scenario Outline: Login with different credentials
    Given I am registered user with username "<username>" and with password "<password>"

    Examples:
      | username | password |
      | testuser1 | password123 |
      | testuser2 | password1234 |


  Scenario: Test using dataTable
    Given the user is on homepage
      | Adithya | password123 |
      | Anuradha | password@123 |


  Scenario: Test using map
    Given the user entered the creds
      | userid | password |
      | Rohit  | Rohit123 |
      | Gill   | Gill234  |


  Scenario: ReadDatafromJson
    Given the user entered the JSON test data
    """
    {

    "users":[
        {"name":"Jenny", "age":35},
        {"name":"Peter","age":25}
        ]
}
    """
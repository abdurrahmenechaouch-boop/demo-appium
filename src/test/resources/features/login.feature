Feature: Authentication

  As a user
  I want to login to the app
  So that I can access my account

  Scenario Outline: Successful login for multiple users
    Given I am on the login page
    When I login with username "<username>" and password "<password>"
    Then the home page is displayed

    Examples:
      | username         | password    |
      | standard_user    | secret_sauce  |
      | No_existing_user     | secret_sauce  |

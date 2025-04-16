@regression
Feature: login functionality
  Background:
    Given user should be on login page

    @login
  Scenario: TC01_Valid_Login
    When user enter the valid credentials and click on login button
    Then user should be navigated to home page
    And user can see the logout link on right corner

  @invalidlogin @sanity @smoke
  Scenario Outline: TC02_Invalid_login
    When user enter the Invalid credentials username as "<userid>" and password as "<password>" click on login button
    Then user can see the error message on login page
    Examples:
    |userid | password |
    |ad1    | pass1    |
    |ad2    | pass2    |
    |ad3    | pass3    |



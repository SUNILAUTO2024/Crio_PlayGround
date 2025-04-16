@regression
Feature: account functionality
  Background:
    Given user should be on login page

  @account
  Scenario: TC04_create_account_with_mandatory_fields
    When user enter the valid credentials along with theme and click on login button
    Then user should be navigated to home page
    When user enter the mandatories fields on account page and click on save button
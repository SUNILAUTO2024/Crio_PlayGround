@regression  @contact
Feature: contact functionality

  Background:
    Given user should be on login page


  Scenario: TC05_create_contact_with_mandatory_fields

    When user enter the valid credentials along with theme and click on login button
    Then user should be navigated to home page
    When user enters the mandatory fields on Contact page like Last name in String and click on save button
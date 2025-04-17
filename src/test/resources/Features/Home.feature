@regression
Feature: HomePage functionality
  Background:
    Given Opens Home page

  @login
  Scenario: TC01_Verify Home Page details
    When
    Then verify Header and logo
    And check tabs appears and validate titles of each
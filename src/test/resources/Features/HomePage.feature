@Home_Page
Feature: Verify Home Page
  Background:
    Given user should be on Home page


  Scenario: TC_001_Verify Title of Page
    Then Retrieve current url and validate
    Then Retrieve header & Logo and validate
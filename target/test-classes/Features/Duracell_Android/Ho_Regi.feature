@Ho_Regi
Feature: Homeowner Registration and Verification Functionality
  Background:
    Given Start Appium server
    Given Start Emulator if not started earlier
    Given Launch Duracell application & login page should appeared

  @Valid_Regi
  Scenario: TC01_Verify regi. Battery new site by Installer with unique data

    When user enter the valid credentials of installer and click on login button
    And user navigates to Battery regi. page new site from installer home page
    When user enter all unique values for Battery regi. and click Submit button
    Then Succesfully registred pop-up should appeared and clicked ok
    Then User navigates to Installer home page and click logout

    Scenario: TC02_Verify newly registered Battery in installation list by Duracell user
      When user enter the valid credentials of Duracell and click on login button
      And user navigates to installation_list page
      When user search latest registered Ho's Product id in list
      Then user validate details like Name and product id appeared in search result
      Then User click on installation box
      And validated Live usage page title
      Then Navigates to Schedule control page, validate title, submit disabled
      And validated Green report page title and click logout

      @QR_Scanning
Scenario: Check QR code parsing
  When user enter the valid credentials of installer and click on login button
  And user navigates to Battery regi. page new site from installer home page
  And scan QR code




      @tap_touch
  Scenario: TC03_Verify single and double tapping and single and multiple touch sequence
    When user enter the valid credentials of Ho and click on login button
    And validated Live usage page title
        Then Click on energy summary page from menu, click on calender box
        And then select date as 15 April 2023 and confirm it
        




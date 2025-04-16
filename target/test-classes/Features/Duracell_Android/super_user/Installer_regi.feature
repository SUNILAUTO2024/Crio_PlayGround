@installer_regi
Feature: Installer registration
  Background:
    Given Start Appium server
    Given Start Emulator if not started earlier
    Given Launch Duracell application & login page should appeared

  @i_regi
  Scenario: TC_28_Verify installer regi with invalid inputs

    Given user enter the valid credentials S_User and click on login button
    And User navigate to Installer regi page
    When user click submit button without data
    Then verify error message
    When user enter invalid name - Submit & verify error for invalid Name
    When user enter invalid name - Submit & verify error for Name start with number
    When user enter valid name,keep company code blank - click Submit
    Then verify error code for empty company code and exit error msg
    When user enter valid name,enter invalid company code & click Submit
    Then verify error code for invalid company code and exit error msg
    When verify error code for invalid company code-8 char and exit error msg
    Then verify error code for invalid company code and exit error msg
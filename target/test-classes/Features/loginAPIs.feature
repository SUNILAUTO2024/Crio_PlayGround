@regression @re
Feature: Test Login endpoint

  @api_dc
  Scenario Outline::TC_01_Check login with invalid username & invalid password
    Given endpoint "https://duracell-cloud-appservice-testing.azurewebsites.net/api/membership/authenticate"
    And user send the post request with "<userid>" and "<password>"
    Then status code should equal to 200
    Then user validate response
    Examples:
      |userid | password |
      |ad1    | pass1    |

  @api_dc
  Scenario Outline::TC_02_Check login with invalid username & invalid password
    Given endpoint "https://duracell-cloud-appservice-testing.azurewebsites.net/api/membership/authenticate"
    And user send the post request with "<userid>" and "<password>"
    Then status code should equal to 200
    Then user validate response for invalid userName

    Examples:
      |userid | password |
      |1ad1    | pass1    |
  @api_dc2
  Scenario Outline::TC_03_Check login with valid username & invalid password
    Given endpoint "https://duracell-cloud-appservice-testing.azurewebsites.net/api/membership/authenticate"
    And user send the post request with "<userid>" and "<password>"
    Then status code should equal to 200
    Then user validate response for invalid password

    Examples:
      |userid | password |
      |CETZ    | @1234    |



  @valid_login_API @re
  Scenario Outline::TC_07_Check login with valid username & valid password
    Given endpoint "https://duracell-cloud-appservice-testing.azurewebsites.net/api/membership/authenticate"
    And user send the post request with "<userid>" and "<password>"
    Then status code should equal to 200
    Then user validate response body

    Examples:
      |userid  | password        |
      |SATZ    | Duracell@123    |

    @API_login @Pd_endpoint
    Scenario: TC01_Valid_Login by Duracell user
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok
      Then user validate response body for Duracell user details

  @API_login  @Pd_endpoint
  Scenario: TC02_Valid_Login by Installer user
    Given login endpoint as string
    When user send the post request with uid and pswd
    And status code must equal to 200 ok
    Then user validate response body for Installer user details

  @API_login  @Pd_endpoint
  Scenario: TC03_Valid_Login by HomeOwner user
    Given login endpoint as string
    When user send the post request with uid and pswd
    And status code must equal to 200 ok
    Then user validate response body for HomeOwner user details

  @API_login  @Pd_endpoint
  Scenario: TC04_Valid_Login by API user
    Given login endpoint as string
    When user send the post request with uid and pswd
    And status code must equal to 200 ok
    Then user validate response body for API user details

@API_login @invalid_log  @Pd_endpoint
  Scenario:TC05_Invalid_login invalid userName invalid password
    Given login endpoint as string
    And user send the post request with uid and pswd
  And status code should equal to 200 ok
    Then user validate response body for invalid uID and pwd login

  @locking  @Pd_endpoint
  Scenario Outline::TC_06_Check login with valid username & invalid password for 4 times
    Given endpoint "https://duracell-cloud-appservice-testing.azurewebsites.net/api/membership/authenticate"
    And user send the post request with "<userid>" and "<password>"
    And status code must equal to 200 ok
    Then user validate response for invalid password

    Examples:
      |userid  | password |
      |HOSA    |  pass1   |
      |HOSA    |  11121   |
      |HOSA    |  dss21   |
      |HOSA    |  vd2s    |

  @locking  @Pd_endpoint
  Scenario Outline::TC_07_Check login with valid username & invalid password for 5th times
    Given endpoint "https://duracell-cloud-appservice-testing.azurewebsites.net/api/membership/authenticate"
    And user send the post request with "<userid>" and "<password>"
    And status code must equal to 200 ok
    Then user validate response for locked account due to 5 successive attempts

    Examples:
      |userid  | password |
      |HOSA    | ee       |

  @locking  @Pd_endpoint
  Scenario Outline::TC_08_Check login with valid username & valid password for 6th times post account locked
    Given endpoint "https://duracell-cloud-appservice-testing.azurewebsites.net/api/membership/authenticate"
    And user send the post request with "<userid>" and "<password>"
    And status code must equal to 200 ok
    Then user validate response for locked account due to 5 successive attempts

    Examples:
      |userid  | password        |
      |HOSA    | Duracell@123    |
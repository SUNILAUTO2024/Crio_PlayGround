@Battery_regi
Feature: Battery registration

  @testa
  Scenario: Base case login by installer and store token
    Given login endpoint as string
    When user send the post request with uid and psd & set endpoints
    And validate status code of response
    When Set token Global

@f11
  Scenario: TC_21_Validate Battery Registration new site endpoint with Blank product by Installer user

    Then send Post request with Blank product & valid token
    And validate status code of response
    And validate response for Blank product
@f22
  Scenario: TC_22_Validate Battery Registration new site endpoint with space as a product by Installer user
    Then send Post request with space as a product & valid token
    And validate status code of response
    And validate response for Blank product

  Scenario: TC_23_Validate Battery Registration new site endpoint with space in a product by Installer user
    Then send Post request with space in a product & valid token
    And validate status code of response
    And validate response for space in product
  @testa
  Scenario: TC_24_Validate Battery Registration new site with all unique values
    Then send Post request with unique values & valid token
    And validate status code of response
    And validate response for all unique values

  Scenario: TC_25_Validate Battery Registration new site with duplicate Product id values
    Then send Post request with duplicate Product id & valid token
    And validate status code of response
    And validate response with duplicate Product id

  Scenario: TC_26_Validate Battery Registration new site with duplicate Name values
    Then send Post request with duplicate Name & valid token
    And validate status code of response
    And validate response with duplicate name
@testa
    Scenario: TC_27_Verify recently registered Battery in installation list
      Then search Post request with recently regi. product id in list endpoint
      And validate status code of response
      And validate details in response of search result and set installation id global

  Scenario: TC_28_Register Ev1 on existing site
    Then send Post request with unique values & to register EV1
    And validate status code of response
    And validate response for all unique values

  Scenario: TC_29_Validate Ev1 Registration existing site with duplicate Product id values
    Then send Post request with duplicate Product id & valid token
    And validate status code of response
    And validate response with duplicate Product id

  Scenario: TC_30_Validate Ev1 Registration existing site with duplicate Name values
    Then send Post request with duplicate Name & valid token
    And validate status code of response
    And validate response with duplicate name

  Scenario: TC_29_Verify recently registered EV1 in installation list
    Then search Post request with recently regi. product ids in list endpoint
    And validate status code of response
    And validate details in response of search result and set installation id global

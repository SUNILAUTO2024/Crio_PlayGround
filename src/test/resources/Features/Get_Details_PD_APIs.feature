@Get_API @Regression
  Feature: Validate Installer List endpoint details PD_APIs

    Scenario: TC_09_Validate Get Installer List endpoint by DC user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      Then user validate response body for Duracell user details
      When Set token Global and endpoint for installer list
      Then send Get request with valid token
      And validate status code
      And validate response

    Scenario: TC_10_Validate Get Installer List endpoint by installer user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for installer list
      Then send Get request with valid token
      And validate status code
      And validate response for invalid user role

    Scenario:TC_11_Validate Get Installer List endpoint by HO user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for installer list
      Then send Get request with valid token
      And validate status code
      And validate response for invalid user role

    Scenario:TC_12_Validate Get Installer List endpoint by API user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for installer list
      Then send Get request with valid token
      And validate status code
      And validate response for invalid user role



  @Language
    Scenario: TC_13_Validate Get Language List endpoint by DC user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for Language list
      Then send Get request with valid token
      And validate status code
      And validate response for Language list

    @Language
    Scenario: TC_14_Validate Get Language List endpoint by Installer user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for Language list
      Then send Get request with valid token
      And validate status code
      And validate response for Language list

    @Language
    Scenario: TC_15_Validate Get Language List endpoint by Ho user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for Language list
      Then send Get request with valid token
      And validate status code
      And validate response for Language list

    @Language
    Scenario: TC_16_Validate Get Language List endpoint by API user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for Language list
      Then send Get request with valid token
      And validate status code
      And validate response for Language list

    @TZ
    Scenario: TC_17_Validate Time Zone List endpoint by DC user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for TZ list
      Then send Get request with valid token
      And validate status code
      And validate response for invalid user role

    @TZ
    Scenario: TC_18_Validate Time Zone List endpoint by Installer user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for TZ list
      Then send Get request with valid token
      And validate status code
      And validate response for Time Zone list

    @TZ
    Scenario: TC_19_Validate Time Zone List endpoint by Ho user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for TZ list
      Then send Get request with valid token
      And validate status code
      And validate response for invalid user role

    @TZ
    Scenario: TC_20_Validate Time Zone List endpoint by API user token
      Given login endpoint as string
      When user send the post request with uid and pswd
      And status code must equal to 200 ok post login
      When Set token Global and endpoint for TZ list
      Then send Get request with valid token
      And validate status code
      And validate response for invalid user role


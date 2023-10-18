Feature : Login Page aplikasi saucedemo

  Scenario: Test Login
    Given Halaman login saucedemo
    When Input username
    And Input Password
    And Click login button
    Then User in products page

  Scenario Outline: Failed login
    Given Halaman login saucedemo
    When Input username
    And Input invalid Password
    And Click login button
    Then User get error message

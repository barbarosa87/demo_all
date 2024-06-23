Feature: test feature


  Scenario: User performs login
    Given User opens the webpage
    And User "standard_user" logins
    Then User is logged in

  Scenario: User performs login with locked out user
    Given User opens the webpage
    And User "locked_out_user" logins
    Then User receives error

  Scenario: User verifies burger menu
    Given User opens the webpage
    And User "standard_user" logins
    Then User checks burger menu items order "All Items,About,Logout,Reset App State"


  Scenario: User verifies products page
    Given User opens the webpage
    And User "standard_user" logins
    Then Verifies product page is displayed correctly


  Scenario: User can add product to cart
    Given User opens the webpage
    And User "standard_user" logins
    Then User adds "Sauce Labs Backpack" to cart
    And cart icon has the number "1"


  Scenario: User checkout product
    Given User opens the webpage
    And User "standard_user" logins
    And User adds "Sauce Labs Bike Light" to cart
    And cart icon has the number "1"
    And User goes to cart
    Then User checkouts product with fname "dasdasda" lname "asdasda" pcode "12345"
    And User procceeds with checkout overview
    And Checkout completes successfully


  Scenario: User checkout product with no data
    Given User opens the webpage
    And User "standard_user" logins
    And User adds "Sauce Labs Bike Light" to cart
    And cart icon has the number "1"
    And User goes to cart
    Then User checkouts product with fname "" lname "" pcode ""
    And Checkout has an error at information provide page
Feature: Hats
Description: The user adds items to the cart

  Scenario: User adds two hats for men
    Given the user is on the website
    When the user searches for 'two hats for men'
    And selects the first 'hat for men'
    And adds 2 to the cart
    Then the expected cost should be correct

  Scenario: User adds one hat for women
    Given the user is on the website
    When the user searches for 'two hats for women'
    And selects the first 'hat for women'
    And adds 1 to the cart
    Then the expected cost should be correct

  Scenario: User removes one hat for men
    Given the user is on the website
    When the user selects the 'hats for men' from the cart
    And removes 1 from the cart
    Then the expected cost should be correct


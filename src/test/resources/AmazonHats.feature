Feature: Amazon Harts
Description: The user adds items to the cart

  Scenario: User adds different items to the cart
    Given the user is on the website
    When the user searches for 'hats for men'
    And selects the first 'hats for men'
    And adds 2 to the cart
    Then the expected cost should be correct
    When the user searches for 'hats for women'
    And selects the first 'hats for women'
    And adds 1 to the cart
    Then the expected cost should be correct
    When the user removes 1 'hats for men' from the cart
    Then the expected cost should be correct


Feature: Verify an item can be created

  @addItem @apiTest
  Scenario Outline: Verify an item can be created
    Given an item is created with the following data
      | name   | cpuModel   | price   |
      | <name> | <cpuModel> | <price> |
    When the request to add the item is made
    Then a 200 response code is returned
    And verify an item "<name>" is created
    And verify CPU model is "<cpuModel>"
    And verify price model is "<price>"

    Examples:
      | name                 | cpuModel      | price   |
      | Apple MacBook Pro 15 | Intel Core i9 | 1849.99 |
      |                      | Intel Core i9 | 1999.99 |



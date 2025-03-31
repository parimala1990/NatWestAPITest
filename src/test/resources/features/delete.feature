Feature: Verify single or all items can be created

  Background: Verify an item can be created
    Given an item is created with the following data
      | name        | cpuModel           | price   |
      | ThinkPad X1 | Intel Core Ultra 7 | 2449.99 |
    And the request to add the item is made
    And a 200 response code is returned
    And verify an item "ThinkPad X1" is created

  @deleteItem @apiTest
  Scenario: Verify an item can be deleted based on the id
    When the request to delete an item with the id is made
    Then a 200 response code is returned
    And verify delete message is returned

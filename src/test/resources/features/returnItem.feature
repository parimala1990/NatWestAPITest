Feature: Verify single or all items can be created

@returnAnItem @apiTest
  Scenario: Verify an item can be returned
    Given an id for item is 7
    When the request to get the item is made
    Then a 200 response code is returned
    And an item is returned with the following data
    | name                 | cpuModel      | price   |
    | Apple MacBook Pro 16 | Intel Core i9 | 1849.99 |

  @returnAllTheItems @apiTest
  Scenario: Verify list of all the items can be returned
    When the request to get all the items is made
    Then a 200 response code is returned
    And list of items are returned

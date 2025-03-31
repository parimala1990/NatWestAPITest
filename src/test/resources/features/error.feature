Feature: Verify error scenarios

  @error_01 @apiTest
  Scenario: Verify error when getting a deleted item
    Given an item is created with the following data
      | name     | cpuModel | price   |
      | TempItem | Test CPU | 1098.55 |
    And the request to add the item is made
    And the request to delete an item with the id is made
    When the request to get the item is made
    Then a 404 response code is returned

  @error_02 @apiTest
  Scenario: Verify deleting a non-existent item returns error
    Given an id for item is 999999999
    When the request to delete an item with the id is made
    Then a 404 response code is returned

  @error_03 @apiTest
  Scenario: Verify error when getting a deleted item
    Given an item is created with no payload
    Then a 400 response code is returned




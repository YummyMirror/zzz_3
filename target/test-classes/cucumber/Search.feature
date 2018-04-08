Feature: Google manipulations

  Scenario: Valid search
    Given I open google search
    When I enter search query:
      | query     |
      | webDriver |
    And I click the search button
    Then I check that search is performed
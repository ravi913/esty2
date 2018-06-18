Feature: search for item
  Scenario: search for shoes
    Given open url "https://www.etsy.com/uk/"
    And enter "sport shoes" in search bar
    When search is sorted by price Highest
    Then print the prices of top 10 items
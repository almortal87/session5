Feature: Google Search

  Scenario: User searches for Selenium WebDriver on Google
    Given the user is on the Google search page
    When the user searches for "Selenium WebDriver"
    Then the search results are displayed
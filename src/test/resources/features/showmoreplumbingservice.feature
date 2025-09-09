Feature: Explore Plumbing Service Options

  Scenario: User views and expands multiple plumbing service categories
    Given the user logs in successfully with valid credentials
    And the user navigates to the plumbing services section
    When the user scrolls through the available plumbing services
    And the user clicks on "Show More" for a selected service
    Then the service description and pricing details should be displayed

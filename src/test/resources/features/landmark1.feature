
Feature: Home Page Search and Navigation
Scenario Outline: Missing landmark
    Given the user selects location "<location>"
    And leaves the landmark field blank
    And clicks on search button
   

    Examples:
      | location |
      | Bangalore   |
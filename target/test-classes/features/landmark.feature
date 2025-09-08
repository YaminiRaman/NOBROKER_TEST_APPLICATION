Feature: Home Page Search and Navigation

  @home
  Scenario Outline: Mismatch location–landmark combination
    Given the user selects location "<location>"
    And enters landmark "<landmark>"
    And clicks on search button
    Then an error message should be displayed

    Examples:
      | location | landmark  |
      | Mumbai   | Velachery |

  @home
  Scenario Outline: Missing landmark
    Given the user selects location "<location>"
    And leaves the landmark field blank
    And clicks on search button
    Then an error message should be displayed

    Examples:
      | location |
      | Mumbai   |

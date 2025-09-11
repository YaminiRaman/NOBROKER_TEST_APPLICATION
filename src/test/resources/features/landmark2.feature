Feature: Home Page Search and Navigation
 Scenario: View previous searches after new search
   Given the user selects location "<location>"
    And enters landmark "<landmark>"
    And clicks on search button
    And the user returns to the home page
   
    
   Examples:
      | location | landmark  |
      | Bangalore | Velachery |
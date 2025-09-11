Feature: Home Page Search and Navigation

  
  Scenario Outline: Mismatch location–landmark combination
    Given the user selects location "<location>"
    And enters landmark "<landmark>"
    And clicks on search button
    

    Examples:
      | location | landmark  |
      | Mumbai   | Velachery |

  
  Scenario Outline: Missing landmark
    Given the user selects location "<location>"
    And leaves the landmark field blank
    And clicks on search button
   

    Examples:
      | location |
      | Mumbai   |

 
      
  
  Scenario: View previous searches after new search
   Given the user selects location "<location>"
    And enters landmark "<landmark>"
    And clicks on search button
    And the user returns to the home page
   
    
   Examples:
      | location | landmark  |
      | Chennai  | Velachery |
      
Feature: Home cleaning service

  Scenario: Navigate to Full House Cleaning and close website
    
    When the user clicks on the menu button for home
    And the user selects Painting and Cleaning for home
    And the user selects Home Cleaning for home
    And the user selects Full House Cleaning for home
    Then the service page should appear for home
   

Scenario: Navigate to Furnished Villa under Cleaning Services
   
    When the user clicks on the menu button for home
    And the user selects Painting and Cleaning for home
    And the user selects Home Cleaning for home
    And the user selects Full House Cleaning for home
    And the user selects Furnished Villa for home
    Then the service page should appear for home
   
  

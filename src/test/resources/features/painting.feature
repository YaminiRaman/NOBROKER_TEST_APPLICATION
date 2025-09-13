Feature: Painting & Cleaning Services
  As a logged-in user
  I want to navigate to painting and waterproofing services
  So that I can book the required service
#TS-PAINT-007
  Scenario: Navigate to Painting service
   
    When the user opens the main menu for painting
    And the user selects Painting and Cleaning for painting
    And the user selects Painting for painting
  

   Scenario: Navigate to Waterproofing service
  
    When the user opens the main menu for painting
    And the user selects Painting and Cleaning for painting
    And the user selects Painting for painting


  Scenario: Navigate to Painting service and view recent projects
   
    When the user opens the main menu for painting
    And the user selects Painting and Cleaning for painting
    And the user selects Painting for painting
    And the user clicks on See All in recent projects
    


    

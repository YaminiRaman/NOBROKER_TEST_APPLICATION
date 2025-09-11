
Feature: User Login

 Scenario: Login with invalid mobile number 
    Given the user is on the login page
    When the user enters a invalid phone number "<phoneNumber>"
    Then an invalid number message should be shown
    
    Examples:
     | phoneNumber |
     | 7812865    | 



  
    
    
    
    
    
    
    
    
    
    
    

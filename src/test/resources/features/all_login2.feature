
Feature: User Login

 Background:
 Given the user is on the login page
    
    
 Scenario: Login with invalid mobile number 
   
    When the user enters a invalid phone number "<phoneNumber>"
    Then an invalid number message should be shown
    
    Examples:
     | phoneNumber |
     | 7812865    | 

  Scenario: Login with invalid OTP
   
	When the user enters a valid phone number "<phoneNumber>"
	And the user enters the invalid OTP "<otp>"
    Then an invalid otp message should be shown
    
    Examples:
      | phoneNumber | otp  |
      | 8015888674  | 554321 |


  
    
    
    
    
    
    
    
    
    
    
    

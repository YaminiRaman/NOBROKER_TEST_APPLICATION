Feature:User Login
Background:
Given the user is on the login page

Scenario: Login with valid credentials
    
    When the user enters a valid phone number "<phoneNumber>"
	And the user enters the valid OTP
    
    
     Examples:
     | phoneNumber |
     | 8015888674  | 
    
 
 Scenario: OTP Expiry and Resend
   
    When the user enters a valid phone number "<phoneNumber>"
    And waits until the OTP expires and clicks on resend button
    And the user enters the valid OTP
   
    
     Examples:
     | phoneNumber |
     | 8015888674  | 
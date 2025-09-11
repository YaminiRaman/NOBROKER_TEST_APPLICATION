Feature:User Login
Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters a valid phone number "<phoneNumber>"
	And the user enters the valid OTP
    
    
     Examples:
     | phoneNumber |
     | 8015888674  | 
    
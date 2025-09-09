
Feature: User Login

 Scenario: Login with invalid mobile number 
    Given the user is on the login page
    When the user enters a invalid phone number "<phoneNumber>"
    Then an invalid number message should be shown
    
    Examples:
     | phoneNumber |
     | 7812865    | 

  Scenario: Login with invalid OTP
    Given the user is on the login page
	When the user enters a valid phone number "<phoneNumber>"
	And the user enters the invalid OTP "<otp>"
    Then an invalid otp message should be shown
    
    Examples:
      | phoneNumber | otp  |
      | 8015888674  | 554321 |
    
    Scenario: OTP Expiry and Resend
    Given the user is on the login page
    When the user enters a valid phone number "<phoneNumber>"
    And waits until the OTP expires and clicks on resend button
    And the user enters the valid OTP
    Then the user should be logged in successfully
    
     Examples:
     | phoneNumber |
     | 8015888674  | 

  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters a valid phone number "<phoneNumber>"
	And the user enters the valid OTP
    Then the user should be logged in successfully
    
     Examples:
     | phoneNumber |
     | 8015888674  | 
    
    
    
    
    
    
    
    
    
    
    
    

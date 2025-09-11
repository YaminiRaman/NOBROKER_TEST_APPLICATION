 Feature:User Login
 Scenario: OTP Expiry and Resend
    Given the user is on the login page
    When the user enters a valid phone number "<phoneNumber>"
    And waits until the OTP expires and clicks on resend button
    And the user enters the valid OTP
   
    
     Examples:
     | phoneNumber |
     | 8015888674  | 
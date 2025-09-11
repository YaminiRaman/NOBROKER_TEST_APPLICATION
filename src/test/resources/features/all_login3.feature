  Feature:User Login
  Scenario: Login with invalid OTP
    Given the user is on the login page
	When the user enters a valid phone number "<phoneNumber>"
	And the user enters the invalid OTP "<otp>"
    Then an invalid otp message should be shown
    
    Examples:
      | phoneNumber | otp  |
      | 8015888674  | 554321 |
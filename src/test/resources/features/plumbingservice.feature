Feature: Plumbing Services Navigation

  @Scenario1
  Scenario: View plumbing services page
    Given the user logs in with a valid mobile number and OTP
    When the user navigates to the plumbing services "booking page"
    

  @Scenario2
  Scenario: Navigate to a plumbing service booking page
    Given the user logs in with a valid mobile number and OTP
    When the user navigates to the plumbing services "booking page"
    Then the user clicks show more button
   

 
Feature: Plumbing Service Navigation

  Scenario: Plumber Service Book a Plumber
    Given the user logs in with a valid mobile number and OTP for booking
    And the user navigates to plumbing services page for booking
    When the user clicks "Book a Plumber"
   

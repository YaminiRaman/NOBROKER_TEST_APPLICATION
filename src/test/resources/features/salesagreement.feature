Feature: Sales agreement Purchase

  Scenario: Sales Agreement after login
    Given the user logs in with a valid mobile number and OTP for sales
    When the user navigates to Sales Agreement and selects a package
 
    And the browser is closed


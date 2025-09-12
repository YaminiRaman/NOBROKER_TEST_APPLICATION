Feature: Sales agreement Purchase  
Background:
 Given the user logs in with a valid mobile number and OTP for sales
Scenario: Sales Agreement Payment Cancel
   
    When the user navigates to Sales Agreement and selects a package
    And the user clicks on Pay button
    And the user clicks on Back button
    Then the user confirms cancel payment
    And the browser is closed

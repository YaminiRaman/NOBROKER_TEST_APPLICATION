Feature: Access Carpentry Services

  Scenario: User logs in and views carpentry services
     Given the user logs in with a valid mobile number and OTP for carpentry 
    When the user navigates to carpentry services

  Scenario: User selects a carpentry service after login
  Given the user logs in with a valid mobile number and OTP for carpentry 
    When the user navigates to carpentry services
    Then the user selects the first carpentry service

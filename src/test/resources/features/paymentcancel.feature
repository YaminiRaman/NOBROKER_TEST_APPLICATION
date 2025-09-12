Feature: Cancel Payment after Selecting Freedom Plan
Background:
Given the user is logged in for payment cancel 
  Scenario: User cancels the payment after subscribing to Freedom Plan
    
    When the user navigates to Tenant Plans and selects Freedom Plan for view plans
    And the user cancels the payment


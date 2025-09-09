Feature: Cancel Payment after Selecting Freedom Plan

  Scenario: User cancels the payment after subscribing to Freedom Plan
    Given the user is logged in for payment cancel 
    When the user navigates to Tenant Plans and selects Freedom Plan for view plans
    And the user cancels the payment


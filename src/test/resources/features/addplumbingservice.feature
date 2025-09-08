@addService
Feature: Add Plumbing Service
  As a registered user
  I want to select and add a plumbing service
  So that I can book the required service successfully

  Background:
    Given the user logs in with a valid mobile number and OTP for booking
    And the user navigates to plumbing services page for booking

  Scenario: User selects and adds a plumbing service
    When the user selects a plumbing service and clicks add
    Then the selected plumbing service should be added successfully with quantity 2

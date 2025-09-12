Feature: VIP Membership Plans
Background:
Given the user logs in successfully for VIP Plans

  Scenario: Navigate to VIP Membership and Explore Offers
    
    When the user clicks on menu for plans
    And the user selects Painting and Cleaning for plans 
    And the user views VIP membership plans
    And the user clicks on Gift Voucher
    Then the user explores available offers

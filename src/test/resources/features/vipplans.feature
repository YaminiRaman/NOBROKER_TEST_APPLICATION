Feature: VIP Membership Plans
Background:
Given the user logs in successfully for VIP Plans
#TS-VIP-014
  Scenario: Navigate to VIP Membership and Explore Offers
    
    When the user clicks on menu for plans
    And the user selects Painting and Cleaning for plans 
    And the user views VIP membership plans
   

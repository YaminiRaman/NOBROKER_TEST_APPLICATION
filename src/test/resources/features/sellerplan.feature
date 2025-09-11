Feature: Seller Plans Subscription

  Scenario: User subscribes to a seller plan
    Given the user logs in with valid credentials seller plan
    When the user clicks on the main menu seller plan
    And the user navigates to seller plans
    And the user subscribes to a plan
    Then the subscription should be successful

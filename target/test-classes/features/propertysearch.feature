Feature: Property Search on NoBroker

  Scenario: Successful property search by city and locality
    Given the user is on the NoBroker home page
    When the user selects "Chennai" from the city dropdown
    And the user enters "Navalur, Chennai" as the locality
    And the user clicks on the Search button
    Then the property listing page should be displayed
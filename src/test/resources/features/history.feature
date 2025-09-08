Feature:  History - Search history

  Scenario: View previous searches after new search
    Given the user is on the NoBroker home page
    When the user performs a search for "Navalur, Chennai"
    And the user returns to the home page
    Then the previous search "Navalur, Chennai" should appear in search history
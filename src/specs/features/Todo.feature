Feature: Todo Management
  Scenario: Should be able to add a todo
    Given User navigates to login page
    When User logs in
    When User should see welcome message
    When User adds a new todo
    Then Todo should be added
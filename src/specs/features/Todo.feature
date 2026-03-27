Feature: Todo Management
  Scenario: Should be able to add a todo
    Given User is in the todos page
    When User adds a new todo
    Then todo is be added correctly
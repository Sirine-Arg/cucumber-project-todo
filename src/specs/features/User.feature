Feature: User Feature
  Scenario: User should be able to login
    Given User is at the login page
    When User fills the email and the password and press login button
    Then User is redirected to homepage and a welcome message is displayed
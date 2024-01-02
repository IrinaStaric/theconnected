Feature: Account Registration

  Background:   Open Home Page
    Given I open the home page "https://theconnectedshop.com/"
    When Close cookie popup
    When I'm clicking on the account link
    When I'm clicking on Create one link


  Scenario: User fills in valid registration details
    Given The user is on the registration page
    When the user fills in the following valid registration details:
      | First Name | Last Name | Email                 | Password   |
      | John       | Doe       | john.doe@example.com  | secret123  |
    And the user clicks on the submit button
    Then the user should be successfully registered
    #And the user should be redirected to the account dashboard

  Scenario: User attempts to register with existing email
    Given The user is on the registration page
    When the user fills in the following registration details:
      | First Name | Last Name | Email                | Password  |
      | Jane       | Smith     | john.doe@example.com | secret456 |
    And the user clicks on the submit button
    Then the user should see an error message indicating email already exists
    #And the user remains on the registration page


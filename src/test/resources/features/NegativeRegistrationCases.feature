Feature: Invalid values in the Registration Field
  Background:   Open Home Page
    Given I open the home page "https://theconnectedshop.com/"
    When Close cookie popup
    When I'm clicking on the account link
    When I'm clicking on Create one link

Scenario: User fills invalid registration details
    Given The user is on the registration page
    When the user fills in the following invalid registration details
      | First Name | Last Name | Email    | Password   |
      | John       | Doe       | 123@123  | 123  |
   And the user clicks on the submit button
   Then the user should see the warning message
   Then Close the browser

  Scenario: The user fills in the registration details using empty values
   Given The user is on the registration page
    And  the user fills in the following empty registration details
      | First Name | Last Name | Email    | Password   |
      |            |           |          |            |
    And the user clicks on the submit button
    Then the user should see the warning message
    Then Close the browser



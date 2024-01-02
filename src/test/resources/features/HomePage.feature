Feature: Home page elements

  Scenario:    Open Home Page
    Given I open the home page "https://theconnectedshop.com/"
    When Close cookie popup
    When Close subscribe popup
    When I'm clicking on the account link
    When I'm clicking on Create one link
    Then Close the browser


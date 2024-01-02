Feature: Selecting the First Smart Doors on The Connected Shop

  Scenario: User selects the first smart doors listed on the website
    Given   The user is on the page "https://theconnectedshop.com/"
    And     The user scrolls down the page a bit
    And     The user should click ok to skip popup
    When    The user selects the first smart doors
    Then    The user should see details of the selected smart doors
    Then    Close the browser

  Scenario: User writing a review on the Web Site
    Given   The user is on the product page "https://theconnectedshop.com/products/smart-door-lock-slim"
    And     The user should click ok to skip popup
    And     The user scrolls down the page to the review section
    Then    The user checks whether the reviews section is visible
    And     The user click on the write a review button
    Then    The user clicks to cancel the review
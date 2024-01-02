Feature: Selecting the First Smart Doors on The Connected Shop

Scenario: User looking for an items using a search field
  Given I open the home page "https://theconnectedshop.com/"
  And The user click on the search field
  Then The user is entering the invalid text
  And After the valid text smart doors
  Then The user has many doors to choose from
  And The user clicks on the first door
  Then Close browser
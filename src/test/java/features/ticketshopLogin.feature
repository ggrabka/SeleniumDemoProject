Feature: Login to Demo Ticketshop

  Scenario: Not successful Login to Demo ticketshop with missing password
    Given I navigate to the main page "https://shop.demotickets.at/de/ticket"
    When I click the login now button
    And I enter email "test@mail.com" and password ""
    And I confirm the entry by clicking on the login button
    Then The login is not successful

    Scenario: Not successful Login to Demo ticketshop with invalid customer credentials
    Given I navigate to the main page "https://shop.demotickets.at/de/ticket"
    When I click the login now button
    And I enter email "test@mail.com" and password "test1234"
    And I confirm the entry by clicking on the login button
    Then The login is not successful
  @Skip
  Scenario: Successful Login to Demo ticketshop with valid customer credentials
    Given I navigate to the main page "https://shop.demotickets.at/de/ticket"
    When I click the login now button
    And I enter email "maxmuster@testmail.com" and password "test1234"
    And I confirm the entry by clicking on the login button
    Then The login is successful



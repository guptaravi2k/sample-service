@accounts
Feature: Accounts
  So that I can check how much money I have
  As an API consumer
  I want the Accounts API to provide me with my account balances

  Scenario: Get Accounts Details
    Given The user has the following accounts
      | BSB    | AccountNo | Balance |
      | 123456 |    123456 |  433.21 |
      | 123456 |    123457 | 1433.21 |
    When I request the Account API
    Then I'll get the following account details
      | BSB    | AccountNo | Balance |
      | 123456 |    123456 |  433.21 |
      | 123456 |    123457 | 1433.21 |

@root
Feature: Root API
  So that I can disover new API features and not have to hard-code URLs
  As an API consumer
  I want the Root API to provide me with links to other parts of the API

  Scenario: Get Root
    When I request the root API
    Then I'll get links to the following endpoints
      | User Details |
      | Accounts     |

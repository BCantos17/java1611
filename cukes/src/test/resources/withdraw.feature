# Feature file    .feature extension
Feature: Withdraw cash
  As as customer
  I can withdraw cash
  So I can spend too much of it

  Background: Context for all tests, runs once for each scenario
    Given I have these accounts
      | accountNum | name           |
      | 555        | Dan Pickles    |
      | 777        | Howard Johnson |
      | 888        | Randolph Scott |

  Scenario Outline: Everything ok, runs once for each example
    Given I have an account
    And I have <balance> dollars
    When I withdraw <withdraw> dollars
    Then I have <remaining> dollars left

    Examples: 
      | balance | withdraw | remaining |
      | 1000    | 200      | 800       |
      | 5000    | 1000     | 4000      |
      | 3000    | 2000     | 1000      |
      
      
      
      
      

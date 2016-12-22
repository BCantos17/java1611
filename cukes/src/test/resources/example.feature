# Example of Cucumber execution
Feature: Show execution of Cucumber
  As a trainer
  I can show the flow of execution
  To explain things better

  Background: Setup, like @Before
    Given I have these objects
      | data  |
      | Hello |
      | World |

  Scenario: Run scenario once
    Given I have a precondition
    When I take this action
    Then I get this result

  Scenario Outline: Run for each Example
    Given I have an example <precondition>
    When I act on it
    Then this <result> occurs

    Examples: 
      | precondition | result    |
      | "Dan"        | "Pickles" |
      | "Donald"     | "Trump"   |

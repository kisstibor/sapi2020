#Author: kozma.e.imre + GitHub@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Create a task and delete it
  I want to use this template for my feature file

  @tag1
  Scenario: Create And Delete
    Given I acces the task list
    And I press de add button
    And I add the title "TaskForDeletion"
    And I add the description "This will be deleted!"
    And I press the add task button
    When I acces the task delete page
    And I press the delete task button
    And I press confirm delete button
    Then I check the task list for task "TaskForDeletion"



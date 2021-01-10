#Author: your.email@your.domain.com
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
Feature: Update task
  I want to use this template for my feature file

  @tag1
  Scenario: Update title and description
    Given I access the task page
    And I create a new task with title "Task for Update" and description "I am the creator!"
    And I access the new task
    When I press the update button
    And Update the Task with title "Updated Task" and description "I am the updater!"
    Then I would see a Task with updated title and description



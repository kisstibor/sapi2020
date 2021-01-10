
@tag
Feature: Add task and check if is created
  I want to use this template for my feature file

  @tag1
  Scenario: Acces Add Task Page
    Given I acces the task list page
    When I press the add button
    Then I should enter in the add task page

 @tag2
  Scenario: Create Task
    Given I enter in the title field "Task1"
    And I enter the "description" in the description field
    When I press the last add task button
    Then It should appear the new "Task1" in the task list
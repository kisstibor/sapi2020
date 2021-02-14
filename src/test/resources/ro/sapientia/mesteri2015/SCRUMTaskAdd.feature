Feature: Check if the scrum task add
	As Sapientia scrum tool user I want to be able to add taks to an existing story

   Scenario: Add Task to Story
   Given I create a new story
   When I enter "task1" in  the task title textbox and I push the add button
   Then I should get result "task1" in tasks list
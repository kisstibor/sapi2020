Feature: Check if I can move tasks
	As Sapientia scrum tool user I want to be able to move tasks

   Scenario: 
   Given I open the board page
   When I see a task in To Do and move it to In Progress
   Then I should see it in In Progress
 
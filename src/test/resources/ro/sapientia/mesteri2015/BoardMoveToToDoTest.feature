Feature: Check if I can move tasks
	As Sapientia scrum tool user I want to be able to move tasks

   Scenario: 
   Given I open the board page
   When I see a task in In Progress and move it to To Do
   Then I should see it in To Do
 
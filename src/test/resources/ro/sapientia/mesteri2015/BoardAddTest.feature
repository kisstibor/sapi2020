Feature: Check if the scrum board adds tasks
	As Sapientia scrum tool user I want to be able to add tasks

   Scenario: Title1
   Given I open the board add page
   When I enter "title1" in  the title textbox and I push the add button
   Then I should get result "title1" on board
   
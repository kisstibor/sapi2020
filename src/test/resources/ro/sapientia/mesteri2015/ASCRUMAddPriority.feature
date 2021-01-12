Feature: Check if the scrum priority add
	As Sapientia scrum tool user I want to be able to add priorities

   Scenario: Low
   Given I open the scrum tool priority add page
   When I enter "low" in  the name textbox and I push the add button
   Then I should get result "low" in priority list
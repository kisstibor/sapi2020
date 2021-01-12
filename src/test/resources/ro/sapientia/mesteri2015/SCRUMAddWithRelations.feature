Feature: Check if the scrum team add
	As Sapientia scrum tool user I want to be able to add team

   Scenario: New Scrum Team with Mandatory data
   Given I open the scrum tool add scrum team page
   When I enter "team_name" in the name textbox and I push the add button
   Then I should get result "team_name" in scrum team list
Feature: Check if we can create a scrum team
	As Sapientia scrum tool user I want to be able to create new Scrum teams

   Scenario: Title1
   Given I open the Teams add page
   When I enter "Team1" in  the name textbox and I push the add button
   Then I should get result "Team1" in scrums list
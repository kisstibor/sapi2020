Feature: Check if the scrum story add
	As Sapientia scrum tool user I want to be able to add stories

Scenario: Title1
   Given I open the scrum tool add page
   When I enter "10" in  the story point input and I push the add button
   Then I should get result "10" in stories list
Feature: Check if the scrum user add
	As Sapientia scrum tool user I want to be able to add users

   Scenario: Title1
   Given I open the scrum tool user's add page
   When I enter "title1" in  the name textbox and I push the add button
   Then I should get result "title1" in users list
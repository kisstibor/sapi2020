Feature: Check if the scrum story add
	As Sapientia scrum tool user I want to be able to add stories

   Scenario: Title1
   Given I open the scrum tool add page
   When I enter "title1" in  the title textbox and I push the add button
   Then I should get result "title1" in stories list
   
  Scenario: Title4
   Given I open the scrum tool add page
   When I enter "title4" in  the title textbox and I push the add button
   Then I should get result "title4" in stories list
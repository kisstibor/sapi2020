      Feature: Check if the scrum priority assign
	As Sapientia scrum tool user I want to be able to asign priority to a user

   Scenario: Assign priority to new story
   Given I open the scrum tool story add page
   When I enter "Story for priority1" in  the title textbox select "low" and I push the add button
   Then I should get result "low" in story detail page
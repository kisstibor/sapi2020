Feature: Check if bug can be added to scrum
	As scrum tool user I want to be able to add bugs

   Scenario: AddBothTitleAndDescription
   Given I open the scrum tool add bug page
   When I enter "Bug title" in the title textbox, "Bug description" in the description textbox and I push the add button
   Then I should get result "Bug title" with "Bug description" in bugs list
   
   Scenario: AddWithoutTitle
   Given I open the scrum tool add bug page
   When I enter nothing in the title textbox and I push the add button
   Then I should get result error message next to title textbox saying "may not be empty"
Feature: Check if already existing bug can be updated
	As scrum tool user I want to be able to update the bugs

   Scenario: UpdateBothTitleAndDescription
   Given I open a single bug page and click update
   When I enter "Updated title" in the title textbox and "Updated description" in the description textbox and I push the update button
   Then I should get result "Updated title" with "Updated description" in single bug page
   
   Scenario: UpdateWithoutTitle
   Given I open a single bug page and click update
   When I enter nothing in the title textbox and I push the update button
   Then I should get result error message for update next to title textbox saying "may not be empty"
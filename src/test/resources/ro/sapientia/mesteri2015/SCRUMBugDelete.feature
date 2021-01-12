Feature: Check if already existing bug can be deleted
	As scrum tool user I want to be able to delete the bugs

   Scenario: DeleteBug
   Given I open a single bug page
   When I click delete button
   Then I should see the bug is not in the list
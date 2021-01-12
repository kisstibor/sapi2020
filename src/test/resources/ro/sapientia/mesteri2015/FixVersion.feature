Feature: Check if the fix version add works
	As Sapientia scrum tool user I want to be able to add fix versions

   Scenario: Add new fix version
   Given I open the scrum tool fix version add page
   When I enter "name" in the name textbox and I press the add button
   Then I should get result "name" in fix version page
   
   Scenario: Add and update fix version
   Given I open the scrum tool fix version add page
   When I enter "name" in the name textbox and I press the add button
   When I press the update button and change name to "test" and press update
   Then I should get result "test" in fix version page
   
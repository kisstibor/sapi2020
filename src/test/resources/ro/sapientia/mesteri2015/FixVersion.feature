Feature: Check if the fix version feature works
	As Sapientia scrum tool user I want to be able to add, update, delete and view fix versions

   Scenario: Add new fix version
   Given I open the scrum tool fix version add page
   When I enter "name" in the name textbox and I press the add button
   Then I should get result "name" in fix version page
   
   Scenario: Add and update fix version
   Given I open the scrum tool fix version add page
   When I enter "name" in the name textbox and I press the add button
   And I press the update button and change name to "test" and press update
   Then I should get result "test" in fix version page
   
   Scenario: Add and delete fix version
   Given I open the scrum tool fix version add page
   When I enter "name" in the name textbox and I press the add button
   And I press the delete button and confirm the delete
   Then I should be redirected to the list all page
   
   Scenario: Add multiple fix versions and list all of them
   Given I open the scrum tool fix version add page
   When I enter "name" in the name textbox and I press the add button
   And I open the list all fix versions page
   Then I should find more or equal than "1" fix version
   
   Scenario: Add fix version and cancel update
   Given I open the scrum tool fix version add page
   When I enter "name" in the name textbox and I press the add button
   And I press the update buton and cancel button after
   Then I should get result "name" in fix version page
   
   Scenario: Add fix version and cancel delete
   Given I open the scrum tool fix version add page
   When I enter "name" in the name textbox and I press the add button
   And I press the delete buton and cancel button after
   Then I should get result "name" in fix version page
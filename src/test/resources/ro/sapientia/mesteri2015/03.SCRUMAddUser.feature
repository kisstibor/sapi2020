Feature: Check if the scrum user add
	As Sapientia scrum tool user I want to be able to add users

   Scenario: User1
   Given I open the scrum tool add user page
   When I enter "user1" in the username textbox, "password1" in the password textbox and I push the add button
   Then I should get result "user1" in assign to combo box on add story page
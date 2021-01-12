Feature: Check if the user update works
	As Sapientia scrum tool user I want to be able to update a user's data

   Scenario: UpdateFirst
   Given I edit the user list's first user
   When I enter "updatefirstnew" in  the name textbox and I push the update button
   Then I should get result "updatefirstnew" in new user list
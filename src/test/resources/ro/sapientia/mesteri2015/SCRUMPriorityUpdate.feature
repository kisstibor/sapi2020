Feature: Check if the priority update works
	As Sapientia scrum tool user I want to be able to update a priority

   Scenario: UpdateFirst
   Given I edit the scrum list's first priority
   When I enter "updatefirstnew" in  the name textbox and I push the update button
   Then I should get result "updatefirstnew" in new priority list
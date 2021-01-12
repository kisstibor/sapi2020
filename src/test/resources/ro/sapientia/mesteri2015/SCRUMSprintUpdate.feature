Feature: Check if the scrum update works
	As Sapientia scrum tool user I want to be able to update a story

	Scenario: Add
	Given I open the add story page
	When I enter "add" in the title textbox and I push the add button
	Then I should get the story with "add" title

   Scenario: Update
   Given I edit the scrum list's first story
   When I enter "updatefirstnew" in  the title textbox and I push the update button
   Then I should get result "updatefirstnew" in new stories list
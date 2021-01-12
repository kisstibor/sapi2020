Feature: Check if the scrum user assign
	As Sapientia scrum tool user I want to be able to assign a user to a story.

   Scenario: Assign user to new story
   Given I open the scrum tool add story page
   When I enter "Story for user1" in the title textbox, select "user1" and I push the add button
   Then I should get result "user1" on story detail page
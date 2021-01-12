Feature: Check if a user can be unassigned
	As Sapientia scrum tool user I want to unassign a user from the story.

   Scenario: User1
   Given I open the scrum tool story edit page
   When I deselect the user from the combo box and I push the "Update" button
   Then I should not see the "Assigned to: user1" text on the detail page
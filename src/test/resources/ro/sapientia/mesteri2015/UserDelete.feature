Feature: Check if the scrum delete works
	As Sapientia scrum tool user I want to be able to delete a user

 Scenario: DeleteFirst
   Given I create a new "user1" element
   When We push twice the delete button
   Then The element is disepeared
	
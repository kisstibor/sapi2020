Feature: Check deleting a project works
	As Sapientia scrum tool user I want to be able to delete projects

   Scenario: Delete a new project
   Given Add a new project and delete it
   When I click the delete button
   Then The project disappears
   
   
   
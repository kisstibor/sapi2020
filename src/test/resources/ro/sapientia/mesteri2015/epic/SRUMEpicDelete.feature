Feature: Check deleting an epic works
	As a user I want to be able to delete epics
	
   Scenario: Delete the first
   Given I click on the epic list's first element to delete it
   When I click the delete button and a dialog appears and i confirm my choice
   Then I should see  a "EpicTitle1" text
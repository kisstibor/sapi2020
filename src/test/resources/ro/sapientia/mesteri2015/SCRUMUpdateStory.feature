Feature: Check that can we update a story
	As Sapientia scrum tool user I want to be able to update a story

   Scenario: AddingTimeFeatureVerifyOnTheViewPage
   Given I open the add webpage fill inputs and push the add button and then push the update button
   When I edit the description and time and then push the update button
   Then I check that the view changed from the first state
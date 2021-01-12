Feature: Check if the time registering field exists on the add page
	As Sapientia scrum tool user I want to be able to add spent time to the story

   Scenario: AddingTimeFeatureExistsOnAddPage
   Given I open the base webpage
   When I push the ADD button
   Then I check that the time related elements exists on page
Feature: Check that when we create a story, on the next page we can verify the stories data
	As Sapientia scrum tool user I want to be able to add a story with the spent time feature, what I would like to check on the next view page

   Scenario: AddingTimeFeatureVerifyOnTheViewPage
   Given I open the base webpage and navigate to the adding story page
   When I fill all data with predefined values and push the add story button to register the story
   Then I check on the page that the story created properly
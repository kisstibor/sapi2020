Feature: Check that when we create a story is it listed on home page with the registered time
	As Sapientia scrum tool user I want to be able to add a story what will be listed on home page

   Scenario: AddingTimeFeatureVerifyOnTheListPage
   Given I open the add story page
   When I fill all data and then navigate to home
   Then I check on the home page that the story is listed with the given time
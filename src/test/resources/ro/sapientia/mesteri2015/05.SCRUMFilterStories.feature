Feature: Check the story filter
	As Sapientia scrum tool user I want to be filter stories based on their title content.

   Scenario: Filter story by title
   Given I open the scrum tool story list page
   When I enter "story" in the filter textbox and I push the "Filter" button
   Then I should get a single result: "Story for user1"
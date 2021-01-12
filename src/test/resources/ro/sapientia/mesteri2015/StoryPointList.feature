Feature: Check if the scrum update works
	As Sapientia scrum tool user I want to be able to see the story point statistics

   Scenario: StoryPointList
   Given I open the scrum tool story point list page
   When I navigate the Story point list page
   Then I see dashboard with numbers
Feature: Check if Story due date check works
	As Sapientia scrum tool user I want to be alerted if a story is expired or not

   Scenario: Available
   Given I have already an "available" story with "availableStory" as title
   When I access the story page for informations
   Then I should see the due date in "green"

   Scenario: Expired
   Given I have already an "expired" story with "expiredStory" as title
   When I access the story page for informations
   Then I should see the due date in "red"
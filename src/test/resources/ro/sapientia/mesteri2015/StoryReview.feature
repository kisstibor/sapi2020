Feature: Ability to review existing story

   Scenario: Approved
   Given I open the scrum tool add page and add a new story with name "storytoreview"
   When I push review button navigate to the review page
   When I enter "Approved" in the review box and push tre review button
   Then I should get result "Approved" in the story view

   Scenario: Rejected
   Given I open the scrum tool add page and add a new story with name "Rejectedstory"
   When I push review button navigate to the review page
   When I enter "Rejected" in the review box and push tre review button
   Then I should get result "Rejected" in the story view
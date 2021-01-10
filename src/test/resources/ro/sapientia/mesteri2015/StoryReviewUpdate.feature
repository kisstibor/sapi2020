Feature: Ability to update an existing review

   Scenario: Change the approved status to rejected
   Given I open the scrum tool add page and set up story with review named "storytoreview" with review of "Approved"
   When I push update review button navigate to the update review page
   When I navigated to the update form I should see "Approved" in the review status
   When I enter "Rejected" in the review box and push the update button
   Then I should get result "Rejected" in the story view after update

   
   Scenario: Enter the same value as before
   Given I open the scrum tool add page and set up story with review named "storytoreviewrejected" with review of "Rejected"
   When I push update review button navigate to the update review page
   When I navigated to the update form I should see "Rejected" in the review status
   When I enter "Rejected" in the review box and push the update button
   Then I should get result "Rejected" in the story view after update
   
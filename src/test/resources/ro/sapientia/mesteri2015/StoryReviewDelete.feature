Feature: Ability to delete review from story

   Scenario: Delete a review from story
   Given I have story with name "storytoreview" and a review.
   When I push update review button navigate to the update review page where I can delete
   When I push the delete review button.
   Then I should not see review in the story view page

   Scenario: Delete a review from story
   Given I have story with name "storytoreviewdelete2" and a review.
   When I push update review button navigate to the update review page where I can delete
   When I push the delete review button.
   Then I should not see review in the story view page
@Comment
Feature: Empty commentlist
  A sapientia scrum tool user wants to see a special message when on a story does not have any comments yet.

  Scenario: Validate the empty-message of a newly created story.
   	When I am on the view page of a new story called "Empty commentlist story" with 0x comment
    Then I see that comments sections states "There are no comments yet."
    And comment list contains 0x comments

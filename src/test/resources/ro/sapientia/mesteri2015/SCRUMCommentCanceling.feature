@Comment
Feature: Comment actions cancelling
  A sapientia scrum tool user wants to be able to cancel initiated commenting actions and prevent any state change.

  Scenario: Cancel adding a new comment
    Given I am on the view page of a new story called "Cancel adding a new comment" with 2x comment
    When I click on "add-button" button
	  And I enter "This is a comment" in  the "comment-message" textbox
	  And I click on "cancel-add-comment-button" button
    Then I should see "Cancel adding a new comment" story's view page
    And comment list contains 2x comments

	Scenario: Cancel deleting a comment
    Given I am on the view page of a new story called "Cancel deleting a comment" with 2x comment
    When I click on "delete-comment-link" button
	  And I click on "cancel-delete-comment-button" button
    Then I should see "Cancel deleting a comment" story's view page
    And comment list contains 2x comments

@Comment
Feature: Adding incorrect comments displays error
	A sapientia scrum tool user wants to add comments safely, so input data is validated and a proper error is presented to the user.

  Scenario: Adding empty comments should show an error message
    Given I am on the view page of a new story called "Adding empty comments" with 0x comment
    When I click on "add-button" button
	  And I enter "" in  the "comment-message" textbox
	 	And I click on "add-comment-button" button
	 	Then I should see an error


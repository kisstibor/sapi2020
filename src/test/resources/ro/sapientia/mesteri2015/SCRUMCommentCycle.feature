#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@Comment
Feature: Comment basic lifecycle
	A sapientia scrum tool user must be able to Create, Read and Delete comments on a story.

	Scenario: Do a comment create-read-delete cycle on first story item
    Given I am on the view page of a new story called "Comment basic lifecycle" with 2x comment

		 # Create the first comment
	   When I click on "add-button" button
	   And I enter "This is a comment" in  the "comment-message" textbox
	   And I click on "add-comment-button" button

	   # Check first comment is visible
	   Then I should see 1x "This is a comment" in the story's comment list

	   # Create the second comment
	   When I click on "add-button" button
	   And I enter "This is a second comment" in  the "comment-message" textbox
	   And I click on "add-comment-button" button

	   # Check both comments are visible
	   Then I should see 1x "This is a comment" in the story's comment list
	   And I should see 1x "This is a second comment" in the story's comment list

	   # Delete the first comment
	   When I delete the comment with "This is a comment" message

	   # Check only second comment is visible
	   Then I should see 0x "This is a comment" in the story's comment list
	   And I should see 1x "This is a second comment" in the story's comment list

	   # Delete the second comment
	   When I delete the comment with "This is a second comment" message

	   # Check none of the comments is visible
	   Then I should see 0x "This is a comment" in the story's comment list
	   And I should see 0x "This is a second comment" in the story's comment list



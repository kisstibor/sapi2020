Feature: Check if commenting on story is possible
	As Sapientia scrum tool user I want to be able to add comments to stories

   Scenario: NewComment
   Given A Story is already created as "newStory"
   Given I open the first story in the list
	And I click on add comment button
   When I enter "first comment" in the message textbox and I push the add button
   Then I should see the "first comment" comment under the "newStory" story
   
   Scenario: UpdateFirstComment
   Given A Story is already created as "newStory"
   Given I am on a story page already
   And I pressed the comment modify button
   When I enter "updated comment text" in the message textbox and I push the update button
   Then I should see the changed comment "updated comment text"
   
   Scenario: DeleteFirstComment
   Given A Story is already created as "newStory"
   Given I am on a story page already
   When I pressed the comment delete button
   Then The comment is gone
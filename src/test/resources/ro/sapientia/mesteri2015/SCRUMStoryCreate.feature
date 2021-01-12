Feature: Check if Story creation works
	As Sapientia scrum tool user I want to be able to create a story

   Scenario: CreateFirst
   Given I add a new story on the list
   When I enter "firstStory" in the title textbox and "test text" in the description textbox also I set tomorrow's date as due date then I push the create button
   Then I should get a new story as "firstStory" in the list
   
   Scenario: UpdateIt
   Given I access the created story
   	And I press modify button
   When I enter "firstStory_updated" in the title textbox and "test text" in the description textbox also I set the status to In Progress I push the create button
   Then I should get a new story as "firstStory_updated" with In Progress status
   
   Scenario: DeleteIt
   Given I access the created story
   	And I press delete button
   When I confirm my action
   Then I should not see this story again
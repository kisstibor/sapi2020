Feature: Check if Story time management works
	As Sapientia scrum tool user I want to be able to track my project efficiency

   Scenario: CreateAStoryFirst
   Given I will add a new story on the list
   When I will enter "testStory" in the title textbox and "test text" in the description textbox also I set tomorrow's date as due date then I push the create button
   Then I will get a new story as "testStory" in the list
   
   Scenario: UpdateItToInProgress
   Given I will access the created story
   	And I will press modify button
   When I enter "testStory_InProgress" in the title textbox I set the status to "In Progress" I push the create button
   Then I should get a new story as "testStory_InProgress" with "In Progress" status
   
   Scenario: UpdateItToUnderTesting
   Given I will access the created story
   	And I will press modify button
   When I enter "testStory_UnderTest" in the title textbox I set the status to "Under Testing" I push the create button
   Then I should get a new story as "testStory_UnderTest" with "Under Testing" status
   
   Scenario: UpdateItToDone
   Given I will access the created story
   	And I will press modify button
   When I enter "testStory_Done" in the title textbox I set the status to "Done" I push the create button
   Then I should get a new story as "testStory_Done" with "Done" status
   	And I should see the time management table
   
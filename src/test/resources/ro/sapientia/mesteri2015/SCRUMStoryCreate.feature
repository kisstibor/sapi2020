Feature: Check if the story create works
	As Sapientia scrum tool user I want to be able to create a story
	
	Scenario: CreateFirst
    Given I add a new story to the list
    When I enter "story1" in  the title textbox and "story1Description" in the description textbox and I push the add button
    Then I should get a new story as "story1" in the stories list

   Scenario: UpdateFirst
   Given I edit the scrum list's first story
   When I enter "story1_updated" in  the title textbox and "story1Description_updated" in the description box and I push the update button
   Then I should get result "story1_updated" in new stories list
   
    Scenario: DeleteFirst
   Given I delete the scrum list's first story
   When I confirm my action
   Then I should not see this story again
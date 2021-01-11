Feature: Check updating an epic works
	As a user I want to be able to update epics

   Scenario: Update the first epic
   Given I click on the epic list's first element
   When I enter "EpicTitle1Updated" in  the title textbox and after that I push the update button
   Then I should get the result "EpicTitle1Updated" in new epics list
   
   Scenario: Update the first epic's title and description
   Given I click on the epic list's first element
   When I enter "EpicTitle1Updated" in  the title textbox and "Epic1 description updated" in the description textbox after that I push the update button
   Then I should get the result with title "EpicTitle1Updated" and description "Epic1 description updated" in new epics list
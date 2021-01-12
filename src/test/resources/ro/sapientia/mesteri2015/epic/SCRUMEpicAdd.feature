Feature: Check if adding an epic works
	As a user I want to be able to add epics

   Scenario: Add an epic
   Given I open the epic add page
   When I enter "EpicTitle1" in  the title textbox and after that I push the add button
   Then I should get the result "EpicTitle1" in epics list
   
   Scenario: Add an epic with title and description
   Given I open the epic add page
   When I enter "EpicTitle1" in  the title textbox and I enter the "Epic1 description" in the description textbox after that I push the add button
   Then I should get the result with the title "EpicTitle1" and description "Epic1 description" in epics list
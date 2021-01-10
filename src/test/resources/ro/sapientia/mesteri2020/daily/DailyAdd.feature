Feature: Check if the daily add
	As Sapientia tool user I want to be able to add dailies

   Scenario: Daily1
   Given I open the tool and navigate to the daily add page
   When I enter "daily1" in  the title textbox, "12-12-1212" in the date textbox, "20" in the duration textbox and I push the add button
   Then I should get result "daily1" title "12-12-1212" date "20" duration on view page
   
   
   Scenario: Daily2
   Given I open the tool and navigate to the daily add page
   When I enter "daily2" in  the title textbox, "10-10-2020" in the date textbox, "50" in the duration textbox and I push the add button
   Then I should get result "daily2" title "10-10-2020" date "50" duration on view page
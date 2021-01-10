Feature: Check if daily delete works fine
	As Sapientia tool user I want to be able to delete dailies

   Scenario: Update1
   Given I open the tool and create a daily with title "daily1", duration "20", date "12-12-1212"
   When I press delete button
   When I confirm delete
   Then I puufff its deleted
   
   Scenario: Update1
   Given I open the tool and create a daily with title "kicsi kutya tarka", duration "754", date "15-12-2020"
   When I press delete button
   When I confirm delete
   Then I puufff its deleted
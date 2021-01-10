Feature: Check if daily update works fine
	As Sapientia tool user I want to be able to update dailies

   Scenario: Update1
   Given I open the tool and navigate to an existing daily with title "daily1", duration "20", date "12-12-1212"
   When I press update button
   When Check title to be "daily1", duration "20", date "12-12-1212"
   When I change title to "mokuska" and press update
   Then I should get result "mokuska" title "12-12-1212" date "20" duration after update
  
  
   Scenario: Update1
   Given I open the tool and navigate to an existing daily with title "blabla", duration "80", date "11-11-1211"
   When I press update button
   When Check title to be "blabla", duration "80", date "11-11-1211"
   When I change title to "blabla" and press update
   Then I should get result "blabla" title "11-11-1211" date "80" duration after update
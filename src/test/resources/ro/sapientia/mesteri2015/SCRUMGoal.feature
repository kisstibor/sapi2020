Feature: Check the goal teplate add
	As Sapientia goal template creator tool user I want to be able to add goals

   Scenario: Goal_I
   Given I open the goal creator tool
   When I enter "Goal I" in the goal textbox and I push the add goal button
   Then I should get result "Goal I" in goals list
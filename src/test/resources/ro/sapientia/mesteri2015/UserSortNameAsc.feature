Feature: Check if the scrum user sort works

 Scenario: Sort1
   Given I choose Name asc from drop down list
   When We push sort button
   Then The users are sorted
	
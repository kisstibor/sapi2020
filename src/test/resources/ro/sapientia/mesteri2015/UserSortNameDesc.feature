Feature: Check if the scrum user sort works

 Scenario: Sort1
   Given I choose Name desc from drop down list
   When We push sort button which sort desc
   Then The users are sorted desc
	
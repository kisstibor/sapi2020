Feature: Check if the scrum project add
	As Sapientia scrum tool user I want to be able to add projects

   Scenario: Add a new project with title and description
   Given I open the add project page
   When I enter "title1" in  the title textbox and I enter the "description1" in the description textbox and I push the add project button
   Then I should get the result "title1" and "description1" in projects list 
   
Feature: Adding and deleting a Project entry

Scenario: Add and delete a new Project
	Given we add a new project named "Qwerty"
	When we delete the project
	Then check if "Qwerty" has been deleted
	
Scenario: Add and delete a new Project
	Given we add a new project named "Abcdef"
	When we delete the project
	Then check if "Abcdef" has been deleted
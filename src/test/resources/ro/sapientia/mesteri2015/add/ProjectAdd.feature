Feature: Adding a new Project

Scenario: We add a new Project and check if it is created
	Given we create a new project with name "NewProject"
	When we load the projects url
	Then project name is "NewProject"
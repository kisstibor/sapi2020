Feature: Updating a Project

Scenario: We add a project and update its name
	Given we add a project named "other"
	When we rename the project
	Then new project name should be "other project"
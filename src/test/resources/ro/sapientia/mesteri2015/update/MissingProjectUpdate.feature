Feature: Updating a missing Project

Scenario: We request to update a missing project
	Given we list all the projects
	When we search for project with id "23124"
	Then the project will not be found
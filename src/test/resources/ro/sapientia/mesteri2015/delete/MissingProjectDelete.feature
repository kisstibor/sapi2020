Feature: Deleting a missing project

Scenario: We browse the projects and manually try to delete one from url
	Given we check the projects
	When we delete the project with id "2312"
	Then we get a not found error
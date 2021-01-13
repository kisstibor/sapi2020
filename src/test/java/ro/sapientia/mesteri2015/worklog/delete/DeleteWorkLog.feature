Feature: Check if the worklog delete
	As Sapientia scrum tool user I want to be able to delete a worklog

   Scenario: Worklog torlese
   Given Loggolok "2021-11-11" "11:30" "12:30" idot majd "test desc" leirast adok
   When Megnyomjuk a delete gombot es meg egyszer a delete gombot
   Then A worklog eltunt
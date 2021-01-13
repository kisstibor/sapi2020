Feature: Check if the worklog update
	As Sapientia scrum tool user I want to be able to update a given work log

   Scenario: Worklog torlese
   Given Loggolok "2021-11-11" "11:30" "12:30" idot majd "test desc" leirast adok
   When Megnyomjuk az update gombot es beallitjuk a datumot "2020-10-16" es a leirast "modified desc"
   Then A worklog megmodosult "2020-10-16" datum es "modified desc" leirassal
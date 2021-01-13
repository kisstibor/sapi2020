Feature: Check if the worklog update
	As Sapientia scrum tool user I want to be able to search worklog by date

   Scenario: Worklog listazasa loggolasi ido szerint
   Given Loggolok 5 veletlenszeru elemet, ebbol 2 "2021-11-11" datumra
   When Kivalasztom a "2021-11-11" datumot es megnyomom s search gombot
   Then A lista ket elemet fog tartalmazni
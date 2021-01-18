Feature: Check if the scrum update works
	As Sapientia scrum tool user I want to be able to update a story

   Scenario: UpdateLog
   Given Firefox nyitas
   And Letrehozok egy uj logot: "title" , "status" , "assignto"
   When Kattintas az update gombra
   And Status es Assingto modositas "title" , "assignto"
   Then Ellenorzes "title" , "assingto" ertekek megvaltoztake?
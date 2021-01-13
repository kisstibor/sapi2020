Feature: Check if the worklog add
	As Sapientia scrum tool user I want to be able to log to a given story

   Scenario: Uj worklog hozzadasa
   Given Megnyitom az uj worklog hozzaadas oldalt
   When Kivalasztom az elso sztorit es "2021-11-11" "11:30" "12:30" idot majd "test desc" leirast adok
   Then Az uj worklog megjelenik "test desc" leirassal

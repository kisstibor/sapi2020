Feature: Egy elem torlese

Scenario: Toroljunk le egy uj elemet
	Given letrehozunk 1 uj "alma" element
	When megnyomjuk a delete gombot es meg egyszer a delete gombot
	Then elem eltunik
	
Scenario: Toroljunk le egy uj elemet
	Given letrehozunk 1 uj "korte" element
	When megnyomjuk a delete gombot es meg egyszer a delete gombot
	Then elem eltunik
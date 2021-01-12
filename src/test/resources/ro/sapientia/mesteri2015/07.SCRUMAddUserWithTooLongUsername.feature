Feature: Check if the scrum user add fails
	As Sapientia scrum tool user I don't want to be able to add users with name longer than 255 characters

   Scenario: User1
   Given I open the add user page
   When I enter long username "Yon668V08I0lv9Jrk0SfmVacpebpVbojOlio1u9oUwJrj4IcBb3TmizOnwKBXHGxhfLGT1ZIPtpQ20wCHLKZg3oC9XorvQSPcu3pophkeaS1b3w12z6M5ouAn5vGl3HTWJSjHPMD7xc8MmzYHUUjckbYeCabIPLbCFBFBfHJpZZfptNAS43W7rramtEDEq86L9bWaiDsjqq8QaXVU4W9ZuQ6kV6llGIZkI23Z6FssxWHX6hd2pPAG3J1X9VMbXTB" in the username textbox, "password1" in the password textbox and I push the add button
   Then I should get error result for username saying: "length must be between 0 and 255"
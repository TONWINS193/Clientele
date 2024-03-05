Feature: Broker Online functionality

 Scenario Outline: Login to online capture
    Given  user open Broker Online Website
    When  user enter access code and confirm,"<AccessCode>"
   Then user Login with valid Broker code and password
   When user click on new sale
   When user select product on a dropdown lists
   Then user enter application number and continue

   Examples:
   | AccessCode |
   |   0132     |
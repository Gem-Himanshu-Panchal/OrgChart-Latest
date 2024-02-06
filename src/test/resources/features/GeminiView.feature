@runGeminiView @regression
Feature: Gemini view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard
#    And Click on "Admin" button
#    And Click on "Manage View" button
#    Then Click on " Export Employees " button
#    And Open downloaded excel file
#    Then Update the JSON data file
#    And Update the mentor name list
#    And Update the mentor code list
#    And Go to Dashboard
#    Then Verify if user is on OrgChart dashboard


  Scenario: OrgChart, Verify set 1 of Gemini employees
    When Open hierarchy in Gemini view for "0" to "20" managers

  Scenario: OrgChart, Verify set 2 of Gemini employees
    When Open hierarchy in Gemini view for "20" to "50" managers

  Scenario: OrgChart, Verify set 3 of Gemini employees
    When Open hierarchy in Gemini view for "50" to "80" managers

  Scenario: OrgChart, Verify set 4 of Gemini employees
    When Open hierarchy in Gemini view for "80" to "110" managers

  Scenario: OrgChart, Verify set 5 of Gemini employees
    When Open hierarchy in Gemini view for "110" to "150" managers

  Scenario: OrgChart, Verify set 6 of Gemini employees
    When Open hierarchy in Gemini view for "150" to "180" managers

  Scenario: OrgChart, Verify set 7 of Gemini employees
    When Open hierarchy in Gemini view for "180" to "204" managers
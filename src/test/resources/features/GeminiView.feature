@geminiViewTesting @regression
Feature: Gemini view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard

  Scenario: OrgChart, Verify set 1 of Gemini employees
    When Open hierarchy in Gemini view for "0" to "20" managers


  Scenario: OrgChart, Verify set 2 of Gemini employees
    When Open hierarchy in Gemini view for "20" to "50" managers


  Scenario: OrgChart, Verify set 3 of Gemini employees
    When Open hierarchy in Gemini view for "50" to "100" managers


  Scenario: OrgChart, Verify set 4 of Gemini employees
    When Open hierarchy in Gemini view for "100" to "150" managers


  Scenario: OrgChart, Verify set 5 of Gemini employees
    When Open hierarchy in Gemini view for "150" to "206" managers



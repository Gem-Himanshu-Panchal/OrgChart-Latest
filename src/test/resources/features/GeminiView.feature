@runGeminiView1 @regression12345 @runDCGEM
Feature: Gemini view data validations

  Background: Verify if user successfully log into Orgchart
    Given a user is logged into OrgChart
    When the user navigates to the OrgChart dashboard



  Scenario: OrgChart, Verify set 1 of Gemini employees
    When Open hierarchy in Gemini view for "0" to "20" managers

  Scenario: OrgChart, Verify set 2 of Gemini employees
    When Open hierarchy in Gemini view for "20" to "50" managers

  Scenario: OrgChart, Verify set 3 of Gemini employees
    When Open hierarchy in Gemini view for "50" to "80" managers

  Scenario: OrgChart, Verify set 4 of Gemini employees
    When Open hierarchy in Gemini view for "80" to "110" managers

  Scenario: OrgChart, Verify set 5 of Gemini employees
    When Open hierarchy in Gemini view for "116" to "150" managers

  Scenario: OrgChart, Verify set 6 of Gemini employees
    When Open hierarchy in Gemini view for "150" to "180" managers

  Scenario: OrgChart, Verify set 7 of Gemini employees
    When Open hierarchy in Gemini view for "180" to "227" managers

  Scenario: Verify any duplicate data in OrgChart employee view
    When Search for any duplicate employee in OrgChart Gemini view

  Scenario: Verify if any extra employee in Gemini View
      When Search for any extra employee

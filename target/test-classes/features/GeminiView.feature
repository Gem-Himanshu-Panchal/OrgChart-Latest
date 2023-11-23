@geminiViewTesting
Feature: Gemini view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard

  Scenario: Gemini View new technique
    When Open hierarchy in Gemini view and verify details

    Scenario: Verify any duplicate data in OrgChart employee view
      When Search for any duplicate employee in OrgChart Gemini view
@geminiViewTesting @regression
Feature: Gemini view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard

  Scenario: Gemini View time reduce 1
    When Open hierarchy in Gemini view for "0" to "20" managers


  Scenario: Gemini View time reduce 2
    When Open hierarchy in Gemini view for "20" to "50" managers


  Scenario: Gemini View time reduce 3
    When Open hierarchy in Gemini view for "50" to "100" managers


  Scenario: Gemini View time reduce 4
    When Open hierarchy in Gemini view for "100" to "150" managers


  Scenario: Gemini View time reduce 5
    When Open hierarchy in Gemini view for "150" to "206" managers



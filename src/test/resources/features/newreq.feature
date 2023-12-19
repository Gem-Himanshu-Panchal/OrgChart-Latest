Feature: Gemini view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard
    And Switch to "Customized View For Pc" view


    Scenario: Verify new location reqirement
      When Open all nodes
      And Check if

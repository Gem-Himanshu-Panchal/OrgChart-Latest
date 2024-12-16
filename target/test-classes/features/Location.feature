Feature: Location Tooltip Testing for Onshore Employees

  Background: Verify if user successfully log into Orgchart
    Given a user is logged into OrgChart
    When the user navigates to the OrgChart dashboard
    And switches to the "Customized View For Pc" mode


#    When Navigate to OrgChart and login
#    Then Verify if user is on OrgChart dashboard
#    And Switch to "Customized View For Pc" view

  Scenario: Verify Location Tooltip Display for Onshore Employees
    When the user expands all nodes
    Then the location tooltip for onshore employees should be displayed correctly

#    Scenario: Verify new location requirement
#      When Open all nodes and verify if correct location tooltip is displayed

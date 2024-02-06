Feature: Testing auto download and setup of Employees data

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard
    And Click on "Admin" button
    And Click on "Manage View" button
    Then Click on " Export Employees " button

    Scenario: Open downloaded file and convert it to json
      Given Open file
      Then Update the file
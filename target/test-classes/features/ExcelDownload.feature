@excelDownload
Feature: EC view data validations

  Scenario: Excel download
#    When Navigate to OrgChart and login
#    Then Verify if user is on OrgChart dashboard
#    And Click on "Admin" button
#    And Click on "Manage View" button
#    Then Click on " Export Employees " button
    And Open downloaded excel file
    Then Update the JSON data file
    And Update the mentor name list
    And Update the mentor code list
#    And Go to Dashboard
#    Then Verify if user is on OrgChart dashboard
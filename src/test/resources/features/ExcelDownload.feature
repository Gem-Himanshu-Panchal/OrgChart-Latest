@excelDownload
Feature: EC view data validations

  Scenario: Excel download

    Given a user is logged into OrgChart
    When the user navigates to the OrgChart dashboard
    And Click on Admin button
    Then Click on Manage View button
    And Click on Export Employees button
    Then Open downloaded excel file
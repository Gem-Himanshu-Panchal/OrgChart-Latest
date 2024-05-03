@runECView @regression @DCEC
Feature: EC view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard
    And Switch to "EC" view


  Scenario: Verify EC view for .Net
    Given Check employee in EC view for ".Net" of OrgChart

  Scenario: Verify EC view for Accounts
   Given Check employee in EC view for "Accounts" of OrgChart

  Scenario: Verify EC view for Admin
    Given Check employee in EC view for "Admin" of OrgChart

  Scenario: Verify EC view for Architect
    Given Check employee in EC view for "Architect" of OrgChart

  Scenario: Verify EC view for Asset Management
    Given Check employee in EC view for "Asset Management" of OrgChart

  Scenario: Verify EC view for Data Engineering
    Given Check employee in EC view for "Data Engineering" of OrgChart

  Scenario: Verify EC view for Data Science/Quant/ML
    Given Check employee in EC view for "Data Science/Quant/ML" of OrgChart

  Scenario: Verify EC view for DesignBranding
    Given Check employee in EC view for "DesignBranding" of OrgChart

  Scenario: Verify EC view for Devops
    Given Check employee in EC view for "Devops" of OrgChart

  Scenario: Verify EC view for Executive Office
    Given Check employee in EC view for "Executive Office" of OrgChart

  Scenario: Verify EC view for Full stack (Angular/ Node/ React)
    Given Check employee in EC view for "Full stack (Angular/ Node/ React)" of OrgChart

  Scenario: Verify EC view for Human Resource
    Given Check employee in EC view for "Human Resource" of OrgChart

  Scenario: Verify EC view for Infrastructure/IT
    Given Check employee in EC view for "Infrastructure/IT" of OrgChart

  Scenario: Verify EC view for Insurance
    Given Check employee in EC view for "Insurance" of OrgChart

  Scenario: Verify EC view for Java
    Given Check employee in EC view for "Java" of OrgChart

  Scenario: Verify EC view for Management
    Given Check employee in EC view for "Management" of OrgChart

  Scenario: Verify EC view for Python/C++
    Given Check employee in EC view for "Python/C++" of OrgChart

  Scenario: Verify EC view for QA
    Given Check employee in EC view for "QA" of OrgChart

  Scenario: Verify EC view for Training
    Given Check employee in EC view for "Training" of OrgChart

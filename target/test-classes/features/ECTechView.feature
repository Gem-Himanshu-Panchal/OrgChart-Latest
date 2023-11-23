@ecviewTest
Feature: EC view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard
    And Switch to "EC" view


  Scenario: Verify EC view for .Net
    When Open modals box in EC View ".Net"
    Then Check employee in EC view for ".Net" of OrgChart


  Scenario: Verify EC view for Accounts
    When Open modals box in EC View "Accounts"
    Then Check employee in EC view for "Accounts" of OrgChart


  Scenario: Verify EC view for Admin
    When Open modals box in EC View "Admin"
    Then Check employee in EC view for "Admin" of OrgChart


  Scenario: Verify EC view for Architect
    When Open modals box in EC View "Architect"
    Then Check employee in EC view for "Architect" of OrgChart



  Scenario: Verify EC view for Asset Management
    When Open modals box in EC View "Asset Management"
    Then Check employee in EC view for "Asset Management" of OrgChart


  Scenario: Verify EC view for Data Engineering
    When Open modals box in EC View "Data Engineering"
    Then Check employee in EC view for "Data Engineering" of OrgChart


  Scenario: Verify EC view for Data Science/Quant/ML
    When Open modals box in EC View "Data Science/Quant/ML"
    Then Check employee in EC view for "Data Science/Quant/ML" of OrgChart


  Scenario: Verify EC view for DesignBranding
    When Open modals box in EC View "DesignBranding"
    Then Check employee in EC view for "DesignBranding" of OrgChart


  Scenario: Verify EC view for Devops
    When Open modals box in EC View "Devops"
    Then Check employee in EC view for "Devops" of OrgChart



  Scenario: Verify EC view for Executive Office
    When Open modals box in EC View "Executive Office"
    Then Check employee in EC view for "Executive Office" of OrgChart


  Scenario: Verify EC view for Full stack (Angular/ Node/ React)
    When Open modals box in EC View "Full stack (Angular/ Node/ React)"
    Then Check employee in EC view for "Full stack (Angular/ Node/ React)" of OrgChart


  Scenario: Verify EC view for Human Resource
    When Open modals box in EC View "Human Resource"
    Then Check employee in EC view for "Human Resource" of OrgChart


  Scenario: Verify EC view for Infrastructure/IT
    When Open modals box in EC View "Infrastructure/IT"
    Then Check employee in EC view for "Infrastructure/IT" of OrgChart


  Scenario: Verify EC view for Insurance
    When Open modals box in EC View "Insurance"
    Then Check employee in EC view for "Insurance" of OrgChart


  Scenario: Verify EC view for Java
    When Open modals box in EC View "Java"
    Then Check employee in EC view for "Java" of OrgChart


  Scenario: Verify EC view for Python/C++
    When Open modals box in EC View "Python/C++"
    Then Check employee in EC view for "Python/C++" of OrgChart


  Scenario: Verify EC view for QA
    When Open modals box in EC View "QA"
    Then Check employee in EC view for "QA" of OrgChart


  Scenario: Verify EC view for Training
    When Open modals box in EC View "Training"
    Then Check employee in EC view for "Training" of OrgChart


  Scenario: Verify any duplicate data in OrgChart employee view
    When Search for any duplicate employee in OrgChart Gemini view
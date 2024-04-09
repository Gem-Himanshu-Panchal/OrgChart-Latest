@testPimcoDC
Feature: Pimco DC view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard
    And Switch to "Pimco Dc" view


  Scenario: Verify Pimco DC view for Pimco Analytics Support
    When Open modals box in "Pimco Analytics Support"
    Then Check employee in PIMCODC view for "Pimco Analytics Support" of OrgChart


  Scenario: Verify Pimco DC view for PIMCO Client Data Intelligence
    When Open modals box in "PIMCO Client Data Intelligence"
    Then Check employee in PIMCODC view for "PIMCO Client Data Intelligence" of OrgChart

#  Scenario: Verify Pimco DC view for Pimco Client Facing Tech
#    When Open modals box in "Pimco Client Facing Tech"
#    Then Check employee in PIMCODC view for "Pimco Client Facing Tech" of OrgChart


  Scenario: Verify Pimco DC view for Pimco Credit Research / PARR
    When Open modals box in "Pimco Credit Research / PARR"
    Then Check employee in PIMCODC view for "Pimco Credit Research / PARR" of OrgChart


  Scenario: Verify Pimco DC view for Pimco CSA frontend & ABS Tech
    When Open modals box in "Pimco CSA frontend & ABS Tech"
    Then Check employee in PIMCODC view for "Pimco CSA frontend & ABS Tech" of OrgChart


  Scenario: Verify Pimco DC view for Pimco Data Engineering
    When Open modals box in "Pimco Data Engineering"
    Then Check employee in PIMCODC view for "Pimco Data Engineering" of OrgChart


  Scenario: Verify Pimco DC view for Pimco Data Science
    When Open modals box in "Pimco Data Science"
    Then Check employee in PIMCODC view for "Pimco Data Science" of OrgChart

  Scenario: Verify Pimco DC view for Pimco DevOps / Platform Engineering
    When Open modals box in "Pimco DevOps / Platform Engineering"
    Then Check employee in PIMCODC view for "Pimco DevOps / Platform Engineering" of OrgChart

  Scenario: Verify Pimco DC view for Pimco EMEA Tech
    When Open modals box in "Pimco EMEA Tech"
    Then Check employee in PIMCODC view for "Pimco EMEA Tech" of OrgChart

  Scenario: Verify Pimco DC view for Pimco FE Infrastructure
    When Open modals box in "Pimco FE Infrastructure"
    Then Check employee in PIMCODC view for "Pimco FE Infrastructure" of OrgChart


  Scenario: Verify Pimco DC view for Pimco Infrastructure
    When Open modals box in "Pimco Infrastructure"
    Then Check employee in PIMCODC view for "Pimco Infrastructure" of OrgChart

  Scenario: Verify Pimco DC view for Pimco Investment Data
    When Open modals box in "Pimco Investment Data"
    Then Check employee in PIMCODC view for "Pimco Investment Data" of OrgChart

  Scenario: Verify Pimco DC view for Pimco Operations Tech
    When Open modals box in "Pimco Operations Tech"
    Then Check employee in PIMCODC view for "Pimco Operations Tech" of OrgChart

  Scenario: Verify Pimco DC view for Pimco Portfolio Analytics Support
    When Open modals box in "Pimco Portfolio Analytics Support"
    Then Check employee in PIMCODC view for "Pimco Portfolio Analytics Support" of OrgChart

  Scenario: Verify Pimco DC view for Pimco Puma
    When Open modals box in "Pimco Puma"
    Then Check employee in PIMCODC view for "Pimco Puma" of OrgChart

  Scenario: Verify Pimco DC view for Pimco QA
    When Open modals box in "Pimco QA"
    Then Check employee in PIMCODC view for "Pimco QA" of OrgChart

  Scenario: Verify Pimco DC view for Pimco Reference Data
    When Open modals box in "Pimco Reference Data"
    Then Check employee in PIMCODC view for "Pimco Reference Data" of OrgChart

  Scenario: Verify Pimco DC view for Pimco RiskOps
    When Open modals box in "Pimco RiskOps"
    Then Check employee in PIMCODC view for "Pimco RiskOps" of OrgChart

  Scenario: Verify Pimco DC view for Pimco Sales & Marketing Tech
    When Open modals box in "Pimco Sales & Marketing Tech"
    Then Check employee in PIMCODC view for "Pimco Sales & Marketing Tech" of OrgChart

  Scenario: Verify Pimco DC view for Pimco Security
    When Open modals box in "Pimco Security"
    Then Check employee in PIMCODC view for "Pimco Security" of OrgChart

  Scenario: Verify Pimco DC view for Pimco ServiceOps
    When Open modals box in "Pimco ServiceOps"
    Then Check employee in PIMCODC view for "Pimco ServiceOps" of OrgChart
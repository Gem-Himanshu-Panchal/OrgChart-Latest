@runDCViewReg111 @regression1 @DCEC @regression12345
Feature: DC view data validations

  Background: Verify if user successfully log into Orgchart
    Given a user is logged into OrgChart
    When the user navigates to the OrgChart dashboard
    And switches to the "DC" mode



#    Support
  Scenario: Verify DC view for Accounts
    When Open path for "Support" Dc tech and "Accounts" DC
    Then Check employee in DC view for "Accounts" in "Support" of OrgChart

  Scenario: Verify DC view for Human Resource
    When Open path for "Support" Dc tech and "Human Resource" DC
    Then Check employee in DC view for "Human Resource" in "Support" of OrgChart

  Scenario: Verify DC view for Admin
    When Open path for "Support" Dc tech and "Admin" DC
    Then Check employee in DC view for "Admin" in "Support" of OrgChart

  Scenario: Verify DC view for Management
    When Open path for "Support" Dc tech and "Admin" DC
    Then Check employee in DC view for "Admin" in "Support" of OrgChart




# EJ
  Scenario: Verify DC view for Edward Jones Core Digital Support
    When Open path for "Clients" Dc tech and "Edward Jones Core Digital Support" DC
    Then Check employee in DC view for "Edward Jones Core Digital Support" in "Clients" of OrgChart

  Scenario: Verify DC view for Edward Jones Quality Engineering
    When Open path for "Clients" Dc tech and "Edward Jones Quality Engineering" DC
    Then Check employee in DC view for "Edward Jones Quality Engineering" in "Clients" of OrgChart

  Scenario: Verify DC view for Edward Jones SWAT & API Platform
    When Open path for "Clients" Dc tech and "Edward Jones SWAT & API Platform" DC
    Then Check employee in DC view for "Edward Jones SWAT & API Platform" in "Clients" of OrgChart

  Scenario: Verify DC view for Edward Jones EOG
    When Open path for "Clients" Dc tech and "Edward Jones EOG" DC
    Then Check employee in DC view for "Edward Jones EOG" in "Clients" of OrgChart

  Scenario: Verify DC view for Edward Jones Language and Data Management
    When Open path for "Clients" Dc tech and "Edward Jones Language and Data Management" DC
    Then Check employee in DC view for "Edward Jones Language and Data Management" in "Clients" of OrgChart

  Scenario: Verify DC view for Edward Jones ITSM
    When Open path for "Clients" Dc tech and "Edward Jones ITSM" DC
    Then Check employee in DC view for "Edward Jones ITSM" in "Clients" of OrgChart



#Internal
  Scenario: Verify DC view for Internal Athena
    When Open path for "Internal" Dc tech and "Internal Athena" DC
    Then Check employee in DC view for "Internal Athena" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal ProfitPulse
    When Open path for "Internal" Dc tech and "Internal ProfitPulse" DC
    Then Check employee in DC view for "Internal ProfitPulse" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal ATS
    When Open path for "Internal" Dc tech and "Internal ATS" DC
    Then Check employee in DC view for "Internal ATS" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Catalyst
    When Open path for "Internal" Dc tech and "Internal Catalyst" DC
    Then Check employee in DC view for "Internal Catalyst" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Data Quality Automation Tool
    When Open path for "Internal" Dc tech and "Internal Data Quality Automation Tool" DC
    Then Check employee in DC view for "Internal Data Quality Automation Tool" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Data Science
    When Open path for "Internal" Dc tech and "Internal Data Science" DC
    Then Check employee in DC view for "Internal Data Science" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal GemDuty
    When Open path for "Internal" Dc tech and "Internal GemDuty" DC
    Then Check employee in DC view for "Internal GemDuty" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Contripoint
    When Open path for "Internal" Dc tech and "Internal Contripoint" DC
    Then Check employee in DC view for "Internal Contripoint" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Neo-Retina
    When Open path for "Internal" Dc tech and "Internal Neo-Retina" DC
    Then Check employee in DC view for "Internal Neo-Retina" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Platform
    When Open path for "Internal" Dc tech and "Internal Platform" DC
    Then Check employee in DC view for "Internal Platform" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Gembook
    When Open path for "Internal" Dc tech and "Internal Gembook" DC
    Then Check employee in DC view for "Internal Gembook" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Helpdesk
    When Open path for "Internal" Dc tech and "Internal Helpdesk" DC
    Then Check employee in DC view for "Internal Helpdesk" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Hpipe
    When Open path for "Internal" Dc tech and "Internal Hpipe" DC
    Then Check employee in DC view for "Internal Hpipe" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal MIS
    When Open path for "Internal" Dc tech and "Internal MIS" DC
    Then Check employee in DC view for "Internal MIS" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Simulation
    When Open path for "Internal" Dc tech and "Internal Simulation" DC
    Then Check employee in DC view for "Internal Simulation" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal HRIS
    When Open path for "Internal" Dc tech and "Internal HRIS" DC
    Then Check employee in DC view for "Internal HRIS" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Insights
    When Open path for "Internal" Dc tech and "Internal Insights" DC
    Then Check employee in DC view for "Internal Insights" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Orgchart
    When Open path for "Internal" Dc tech and "Internal Orgchart" DC
    Then Check employee in DC view for "Internal Orgchart" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Quality Engineering
    When Open path for "Internal" Dc tech and "Internal Quality Engineering" DC
    Then Check employee in DC view for "Internal Quality Engineering" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Training
    When Open path for "Internal" Dc tech and "Internal Training" DC
    Then Check employee in DC view for "Internal Training" in "Internal" of OrgChart







#Pimco

  Scenario: Verify DC view for Pimco Infrastructure
    When Open path for "Clients" Dc tech and "Pimco Infrastructure" DC
    Then Check employee in DC view for "Pimco Infrastructure" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco RiskOps
    When Open path for "Clients" Dc tech and "Pimco RiskOps" DC
    Then Check employee in DC view for "Pimco RiskOps" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Quality Engineering
    When Open path for "Clients" Dc tech and "Pimco Quality Engineering" DC
    Then Check employee in DC view for "Pimco Quality Engineering" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco ServiceOps
    When Open path for "Clients" Dc tech and "Pimco ServiceOps" DC
    Then Check employee in DC view for "Pimco ServiceOps" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Reference Data
    When Open path for "Clients" Dc tech and "Pimco Reference Data" DC
    Then Check employee in DC view for "Pimco Reference Data" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Operations Tech
    When Open path for "Clients" Dc tech and "Pimco Operations Tech" DC
    Then Check employee in DC view for "Pimco Operations Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Portfolio Analytics Support
    When Open path for "Clients" Dc tech and "Pimco Portfolio Analytics Support" DC
    Then Check employee in DC view for "Pimco Portfolio Analytics Support" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Credit Research / PARR
    When Open path for "Clients" Dc tech and "Pimco Credit Research / PARR" DC
    Then Check employee in DC view for "Pimco Credit Research / PARR" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Security
    When Open path for "Clients" Dc tech and "Pimco Security" DC
    Then Check employee in DC view for "Pimco Security" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Batch Reports
    When Open path for "Clients" Dc tech and "Pimco Batch Reports" DC
    Then Check employee in DC view for "Pimco Batch Reports" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Client Solutions & Analytics
    When Open path for "Clients" Dc tech and "Pimco Client Solutions & Analytics" DC
    Then Check employee in DC view for "Pimco Client Solutions & Analytics" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Financial Engineering Services (FES)
    When Open path for "Clients" Dc tech and "Pimco Financial Engineering Services (FES)" DC
    Then Check employee in DC view for "Pimco Financial Engineering Services (FES)" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Client Data Intelligence & Sales Tech
    When Open path for "Clients" Dc tech and "Pimco Client Data Intelligence & Sales Tech" DC
    Then Check employee in DC view for "Pimco Client Data Intelligence & Sales Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Client Facing & Marketing Tech
    When Open path for "Clients" Dc tech and "Pimco Client Facing & Marketing Tech" DC
    Then Check employee in DC view for "Pimco Client Facing & Marketing Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Platform Success
    When Open path for "Clients" Dc tech and "Pimco Platform Success" DC
    Then Check employee in DC view for "Pimco Platform Success" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco SMA Tech
    When Open path for "Clients" Dc tech and "Pimco SMA Tech" DC
    Then Check employee in DC view for "Pimco SMA Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Client Data Science
    When Open path for "Clients" Dc tech and "Pimco Client Data Science" DC
    Then Check employee in DC view for "Pimco Client Data Science" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Data Ops
    When Open path for "Clients" Dc tech and "Pimco Data Ops" DC
    Then Check employee in DC view for "Pimco Data Ops" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco ETL
    When Open path for "Clients" Dc tech and "Pimco ETL" DC
    Then Check employee in DC view for "Pimco ETL" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Investment Data Dev
    When Open path for "Clients" Dc tech and "Pimco Investment Data Dev" DC
    Then Check employee in DC view for "Pimco Investment Data Dev" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Investment Ops
    When Open path for "Clients" Dc tech and "Pimco Investment Ops" DC
    Then Check employee in DC view for "Pimco Investment Ops" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Financial Engineering Infrastructure (FEI)
    When Open path for "Clients" Dc tech and "Pimco Financial Engineering Infrastructure (FEI)" DC
    Then Check employee in DC view for "Pimco Financial Engineering Infrastructure (FEI)" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Platform Engineering
    When Open path for "Clients" Dc tech and "Pimco Platform Engineering" DC
    Then Check employee in DC view for "Pimco Platform Engineering" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco ESG
    When Open path for "Clients" Dc tech and "Pimco ESG" DC
    Then Check employee in DC view for "Pimco ESG" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Legal & Regulatory Tech
    When Open path for "Clients" Dc tech and "Pimco Legal & Regulatory Tech" DC
    Then Check employee in DC view for "Pimco Legal & Regulatory Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Systematic Ops & Tooling
    When Open path for "Clients" Dc tech and "Pimco Systematic Ops & Tooling" DC
    Then Check employee in DC view for "Pimco Systematic Ops & Tooling" in "Clients" of OrgChart









#Other Clients

  Scenario: Verify DC view for Mifid Reporting
    When Open path for "Clients" Dc tech and "Mifid Reporting" DC
    Then Check employee in DC view for "Mifid Reporting" in "Clients" of OrgChart

  Scenario: Verify DC view for FinAdvisor
    When Open path for "Clients" Dc tech and "FinAdvisor" DC
    Then Check employee in DC view for "FinAdvisor" in "Clients" of OrgChart

  Scenario: Verify DC view for Sports Performance Analytics
    When Open path for "Clients" Dc tech and "Sports Performance Analytics" DC
    Then Check employee in DC view for "Sports Performance Analytics" in "Clients" of OrgChart

  Scenario: Verify DC view for Mosaic Smart Data
    When Open path for "Clients" Dc tech and "Mosaic Smart Data" DC
    Then Check employee in DC view for "Mosaic Smart Data" in "Clients" of OrgChart

  Scenario: Verify DC view for AFLI
    When Open path for "Clients" Dc tech and "AFLI" DC
    Then Check employee in DC view for "AFLI" in "Clients" of OrgChart

  Scenario: Verify DC view for ARADA Salesforce
    When Open path for "Clients" Dc tech and "ARADA Salesforce" DC
    Then Check employee in DC view for "ARADA Salesforce" in "Clients" of OrgChart

  Scenario: Verify DC view for Hartron
    When Open path for "Clients" Dc tech and "Hartron" DC
    Then Check employee in DC view for "Hartron" in "Clients" of OrgChart

  Scenario: Verify DC view for Sharemeister
    When Open path for "Clients" Dc tech and "Sharemeister" DC
    Then Check employee in DC view for "Sharemeister" in "Clients" of OrgChart

  Scenario: Verify DC view for DPLI/PLIL
    When Open path for "Clients" Dc tech and "DPLI/PLIL" DC
    Then Check employee in DC view for "DPLI/PLIL" in "Clients" of OrgChart

  Scenario: Verify DC view for Beacon DevOps
    When Open path for "Clients" Dc tech and "Beacon DevOps" DC
    Then Check employee in DC view for "Beacon DevOps" in "Clients" of OrgChart

  Scenario: Verify DC view for Tata Aig
    When Open path for "Clients" Dc tech and "Tata Aig" DC
    Then Check employee in DC view for "Tata Aig" in "Clients" of OrgChart

  Scenario: Verify DC view for TATA AIG Ops
    When Open path for "Clients" Dc tech and "TATA AIG Ops" DC
    Then Check employee in DC view for "TATA AIG Ops" in "Clients" of OrgChart

  Scenario: Verify DC view for Discern
    When Open path for "Clients" Dc tech and "Discern" DC
    Then Check employee in DC view for "Discern" in "Clients" of OrgChart

  Scenario: Verify DC view for IBKS
    When Open path for "Clients" Dc tech and "IBKS" DC
    Then Check employee in DC view for "IBKS" in "Clients" of OrgChart

  Scenario: Verify DC view for Emaar
    When Open path for "Clients" Dc tech and "Emaar" DC
    Then Check employee in DC view for "Emaar" in "Clients" of OrgChart

  Scenario: Verify DC view for IT
    When Open path for "Clients" Dc tech and "IT" DC
    Then Check employee in DC view for "IT" in "Clients" of OrgChart

  Scenario: Verify DC view for FAB
    When Open path for "Clients" Dc tech and "FAB" DC
    Then Check employee in DC view for "FAB" in "Clients" of OrgChart

  Scenario: Verify DC view for Pre-Sales
    When Open path for "Clients" Dc tech and "Pre-Sales" DC
    Then Check employee in DC view for "Pre-Sales" in "Clients" of OrgChart

  Scenario: Verify DC view for GemFin
    When Open path for "Clients" Dc tech and "GemFin" DC
    Then Check employee in DC view for "GemFin" in "Clients" of OrgChart

  Scenario: Verify DC view for Ekam
    When Open path for "Clients" Dc tech and "Ekam" DC
    Then Check employee in DC view for "Ekam" in "Clients" of OrgChart
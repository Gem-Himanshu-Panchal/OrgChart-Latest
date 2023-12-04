@RunDCVIEW
Feature: DC view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard
    And Switch to "DC" view


#    Support
@testhghg
  Scenario: Verify DC view for Accounts
    When Open path for "Support" Dc tech and "Accounts" DC
    Then Check employee in DC view for "Accounts" in "Support" of OrgChart
  @testhghg
  Scenario: Verify DC view for Human Resource
    When Open path for "Support" Dc tech and "Human Resource" DC
    Then Check employee in DC view for "Human Resource" in "Support" of OrgChart
  @testhghg
  Scenario: Verify DC view for Admin
    When Open path for "Support" Dc tech and "Admin" DC
    Then Check employee in DC view for "Admin" in "Support" of OrgChart




# EJ
  @testhghg
  Scenario: Verify DC view for Edward Jones Developer Platform
    When Open path for "Clients" Dc tech and "Edward Jones Developer Platform" DC
    Then Check employee in DC view for "Edward Jones Developer Platform" in "Clients" of OrgChart
  @testhghg
  Scenario: Verify DC view for Edward Jones DevSecOps
    When Open path for "Clients" Dc tech and "Edward Jones DevSecOps" DC
    Then Check employee in DC view for "Edward Jones DevSecOps" in "Clients" of OrgChart
  @testhghg
  Scenario: Verify DC view for Edward Jones Environments & ITSM
    When Open path for "Clients" Dc tech and "Edward Jones Environments & ITSM" DC
    Then Check employee in DC view for "Edward Jones Environments & ITSM" in "Clients" of OrgChart
  @testhghg
  Scenario: Verify DC view for Edward Jones Language and Data Management
    When Open path for "Clients" Dc tech and "Edward Jones Language and Data Management" DC
    Then Check employee in DC view for "Edward Jones Language and Data Management" in "Clients" of OrgChart

  Scenario: Verify DC view for Edward Jones Quality Engineering
    When Open path for "Clients" Dc tech and "Edward Jones Quality Engineering" DC
    Then Check employee in DC view for "Edward Jones Quality Engineering" in "Clients" of OrgChart
  @testhghg
  Scenario: Verify DC view for Edward Jones SWAT & API Platform
    When Open path for "Clients" Dc tech and "Edward Jones SWAT & API Platform" DC
    Then Check employee in DC view for "Edward Jones SWAT & API Platform" in "Clients" of OrgChart
  @testhghg
  Scenario: Verify DC view for Edward Jones EOG
    When Open path for "Clients" Dc tech and "Edward Jones EOG" DC
    Then Check employee in DC view for "Edward Jones EOG" in "Clients" of OrgChart



#Internal
  @testhghg
  Scenario: Verify DC view for Internal Athena
    When Open path for "Internal" Dc tech and "Internal Athena" DC
    Then Check employee in DC view for "Internal Athena" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal ATS
    When Open path for "Internal" Dc tech and "Internal ATS" DC
    Then Check employee in DC view for "Internal ATS" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Catalyst
    When Open path for "Internal" Dc tech and "Internal Catalyst" DC
    Then Check employee in DC view for "Internal Catalyst" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Contri-Neo-Retina
    When Open path for "Internal" Dc tech and "Internal Contri-Neo-Retina" DC
    Then Check employee in DC view for "Internal Contri-Neo-Retina" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Gembook
    When Open path for "Internal" Dc tech and "Internal Gembook" DC
    Then Check employee in DC view for "Internal Gembook" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Gemini Hpipe_Simul
    When Open path for "Internal" Dc tech and "Internal Gemini Hpipe_Simul" DC
    Then Check employee in DC view for "Internal Gemini Hpipe_Simul" in "Internal" of OrgChart

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

  Scenario: Verify DC view for Internal RnD
    When Open path for "Internal" Dc tech and "Internal RnD" DC
    Then Check employee in DC view for "Internal RnD" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal Training
    When Open path for "Internal" Dc tech and "Internal Training" DC
    Then Check employee in DC view for "Internal Training" in "Internal" of OrgChart

  Scenario: Verify DC view for Internal-GemFin
    When Open path for "Internal" Dc tech and "Internal-GemFin" DC
    Then Check employee in DC view for "Internal-GemFin" in "Internal" of OrgChart




#Pimco
  Scenario: Verify DC view for Pimco Analytics Support
    When Open path for "Clients" Dc tech and "Pimco Analytics Support" DC
    Then Check employee in DC view for "Pimco Analytics Support" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Client Facing Tech
    When Open path for "Clients" Dc tech and "Pimco Client Facing Tech" DC
    Then Check employee in DC view for "Pimco Client Facing Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Credit Research / PARR
    When Open path for "Clients" Dc tech and "Pimco Credit Research / PARR" DC
    Then Check employee in DC view for "Pimco Credit Research / PARR" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco CSA frontend & ABS Tech
    When Open path for "Clients" Dc tech and "Pimco CSA frontend & ABS Tech" DC
    Then Check employee in DC view for "Pimco CSA frontend & ABS Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Data Engineering
    When Open path for "Clients" Dc tech and "Pimco Data Engineering" DC
    Then Check employee in DC view for "Pimco Data Engineering" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Data Science
    When Open path for "Clients" Dc tech and "Pimco Data Science" DC
    Then Check employee in DC view for "Pimco Data Science" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco DevOps / Platform Engineering
    When Open path for "Clients" Dc tech and "Pimco DevOps / Platform Engineering" DC
    Then Check employee in DC view for "Pimco DevOps / Platform Engineering" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco EMEA Tech
    When Open path for "Clients" Dc tech and "Pimco EMEA" DC
    Then Check employee in DC view for "Pimco EMEA Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco FE Infrastructure
    When Open path for "Clients" Dc tech and "Pimco FE Infrastructure" DC
    Then Check employee in DC view for "Pimco FE Infrastructure" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Infrastructure
    When Open path for "Clients" Dc tech and "Pimco Infrastructure" DC
    Then Check employee in DC view for "Pimco Infrastructure" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Investment Data
    When Open path for "Clients" Dc tech and "Pimco Investment Data" DC
    Then Check employee in DC view for "Pimco Investment Data" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Operations Tech
    When Open path for "Clients" Dc tech and "Pimco Operations Tech" DC
    Then Check employee in DC view for "Pimco Operations Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Portfolio Analytics Support
    When Open path for "Clients" Dc tech and "Pimco Portfolio Analytics Support" DC
    Then Check employee in DC view for "Pimco Portfolio Analytics Support" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Puma
    When Open path for "Clients" Dc tech and "Pimco Puma" DC
    Then Check employee in DC view for "Pimco Puma" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Quality Engineering
    When Open path for "Clients" Dc tech and "Pimco Quality Engineering" DC
    Then Check employee in DC view for "Pimco Quality Engineering" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Reference Data
    When Open path for "Clients" Dc tech and "Pimco Reference Data" DC
    Then Check employee in DC view for "Pimco Reference Data" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco RiskOps
    When Open path for "Clients" Dc tech and "Pimco RiskOps" DC
    Then Check employee in DC view for "Pimco RiskOps" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Sales & Marketing Tech
    When Open path for "Clients" Dc tech and "Pimco Sales & Marketing Tech" DC
    Then Check employee in DC view for "Pimco Sales & Marketing Tech" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco Security
    When Open path for "Clients" Dc tech and "Pimco Security" DC
    Then Check employee in DC view for "Pimco Security" in "Clients" of OrgChart

  Scenario: Verify DC view for Pimco ServiceOps
    When Open path for "Clients" Dc tech and "Pimco ServiceOps" DC
    Then Check employee in DC view for "Pimco ServiceOps" in "Clients" of OrgChart



#Other Clients
  Scenario: Verify DC view for Discern
    When Open path for "Clients" Dc tech and "Discern" DC
    Then Check employee in DC view for "Discern" in "Clients" of OrgChart

  Scenario: Verify DC view for Hdfc Ergo
    When Open path for "Clients" Dc tech and "HDFC Ergo" DC
    Then Check employee in DC view for "Hdfc Ergo" in "Clients" of OrgChart

  Scenario: Verify DC view for Sports Performance Analytics
    When Open path for "Clients" Dc tech and "Sports Performance Analytics" DC
    Then Check employee in DC view for "Sports Performance Analytics" in "Clients" of OrgChart

  Scenario: Verify DC view for Mosaic Smart Data
    When Open path for "Clients" Dc tech and "Mosaic Smart Data" DC
    Then Check employee in DC view for "Mosaic Smart Data" in "Clients" of OrgChart

  Scenario: Verify DC view for Piston
    When Open path for "Clients" Dc tech and "Piston" DC
    Then Check employee in DC view for "Piston" in "Clients" of OrgChart

  Scenario: Verify DC view for AFLI
    When Open path for "Clients" Dc tech and "AFLI" DC
    Then Check employee in DC view for "AFLI" in "Clients" of OrgChart

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

#  Scenario: Verify any duplicate data in OrgChart employee view
#    When Search for any duplicate employee in OrgChart Gemini view
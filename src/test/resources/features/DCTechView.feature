@RunDCVIEW
Feature: DC view data validations

  Background: Verify if user successfully log into Orgchart
    When Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard
    And Switch to "DC" view


#    Support
  Scenario: Verify DC view for Accounts
    When Open path for "Support" Dc tech and "Accounts" DC
    And Open modals for "Support" in "Accounts"
    Then Check employee in DC view for "Accounts" of OrgChart



# EJ
  Scenario: Verify DC view for Edward Jones Developer Platform
    When Open path for "Clients" Dc tech and "Edward Jones Developer Platform" DC
    And Open modals for "Clients" in "Edward Jones Developer Platform"
    Then Check employee in DC view for "Edward Jones Developer Platform" of OrgChart

  Scenario: Verify DC view for Edward Jones DevSecOps
    When Open path for "Clients" Dc tech and "Edward Jones DevSecOps" DC
    And Open modals for "Clients" in "Edward Jones DevSecOps"
    Then Check employee in DC view for "Edward Jones DevSecOps" of OrgChart

  Scenario: Verify DC view for Edward Jones Environments & ITSM
    When Open path for "Clients" Dc tech and "Edward Jones Environments & ITSM" DC
    And Open modals for "Clients" in "Edward Jones Environments & ITSM"
    Then Check employee in DC view for "Edward Jones Environments & ITSM" of OrgChart

  Scenario: Verify DC view for Edward Jones Language and Data Management
    When Open path for "Clients" Dc tech and "Edward Jones Language and Data Management" DC
    And Open modals for "Clients" in "Edward Jones Language and Data Management"
    Then Check employee in DC view for "Edward Jones Language and Data Management" of OrgChart

  Scenario: Verify DC view for Edward Jones Quality Engineering
    When Open path for "Clients" Dc tech and "Edward Jones Quality Engineering" DC
    And Open modals for "Clients" in "Edward Jones Quality Engineering"
    Then Check employee in DC view for "Edward Jones Quality Engineering" of OrgChart

  Scenario: Verify DC view for Edward Jones SWAT & API Platform
    When Open path for "Clients" Dc tech and "Edward Jones SWAT & API Platform" DC
    And Open modals for "Clients" in "Edward Jones SWAT & API Platform"
    Then Check employee in DC view for "Edward Jones SWAT & API Platform" of OrgChart

  Scenario: Verify DC view for Edward Jones EOG
    When Open path for "Clients" Dc tech and "Edward Jones EOG" DC
    And Open modals for "Clients" in "Edward Jones EOG"
    Then Check employee in DC view for "Edward Jones EOG" of OrgChart



#Internal
  Scenario: Verify DC view for Internal Athena
    When Open path for "Internal" Dc tech and "Internal Athena" DC
    And Open modals for "Internal" in "Internal Athena"
    Then Check employee in DC view for "Internal Athena" of OrgChart

  @hihi
  Scenario: Verify DC view for Internal ATS
    When Open path for "Internal" Dc tech and "Internal ATS" DC
    And Open modals for "Internal" in "Internal ATS"
    Then Check employee in DC view for "Internal ATS" of OrgChart


  Scenario: Verify DC view for Internal Catalyst
    When Open path for "Internal" Dc tech and "Internal Catalyst" DC
    And Open modals for "Internal" in "Internal Catalyst"
    Then Check employee in DC view for "Internal Catalyst" of OrgChart


  Scenario: Verify DC view for Internal Contri-Neo-Retina
    When Open path for "Internal" Dc tech and "Internal Contri-Neo-Retina" DC
    And Open modals for "Internal" in "Internal Contri-Neo-Retina"
    Then Check employee in DC view for "Internal Contri-Neo-Retina" of OrgChart


  Scenario: Verify DC view for Internal Gembook
    When Open path for "Internal" Dc tech and "Internal Gembook" DC
    And Open modals for "Internal" in "Internal Gembook"
    Then Check employee in DC view for "Internal Gembook" of OrgChart


  Scenario: Verify DC view for Internal Gemini Hpipe_Simul
    When Open path for "Internal" Dc tech and "Internal Gemini Hpipe_Simul" DC
    And Open modals for "Internal" in "Internal Gemini Hpipe_Simul"
    Then Check employee in DC view for "Internal Gemini Hpipe_Simul" of OrgChart


  Scenario: Verify DC view for Internal HRIS
    When Open path for "Internal" Dc tech and "Internal HRIS" DC
    And Open modals for "Internal" in "Internal HRIS"
    Then Check employee in DC view for "Internal HRIS" of OrgChart


  Scenario: Verify DC view for Internal Insights
    When Open path for "Internal" Dc tech and "Internal Insights" DC
    And Open modals for "Internal" in "Internal Insights"
    Then Check employee in DC view for "Internal Insights" of OrgChart


  Scenario: Verify DC view for Internal Orgchart
    When Open path for "Internal" Dc tech and "Internal Orgchart" DC
    And Open modals for "Internal" in "Internal Orgchart"
    Then Check employee in DC view for "Internal Orgchart" of OrgChart

  Scenario: Verify DC view for Internal Quality Engineering
    When Open path for "Internal" Dc tech and "Internal Quality Engineering" DC
    And Open modals for "Internal" in "Internal Quality Engineering"
    Then Check employee in DC view for "Internal Quality Engineering" of OrgChart


  Scenario: Verify DC view for Internal RnD
    When Open path for "Internal" Dc tech and "Internal RnD" DC
    And Open modals for "Internal" in "Internal RnD"
    Then Check employee in DC view for "Internal RnD" of OrgChart


  Scenario: Verify DC view for Internal Training
    When Open path for "Internal" Dc tech and "Internal Training" DC
    And Open modals for "Internal" in "Internal Training"
    Then Check employee in DC view for "Internal Training" of OrgChart


  Scenario: Verify DC view for Internal-GemFin
    When Open path for "Internal" Dc tech and "Internal-GemFin" DC
    And Open modals for "Internal" in "Internal-GemFin"
    Then Check employee in DC view for "Internal-GemFin" of OrgChart




#Pimco
  Scenario: Verify DC view for Pimco Analytics Support
    When Open path for "Clients" Dc tech and "Pimco Analytics Support" DC
    And Open modals for "Clients" in "Pimco Analytics Support"
    Then Check employee in DC view for "Pimco Analytics Support" of OrgChart

  Scenario: Verify DC view for Pimco Client Facing Tech
    When Open path for "Clients" Dc tech and "Pimco Client Facing Tech" DC
    And Open modals for "Clients" in "Pimco Client Facing Tech"
    Then Check employee in DC view for "Pimco Client Facing Tech" of OrgChart

  Scenario: Verify DC view for Pimco Credit Research / PARR
    When Open path for "Clients" Dc tech and "Pimco Credit Research / PARR" DC
    And Open modals for "Clients" in "Pimco Credit Research / PARR"
    Then Check employee in DC view for "Pimco Credit Research / PARR" of OrgChart

  Scenario: Verify DC view for Pimco CSA frontend & ABS Tech
    When Open path for "Clients" Dc tech and "Pimco CSA frontend & ABS Tech" DC
    And Open modals for "Clients" in "Pimco CSA frontend & ABS Tech"
    Then Check employee in DC view for "Pimco CSA frontend & ABS Tech" of OrgChart

  Scenario: Verify DC view for Pimco Data Engineering
    When Open path for "Clients" Dc tech and "Pimco Data Engineering" DC
    And Open modals for "Clients" in "Pimco Data Engineering"
    Then Check employee in DC view for "Pimco Data Engineering" of OrgChart

  Scenario: Verify DC view for Pimco Data Science
    When Open path for "Clients" Dc tech and "Pimco Data Science" DC
    And Open modals for "Clients" in "Pimco Data Science"
    Then Check employee in DC view for "Pimco Data Science" of OrgChart

  Scenario: Verify DC view for Pimco DevOps / Platform Engineering
    When Open path for "Clients" Dc tech and "Pimco DevOps / Platform Engineering" DC
    And Open modals for "Clients" in "Pimco DevOps / Platform Engineering"
    Then Check employee in DC view for "Pimco DevOps / Platform Engineering" of OrgChart

  Scenario: Verify DC view for Pimco EMEA Tech
    When Open path for "Clients" Dc tech and "Pimco EMEA" DC
    And Open modals for "Clients" in "Pimco EMEA"
    Then Check employee in DC view for "Pimco EMEA Tech" of OrgChart

  Scenario: Verify DC view for Pimco FE Infrastructure
    When Open path for "Clients" Dc tech and "Pimco FE Infrastructure" DC
    And Open modals for "Clients" in "Pimco FE Infrastructure"
    Then Check employee in DC view for "Pimco FE Infrastructure" of OrgChart

  Scenario: Verify DC view for Pimco Infrastructure
    When Open path for "Clients" Dc tech and "Pimco Infrastructure" DC
    And Open modals for "Clients" in "Pimco Infrastructure"
    Then Check employee in DC view for "Pimco Infrastructure" of OrgChart

  Scenario: Verify DC view for Pimco Investment Data
    When Open path for "Clients" Dc tech and "Pimco Investment Data" DC
    And Open modals for "Clients" in "Pimco Investment Data"
    Then Check employee in DC view for "Pimco Investment Data" of OrgChart

  Scenario: Verify DC view for Pimco Operations Tech
    When Open path for "Clients" Dc tech and "Pimco Operations Tech" DC
    And Open modals for "Clients" in "Pimco Operations Tech"
    Then Check employee in DC view for "Pimco Operations Tech" of OrgChart

  Scenario: Verify DC view for Pimco Portfolio Analytics Support
    When Open path for "Clients" Dc tech and "Pimco Portfolio Analytics Support" DC
    And Open modals for "Clients" in "Pimco Portfolio Analytics Support"
    Then Check employee in DC view for "Pimco Portfolio Analytics Support" of OrgChart

  Scenario: Verify DC view for Pimco Puma
    When Open path for "Clients" Dc tech and "Pimco Puma" DC
    And Open modals for "Clients" in "Pimco Puma"
    Then Check employee in DC view for "Pimco Puma" of OrgChart

  Scenario: Verify DC view for Pimco Quality Engineering
    When Open path for "Clients" Dc tech and "Pimco Quality Engineering" DC
    And Open modals for "Clients" in "Pimco Quality Engineering"
    Then Check employee in DC view for "Pimco Quality Engineering" of OrgChart

  Scenario: Verify DC view for Pimco Reference Data
    When Open path for "Clients" Dc tech and "Pimco Reference Data" DC
    And Open modals for "Clients" in "Pimco Reference Data"
    Then Check employee in DC view for "Pimco Reference Data" of OrgChart

  Scenario: Verify DC view for Pimco RiskOps
    When Open path for "Clients" Dc tech and "Pimco RiskOps" DC
    And Open modals for "Clients" in "Pimco RiskOps"
    Then Check employee in DC view for "Pimco RiskOps" of OrgChart

  Scenario: Verify DC view for Pimco Sales & Marketing Tech
    When Open path for "Clients" Dc tech and "Pimco Sales & Marketing Tech" DC
    And Open modals for "Clients" in "Pimco Sales & Marketing Tech"
    Then Check employee in DC view for "Pimco Sales & Marketing Tech" of OrgChart

  Scenario: Verify DC view for Pimco Security
    When Open path for "Clients" Dc tech and "Pimco Security" DC
    And Open modals for "Clients" in "Pimco Security"
    Then Check employee in DC view for "Pimco Security" of OrgChart

  Scenario: Verify DC view for Pimco ServiceOps
    When Open path for "Clients" Dc tech and "Pimco ServiceOps" DC
    And Open modals for "Clients" in "Pimco ServiceOps"
    Then Check employee in DC view for "Pimco ServiceOps" of OrgChart



#Other Clients
  Scenario: Verify DC view for Discern
    When Open path for "Clients" Dc tech and "Discern" DC
    And Open modals for "Other Clients" in "Discern"
    Then Check employee in DC view for "Discern" of OrgChart

  Scenario: Verify DC view for Hdfc Ergo
    When Open path for "Clients" Dc tech and "HDFC Ergo" DC
    And Open modals for "Other Clients" in "Hdfc Ergo"
    Then Check employee in DC view for "Hdfc Ergo" of OrgChart

  Scenario: Verify DC view for Sports Performance Analytics
    When Open path for "Clients" Dc tech and "Sports Performance Analytics" DC
    And Open modals for "Clients" in "Sports Performance Analytics"
    Then Check employee in DC view for "Sports Performance Analytics" of OrgChart

  Scenario: Verify DC view for Mosaic Smart Data
    When Open path for "Clients" Dc tech and "Mosaic Smart Data" DC
    And Open modals for "Clients" in "Mosaic Smart Data"
    Then Check employee in DC view for "Mosaic Smart Data" of OrgChart

  Scenario: Verify DC view for Piston
    When Open path for "Clients" Dc tech and "Piston" DC
    And Open modals for "Clients" in "Piston"
    Then Check employee in DC view for "Piston" of OrgChart

  Scenario: Verify DC view for AFLI
    When Open path for "Clients" Dc tech and "AFLI" DC
    And Open modals for "Clients" in "AFLI"
    Then Check employee in DC view for "AFLI" of OrgChart

  Scenario: Verify DC view for Hartron
    When Open path for "Clients" Dc tech and "Hartron" DC
    And Open modals for "Clients" in "Hartron"
    Then Check employee in DC view for "Hartron" of OrgChart

  Scenario: Verify DC view for Sharemeister
    When Open path for "Clients" Dc tech and "Sharemeister" DC
    And Open modals for "Clients" in "Sharemeister"
    Then Check employee in DC view for "Sharemeister" of OrgChart

  Scenario: Verify DC view for DPLI/PLIL
    When Open path for "Clients" Dc tech and "DPLI/PLIL" DC
    And Open modals for "Clients" in "DPLI/PLIL"
    Then Check employee in DC view for "DPLI/PLIL" of OrgChart

  Scenario: Verify DC view for Beacon DevOps
    When Open path for "Clients" Dc tech and "Beacon DevOps" DC
    And Open modals for "Clients" in "Beacon DevOps"
    Then Check employee in DC view for "Beacon DevOps" of OrgChart

  Scenario: Verify DC view for Human Resource
    When Open path for "Clients" Dc tech and "Human Resource" DC
    And Open modals for "Clients" in "Human Resource"
    Then Check employee in DC view for "Human Resource" of OrgChart

  Scenario: Verify DC view for Tata Aig
    When Open path for "Clients" Dc tech and "Tata Aig" DC
    And Open modals for "Clients" in "Tata Aig"
    Then Check employee in DC view for "Tata Aig" of OrgChart

#  Scenario: Verify any duplicate data in OrgChart employee view
#    When Search for any duplicate employee in OrgChart Gemini view
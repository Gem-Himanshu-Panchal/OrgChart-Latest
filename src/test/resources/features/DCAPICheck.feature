@api
Feature: Api test DC

  Scenario Outline: API test for DC "<dcName>"
    When Hit endpoint for "<dcName>"
    Examples:
      | dcName                                        |
#      | Pimco Analytics Support                       |
#      | PIMCO Client Data Intelligence                |
#      | Pimco Client Facing Tech                      |
#      | Pimco Credit Research / PARR        |
#      | Pimco CSA frontend & ABS Tech                 |
#      | Pimco Data Engineering                        |
#      | Pimco Data Science                            |
#      | Pimco DevOps / Platform Engineering |
#      | Pimco EMEA Tech                               |
#      | Pimco FE Infrastructure                       |
#      | Pimco Infrastructure                          |
#      | Pimco Investment Data                         |
#      | Pimco Operations Tech                         |
#      | Pimco Portfolio Analytics Support             |
#      | Pimco Puma                                    |
#      | Pimco Quality Engineering                     |
#      | Pimco Reference Data                          |
#      | Pimco RiskOps                                 |
#      | Pimco Sales & Marketing Tech                  |
#      | Pimco Security                                |
#      | Pimco ServiceOps                              |
#      | Edward Jones Core Digital Support             |
#      | Edward Jones Developer Platform               |
#      | Edward Jones Environments & ITSM              |
#      | Edward Jones EOG                              |
#      | Edward Jones Language and Data Management     |
#      | Edward Jones Quality Engineering              |
#      | Edward Jones SWAT & API Platform              |
#      | AFLI                                          |
#      | Beacon DevOps                                 |
#      | Discern                                       |
#      | DPLI/PLIL                                   |
#      | Emaar                                         |
#      | FinAdvisor                                    |
#      | Hartron                                       |
#      | IBKS                                          |
      | IT                                            |
#      | Mosaic Smart Data                             |
#      | Sharemeister                                  |
#      | Sports Performance Analytics                  |
#      | Tata Aig                                      |
#      | Internal Athena                               |
#      | Internal ATS                                  |
#      | Internal Catalyst                             |
#      | Internal Contripoint                          |
#      | Internal Gembook                              |
#      | Internal Hpipe                                |
#      | Internal HRIS                                 |
#      | Internal Insights                             |
#      | Internal MIS                                  |
#      | Internal Neo-Retina                           |
#      | Internal Orgchart                             |
#      | Internal ProfitPulse                          |
#      | Internal Quality Engineering                  |
#      | Internal RnD                                  |
#      | Internal Simulation                           |
#      | Internal Training                             |
#      | Internal-GemFin                               |
#      | Accounts                                      |
#      | Admin                                         |
#      | Human Resource                                |
      | Management                                    |

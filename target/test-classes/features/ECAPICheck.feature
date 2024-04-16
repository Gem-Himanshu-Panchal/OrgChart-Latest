@ECapi
Feature: Api test EC

  Scenario Outline: API test for EC: "<dcName>"
    When Hit endpoint for EC "<dcName>"
    Examples:
      | dcName                            |
      | .Net                              |
      | Accounts                          |
      | Admin                             |
      | Architect                         |
      | Asset Management                  |
      | Data Engineering                  |
      | Data Science/Quant/ML             |
      | DesignBranding                    |
      | Devops                            |
      | Executive Office                  |
      | Full stack (Angular/ Node/ React) |
      | Human Resource                    |
      | Infrastructure/IT                 |
      | Insurance                         |
      | Java                              |
      | Management                        |
      | Python/C++                        |
      | QA                                |
      | Training                          |

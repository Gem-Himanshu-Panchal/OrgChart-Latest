@sanity
Feature: Sanity suite for OrgChart

  Background: Verify if user successfully log into Orgchart
    Given Navigate to OrgChart and login
    Then Verify if user is on OrgChart dashboard

  Scenario: Search valid name in global search box
    When Enter "Himanshu Panchal" in search box
    Then Verify if searched name "Himanshu Panchal" appear on screen


  Scenario: Search invalid name is global search box
    When Enter "Aarush Jain" in search box
    Then Verify if invalid name is searched

  Scenario: Verify if feedback form is working
    When Click on "Feedback form" button
    Then Verify if "Add Your Feedback" modal box appears on screen
    And Select "Functionality" value from feedback dropdown
    Then Enter "Hi this feedback is for testing purpose" in feedback description field
    And Click on "submit" button


  Scenario: Verify if feedback form collapse on clicking on cancel button
    When Click on "Feedback form" button
    Then Verify if "Add Your Feedback" modal box appears on screen
    And Select "Functionality" value from feedback dropdown
    Then Enter "Hi this feedback is for testing purpose" in feedback description field
    And Click on "cancel" button
    Then Verify if "Add Your Feedback" modal box disappears from screen

  Scenario: Verify if refresh button works as expected
    When Click on "Reset" button
    Then Verify if " Views Fetched Successfully " toast message appears on screen

  Scenario Outline: Verify if user is able to switch to different views
    When Click on "view" button
    And Select "<viewName>" value from views dropdown
    And Click on "view" button
    Then Verify if "<viewName>" view is selected
    Examples:
      | viewName |
      | DC       |
      | Pimco Dc |
      | EC       |

  Scenario: Verify if user is able to logout
    When Click on "Logout" button
    And Select account which user wants to logout
    Then Verify if user is successfully logout

  Scenario: Verify if user is able to search valid employee in Manage hierarchy tab
    When Click on "Admin" button
    And Search "Himanshu Panchal" in "Manage Hierarchy" view
    Then Verify if searched element "Himanshu Panchal" appear on screen

  Scenario: Verify if user is able to search invalid employee in Manage hierarchy tab
    When Click on "Admin" button
    And Search "Sheeza Bakshi" in "Manage Hierarchy" view
    Then Verify if searched invalid node name appear on screen

  Scenario: Verify if Update hierarchy button is working
    When Click on "Admin" button
    And Click on "Update Hierarchy" button
    Then Verify if "Update hierarchy using excel" modal box appears on screen

  Scenario: Verify if only valid file is allowed in update hierarchy modal box
    When Click on "Admin" button
    And Click on "Update Hierarchy" button
    Then Verify if "Update hierarchy using excel" modal box appears on screen
    And Upload a valid csv file in Upload excel div
    Then Verify if file uploaded successfully or not


  Scenario: Verify if user is unable to upload a invalid file
    When Click on "Admin" button
    And Click on "Update Hierarchy" button
    Then Verify if "Update hierarchy using excel" modal box appears on screen
    And Upload a invalid csv file in Upload excel div
    Then Verify if file is not uploaded successfully

  Scenario: Verify if user is able to download hierarchy
    When Click on "Admin" button
    And Click on "Export Hierarchy" button
    Then Verify if a csv file is downloaded

  Scenario Outline: Verify if user is able to navigate through different views in Manage hierarchy tab
    When Click on "Admin" button
    And Click on "View dropdown" button
    Then Choose "<viewName>" from the dropdown value
    Then Check if correct view "<viewName>" is selected
    Examples:
      | viewName |
      | Pimco Dc |
      | Ej Old   |
      | Ej New   |
      | EC       |

#Manage View
  Scenario: Verify if user is able to search for a valid view name
    When Click on "Admin" button
    And Click on "Manage View" button
    Then Search "Pimco Dc" in "Manage View" view
    Then Verify if correct view "Pimco Dc" is searched

  Scenario: Verify if user is able to search for a invalid view name
    When Click on "Admin" button
    And Click on "Manage View" button
    Then Search "Test xyz abc" in "Manage View" view
    Then Verify if incorrect view is searched

  Scenario: Verify if user is able to add a new view with valid information
    When Click on "Admin" button
    And Click on "Manage View" button
    And Click on "Add View" button
    Then Fill required details "Naruto123", "Employee", " Himanshu Panchal ", "dev"
    And Click on "Submit view" button
    Then Verify if "Create new view" is created

    Scenario: Verify if user is unable to create a view with special characters in its name
      When Click on "Admin" button
      And Click on "Manage View" button
      And Click on "Add View" button
      And Fill required details "Check!@#$%^", "Employee", " Himanshu Panchal ", "dev"
      Then Verify if submit button remains disabled

# Delete all CSV/XLS files before thi
  Scenario: Verify if user is able to download employees list
    When Click on "Admin" button
    And Click on "Manage View" button
    And Click on " Export Employees " button
    Then Verify if a csv file is downloaded

  Scenario: Verify if user is able to edit a existing view
    When Click on "Admin" button
    And Click on "Manage View" button
    And Click on "Edit" button to do some change
    Then Change view name to "NewViewName"
    And Click on " Update " button
    Then Verify if "NewViewName" name is changed


  Scenario: Verify if Update View modal collapse on clicking on cross icon
    When Click on "Admin" button
    And Click on "Manage View" button
    And Click on "Edit" button to do some change
    Then Verify if "Update View" modal box appears on screen
    And Click on "close" button
    Then Verify if "Update View" modal box disappears from screen


    Scenario: Verify if user is able to clone an existing view
      When Click on "Admin" button
      And Click on "Manage View" button
      And Click on "Clone View" button
      And Enter new clone view name "Check Cloning" into required input field
      Then Verify if "Check Cloning" name is changed


  Scenario: Verify if user is able to close clone view modal box
    When Click on "Admin" button
    And Click on "Manage View" button
    And Click on "Clone View" button
    And Click on "close" button
    Then Verify if "Clone View" modal box disappears from screen



  Scenario: Verify if user is able to delete a existing view
    When Click on "Admin" button
    And Click on "Manage View" button
    Then Save the name of view that we want to delete
    And Click on "Delete View" button
    And Click on "Yes, delete it!" button
    Then Verify if view is deleted
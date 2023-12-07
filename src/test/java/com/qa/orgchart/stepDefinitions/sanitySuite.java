package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.locators.sanityLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class sanitySuite {
    public static String lastViewName;
    @When("^Enter \"(.*)\" in search box$")
    public void enterInSearchBox(String validName) {
        try {
            GenericUtils.waitUntilElementAppear(sanityLocators.searchBox);
            DriverAction.typeText(sanityLocators.searchBox, validName);
            GemTestReporter.addTestStep("Enter text in search box", "Successfully entered " + validName + " in search box", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if searched name \"(.*)\" appear on screen$")
    public void verifyIfSearchedItemAppearOnScreen(String name) {
        try {
            if (GenericUtils.isExist(sanityLocators.searchedName(name))) {
                GemTestReporter.addTestStep("Verify if valid name is searched", "Successfully searched valid name", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify if valid name is searched",
                        "Unable to search valid name", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if invalid name is searched$")
    public void verifyIfInvalidNameIsSearched() {
        try {
            if (GenericUtils.isExist(sanityLocators.invalidNameSearch)) {
                GemTestReporter.addTestStep("Verify if invalid name is searched", "Successfully searched invalid name", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify if invalid name is searched",
                        "Unable to search invalid name", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @When("^Click on \"(.*)\" button$")
    public void clickOnButton(String btnName) {
        try {
            GenericUtils.clickOnButton(btnName);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if \"(.*)\" modal box appears on screen$")
    public void verifyIfModalBoxAppearsOnScreen(String modalName) {
        try {
            GenericUtils.waitUntilElementAppear(sanityLocators.modalValidation("div", modalName));
            if (GenericUtils.isExist(sanityLocators.modalValidation("span", modalName)) && !modalName.contains("Update hierarchy"))
                GemTestReporter.addTestStep("Verify if " + modalName + " modal appears on screen",
                        modalName + " modal appears on screen", STATUS.PASS, DriverAction.takeSnapShot());
            else if (GenericUtils.isExist(sanityLocators.modalValidation("div", modalName)))
                GemTestReporter.addTestStep("Verify if " + modalName + " modal appears on screen",
                        modalName + " modal appears on screen", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if " + modalName + " modal appears on screen",
                        "Unable to open " + modalName + " modal", STATUS.FAIL, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @And("^Select \"(.*)\" value from feedback dropdown$")
    public void selectValueFromFeedbackDropdown(String value) {
        try {
            GenericUtils.waitUntilElementAppear(sanityLocators.feedbackTypeDropdown);
            DriverAction.click(sanityLocators.feedbackTypeDownArrow);
            DriverAction.click(sanityLocators.dropdownValues(value));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Enter \"(.*)\" in feedback description field$")
    public void enterInFeedbackDescriptionField(String textValue) {
        try {
            GenericUtils.waitUntilElementAppear(sanityLocators.feedbackDescription);
            DriverAction.typeText(sanityLocators.feedbackDescription, textValue);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if \"(.*)\" modal box disappears from screen$")
    public void verifyIfModalBoxDisappearsFromScreen(String modalName) {
        try {
//            GenericUtils.waitUntilElementAppear(sanityLocators.modalValidation("div", modalName));
            DriverAction.waitSec(2);
            if (!GenericUtils.isExist(sanityLocators.modalValidation("span", modalName)))
                GemTestReporter.addTestStep("Verify if " + modalName + " modal disappears from screen",
                        modalName + " modal disappears from the screen", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if " + modalName + " modal disappears from screen",
                        "Modal box is still on the screen", STATUS.FAIL, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if \"(.*)\" toast message appears on screen$")
    public void verifyIfToastMessageAppearsOnScreen(String toastMessage) {
        try {
            GenericUtils.waitUntilElementAppear(sanityLocators.toastMessage(toastMessage));
            if (GenericUtils.isExist(sanityLocators.toastMessage(toastMessage)))
                GemTestReporter.addTestStep("Verify if " + toastMessage + " appears on screen",
                        toastMessage + " toast message appears on the screen", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if " + toastMessage + " appears on screen",
                        "Toast message doesn't appear on screen", STATUS.FAIL, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @And("^Select \"(.*)\" value from views dropdown$")
    public void selectValueFromViewsDropdown(String viewValue) {
        try {
            GenericUtils.waitUntilElementAppear(sanityLocators.viewsDropdown);
            DriverAction.click(sanityLocators.dropdownValues(viewValue));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if \"(.*)\" view is selected$")
    public void verifyIfViewIsSelected(String viewValue) {
        try {
            String extractedViewName = DriverAction.getElementText(sanityLocators.selectedView);
            if (extractedViewName.contains(viewValue))
                GemTestReporter.addTestStep("Verify if " + viewValue + " is selected successfully",
                        "Successfully selected " + viewValue + " view", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if " + viewValue + " is selected successfully",
                        "Unable to select " + viewValue + " view", STATUS.FAIL, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if user is successfully logout$")
    public void verifyIfUserIsSuccessfullyLogout() {
        try {
            GenericUtils.waitUntilElementAppear(sanityLocators.loginPage);
            if (GenericUtils.isExist(sanityLocators.loginPage))
                GemTestReporter.addTestStep("Verify if user is successfully logged out",
                        "User is successfully logged out", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if user is successfully logged out",
                        "Unable to log out", STATUS.FAIL, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @And("^Select account which user wants to logout$")
    public void selectAccountWhichUserWantsToLogout() {
        WebDriver driver = DriverManager.getWebDriver();
        try {
            String mainWin = driver.getWindowHandle();
            String popUpWin = null;
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            for (String handle : driver.getWindowHandles()) {
                if (!handle.equalsIgnoreCase(mainWin)) {
                    popUpWin = handle;
                    break;
                }
            }
            DriverAction.switchToWindow(popUpWin);
            GenericUtils.waitUntilElementAppear(CommonLocators.userName);
            DriverAction.click(CommonLocators.userName);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        } finally {
            if (driver.getWindowHandles().size() > 0) {
                String mainWindow = driver.getWindowHandles().iterator().next();
                DriverAction.switchToWindow(mainWindow);
            }
        }
    }

    @And("^Search \"(.*)\" in \"(.*)\" view$")
    public void searchANodeInView(String searchValue, String tabName) {
        try {
            DriverAction.waitSec(5);
            if (tabName.equalsIgnoreCase("Manage Hierarchy")) {
                DriverAction.typeText(sanityLocators.searchBoxField("Search Node"), searchValue);
            } else if (tabName.equalsIgnoreCase("Manage View")) {
                DriverAction.typeText(sanityLocators.searchBoxField("Search View"), searchValue);
            }else if (tabName.equalsIgnoreCase("Manage Team")) {
                DriverAction.typeText(sanityLocators.searchBoxField("Search Team"), searchValue);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if searched element \"(.*)\" appear on screen$")
    public void verifyIfSearchedElementAppearOnScreen(String nodeName) {
        try {
            if (GenericUtils.isExist(sanityLocators.searchedName))
                GemTestReporter.addTestStep("Verify if " + nodeName + " is searched successfully",
                        "Successfully searched: " + nodeName, STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if " + nodeName + " is searched successfully",
                        "Unable to search a node", STATUS.FAIL, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if searched invalid node name appear on screen$")
    public void verifyIfSearchedInvalidNodeNameAppearOnScreen() {
        try {
            if (GenericUtils.isExist(sanityLocators.invalidNameSearchResult))
                GemTestReporter.addTestStep("Verify if invalid name search is working as expected",
                        "No node is searched", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if invalid name search is working as expected",
                        "Invalid response on screen", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @And("^Upload a valid csv file in Upload excel div$")
    public void uploadAValidCsvFileInUploadExcelDiv() {
        try {
            String basePath = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\validCSV.xlsx";
            DriverAction.fileUpload(sanityLocators.fileUpload, basePath);
            DriverAction.waitSec(5);

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if file uploaded successfully or not$")
    public void verifyIfFileUploadedSuccessfullyOrNot() {
        try {
            if (GenericUtils.isExist(sanityLocators.uploadedFileName))
                GemTestReporter.addTestStep("Verify if file is uploaded successfully or not",
                        "Successfully uploaded a file", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if file is uploaded successfully or not",
                        "Unable to add file", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @And("^Upload a invalid csv file in Upload excel div$")
    public void uploadAInvalidCsvFileInUploadExcelDiv() {
        try {
            String basePath = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\PDF1.pdf";
            DriverAction.fileUpload(sanityLocators.fileUpload, basePath);
            DriverAction.waitSec(5);

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if file is not uploaded successfully$")
    public void verifyIfFileIsNotUploadedSuccessfully() {
        try {
            if (!GenericUtils.isExist(sanityLocators.uploadedFileName))
                GemTestReporter.addTestStep("Verify if file is uploaded successfully or not",
                        "Successfully uploaded a file", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if file is uploaded successfully or not",
                        "Unable to add file", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if a csv file is downloaded$")
    public void verifyIfACsvFileIsDownloaded() {
        try {
            DriverAction.waitSec(10);
            String downloadPath = "C:\\Users\\himanshu.panchal\\Downloads";
            File downloadDir = new File(downloadPath);

            File[] downloadedFiles = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xls"));

            if (downloadedFiles != null && downloadedFiles.length > 0) {
                GemTestReporter.addTestStep("Verify if a csv file is downloaded",
                        "Successfully downloaded a file", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify if a csv file is downloaded",
                        "Unable to download a file", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Choose \"(.*)\" from the dropdown value$")
    public void chooseFromTheDropdownValue(String viewName) {
        try {
            DriverAction.click(sanityLocators.dropdownValues(viewName));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Check if correct view \"(.*)\" is selected$")
    public void checkIfCorrectViewIsSelected(String viewName) {
        try {
            if (DriverAction.getElementText(sanityLocators.viewPlaceholder).equalsIgnoreCase(viewName))
                GemTestReporter.addTestStep("Check if correct view is selected",
                        "Successfully navigated to correct view", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Check if correct view is selected",
                        "Unable to navigate to right view", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if correct view \"(.*)\" is searched$")
    public void verifyIfCorrectViewIsSearched(String viewName) {
        try {
            DriverAction.waitSec(2);
            List<String> tempList = DriverAction.getElementsText(sanityLocators.viewNameList);
            if (tempList.size() == 1 && tempList.get(0).equalsIgnoreCase(viewName))
                GemTestReporter.addTestStep("Verify if correct view is searched",
                        "Successfully searched correct view", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if correct view is searched",
                        "Unable to search right view", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if incorrect view is searched$")
    public void verifyIfIncorrectViewIsSearched() {
        try {
            DriverAction.waitSec(2);
            List<String> tempList = DriverAction.getElementsText(sanityLocators.viewNameList);
            if (tempList.size() == 0)
                GemTestReporter.addTestStep("Verify if incorrect view is searched",
                        "Successfully searched incorrect view", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if incorrect view is searched",
                        "Unable to search wrong view", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Fill required details \"(.*)\", \"(.*)\", \"(.*)\", \"(.*)\"$")
    public void fillRequiredDetails(String viewName, String rootNode, String name, String roleName) {
        try {
            List<WebElement> downArrows = DriverAction.getElements(sanityLocators.downArrows);
            DriverAction.typeText(sanityLocators.viewNameInput, viewName);
            downArrows.get(0).click();
            DriverAction.click(sanityLocators.elementWithText("span", rootNode.toUpperCase()));
            DriverAction.waitSec(3);
            downArrows.get(1).click();
            DriverAction.typeText(sanityLocators.searchBox, name);
            DriverAction.click(sanityLocators.elementWithText("div", name));
            downArrows.get(2).click();
            DriverAction.click(sanityLocators.elementWithText("span", roleName));
            GemTestReporter.addTestStep("Enter required details into Add view modal box",
                    "Successfully entered details", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if \"(.*)\" is created$")
    public void verifyIfIsCreated(String viewName) {
        try {
            DriverAction.waitSec(4);
            List<String> viewNames = DriverAction.getElementsText(sanityLocators.viewNamesList);
            if (viewNames.contains(viewName))
                GemTestReporter.addTestStep("Verify if " + viewName + " is created",
                        "Successfully created new view", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if " + viewName + " is created",
                        "Unable to create new view", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on \"(.*)\" button to do some change$")
    public void clickOnButtonToDoSomeChange() {
        try {
            DriverAction.waitSec(3);
            List<WebElement> editButtons = DriverAction.getElements(sanityLocators.editBtn);
            DriverAction.waitSec(2);
            editButtons.get(editButtons.size() - 1).click();

            GemTestReporter.addTestStep("Click on edit button to do some change",
                    "Successfully clicked on Edit button", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Change view name to \"(.*)\"$")
    public void changeViewNameTo(String viewName) {
        try {
            DriverAction.clearText(sanityLocators.updateViewInput);
            DriverAction.typeText(sanityLocators.updateViewInput, viewName);

            GemTestReporter.addTestStep("Change view name to: " + viewName,
                    "Successfully changed view name", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if \"(.*)\" name is changed$")
    public void verifyIfNameIsChanged(String viewName) {
        try {
            DriverAction.waitSec(4);
            List<String> viewNames = DriverAction.getElementsText(sanityLocators.viewNamesList);
            if (viewNames.contains(viewName))
                GemTestReporter.addTestStep("Verify if " + viewName + " is created",
                        "Successfully created new view", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if " + viewName + " is created",
                        "Unable to create new view", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @And("^Enter new clone view name \"(.*)\" into required input field$")
    public void enterNewCloneViewNameIntoRequiredInputField(String viewName) {
        try {
            DriverAction.waitSec(2);
            DriverAction.typeText(sanityLocators.newViewNameInputBox, viewName);
            DriverAction.click(sanityLocators.submitBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if submit button remains disabled$")
    public void verifyIfSubmitButtonRemainsDisabled() {
        try {
            if (GenericUtils.isExist(sanityLocators.cautionMessage)) {
                GemTestReporter.addTestStep("Check if a caution message is displayed under View name field",
                        "Caution text is visible", STATUS.PASS, DriverAction.takeSnapShot());
                if (GenericUtils.isExist(sanityLocators.inactiveSubmitButton)) {
                    GemTestReporter.addTestStep("Check if a Submit button is inactive",
                            "Submit button is inactive", STATUS.PASS, DriverAction.takeSnapShot());
                } else GemTestReporter.addTestStep("Check if a Submit button is inactive",
                        "Submit button is active", STATUS.FAIL, DriverAction.takeSnapShot());
            } else GemTestReporter.addTestStep("Check if a caution message is displayed under View name field",
                    "No caution text is visible", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if view is deleted$")
    public void verifyIfIsDeleted() {
        try {
            DriverAction.waitSec(4);
            List<String> viewNames = DriverAction.getElementsText(sanityLocators.viewNamesList);
            if (!viewNames.contains(lastViewName))
                GemTestReporter.addTestStep("Verify if " + lastViewName + " is deleted",
                        "Successfully deleted new view", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Verify if " + lastViewName + " is created",
                        "Unable to delete existing view", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("Save the name of view that we want to delete")
    public void saveTheNameOfViewThatWeWantToDelete() {
        try{
            DriverAction.waitSec(4);
            List<String> viewNames = DriverAction.getElementsText(sanityLocators.viewNamesList);
            lastViewName = viewNames.get(viewNames.size()-1);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }
}
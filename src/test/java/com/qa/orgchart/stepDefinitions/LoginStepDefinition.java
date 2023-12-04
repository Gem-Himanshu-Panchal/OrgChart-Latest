package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.gemini.generic.utils.ProjectConfigData;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.requirements.reports.ScenarioOutcome;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinition {
    @Then("^Switch to \"(.*)\" view$")
    public static void switchToView(String viewName) {
        try {
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitUntilElementAppear(CommonLocators.dropdownBox, 30);
            DriverAction.waitUntilElementClickable(CommonLocators.dropdownBox, 20);
            DriverAction.click(CommonLocators.dropdownBox);
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitUntilElementAppear(CommonLocators.viewValue(viewName), 30);
            if (!GenericUtils.isExist(CommonLocators.viewValue(viewName))) {
                DriverAction.refresh();
                GenericUtils.waitUntilLoaderDisappear();
                DriverAction.waitUntilElementClickable(CommonLocators.dropdownBox, 20);
                DriverAction.click(CommonLocators.dropdownBox);
                DriverAction.waitSec(1);
                DriverAction.waitUntilElementAppear(CommonLocators.viewValue(viewName), 10);
            }
            DriverAction.scrollIntoView(CommonLocators.viewValue(viewName));
            DriverAction.getElement(CommonLocators.viewValue(viewName)).click();
            GenericUtils.waitUntilLoaderDisappear();
            if (DriverAction.isExist(CommonLocators.selectedView(viewName))) {
                GemTestReporter.addTestStep("Select " + viewName + " from view dropdown"
                        , "Successfully selected " + viewName + " view", STATUS.PASS, DriverAction.takeSnapShot());

            } else GemTestReporter.addTestStep("Select " + viewName + " from view dropdown"
                    , "Unable to select " + viewName + " view", STATUS.FAIL, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @When("^Navigate to OrgChart and login$")
    public synchronized void navigateToOrgChartAndLogin() {
        try {
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitUntilElementAppear(CommonLocators.loginButton, 30);
            if (GenericUtils.isExist(CommonLocators.loginButton)) {
                DriverAction.click(CommonLocators.loginButton);
                GemTestReporter.addTestStep("Click on Login button"
                        , "Successfully clicked on login button", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                DriverAction.refresh();
                GenericUtils.waitUntilLoaderDisappear();
                DriverAction.refresh();
                GenericUtils.waitUntilLoaderDisappear();
                DriverAction.waitUntilElementAppear(CommonLocators.loginButton, 30);
                if (GenericUtils.isExist(CommonLocators.loginButton)) {
                    DriverAction.click(CommonLocators.loginButton);
                    GemTestReporter.addTestStep("Click on Login button"
                            , "Successfully clicked on login button", STATUS.PASS, DriverAction.takeSnapShot());
                } else
                    GemTestReporter.addTestStep("Click on Login button"
                            , "Unable to click on login button", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            WebDriver driver = DriverManager.getWebDriver();
            String mainWin = driver.getWindowHandle();
            try {
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

                byte[] decodingString = Base64.decodeBase64(ProjectConfigData.getProperty("password"));
                String passwordDecoded = new String(decodingString);
                DriverAction.waitUntilElementAppear(CommonLocators.loginEmail, 30);
                if (GenericUtils.isExist(CommonLocators.loginEmail)) {
                    DriverAction.typeText(CommonLocators.loginEmail, ProjectConfigData.getProperty("email"));
                    DriverAction.click(CommonLocators.submitButton);
                }
                DriverAction.waitUntilElementAppear(CommonLocators.loginPswd, 30);
                if (GenericUtils.isExist(CommonLocators.loginPswd)) {
                    DriverAction.typeText(CommonLocators.loginPswd, passwordDecoded);
                    DriverAction.click(CommonLocators.submitButton);
                }
                DriverAction.waitUntilElementAppear(CommonLocators.submitButton, 30);
                DriverAction.click(CommonLocators.submitButton);
                DriverAction.waitSec(2);
                DriverAction.switchToWindow(mainWin);
                GenericUtils.waitUntilLoaderDisappear();
                if (driver.getWindowHandles().size() > 0) {
                    String mainWindow = driver.getWindowHandles().iterator().next();
                    DriverAction.switchToWindow(mainWindow);
                }
                DriverAction.switchToWindow(mainWin);
                if (GenericUtils.isExist(CommonLocators.invalidHTTPRequestToastMessage)) {
                    DriverAction.refresh();
                    DriverAction.waitSec(3);
                    GenericUtils.waitUntilLoaderDisappear();
                    DriverAction.waitUntilElementAppear(CommonLocators.loginButton, 30);
                    DriverAction.click(CommonLocators.loginButton);
                }
            } catch (Exception e) {
                GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify if user is on OrgChart dashboard$")
    public void verifyIfUserIsOnOrgChartDashboard() {
        try {
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitUntilElementAppear(CommonLocators.chartContainer, 30);
            if (GenericUtils.isExist(CommonLocators.companyLogo) && GenericUtils.isExist(CommonLocators.chartContainer)
                    && GenericUtils.isExist(CommonLocators.searchField)) {
                GemTestReporter.addTestStep("Verify if User is logged into OrgChart"
                        , "Successfully logged into OrgChart", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify if User is logged into OrgChart"
                        , "Unable to log into Orgchart", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }
}

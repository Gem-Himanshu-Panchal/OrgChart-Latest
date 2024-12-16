package com.qa.orgchart.stepDefinitions;


import com.gemini.gemjar.enums.Status;
import com.gemini.gemjar.reporting.GemTestReporter;
import com.gemini.gemjar.utils.app.ProjectConfigData;
import com.gemini.gemjar.utils.ui.DriverAction;
import com.gemini.gemjar.utils.ui.DriverManager;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinition {
    @Then("^switches to the \"(.*)\" mode$")
    public static void switchToViewMode(String viewName) {
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
            System.out.println(CommonLocators.selectedView(viewName));
            if (GenericUtils.isExist(CommonLocators.selectedView(viewName))) {
                GemTestReporter.addTestStep("Select " + viewName + " from view dropdown"
                        , "Successfully selected " + viewName + " view", Status.PASS, DriverAction.takeSnapShot());

            } else GemTestReporter.addTestStep("Select " + viewName + " from view dropdown"
                    , "Unable to select " + viewName + " view", Status.FAIL, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
            throw new RuntimeException(e);
        }
    }
    private final Object lock = new Object();
    @Given("^a user is logged into OrgChart$")
    public synchronized void userLoggedIn() {
        try {
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitUntilElementAppear(CommonLocators.loginButton, 30);
            if (GenericUtils.isExist(CommonLocators.loginButton)) {
                DriverAction.click(CommonLocators.loginButton);
                GemTestReporter.addTestStep("Click on Login button"
                        , "Successfully clicked on login button", Status.PASS, DriverAction.takeSnapShot());
            } else {
                DriverAction.refresh();
                GenericUtils.waitUntilLoaderDisappear();
                DriverAction.refresh();
                GenericUtils.waitUntilLoaderDisappear();
                GenericUtils.waitUntilElementAppear(CommonLocators.loginButton);
                if (GenericUtils.isExist(CommonLocators.loginButton)) {
                    DriverAction.click(CommonLocators.loginButton);
                    GemTestReporter.addTestStep("Click on Login button"
                            , "Successfully clicked on login button", Status.PASS, DriverAction.takeSnapShot());
                } else
                    GemTestReporter.addTestStep("Click on Login button"
                            , "Unable to click on login button", Status.FAIL, DriverAction.takeSnapShot());
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

                GenericUtils.switchToNewWindow(popUpWin);

                byte[] decodingString = Base64.decodeBase64(ProjectConfigData.getProperty("password"));
                String passwordDecoded = new String(decodingString);
                GenericUtils.waitUntilElementAppear(CommonLocators.loginEmail);
                synchronized ((lock)) {
                    if (GenericUtils.isExist(CommonLocators.loginEmail)) {
                        DriverAction.typeText(CommonLocators.loginEmail, ProjectConfigData.getProperty("email"));
                        DriverAction.click(CommonLocators.submitButton);
                        GenericUtils.waitUntilElementAppear(CommonLocators.loginPswd);
                        if (GenericUtils.isExist(CommonLocators.loginPswd)) {
                            DriverAction.typeText(CommonLocators.loginPswd, passwordDecoded);
                            DriverAction.click(CommonLocators.submitButton);
                        }
                    }
                }
                DriverAction.waitUntilElementAppear(CommonLocators.submitButton, 30);
                DriverAction.click(CommonLocators.submitButton);
                DriverAction.waitSec(2);
                GenericUtils.switchToNewWindow(mainWin);
                GenericUtils.waitUntilLoaderDisappear();

                GenericUtils.switchToNewWindow(mainWin);
                DriverAction.waitUntilElementAppear(CommonLocators.invalidHTTPRequestToastMessage,15);
                if (GenericUtils.isExist(CommonLocators.invalidHTTPRequestToastMessage)) {
                    DriverAction.refresh();
                    DriverAction.waitSec(3);
                    GenericUtils.waitUntilLoaderDisappear();
                    DriverAction.waitUntilElementAppear(CommonLocators.loginButton, 30);
                    DriverAction.click(CommonLocators.loginButton);
                }
            } catch (Exception e) {
                GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("^the user navigates to the OrgChart dashboard$")
    public void navigateToDashboard() {
        try {
            GenericUtils.waitUntilLoaderDisappear();
            String mainWin = DriverAction.getWindowHandle();
            GenericUtils.switchToNewWindow(mainWin);
            DriverAction.waitUntilElementAppear(CommonLocators.companyLogo, 30);
            DriverAction.refresh();
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitUntilElementAppear(CommonLocators.companyLogo, 30);
            if (GenericUtils.isExist(CommonLocators.companyLogo) && GenericUtils.isExist(CommonLocators.chartContainer)
                    && GenericUtils.isExist(CommonLocators.searchField)) {
                GemTestReporter.addTestStep("Verify if User is logged into OrgChart"
                        , "Successfully logged into OrgChart", Status.PASS, DriverAction.takeSnapShot());
            }else {
                DriverAction.refresh();
                mainWin = DriverAction.getWindowHandle();
                GenericUtils.switchToNewWindow(mainWin);
                GenericUtils.waitUntilLoaderDisappear();
                if(GenericUtils.isExist(CommonLocators.loginButton)) {
                    DriverAction.click(CommonLocators.loginButton);
                }
                else{
                    DriverAction.refresh();
                    mainWin = DriverAction.getWindowHandle();
                    GenericUtils.switchToNewWindow(mainWin);
                    GenericUtils.waitUntilLoaderDisappear();
                    DriverAction.waitUntilElementAppear(CommonLocators.companyLogo, 30);
                    DriverAction.waitUntilElementAppear(CommonLocators.chartContainer, 30);
                    if (GenericUtils.isExist(CommonLocators.companyLogo) && GenericUtils.isExist(CommonLocators.chartContainer)
                            && GenericUtils.isExist(CommonLocators.searchField)) {
                        GemTestReporter.addTestStep("Verify if User is logged into OrgChart"
                                , "Successfully logged into OrgChart", Status.PASS, DriverAction.takeSnapShot());
                    }
                    else {
                        GemTestReporter.addTestStep("Verify if User is logged into OrgChart"
                                , "Unable to log into Orgchart", Status.FAIL, DriverAction.takeSnapShot());
                    }
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
            throw new RuntimeException(e);
        }
    }
}

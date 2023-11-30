package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinition {
    @Then("^Switch to \"(.*)\" view$")
    public static void switchToView(String viewName) {
        try {
            GenericUtils.waitUntilLoaderDisappear();
            GenericUtils.waitUntilElementAppear(CommonLocators.dropdownBox);
            DriverAction.click(CommonLocators.dropdownBox);
            GenericUtils.waitUntilLoaderDisappear();
            GenericUtils.waitUntilElementAppear(CommonLocators.viewValue(viewName));
            if(!GenericUtils.isExist(CommonLocators.viewValue(viewName))){
                DriverAction.click(CommonLocators.dropdownBox);
                DriverAction.waitSec(1);
                GenericUtils.waitUntilElementAppear(CommonLocators.viewValue(viewName));
            }
            DriverAction.scrollIntoView(CommonLocators.viewValue(viewName));
            GenericUtils.waitUntilElementAppear(CommonLocators.viewValue(viewName));
            DriverAction.getElement(CommonLocators.viewValue(viewName)).click();
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    @When("^Navigate to OrgChart and login$")
    public void navigateToOrgChartAndLogin() {
        try {
            GenericUtils.waitUntilLoaderDisappear();
            GenericUtils.waitUntilElementAppear(CommonLocators.loginButton);
            if (GenericUtils.isExist(CommonLocators.loginButton)) {
                DriverAction.click(CommonLocators.loginButton);
                GemTestReporter.addTestStep("Click on Login button"
                        , "Successfully clicked on login button", STATUS.PASS, DriverAction.takeSnapShot());
            } else
                GemTestReporter.addTestStep("Click on Login button"
                        , "Unable to click on login button", STATUS.FAIL, DriverAction.takeSnapShot());
            WebDriver driver = DriverManager.getWebDriver();

            if (GenericUtils.isExist(CommonLocators.invalidHTTPRequestToastMessage)) {
                DriverAction.refresh();
                DriverAction.waitSec(2);
                DriverAction.refresh();
                DriverAction.waitSec(2);
                GenericUtils.waitUntilElementAppear(CommonLocators.loginButton);
                DriverAction.click(CommonLocators.loginButton);
                DriverAction.refresh();
            }
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
                GenericUtils.waitUntilElementAppear(CommonLocators.loginEmail);
                if (GenericUtils.isExist(CommonLocators.loginEmail)) {
                    DriverAction.typeText(CommonLocators.loginEmail, "himanshu.panchal@geminisolutions.com");
                    DriverAction.click(CommonLocators.submitButton);
                }
                GenericUtils.waitUntilElementAppear(CommonLocators.loginPswd);
                if (GenericUtils.isExist(CommonLocators.loginPswd)) {
                    DriverAction.typeText(CommonLocators.loginPswd, "HimuAug@1808");
                    DriverAction.click(CommonLocators.submitButton);
                }
                GenericUtils.waitUntilElementAppear(CommonLocators.submitButton);
                DriverAction.click(CommonLocators.submitButton);
                DriverAction.waitSec(2);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(driver.getWindowHandles().size()>0) {
                    String mainWindow = driver.getWindowHandles().iterator().next();
                    DriverAction.switchToWindow(mainWindow);

                    if (GenericUtils.isExist(CommonLocators.invalidHTTPRequestToastMessage)) {
                        DriverAction.refresh();
                        DriverAction.waitSec(2);
                        DriverAction.refresh();
                        DriverAction.waitSec(2);
                        GenericUtils.waitUntilElementAppear(CommonLocators.loginButton);
                        DriverAction.click(CommonLocators.loginButton);
                        DriverAction.refresh();
                    }
                }
            }

            if (GenericUtils.isExist(CommonLocators.invalidHTTPRequestToastMessage)) {
                DriverAction.refresh();
                DriverAction.waitSec(2);
                DriverAction.refresh();
                DriverAction.waitSec(2);
                GenericUtils.waitUntilElementAppear(CommonLocators.loginButton);
                DriverAction.click(CommonLocators.loginButton);
                DriverAction.refresh();
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
            GenericUtils.waitUntilElementAppear(CommonLocators.chartContainer);
            if (GenericUtils.isExist(CommonLocators.companyLogo) && GenericUtils.isExist(CommonLocators.chartContainer)
                    && GenericUtils.isExist(CommonLocators.searchField)) {
                GemTestReporter.addTestStep("Verify if User is logged into OrgChart"
                        , "Successfully logged into OrgChart", STATUS.PASS, DriverAction.takeSnapShot());
            } else{
                GemTestReporter.addTestStep("Verify if User is logged into OrgChart"
                        , "Unable to log into Orgchart", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }
}

package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeminiView {

    @When("^Search for any duplicate employee in OrgChart Gemini view$")
    public void searchForAnyDuplicateEmployeeInOrgChartGeminiView() {
        try {
            List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();

            assert hashMapList != null;
            for (HashMap<String, String> stringStringHashMap : hashMapList) {
                String name = stringStringHashMap.get("EmployeeName");
                String code = stringStringHashMap.get("EmployeeCode");

                List<WebElement> li = DriverAction.getElements(CommonLocators.dataSource("name", name, "EmployeeCode", code));

                if (li.size() > 1) {
                    System.out.println(name + " " + code);
                }

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }


    @When("^Open hierarchy in Gemini view and verify details$")
    public void openHierarchyToTestInGeminiView() {
        int flag = 1;
        int mFlag = 1;
        GenericUtils.waitUntilLoaderDisappear();
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();

        List<String> reportingManager = new ArrayList<>();
        List<String> mentees;

        if (hashMapList != null) {
            Lastloop:
            for (int i = 71; i < hashMapList.size(); i++) {
                HashMap<String, String> hashMap = hashMapList.get(i);
                String manager = hashMap.get("ReportingManager");
                String manageCode = hashMap.get("ManagerCode");
                if (manager.equalsIgnoreCase("Vishal Malik"))
                    continue;

                if (!reportingManager.contains(manager))
                    reportingManager.add(hashMap.get("ReportingManager"));
                else continue;

                System.out.println(mFlag + ". Manager: " + manager);
                List<String> userHierarchy = GenericUtils.getManagerHierarchy(manager, manageCode);
                mentees = GenericUtils.getMenteesList(hashMap.get("ReportingManager"));
                System.out.println("Mentees: " + mentees);
                System.out.println();
                int lastIndex = userHierarchy.size() - 1;
                while (userHierarchy.size() != 2) {
                    DriverAction.waitSec(1);
                    if (!GenericUtils.isExist(CommonLocators.employeeDiv(userHierarchy.get(lastIndex - 1), userHierarchy.get(lastIndex)))) {
                        GemTestReporter.addTestStep(i + ". Verify if " + userHierarchy.get(0) + " is at right hierarchy or not",
                                userHierarchy.get(0) + " is missing from hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                        continue Lastloop;
                    }
                    DriverAction.scrollIntoView(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                    DriverAction.scrollToBottom();
                    DriverAction.waitSec(1);
                    GenericUtils.waitUntilElementAppear(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                    DriverAction.hoverOver(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));

                    DriverAction.scrollIntoView(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                    DriverAction.scrollToBottom();
                    DriverAction.waitSec(1);
                    GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                    if (!DriverAction.isExist(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)))) {
                        DriverAction.hoverOver(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                        DriverAction.waitSec(1);
                    }
                    DriverAction.getElement(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex))).click();
                    userHierarchy.remove(lastIndex);
                    userHierarchy.remove(lastIndex - 1);
                    lastIndex = userHierarchy.size() - 1;
                }
                DriverAction.scrollIntoView(CommonLocators.employeeName2(manager));
                if (GenericUtils.isExist(CommonLocators.employeeDiv(manager, manageCode))) {
                    GemTestReporter.addTestStep(flag + ". " + "Verify if " + manager + " is present or not",
                            manager + " is present", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Verify if " + manager + " is at right hierarchy or not",
                            flag + ". " + manager + " is not present", STATUS.FAIL, DriverAction.takeSnapShot());
                    continue;
                }
                DriverAction.hoverOver(CommonLocators.employeeDiv(manager, manageCode));
                GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", manageCode));

                if (DriverAction.isExist(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", manageCode))
                        && DriverAction.isExist(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", manageCode)))
                    DriverAction.getElement(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", manageCode)).click();
                else {
                    GemTestReporter.addTestStep(i + ". Verify if " + userHierarchy.get(0) + " is at right hierarchy or not",
                            manager + " is missing from hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                    continue;
                }

                List<WebElement> menteeCountOnApplication = DriverAction.getElements(CommonLocators.menteeCount(manager, manageCode));


                int menteeCount = mentees.size();

                if (menteeCountOnApplication.size() > menteeCount) {
                    GemTestReporter.addTestStep("Verify number of mentee",
                            "Application have more mantees under: " + manager, STATUS.FAIL, DriverAction.takeSnapShot());
                }

                for (int j = 0; j < menteeCount; j = j + 2) {
                    DriverAction.waitSec(1);
                    hashMap = GenericUtils.getEmployeeData(mentees.get(0), manager);
                    DriverAction.scrollIntoView(CommonLocators.employeeName(mentees.get(0), mentees.get(1)));
                    if (GenericUtils.isExist(CommonLocators.employeeName(mentees.get(0), mentees.get(1)))) {
                        GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " is present or not",
                                mentees.get(0) + " is present", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " is at right hierarchy or not",
                                mentees.get(0) + " is not present", STATUS.FAIL, DriverAction.takeSnapShot());
                        mentees.remove(0);
                        mentees.remove(0);
                        continue;
                    }


                    DriverAction.getElement(CommonLocators.employeeDiv(mentees.get(0), mentees.get(1))).click();
                    GenericUtils.waitUntilElementAppear(CommonLocators.infoCard);

                    if (!GenericUtils.isExist(CommonLocators.checkInfoCard)) {
                        GemTestReporter.addTestStep("Verify if users info card is opened or not",
                                "Unable to open info card of " + mentees.get(0), STATUS.FAIL, DriverAction.takeSnapShot());
                        mentees.remove(0);
                        mentees.remove(0);
                        continue;
                    }

                    assert hashMap != null;
                    List<String> resp = GenericUtils.verifyEmployeeDetails(hashMap);


                    if (resp.get(0).equalsIgnoreCase("True")) {
                        GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " has right values",
                                mentees.get(0) + " has right values", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " is at right hierarchy or not",
                                mentees.get(0) + " has wrong value: " + resp.get(1), STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                    DriverAction.getElement(CommonLocators.crossIcon).click();
                    mentees.remove(0);
                    mentees.remove(0);
                }


                DriverAction.click(CommonLocators.companyLogo);
                GenericUtils.waitUntilLoaderDisappear();
                GenericUtils.waitUntilElementAppear(CommonLocators.chartContainer);
                flag++;
                mFlag++;
            }
        }
    }
}
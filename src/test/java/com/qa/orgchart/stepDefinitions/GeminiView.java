package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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


//    @When("^Open hierarchy in Gemini view and verify details$")
//    public void openHierarchyToTestInGeminiView() {
//        int flag = 1;
//        int mFlag = 1;
//        GenericUtils.waitUntilLoaderDisappear();
//        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
//
//        List<String> reportingManager = new ArrayList<>();
//        List<String> mentees;
//
//        if (hashMapList != null) {
//            Lastloop:
//            for (int i = 0; i < hashMapList.size(); i++) {
//                HashMap<String, String> hashMap = hashMapList.get(i);
//                String manager = hashMap.get("ReportingManager");
//                String manageCode = hashMap.get("ManagerCode");
//                if (manager.equalsIgnoreCase("Vishal Malik"))
//                    continue;
//
//                if (!reportingManager.contains(manager))
//                    reportingManager.add(hashMap.get("ReportingManager"));
//                else continue;
//
//                System.out.println(mFlag + ". Manager: " + manager);
//                List<String> userHierarchy = GenericUtils.getManagerHierarchy(manager, manageCode);
//                mentees = GenericUtils.getMenteesList(hashMap.get("ReportingManager"));
//                System.out.println("Mentees: " + mentees);
//                System.out.println();
//                int lastIndex = userHierarchy.size() - 1;
//                while (userHierarchy.size() != 2) {
//                    DriverAction.waitSec(1);
//                    if (!GenericUtils.isExist(CommonLocators.employeeDiv(userHierarchy.get(lastIndex - 1), userHierarchy.get(lastIndex)))) {
//                        GemTestReporter.addTestStep(i + ". Verify if " + userHierarchy.get(0) + " is at right hierarchy or not",
//                                userHierarchy.get(0) + " is missing from hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
//                        GemTestReporter.addTestStep("Verify user hierarchy",
//                                "Check " + manager + " hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
//                        continue Lastloop;
//                    }
//                    DriverAction.scrollIntoView(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
//                    DriverAction.scrollToBottom();
//                    DriverAction.waitSec(1);
//                    GenericUtils.waitUntilElementAppear(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
//                    DriverAction.hoverOver(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
//
//                    DriverAction.scrollIntoView(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
//                    DriverAction.scrollToBottom();
//                    DriverAction.waitSec(1);
//                    GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
//                    if (!GenericUtils.isExist(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)))) {
//                        DriverAction.hoverOver(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
//                        DriverAction.waitSec(1);
//                    }
//                    DriverAction.getElement(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex))).click();
//                    userHierarchy.remove(lastIndex);
//                    userHierarchy.remove(lastIndex - 1);
//                    lastIndex = userHierarchy.size() - 1;
//                }
//                DriverAction.scrollIntoView(CommonLocators.employeeName2(manager));
//                if (GenericUtils.isExist(CommonLocators.employeeDiv(manager, manageCode))) {
//                    GemTestReporter.addTestStep(flag + ". " + "Verify if " + manager + " is present or not",
//                            manager + " is present", STATUS.PASS, DriverAction.takeSnapShot());
//                } else {
//                    GemTestReporter.addTestStep("Verify if " + manager + " is at right hierarchy or not",
//                            flag + ". " + manager + " is not present", STATUS.FAIL, DriverAction.takeSnapShot());
//                    DriverAction.refresh();
//                    continue;
//                }
//                DriverAction.hoverOver(CommonLocators.employeeDiv(manager, manageCode));
//                GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", manageCode));
//
//                if (GenericUtils.isExist(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", manageCode))
//                        && GenericUtils.isExist(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", manageCode)))
//                    DriverAction.getElement(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", manageCode)).click();
//                else {
//                    GemTestReporter.addTestStep(i + ". Verify if " + userHierarchy.get(0) + " is at right hierarchy or not",
//                            manager + " is missing from hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
//                    continue;
//                }
//
//                List<WebElement> menteeCountOnApplication = DriverAction.getElements(CommonLocators.menteeCount(manager, manageCode));
//
//
//                int menteeCount = mentees.size();
//
//                if (menteeCountOnApplication.size() > menteeCount) {
//                    GemTestReporter.addTestStep("Verify number of mentee",
//                            "Application have more mantees under: " + manager, STATUS.FAIL, DriverAction.takeSnapShot());
//                }
//
//                for (int j = 0; j < menteeCount; j = j + 2) {
//                    DriverAction.waitSec(1);
//                    hashMap = GenericUtils.getEmployeeData(mentees.get(0), manager);
//                    DriverAction.scrollIntoView(CommonLocators.employeeName(mentees.get(0), mentees.get(1)));
//                    if (GenericUtils.isExist(CommonLocators.employeeName(mentees.get(0), mentees.get(1)))) {
//                        GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " is present or not",
//                                mentees.get(0) + " is present", STATUS.PASS, DriverAction.takeSnapShot());
//                    } else {
//                        GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " is present or not",
//                                mentees.get(0) + " is not present", STATUS.FAIL, DriverAction.takeSnapShot());
//                        mentees.remove(0);
//                        mentees.remove(0);
//                        continue;
//                    }
//
//
//                    DriverAction.getElement(CommonLocators.employeeDiv(mentees.get(0), mentees.get(1))).click();
//                    GenericUtils.waitUntilElementAppear(CommonLocators.infoCard);
//
//                    if (!GenericUtils.isExist(CommonLocators.checkInfoCard)) {
//                        GemTestReporter.addTestStep("Verify if users info card is opened or not",
//                                "Unable to open info card of " + mentees.get(0), STATUS.FAIL, DriverAction.takeSnapShot());
//                        mentees.remove(0);
//                        mentees.remove(0);
//                        continue;
//                    }
//
//                    assert hashMap != null;
//                    List<String> resp = GenericUtils.verifyEmployeeDetails(hashMap);
//
//
//                    if (resp.get(0).equalsIgnoreCase("True")) {
//                        GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " has right values",
//                                mentees.get(0) + " has right values", STATUS.PASS, DriverAction.takeSnapShot());
//                    } else {
//                        GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " is at right hierarchy or not",
//                                mentees.get(0) + " has wrong value: " + resp.get(1), STATUS.FAIL, DriverAction.takeSnapShot());
//                    }
//                    DriverAction.getElement(CommonLocators.crossIcon).click();
//                    mentees.remove(0);
//                    mentees.remove(0);
//                }
//
//
////                DriverAction.click(CommonLocators.companyLogo);
//                DriverAction.refresh();
//                GenericUtils.waitUntilLoaderDisappear();
//                GenericUtils.waitUntilElementAppear(CommonLocators.chartContainer);
//                flag++;
//                mFlag++;
//            }
//        }
//    }

    @When("^Open hierarchy in Gemini view for \"(.*)\" to \"(.*)\" managers$")
    public void testNewGemini(int start, int end) {
        List<String> mentorNames = null;
        List<String> mentorCodes = null;

        GenericUtils.waitUntilLoaderDisappear();
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();

        List<String> mentees;

        try {
            String filePath = "src/test/java/com/qa/orgchart/jsonData/MentorsNameList";
            String filePathCode = "src/test/java/com/qa/orgchart/jsonData/MentorsCodeList";

            mentorNames = readNamesFromFile(filePath);
            mentorCodes = readNamesFromFile(filePathCode);
            System.out.println(mentorNames);
            System.out.println(mentorCodes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (hashMapList != null) {

                Lastloop:
                for (int i = start; i < end; i++) {
                    assert mentorNames != null;
                    String manager = mentorNames.get(i);
                    assert mentorCodes != null;
                    String managerCode = mentorCodes.get(i);

                    if (manager.equalsIgnoreCase("Vishal Malik"))
                        continue;

                    System.out.println(i + ". Manager: " + manager);

                    List<String> userHierarchy = GenericUtils.getManagerHierarchy(manager, managerCode);
                    mentees = GenericUtils.getMenteesList(manager);
                    System.out.println("Mentees: " + mentees);
                    System.out.println();
                    int lastIndex = userHierarchy.size() - 1;

                    while (userHierarchy.size() != 2) {
                        DriverAction.waitSec(1);
                        if (!GenericUtils.isExist(CommonLocators.employeeDiv(userHierarchy.get(lastIndex - 1), userHierarchy.get(lastIndex)))) {
                            GemTestReporter.addTestStep(i + ". Verify if " + userHierarchy.get(0) + " is at right hierarchy or not",
                                    userHierarchy.get(0) + " is missing from hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                            GemTestReporter.addTestStep("Verify user hierarchy",
                                    "Check " + manager + " hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                            continue Lastloop;
                        }
                        DriverAction.scrollIntoView(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                        DriverAction.scrollToBottom();

                        GenericUtils.waitUntilElementAppear(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                        DriverAction.hoverOver(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));

                        DriverAction.scrollIntoView(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                        DriverAction.scrollToBottom();

                        GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                        if (!GenericUtils.isExist(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)))) {
                            DriverAction.hoverOver(CommonLocators.dataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex)));
                            DriverAction.waitSec(1);
                        }
                        DriverAction.getElement(CommonLocators.downArrowDataSource("name", userHierarchy.get(lastIndex - 1), "EmployeeCode", userHierarchy.get(lastIndex))).click();
                        userHierarchy.remove(lastIndex);
                        userHierarchy.remove(lastIndex - 1);
                        lastIndex = userHierarchy.size() - 1;
                    }


//                    DriverAction.scrollIntoView(CommonLocators.employeeName2(manager));
                    GenericUtils.scrollToElement(manager,managerCode);
                    if (GenericUtils.isExist(CommonLocators.employeeDiv(manager, managerCode))) {
                        GemTestReporter.addTestStep(i + ". " + "Verify if manager: " + manager + " is present or not",
                                manager + " is present", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep(i + ". Verify if manager: " + manager + " is present or not",
                                manager + " is not present", STATUS.FAIL, DriverAction.takeSnapShot());
                        DriverAction.refresh();
                        continue;
                    }
                    DriverAction.hoverOver(CommonLocators.employeeDiv(manager, managerCode));
                    GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", managerCode));

                    if (GenericUtils.isExist(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", managerCode))
                            && GenericUtils.isExist(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", managerCode)))
                        DriverAction.getElement(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", managerCode)).click();
                    else {
                        GemTestReporter.addTestStep(i + ". Verify if manager: " + userHierarchy.get(0) + " is at right hierarchy or not",
                                manager + " is missing from hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                        continue;
                    }

                    List<WebElement> menteeCountOnApplication = DriverAction.getElements(CommonLocators.menteeCount(manager, managerCode));


                    int menteeCount = mentees.size();

                    if (menteeCountOnApplication.size() > menteeCount) {
                        GemTestReporter.addTestStep("Verify number of mentee",
                                "Application have more mantees under: " + manager, STATUS.FAIL, DriverAction.takeSnapShot());
                    }

                    for (int j = 0; j < menteeCount; j = j + 2) {
                        DriverAction.waitSec(1);
                        HashMap<String, String> hashMap = GenericUtils.getEmployeeData(mentees.get(0), manager);
                        DriverAction.scrollIntoView(CommonLocators.employeeName(mentees.get(0), mentees.get(1)));
                        if (GenericUtils.isExist(CommonLocators.employeeName(mentees.get(0), mentees.get(1)))) {
                            GemTestReporter.addTestStep("Verify if mentee: " + mentees.get(0) + " is present or not",
                                    mentees.get(0) + " is present", STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep("Verify if mentee: " + mentees.get(0) + " is present or not",
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
                            GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " has right values",
                                    mentees.get(0) + " has wrong value: " + resp.get(1), STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                        DriverAction.getElement(CommonLocators.crossIcon).click();
                        mentees.remove(0);
                        mentees.remove(0);
                    }

                    DriverAction.refresh();
                    GenericUtils.waitUntilLoaderDisappear();
                    GenericUtils.waitUntilElementAppear(CommonLocators.chartContainer);
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }

    private static List<String> readNamesFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }

}
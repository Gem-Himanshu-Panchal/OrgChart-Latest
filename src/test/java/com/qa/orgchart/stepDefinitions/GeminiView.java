package com.qa.orgchart.stepDefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.gemini.gemjar.enums.Status;
import com.gemini.gemjar.reporting.GemTestReporter;
import com.gemini.gemjar.utils.ui.DriverAction;
import com.gemini.gemjar.utils.ui.DriverManager;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.io.File;
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
                    GemTestReporter.addTestStep("Duplicate"
                            , name + "   " + code, Status.FAIL);
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL, DriverAction.takeSnapShot());
            throw new RuntimeException(e);
        }
    }
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (hashMapList != null) {
                if (start == 180)
                    end = mentorNames.size();
                Lastloop:
                for (int i = start; i < end; i++) {
                    assert mentorNames != null;
                    String manager = mentorNames.get(i);
                    assert mentorCodes != null;
                    String managerCode = mentorCodes.get(i);
//                    if (manager.equalsIgnoreCase("Vishal Malik") || manager.equalsIgnoreCase("Anil Singh") || manager.equalsIgnoreCase("Anil Pahal"))
                    if (manager.equalsIgnoreCase("Anil Singh"))
                    continue;
                    List<String> userHierarchy = GenericUtils.getManagerHierarchy(manager, managerCode);
                    mentees = GenericUtils.getMenteesList(manager);
                    System.out.println("Mentor: " + manager);
                    System.out.println("Mentees: " + mentees);
                    System.out.println();
                    int lastIndex = userHierarchy.size() - 1;
                    while (userHierarchy.size() != 2) {
                        DriverAction.waitSec(1);
                        if (!GenericUtils.isExist(CommonLocators.employeeDiv(userHierarchy.get(lastIndex - 1), userHierarchy.get(lastIndex)))) {
                            GemTestReporter.addTestStep(i + ". Verify if " + userHierarchy.get(lastIndex - 1) + " is at right hierarchy or not",
                                    userHierarchy.get(lastIndex - 1) + " is missing from hierarchy", Status.FAIL, DriverAction.takeSnapShot());
                            GemTestReporter.addTestStep("Check " + manager + " hierarchy",
                                    manager + " is having incomplete hierarchy", Status.FAIL, DriverAction.takeSnapShot());
                            DriverAction.refresh();
                            GenericUtils.waitUntilLoaderDisappear();
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
                    if (GenericUtils.isExist(CommonLocators.employeeDiv(manager, managerCode))) {
                        GenericUtils.scrollToElement(manager, managerCode);
                        GemTestReporter.addTestStep(i + ". " + "Verify if manager: " + manager + " is present or not",
                                manager + " is present", Status.PASS);
                    } else {
                        GemTestReporter.addTestStep(i + ". Verify if manager: " + manager + " is present or not",
                                manager + " is not present", Status.FAIL, DriverAction.takeSnapShot());
                        DriverAction.refresh();
                        continue;
                    }
                    DriverAction.hoverOver(CommonLocators.employeeDiv(manager, managerCode));
                    GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", managerCode));
                    if (GenericUtils.isExist(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", managerCode)))
                        DriverAction.getElement(CommonLocators.downArrowDataSource("name", manager, "EmployeeCode", managerCode)).click();
                    else {
                        GemTestReporter.addTestStep(i + ". Verify if manager: " + userHierarchy.get(0) + " is at right hierarchy or not",
                                manager + " is missing from hierarchy", Status.FAIL, DriverAction.takeSnapShot());
                        DriverAction.refresh();
                        continue;
                    }
                    List<WebElement> menteeCountOnApplication = DriverAction.getElements(CommonLocators.menteeCount(manager, managerCode));
                    int menteeCount = mentees.size();

                    if (menteeCountOnApplication.size() > menteeCount) {
                        GemTestReporter.addTestStep("Verify number of mentee",
                                "Application have more mentees under: " + manager, Status.FAIL, DriverAction.takeSnapShot());
                    }
                    for (int j = 0; j < menteeCount; j = j + 2) {
                        DriverAction.waitSec(1);
                        HashMap<String, String> hashMap = GenericUtils.getEmployeeData(mentees.get(0), manager);
                        DriverAction.scrollIntoView(CommonLocators.hierarchyCheck(manager, managerCode, mentees.get(0), mentees.get(1)));
                        if (GenericUtils.isExist(CommonLocators.hierarchyCheck(manager, managerCode, mentees.get(0), mentees.get(1)))) {
                            GemTestReporter.addTestStep("Verify if mentee: " + mentees.get(0) + " is present or not",
                                    mentees.get(0) + " is present", Status.PASS);
                        } else {
                            GemTestReporter.addTestStep("Verify if mentee: " + mentees.get(0) + " is present or not",
                                    mentees.get(0) + " is not present", Status.FAIL, DriverAction.takeSnapShot());
                            mentees.remove(0);
                            mentees.remove(0);
                            continue;
                        }
                        DriverAction.getElement(CommonLocators.employeeDiv(mentees.get(0), mentees.get(1))).click();
                        GenericUtils.waitUntilLoaderDisappear();
                        GenericUtils.waitUntilElementAppear(CommonLocators.infoCard);
                        if (!GenericUtils.isExist(CommonLocators.checkInfoCard)) {
                            DriverAction.getElement(CommonLocators.employeeDiv(mentees.get(0), mentees.get(1))).click();
                            GenericUtils.waitUntilElementAppear(CommonLocators.infoCard);
                            if (!GenericUtils.isExist(CommonLocators.checkInfoCard)) {
                                GemTestReporter.addTestStep("Verify if users info card is opened or not",
                                        "Unable to open info card of " + mentees.get(0), Status.FAIL, DriverAction.takeSnapShot());
                                mentees.remove(0);
                                mentees.remove(0);
                                DriverAction.refresh();
                                GenericUtils.waitUntilLoaderDisappear();
                                continue;
                            }
                        }
                        assert hashMap != null;
                        List<String> resp = GenericUtils.verifyEmployeeDetails(hashMap);
                        if (resp.get(0).equalsIgnoreCase("True")) {
                            GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " has right values",
                                    mentees.get(0) + " has right values", Status.PASS);
                        } else {
                            GemTestReporter.addTestStep("Verify if " + mentees.get(0) + " has right values",
                                    mentees.get(0) + " has wrong value: " + resp.get(1), Status.FAIL, DriverAction.takeSnapShot());
                        }
                        DriverAction.getElement(CommonLocators.crossIcon).click();
                        mentees.remove(0);
                        mentees.remove(0);
                    }
                    DriverAction.refresh();
                    if (GenericUtils.isExist(CommonLocators.chartContainer)
                            && GenericUtils.isExist(CommonLocators.searchField)) {
                        System.out.println("Hello world");
                    } else {
                        DriverAction.refresh();
                    }
                    GenericUtils.waitUntilLoaderDisappear();
                    GenericUtils.waitUntilElementAppear(CommonLocators.chartContainer);
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL, DriverAction.takeSnapShot());
            throw new RuntimeException(e);
        }
    }
    private static List<String> readNamesFromFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        return Files.readAllLines(path);
    }
    @And("Go to Dashboard")
    public void goToDashboard() {
        try {
            DriverAction.click(CommonLocators.companyLogo);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL, DriverAction.takeSnapShot());
            throw new RuntimeException(e);
        }
    }
    @When("^Search for any extra employee$")
    public void searchForAnyExtraEmployee() {
        try {
            DriverAction.waitSec(5);
            List<WebElement> hiddenElements = DriverAction.getElements(CommonLocators.allEmployeesName);
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
            List<String> extractedEmpNames = new ArrayList<>();

            for (WebElement element : hiddenElements) {
                extractedEmpNames.add((String) js.executeScript("return arguments[0].textContent;", element));
            }
            String filePath = "src/test/java/com/qa/orgchart/jsonData/updatedJsonPayload.json";
            List<String> jsonEmpNames = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));
            for (JsonNode employeeNode : rootNode) {
                String employeeName = employeeNode.get("EmployeeName").asText();
                jsonEmpNames.add(employeeName);
            }
            for (int i = 0; i < extractedEmpNames.size(); i++) {
                if (!jsonEmpNames.contains(extractedEmpNames.get(i))) {
                    GemTestReporter.addTestStep("Extra employee list", "Employee Name: " + extractedEmpNames.get(i), Status.FAIL);
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL, DriverAction.takeSnapShot());
            throw new RuntimeException(e);
        }
    }
}
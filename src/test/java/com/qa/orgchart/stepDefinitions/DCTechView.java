package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class DCTechView {
    static String chair = null;
    static List<WebElement> firstRowEmployees = null;

    @When("^Open modals in \"(.*)\"$")
    public static void clickOnDownArrows(String teamBox) {
        GenericUtils.waitUntilLoaderDisappear();
        DriverAction.waitSec(3);
        DriverAction.scrollIntoView(By.xpath("//tr[@class='nodes']//table//tr//td//div[@class='node cursorPointer']//img"));
        GenericUtils.waitUntilElementAppear(By.xpath("//tr[@class='nodes']//table//tr//td//div[@class='node cursorPointer']//img"));
        DriverAction.hoverOver(By.xpath("//tr[@class='nodes']//table//tr//td//div[@class='node cursorPointer']//img"));
        GenericUtils.waitUntilElementAppear(By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']"));
        DriverAction.getElement(By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']")).click();
        GenericUtils.waitUntilElementAppear(CommonLocators.ecTeamBox(teamBox));
        DriverAction.scrollIntoView(CommonLocators.ecTeamBox(teamBox));
        GenericUtils.waitUntilElementAppear(CommonLocators.ecTeamBox(teamBox));
        DriverAction.hoverOver(CommonLocators.ecTeamBox(teamBox));
        chair = null;
        if (GenericUtils.isExist(CommonLocators.chairBox(teamBox))) {
            chair = DriverAction.getElementText(CommonLocators.chairName(teamBox));
        }
        GenericUtils.waitUntilElementAppear(By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']"));
        DriverAction.getElement(By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']")).click();
        DriverAction.waitSec(3);
        GenericUtils.waitUntilLoaderDisappear();
//        GenericUtils.waitUntilElementAppear(By.xpath("(//tr[@class='nodes'])[3]/td/table//div[@class='node cursorPointer']"));
//        firstRowEmployees = DriverAction.getElements(By.xpath("(//tr[@class='nodes'])[3]/td/table//div[@class='node cursorPointer']"));
        GenericUtils.waitUntilElementAppear(By.xpath("(//div[contains(text(),'"+teamBox+"')]/ancestor::table)[last()]//tr[@class='nodes']//div[@class='node cursorPointer']"));
        firstRowEmployees = DriverAction.getElements(By.xpath("(//div[contains(text(),'"+teamBox+"')]/ancestor::table)[last()]//tr[@class='nodes']//div[@class='node cursorPointer']"));
        DriverAction.waitSec(1);
        List<WebElement> members = DriverAction.getElements(By.xpath("(//tr[@class='nodes'])[3]/td/table"));
        String path1 = "(//tr[@class='nodes'])[3]/td/table";
        String endPath = "/tr[@class='nodes']/td/table";
        while (!members.isEmpty()) {
            for (WebElement member : members) {
                DriverAction.scrollIntoView(member);
                DriverAction.hoverOver(member);
                if (GenericUtils.isExist(CommonLocators.downArrow)) {
                    DriverAction.getElement(CommonLocators.downArrow).click();
                    DriverAction.waitSec(1);
                }
            }
            members.clear();
            path1 = path1 + endPath;
            members.addAll(DriverAction.getElements(By.xpath(path1)));

        }
    }

    @Then("^Check employee in DC view for \"(.*)\" of OrgChart$")
    public void checkForEmployeeInDcViewOfOrgChart(String dcTechName) {

        GenericUtils.waitUntilLoaderDisappear();
        GenericUtils.waitUntilElementAppear(CommonLocators.chartContainer);
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        int flag = 1;
        assert hashMapList != null;
        for (HashMap<String, String> hashMap : hashMapList) {
            if (hashMap.get("DCTech").contains(dcTechName)
                    || (hashMap.containsKey("SecondaryDCs") &&
                    hashMap.get("SecondaryDCs") != null &&
                    hashMap.get("SecondaryDCs").contains(dcTechName))) {
                String empName = hashMap.get("EmployeeName");
                String empCode = hashMap.get("EmployeeCode");
                String mentorName = hashMap.get("ReportingManager");
                String mentorCode = hashMap.get("ManagerCode");

                if (!GenericUtils.isExist(CommonLocators.employeeDiv(empName, empCode))) {
                    GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                            empName + " is missing from hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                    flag++;
                    continue;
                }
                scrollToElement.scrollToElement(empName, empCode);
                String mentorDCTech = GenericUtils.getDcTech(mentorName, mentorCode);
                String mentorSecondaryDCTech = GenericUtils.getSecondaryDcTech(mentorName, mentorCode);
                assert mentorDCTech != null;
                DriverAction.waitSec(2);
                System.out.println("firstRowEmployees found");
                if (!mentorDCTech.contains(dcTechName) && !mentorSecondaryDCTech.contains(dcTechName) && !mentorName.equalsIgnoreCase(chair)) {
                    if (GenericUtils.isEmployeeInFirstRow(firstRowEmployees, empName, empCode)) {
                        GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                empName + " is at right hierarchy", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                empName + " is at wrong hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } else if (!mentorDCTech.contains(dcTechName) && !mentorSecondaryDCTech.contains(dcTechName) && mentorName.equalsIgnoreCase(chair)) {
                    if (GenericUtils.isExist(CommonLocators.hierarchyCheck(mentorName, mentorCode, empName, empCode))) {
                        GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                empName + " is at right hierarchy", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                empName + " is at wrong hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } else if (!mentorDCTech.contains(dcTechName) && !mentorSecondaryDCTech.contains(dcTechName)) {
                    if (GenericUtils.isEmployeeInFirstRow(firstRowEmployees, empName, empCode)) {
                        GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                empName + " is at right hierarchy", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                empName + " is at wrong hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } else {
                    if (GenericUtils.isExist(CommonLocators.hierarchyCheck(mentorName, mentorCode, empName, empCode))) {
                        GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                empName + " is at right hierarchy", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                empName + " is at wrong hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                }
                flag++;
//                scrollToElement.scrollToElement(empName, empCode);
//                DriverAction.getElement(CommonLocators.employeeDiv(empName, empCode)).click();
//                GenericUtils.waitUntilElementAppear(CommonLocators.infoCard);
//                DriverAction.waitSec(2);
//
//                List<String> resp = GenericUtils.verifyEmployeeDetails(hashMap);
//
//                if (resp.get(0).equalsIgnoreCase("True")) {
//                    GemTestReporter.addTestStep("Verify if " + empName + " has right values",
//                            empName + " has right values", STATUS.PASS, DriverAction.takeSnapShot());
//                } else {
//                    GemTestReporter.addTestStep("Verify if " + empName + " is at right hierarchy or not",
//                            empName + " has wrong value: " + resp.get(1), STATUS.FAIL, DriverAction.takeSnapShot());
//                }
//                DriverAction.getElement(CommonLocators.crossIcon).click();
            }

        }
    }
}



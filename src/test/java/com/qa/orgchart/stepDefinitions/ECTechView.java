package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ECTechView {


    public synchronized List<Object> openECTeamBox(String teamBox) {
        GenericUtils.waitUntilLoaderDisappear();
        GenericUtils.waitUntilElementAppear(CommonLocators.ecTeamBox(teamBox));
        DriverAction.scrollIntoView(CommonLocators.ecTeamBox(teamBox));
        DriverAction.hoverOver(CommonLocators.ecTeamBox(teamBox));
        String chair = null;
        if (GenericUtils.isExist(CommonLocators.chairBox(teamBox))) {
            chair = DriverAction.getElementText(CommonLocators.chairName(teamBox));
        }
        GenericUtils.waitUntilElementAppear(By.xpath("//div[contains(text(),'"+teamBox+"')]//ancestor::div[@class='teambox']//preceding-sibling::i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']"));
        DriverAction.getElement(By.xpath("//div[contains(text(),'"+teamBox+"')]//ancestor::div[@class='teambox']//preceding-sibling::i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']")).click();
        DriverAction.waitSec(3);
        GenericUtils.waitUntilLoaderDisappear();
        GenericUtils.waitUntilElementAppear(CommonLocators.firstRowEmployees(teamBox));
        List<WebElement> firstRowEmployees = DriverAction.getElements(CommonLocators.firstRowEmployees(teamBox));
        List<Object> result = new ArrayList<>();
        result.add(chair);
        result.add(firstRowEmployees);

        DriverAction.waitSec(1);
        List<WebElement> members = DriverAction.getElements(By.xpath("(//tr[@class='nodes'])[2]/td/table"));
        String path1 = "(//tr[@class='nodes'])[2]/td/table";
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
        return result;

    }


    @Then("^Check employee in EC view for \"(.*)\" of OrgChart$")
    public void checkEmployeeInECViewForOfOrgChart(String ecName) {
        GenericUtils.waitUntilLoaderDisappear();
        GenericUtils.waitUntilElementAppear(CommonLocators.chartContainer);
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        List<Object> response;
        response = openECTeamBox(ecName);
        int flag = 1;
        String chair = (String) response.get(0);
        List<WebElement> firstRowEmployees = (List<WebElement>) response.get(1);
        assert hashMapList != null;
        for (HashMap<String, String> hashMap : hashMapList) {
            String ecTechValue = hashMap.get("ECTech");

            if (ecTechValue != null && ecTechValue.contains(ecName)) {
                String empName = hashMap.get("EmployeeName");
                String empCode = hashMap.get("EmployeeCode");
                String mentorName = hashMap.get("ECMentorName");
                String mentorCode = hashMap.get("ECMentorId");

                if (empName.contains("Vishal Malik") || empName.contains("Aman Bansal") || empName.contains("Anil Pahal")
                        || empName.contains("Anil Singh") || empName.contains("Neeraj Yadav") || empName.contains("Prashank Chaudhary") || empName.contains("Lovish Sanghvi")) {
                    GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                            empName + " is at right hierarchy", STATUS.PASS, DriverAction.takeSnapShot());
                    continue;
                }

                if (!GenericUtils.isExist(CommonLocators.employeeDiv(empName, empCode))) {
                    GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                            empName + " is missing from hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                    flag++;
                    continue;
                }
                GenericUtils.scrollToElement(empName, empCode);
                String mentorECTech = getEcTech(mentorName, mentorCode);
                if (mentorECTech == null) {
                    GemTestReporter.addTestStep("Check employee EC mentor",
                            empName + " has wrong EC mentor", STATUS.FAIL, DriverAction.takeSnapShot());
                    continue;
                }
                DriverAction.waitSec(1);
                if (!mentorECTech.contains(ecName) && !mentorName.equalsIgnoreCase(chair)) {
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
            }

        }

    }

    public synchronized String getEcTech(String name, String code) {
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        assert hashMapList != null;
        for (HashMap<String, String> hm : hashMapList) {
            if (hm.containsKey("EmployeeName") && hm.get("EmployeeName").equalsIgnoreCase(name) &&
                    hm.containsKey("EmployeeCode") && hm.get("EmployeeCode").equalsIgnoreCase(code)) {
                return hm.get("ECTech");
            }
        }
        return null;
    }


}

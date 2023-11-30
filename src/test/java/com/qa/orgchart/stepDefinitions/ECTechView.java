package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.HashMap;
import java.util.List;


public class ECTechView {
    static String chair = null;
    static List<WebElement> firstRowEmployees = null;

    @When("^Open modals box in EC View \"(.*)\"$")
    public void openModalsBoxInECView(String teamBox) {
        GenericUtils.waitUntilLoaderDisappear();
        DriverAction.scrollIntoView(By.xpath("//div[@id='root-node']//img"));
        DriverAction.scrollIntoView(CommonLocators.ecTeamBox(teamBox));
        DriverAction.waitSec(1);
        DriverAction.hoverOver(CommonLocators.ecTeamBox(teamBox));
        chair = null;
        if(GenericUtils.isExist(CommonLocators.chairBox(teamBox))){
            chair = DriverAction.getElementText(CommonLocators.chairName(teamBox));
        }
        DriverAction.waitSec(1);
        DriverAction.getElement(By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']")).click();

        firstRowEmployees = DriverAction.getElements(By.xpath("(//tr[@class='nodes'])[2]/td/table//div[@class='node cursorPointer']"));

        List<WebElement> members = DriverAction.getElements(By.xpath("(//tr[@class='nodes'])[2]/td/table"));
        String str = "(//tr[@class='nodes'])[2]/td/table";
        String str2 = "/tr[@class='nodes']/td/table";
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
            str = str + str2;
            members.addAll(DriverAction.getElements(By.xpath(str)));

        }
    }

    @Then("^Check employee in EC view for \"(.*)\" of OrgChart$")
    public void checkEmployeeInECViewForOfOrgChart(String ecName) {
        GenericUtils.waitUntilLoaderDisappear();
        GenericUtils.waitUntilElementAppear(CommonLocators.chartContainer);
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        int flag = 1;

        assert hashMapList != null;
        for (HashMap<String, String> hashMap : hashMapList) {
            String ecTechValue = hashMap.get("ECTech");

            if (ecTechValue != null && ecTechValue.contains(ecName)) {
                String empName = hashMap.get("EmployeeName");
                String empCode = hashMap.get("EmployeeCode");
                String mentorName = hashMap.get("ECMentorName");
                String mentorCode = hashMap.get("ECMentorId");


                    if (!GenericUtils.isExist(CommonLocators.employeeDiv(empName, empCode))) {
                        GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                empName + " is missing from hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                        flag++;
                        continue;
                    }

                    String mentorECTech = GenericUtils.getEcTech(mentorName, mentorCode);
                    assert mentorECTech != null;
                    DriverAction.waitSec(1);
                    if (!mentorECTech.contains(ecName)  && !mentorName.equalsIgnoreCase(chair)) {
                        if (GenericUtils.isEmployeeInFirstRow(firstRowEmployees, empName, empCode)) {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at right hierarchy", STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at wrong hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                    }
                    else {
                        if (GenericUtils.isExist(CommonLocators.hierarchyCheck(mentorName, mentorCode, empName, empCode))) {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at right hierarchy", STATUS.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at wrong hierarchy", STATUS.FAIL, DriverAction.takeSnapShot());
                        }
                    }
                    flag++;
                    GenericUtils.scrollToElement(empName, empCode);
                    DriverAction.getElement(CommonLocators.employeeDiv(empName, empCode)).click();
                    GenericUtils.waitUntilElementAppear(CommonLocators.infoCard);
                    DriverAction.waitSec(2);

                    List<String> resp = GenericUtils.verifyEmployeeDetails(hashMap);

                    if (resp.get(0).equalsIgnoreCase("True")) {
                        GemTestReporter.addTestStep("Verify if " + empName + " has right values",
                                empName + " has right values", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify if " + empName + " is at right hierarchy or not",
                                empName + " has wrong value: " + resp.get(1), STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                    DriverAction.getElement(CommonLocators.crossIcon).click();
                }

            }

    }
}

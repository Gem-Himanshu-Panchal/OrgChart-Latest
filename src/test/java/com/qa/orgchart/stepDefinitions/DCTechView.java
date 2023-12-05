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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DCTechView {

    @Then("^Check employee in DC view for \"(.*)\" in \"(.*)\" of OrgChart$")
    public void checkForEmployeeInDcViewOfOrgChart(String dcTechName,String dcType) {
        try {
            List<Object> response = openDCTeamBox(dcTechName);
            openDCNodes(dcType);

            String chair = (String) response.get(0);
            List<WebElement>firstRowEmployees = (List<WebElement>) response.get(1);
            System.out.println(chair+"   "+firstRowEmployees.size());
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
                    GenericUtils.scrollToElement(empName, empCode);
                    String mentorDCTech = GenericUtils.getDcTech(mentorName, mentorCode);
                    String mentorSecondaryDCTech = GenericUtils.getSecondaryDcTech(mentorName, mentorCode);
                    assert mentorDCTech != null;

                    DriverAction.waitSec(1);
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
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }



    @When("Open path for {string} Dc tech and {string} DC")
    public void openPathForDcTechAndDC(String DcTechName, String actualDC) {
        try {
            GenericUtils.waitUntilLoaderDisappear();
//            Hover over prashank
            GenericUtils.waitUntilElementAppear(CommonLocators.dataSource("name", "Prashank Chaudhary", "EmployeeCode", "GSI N 015"));
            DriverAction.hoverOver(CommonLocators.dataSource("name", "Prashank Chaudhary", "EmployeeCode", "GSI N 015"));

            DriverAction.scrollIntoView(CommonLocators.downArrowDataSource("name", "Prashank Chaudhary", "EmployeeCode", "GSI N 015"));
            DriverAction.scrollToBottom();

            GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDataSource("name", "Prashank Chaudhary", "EmployeeCode", "GSI N 015"));
            if (!GenericUtils.isExist(CommonLocators.downArrowDataSource("name", "Prashank Chaudhary", "EmployeeCode", "GSI N 015"))) {
                DriverAction.hoverOver(CommonLocators.dataSource("name", "Prashank Chaudhary", "EmployeeCode", "GSI N 015"));
                DriverAction.waitSec(1);
            }
            DriverAction.getElement(CommonLocators.downArrowDataSource("name", "Prashank Chaudhary", "EmployeeCode", "GSI N 015")).click();
// Hover over type of DC
            GenericUtils.waitUntilElementAppear(CommonLocators.dcTechNameBox(DcTechName));
            DriverAction.hoverOver(CommonLocators.dcTechNameBox(DcTechName));

            GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDCTechDataSource(DcTechName));
            if (!GenericUtils.isExist(CommonLocators.downArrowDCTechDataSource(DcTechName))) {
                DriverAction.hoverOver(CommonLocators.dcTechNameBox(DcTechName));
                DriverAction.waitSec(1);
            }
            DriverAction.getElement(CommonLocators.downArrowDCTechDataSource(DcTechName)).click();

            DriverAction.scrollToBottom();
            if (DcTechName.contains("Clients")) {
                String secondLevelDC;
                if (actualDC.contains("Pimco"))
                    secondLevelDC = "Pimco";
                else if (actualDC.contains("Edward Jones"))
                    secondLevelDC = "Edward Jones";
                else secondLevelDC = "Other Clients";

                GenericUtils.waitUntilElementAppear(CommonLocators.dcTechNameBoxLevel2(secondLevelDC));
                DriverAction.hoverOver(CommonLocators.dcTechNameBoxLevel2(secondLevelDC));

                GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDCTechDataSource(secondLevelDC));
                if (!GenericUtils.isExist(CommonLocators.downArrowDCTechDataSource(secondLevelDC))) {
                    DriverAction.hoverOver(CommonLocators.dcTechNameBoxLevel2(secondLevelDC));
                    DriverAction.waitSec(1);
                }
                DriverAction.getElement(CommonLocators.downArrowDCTechDataSource(secondLevelDC)).click();

                DriverAction.scrollToBottom();

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }
    public synchronized List<Object> openDCTeamBox(String teamBox){
        GenericUtils.waitUntilLoaderDisappear();
        GenericUtils.waitUntilElementAppear(CommonLocators.ecTeamBox(teamBox));
        DriverAction.scrollIntoView(CommonLocators.ecTeamBox(teamBox));
        DriverAction.hoverOver(CommonLocators.ecTeamBox(teamBox));
        synchronized (this){
            String chair = null;
            if (GenericUtils.isExist(CommonLocators.chairBox(teamBox))) {
                chair = DriverAction.getElementText(CommonLocators.chairName(teamBox));
            }
            GenericUtils.waitUntilElementAppear(By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']"));
            DriverAction.getElement(By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']")).click();
            DriverAction.waitSec(3);
            GenericUtils.waitUntilLoaderDisappear();
            GenericUtils.waitUntilElementAppear(CommonLocators.firstRowEmployees(teamBox));
            List<WebElement>firstRowEmployees = DriverAction.getElements(CommonLocators.firstRowEmployees(teamBox));
            List<Object> result = new ArrayList<>();
            result.add(chair);
            result.add(firstRowEmployees);
            return result;
        }
    }
    public synchronized void openDCNodes(String DCtype){
        synchronized (this) {
            DriverAction.waitSec(1);
            List<WebElement> members;
            String path1;
            String endPath;
            if (!DCtype.contains("Clients")) {
                members = DriverAction.getElements(By.xpath("(//tr[@class='nodes'])[4]/td/table"));
                path1 = "(//tr[@class='nodes'])[4]/td/table";
            } else {
                members = DriverAction.getElements(By.xpath("(//tr[@class='nodes'])[5]/td/table"));
                path1 = "(//tr[@class='nodes'])[5]/td/table";
            }
            endPath = "/tr[@class='nodes']/td/table";
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
    }
}



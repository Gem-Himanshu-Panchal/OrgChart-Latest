package com.qa.orgchart.stepDefinitions;


import com.gemini.gemjar.enums.Status;
import com.gemini.gemjar.reporting.GemTestReporter;
import com.gemini.gemjar.utils.ui.DriverAction;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.HashMap;
import java.util.List;

public class PimcoDCView {
    static  String chair =null;
    static List<WebElement> firstRowEmployees = null;

    @When("^Check employee in PIMCODC view for \"(.*)\" of OrgChart$")
    public synchronized void checkForEmployeeInPimcoDcViewOfOrgChart(String dcTechName) {
        try {
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
                                empName + " is missing from hierarchy", Status.FAIL, DriverAction.takeSnapShot());
                        flag++;
                        continue;
                    }
                    String mentorDCTech = GenericUtils.getDcTech(mentorName, mentorCode);
                    String mentorSecondaryDCTech = GenericUtils.getSecondaryDcTech(mentorName, mentorCode);
                    assert mentorDCTech != null;
                    DriverAction.waitSec(1);
                    if (!mentorDCTech.contains(dcTechName) && !mentorSecondaryDCTech.contains(dcTechName) && !mentorName.equalsIgnoreCase(chair)) {
                        if (GenericUtils.isEmployeeInFirstRow(firstRowEmployees, empName, empCode)) {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at right hierarchy", Status.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at wrong hierarchy", Status.FAIL, DriverAction.takeSnapShot());
                        }
                    } else if (!mentorDCTech.contains(dcTechName) && !mentorSecondaryDCTech.contains(dcTechName) && mentorName.equalsIgnoreCase(chair)) {
                        if (GenericUtils.isExist(CommonLocators.hierarchyCheck(mentorName, mentorCode, empName, empCode))) {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at right hierarchy", Status.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at wrong hierarchy", Status.FAIL, DriverAction.takeSnapShot());
                        }
                    } else if (!mentorDCTech.contains(dcTechName) && !mentorSecondaryDCTech.contains(dcTechName)) {
                        if (GenericUtils.isEmployeeInFirstRow(firstRowEmployees, empName, empCode)) {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at right hierarchy", Status.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at wrong hierarchy", Status.FAIL, DriverAction.takeSnapShot());
                        }
                    } else {
                        if (GenericUtils.isExist(CommonLocators.hierarchyCheck(mentorName, mentorCode, empName, empCode))) {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at right hierarchy", Status.PASS, DriverAction.takeSnapShot());
                        } else {
                            GemTestReporter.addTestStep(flag + ". Verify if " + empName + " is at right hierarchy or not",
                                    empName + " is at wrong hierarchy", Status.FAIL, DriverAction.takeSnapShot());
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
                                empName + " has right values", Status.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Verify if " + empName + " is at right hierarchy or not",
                                empName + " has wrong value: " + resp, Status.FAIL, DriverAction.takeSnapShot());
                    }
                    DriverAction.getElement(CommonLocators.crossIcon).click();
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
            throw new RuntimeException(e);
        }
    }

    @When("^Open modals box in \"(.*)\"$")
    public synchronized void openModalsBoxIn(String teamBox) {
        try {
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.scrollIntoView(By.xpath("//div[@id='root-node']//img"));
            DriverAction.scrollIntoView(CommonLocators.ecTeamBox(teamBox));
            DriverAction.waitSec(1);
            DriverAction.hoverOver(CommonLocators.ecTeamBox(teamBox));
            chair = null;
            if (GenericUtils.isExist(CommonLocators.chairBox(teamBox))) {
                chair = DriverAction.getElementText(CommonLocators.chairName(teamBox));
            }
            DriverAction.waitSec(2);
            DriverAction.waitUntilElementClickable(By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']"),3);
            DriverAction.getElement(By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']")).click();

//            firstRowEmployees = DriverAction.getElements(By.xpath("(//tr[@class='nodes'])[2]/td/table//div[@class='node cursorPointer']"));
            firstRowEmployees = DriverAction.getElements(CommonLocators.firstRowEmployeesXpath);

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
                    }else {
                        DriverAction.hoverOver(member);
                        DriverAction.waitSec(1);
                        DriverAction.getElement(CommonLocators.downArrow).click();
                        DriverAction.waitSec(1);
                    }
                }
                members.clear();
                str = str + str2;
                members.addAll(DriverAction.getElements(By.xpath(str)));

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
            throw new RuntimeException(e);
        }
    }
}

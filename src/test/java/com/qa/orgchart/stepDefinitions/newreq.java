package com.qa.orgchart.stepDefinitions;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class newreq {


    @When("Open all nodes")
    public void openAllNodes() {
        try {
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.refresh();
            GenericUtils.waitUntilLoaderDisappear();
            GenericUtils.waitUntilElementAppear(CommonLocators.chartContainer);
//            Hover over Anil
            GenericUtils.waitUntilElementAppear(CommonLocators.dataSource("name", "Anil Singh", "EmployeeCode", "GSI G 818"));
            DriverAction.hoverOver(CommonLocators.dataSource("name", "Anil Singh", "EmployeeCode", "GSI G 818"));

            DriverAction.scrollIntoView(CommonLocators.downArrowDataSource("name", "Anil Singh", "EmployeeCode", "GSI G 818"));
            DriverAction.scrollToBottom();

            GenericUtils.waitUntilElementAppear(CommonLocators.downArrowDataSource("name", "Anil Singh", "EmployeeCode", "GSI G 818"));
            if (!GenericUtils.isExist(CommonLocators.downArrowDataSource("name", "Anil Singh", "EmployeeCode", "GSI G 818"))) {
                DriverAction.hoverOver(CommonLocators.dataSource("name", "Anil Singh", "EmployeeCode", "GSI G 818"));
                DriverAction.waitSec(1);
            }
            DriverAction.getElement(CommonLocators.downArrowDataSource("name", "Anil Singh", "EmployeeCode", "GSI G 818")).click();


//            Hover over Prashank
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


            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitSec(1);
            List<WebElement> members;
            String path1;
            String endPath;
            members = DriverAction.getElements(By.xpath("(//tr[@class='nodes'])[3]/td/table"));
            path1 = "(//tr[@class='nodes'])[3]/td/table";
            WebElement dataContainer;
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

            while(DriverAction.isExist(By.xpath()))
            dataContainer = DriverAction.getElement(By.xpath(path1 + "/tr/td/div[contains(@data-source, 'name')]"));
            List<String>resp = checkIfDataIsRight(dataContainer);
            if (resp.get(0).equalsIgnoreCase("True")) {
                GemTestReporter.addTestStep("Verify if "+resp.get(1)+" is having correct location",
                        "Correct location is mentioned", STATUS.PASS, DriverAction.takeSnapShot());
            } else GemTestReporter.addTestStep("Verify if "+resp.get(1)+" is having correct location",
                    "Incorrect location is mentioned", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            throw new RuntimeException(e);
        }
    }


//    public synchronized void openDCTeamBox(String teamBox) {
//
//
//    }


    public static List<String> checkIfDataIsRight(WebElement container) {

        String dataSource = container.getAttribute("data-source");
//Location
        int startIndex = dataSource.indexOf("\"Location\":\"") + "\"Location\":\"".length();
        int endIndex = dataSource.indexOf("\"", startIndex);
        System.out.println("Location: " + dataSource.substring(startIndex, endIndex));
        String location = dataSource.substring(startIndex, endIndex);

// EmployeeName
        startIndex = dataSource.indexOf("\"name\":\"") + "\"name\":\"".length();
        endIndex = dataSource.indexOf("\"", startIndex);
        System.out.println("Name: " + dataSource.substring(startIndex, endIndex));
        String name = dataSource.substring(startIndex, endIndex);

// EmployeeCode
        startIndex = dataSource.indexOf("\"EmployeeCode\":\"") + "\"EmployeeCode\":\"".length();
        endIndex = dataSource.indexOf("\"", startIndex);
        System.out.println("Code: " + dataSource.substring(startIndex, endIndex));
        String code = dataSource.substring(startIndex, endIndex);


        String extractedLocation = null;
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        List<String> mentees = new ArrayList<>();
        assert hashMapList != null;
        for (HashMap<String, String> hashMap : hashMapList) {
            if (hashMap.containsKey("EmployeeName") && hashMap.get("EmployeeName").equalsIgnoreCase(name)
                    && hashMap.containsKey("EmployeeCode") && hashMap.get("EmployeeCode").equalsIgnoreCase(code)) {
                extractedLocation = hashMap.get("Location");
                break;
            }
        }
        List<String> response = new ArrayList<>();
        if (location.equalsIgnoreCase(extractedLocation))
            response.add("True");
        else
            response.add("False");

        response.add(name);
        response.add(code);
        return response;
    }
}

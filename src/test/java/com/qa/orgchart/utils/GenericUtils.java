package com.qa.orgchart.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.orgchart.locators.CommonLocators;

import com.qa.orgchart.locators.sanityLocators;
import org.apache.commons.collections.CollectionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.orgchart.stepDefinitions.*;

import javax.xml.transform.Result;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.gemini.generic.ui.utils.DriverAction.getElements;


public class GenericUtils{
    public static void waitUntilElementDisappear(By locator) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitUntilLoaderDisappear() {
        if (GenericUtils.isExist(CommonLocators.loader)) {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 60);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(CommonLocators.loader));
        }
    }

    public static void waitUntilElementAppear(By locator) {
        if (GenericUtils.isExist(locator)) {
            WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(60));
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
    }

    public static List<String> getMenteesList(String managerName) {
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        List<String> mentees = new ArrayList<>();
        assert hashMapList != null;
        for (HashMap<String, String> hashMap : hashMapList) {
            if (hashMap.containsKey("ReportingManager") && hashMap.get("ReportingManager").equalsIgnoreCase(managerName)) {
                mentees.add(hashMap.get("EmployeeName"));
                mentees.add((hashMap.get("EmployeeCode")));
            }
        }
        return mentees;
    }

    public static List<String> getHierarchy(int index) {
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();

        assert hashMapList != null;
        HashMap<String, String> employee = hashMapList.get(index);
        String name;
        String code;
        List<String> hierarchy = new ArrayList<>();
        hierarchy.add(employee.get("EmployeeName"));
        hierarchy.add(employee.get("EmployeeCode"));
        name = employee.get("ReportingManager");
        code = employee.get("ManagerCode");
        while (!name.equalsIgnoreCase("Vishal Malik")) {
            for (HashMap<String, String> hashMap : hashMapList) {
                if (hashMap.containsKey("EmployeeName") && hashMap.containsKey("EmployeeCode")
                        && hashMap.get("EmployeeName").equals(name) && hashMap.get("EmployeeCode").equals(code)) {
                    hierarchy.add(hashMap.get("EmployeeName"));
                    hierarchy.add(hashMap.get("EmployeeCode"));
                    name = hashMap.get("ReportingManager");
                    code = hashMap.get("ManagerCode");
                    break;
                }
            }
        }
        return hierarchy;
    }


    public static List<String> getManagerHierarchy(String managerName, String managerCode) {
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        int index = GenericUtils.getEmployeeIndex(managerName, managerCode);
        assert hashMapList != null;
        HashMap<String, String> employee = hashMapList.get(index);
        String name;
        String code;
        List<String> hierarchy = new ArrayList<>();
        hierarchy.add(employee.get("EmployeeName"));
        hierarchy.add(employee.get("EmployeeCode"));
        name = employee.get("ReportingManager");
        code = employee.get("ManagerCode");
        while (!name.equalsIgnoreCase("Vishal Malik")) {
            for (HashMap<String, String> hashMap : hashMapList) {
                if (hashMap.containsKey("EmployeeName") && hashMap.containsKey("EmployeeCode")
                        && hashMap.get("EmployeeName").equals(name) && hashMap.get("EmployeeCode").equals(code)) {
                    hierarchy.add(hashMap.get("EmployeeName"));
                    hierarchy.add(hashMap.get("EmployeeCode"));
                    name = hashMap.get("ReportingManager");
                    code = hashMap.get("ManagerCode");
                    break;
                }
            }
        }
        return hierarchy;
    }

    public static HashMap<String, String> getEmployeeData(String name, String managerName) {
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        assert hashMapList != null;
        for (HashMap<String, String> hashMap : hashMapList) {
            if (hashMap.containsKey("EmployeeName") && hashMap.containsKey("ReportingManager")
                    && hashMap.get("EmployeeName").equals(name) && hashMap.get("ReportingManager").equals(managerName)) {
                return hashMap;
            }
        }
        return null;
    }

    public static int getEmployeeIndex(String name, String code) {
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        int index = 0;

        for (int i = 0; i < Objects.requireNonNull(hashMapList).size(); i++) {
            if (hashMapList.get(i).get("EmployeeName").equalsIgnoreCase(name) && hashMapList.get(i).get("EmployeeCode").equalsIgnoreCase(code)) {
                index = i;
                break;
            }
        }
        return index;
    }


    public static String getDcTech(String name, String code) {
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        assert hashMapList != null;
        for (HashMap<String, String> hm : hashMapList) {
            if (hm.containsKey("EmployeeName") && hm.get("EmployeeName").equalsIgnoreCase(name) &&
                    hm.containsKey("EmployeeCode") && hm.get("EmployeeCode").equalsIgnoreCase(code)) {
                return hm.get("DCTech");
            }
        }
        return null;
    }

    public static String getEcTech(String name, String code) {
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

    public static String getSecondaryDcTech(String name, String code) {
        List<HashMap<String, String>> hashMapList = jsonToHash.getHashList2();
        assert hashMapList != null;
        for (HashMap<String, String> hm : hashMapList) {
            if (hm.containsKey("EmployeeName") && hm.get("EmployeeName").equalsIgnoreCase(name) &&
                    hm.containsKey("EmployeeCode") && hm.get("EmployeeCode").equalsIgnoreCase(code) && hm.containsKey("SecondaryDCs")) {
                return hm.get("SecondaryDCs");
            }
        }
        return "Nil";
    }

    public static List<String> verifyEmployeeDetails(HashMap<String, String> hashMap) {
        boolean passed = false;
        String str = hashMap.get("DateOfJoining");
        str = str.substring(0, 10);
        LocalDate date = LocalDate.parse(str);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(formatter);
        hashMap.put("DateOfJoining", formattedDate);

        HashMap<String, String> extractData = new HashMap<>();
        extractData.put("ImagePath", DriverAction.getAttributeName(CommonLocators.employeeProfile, "src"));
        extractData.put("EmployeeName", DriverAction.getElementText(CommonLocators.employeeDataSet1(hashMap.get("EmployeeName"))));
        extractData.put("EmployeeCode", DriverAction.getElementText(CommonLocators.employeeDataSet1(hashMap.get("EmployeeCode"))).substring(1, DriverAction.getElementText(CommonLocators.employeeDataSet1(hashMap.get("EmployeeCode"))).length() - 1));
        extractData.put("Designation", DriverAction.getElementText(CommonLocators.employeeDataSet1(hashMap.get("Designation"))));
        extractData.put("EmailId", DriverAction.getElementText(CommonLocators.employeeDataSet3("Email")));
        extractData.put("MobileNumber", DriverAction.getElementText(CommonLocators.employeeDataSet3("Phone Number")));
        extractData.put("Location", DriverAction.getElementText(CommonLocators.employeeDataSet3("Location")));
        extractData.put("DateOfJoining", DriverAction.getElementText(CommonLocators.employeeDataSet3("Date of Joining")));
        String[] temp = DriverAction.getElementText(CommonLocators.employeeDataSet4("Experience")).split(" ");
        extractData.put("OverallExp", temp[0]);
        extractData.put("ECTech", DriverAction.getElementText(CommonLocators.employeeDataSet3("Engineering Council")));
        extractData.put("DCTech", DriverAction.getElementText(CommonLocators.employeeDataSet3("Delivery Council")));
        if (hashMap.containsKey("PrimarySkills") && hashMap.containsKey("SecondarySkills"))
            extractData.put("BothSkills", DriverAction.getElementText(CommonLocators.employeeDataSet3("Skills")));
        else if (hashMap.containsKey("PrimarySkills"))
            extractData.put("PrimarySkills", DriverAction.getElementText(CommonLocators.employeeDataSet3("Skills")));
        else if (hashMap.containsKey("SecondarySkills"))
            extractData.put("SecondarySkills", DriverAction.getElementText(CommonLocators.employeeDataSet3("Skills")));

        extractData.put("ECMentorName", DriverAction.getElementText(CommonLocators.employeeDataSet3("EC Mentor")));


        String wrongValue = "";
        for (Map.Entry<String, String> entry : extractData.entrySet()) {
            String key = entry.getKey();
            String value1 = entry.getValue();
            String value2;
            if (key.equalsIgnoreCase("PrimarySkills")) {
                value2 = hashMap.get(key);
            } else if (key.equalsIgnoreCase("SecondarySkills")) {
                value2 = hashMap.get(key);
            } else if (key.equalsIgnoreCase("BothSkills")) {
                value2 = hashMap.get("PrimarySkills") + ", " + hashMap.get("SecondarySkills");
                value2 = value2.trim();
                value2 = value2.startsWith(",") ? value2.substring(1) : value2;
                value2 = value2.trim();
            } else {
                value2 = hashMap.get(key);
            }
            if (value1.equals(value2) || value1.equalsIgnoreCase("NA")) {
                passed = true;
            } else {
                passed = false;
                wrongValue = key;
                break;
            }

        }
        List<String> li = new ArrayList<>();
        if (passed) {
            li.add("True");
        } else li.add("False");
        li.add(wrongValue);
        return li;
    }

    public static boolean isEmployeeInFirstRow(List<WebElement> empList, String empName, String empCode) {
        for (WebElement webElement : empList) {
            String dataSource = webElement.getAttribute("data-source");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonNode = objectMapper.readTree(dataSource);
                String name = jsonNode.get("name").asText();
                String employeeCode = jsonNode.get("EmployeeCode").asText();
                if (employeeCode.length() > 10)
                    employeeCode = employeeCode.substring(0, employeeCode.length() - 4);
                if (name.equalsIgnoreCase(empName) && empCode.equalsIgnoreCase(employeeCode))
                    return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static void clickOnButton(String btnName) {
        if (btnName.equalsIgnoreCase("Feedback form")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.btnLocator("div", btnName, "title"));
            DriverAction.click(sanityLocators.btnLocator("div", btnName, "title"));
        } else if (btnName.equalsIgnoreCase("Submit")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.btnLocator("button", btnName, "type"));
            DriverAction.click(sanityLocators.btnLocator("button", btnName, "type"));
        } else if (btnName.equalsIgnoreCase("cancel")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.btnLocator("button", "cancel-btn m-btn", "class"));
            DriverAction.click(sanityLocators.btnLocator("button", "cancel-btn m-btn", "class"));
        } else if (btnName.equalsIgnoreCase("Reset") || btnName.equalsIgnoreCase("Logout") || btnName.equalsIgnoreCase("Admin")) {
//            GenericUtils.waitUntilElementAppear(sanityLocators.btnLocator("div", btnName, "title"));
//            DriverAction.waitUntilElementClickable(sanityLocators.btnLocator("div", btnName, "title"),10);
            DriverAction.waitSec(6);
            DriverAction.click(sanityLocators.btnLocator("div", btnName, "title"));
        } else if (btnName.equalsIgnoreCase("view")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.btnLocator("div", "ng-select-container ng-has-value", "class"));
            DriverAction.click(sanityLocators.btnLocator("div", "ng-select-container ng-has-value", "class"));
        } else if (btnName.equalsIgnoreCase("Update Hierarchy")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.btnLocator("button", "excel-modal-btn", "class"));
            DriverAction.click(sanityLocators.btnLocator("button", "excel-modal-btn", "class"));
        } else if (btnName.equalsIgnoreCase("Export Hierarchy")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.exportHierarchyButton);
            DriverAction.click(sanityLocators.exportHierarchyButton);
        } else if (btnName.equalsIgnoreCase("View dropdown")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.dropdownViews);
            DriverAction.click(sanityLocators.dropdownViews);
        } else if (btnName.equalsIgnoreCase("Manage View") || btnName.equalsIgnoreCase("Manage Team") || btnName.equalsIgnoreCase("Manage Project") ||
                btnName.equalsIgnoreCase("User Management") || btnName.equalsIgnoreCase("Role Management") || btnName.equalsIgnoreCase("Manage Requests")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.adminTab(btnName));
            DriverAction.click(sanityLocators.adminTab(btnName));
        } else if (btnName.equalsIgnoreCase("Add View")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.addViewBtn);
            DriverAction.click(sanityLocators.addViewBtn);
        } else if (btnName.equalsIgnoreCase("Submit view")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.submitBtn);
            DriverAction.click(sanityLocators.submitBtn);
        } else if (btnName.equalsIgnoreCase(" Export Employees ")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.elementWithText("button", btnName));
            DriverAction.click(sanityLocators.elementWithText("button", btnName));
        } else if (btnName.equalsIgnoreCase(" Update ")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.elementWithText("button", btnName));
            DriverAction.click(sanityLocators.elementWithText("button", btnName));
        } else if (btnName.equalsIgnoreCase("close")) {
            GenericUtils.waitUntilElementAppear(sanityLocators.crossIcon);
            DriverAction.click(sanityLocators.crossIcon);
        } else if (btnName.equalsIgnoreCase("Clone View")) {
            GenericUtils.waitUntilLoaderDisappear();
            GenericUtils.waitUntilElementAppear(sanityLocators.cloneViewButton);
            List<WebElement> cloneButtons = DriverAction.getElements(sanityLocators.cloneViewButton);
            cloneButtons.get(cloneButtons.size() - 1).click();
        } else if (btnName.equalsIgnoreCase("Delete View")) {
            GenericUtils.waitUntilLoaderDisappear();
            GenericUtils.waitUntilElementAppear(sanityLocators.btnLocator("img",  btnName,"title"));
            List<WebElement> deleteButtons = DriverAction.getElements(sanityLocators.btnLocator("img",  btnName,"title"));
            deleteButtons.get(deleteButtons.size() - 1).click();
        }else if(btnName.equalsIgnoreCase("Yes, delete it!")){
            GenericUtils.waitUntilElementAppear(sanityLocators.deleteButton);
            DriverAction.click(sanityLocators.deleteButton);
        }
    }

    public static boolean isExist(By locator) {
//        if(locator!=null) {
//            List<WebElement> elementList = getElements(locator);
//            int elementListSize = elementList.size();
//            return elementListSize > 0;
//        }
//        return false;
        List<WebElement> elementList = getElements(locator);
        if (CollectionUtils.isEmpty(elementList)) {
            return false;
        } else {
            return true;
        }
    }

    public static void scrollToElement(String name, String code){
        WebDriver driver= DriverManager.getWebDriver();
        WebElement element = DriverAction.getElement(CommonLocators.employeeDiv(name, code));
        long windowWidth = (long) ((JavascriptExecutor) driver).executeScript("return window.innerWidth;");
        long windowHeight = (long) ((JavascriptExecutor) driver).executeScript("return window.innerHeight;");

        long elementX = element.getLocation().getX();
        long elementY = element.getLocation().getY();

        // Get the dimensions of the element.
        long elementWidth = element.getSize().getWidth();
        long elementHeight = element.getSize().getHeight();

        // Calculate the center coordinates of the element relative to the top-left corner of the page.
        long centerX = elementX + elementWidth / 2;
        long centerY = elementY + elementHeight / 2;

        // Calculate the scroll positions needed to center the element in the viewport.
        long scrollX = centerX - windowWidth / 2;
        long scrollY = centerY - windowHeight / 2;


        ((JavascriptExecutor) driver).executeScript("window.scrollTo(" + scrollX + ", " + scrollY + ");");
    }




}

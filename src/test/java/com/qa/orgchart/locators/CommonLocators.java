package com.qa.orgchart.locators;

import org.openqa.selenium.By;

public class CommonLocators {
    public static By loader = By.xpath("//div[@class='loader']");
    public static By loginButton = By.xpath("//button[contains(text(),' Login with Azure AD ')]");
    public static By companyLogo = By.xpath("//img[@class='company-logo']");
    public static By chartContainer = By.xpath("//div[@id='chart-container']");
    public static By searchField = By.xpath("//div[contains(text(),'Search Employee')]");

    public static By dropdownBox = By.xpath("//div[@class='ng-select-container ng-has-value']");
    public static By infoCard = By.xpath("//div[@class='nsm-body']");
    public static By employeeProfile = By.xpath("//div[@class='nsm-body']//img");
    public static By crossIcon = By.xpath("//span[@class='myclose']");
    public static By downArrow = By.xpath("//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']");
    public static By userName = By.xpath("//div[contains(text(),'Himanshu Panchal')]");
    public static By checkInfoCard = By.xpath("//div[@class='col-md id-row']");
    public static By invalidHTTPRequestToastMessage = By.xpath("//div[contains(text(),'Http failure')]");
    public static By allEmployeesName = By.xpath("//div[@class='ptitle']");
    public static By coChairsNames(String dcName){
        return By.xpath("//div[contains(text(),'"+dcName+"')]//..//..//div[@class='hierarchy-box-tooltip']//ul[2]//li");
    }

    public static By teamDataSource(String team){
        return By.xpath("//div[contains(@data-source, 'name\":\""+team+"')]");
    }

    public static By selectedView(String viewName){
       return By.xpath("//div[contains(@class, 'ng-value')]//span[contains(text(),'"+viewName+"')]");
    }

    public static By firstRowEmployees(String techName){
        return By.xpath("//div[@class='teambox']//div[contains(text(),'"+techName+"')]/ancestor::table[1]/tr[@class='nodes']/td/table/tr[1]/td/div[@data-source]");
    }


    public static By chairName(String team) {
        return By.xpath("//div[contains(@data-source,'name\":\"" + team + "')]//div[@class='hierarchy-box-tooltip']//ul[1]");
    }

    public static By chairBox(String team) {
        return By.xpath("//div[contains(@data-source,'name\":\"" + team + "')]//div[@class='hierarchy-box-tooltip']");
    }

    public static By viewValue(String viewValue) {
        return By.xpath("//span[contains(text(), '" + viewValue + "') and contains(@class, 'ng-option-label')]");
    }

    public static By dataSource(String key1, String empName, String key2, String code) {
//        return By.xpath("//tr[@class='nodes']//div[contains(@data-source, '" + key + "\":\"" + value + "')]");
        return By.xpath("//tr[@class='nodes']//div[contains(@data-source, '" + key1 + "\":\"" + empName + "') and contains(@data-source, '" + key2 + "\":\"" + code + "')]");
    }

    public static By downArrowDataSource(String key1, String empName, String key2, String code) {
        return By.xpath("//div[contains(@data-source, '" + key1 + "\":\"" + empName + "') and contains(@data-source, '" + key2 + "\":\"" + code + "')]//i[contains(@class,'edge verticalEdge bottomEdge fa fa-chevron-circle-down')]");
        //i[contains(@class,'bottomEdge fa fa-chevron-circle-down')]");
    }

    public static By employeeDataSet1(String name) {
        return By.xpath("//div[@class='nsm-body']//div[contains(text(),'" + name + "')]");
    }

    public static By employeeDataSet3(String value) {
        return By.xpath("//span[contains(text(),'" + value + " : ')]//..//span[2]");
    }

    public static By employeeDataSet4(String value) {
        return By.xpath("//span[contains(text(),'" + value + ": ')]//..//span[2]");
    }

    public static By employeeDiv(String empName, String code) {
//        return By.xpath("//tr[@class='nodes']//div[contains(@data-source, '"+key1+"\":\""+empName+"') and contains(@data-source,'"+key2+"\":\""+code+"')]//div");
        return By.xpath("//tr[contains(@class,'nodes')]//div[contains(@class, 'node') and contains(@class, 'cursorPointer') and not(contains(@class,'slide-up'))  and contains(@data-source, 'name\":\"" + empName + "') and contains(@data-source,'EmployeeCode\":\"" + code + "')]//div//img");
    }


    public static By ecTeamBox(String teamName) {
        return By.xpath("//div[contains(text(),'"+teamName+"')]//ancestor::div[@class='teambox']");

    }

    public static By downArrowDcView(String team) {
        return By.xpath("//div[contains(text(),'"+team+"')]//ancestor::div[@class='teambox']//preceding-sibling::i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']");
    }

    public static By hierarchyCheck(String mentorName, String mentorCode, String name, String code) {
//        return By.xpath("//div[contains(@data-source, 'name\":\"" + mentorName + "') and contains(@data-source, 'EmployeeCode\":\"" + mentorCode + "')]//ancestor::table[1]//tr[@class='nodes']//div[contains(@data-source, 'name\":\"" + name + "') and contains(@data-source, 'EmployeeCode\":\"" + code + "')]");
    return By.xpath("//div[contains(@data-source, 'name\":\""+mentorName+"') and contains(@data-source, 'EmployeeCode\":\""+mentorCode+"')]/ancestor::table[1]/tr[@class='nodes']/td/table/tr/td/div[contains(@data-source, 'name\":\""+name+"') and contains(@data-source, 'EmployeeCode\":\""+code+"')]");
    }

    public static By menteeCount(String name, String code) {
        return By.xpath("//tr[contains(@class,'nodes')]//div[contains(@class, 'node') and contains(@class, 'cursorPointer') and not(contains(@class,'slide-up'))  and contains(@data-source, 'name\":\"" + name + "') and contains(@data-source,'EmployeeCode\":\"" + code + "')]//div//img/ancestor::table[1]//tr[@class='nodes'][1]/td");
    }


    public static By loginEmail = By.xpath("//input[@type='email']");
    public static By submitButton = By.xpath("//input[@type='submit']");
    public static By loginPswd = By.xpath("//input[@type='password']");

    public static By dcTechNameBox(String dcName){
        return  By.xpath("//div[@class='teambox dc-l1']//div[@class='teamname' and contains(text(),'"+dcName+"')]");
    }

    public static By dcTechNameBoxLevel2(String dcName){
        return  By.xpath("//div[@class='teambox dc-l2']//div[@class='teamname' and contains(text(),'"+dcName+"')]");
    }

    public static By downArrowDCTechDataSource(String dcName) {
        return By.xpath("//div[contains(@data-source,'name\":\""+dcName+"')]//i[@class='edge verticalEdge bottomEdge fa fa-chevron-circle-down']");
    }
    public static By scrollElement(String value){
        return By.xpath("//*[contains(text(),'"+value+"')]");
    }
}

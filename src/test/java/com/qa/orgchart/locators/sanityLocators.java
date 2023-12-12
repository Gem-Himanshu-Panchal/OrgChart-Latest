package com.qa.orgchart.locators;

import org.openqa.selenium.By;


public class sanityLocators {
    public static By exportHierarchyButton = By.xpath("//button[contains(text(),' Export Hierarchy ')]");
    public static By searchBox = By.xpath("//div[@role='combobox']//input");
    public static By invalidNameSearch = By.xpath("//div[contains(text(),'No data found.')]");
    public static By feedbackTypeDropdown = By.xpath("//div[contains(text(),'Enter Feedback Type')]");
    public static By feedbackDescription = By.xpath("//input[@formcontrolname='feedbackDesc']");
    public static By feedbackTypeDownArrow = By.xpath("//app-feedback//span[@class='ng-arrow-wrapper']");
    public static By viewsDropdown = By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']");
    public static By selectedView = By.xpath("//div[@class='ng-option ng-option-selected ng-option-marked ng-star-inserted']//span");
    public static By loginPage = By.xpath("//button[contains(text(),' Login with Gemini Mail ')]");
    public static By invalidNameSearchResult = By.xpath("//div[contains(text(),' No data found ')]");
    public static By fileUpload = By.xpath("//input[@id='upload']");
    public static By uploadedFileName = By.xpath("//span[contains(text(),' validCSV.xlsx ')]");
    public static By dropdownViews =By.xpath("//div[@class='ng-value-container']");
    public static By viewPlaceholder = By.xpath("//span[@class='ng-value-label ng-star-inserted']");
    public static By viewNameList = By.xpath("//div[@class='ag-center-cols-container']//div[1]//div[1]");
    public static By addViewBtn = By.xpath("//button[contains(text(),'Add View')]");
    public static By submitBtn = By.xpath("//button[contains(text(),' Submit ')]");
    public static By viewNameInput = By.xpath("//input[@formcontrolName='viewName']");
    public static By downArrows = By.xpath("//span[@class='ng-arrow-wrapper']");
    public static By viewNamesList = By.xpath("//div[@class='ag-center-cols-container']//div//div[1]");
    public static By editBtn =By.xpath("//img[@alt='edit']//..");
    public static By updateViewInput = By.xpath("//input[@placeholder='Enter View Name']");
    public static By crossIcon = By.xpath("//img[@alt='close']");
    public static By cloneViewButton = By.xpath("//img[@title='Clone View']");
    public static By newViewNameInputBox = By.xpath("//input[@placeholder='Enter View Name']");
    public static By cautionMessage = By.xpath("//span[contains(text(),' View name should always start with letters and can contain digits ')]");
    public static By inactiveSubmitButton = By.xpath("//button[@class='m-btn add-btn btn-disabled ng-star-inserted']");
    public static By deleteButton = By.xpath("//button[contains(text(),'Yes, delete it!')]");

    public static By searchBoxField(String value) {
        return By.xpath("//input[@placeholder='" + value + "']");
    }

    public static By toastMessage(String value) {
        return By.xpath("//div[contains(text(),'" + value + "')]");
    }

    public static By dropdownValues(String value) {
        return By.xpath("//span[contains(text(),'" + value + "')]");
    }
    //input[@placeholder='Enter View Name']
    public static By searchedName(String name) {
        return By.xpath("//strong[contains(text(),'" + name + "')]");
    }

    public static By btnLocator(String locatorType, String value, String key) {
        return By.xpath("//" + locatorType + "[@" + key + "='" + value + "']");
    }

    public static By modalValidation(String locatorType, String value) {
        return By.xpath("//" + locatorType + "[contains(text(),'" + value + "')]");
    }
    public static By searchedName = By.xpath("//div[@class='node-data ng-star-inserted']//div[contains(text(),'Himanshu Panchal')]");

    public static By adminTab(String btnName) {
        return By.xpath("//li[contains(text(),'"+btnName+"')]");
    }

    public static By elementWithText(String type,String value){
         return By.xpath("//"+type+"[contains(text(),'"+value+"')]");
        }
    }


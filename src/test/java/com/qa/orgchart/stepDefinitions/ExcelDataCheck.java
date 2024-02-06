package com.qa.orgchart.stepDefinitions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


public class ExcelDataCheck {

    public  String json;


    public static class Employee {
        @JsonProperty("EmployeeName")
        private String employeeName;

        @JsonProperty("EmployeeCode")
        private String employeeCode;

        @JsonProperty("EmailId")
        private String emailId;

        @JsonProperty("Designation")
        private String designation;

        @JsonProperty("DepartmentName")
        private String departmentName;

        @JsonProperty("MobileNumber")
        private String mobileNumber;

        @JsonProperty("Location")
        private String location;

        @JsonProperty("ReportingManager")
        private String reportingManager;

        @JsonProperty("ManagerCode")
        private String managerCode;

        @JsonProperty("ImagePath")
        private String imagePath;

        @JsonProperty("Experience")
        private int experience;

        @JsonProperty("ECTech")
        private String ecTech;

        @JsonProperty("DCTech")
        private String dcTech;

        @JsonProperty("PrimarySkills")
        private String primarySkills;

        @JsonProperty("Summary")
        private String summary;

        @JsonProperty("DateOfJoining")
        private String dateOfJoining;

        @JsonProperty("DCChairId")
        private String dcChairId;

        @JsonProperty("DCChairName")
        private String dcChairName;

        @JsonProperty("ECChairId")
        private String ecChairId;

        @JsonProperty("ECChairName")
        private String ecChairName;

        @JsonProperty("ECMentorId")
        private String ecMentorId;

        @JsonProperty("ECMentorName")
        private String ecMentorName;

        @JsonProperty("SecondaryDCs")
        private String secondaryDCs;

        @JsonProperty("OverallExp")
        private int overallExp;

        @JsonProperty("LastJobTenure")
        private String lastJobTenure;

        @JsonProperty("SecondarySkills")
        private String secondarySkills;

        // Getter and setter methods

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

        public String getEmployeeCode() {
            return employeeCode;
        }

        public void setEmployeeCode(String employeeCode) {
            this.employeeCode = employeeCode;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getReportingManager() {
            return reportingManager;
        }

        public void setReportingManager(String reportingManager) {
            this.reportingManager = reportingManager;
        }

        public String getManagerCode() {
            return managerCode;
        }

        public void setManagerCode(String managerCode) {
            this.managerCode = managerCode;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public String getEcTech() {
            return ecTech;
        }

        public void setEcTech(String ecTech) {
            this.ecTech = ecTech;
        }

        public String getDcTech() {
            return dcTech;
        }

        public void setDcTech(String dcTech) {
            this.dcTech = dcTech;
        }

        public String getPrimarySkills() {
            return primarySkills;
        }

        public void setPrimarySkills(String primarySkills) {
            this.primarySkills = primarySkills;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getDateOfJoining() {
            return dateOfJoining;
        }

        public void setDateOfJoining(String dateOfJoining) {
            this.dateOfJoining = dateOfJoining;
        }

        public String getDcChairId() {
            return dcChairId;
        }

        public void setDcChairId(String dcChairId) {
            this.dcChairId = dcChairId;
        }

        public String getDcChairName() {
            return dcChairName;
        }

        public void setDcChairName(String dcChairName) {
            this.dcChairName = dcChairName;
        }

        public String getEcChairId() {
            return ecChairId;
        }

        public void setEcChairId(String ecChairId) {
            this.ecChairId = ecChairId;
        }

        public String getEcChairName() {
            return ecChairName;
        }

        public void setEcChairName(String ecChairName) {
            this.ecChairName = ecChairName;
        }

        public String getEcMentorId() {
            return ecMentorId;
        }

        public void setEcMentorId(String ecMentorId) {
            this.ecMentorId = ecMentorId;
        }

        public String getEcMentorName() {
            return ecMentorName;
        }

        public void setEcMentorName(String ecMentorName) {
            this.ecMentorName = ecMentorName;
        }

        public String getSecondaryDCs() {
            return secondaryDCs;
        }

        public void setSecondaryDCs(String secondaryDCs) {
            this.secondaryDCs = secondaryDCs;
        }

        public int getOverallExp() {
            return overallExp;
        }

        public void setOverallExp(int overallExp) {
            this.overallExp = overallExp;
        }

        public String getLastJobTenure() {
            return lastJobTenure;
        }

        public void setLastJobTenure(String lastJobTenure) {
            this.lastJobTenure = lastJobTenure;
        }

        public String getSecondarySkills() {
            return secondarySkills;
        }

        public void setSecondarySkills(String secondarySkills) {
            this.secondarySkills = secondarySkills;
        }
    }

    @Given("^Open downloaded excel file$")
    public void open_file_and_convert_it() {
        try {
            DriverAction.waitSec(15);
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            DriverAction.waitSec(10);


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String todayDate = dateFormat.format(new Date());

            String downloadFolder = "C:\\Users\\himanshu.panchal\\Downloads\\";

            File folder = new File(downloadFolder);

            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().contains("EmpMasterTable") && file.getName().contains(todayDate)) {
                        List<Employee> employees = openExcelFile(file);
                        ObjectMapper objectMapper = new ObjectMapper();
                        json= objectMapper.writeValueAsString(employees);

                        // Print the generated JSON
                        System.out.println(json);
                        return;
                    }
                }
            }


            System.out.println("No matching file found for today's date and 'EmpMasterTable' in the download folder.");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Employee> openExcelFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file);
             Workbook ignored = WorkbookFactory.create(fis)) {
            System.out.println("Opened Excel file: " + file.getAbsolutePath());
        }

        DriverAction.waitSec(5);


        List<Employee> employees = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            DataFormatter dataFormatter = new DataFormatter();

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Employee employee = new Employee();

                int cellIndex = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    String cellValue = dataFormatter.formatCellValue(cell);

                    switch (cellIndex) {
                        case 0:
                            employee.setEmployeeName(cellValue);
                            break;
                        case 1:
                            employee.setEmployeeCode(cellValue);
                            break;
                        case 2:
                            employee.setEmailId(cellValue);
                            break;
                        case 3:
                            employee.setDesignation(cellValue);
                            break;
                        case 4:
                            employee.setDepartmentName(cellValue);
                            break;
                        case 5:
                            employee.setMobileNumber(cellValue);
                            break;
                        case 6:
                            employee.setLocation(cellValue);
                            break;
                        case 7:
                            employee.setReportingManager(cellValue);
                            break;
                        case 8:
                            employee.setManagerCode(cellValue);
                            break;
                        case 9:
                            employee.setImagePath(cellValue);
                            break;
                        case 10:
                            try {
                                employee.setExperience(Integer.parseInt(cellValue));
                            } catch (NumberFormatException e) {
                                employee.setExperience(0);
                            }
                            break;
                        case 11:
                            employee.setEcTech(cellValue);
                            break;
                        case 12:
                            employee.setDcTech(cellValue);
                            break;
                        case 13:
                            employee.setPrimarySkills(cellValue);
                            break;
                        case 14:
                            employee.setSecondarySkills(cellValue);
                            break;
                        case 15:
                            employee.setSummary(cellValue);
                            break;
                        case 16:
                            employee.setDateOfJoining(cellValue);
                            break;
                        case 17:
                            employee.setDcChairId(cellValue);
                            break;
                        case 18:
                            employee.setDcChairName(cellValue);
                            break;
                        case 19:
                            employee.setEcChairId(cellValue);
                            break;
                        case 20:
                            employee.setEcChairName(cellValue);
                            break;
                        case 21:
                            employee.setEcMentorId(cellValue);
                            break;
                        case 22:
                            employee.setEcMentorName(cellValue);
                            break;
                        case 23:
                            employee.setSecondaryDCs(cellValue);
                            break;
                        case 24:

                            try {
                                employee.setOverallExp(Integer.parseInt(cellValue));
                            } catch (NumberFormatException e) {
                                employee.setOverallExp(0);
                            }
                            break;
                        case 25:
                            employee.setLastJobTenure(cellValue);
                            break;

                        default:
                            break;
                    }

                    cellIndex++;
                }

                employees.add(employee);
            }
        }

        return employees;
    }


    @Then("^Update the JSON data file$")
    public void updateTheFile() {
        String jsonFilePath = "src/test/java/com/qa/orgchart/jsonData/updatedJsonPayload.json";
        writeToJsonFile(jsonFilePath, json);
    }
    @Then("^Update the mentor name list$")
    public void updatementorName() throws IOException {
        String filePath = "src/test/java/com/qa/orgchart/jsonData/MentorsNameList";
        String content = GenericUtils.extractMentorListFromJSON(json);
        writeStringToFile(filePath, content);
    }

    @And("Update the mentor code list")
    public void updateTheMentorCodeList() throws IOException {
        String filePath = "src/test/java/com/qa/orgchart/jsonData/MentorsCodeList";
        String content = GenericUtils.extractMentorCodeFromJSON(json);
        writeStringToFile(filePath, content);
    }
    private static void writeStringToFile(String filePath, String content) throws IOException {
        byte[] bytes = content.getBytes();
        Path path = Paths.get(filePath);
        Files.write(path, bytes);
    }
    private static void writeToJsonFile(String jsonFilePath, String jsonData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFilePath))) {

            writer.write(jsonData);

            System.out.println("JSON data has been written to the file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


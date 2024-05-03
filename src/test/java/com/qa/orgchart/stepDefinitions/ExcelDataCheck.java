//package com.qa.orgchart.stepDefinitions;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.gemini.generic.ui.utils.DriverAction;
//import com.qa.orgchart.utils.GenericUtils;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
////import org.apache.poi.ss.usermodel.*;
//
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.List;
//
//
//public class ExcelDataCheck {
//
//    public  String json;
//    public static class Employee {
//        @JsonProperty("EmployeeName")
//        private String employeeName;
//
//        @JsonProperty("EmployeeCode")
//        private String employeeCode;
//
//        @JsonProperty("EmailId")
//        private String emailId;
//
//        @JsonProperty("Designation")
//        private String designation;
//
//        @JsonProperty("DepartmentName")
//        private String departmentName;
//
//        @JsonProperty("MobileNumber")
//        private String mobileNumber;
//
//        @JsonProperty("Location")
//        private String location;
//
//        @JsonProperty("ReportingManager")
//        private String reportingManager;
//
//        @JsonProperty("ManagerCode")
//        private String managerCode;
//
//        @JsonProperty("ImagePath")
//        private String imagePath;
//
//        @JsonProperty("Experience")
//        private int experience;
//
//        @JsonProperty("ECTech")
//        private String ecTech;
//
//        @JsonProperty("DCTech")
//        private String dcTech;
//
//        @JsonProperty("PrimarySkills")
//        private String primarySkills;
//
//        @JsonProperty("Summary")
//        private String summary;
//
//        @JsonProperty("DateOfJoining")
//        private String dateOfJoining;
//
//        @JsonProperty("DCChairId")
//        private String dcChairId;
//
//        @JsonProperty("DCChairName")
//        private String dcChairName;
//
//        @JsonProperty("ECChairId")
//        private String ecChairId;
//
//        @JsonProperty("ECChairName")
//        private String ecChairName;
//
//        @JsonProperty("ECMentorId")
//        private String ecMentorId;
//
//        @JsonProperty("ECMentorName")
//        private String ecMentorName;
//
//        @JsonProperty("SecondaryDCs")
//        private String secondaryDCs;
//
//        @JsonProperty("OverallExp")
//        private int overallExp;
//
//        @JsonProperty("LastJobTenure")
//        private String lastJobTenure;
//
//        @JsonProperty("SecondarySkills")
//        private String secondarySkills;
//
//        // Getter and setter methods
//
//        public String getEmployeeName() {
//            return employeeName;
//        }
//
//        public void setEmployeeName(String employeeName) {
//            this.employeeName = employeeName;
//        }
//
//        public String getEmployeeCode() {
//            return employeeCode;
//        }
//
//        public void setEmployeeCode(String employeeCode) {
//            this.employeeCode = employeeCode;
//        }
//
//        public String getEmailId() {
//            return emailId;
//        }
//
//        public void setEmailId(String emailId) {
//            this.emailId = emailId;
//        }
//
//        public String getDesignation() {
//            return designation;
//        }
//
//        public void setDesignation(String designation) {
//            this.designation = designation;
//        }
//
//        public String getDepartmentName() {
//            return departmentName;
//        }
//
//        public void setDepartmentName(String departmentName) {
//            this.departmentName = departmentName;
//        }
//
//        public String getMobileNumber() {
//            return mobileNumber;
//        }
//
//        public void setMobileNumber(String mobileNumber) {
//            this.mobileNumber = mobileNumber;
//        }
//
//        public String getLocation() {
//            return location;
//        }
//
//        public void setLocation(String location) {
//            this.location = location;
//        }
//
//        public String getReportingManager() {
//            return reportingManager;
//        }
//
//        public void setReportingManager(String reportingManager) {
//            this.reportingManager = reportingManager;
//        }
//
//        public String getManagerCode() {
//            return managerCode;
//        }
//
//        public void setManagerCode(String managerCode) {
//            this.managerCode = managerCode;
//        }
//
//        public String getImagePath() {
//            return imagePath;
//        }
//
//        public void setImagePath(String imagePath) {
//            this.imagePath = imagePath;
//        }
//
//        public int getExperience() {
//            return experience;
//        }
//
//        public void setExperience(int experience) {
//            this.experience = experience;
//        }
//
//        public String getEcTech() {
//            return ecTech;
//        }
//
//        public void setEcTech(String ecTech) {
//            this.ecTech = ecTech;
//        }
//
//        public String getDcTech() {
//            return dcTech;
//        }
//
//        public void setDcTech(String dcTech) {
//            this.dcTech = dcTech;
//        }
//
//        public String getPrimarySkills() {
//            return primarySkills;
//        }
//
//        public void setPrimarySkills(String primarySkills) {
//            this.primarySkills = primarySkills;
//        }
//
//        public String getSummary() {
//            return summary;
//        }
//
//        public void setSummary(String summary) {
//            this.summary = summary;
//        }
//
//        public String getDateOfJoining() {
//            return dateOfJoining;
//        }
//
//        public void setDateOfJoining(String dateOfJoining) {
//            this.dateOfJoining = dateOfJoining;
//        }
//
//        public String getDcChairId() {
//            return dcChairId;
//        }
//
//        public void setDcChairId(String dcChairId) {
//            this.dcChairId = dcChairId;
//        }
//
//        public String getDcChairName() {
//            return dcChairName;
//        }
//
//        public void setDcChairName(String dcChairName) {
//            this.dcChairName = dcChairName;
//        }
//
//        public String getEcChairId() {
//            return ecChairId;
//        }
//
//        public void setEcChairId(String ecChairId) {
//            this.ecChairId = ecChairId;
//        }
//
//        public String getEcChairName() {
//            return ecChairName;
//        }
//
//        public void setEcChairName(String ecChairName) {
//            this.ecChairName = ecChairName;
//        }
//
//        public String getEcMentorId() {
//            return ecMentorId;
//        }
//
//        public void setEcMentorId(String ecMentorId) {
//            this.ecMentorId = ecMentorId;
//        }
//
//        public String getEcMentorName() {
//            return ecMentorName;
//        }
//
//        public void setEcMentorName(String ecMentorName) {
//            this.ecMentorName = ecMentorName;
//        }
//
//        public String getSecondaryDCs() {
//            return secondaryDCs;
//        }
//
//        public void setSecondaryDCs(String secondaryDCs) {
//            this.secondaryDCs = secondaryDCs;
//        }
//
//        public int getOverallExp() {
//            return overallExp;
//        }
//
//        public void setOverallExp(int overallExp) {
//            this.overallExp = overallExp;
//        }
//
//        public String getLastJobTenure() {
//            return lastJobTenure;
//        }
//
//        public void setLastJobTenure(String lastJobTenure) {
//            this.lastJobTenure = lastJobTenure;
//        }
//
//        public String getSecondarySkills() {
//            return secondarySkills;
//        }
//
//        public void setSecondarySkills(String secondarySkills) {
//            this.secondarySkills = secondarySkills;
//        }
//    }
//
//    @Given("^Open downloaded excel file$")
//    public void openFileAndConvertIt() {
//        try {
//            DriverAction.waitSec(15);
//            Robot robot = new Robot();
//
//            robot.keyPress(KeyEvent.VK_ENTER);
//            robot.keyRelease(KeyEvent.VK_ENTER);
//
//            DriverAction.waitSec(10);
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            String todayDate = dateFormat.format(new Date());
//
//            String downloadFolder = "C:\\Users\\himanshu.panchal\\Downloads\\";
//            File folder = new File(downloadFolder);
//            File[] files = folder.listFiles();
//
//            if (files != null) {
//                for (File file : files) {
//                    if (file.getName().contains("EmpMasterTable") && file.getName().contains(todayDate)) {
//                        List<Employee> employees = openExcelFile(file);
//                        ObjectMapper objectMapper = new ObjectMapper();
//                        json = objectMapper.writeValueAsString(employees);
//                        System.out.println(json);
//                        return;
//                    }
//                }
//            }
//
//            System.out.println("No matching file found for today's date and 'EmpMasterTable' in the download folder.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private List<Employee> openExcelFile(File file) {
//        List<Employee> employees = new ArrayList<>();
//        try (FileInputStream fis = new FileInputStream(file)){
//            Workbook workbook = WorkbookFactory.create(fis);
//
//            DataFormatter dataFormatter = new DataFormatter();
//            Sheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator = sheet.iterator();
//
//            if (rowIterator.hasNext()) {
//                rowIterator.next(); // Skip header row
//            }
//
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//                Iterator<Cell> cellIterator = row.cellIterator();
//                Employee employee = new Employee();
//
//                int cellIndex = 0;
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    String cellValue = dataFormatter.formatCellValue(cell);
//                    // Set Employee object fields based on cell index
//                    // Example: switch (cellIndex) { ... }
//                    cellIndex++;
//                }
//                employees.add(employee);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return employees;
//    }
//
//    @Then("^Update the JSON data file$")
//    public void updateTheFile() {
//        String jsonFilePath = "src/test/java/com/qa/orgchart/jsonData/updatedJsonPayload.json";
//        writeToJsonFile(jsonFilePath, json);
//    }
//
//    @Then("^Update the mentor name list$")
//    public void updateMentorName() {
//        try {
//            String filePath = "src/test/java/com/qa/orgchart/jsonData/MentorsNameList";
//            String content = GenericUtils.extractMentorListFromJSON(json);
//            writeStringToFile(filePath, content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Then("^Update the mentor code list$")
//    public void updateMentorCodeList() {
//        try {
//            String filePath = "src/test/java/com/qa/orgchart/jsonData/MentorsCodeList";
//            String content = GenericUtils.extractMentorCodeFromJSON(json);
//            writeStringToFile(filePath, content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void writeStringToFile(String filePath, String content) throws IOException {
//        Path path = Paths.get(filePath);
//        Files.write(path, content.getBytes());
//    }
//
//    private static void writeToJsonFile(String jsonFilePath, String jsonData) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFilePath))) {
//            writer.write(jsonData);
//            System.out.println("JSON data has been written to the file successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//

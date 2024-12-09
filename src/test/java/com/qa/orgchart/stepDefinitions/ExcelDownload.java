package com.qa.orgchart.stepDefinitions;

import com.gemini.gemjar.enums.Status;
import com.gemini.gemjar.reporting.GemTestReporter;
import com.gemini.gemjar.utils.ui.DriverAction;
import com.qa.orgchart.locators.CommonLocators;
import com.qa.orgchart.utils.GenericUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.List;

public class ExcelDownload {
    @And("Click on Admin button")
    public void clickOnButton() {
        try{
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitUntilElementClickable(CommonLocators.AdminIcon, 10);
            DriverAction.click(CommonLocators.AdminIcon);
        }catch (Exception e){
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("Click on Manage View button")
    public void clickOnManageViewButton() {
        try{
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitUntilElementClickable(CommonLocators.manageViewIcon, 10);
            DriverAction.click(CommonLocators.manageViewIcon);
        }catch (Exception e){
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
            throw new RuntimeException(e);
        }
    }

    @And("Click on Export Employees button")
    public void clickOnExportEmployeesButton() {
        try{
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitUntilElementClickable(CommonLocators.exportIcon, 10);
            DriverAction.click(CommonLocators.exportIcon);
            GenericUtils.waitUntilLoaderDisappear();
            DriverAction.waitSec(15);
            Robot robot = new Robot();

            // Press TAB key to move focus to "Save" button (if needed)
//            robot.keyPress(KeyEvent.VK_TAB);
//            robot.keyRelease(KeyEvent.VK_TAB);

            // Press ENTER to confirm "Save"
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }catch (Exception e){
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
            throw new RuntimeException(e);
        }
    }

    @Then("Open downloaded excel file")
    public void openDownloadedExcelFile() {
        try {
            DriverAction.waitSec(10);
            String folderPath = "C:\\Users\\himanshu.panchal\\Downloads";
            String fileNamePattern = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".*EmpMasterTable.xls";

            File targetFile = findFile(folderPath);
            if (targetFile == null) {
                System.out.println("File not found matching pattern: " + fileNamePattern);
                return;
            }

            JSONArray jsonArray = parseExcelToJson(targetFile.getAbsolutePath());

            System.out.println(jsonArray.toString());
            writeJsonToFile(jsonArray);
            extractAndWriteMentorNames(jsonArray);
            extractAndWriteMentorCodes(jsonArray);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, Status.FAIL);
            throw new RuntimeException(e);
        }
    }


    private static File findFile(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            System.out.println("Invalid folder path: " + folderPath);
            return null;
        }

        // Generate the date in "yyyy-MM-dd" format
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // File pattern: Starts with the date, anything in the middle, ends with "__EmpMasterTable.xls"
        File[] matchingFiles = folder.listFiles((dir, name) ->
                name.matches("^" + currentDate + ".*__EmpMasterTable\\.xls$")
        );

        return (matchingFiles != null && matchingFiles.length > 0) ? matchingFiles[0] : null;
    }

    private static JSONArray parseExcelToJson(String filePath) throws IOException {
        JSONArray jsonArray = new JSONArray();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            Iterator<Row> rows = sheet.iterator();

            List<String> headers = new ArrayList<>();
            if (rows.hasNext()) {
                Row headerRow = rows.next();
                for (Cell cell : headerRow) {
                    headers.add(cell.getStringCellValue());
                }
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.size(); i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    jsonObject.put(headers.get(i), getCellValue(cell));
                }
                jsonArray.put(jsonObject);
            }
        }

        return jsonArray;
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(cell.getDateCellValue());
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
            default:
                return "";
        }
    }
    public static void writeJsonToFile(JSONArray jsonArray) {
        File file = new File("C:\\Users\\himanshu.panchal\\OneDrive - Gemini Solutions\\Desktop\\GemJar\\OrgChart-Latest\\src\\test\\java\\com\\qa\\orgchart\\jsonData\\updatedJsonPayload.json");

        try (FileWriter writer = new FileWriter(file, false)) { // 'false' ensures the file is cleared
            writer.write(jsonArray.toString(4)); // Pretty print with 4 spaces indentation
            System.out.println("JSON data successfully written to " + "C:\\Users\\himanshu.panchal\\OneDrive - Gemini Solutions\\Desktop\\GemJar\\OrgChart-Latest\\src\\test\\java\\com\\qa\\orgchart\\jsonData\\updatedJsonPayload.json");
        } catch (IOException e) {
            System.err.println("Error while writing JSON to file: " + e.getMessage());
        }
    }

    public static void extractAndWriteMentorNames(JSONArray jsonArray) {
        Set<String> mentorNames = new HashSet<>();

        // Extract mentor names
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject employee = jsonArray.getJSONObject(i);

            if (employee.has("ReportingManager")) {
                mentorNames.add(employee.getString("ECMentorName"));
            }
//            if (employee.has("DCChairName")) {
//                mentorNames.add(employee.getString("DCChairName"));
//            }
//            if (employee.has("ECChairName")) {
//                mentorNames.add(employee.getString("ECChairName"));
//            }
        }

        // Write mentor names to file
        try (FileWriter writer = new FileWriter("C:\\Users\\himanshu.panchal\\OneDrive - Gemini Solutions\\Desktop\\GemJar\\OrgChart-Latest\\src\\test\\java\\com\\qa\\orgchart\\jsonData\\MentorsNameList")) {
            for (String name : mentorNames) {
                writer.write(name + System.lineSeparator());
            }
            System.out.println("Mentor names successfully written to " + "C:\\Users\\himanshu.panchal\\OneDrive - Gemini Solutions\\Desktop\\GemJar\\OrgChart-Latest\\src\\test\\java\\com\\qa\\orgchart\\jsonData\\MentorsNameList");
        } catch (IOException e) {
            System.err.println("Error while writing mentor names: " + e.getMessage());
        }
    }

    public static void extractAndWriteMentorCodes(JSONArray jsonArray) {
        Set<String> mentorCodes = new HashSet<>();

        // Extract mentor codes
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject employee = jsonArray.getJSONObject(i);

            if (employee.has("ManagerCode")) {
                mentorCodes.add(employee.getString("ECMentorId"));
            }
//            if (employee.has("DCChairId")) {
//                mentorCodes.add(employee.getString("DCChairId"));
//            }
//            if (employee.has("ECChairId")) {
//                mentorCodes.add(employee.getString("ECChairId"));
//            }
        }

        // Write mentor codes to file
        try (FileWriter writer = new FileWriter("C:\\Users\\himanshu.panchal\\OneDrive - Gemini Solutions\\Desktop\\GemJar\\OrgChart-Latest\\src\\test\\java\\com\\qa\\orgchart\\jsonData\\MentorsCodeList")) {
            for (String code : mentorCodes) {
                writer.write(code + System.lineSeparator());
            }
            System.out.println("Mentor codes successfully written to " + "C:\\Users\\himanshu.panchal\\OneDrive - Gemini Solutions\\Desktop\\GemJar\\OrgChart-Latest\\src\\test\\java\\com\\qa\\orgchart\\jsonData\\MentorsCodeList");
        } catch (IOException e) {
            System.err.println("Error while writing mentor codes: " + e.getMessage());
        }
    }
}

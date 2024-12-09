package com.qa.orgchart.stepDefinitions;

import com.gemini.gemjar.enums.Status;
import com.gemini.gemjar.reporting.GemTestReporter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class test {
    public static void main(String[] args) {
        try {
            String folderPath = "C:\\Users\\himanshu.panchal\\Downloads";
            String fileNamePattern = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".*EmpMasterTable.xls";

            File targetFile = findFile(folderPath);
            if (targetFile == null) {
                System.out.println("File not found matching pattern: " + fileNamePattern);
                return;
            }

            JSONArray jsonArray = parseExcelToJson(targetFile.getAbsolutePath());

            System.out.println(jsonArray.toString());
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

}


package com.qa.orgchart.stepDefinitions;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test {

    public static void main(String[] args) {
        try {
            // Specify the path to your Excel file
            String excelFilePath = "path/to/your/excel/file.xlsx";

            // Read Excel file
            List<List<String>> excelData = readExcel(excelFilePath);

            // Convert Excel data to JSON
            String jsonData = convertToJson(excelData);

            // Print the generated JSON
            System.out.println(jsonData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<List<String>> readExcel(String filePath) throws Exception {
        List<List<String>> excelData = new ArrayList<>();

        FileInputStream excelFile = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet sheet = workbook.getSheetAt(0); // Assuming the data is in the first sheet

        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            List<String> rowData = new ArrayList<>();

            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();
                rowData.add(currentCell.toString());
            }

            excelData.add(rowData);
        }

        workbook.close();
        excelFile.close();

        return excelData;
    }

    private static String convertToJson(List<List<String>> excelData) throws Exception {
        List<Object> jsonArray = new ArrayList<>();

        for (List<String> row : excelData) {
            // Assuming the first row contains headers
            String[] headers = excelData.get(0).toArray(new String[0]);
            Object jsonRow = new ObjectMapper().readTree("{}");

            for (int i = 0; i < row.size(); i++) {
                ((ObjectNode) jsonRow).put(headers[i], row.get(i));
            }

            jsonArray.add(jsonRow);
        }

        return new ObjectMapper().writeValueAsString(jsonArray);
    }
}

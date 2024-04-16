package com.qa.orgchart.stepDefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.qa.orgchart.stepDefinitions.DCAPICheck.*;

public class ECAPICheck {
    public StringBuilder response = new StringBuilder();
    public static List<String> apiEmployeeNames = new ArrayList<>();
    public static List<String> jsonDataEmpList = new ArrayList<>();
    @When("Hit endpoint for EC {string}")
    public void hit_endpoint_for_ec(String ecTech) {
        String apiUrl = "https://orgchartapidev.geminisolutions.com/dev/hierarchy/external/fetchHierarchyForOneEC/ECTECHNAME?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE4NjYxMDE1MjkuMzYxLCJpYXQiOjE2OTMzMDE1Mjl9.WfzgTwPOTRb2LolnP0lgHWjekQ5737hs2uYjII4fS9E&key=SktmNGVGTVFIQ3k4QmJR";
        String encoded = encodeValue(ecTech);
        if(ecTech.equalsIgnoreCase("Full stack (Angular/ Node/ React)")){
            apiUrl = apiUrl.replaceFirst("ECTECHNAME", "Full Stack");
        } else if(ecTech.equalsIgnoreCase("Python/C++")){
            apiUrl = apiUrl.replaceFirst("ECTECHNAME", "Python");
        }else {
            apiUrl = apiUrl.replaceFirst("ECTECHNAME", encoded);
        }
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                conn.disconnect();
                apiEmployeeNames = extractNames(response);
                List<String> coChairs = extractCoChair(response);
                File jsonFile = new File("src/test/java/com/qa/orgchart/jsonData/updatedJsonPayload.json");
                jsonDataEmpList = extractNamesWithECTech(jsonFile, ecTech);
                List<String> missingEmpList = new ArrayList<>();
                List<String> extraEmpList = new ArrayList<>();

                if (jsonDataEmpList.size() > apiEmployeeNames.size()) {
                    for (String str : jsonDataEmpList) {
                        if (!apiEmployeeNames.contains(str)) {
                            missingEmpList.add(str);
                        }
                    }
                    if (!missingEmpList.isEmpty())
                        GemTestReporter.addTestStep("Check data",
                                "Missing emp from the API: " + missingEmpList, STATUS.FAIL);
                    else GemTestReporter.addTestStep("Check data",
                            "Exact number of nodes", STATUS.PASS);
                } else if (apiEmployeeNames.size() > jsonDataEmpList.size()) {
                    for (String str : apiEmployeeNames) {
                        if (!jsonDataEmpList.contains(str) && !coChairs.contains(str)) {
                            extraEmpList.add(str);
                        }
                    }
                    if (!extraEmpList.isEmpty())
                        GemTestReporter.addTestStep("Check data",
                                "Extra emp in the API: " + extraEmpList, STATUS.FAIL);
                    else GemTestReporter.addTestStep("Check data",
                            "Exact number of nodes", STATUS.PASS);
                } else if(apiEmployeeNames.equals(jsonDataEmpList)) {
                    GemTestReporter.addTestStep("Check data",
                            "Exact number of nodes", STATUS.PASS);
                }
            } else {
                GemTestReporter.addTestStep("Check API hit", "Status Code is not 200", STATUS.FAIL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> extractCoChair(StringBuilder response) {
        List<String> coChairs = new ArrayList<>();
        String jsonString = response.toString();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray dataArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataObject = dataArray.getJSONObject(i);
            String coChair = dataObject.getString("CoChairs");
            if (!coChair.isEmpty()) {
                String[] coChairArray = coChair.split(",");
                for (String coChairName : coChairArray) {
                    coChairs.add(coChairName.trim());
                }
            }
        }
        return coChairs;
    }
    public static List<String> extractNamesWithECTech(File jsonFile, String techName) {
        List<String> names = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonFile);
            String ecChairName = "";
            for (JsonNode employeeNode : rootNode) {
                JsonNode ecTechNode = employeeNode.get("ECTech");
                if (ecTechNode != null && ecTechNode.asText().contains(techName)) {
                    names.add(employeeNode.get("EmployeeName").asText());
                    ecChairName = employeeNode.get("ECChairName").asText();
                }
            }
            names.add(ecChairName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
}

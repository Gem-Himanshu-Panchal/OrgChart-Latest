package com.qa.orgchart.stepDefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DCAPICheck {

    public StringBuilder response = new StringBuilder();
    public static List<String> apiEmployeeNames = new ArrayList<>();
    public static List<String> jsonDataEmpList = new ArrayList<>();

    @When("Hit endpoint for {string}")
    public void hit_endpoint_for(String dcTech) {
        String apiUrl = "https://orgchartapidev.geminisolutions.com/dev/hierarchy/external/fetchHierarchyForOneDC/DCTECHNAME?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE4NjYxMDE1MjkuMzYxLCJpYXQiOjE2OTMzMDE1Mjl9.WfzgTwPOTRb2LolnP0lgHWjekQ5737hs2uYjII4fS9E&key=SktmNGVGTVFIQ3k4QmJR";
        String encoded = encodeValue(dcTech);
        apiUrl = apiUrl.replaceFirst("DCTECHNAME", encoded);

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
                System.out.println("Employee names: " + apiEmployeeNames);
                List<String> coChairs = extractCoChairs(response);
                System.out.println("Co chairs: " + coChairs);
                File jsonFile = new File("src/test/java/com/qa/orgchart/jsonData/updatedJsonPayload.json");
                jsonDataEmpList = extractNamesWithDCTechOrSecondaryDCs(jsonFile, dcTech);
                System.out.println("JSON Data: " + jsonDataEmpList);
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
                } else {
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
    public static String encodeValue(String value) {
        try {
            String encoded = URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
            return encoded.replace("+", "%20").replace("%5C", "%2F");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported", e);
        }
    }

    public static List<String> extractCoChairs(StringBuilder response) {
        List<String> coChairs = new ArrayList<>();
        String jsonString = response.toString();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray dataArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject dataObject = dataArray.getJSONObject(i);
            String coChair = dataObject.getString("CoChair");
            if (!coChair.isEmpty()) {
                String[] coChairArray = coChair.split(",");
                for (String coChairName : coChairArray) {
                    coChairs.add(coChairName.trim());
                }
            }
        }
        return coChairs;
    }

    public static List<String> extractNames(StringBuilder resp) {
        List<String> names = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode rootNode = objectMapper.readTree(String.valueOf(resp));
            JsonNode dataNode = rootNode.get("data");

            if (dataNode != null && dataNode.isArray()) {
                for (JsonNode node : dataNode) {
                    JsonNode childrenNode = node.get("children");
                    if (childrenNode != null && childrenNode.isArray()) {
                        extractNamesFromChildren(childrenNode, names);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return names;
    }

    private static void extractNamesFromChildren(JsonNode childrenNode, List<String> names) {
        for (JsonNode child : childrenNode) {
            JsonNode nameNode = child.get("name");
            if (nameNode != null) {
                names.add(nameNode.asText());
            }
            JsonNode nestedChildrenNode = child.get("children");
            if (nestedChildrenNode != null && nestedChildrenNode.isArray()) {
                extractNamesFromChildren(nestedChildrenNode, names);
            }
        }
    }
//    public static void analyseResp(StringBuilder response) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            JsonNode rootNode = objectMapper.readTree(response.toString());
//
//            JsonNode dataNode = rootNode.get("data");
//            if (dataNode != null) {
//                JsonNode childrenNode = dataNode.get("children");
//                if (childrenNode != null) {
//                    List<String> employeeNames = extractEmployeeNames(childrenNode);
//                    System.out.println("Employee names:" +employeeNames);
//                } else {
//                    System.out.println("No 'children' node found in the JSON.");
//                }
//            } else {
//                System.out.println("No 'data' node found in the JSON.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static List<String> extractEmployeeNames(JsonNode node) {
//        List<String> employeeNames = new ArrayList<>();
//        String fieldName = "name";
//
//        if (node.isArray()) {
//            for (JsonNode element : node) {
//                JsonNode nameNode = element.get(fieldName);
//                if (nameNode != null) {
//                    employeeNames.add(nameNode.asText());
//                }
//                JsonNode childrenNode = element.get("children");
//                if (childrenNode != null) {
//                    employeeNames.addAll(extractEmployeeNames(childrenNode));
//                }
//            }
//        }
//        return employeeNames;
//    }

    public static List<String> extractNamesWithDCTechOrSecondaryDCs(File jsonFile, String techName) {
        List<String> names = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonFile);
            String dcChairName = "";
            for (JsonNode employeeNode : rootNode) {
                JsonNode dcTechNode = employeeNode.get("DCTech");
                JsonNode secondaryDCsNode = employeeNode.get("SecondaryDCs");
                if (dcTechNode != null && dcTechNode.asText().contains(techName)) {
                    names.add(employeeNode.get("EmployeeName").asText());
                    dcChairName = employeeNode.get("DCChairName").asText();
                } else if (secondaryDCsNode != null && secondaryDCsNode.asText().contains(techName)) {
                    names.add(employeeNode.get("EmployeeName").asText());
                }
            }
            names.add(dcChairName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
}
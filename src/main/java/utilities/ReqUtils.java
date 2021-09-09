package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import java.io.*;

 public class ReqUtils {

    private static final String ACCEPT = "Accept";
    private static final String APP_JSON = "application/json";

    private static String getRequest(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.header(ACCEPT, APP_JSON);
        Response resp = reqSpec.get();
        if (resp.statusCode() != 200) {
            System.out.println("Request Failed with Error code " + resp.statusCode());
        }
        return inputStreamReader(resp.asInputStream());
    }

    protected static boolean compareResponse(String file1Url, String file2Url) {
        ObjectMapper objMapper = new ObjectMapper();
        try {
            return objMapper.readTree(getRequest(file1Url))
                    .equals(objMapper.readTree(getRequest(file2Url)));
        } catch (IOException io) {
            System.out.println(io.getMessage());
            return false;
        }

    }

    private static String inputStreamReader(InputStream inputStream) {
        String response ="";
        String finalResponse ="";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));
        StringBuilder stringBuilder = new StringBuilder(finalResponse);
        try {
            while((response =bufferedReader.readLine())!=null){
            finalResponse = stringBuilder.append(response).toString();}
        } catch (IOException io) {
            System.out.println(io.getMessage());
            return null;
        }
        return finalResponse;
    }


}

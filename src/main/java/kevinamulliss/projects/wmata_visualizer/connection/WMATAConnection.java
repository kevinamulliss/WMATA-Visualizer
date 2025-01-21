package kevinamulliss.projects.wmata_visualizer.connection;

import kevinamulliss.projects.wmata_visualizer.request.WMATARequest;
import kevinamulliss.projects.wmata_visualizer.request.misc.ValidateRequest;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class WMATAConnection {
    private static final String API_KEY_KEY = "api_key";
    private static String API_KEY;
    private final static String API_KEY_PATH = "src/main/resources/api-key.txt";

    private static boolean connected = false;

    public static boolean initializeConnection() {
        Scanner apiKeyScanner = null;
        try {
            apiKeyScanner = new Scanner(new File(API_KEY_PATH));
            if (apiKeyScanner.hasNext()) {
                API_KEY = apiKeyScanner.next();
            }
        } catch (FileNotFoundException e) {
            System.out.println("failed to find find file " + API_KEY_PATH + " with error: " + e.getMessage());
            return false;
        } finally {
            if (apiKeyScanner != null) {
                apiKeyScanner.close();
            }
        }

        if (API_KEY == null || API_KEY.isEmpty()) {
            System.out.println("api key form file " + API_KEY_PATH + " was null or empty.");
            return false;
        } else {
            ValidateRequest validateRequest = new ValidateRequest();
            connected = request(validateRequest);
            return connected;
        }
    }

    private static boolean request(WMATARequest request) {
        try {
            HttpURLConnection connection = request.getConnection();
            connection.setRequestProperty(API_KEY_KEY, API_KEY);
            int status = connection.getResponseCode();
            return status >= 200 && status < 300;
        } catch (IOException e) {
            System.out.println("error");
            return false;
        }
    }
}

package kevinamulliss.projects.wmata_visualizer.connection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import kevinamulliss.projects.wmata_visualizer.model.wmata.*;
import kevinamulliss.projects.wmata_visualizer.request.railstation.PathBetweenStationsRequest;
import kevinamulliss.projects.wmata_visualizer.request.railstation.StationListRequest;
import kevinamulliss.projects.wmata_visualizer.request.trainpositions.TrainPositionRequest;
import kevinamulliss.projects.wmata_visualizer.request.WMATARequest;
import kevinamulliss.projects.wmata_visualizer.request.misc.ValidateRequest;
import kevinamulliss.projects.wmata_visualizer.request.railstation.LinesRequest;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WMATAConnection {
    private static final String API_KEY_KEY = "api_key";
    private static String API_KEY;
    private final static String API_KEY_PATH = "src/main/resources/api-key.txt";

    private static final Gson GSON = new Gson();

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

            connected = WMATAConnection.validateAPI();
            return connected;
        }
    }

    private static Optional<String> request(WMATARequest request) {
        HttpURLConnection connection = null;

        try {
            // add the api key authentication
            connection = request.getConnection();
            connection.setRequestProperty(API_KEY_KEY, API_KEY);
            // request for status code implicitly opens connection
            int status = connection.getResponseCode();

            if (status >= 200 && status < 300) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                return Optional.of(content.toString());
            } else {
                System.err.println("received failed http code: " + status);
            }
        } catch (IOException e) {
            System.err.println("encountered IOException while connecting to WMATA API: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return Optional.empty();
    }

    public static boolean validateAPI() {
        return WMATAConnection.request(new ValidateRequest()).isPresent();
    }

    public static Optional<List<TrainPosition>> getTrainPositions() {
        Optional<String> response = WMATAConnection.request(new TrainPositionRequest());
        if (response.isPresent()) {
            Type listType = new TypeToken<List<TrainPosition>>(){}.getType();
            JsonObject nestedObject = GSON.fromJson(response.get(), JsonObject.class);
            return Optional.of(GSON.fromJson(nestedObject.get("TrainPositions"), listType));
        }

        return Optional.empty();
    }

    public static Optional<List<Line>> getLines() {
        Optional<String> response = WMATAConnection.request(new LinesRequest());
        if (response.isPresent()) {
            Type listType = new TypeToken<List<Line>>(){}.getType();
            JsonObject nestedObject = GSON.fromJson(response.get(), JsonObject.class);
            return Optional.of(GSON.fromJson(nestedObject.get("Lines"), listType));
        }

        return Optional.empty();
    }

    // TODO: convert to enum
    public static Optional<List<MetroPathItem>> getMetroPath(String fromStation, String toStation) {
        Optional<String> response = WMATAConnection.request(new PathBetweenStationsRequest(fromStation, toStation));
        if (response.isPresent()) {
            Type listType = new TypeToken<List<MetroPathItem>>(){}.getType();
            JsonObject nestedObject = GSON.fromJson(response.get(), JsonObject.class);
            return Optional.of(GSON.fromJson(nestedObject.get("Path"), listType));
        }

        return Optional.empty();
    }

    public static Optional<List<Station>> getStations(LineCode lineCode) {
        Optional<String> response = WMATAConnection.request(new StationListRequest(lineCode));
        if (response.isPresent()) {
            Type listType = new TypeToken<List<Station>>(){}.getType();
            JsonObject nestedObject = GSON.fromJson(response.get(), JsonObject.class);
            return Optional.of(GSON.fromJson(nestedObject.get("Stations"), listType));
        }

        return Optional.empty();
    }
}

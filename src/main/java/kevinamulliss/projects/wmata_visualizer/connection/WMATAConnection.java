package kevinamulliss.projects.wmata_visualizer.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import kevinamulliss.projects.wmata_visualizer.json.LocalTimeSerializer;
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
import java.time.LocalTime;
import java.util.*;

public class WMATAConnection {
    private static final String API_KEY_KEY = "api_key";
    private static String API_KEY;
    private final static String API_KEY_PATH = "src/main/resources/api-key.txt";

    private static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(LocalTime.class, new LocalTimeSerializer())
            .create();

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

    public static Optional<String> buildRequest(WMATARequest request) {
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

    public static <T> Optional<List<T>> rawToObject(String raw, Class<T> objectClass) {
        JsonObject nestedObject = GSON.fromJson(raw, JsonObject.class);
        if (nestedObject.size() == 1) {
            Optional<String> optionalKey = nestedObject.keySet().stream().findAny();
            if (optionalKey.isPresent()) {
                JsonElement element = nestedObject.get(optionalKey.get());
                List<T> results;
                results = new ArrayList<T>();
                for (JsonElement jsonElement : element.getAsJsonArray()) {
                    results.add(GSON.fromJson(jsonElement, objectClass));
                }

                return Optional.of(results);
            }
        } else {
            return Optional.of(Collections.singletonList(GSON.fromJson(nestedObject, objectClass)));
        }

        return Optional.empty();
    }

    public static <T> Optional<List<T>> request(WMATARequest request, Class<T> objectClass) {
        Optional<String> result = WMATAConnection.buildRequest(request);
        return result.flatMap(s -> WMATAConnection.rawToObject(s, objectClass));
    }

    public static boolean validateAPI() {
        return WMATAConnection.buildRequest(new ValidateRequest()).isPresent();
    }
}

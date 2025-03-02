package kevinamulliss.projects.wmata_visualizer.request.railstation;

/**
 * Represents a request for information about the entrances of a Metrorail station. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330f">api</a> for details.
 */
public class StationEntrancesRequest extends RailStationRequest {
    // final path for this request
    private static final String PATH = "/jStationEntrances";
    private static final String LAT_KEY = "Lat=";
    private static final String LON_KEY = "Lon=";
    private static final String RADIUS_KEY = "Radius=";

    /**
     * Default constructor. Using this will build a request for all WMATA Metrorail entrances.
     */
    public StationEntrancesRequest() {
        super(PATH);
    }

    /**
     * Parameter constructor. Builds a request for entrances within a radius centered at lat/lon.
     * @param lat Latitude for center point of entrance search.
     * @param lon Longitude for center point of entrance search.
     * @param radius Radius to search within.
     */
    public StationEntrancesRequest(double lat, double lon, double radius) {
        super(PATH + "?" + LAT_KEY + lat + "&" + LON_KEY + lon + "&" + RADIUS_KEY + radius);
    }
}

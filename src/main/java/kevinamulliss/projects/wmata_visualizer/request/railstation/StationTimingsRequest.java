package kevinamulliss.projects.wmata_visualizer.request.railstation;

import kevinamulliss.projects.wmata_visualizer.model.wmata.StationCode;

/**
 * Represents a request for opening time, first train, and last train of a station. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3312">API</a>.
 */
public class StationTimingsRequest extends RailStationRequest {
    // final path for this request
    private static final String PATH = "/jStationTimes";
    private static final String STATION_CODE_KEY = "StationCode=";

    /**
     * Default constructor. Builds a request with no specified station and thus creates a request for all stations.
     */
    public StationTimingsRequest() {
        super(PATH);
    }

    /**
     * Parameter constructor. Builds a request for information on a specific WMATA Metrorail station.
     * @param stationCode Line Code to request station information for.
     */
    public StationTimingsRequest(StationCode stationCode) {
        super(PATH + "?" + STATION_CODE_KEY + stationCode.name());
    }
}

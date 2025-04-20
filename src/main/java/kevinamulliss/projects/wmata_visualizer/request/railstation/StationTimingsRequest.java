package kevinamulliss.projects.wmata_visualizer.request.railstation;

import kevinamulliss.projects.wmata_visualizer.model.wmata.StationCode;

/**
 * Represents a request for information about operating hours of a WMATA Metrorail station. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3312">api link</a>.
 */
public class StationTimingsRequest extends RailStationRequest {
    private static final String PATH = "/jStationTimes";
    private static final String STATION_CODE_KEY = "StationCode=";

    // constructor to build request for information about all stations
    public StationTimingsRequest() {
        super(PATH);
    }

    // constructor to build request for information about one station
    public StationTimingsRequest(StationCode stationCode) {
        super(PATH + "?" + STATION_CODE_KEY + stationCode.name());
    }
}
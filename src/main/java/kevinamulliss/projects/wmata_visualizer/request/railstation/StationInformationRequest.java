package kevinamulliss.projects.wmata_visualizer.request.railstation;

import kevinamulliss.projects.wmata_visualizer.model.wmata.StationCode;

/**
 * Represents a request for information about a specific metro station. See api <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3310">api link</a>.
 */
public class StationInformationRequest extends RailStationRequest {
    // final path for this request
    private static final String PATH = "/jStationInfo";
    private static final String STATION_CODE_KEY = "StationCode=";

    /**
     * Parameter constructor. Builds a request with no specified line and thus creates a request for all stations.
     */
    public StationInformationRequest(StationCode stationCode) {
        super(PATH + "?" + STATION_CODE_KEY + stationCode.name());
    }
}

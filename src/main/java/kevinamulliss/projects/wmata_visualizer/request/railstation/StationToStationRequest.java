package kevinamulliss.projects.wmata_visualizer.request.railstation;

import kevinamulliss.projects.wmata_visualizer.model.wmata.StationCode;

/**
 * Represents a request for information about price and distance to travel between two WMATA Metrorail stations. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3313">api link</a>.
 */
public class StationToStationRequest extends RailStationRequest {
    // final path for request
    private static final String PATH = "/jSrcStationToDstStationInfo";
    private static final String FROM_KEY = "FromStationCode=";
    private static final String TO_KEY = "ToStationCode=";

    // constructor to build request for all stations
    public StationToStationRequest() {
        super(PATH);
    }

    // constructor to build request for information between two stations
    public StationToStationRequest(StationCode from, StationCode to) {
        super(PATH + "?" + FROM_KEY + from.name() + "&" + TO_KEY + to.name());
    }
}

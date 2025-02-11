package kevinamulliss.projects.wmata_visualizer.request.railstation;

import kevinamulliss.projects.wmata_visualizer.model.wmata.LineCode;

/**
 * Represents a request for a list of stations corresponding to a line. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3311">API</a>.
 */
public class StationListRequest extends RailStationRequest {
    // final path for this request
    private static final String PATH = "/jStations";
    private static final String LINE_CODE_KEY = "LineCode=";

    /**
     * Default constructor. Builds a request with no specified line and thus creates a request for all stations.
     */
    public StationListRequest() {
        super(PATH);
    }

    /**
     * Parameter constructor. Builds a request for information on all WMATA stations for a specific line.
     * @param lineCode Line Code to request station information for.
     */
    public StationListRequest(LineCode lineCode) {
        super(PATH + "?" + LINE_CODE_KEY + lineCode.name());
    }
}

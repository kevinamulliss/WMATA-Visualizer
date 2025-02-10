package kevinamulliss.projects.wmata_visualizer.request.railstation;

import kevinamulliss.projects.wmata_visualizer.model.wmata.StationCode;

/**
 * Represents a request for the path between two WMATA stations. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330e">api link</a>.
 */
public class PathBetweenStationsRequest extends RailStationRequest {
    // final path for this request
    private static final String PATH = "/jPath";
    private static final String FROM_STATION_KEY = "FromStationCode=";
    private static final String TO_STATION_KEY = "ToStationCode=";

    /**
     * Parameter constructor. Builds a request for the path of stations between two stations.
     * @param fromStationCode Station to build path from.
     * @param toStationCode Station to build path to.
     */
    public PathBetweenStationsRequest(StationCode fromStationCode, StationCode toStationCode) {
        super(PATH + "?" + FROM_STATION_KEY + fromStationCode.name() + "&" + TO_STATION_KEY + toStationCode.name());
    }
}

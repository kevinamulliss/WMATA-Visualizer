package kevinamulliss.projects.wmata_visualizer.request.railstation;

import kevinamulliss.projects.wmata_visualizer.model.wmata.StationCode;

/**
 * Represents a request for information about a station's parking. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330d">api link</a> for more detail.
 */
public class ParkingInformationRequest extends RailStationRequest{
    private static final String PATH = "/jStationParking";
    private static final String STATION_CODE_KEY = "StationCode=";

    public ParkingInformationRequest() {
        super(PATH);
    }

    public ParkingInformationRequest(StationCode stationCode) {
        super(PATH + "?" + STATION_CODE_KEY + stationCode.name());
    }
}

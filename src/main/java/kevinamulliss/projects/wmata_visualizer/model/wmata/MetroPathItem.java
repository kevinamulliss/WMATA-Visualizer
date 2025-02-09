package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Model for representing one element in a path between two stations. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330e">WMATA API</a>.
 * Variable descriptions come from WMATA API.
 */
public class MetroPathItem {
    // Distance in feet to the previous station in the list.
    @SerializedName("DistanceToPrev")
    private int distanceToPrevious;
    // Two-letter abbreviation for the line (e.g.: RD, BL, YL, OR, GR, or SV) this station's platform is on.
    @SerializedName("LineCode")
    private LineCode lineCode;
    // Ordered sequence number.
    @SerializedName("SeqNum")
    private int sequenceNumber;
    // TODO: convert to enum
    // Station code for this station. Use this value in other rail-related APIs to retrieve data about a station.
    @SerializedName("StationCode")
    private String stationCode;
    // Full name for this station, as shown on the WMATA website.
    @SerializedName("StationName")
    private String stationName;

    public int getDistanceToPrevious() {
        return distanceToPrevious;
    }

    public void setDistanceToPrevious(int distanceToPrevious) {
        this.distanceToPrevious = distanceToPrevious;
    }

    public LineCode getLineCode() {
        return lineCode;
    }

    public void setLineCode(LineCode lineCode) {
        this.lineCode = lineCode;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}

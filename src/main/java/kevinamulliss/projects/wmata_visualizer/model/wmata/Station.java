package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Nullable;

/**
 * Model for representing a Station as defined by the WMATA API. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3311">link</a>.
 * Variable descriptions come from WMATA API.
 */
public class Station {
    @SerializedName("Address")
    private Address address;
    // TODO: replace with enum
    @SerializedName("Code")
    private String stationCode;
    @SerializedName("Lat")
    private double latitude;
    // Two-letter abbreviation for one line (e.g.: RD, BL, YL, OR, GR, or SV) served by this station. If the station
    // has an additional platform, the lines served by the other platform are listed in the LineCodeX values for the
    // record associated with the StationCode found in StationTogether1.
    @SerializedName("LineCode1")
    private LineCode lineCode1;
    // Additional line served by this station, if applicable.
    @SerializedName("LineCode2")
    private LineCode lineCode2;
    // Additional line served by this station, if applicable.
    @SerializedName("LineCode3")
    private LineCode lineCode3;
    // Additional line served by this station, if applicable.
    @SerializedName("LineCode4")
    private LineCode lineCode4;
    @SerializedName("Lon")
    private double longitude;
    @SerializedName("Name")
    private String name;
    // TODO: replace with enum
    // For stations with multiple platforms (e.g.: Gallery Place, Fort Totten, L'Enfant Plaza, and Metro Center), the
    // additional StationCode will be listed here.
    @SerializedName("StationTogether1")
    private String stationTogether1;
    // TODO: replace with enum
    // Similar in function to StationTogether2. Currently not in use.
    @SerializedName("StationTogether2")
    private String stationTogether2;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public LineCode getLineCode1() {
        return lineCode1;
    }

    public void setLineCode1(LineCode lineCode1) {
        this.lineCode1 = lineCode1;
    }

    @Nullable
    public LineCode getLineCode2() {
        return lineCode2;
    }

    public void setLineCode2(LineCode lineCode2) {
        this.lineCode2 = lineCode2;
    }

    @Nullable
    public LineCode getLineCode3() {
        return lineCode3;
    }

    public void setLineCode3(LineCode lineCode3) {
        this.lineCode3 = lineCode3;
    }

    @Nullable
    public LineCode getLineCode4() {
        return lineCode4;
    }

    public void setLineCode4(LineCode lineCode4) {
        this.lineCode4 = lineCode4;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Nullable
    public String getStationTogether1() {
        return stationTogether1;
    }

    public void setStationTogether1(String stationTogether1) {
        this.stationTogether1 = stationTogether1;
    }

    @Nullable
    public String getStationTogether2() {
        return stationTogether2;
    }

    public void setStationTogether2(String stationTogether2) {
        this.stationTogether2 = stationTogether2;
    }
}

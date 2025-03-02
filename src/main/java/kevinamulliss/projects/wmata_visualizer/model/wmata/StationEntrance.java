package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;
import kevinamulliss.projects.wmata_visualizer.util.Display;

/**
 * Model for representing a Station Entrance as defined by WMATA API. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330f">api link</a>.
 * Variable descriptions come from WMATA API.
 */
public class StationEntrance {
    // Additional information for the entrance, if available. Currently available data usually shows the same value as
    // the Name element.
    @SerializedName("Description")
    private String description;
    // Listed by WMATA API as deprecated. Included here in case old data ever returns it.
    @Deprecated
    @SerializedName("ID")
    private String id;
    @SerializedName("Lat")
    private double lat;
    @SerializedName("Lon")
    private double lon;
    // Name of the entrance (usually the station name and nearest intersection).
    @SerializedName("Name")
    private String name;
    // The station code associated with this entrance. Use this value in other rail-related APIs to retrieve data about
    // a station.
    @SerializedName("StationCode1")
    public StationCode stationCode1;
    // For stations containing multiple platforms (e.g.: Gallery Place, Fort Totten, L'Enfant Plaza, and Metro Center),
    // the other station code.
    @SerializedName("StationCode2")
    public StationCode stationCode2;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StationCode getStationCode1() {
        return stationCode1;
    }

    public void setStationCode1(StationCode stationCode1) {
        this.stationCode1 = stationCode1;
    }

    public StationCode getStationCode2() {
        return stationCode2;
    }

    public void setStationCode2(StationCode stationCode2) {
        this.stationCode2 = stationCode2;
    }

    /**
     * Overridden toString method to pretty display a station entrance.
     * @return Formatted string output representing the station entrance.
     */
    @Override
    public String toString() {
        String output = this.name + " entrance at ";
        //
        if (this.stationCode2 != null) {
            output += Display.aggregateStationLineOutputs(this.stationCode1, this.stationCode2);
        } else {
            output += Display.buildPrettyStationLineOutput(this.stationCode1.getDisplayName(), this.stationCode1.getLineCodes());
        }

        return output;
    }
}

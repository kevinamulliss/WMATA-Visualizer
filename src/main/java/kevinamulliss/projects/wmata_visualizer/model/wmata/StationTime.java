package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;
import kevinamulliss.projects.wmata_visualizer.util.Display;

import java.util.Objects;

/**
 * Model for representing the StationTime object defined by the WMATA API <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330c">here</a>.
 * Variable descriptions come from WMATA API.
 */
public class StationTime {
    // Station code for this station. Use this value in other rail-related APIs to retrieve data about a station.
    @SerializedName("Code")
    private StationCode code;
    // Full name of the station.
    @SerializedName("StationName")
    private String stationName;
    // Container elements containing timing information based on day of the week.
    @SerializedName("Monday")
    private StationDay monday;
    @SerializedName("Tuesday")
    private StationDay tuesday;
    @SerializedName("Wednesday")
    private StationDay wednesday;
    @SerializedName("Thursday")
    private StationDay thursday;
    @SerializedName("Friday")
    private StationDay friday;
    @SerializedName("Saturday")
    private StationDay saturday;
    @SerializedName("Sunday")
    private StationDay sunday;

    public StationCode getCode() {
        return code;
    }

    public void setCode(StationCode code) {
        this.code = code;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public StationDay getMonday() {
        return monday;
    }

    public void setMonday(StationDay monday) {
        this.monday = monday;
    }

    public StationDay getTuesday() {
        return tuesday;
    }

    public void setTuesday(StationDay tuesday) {
        this.tuesday = tuesday;
    }

    public StationDay getWednesday() {
        return wednesday;
    }

    public void setWednesday(StationDay wednesday) {
        this.wednesday = wednesday;
    }

    public StationDay getThursday() {
        return thursday;
    }

    public void setThursday(StationDay thursday) {
        this.thursday = thursday;
    }

    public StationDay getFriday() {
        return friday;
    }

    public void setFriday(StationDay friday) {
        this.friday = friday;
    }

    public StationDay getSaturday() {
        return saturday;
    }

    public void setSaturday(StationDay saturday) {
        this.saturday = saturday;
    }

    public StationDay getSunday() {
        return sunday;
    }

    public void setSunday(StationDay sunday) {
        this.sunday = sunday;
    }

    @Override
    public String toString() {
        return Display.buildPrettyStationLineOutput(this.code)
                + "\n\tMonday:\t" + this.monday.toString()
                + "\n\tTuesday:\t" + this.tuesday.toString()
                + "\n\tWednesday:\t" + this.wednesday.toString()
                + "\n\tThursday:\t" + this.thursday.toString()
                + "\n\tFriday:\t" + this.friday.toString()
                + "\n\tSaturday:\t" + this.saturday.toString()
                + "\n\tSunday:\t" + this.sunday.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StationTime that = (StationTime) o;
        return code == that.code && Objects.equals(stationName, that.stationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, stationName);
    }
}

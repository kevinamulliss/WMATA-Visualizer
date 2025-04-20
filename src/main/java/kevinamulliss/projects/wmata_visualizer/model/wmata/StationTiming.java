package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Model representing information about first/last train schedule and opening hours for WMATA Metrorail stations. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3312">api link</a>.
 * Descriptions come directly from WMATA api.
 */
public class StationTiming {

    // Station code for this station. Use this value in other rail-related APIs to retrieve data about a station.
    @SerializedName("Code")
    private StationCode code;
    // Station code for this station. Use this value in other rail-related APIs to retrieve data about a station.
    @SerializedName("StationName")
    private String stationName;
    // Container elements containing timing information based on day of the week.
    @SerializedName("Monday")
    private StationHours monday;
    @SerializedName("Tuesday")
    private StationHours tuesday;
    @SerializedName("Wednesday")
    private StationHours wednesday;
    @SerializedName("Thursday")
    private StationHours thursday;
    @SerializedName("Friday")
    private StationHours friday;
    @SerializedName("Saturday")
    private StationHours saturday;
    @SerializedName("Sunday")
    private StationHours sunday;

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

    public StationHours getMonday() {
        return monday;
    }

    public void setMonday(StationHours monday) {
        this.monday = monday;
    }

    public StationHours getTuesday() {
        return tuesday;
    }

    public void setTuesday(StationHours tuesday) {
        this.tuesday = tuesday;
    }

    public StationHours getWednesday() {
        return wednesday;
    }

    public void setWednesday(StationHours wednesday) {
        this.wednesday = wednesday;
    }

    public StationHours getThursday() {
        return thursday;
    }

    public void setThursday(StationHours thursday) {
        this.thursday = thursday;
    }

    public StationHours getFriday() {
        return friday;
    }

    public void setFriday(StationHours friday) {
        this.friday = friday;
    }

    public StationHours getSaturday() {
        return saturday;
    }

    public void setSaturday(StationHours saturday) {
        this.saturday = saturday;
    }

    public StationHours getSunday() {
        return sunday;
    }

    public void setSunday(StationHours sunday) {
        this.sunday = sunday;
    }

    @Override
    public String toString() {
        // as of coding (04/20/25) all stations have the same m-th hours
        String result = this.code.toString() + "\n";

        // if monday through thursday are the same, display them as one
        if (this.monday.equals(this.tuesday) && this.tuesday.equals(this.wednesday) && this.wednesday.equals(this.thursday)) {
            result += "Monday through Thursday hours: ";
            result += this.monday.toString();
        } else {
            result += "\nMonday hours: ";
            result += this.monday.toString();
            result += "\nTuesday hours: ";
            result += this.tuesday.toString();
            result += "\nWednesday hours: ";
            result += this.wednesday.toString();
            result += "\nThursday hours: ";
            result += this.thursday.toString();
        }

        result += "\nFriday hours: ";
        result += this.friday.toString();
        result += "\nSaturday hours: ";
        result += this.saturday.toString();
        result += "\nSunday hours: ";
        result += this.sunday.toString();

        return result;
    }
}

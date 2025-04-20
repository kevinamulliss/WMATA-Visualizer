package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Model representing information about parking available at Metrorail stations. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330d">api link</a>.
 * Descriptions come directly from WMATA api.
 */
public class StationParking {
    // Station code. Useful when returning parking information for all stations. Use this value in other rail-related
    // APIs to retrieve data about a station.
    @SerializedName("Code")
    private StationCode code;
    // When not NULL, provides additional parking resources such as nearby lots.
    @SerializedName("Notes")
    private String notes;
    // Structure describing all-day parking options.
    @SerializedName("AllDayParking")
    private AllDayParking allDayParking;
    // Structure describing short-term parking options.
    @SerializedName("ShortTermParking")
    private ShortTermParking shortTermParking;

    public StationCode getCode() {
        return code;
    }

    public void setCode(StationCode code) {
        this.code = code;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public AllDayParking getAllDayParking() {
        return allDayParking;
    }

    public void setAllDayParking(AllDayParking allDayParking) {
        this.allDayParking = allDayParking;
    }

    public ShortTermParking getShortTermParking() {
        return shortTermParking;
    }

    public void setShortTermParking(ShortTermParking shortTermParking) {
        this.shortTermParking = shortTermParking;
    }

    @Override
    public String toString() {
        return this.code + ":\n\t" + this.allDayParking.toString() + "\n\t" + this.shortTermParking.toString();
    }
}

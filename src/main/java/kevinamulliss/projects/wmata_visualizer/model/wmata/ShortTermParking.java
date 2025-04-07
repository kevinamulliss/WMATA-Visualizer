package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Model for representing information about short term parking at a Metro station. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330d">api link</a> for details.
 * Variable description comes from WMATA api.
 */
public class ShortTermParking {
    // Number of short-term parking spots available at a station (parking meters).
    @SerializedName("TotalCount")
    private int totalCount;
    // Misc. information relating to short-term parking. NULL when no short-term spots are available.
    @SerializedName("Notes")
    private String notes;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        String output = this.totalCount + " short term parking spots";
        if (this.notes != null && !this.notes.isEmpty()) {
            output += ": " + this.notes;
        }
        return output;
    }
}

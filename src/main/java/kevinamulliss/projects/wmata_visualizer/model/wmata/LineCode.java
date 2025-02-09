package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for representing WMATA Metro lines used in various requests.
 */
public enum LineCode {
    @SerializedName("RD")
    RD("Red Line"),
    @SerializedName("BL")
    BL("Blue Line"),
    @SerializedName("YL")
    YL("Yellow Line"),
    @SerializedName("OR")
    OR("Orange Line"),
    @SerializedName("GR")
    GR("Green Line"),
    @SerializedName("SV")
    SV("Silver Line");

    // formatted name
    private final String lineCode;

    /**
     * Enum constructor for inputted formatted name.
     * @param lineCode Formatted name of line.
     */
    LineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    /**
     * Overridden toString() method for outputting formatted name.
     * @return Formatted name.
     */
    @Override
    public String toString() {
        return this.lineCode;
    }
}

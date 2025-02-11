package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for representing WMATA Metro lines used in various requests.
 */
public enum LineCode {
    @SerializedName("RD")
    RD("Red"),
    @SerializedName("BL")
    BL("Blue"),
    @SerializedName("YL")
    YL("Yellow"),
    @SerializedName("OR")
    OR("Orange"),
    @SerializedName("GR")
    GR("Green"),
    @SerializedName("SV")
    SV("Silver");

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
        return this.lineCode + " Line";
    }
}

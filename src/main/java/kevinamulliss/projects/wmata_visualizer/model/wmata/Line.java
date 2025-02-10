package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Model for representing the Line object defined by the WMATA API <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330c">here</a>.
 * Variable descriptions come from WMATA API.
 */
public class Line {
    // Full name of line color.
    @SerializedName("DisplayName")
    private String displayName;
    // End station code. For example, will be E10 (Greenbelt) for the Green Line, B11 (Glenmont) for the Red Line, etc.
    // Use this value in other rail-related APIs to retrieve data about a station.
    @SerializedName("EndStationCode")
    private StationCode endStationCode;
    // Intermediate terminal station code. During normal service, some trains on some lines might end their trip prior
    // to the StartStationCode or EndStationCode. A good example is on the Red Line where some trains stop at A11
    // (Grosvenor) or B08 (Silver Spring). Empty string if not defined.
    @SerializedName("InternalDestination1")
    private StationCode internalDestinationCode1;
    // Similar to InternalDestination1.
    @SerializedName("InternalDestination2")
    private StationCode internalDestinationCode2;
    // 	Two-letter abbreviation for the line (e.g.: RD, BL, YL, OR, GR, or SV).
    @SerializedName("LineCode")
    private LineCode lineCode;
    // Start station code. For example, will be F11 (Branch Avenue) for the Green Line, A15 (Shady Grove) for the Red
    // Line, etc. Use this value in other rail-related APIs to retrieve data about a station.
    @SerializedName("StartStationCode")
    private StationCode startStationCode;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public StationCode getEndStationCode() {
        return endStationCode;
    }

    public void setEndStationCode(StationCode endStationCode) {
        this.endStationCode = endStationCode;
    }

    public StationCode getInternalDestinationCode1() {
        return internalDestinationCode1;
    }

    public void setInternalDestinationCode1(StationCode internalDestinationCode1) {
        this.internalDestinationCode1 = internalDestinationCode1;
    }

    public StationCode getInternalDestinationCode2() {
        return internalDestinationCode2;
    }

    public void setInternalDestinationCode2(StationCode internalDestinationCode2) {
        this.internalDestinationCode2 = internalDestinationCode2;
    }

    public LineCode getLineCode() {
        return lineCode;
    }

    public void setLineCode(LineCode lineCode) {
        this.lineCode = lineCode;
    }

    public StationCode getStartStationCode() {
        return startStationCode;
    }

    public void setStartStationCode(StationCode startStationCode) {
        this.startStationCode = startStationCode;
    }

    /**
     * Overridden toString method for outputting this line.
     * @return The display name of this line.
     */
    @Override
    public String toString() {
        return this.displayName;
    }

    /**
     * Overridden equals method for determine of two lines are the same.
     * @param obj The object to check for equality to.
     * @return Whether the inputted object is equal to this line, which is only true if their line codes match.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Line line) {
            return this.lineCode.equals(line.getLineCode());
        }

        return false;
    }
}

package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for representing the State for an address.
 * WMATA does not consider this an enum but given that there are only three options it seems appropriate.
 */
public enum State {
    @SerializedName("DC")
    DC("District of Columbia"),
    @SerializedName("MD")
    MD("Maryland"),
    @SerializedName("VA")
    VA("Virginia");

    // formatted name
    private final String state;

    /**
     * Enum constructor for inputted formatted name.
     * @param state Formatted name of state.
     */
    State(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return state;
    }
}

package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for representing WMATA API Service Type.
 * Descriptions come from WMATA API page.
 */
public enum ServiceType {
    // value declarations

    // This is a non-revenue train with no passengers on board. Note that this designation of NoPassengers does not
    // necessarily correlate with PIDS "No Passengers". As of 08/22/2016, this functionality has been reinstated to
    // include all non-revenue vehicles, with minor exceptions.
    @SerializedName("NoPassengers")
    N0_PASSENGERS("No Passengers"),
    // This is a normal revenue service train.
    @SerializedName("Normal")
    NORMAL("Normal"),
    // This is a special revenue service train with an unspecified line and destination. This is more prevalent during
    // scheduled track work.
    @SerializedName("Special")
    SPECIAL("Special"),
    // This often denotes cases with unknown data or work vehicles.
    @SerializedName("Unknown")
    UNKNOWN("Unknown");

    // string for mapping enum to formatted text
    private final String serviceType;

    /**
     * Enum constructor for inputting formatted text.
     * @param serviceType Formatted text to output for this enum.
     */
    ServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * Overridden toString which outputs formatted name of enum.
     * @return Formatted version of enum value.
     */
    @Override
    public String toString() {
        return this.serviceType;
    }
}

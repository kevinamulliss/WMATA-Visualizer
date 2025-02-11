package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Model for representing an address as defined within the WMATA API. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3311">link</a>.
 * Variable descriptions come from WMATA API.
 */
public class Address {
    @SerializedName("City")
    private String city;
    @SerializedName("State")
    private State state;
    @SerializedName("Street")
    private String street;
    @SerializedName("Zip")
    private short zipCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public short getZipCode() {
        return zipCode;
    }

    public void setZipCode(short zipCode) {
        this.zipCode = zipCode;
    }
}

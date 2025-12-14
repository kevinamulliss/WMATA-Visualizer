package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;
import kevinamulliss.projects.wmata_visualizer.util.Display;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Model for representing the FirstTrains and LastTrains objects defined by the WMATA API <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330c">here</a>.
 * Variable descriptions come from WMATA API.
 */
public class StationBookmarkTime {
    // First or last train leaves the station at this time. Format is HH:mm.
    @SerializedName("Time")
    private LocalTime time;
    // Station code for the train's destination.
    // Use this value in other rail-related APIs to retrieve data about a station.
    @SerializedName("DestinationStation")
    private StationCode destinationStation;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public StationCode getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(StationCode destinationStation) {
        this.destinationStation = destinationStation;
    }

    @Override
    public String toString() {
        return "Departing at " + Display.localTimeToTwelveHourTIme(this.time) + " towards " + Display.buildPrettyStationLineOutput(this.destinationStation);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StationBookmarkTime that = (StationBookmarkTime) o;
        return Objects.equals(time, that.time) && destinationStation == that.destinationStation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, destinationStation);
    }
}

package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Model for representing timing information for first or last train at a station. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3312">api link</a>.
 */
public class TrainTiming {
    // First/last train leaves the station at this time. Format is HH:mm. Note that when the time is AM, it signifies the next
    // day. For example, a value of 02:30 under a Saturday element means the last train leaves on Sunday at 2:30 AM.
    @SerializedName("Time")
    private String time;
    // Station code for the train's destination. Use this value in other rail-related APIs to get data about a station.
    @SerializedName("DestinationStation")
    private StationCode destinationStation;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public StationCode getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(StationCode destinationStation) {
        this.destinationStation = destinationStation;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TrainTiming t) {
            return this.time.equals(t.time) && this.destinationStation.equals(t.destinationStation);
        }

        return false;
    }

    @Override
    public String toString() {
        return this.time + " towards " + this.destinationStation.toString();
    }
}

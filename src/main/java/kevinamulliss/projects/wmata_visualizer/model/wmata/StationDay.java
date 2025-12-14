package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;
import kevinamulliss.projects.wmata_visualizer.util.Display;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Model for representing the station day objects defined by the WMATA API <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330c">here</a>.
 * Variable descriptions come from WMATA API.
 */
public class StationDay {
    // Station opening time. Format is HH:mm.
    @SerializedName("OpeningTime")
    LocalTime openingTime;
    // Structure containing first train information.
    @SerializedName("FirstTrains")
    List<StationBookmarkTime> firstTrains;
    // Structure containing last train information.
    @SerializedName("LastTrains")
    List<StationBookmarkTime> lastTrains;

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = LocalTime.parse(openingTime);
    }

    public List<StationBookmarkTime> getFirstTrains() {
        return firstTrains;
    }

    public void setFirstTrains(List<StationBookmarkTime> firstTrains) {
        this.firstTrains = firstTrains;
    }

    public List<StationBookmarkTime> getLastTrains() {
        return lastTrains;
    }

    public void setLastTrains(List<StationBookmarkTime> lastTrains) {
        this.lastTrains = lastTrains;
    }

    @Override public String toString() {
        return "Opens at " + Display.localTimeToTwelveHourTIme(this.openingTime) + " with"
                + "\n\t\tFirst Trains:\t" + this.firstTrains.stream().map(Objects::toString).collect(Collectors.joining(", "))
                + "\n\t\tLast Trains:\t" + this.lastTrains.stream().map(Objects::toString).collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StationDay that = (StationDay) o;
        return Objects.equals(openingTime, that.openingTime) && Objects.equals(firstTrains, that.firstTrains) && Objects.equals(lastTrains, that.lastTrains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(openingTime, firstTrains, lastTrains);
    }
}

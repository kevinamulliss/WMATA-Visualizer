package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Model for representing the open hours of a single WMATA Metrorail station. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe3312">api link</a>.
 */
public class StationHours {
    // Station opening time. Format is HH:mm.
    @SerializedName("OpeningTime")
    private String openingTime;
    // Structure containing first train information.
    @SerializedName("FirstTrains")
    private List<TrainTiming> firstTrains;
    // Structure containing last train information.
    @SerializedName("LastTrains")
    private List<TrainTiming> lastTrains;

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public List<TrainTiming> getFirstTrains() {
        return firstTrains;
    }

    public void setFirstTrains(List<TrainTiming> firstTrains) {
        this.firstTrains = firstTrains;
    }

    public List<TrainTiming> getLastTrains() {
        return lastTrains;
    }

    public void setLastTrains(List<TrainTiming> lastTrains) {
        this.lastTrains = lastTrains;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("opens at " + this.openingTime);
        result.append("\n\tFirst trains:");
        for (TrainTiming t : firstTrains) {
            result.append("\n\t\t").append(t.toString());
        }

        result.append("\n\tLast trains:");
        for (TrainTiming t : lastTrains) {
            result.append("\n\t\t").append(t.toString());
        }

        return result.toString();
    }

    /**
     * Determine if two scheduled station times are exactly the same.
     * @param o A station time to compare to.
     * @return Whether the inputted station has the same scheduled station hours.
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof StationHours h) {
            if (!this.compareTwoTimes(this.firstTrains, h.firstTrains)) {
                return false;
            }
            return this.compareTwoTimes(this.lastTrains, h.lastTrains);
        }

        return false;
    }

    /**
     * Helper method to determine whether two train timing lists are equal.
     * WMATA API returns two lists to determine train times per station: one containing information about first trains,
     * one about last trains. Each list contains the timing for the one/two directions of trains.
     * Given two different train timings, the first/last lists in each must contain exactly the same elements.
     * @param a One of two train timing lists.
     * @param b The other of two train timing lists.
     * @return Boolean representing whether each list are exactly the same in size and elements.
     */
    private boolean compareTwoTimes(List<TrainTiming> a, List<TrainTiming> b) {
        if (a.size() != b.size()) {
            return false;
        }
        // each station is only represented as one platform. this means that the maximum number of values could only be
        // six, one train in each direction for three services. we explicitly check this as containsAll can have poor
        // n^2 runtime. in practice, this should never happen, but the check makes IDEs and QA testers happy!
        if (a.size() > 6) {
            return false;
        } else {
            return a.containsAll(b);
        }
    }
}

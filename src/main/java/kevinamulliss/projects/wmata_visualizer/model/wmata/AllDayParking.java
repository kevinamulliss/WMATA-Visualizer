package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;
import kevinamulliss.projects.wmata_visualizer.util.Display;

/**
 * Model for representing information about all day parking at a Metro station. See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330d">api link</a> for details.
 * Variable description comes from WMATA api.
 */
public class AllDayParking {
    // Number of all-day parking spots available at a station.
    @SerializedName("TotalCount")
    private int totalCount;
    // All-day cost per day (weekday) for Metro riders. NULL when no all-day spots are available. For most stations,
    // this value is identical to the NonRiderCost.
    // For cases where the NonRiderCost is different, the lower cost per day requires a valid rail trip using a
    // SmarTrip® card originating from a station other than the one where the patron parked. To receive this lower rate,
    // patrons must pay for their parking with the same SmarTrip® card used to enter/exit Metrorail, and must exit the
    // parking lot within two hours of exiting Metrorail.
    @SerializedName("RiderCost")
    private double riderCost;
    // All-day cost per day (weekday) for non-Metro riders. NULL when no all-day spots are available.
    @SerializedName("NonRiderCost")
    private double nonRiderCost;
    // Similar to RiderCost, except denoting Saturday prices.
    @SerializedName("SaturdayRiderCost")
    private double saturdayRiderCost;
    // Similar to NonRiderCost, except denoting Saturday prices.
    @SerializedName("SaturdayNonRiderCost")
    private double nonRiderSaturdayCost;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public double getRiderCost() {
        return riderCost;
    }

    public void setRiderCost(double riderCost) {
        this.riderCost = riderCost;
    }

    public double getNonRiderCost() {
        return nonRiderCost;
    }

    public void setNonRiderCost(double nonRiderCost) {
        this.nonRiderCost = nonRiderCost;
    }

    public double getSaturdayRiderCost() {
        return saturdayRiderCost;
    }

    public void setSaturdayRiderCost(double saturdayRiderCost) {
        this.saturdayRiderCost = saturdayRiderCost;
    }

    public double getNonRiderSaturdayCost() {
        return nonRiderSaturdayCost;
    }

    public void setNonRiderSaturdayCost(double nonRiderSaturdayCost) {
        this.nonRiderSaturdayCost = nonRiderSaturdayCost;
    }

    /**
     * Private helper method to display a double amount of dollars as USD currency or free if it's 0.
     * @param dollars Double amount of dollars, including fractional.
     * @return Inputted value formatted as USD or "free" if it's 0.
     */
    private String currencyValueOrFree(double dollars) {
        if (dollars == 0) {
            return "free";
        } else {
            return Display.formatDoubleAsCurrency(dollars);
        }
    }

    @Override
    public String toString() {
        if (totalCount == 0) {
            return "no all day parking";
        } else if (riderCost == nonRiderCost && nonRiderCost == saturdayRiderCost && saturdayRiderCost == nonRiderSaturdayCost) {
            return totalCount + "all day parking spots for " + currencyValueOrFree(riderCost) + " per day, Monday through Saturday";
        } else {
            String output = totalCount + " all day parking spots, ";
            if (riderCost == nonRiderCost) {
                output += this.currencyValueOrFree(riderCost) + " on weekdays ";
            } else {
                output += this.currencyValueOrFree(riderCost) + " for riders and ";
                output += this.currencyValueOrFree(nonRiderCost) + " for non riders on weekdays ";
            }
            output += "and ";
            if (saturdayRiderCost == nonRiderSaturdayCost) {
                output += this.currencyValueOrFree(saturdayRiderCost) + " on Saturdays";
            } else {
                output += this.currencyValueOrFree(saturdayRiderCost) + " for riders and ";
                output += this.currencyValueOrFree(nonRiderSaturdayCost) + " for non riders on Saturdays";
            }

            return output;
        }
    }
}

package kevinamulliss.projects.wmata_visualizer.util;

import kevinamulliss.projects.wmata_visualizer.model.wmata.LineCode;
import kevinamulliss.projects.wmata_visualizer.model.wmata.Station;
import kevinamulliss.projects.wmata_visualizer.model.wmata.StationCode;

import javax.annotation.Nullable;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for complex operations for display operations.
 */
public class Display {
    private static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    private static final DateTimeFormatter TWELVE_HOUR_TIME = DateTimeFormatter.ofPattern("h:mm a");
    @Nullable
    public static String aggregateStationLineOutputs(StationCode stationCode1, StationCode stationCode2) {
        if (!stationCode1.getDisplayName().equals(stationCode2.getDisplayName())) {
            return null;
        }
        LineCode[] lineCodes = new LineCode[stationCode1.getLineCodes().length + stationCode2.getLineCodes().length];
        System.arraycopy(stationCode1.getLineCodes(), 0, lineCodes, 0, stationCode1.getLineCodes().length);
        System.arraycopy(stationCode2.getLineCodes(), 0, lineCodes, stationCode1.getLineCodes().length, stationCode2.getLineCodes().length);

        return buildPrettyStationLineOutput(stationCode1.getDisplayName(), lineCodes) + " (" + stationCode1.name() + "/" + stationCode2.name() + ")";
    }

    public static String buildPrettyStationLineOutput(StationCode stationCode) {
        return buildPrettyStationLineOutput(stationCode.getDisplayName(), stationCode.getLineCodes());
    }

    public static String buildPrettyStationLineOutput(String stationName, LineCode[] lineCodes) {
        StringBuilder result = new StringBuilder(stationName + " Station on the ");
        result.append(lineCodes[0].getLineCodeName());
        if (lineCodes.length > 2) {
            result.append(',');
        }
        if (lineCodes.length > 1) {
            result.append(' ');
            for (int i = 1; i < lineCodes.length - 1; i++) {
                result.append(lineCodes[i].getLineCodeName());
                result.append(", ");
            }
            result.append("and ").append(lineCodes[lineCodes.length - 1].getLineCodeName());
            result.append(" Lines");
        } else {
            result.append(" Line");
        }

        return result.toString();
    }

    /**
     * Utility method to format a double dollar amount as a String. 0 translates to free.
     * @param dollars The dollars (including fractional).
     * @return The dollar value formatted as USD currency. If conversion fails returns the direct double to string.
     */
    public static String formatDoubleAsCurrency(double dollars) {
        try {
            return currencyFormatter.format(dollars);
        } catch (ArithmeticException e) {
            return Double.toString(dollars);
        }
    }

    public static String localTimeToTwelveHourTIme(LocalTime localTime) {
        return localTime.format(TWELVE_HOUR_TIME);
    }
}

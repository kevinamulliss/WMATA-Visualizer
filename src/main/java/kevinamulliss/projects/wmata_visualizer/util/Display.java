package kevinamulliss.projects.wmata_visualizer.util;

import kevinamulliss.projects.wmata_visualizer.model.wmata.LineCode;
import kevinamulliss.projects.wmata_visualizer.model.wmata.StationCode;

import javax.annotation.Nullable;

/**
 * Utility class for complex operations for display operations.
 */
public class Display {
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
}

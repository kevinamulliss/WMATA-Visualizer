package kevinamulliss.projects.wmata_visualizer;

import kevinamulliss.projects.wmata_visualizer.connection.WMATAConnection;
import kevinamulliss.projects.wmata_visualizer.model.wmata.Line;
import kevinamulliss.projects.wmata_visualizer.model.wmata.MetroPathItem;
import kevinamulliss.projects.wmata_visualizer.model.wmata.Station;
import kevinamulliss.projects.wmata_visualizer.model.wmata.TrainPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Main class entrypoint for WMATA Visualizer.
 */
public class Main {
    /**
     * Main method program entrypoint.
     * @param args Standard command line arguments for java program. Should be left blank.
     */
    public static void main(String[] args) {
        boolean apiConnected = WMATAConnection.initializeConnection();
        if (apiConnected) {
            System.out.println("succesfully connected to API");
            Optional<List<Line>> lines = WMATAConnection.getLines();
            if (lines.isPresent()) {
                for (Line line : lines.get()) {
                    List<Station> stations = WMATAConnection.getStations(line.getLineCode()).orElse(new ArrayList<>());
                    System.out.println("test");
                }
            }
//            Thread cli = new CLIThread();
//            cli.start();
//            try {
//                cli.join();
//            } catch (InterruptedException e) {
//                System.out.println("interrupted");
//            }
        } else {
            System.out.println("failed to connect to API");
        }
    }
}
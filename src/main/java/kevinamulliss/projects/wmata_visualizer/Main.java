package kevinamulliss.projects.wmata_visualizer;

import kevinamulliss.projects.wmata_visualizer.connection.WMATAConnection;

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
        } else {
            System.out.println("failed to connect to API");
        }
    }
}
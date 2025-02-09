package kevinamulliss.projects.wmata_visualizer.request.trainpositions;

import kevinamulliss.projects.wmata_visualizer.request.WMATARequest;

public abstract class TrainPositionsRequest extends WMATARequest {
    private static final String PATH = "/TrainPositions";

    public TrainPositionsRequest() {
        this("");
    }

    public TrainPositionsRequest(String path) {
        super(PATH + path);
    }
}

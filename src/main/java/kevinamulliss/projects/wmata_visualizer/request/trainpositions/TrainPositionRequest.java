package kevinamulliss.projects.wmata_visualizer.request.trainpositions;

public class TrainPositionRequest extends TrainPositionsRequest{
    public static final String PATH = "/TrainPositions?contentType=json";

    public TrainPositionRequest() {
        this("");
    }

    public TrainPositionRequest(String path) {
        super(PATH + path);
    }
}

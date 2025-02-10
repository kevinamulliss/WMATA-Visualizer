package kevinamulliss.projects.wmata_visualizer.model.wmata;

import com.google.gson.annotations.SerializedName;

/**
 * Model for representing the results of a TrainPositions request.
 * Variable descriptions come from WMATA API.
 */
public class TrainPosition {
    // Number of cars. Can sometimes be 0 when there is no data available.
    @SerializedName("CarCount")
    private int carCount;
    // Circuit identifier the train is currently on. This identifier can be referenced from the Standard Routes method.
    @SerializedName("CircuitId")
    private int circuitId;
    // Destination station code. Can be NULL. Use this value in other rail-related APIs to retrieve data about a
    // station. Note: this value may sometimes differ from destination station code returned by our Next Trains methods.
    @SerializedName("DestinationStationCode")
    private StationCode destinationStationCode;
    // The direction of movement regardless of which track the train is on. Valid values are 1 or 2. Generally speaking,
    // trains with direction 1 are northbound/eastbound, while trains with direction 2 are southbound/westbound.
    @SerializedName("DirectionNum")
    private int directionNum;
    // 	Two-letter abbreviation for the line (e.g.: RD, BL, YL, OR, GR, or SV). May also be NULL in certain cases.
    @SerializedName("LineCode")
    private LineCode lineCode;
    // Approximate "dwell time". This is not an exact value, but can be used to determine how long a train has been
    // reported at the same track circuit.
    @SerializedName("SecondsAtLocation")
    private int secondsAtLocation;
    // Service Type of a train.
    @SerializedName("ServiceType")
    private ServiceType serviceType;
    // Uniquely identifiable internal train identifier.
    @SerializedName("TrainId")
    private int trainId;
    // Non-unique train identifier, often used by WMATA's Rail Scheduling and Operations Teams, as well as over open
    // radio communication.
    @SerializedName("TrainNumber")
    private String trainNumber;

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public int getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(int circuitId) {
        this.circuitId = circuitId;
    }

    public StationCode getDestinationStationCode() {
        return destinationStationCode;
    }

    public void setDestinationStationCode(StationCode destinationStationCode) {
        this.destinationStationCode = destinationStationCode;
    }

    public int getDirectionNum() {
        return directionNum;
    }

    public void setDirectionNum(int directionNum) {
        this.directionNum = directionNum;
    }

    public LineCode getLineCode() {
        return lineCode;
    }

    public void setLineCode(LineCode lineCode) {
        this.lineCode = lineCode;
    }

    public int getSecondsAtLocation() {
        return secondsAtLocation;
    }

    public void setSecondsAtLocation(int secondsAtLocation) {
        this.secondsAtLocation = secondsAtLocation;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }
}

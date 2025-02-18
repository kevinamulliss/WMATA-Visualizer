package kevinamulliss.projects.wmata_visualizer.request.railstation;

/**
 * Represents a request for information about Metro Lines from the WMATA API.
 * See <a href="https://developer.wmata.com/api-details#api=5476364f031f590f38092507&operation=5476364f031f5909e4fe330c">api link</a>.
 */
public class LinesRequest extends RailStationRequest {
    // final path for this request
    private static final String PATH = "/jLines";

    /**
     * Default constructor.
     */
    public LinesRequest() {
        super(PATH);
    }
}

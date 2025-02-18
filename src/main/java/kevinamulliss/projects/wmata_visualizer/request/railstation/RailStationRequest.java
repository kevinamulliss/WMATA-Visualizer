package kevinamulliss.projects.wmata_visualizer.request.railstation;

import kevinamulliss.projects.wmata_visualizer.request.WMATARequest;

/**
 * Represents an abstract base class for all Rail Station requests as defined in the <a href="https://developer.wmata.com/apis">WMATA API</a>.
 */
public abstract class RailStationRequest extends WMATARequest {
    // base path for all rail station requests
    private static final String PATH = "/Rail.svc/json";

    /**
     * Parameter constructor.
     * @param path An HTML path which represents an extension of this request's base path.
     */
    protected RailStationRequest(String path) {
        super(PATH + path);
    }
}

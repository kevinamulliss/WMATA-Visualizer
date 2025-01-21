package kevinamulliss.projects.wmata_visualizer.request.misc;

import kevinamulliss.projects.wmata_visualizer.request.WMATARequest;

public abstract class MiscRequest extends WMATARequest {

    private static final String PATH = "/Misc";

    public MiscRequest() {
        this("");
    }

    public MiscRequest(String path) {
        super(PATH + path);
    }
}

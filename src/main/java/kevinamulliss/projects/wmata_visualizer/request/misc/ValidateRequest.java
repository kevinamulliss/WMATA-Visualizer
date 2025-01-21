package kevinamulliss.projects.wmata_visualizer.request.misc;

public class ValidateRequest extends MiscRequest {
    private static final String PATH = "/Validate";

    public ValidateRequest() {
        this("");
    }

    public ValidateRequest(String path) {
        super(PATH + path);
    }
}

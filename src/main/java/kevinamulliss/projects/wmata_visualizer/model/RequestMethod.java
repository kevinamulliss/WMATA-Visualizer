package kevinamulliss.projects.wmata_visualizer.model;

public enum RequestMethod {
    GET, POST;

    @Override
    public String toString() {
        return switch (this) {
            case GET -> "GET";
            case POST -> "POST";
            default -> "";
        };
    }
}

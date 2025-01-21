package kevinamulliss.projects.wmata_visualizer.request;

import kevinamulliss.projects.wmata_visualizer.model.CacheControl;
import kevinamulliss.projects.wmata_visualizer.model.RequestMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public abstract class WMATARequest {
    private static final String PATH = "https://api.wmata.com/";
    private final String url;
    protected final String CACHE_CONTROL_KEY = "Cache-Control";
    protected CacheControl cacheControl = CacheControl.NO_CACHE;
    protected RequestMethod method = RequestMethod.GET;

    public WMATARequest() {
        this("");
    }

    public WMATARequest(String path) {
        this.url = PATH + path;
    }

    public HttpURLConnection getConnection() throws IOException {
        URL uri = URI.create(url).toURL();
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();
        connection.setRequestProperty(CACHE_CONTROL_KEY, cacheControl.toString());
        connection.setRequestMethod(method.toString());

        return connection;
    }
}

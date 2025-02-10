package kevinamulliss.projects.wmata_visualizer.cli;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import kevinamulliss.projects.wmata_visualizer.connection.WMATAConnection;
import kevinamulliss.projects.wmata_visualizer.request.WMATARequest;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CLICommand<T> {
    private final String COMMAND;
    private final String HELP;
    private final int PARAM_MIN;
    private final int PARAM_MAX;
    private final Function<String[], WMATARequest> EXEC;

    private static final Gson GSON = new Gson();

    public CLICommand(String command, String help, int paramMin, int ParamMax, Function<String[], WMATARequest> exec) {
        this.COMMAND = command;
        this.HELP = help;
        this.PARAM_MIN = paramMin;
        this.PARAM_MAX = ParamMax;
        this.EXEC = exec;
    }

    public String getCommand() {
        return this.COMMAND;
    }

    public String getHelp() {
        return this.HELP;
    }

    public void run() {
        this.run(new String[0]);
    }

    public void run(String[] args) {
        if (args.length < this.PARAM_MIN) {
            System.err.println(this.COMMAND + "requires " + this.PARAM_MIN + " parameters, but " + args.length + " provided.");
            return;
        }

        if (args.length > this.PARAM_MAX) {
            System.out.println(this.COMMAND + "uses " + this.PARAM_MAX + " parameters, but " + args.length + " provided. Remaining will be ignored.");
        }

        WMATARequest request = EXEC.apply(args);
        Optional<String> result = WMATAConnection.request(request);
        if (result.isPresent()) {
            Type listType = new TypeToken<List<T>>(){}.getType();
            JsonObject nestedObject = GSON.fromJson(result.get(), JsonObject.class);
            nestedObject.keySet().stream().findFirst().ifPresent((String key) -> {
                System.out.println(GSON.fromJson(nestedObject.get(key), listType).toString());
            });
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CLICommand c) {
            return this.COMMAND.equals(c.COMMAND);
        }

        return false;
    }
}

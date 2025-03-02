package kevinamulliss.projects.wmata_visualizer.cli;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kevinamulliss.projects.wmata_visualizer.cli.validation.CLIInputValidator;
import kevinamulliss.projects.wmata_visualizer.connection.WMATAConnection;
import kevinamulliss.projects.wmata_visualizer.request.WMATARequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CLICommand<T> {
    private final String COMMAND;
    private final String HELP;
    private final int PARAM_MIN;
    private final int PARAM_MAX;
    // list of validators to use
    private final CLIInputValidator[] validators;
    // determines how validation occurs
    // if false (default), each inputted element will be checked against equivalent email in validator array
    // if true, the first entry in the validator array will be used to check against all input
    private boolean validateAll = false;
    // this function can assume input is formatted properly as we validate before calling it
    private final Function<String[], WMATARequest> EXEC;
    private final Class<T> CLASS;

    private static final Gson GSON = new Gson();

    /**
     * Utility constructor for creating command without validation.
     * @param command Name of the command to create. This is what the user types into the CLI.
     * @param help Help menu entry for this command.
     * @param paramMin Minimum number of parameters this command requires.
     * @param paramMax Maximum number of parameters this command requires.
     * @param exec The function to run with the input should the command be successfully validated.
     * @param inputClass The data type that this command produces.
     */
    public CLICommand(String command, String help, int paramMin, int paramMax, Function<String[], WMATARequest> exec, Class<T> inputClass) {
        this(command, help, paramMin, paramMax, new CLIInputValidator[]{}, exec, inputClass);
    }

    /**
     * Utility constructor for creating command with the same validator for every input.
     * @param command Name of the command to create. This is what the user types into the CLI.
     * @param help Help menu entry for this command.
     * @param paramMin Minimum number of parameters this command requires.
     * @param paramMax Maximum number of parameters this command requires.
     * @param validator Validator to use for every input field.
     * @param exec The function to run with the input should the command be successfully validated.
     * @param inputClass The data type that this command produces.
     */
    public CLICommand(String command, String help, int paramMin, int paramMax, CLIInputValidator validator, Function<String[], WMATARequest> exec, Class<T> inputClass) {
        this(command, help, paramMin, paramMax, new CLIInputValidator[]{validator}, exec, inputClass);
        this.validateAll = true;
    }

    /**
     * Parameter constructor for instantiating a command with all fields.
     * @param command Name of the command to create. This is what the user types into the CLI.
     * @param help Help menu entry for this command.
     * @param paramMin Minimum number of parameters this command requires.
     * @param paramMax Maximum number of parameters this command requires.
     * @param validators Validation for the inputted parameters. Will check each element of input array against equivalent validator.
     * @param exec The function to run with the input should the command be successfully validated.
     * @param inputClass The data type that this command produces.
     */
    public CLICommand(String command, String help, int paramMin, int paramMax, CLIInputValidator[] validators, Function<String[], WMATARequest> exec, Class<T> inputClass) {
        this.COMMAND = command;
        this.HELP = help;
        this.PARAM_MIN = paramMin;
        this.PARAM_MAX = paramMax;
        this.validators = validators;
        this.EXEC = exec;
        this.CLASS = inputClass;
    }

    public String getCommand() {
        return this.COMMAND;
    }

    public String getHelp() {
        return this.HELP;
    }

    public Optional<List<T>> run() {
        return this.run(new String[0]);
    }

    public Optional<List<T>> run(String[] args) {
        // ensure there were enough parameters inputted
        if (args.length < this.PARAM_MIN) {
            System.err.println(this.COMMAND + "requires " + this.PARAM_MIN + " parameters, but " + args.length + " provided.");
            return Optional.empty();
        }

        // warn user if too many parameters were inputted
        if (args.length > this.PARAM_MAX) {
            System.out.println(this.COMMAND + "uses " + this.PARAM_MAX + " parameters, but " + args.length + " provided. Remaining will be ignored.");
        }

        // perform input validation
        // if we want to check one validator against all input
        if (this.validateAll) {
            // ensure we do have one validator and use it if we do
            CLIInputValidator validator = this.validators[0];
            if (validator != null) {
                for (int i = 0; i < args.length; i++) {
                    // if validation fails, output error and quit
                    if (!validator.validate(args[i])) {
                        System.err.println("Validation of " + args[i] + " failed.");
                        return Optional.empty();
                    }
                }
            }
        } else {
            // check validators against args until we run out of args or validators
            for (int i = 0; i < args.length && i < validators.length; i++) {
                // if validation fails, output and error
                if (!this.validators[i].validate(args[i])) {
                    System.err.println("Validation of " + args[i] + " failed.");
                    return Optional.empty();
                }
            }
        }

        WMATARequest request = EXEC.apply(args);
        Optional<String> result = WMATAConnection.request(request);
        if (result.isPresent()) {
            JsonObject nestedObject = GSON.fromJson(result.get(), JsonObject.class);
            Optional<String> optionalKey = nestedObject.keySet().stream().findAny();
            if (optionalKey.isPresent()) {
                JsonElement element = nestedObject.get(optionalKey.get());
                List<T> results = new ArrayList<T>();
                for (JsonElement jsonElement : element.getAsJsonArray()) {
                    results.add(GSON.fromJson(jsonElement, this.CLASS));
                }
                return Optional.of(results);
            }
        }

        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CLICommand<?> c) {
            return this.COMMAND.equals(c.COMMAND);
        }

        return false;
    }
}

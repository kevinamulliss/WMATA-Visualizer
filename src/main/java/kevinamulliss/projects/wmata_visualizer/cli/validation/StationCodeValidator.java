package kevinamulliss.projects.wmata_visualizer.cli.validation;

import kevinamulliss.projects.wmata_visualizer.model.wmata.StationCode;

public class StationCodeValidator implements CLIInputValidator {
    /**
     * Interface method to perform validation.
     * @param input String input to validation.
     * @return A boolean representing whether the input passed validation.
     */
    @Override
    public boolean validate(String input) {
        try {
            StationCode.valueOf(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

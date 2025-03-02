package kevinamulliss.projects.wmata_visualizer.cli.validation;

/**
 * Utility interface for defining how to validate input to CLI.
 */
public interface CLIInputValidator {
    // interface method. a validator will implement this, which takes in raw input and determines if it's valid
    public boolean validate(String input);
}

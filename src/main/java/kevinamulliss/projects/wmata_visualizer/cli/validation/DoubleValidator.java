package kevinamulliss.projects.wmata_visualizer.cli.validation;

public class DoubleValidator implements CLIInputValidator{
    @Override
    public boolean validate(String input) {
       try {
           Double.parseDouble(input);
           return true;
       } catch (NumberFormatException e) {
           return false;
       }
    }
}

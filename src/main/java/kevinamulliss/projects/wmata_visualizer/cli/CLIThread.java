package kevinamulliss.projects.wmata_visualizer.cli;

import kevinamulliss.projects.wmata_visualizer.model.wmata.LineCode;
import kevinamulliss.projects.wmata_visualizer.model.wmata.Station;
import kevinamulliss.projects.wmata_visualizer.request.railstation.StationListRequest;

import java.util.*;

public class CLIThread extends Thread {
    private String helpMenu;

    private String generateHelpMenu(Set<CLICommand<?>> commands) {
        StringBuilder help =
                new StringBuilder("Available Commands:\n" +
                        "help:\tDisplays this help menu.\n");
        for (CLICommand<?> command : commands) {
            help.append(command.getCommand()).append(":\t").append(command.getHelp()).append("\n");
        }
        help.append("exit:\tExits CLI.");

        return help.toString();
    }

    private Set<CLICommand<?>> getCommands() {
        Set<CLICommand<?>> commands = new HashSet<>();
        commands.add(new CLICommand<Station>(
                "list-stations",
                "Inputs 0-1 Line Codes. If 0 are inputted, all WMATA Metrorail stations are listed. If one is inputted, the stations for that line are listed.",
                0, 1,
                (String[] input) -> {
                    if (input.length >= 1) {
                        return new StationListRequest(LineCode.valueOf(input[0]));
                    } else {
                        return new StationListRequest();
                    }
                }));
        return commands;
    }
    @Override
    public void run() {
        Set<CLICommand<?>> commands = getCommands();
        this.helpMenu = generateHelpMenu(commands);
        Scanner scanner = new Scanner(System.in);
        String rawInput = "";
        String formattedInput = "";

        System.out.println("Welcome to WMATA Visualizer CLI");
        System.out.println(this.helpMenu);
        System.out.print("> ");

        while (scanner.hasNextLine()) {
            rawInput = scanner.nextLine();
            formattedInput = rawInput.trim().toLowerCase();
            if (formattedInput.equals("exit")) {
                break;
            } else {
                resolveCommand(rawInput, commands);
            }
            System.out.print("> ");
        }

        System.out.println("exiting CLI");
        scanner.close();
    }

    public void resolveCommand(String command, Set<CLICommand<?>> commands) {
        if (command.equalsIgnoreCase("help")) {
            System.out.println(this.helpMenu);
        } else {
            String[] tokens = command.split(" ");
            if (tokens.length == 0) {
                System.err.println("No tokens in input.");
            }
            String commandKey = tokens[0];

            Optional<CLICommand<?>> optionalCommand = commands.stream().filter((CLICommand<?> searchCommand) -> searchCommand.getCommand().equals(commandKey)).findAny();
            if (optionalCommand.isPresent()) {
                CLICommand<?> finalCommand = optionalCommand.get();
                if (tokens.length > 1) {
                    finalCommand.run(Arrays.copyOfRange(tokens, 1, tokens.length));
                } else {
                    finalCommand.run();
                }
            }
        }
    }
}

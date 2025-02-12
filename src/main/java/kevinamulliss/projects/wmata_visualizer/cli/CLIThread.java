package kevinamulliss.projects.wmata_visualizer.cli;

import kevinamulliss.projects.wmata_visualizer.model.wmata.*;
import kevinamulliss.projects.wmata_visualizer.request.railstation.LinesRequest;
import kevinamulliss.projects.wmata_visualizer.request.railstation.PathBetweenStationsRequest;
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
        commands.add(new CLICommand<Line>(
                "lines",
                "No inputs. Provides information about every WMATA Metrorail line.",
                0, 0,
                ((String[] input) -> new LinesRequest())
        ));
        commands.add(new CLICommand<MetroPathItem>(
                "path-between",
                "Inputs 2 Station Codes. Returns the path of stations between the two stations represented by those Station Codes.",
                2, 2,
                ((String[] input) -> new PathBetweenStationsRequest(StationCode.valueOf(input[0]), StationCode.valueOf(input[1])))
        ));
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
                Optional<? extends List<?>> result = resolveCommand(rawInput, commands);
            }
            System.out.print("> ");
        }

        System.out.println("exiting CLI");
        scanner.close();
    }

    public Optional<? extends List<?>> resolveCommand(String command, Set<CLICommand<?>> commands) {
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
                    return finalCommand.run(Arrays.copyOfRange(tokens, 1, tokens.length));
                } else {
                    return finalCommand.run();
                }
            }
        }
    }
}

/*
chatgpt paginated output example
import java.util.Scanner;

public class PaginatedOutput {
    public static void main(String[] args) {
        String[] data = {
            "Element 1:\nLine 1\nLine 2\nLine 3",
            "Element 2:\nLine 1\nLine 2\nLine 3",
            "Element 3:\nLine 1\nLine 2\nLine 3",
            "Element 4:\nLine 1\nLine 2\nLine 3"
        };

        displayWithPagination(data);
    }

    public static void displayWithPagination(String[] data) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;

        while (index < data.length) {
            clearScreen();  // Optional: Clears the terminal screen
            System.out.println(data[index]);
            System.out.println("\n[Press Enter to continue, 'b' to go back, 'q' to quit]");

            String input = scanner.nextLine();
            if (input.equals("q")) {
                break;
            } else if (input.equals("b")) {
                if (index > 0) index--; // Move back
            } else {
                index++; // Move forward
            }
        }

        scanner.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}


 */

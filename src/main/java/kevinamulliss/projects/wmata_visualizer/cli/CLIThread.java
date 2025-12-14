package kevinamulliss.projects.wmata_visualizer.cli;

import kevinamulliss.projects.wmata_visualizer.cli.validation.DoubleValidator;
import kevinamulliss.projects.wmata_visualizer.cli.validation.StationCodeValidator;
import kevinamulliss.projects.wmata_visualizer.model.wmata.*;
import kevinamulliss.projects.wmata_visualizer.request.railstation.*;

import java.util.*;

public class CLIThread extends Thread {
    private String helpMenu;
    private final Set<CLICommand<?>> COMMANDS = getCommands();
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

    private static Set<CLICommand<?>> getCommands() {
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
                },
                Station.class));
        commands.add(new CLICommand<Line>(
                "lines",
                "No inputs. Provides information about every WMATA Metrorail line.",
                0, 0,
                ((String[] input) -> new LinesRequest()),
                Line.class
        ));
        commands.add(new CLICommand<MetroPathItem>(
                "path-between",
                "Inputs 2 Station Codes. Returns the path of stations between the two stations represented by those Station Codes.",
                2, 2,
                ((String[] input) -> new PathBetweenStationsRequest(StationCode.valueOf(input[0]), StationCode.valueOf(input[1]))),
                MetroPathItem.class
        ));
        commands.add(new CLICommand<StationEntrance>(
                "entrances",
                "No Inputs. Returns a list of all station entrances on the WMATA Metrorail system.",
                0, 0,
                ((String[] input) -> new StationEntrancesRequest()),
                StationEntrance.class
        ));
        commands.add(new CLICommand<StationEntrance>(
                "entrances-near",
                "Inputs a lat, lon, and radius (meters). Returns all stations within input radius centered on inputted lat/lon.",
                3, 3,
                new DoubleValidator(),
                ((String[] input) -> new StationEntrancesRequest(Double.parseDouble(input[0]), Double.parseDouble(input[1]), Double.parseDouble(input[2]))),
                StationEntrance.class

        ));
        commands.add(new CLICommand<StationParking>(
                "parking",
                "Inputs nothing or a station code. If nothing, parking information for all stations is outputted. If a station code, parking about that station is outputted.",
                0, 1,
                new StationCodeValidator(),
                (String[] input) -> {
                    if (input.length >= 1) {
                        return new ParkingInformationRequest(StationCode.valueOf(input[0]));
                    } else {
                        return new ParkingInformationRequest();
                    }
                },
                StationParking.class
        ));
        commands.add(new CLICommand<Station>(
                "station",
                "Inputs a station code and provides general information about that station.",
                1, 1,
                new StationCodeValidator(),
                (String [] input) -> new StationInformationRequest(StationCode.valueOf(input[0])),
                Station.class
        ));
        commands.add(new CLICommand<StationTime>(
                "station-timing",
                "Inputs nothing or a station code. If nothing, station timing information for all stations is outputted. If a station code, station timing about that station is outputted.",
                0, 1,
                new StationCodeValidator(),
                (String[] input) -> {
                    if (input.length >= 1) {
                        return new StationTimingsRequest(StationCode.valueOf(input[0]));
                    } else {
                        return new StationTimingsRequest();
                    }
                },
                StationTime.class
        ));
        return commands;
    }
    @Override
    public void run() {
        this.helpMenu = generateHelpMenu(COMMANDS);
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
                Optional<? extends List<?>> result = resolveCommand(rawInput);
                if (result.isPresent()) {
                    List<?> resultList = result.get();
                    // only do paginated output for arrays above size 10
                    if (resultList.size() > 10) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("there are " + resultList.size() + " results. Using paginated output.");
                        int index = 0;
                        while (index >= 0 && index < resultList.size()) {
                            System.out.println("Element " + (index + 1) + " out of " + resultList.size() + " results:");
                            System.out.println("\t" + resultList.get(index));

                            System.out.print("Enter 'q' to quit");
                            if (index < resultList.size() - 1) {
                                System.out.print(" or 'n' for next element");
                            }
                            if (index >= 1) {
                                System.out.print(" or 'p' for previous element");
                            }

                            System.out.println(". Enter 'l' to list every element or a number to go to a specific element");

                            String pageInput = scanner.nextLine().trim().toLowerCase();
                            if (pageInput.startsWith("q")) {
                                break;
                            } else if (pageInput.startsWith("p")) {
                                index--;
                            } else if (pageInput.startsWith("n")) {
                                index++;
                            } else if (pageInput.startsWith("l")) {
                                printAll(resultList);
                                break;
                            } else {
                                // check if the user entered an index to jump to
                                try {
                                    int seek = Integer.parseInt(pageInput);
                                    // while the array is 0 indexed, the user is displayed 1 indexed values so we decrement what they input
                                    if (seek >= 1 && seek <= resultList.size()) {
                                        index = seek - 1;
                                    } else if (seek == 0) {
                                        System.err.println("You entered 0. Values are 1 indexed. Enter 1 to go to first value");
                                    } else {
                                        System.err.println("You entered " + seek + ", which is not with valid range between 1 and " + resultList.size());
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("Invalid entry, " + pageInput + " is not an integer.");
                                }
                            }
                        }
                    } else if (resultList.size() == 1) {
                        System.out.println(resultList.getFirst());
                    }
                    else {
                        printAll(resultList);
                    }
                }
            }

            System.out.print("> ");
        }

        System.out.println("exiting CLI");
        scanner.close();
    }

    private void printAll(List<?> results) {
        for (int i = 0; i < results.size(); i++) {
            System.out.println("(" + (i + 1) + "/" + results.size() + "): " + results.get(i));
        }
    }

    public Optional<? extends List<?>> resolveCommand(String command) {
        if (command.equalsIgnoreCase("help")) {
            System.out.println(this.helpMenu);
        } else {
            String[] tokens = command.split(" ");
            if (tokens.length == 0) {
                System.err.println("No tokens in input.");
            }
            String commandKey = tokens[0];

            Optional<CLICommand<?>> optionalCommand = COMMANDS.stream().filter((CLICommand<?> searchCommand) -> searchCommand.getCommand().equals(commandKey)).findAny();
            if (optionalCommand.isPresent()) {
                CLICommand<?> finalCommand = optionalCommand.get();
                if (tokens.length > 1) {
                    return finalCommand.run(Arrays.copyOfRange(tokens, 1, tokens.length));
                } else {
                    return finalCommand.run();
                }
            }
        }

        return Optional.empty();
    }
}
package kevinamulliss.projects.wmata_visualizer.cli;

import java.util.Scanner;

public class CLIThread extends Thread {
    private static final String HELP_MENU =
            "Available Commands:\n" +
            "help:\tDisplays this help menu.\n" +
            "exit:\tExits CLI.";
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String rawInput = "";
        String formattedInput = "";

        System.out.println("Welcome to WMATA Visualizer CLI");
        System.out.println(HELP_MENU);
        System.out.print("> ");

        while (scanner.hasNextLine()) {
            rawInput = scanner.nextLine();
            formattedInput = rawInput.trim().toLowerCase();
            if (formattedInput.equals("exit")) {
                break;
            } else {
                resolveCommand(formattedInput);
            }
            System.out.print("> ");
        }

        System.out.println("exiting CLI");
        scanner.close();
    }

    public void resolveCommand(String command) {
        if (command.equals("help")) {
            System.out.println(HELP_MENU);
        }
    }
}

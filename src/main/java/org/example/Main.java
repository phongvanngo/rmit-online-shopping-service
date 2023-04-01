package org.example;

import org.example.command.CommandManager;
import org.example.command.command_management.AppCommandInvoker;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandManager commandManager = new CommandManager(scanner);
        commandManager.register("app",new AppCommandInvoker(scanner));

        String commandName;
        do {
            System.out.print("Enter command: ");
            commandName = scanner.next();
            commandManager.execute(commandName);
        } while (true);
    }
}
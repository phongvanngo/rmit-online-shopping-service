package org.example;

import org.example.command.CommandManager;
import org.example.command.command_management.AppCommandInvoker;
import org.example.command.command_management.CartCommandInvoker;
import org.example.command.command_management.ProductCommandInvoker;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandManager commandManager = new CommandManager(scanner);
        commandManager.register("app",new AppCommandInvoker(scanner));
        commandManager.register("product",new ProductCommandInvoker(scanner));
        commandManager.register("cart",new CartCommandInvoker(scanner));

        String commandName;
        do {
            System.out.print("Enter command ( Type ? to view all commands): ");
            commandName = scanner.next();
            commandManager.execute(commandName);
        } while (true);
    }
}
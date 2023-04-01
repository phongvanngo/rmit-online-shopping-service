package org.example.command;

import org.example.command.command_management.AppCommandInvoker;
import org.example.command.command_management.CommandInvoker;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {

    Map<String, CommandInvoker> invokers = new HashMap<>();

    AppCommandInvoker appCommandInvoker;
    private Scanner scanner;

    public void register(String commandName, CommandInvoker commandInvoker) {
        invokers.put(commandName, commandInvoker);
    }

    public CommandManager(Scanner scanner) {
        this.scanner = scanner;
        appCommandInvoker = new AppCommandInvoker(scanner);
    }

    public void execute(String commandName) {
        CommandInvoker commandInvoker = invokers.get(commandName);
        if (commandInvoker != null) {
            commandInvoker.execute(scanner.next());
        } else {
            appCommandInvoker.execute(commandName);
        }
    }
}

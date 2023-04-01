package org.example.command.command_management;

import org.example.command.commands.Command;
import org.example.command.commands.app_commands.ExitCommand;
import org.example.command.commands.app_commands.HelloCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppCommandInvoker implements CommandInvoker {
    private Map<String, Command> commands = new HashMap<>();
    private Scanner scanner;

    public AppCommandInvoker(Scanner scanner) {
        this.scanner = scanner;
        register("hello world", new HelloCommand(scanner));
        register("exit",new ExitCommand(scanner));
    }

    private void register(String commandName, Command command) {
        commands.put(commandName, command);
    }

    @Override
    public void execute(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.readInput();
            command.execute(commandName);
        } else {
            System.out.println("Command Not Found");
        }
        return;
    }
}

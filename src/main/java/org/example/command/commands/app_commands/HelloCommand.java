package org.example.command.commands.app_commands;

import org.example.command.commands.Command;

import java.util.Scanner;

public class HelloCommand implements Command {

    private Scanner scanner;
    @Override
    public void readInput() {
        return;
    }

    public HelloCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String commandName) {
        System.out.println("Hello World");
    }
}

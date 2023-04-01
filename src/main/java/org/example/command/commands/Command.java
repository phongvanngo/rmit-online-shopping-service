package org.example.command.commands;

import java.util.Scanner;

public interface Command {
    void readInput();
    void execute(String commandName);
}

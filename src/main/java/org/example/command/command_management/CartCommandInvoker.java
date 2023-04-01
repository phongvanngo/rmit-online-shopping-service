package org.example.command.command_management;

import org.example.command.commands.Command;
import org.example.command.commands.cart_commands.*;
import org.example.command.commands.product_commands.CreateProductCommand;
import org.example.command.commands.product_commands.EditProductCommand;
import org.example.command.commands.product_commands.ViewProductCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CartCommandInvoker implements CommandInvoker {
    private Map<String, Command> commands = new HashMap<>();
    private Scanner scanner;

    public CartCommandInvoker(Scanner scanner) {
        this.scanner = scanner;
        register("add", new AddToCartCommand(scanner));
        register("new", new NewCartCommand(scanner));
        register("remove", new RemoveItemFromCart(scanner));
        register("display", new DisplayCartsCommand(scanner));
        register("view", new ViewCurrentCart(scanner));
        register("switch", new SwitchCartCommand(scanner));
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

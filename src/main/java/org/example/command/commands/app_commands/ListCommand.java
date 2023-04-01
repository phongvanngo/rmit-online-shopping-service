package org.example.command.commands.app_commands;

import org.example.command.commands.Command;

import java.util.Scanner;

public class ListCommand implements Command {

    private Scanner scanner;
    @Override
    public void readInput() {
        return;
    }

    public ListCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String commandName) {
        System.out.println("- product add : add new product\n" +
                "- product update : update product\n" +
                "- product view : view all product\n" +
                "- cart new : init new cart\n" +
                "- cart add : add item to cart\n" +
                "- cart remove : remove item from cart\n" +
                "- cart display : display cart sorted base on cart weight\n" +
                "- cart switch : switch to other cart in system\n" +
                "- cart view : view current cart info\n");
    }
}

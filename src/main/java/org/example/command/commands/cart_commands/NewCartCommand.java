package org.example.command.commands.cart_commands;

import org.example.command.commands.Command;
import org.example.entity.product.Product;
import org.example.repository.CartRepository;

import java.util.Scanner;

public class NewCartCommand implements Command {

    private final CartRepository cartRepository = CartRepository.getInstance();

    Product product;


    private Scanner scanner;

    @Override
    public void readInput() {
    }

    public NewCartCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String commandName) {
        cartRepository.initCart();
        System.out.println("Your Cart Is Init Successfully: " + cartRepository.getCurrentCart());
    }
}

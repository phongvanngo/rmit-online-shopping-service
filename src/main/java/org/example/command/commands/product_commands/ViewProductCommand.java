package org.example.command.commands.product_commands;

import org.example.command.commands.Command;
import org.example.entity.product.DigitalProduct;
import org.example.entity.product.PhysicalProduct;
import org.example.entity.product.Product;
import org.example.repository.ProductRepository;

import java.util.Scanner;

public class ViewProductCommand implements Command {

    private Scanner scanner;

    @Override
    public void readInput() {
    }

    public ViewProductCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String commandName) {
        ProductRepository productRepository = ProductRepository.getInstance();
        productRepository.printProducts();
        System.out.println("-----\n");
    }
}

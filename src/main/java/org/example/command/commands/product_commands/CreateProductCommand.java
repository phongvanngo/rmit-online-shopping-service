package org.example.command.commands.product_commands;

import org.example.command.commands.Command;
import org.example.entity.product.DigitalProduct;
import org.example.entity.product.PhysicalProduct;
import org.example.entity.product.Product;
import org.example.repository.ProductRepository;

import java.util.Scanner;

public class CreateProductCommand implements Command {

    private final ProductRepository productRepository = ProductRepository.getInstance();

    Product product;

    private boolean passed;

    private Scanner scanner;

    @Override
    public void readInput() {
        System.out.print("Type Of Product (Digital/Physical): ");

        switch (scanner.next().toLowerCase()) {
            case "digital":
                product = new DigitalProduct();
                break;
            case "physical":
                product = new PhysicalProduct();
                System.out.print("Weight: ");
                product.setWeight(scanner.nextDouble());
                break;
            default:
                System.out.println("Invalid input");
                passed = false;
                return;
        }
        scanner.nextLine();
        System.out.print("Name: ");
        product.setName(scanner.nextLine());

        System.out.print("Description: ");
        product.setDescription(scanner.nextLine());

        System.out.print("Quantity Available: ");
        product.setQuantityAvailable(scanner.nextInt());

        System.out.print("Is Gift (Y/N): ");
        scanner.nextLine();
        switch (scanner.next().toLowerCase()) {
            case "y":
                product.setGift(true);
                scanner.nextLine();
                System.out.print("Message: ");
                product.setMessage(scanner.nextLine());
                break;
            case "n":
                product.setGift(false);
                break;
            default:
                System.out.println("Invalid input");
                passed = false;
                return;
        }
        System.out.print("Price: ");
        product.setPrice(scanner.nextDouble());

        System.out.println(product);
        passed = true;
    }

    public CreateProductCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String commandName) {
        if (!passed) return;
        productRepository.saveProduct(product);
        System.out.println("Create successfully!\n");
        System.out.println(product.getName());
    }
}

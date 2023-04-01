package org.example.command.commands.product_commands;

import org.example.command.commands.Command;
import org.example.entity.product.DigitalProduct;
import org.example.entity.product.PhysicalProduct;
import org.example.entity.product.Product;
import org.example.repository.ProductRepository;

import java.util.Optional;
import java.util.Scanner;

public class EditProductCommand implements Command {
    private final ProductRepository productRepository = ProductRepository.getInstance();

    Product productToEdit;

    private boolean passed;

    private Scanner scanner;

    @Override
    public void readInput() {
        System.out.print("Product Id that you want to update: ");
        Integer productId = scanner.nextInt();

        Optional<Product> product = productRepository.getById(productId);

        if(product.isEmpty()) {
            passed = false;
            System.out.println("Product Not Found!");
            return;
        }

        if (product.get() instanceof PhysicalProduct) {
            System.out.print("Weight: ");
            product.get().setWeight(scanner.nextDouble());
        }


        scanner.nextLine();
        System.out.print("Name: ");
        product.get().setName(scanner.nextLine());

        System.out.print("Description: ");
        product.get().setDescription(scanner.nextLine());

        System.out.print("Quantity Available: ");
        product.get().setQuantityAvailable(scanner.nextInt());

        System.out.print("Is Gift (Y/N): ");
        switch (scanner.next().toLowerCase()) {
            case "y":
                product.get().setGift(true);
                System.out.print("Message: ");
                scanner.nextLine();
                product.get().setMessage(scanner.nextLine());
                break;
            case "n":
                product.get().setGift(false);
                break;
            default:
                System.out.println("Invalid input");
                passed = false;
                return;
        }
        System.out.print("Price: ");
        product.get().setPrice(Double.valueOf(scanner.next()));
        productToEdit = product.get();
        passed = true;
    }

    public EditProductCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String commandName) {
        if (!passed) return;
        ProductRepository productRepository = ProductRepository.getInstance();
        productRepository.saveProduct(productToEdit);
        System.out.println("Edit successfully!\n");

    }
}

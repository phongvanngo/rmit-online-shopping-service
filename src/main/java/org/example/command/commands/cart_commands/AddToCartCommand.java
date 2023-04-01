package org.example.command.commands.cart_commands;

import org.example.command.commands.Command;
import org.example.entity.product.DigitalProduct;
import org.example.entity.product.PhysicalProduct;
import org.example.entity.product.Product;
import org.example.repository.CartRepository;
import org.example.repository.ProductRepository;

import java.util.Scanner;

public class AddToCartCommand implements Command {

    private final CartRepository cartRepository = CartRepository.getInstance();

    Product product;


    private Scanner scanner;

    @Override
    public void readInput() {
    }

    public AddToCartCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String commandName) {
        if (cartRepository.getCurrentCart() == null) {
            System.out.println("You must init the cart first");
            return;
        }
        System.out.println("Your Current Cart: " + cartRepository.getCurrentCart());
        scanner.nextLine();
        System.out.print("Product name to add to cart: ");
        String name = scanner.nextLine();
        if (cartRepository.addItem(name)) {
            System.out.print("Add Item Succesffully. Your Product In Cart: ");
            cartRepository.getCurrentCart().printProductsInCart();
        }
    }
}

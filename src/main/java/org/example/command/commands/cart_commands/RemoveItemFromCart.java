package org.example.command.commands.cart_commands;

import org.example.command.commands.Command;
import org.example.entity.product.Product;
import org.example.repository.CartRepository;

import java.util.Scanner;

public class RemoveItemFromCart implements Command {

    private final CartRepository cartRepository = CartRepository.getInstance();

    Product product;


    private Scanner scanner;

    @Override
    public void readInput() {
    }

    public RemoveItemFromCart(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String commandName) {
        System.out.println("Your Current Cart: " + cartRepository.getCurrentCart());
        scanner.nextLine();
        System.out.print("Product name to remove from cart: ");
        String name = scanner.nextLine();
        if (cartRepository.removeItem(name)) {
            System.out.print("Remove Item Succesffully. Your Product In Cart: ");
            cartRepository.getCurrentCart().printProductsInCart();
        }
    }
}

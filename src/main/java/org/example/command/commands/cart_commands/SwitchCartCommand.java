package org.example.command.commands.cart_commands;

import org.example.command.commands.Command;
import org.example.entity.cart.Cart;
import org.example.entity.product.Product;
import org.example.repository.CartRepository;

import java.util.Optional;
import java.util.Scanner;

public class SwitchCartCommand implements Command {

    private final CartRepository cartRepository = CartRepository.getInstance();

    Product product;


    private Scanner scanner;

    @Override
    public void readInput() {

    }

    public SwitchCartCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(String commandName) {
        System.out.println("Current Carts In System: ");
        cartRepository.printCarts();
        System.out.print("Input cart id that you want to switch to :");
        Integer cartId = scanner.nextInt();
        Optional<Cart> cart = cartRepository.getById(cartId);
        if (cart.isEmpty()) {
            System.out.println("Cart Not Found");
            return;
        }
        cartRepository.switchCart(cart.get());

        System.out.println("Successfully!. Your current cart: "+cartRepository.getCurrentCart());
    }
}

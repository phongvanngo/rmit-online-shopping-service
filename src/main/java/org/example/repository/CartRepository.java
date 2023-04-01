package org.example.repository;

import org.example.entity.cart.Cart;
import org.example.entity.product.Product;
import org.example.util.IdGenerator;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class CartRepository {
    private static CartRepository instance;

    private final IdGenerator idGenerator;

    private Cart currentCart;

    List<Cart> carts;

    private CartRepository() {
        carts = new ArrayList<>();
        idGenerator = new IdGenerator();
    }

    ;

    public static CartRepository getInstance() {
        if (instance == null) {
            instance = new CartRepository();
        }
        return instance;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void printCarts() {
        sortCarts();
        for (Cart cart :
                carts) {
            System.out.println(cart.toString());
        }
    }

    public void initCart() {
        updateCarts();
        currentCart = new Cart(idGenerator.next());
        carts.add(currentCart);
    }

    public void sortCarts() {
        Collections.sort(carts);
    }

    public boolean switchCart(Integer cartId) {
        Optional<Cart> cart = getById(cartId);
        if (cart.isEmpty()) {
            System.out.println("Cart Not Found");
            return false;
        }
        updateCarts();
        currentCart = cart.get();
        System.out.println("Cart now is " + cart.toString());
        return true;
    }

    private void updateCarts() {
        carts = carts.stream().map(e -> {
                    if (e.getCartId().equals(currentCart.getCartId())) {
                        return e;
                    }
                    return e;
                }
        ).collect(Collectors.toList());
    }


    public boolean addItem(String name) {
        if(currentCart==null) {
            System.out.println("You must init cart first");
            return false;
        }
        return currentCart.addItem(name);
    }

    ;

    public boolean removeItem(String name) {
        return currentCart.removeItem(name);
    }

    ;

    public Optional<Cart> getById(Integer id) {
        return carts
                .stream().parallel()
                .filter(e -> e.getCartId().equals(id)).findFirst();
    }

    public Cart getCurrentCart() {
        return currentCart;
    }

    public void switchCart(Cart cart) {
        currentCart = cart;
    }
}

package org.example.entity.cart;

import org.example.entity.product.PhysicalProduct;
import org.example.entity.product.Product;
import org.example.repository.ProductRepository;
import org.example.util.Constants;
import org.example.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Cart implements Comparable<Cart> {

    private final ProductRepository productRepository = ProductRepository.getInstance();
    private Integer cartId;
    private List<String> productNames = new ArrayList<>();

    public boolean addItem(String productName) {
        Optional<Product> product = productRepository.getByName(productName);
        if (product.isEmpty()) {
            System.out.println("Product With The Name Provided Not Found");
            return false;
        }
        if (productNames.contains(productName)) {
            System.out.println("Already in cart");
            return false;
        }
        if (product.get().getQuantityAvailable() == 0) {
            System.out.println("Out of stock");
            return false;
        }
        ;

        product.get().setQuantityAvailable(product.get().getQuantityAvailable() - 1);
        productRepository.saveProduct(product.get());

        productNames.add(productName);

        return true;
    }

    public boolean removeItem(String productName) {
        try {
            Optional<Product> product = productRepository.getByName(productName);
            product.get().setQuantityAvailable(product.get().getQuantityAvailable() + 1);
            productRepository.saveProduct(product.get());
            productNames.remove(productName);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public Cart(Integer id) {
        cartId = id;
    }

    public Double cartAmount() {
        Double amount = 0.0;
        for (String name :
                productNames) {
            Optional<Product> product = productRepository.getByName(name);
            amount += product.get().getPrice();
        }
        return amount + cartWeight() * Constants.BASE_FEE;
    }

    public Double cartWeight() {
        Double weight = 0.0;
        for (String name :
                productNames) {
            Optional<Product> product = productRepository.getByName(name);
            if (product.get() instanceof PhysicalProduct) {
                weight += product.get().getWeight();
            }
        }
        return weight;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", productNames=" + productNames +
                ", cartAmount=" + cartAmount() +
                '}';
    }


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public void printProductsInCart() {
        System.out.println(productNames);
    }
    @Override
    public int compareTo(Cart o) {
        if (cartWeight().equals(o.cartWeight())) return 0;
        if (cartWeight() > o.cartWeight()) return 1;
        return -1;
    }
}

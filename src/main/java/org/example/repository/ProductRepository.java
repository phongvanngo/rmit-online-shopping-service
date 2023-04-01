package org.example.repository;

import org.example.entity.product.Product;
import org.example.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductRepository {
    private static ProductRepository instance;

    private final IdGenerator idGenerator;

    List<Product> products;

    private ProductRepository() {
        products = new ArrayList<>();
        idGenerator = new IdGenerator();
    }

    ;

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void printProducts() {
        for (Product product :
                products) {
            System.out.println(product.getInfo());
        }
    }

    public boolean saveProduct(Product product) {
        try {
            if (product.getId() == null) {
                product.setId(idGenerator.next());
                products.add(product);
            } else {
                products = products.stream().map(e -> {
                            if (e.getId().equals(product.getId())) {
                                return product;
                            }
                            return e;
                        }
                ).collect(Collectors.toList());
            }
            return true;
        } catch (
                Exception e) {
            return false;
        }
    }

    public Optional<Product> getById(Integer id) {
        return products
                .stream().parallel()
                .filter(e -> e.getId().equals(id)).findFirst();
    }
}

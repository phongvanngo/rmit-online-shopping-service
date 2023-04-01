package org.example.entity.product;

public class Product {
    private Integer id;
    private String name;
    private String description;
    private Integer quantityAvailable;
    private double Price;
    private boolean isGift;
    private String message;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public boolean isGift() {
        return isGift;
    }

    public void setGift(boolean gift) {
        isGift = gift;
    }

    public String getMessage() {
        if (isGift) {
            return this.message;
        }
        System.out.println("---!!!---Product isn't a gift");
        return null;
    }

    public void setWeight(Double weight) {
        return;
    }

    public Double getWeight() {
        return null;
    }

    public void setMessage(String message) {
        if (isGift) {
            this.message = message;
        } else {
            System.out.println("---!!!---Product isn't a gift");
        }
    }

    public String getInfo() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                ", Price=" + Price +
                ", isGift=" + isGift +
                ", message='" + message + '\'' +
                '}';
    }
}

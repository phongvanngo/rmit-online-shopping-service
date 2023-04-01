package org.example.entity.product;

public class DigitalProduct extends Product{
    @Override
    public String toString() {
        return "DIGITAL - "+this.getName();
    }

    public String getInfo() {
        return "DIGITAL {" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", quantityAvailable=" + this.getDescription() +
                ", Price=" + this.getPrice() +
                ", isGift=" + this.isGift() +
                ", message='" + this.getMessage() + '\'' +
                '}';
    }
}

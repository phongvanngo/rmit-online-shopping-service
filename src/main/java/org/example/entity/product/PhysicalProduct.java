package org.example.entity.product;

public class PhysicalProduct extends Product{
    private Double weight;

    public Double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String toString() {
        return "PHYSICAL - "+this.getName();
    }

    public String getInfo() {
        return "PHYSICAL {" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", description='" + this.getDescription() + '\'' +
                ", quantityAvailable=" + this.getQuantityAvailable() +
                ", Price=" + this.getPrice() +
                ", isGift=" + this.isGift() +
                ", message='" + this.getMessage() + '\'' +
                ", weight='" + this.getWeight() + '\'' +
                '}';
    }
}

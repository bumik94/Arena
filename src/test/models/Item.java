package test.models;

import java.util.Objects;

public abstract class Item implements Comparable<Item> {
    private final String name;
    private final double weight;

    private int quantity;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
        this.quantity = 1;
    }

    public Item(String name, double weight, int quantity) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return String.format("'%s' (%.2f) %dx (%.2f)", name, weight, quantity, totalWeight());
    }

    public String name() {
        return name;
    }

    public double weight() {
        return weight;
    }

    public int quantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    public double totalWeight() {
        return weight * quantity;
    }
}

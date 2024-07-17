package test.models;

import java.util.Comparator;
import java.util.Objects;

public abstract class Item {
    private final String name;
    private final double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return String.format("'%s' |%.2f|", name, weight);
    }

    public String name() {
        return name;
    }

    public double weight() {
        return weight;
    }

    public static class Stack <T extends Item> {
        private final T item;

        private int quantity;

        public Stack(T item, int quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Stack{" +
                    "stack=" + item +
                    ", quantity=" + quantity +
                    '}';
        }
    }
}

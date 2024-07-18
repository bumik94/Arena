package test.items;

import test.models.Item;

public class Miscelaneous extends Item implements Comparable<Item> {

    public Miscelaneous(String name, double weight) {
        super(name, weight);
    }

    @Override
    public int compareTo(Item o) {
        return name().compareTo(o.name());
    }
}
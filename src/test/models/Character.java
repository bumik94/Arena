package test.models;

import java.util.ArrayList;

public class Character {
    private final String name;

    private int     maxHealth;
    private int     currentHealth;
    private int     damagge = 0;
    private double  carryingCapacity;
    private double  encumbrance = 0;

    private ArrayList<Item>      inventory = new ArrayList<>();
    private ArrayList<Equipable> equipment = new ArrayList<>();

    public Character(String name, int health, double carryingCapacity) {
        this.name               = name;
        this.maxHealth          = health;
        this.currentHealth      = health;
        this.carryingCapacity   = carryingCapacity;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", carryingCapacity=" + carryingCapacity +
                ", encumbrance=" + encumbrance +
                ", inventory=" + inventory +
                ", equipment=" + equipment +
                '}';
    }

    public <T extends Equipable> void equipItem(T item) {
        equipment.add(item.getSLOT().ordinal(), item);
    }
}

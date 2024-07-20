package test.models;

import test.interfaces.Equipable;
import test.interfaces.Operation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Character {
    private final String name;

    private int     maxHealth;
    private int     currentHealth;
    private int     damage;
    private int     armor;
    private double  carryingCapacity;
    private double  encumbrance;

    private List<Item>      inventory = new ArrayList<>();
    private List<Equipable> equipment = new ArrayList<>();

    public Character(String name) {
        this.name               = name;
        this.maxHealth          = 10;
        this.currentHealth      = 10;
        this.carryingCapacity   = 50;
        this.encumbrance        = 0;
        this.damage             = 0;
        this.armor              = 0;
    }

    @Override
    public String toString() {
        return String.format("""
                '%s'
                damage      >%d<
                armor       ]%d[
                health      |%d/%d|
                encumbrance (%.2f/%.2f)
                Equipment   > %s
                Inventory   > %s
                """,
                name,
                damage,
                armor,
                currentHealth, maxHealth,
                encumbrance, carryingCapacity,
                equipment.toString(),
                inventory.toString());
    }

    public <T extends Equipable> void equipItem(T item) {
        equipment.add(item.getSlotOrdinal(), item);

        switch (item.getBonusType()) {
            case DAMAGE -> this.damage     += item.getBonusValue();
            case ARMOR  -> this.armor      += item.getBonusValue();
            case HEALTH -> this.maxHealth  += item.getBonusValue();
        }
    }

    public <T extends Equipable> void unequipItem(T item) {
        equipment.removeIf(o -> equipment.contains(item));

        switch (item.getBonusType()) {
            case DAMAGE -> this.damage     -= item.getBonusValue();
            case ARMOR  -> this.armor      -= item.getBonusValue();
            case HEALTH -> this.maxHealth  -= item.getBonusValue();
        }
    }

    public double currentInventoryCapacity() {
        return carryingCapacity - encumbrance;
    }

public static <T> T operator(Operation<T> function, T value1, T value2) {
        return function.operate(value1, value2);
}

    public void currentInventoryEncumbrance() {
        encumbrance = 0;
        inventory.forEach(o -> encumbrance += o.totalWeight());
    }

    public void obtainItem(Item item) {
        if (item.totalWeight() > currentInventoryCapacity()) {
            System.out.println("Inventory full");
            return;
        }
        if (inventory.contains(item)) {
            Item existingItem = inventory.get(inventory.indexOf(item));
            existingItem.setQuantity(existingItem.quantity() + item.quantity());
        } else {
            inventory.add(item);
        }
        currentInventoryEncumbrance();
    }

    public void disposeItem(Item item) throws IndexOutOfBoundsException {
        inventory.removeIf(o ->
                o.name().equals(item.name()) &&
                o.quantity() <= item.quantity());

        try { inventory.get(inventory.indexOf(item)).setQuantity(-item.quantity()); }
        catch (Exception ignored) {}

        currentInventoryEncumbrance();
    }

    public void printInventory() {

        inventory.sort(Comparator.comparing(Item::weight));
        inventory.forEach(System.out::println);
        System.out.println();
        inventory.sort(Comparator.comparing(Item::name));
        inventory.forEach(System.out::println);
    }
}

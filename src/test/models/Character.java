package test.models;

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
        equipment.remove(item);

        switch (item.getBonusType()) {
            case DAMAGE -> this.damage     -= item.getBonusValue();
            case ARMOR  -> this.armor      -= item.getBonusValue();
            case HEALTH -> this.maxHealth  -= item.getBonusValue();
        }
    }

    public double currentInventoryCapacity() {
        return carryingCapacity - encumbrance;
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
        encumbrance = inventory.get(inventory.indexOf(item)).totalWeight();
    }

    public void disposeItem(Item item) {
        if (! inventory.contains(item)) {
            return;
        }
//        Item existingItem = inventory.get(inventory.indexOf(item));
        inventory.removeIf(o -> o.equals(item));
    }

    public void printInventory() {

        inventory.sort(Comparator.comparing((Item o) -> Double.valueOf(o.weight())));
        inventory.forEach(System.out::println);
        System.out.println();
        inventory.sort(Comparator.comparing((Item o) -> o.name()));
        inventory.forEach(System.out::println);
    }
}

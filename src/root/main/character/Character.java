package root.main.character;

import root.main.items.Item;

import java.util.ArrayList;

public class Character {
    /*
    Defines a character with basic stats
        - name
        - health
        - capacity
        - inventory
     */
    private final String name;

    private int     health;
    private double  carryingCapacity;
    private double  encumbrance;

    private final ArrayList<Item.Stack> inventory;

    public Character(String name, int health, double carryingCapacity) {
        this.name               = name;
        this.health             = health;
        this.carryingCapacity   = carryingCapacity;
        this.encumbrance        = 0;
        this.inventory          = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", carryingCapacity=" + carryingCapacity +
                ", encumbrance=" + encumbrance +
                ", inventory=" + inventory.toString() +
                '}';
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getRemainingCapacity() {
        return carryingCapacity - encumbrance;
    }

    public void addItemStack(Item item, int quantity) {
        Item.Stack newStack = new Item.Stack(item, quantity);
        double stackWeight = newStack.getStackWeight();

        // Check for available space
        if (newStack.getStackWeight() > getRemainingCapacity()) {
            // Not enough space in inventory, return from method
            System.out.println("Inventory full");
            return;

        } else {
            // Enough space in inventory, proceed to add item stack
            System.out.printf("< + > %s [%d]%n", item, quantity);
            encumbrance += stackWeight;
        }

        // Search inventory for existing stack
        for (Item.Stack existingStack : inventory) {
            if (existingStack.getItemName().equalsIgnoreCase(newStack.getItemName())) {
                // Add new quantity to existing stack
                // and return from method
                existingStack.add(quantity);
                return;
            }
        }
        // When no existing stack is found, add new stack
        inventory.add(newStack);
    }

    public void removeItemStack(Item item, int quantity) {
        Item.Stack newStack = new Item.Stack(item, quantity);
        double stackWeight = newStack.getStackWeight();

        // Search inventory for existing stack and check available quantity
        for (Item.Stack existingStack : inventory) {
            if (existingStack.getItemName().equalsIgnoreCase(newStack.getItemName()) &&
                existingStack.getQuantity() >= quantity) {

                // Remove selected quantity from stack
                System.out.printf("< - > %s [%d]%n", item, quantity);
                encumbrance -= stackWeight;
                existingStack.take(quantity);

                // When stack quantity reaches 0, remove stack entirely
                if (existingStack.getQuantity() == 0) {
                    inventory.remove(existingStack);
                }

                break;
            }
        }
    }

    public void consumeItem(String itemName) {
        
    }
}

package root.main.items;

import root.main.modifiers.Consumable;
import root.main.modifiers.Stats;
import root.main.character.Character;

import java.util.ArrayList;
import java.util.List;



public class Potion extends Item implements Consumable {



    public Potion(String name, double weight, Stats stat) {
        super(name, weight);
    }

    @Override
    public void modifyStat(Character character, Stats stat, double value) {
        switch (stat) {
            case HEALTH -> character.setHealth(
                    character.getHealth() + (int) value);
            case CARRYING_CAPACITY -> character.setCarryingCapacity(
                    character.getCarryingCapacity() + value);
        }
    }

    public static class Collection {
        public static final List<Item> potionList = new ArrayList<>();

        public Collection() { addItems(); }

        public static void addItems() {
            potionList.add(new Potion("Health potion", 0.5, Stats.HEALTH));
            potionList.add(new Potion("Feather potion", 0.5, Stats.CARRYING_CAPACITY));
        }

        @Override
        public String toString() {
            return "Potions" + List.of(potionList);
        }

        public static Item getItem(String name) {
            for (Item item : potionList) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
            return null;
        }
    }
}
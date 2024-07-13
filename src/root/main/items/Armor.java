package root.main.items;

import java.util.ArrayList;
import java.util.List;

public class Armor extends Item {

    public Armor(String name, double weight) {
        super(name, weight);
    }

    public static class Collection {
        public static final List<Item> armorList = new ArrayList<>();

        public Collection() {addItems();}

        public static void addItems() {
            armorList.add(new Armor("Harness", 1.5));
            armorList.add(new Armor("Chain mail", 3));
        }

        @Override
        public String toString() {
            return "Armors" + List.of(armorList);
        }

        public static Item getItem(String name) {
            for (Item item : armorList) {
                if (name.equalsIgnoreCase(item.getName())) {
                    return item;
                }
            }
            return null;
        }
    }
}

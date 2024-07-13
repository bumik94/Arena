package root.main.items;

import java.util.ArrayList;
import java.util.List;

public class Equipment extends Item {

    public Equipment(String name, double weight) {
        super(name, weight);
    }

    public static class Collection {
        public static final List<Item> equipmentList = new ArrayList<>();

        public Collection() { addItems(); }

        public static void addItems() {
            equipmentList.add(new Equipment("Dagger", 1.5));
            equipmentList.add(new Equipment("Sword", 3));
            equipmentList.add(new Equipment("Harness", 1.5));
            equipmentList.add(new Equipment("Chain mail", 3));
        }

        @Override
        public String toString() {
            return "Equipment" + List.of(equipmentList);
        }

        public static Item getItem(String name) {
            for (Item item : equipmentList) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
            return null;
        }
    }
}
package root.main.items;

import java.util.ArrayList;
import java.util.List;

public class Weapons extends Item {

    public Weapons(String name, double weight) {
        super(name, weight);
    }

    public static class Collection {
        public static final List<Item> weaponList = new ArrayList<>();

        public Collection() {addItems();}

        public static void addItems() {
            weaponList.add(new Weapons("Dagger", 1.5));
            weaponList.add(new Weapons("Sword", 3));
        }

        @Override
        public String toString() {
            return "Weapons" + List.of(weaponList);
        }

        public static Item getItem(String name) {
            for (Item item : weaponList) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
            return null;
        }
    }
}

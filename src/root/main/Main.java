package root.main;

import root.main.character.Character;
import root.main.items.Equipment;
import root.main.items.Potion;

public class Main {

    public static void main(String[] args) {

        new Potion.Collection();

        Character player = new Character(
                "Olaf", 10, 50);
        System.out.println(player);

        player.addItemStack(
                Potion.Collection.getItem("health potion"), 10);
        System.out.println(player);

    }
}

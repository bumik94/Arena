package test;

import test.items.Armory;
import test.models.Character;
import test.items.MainHand;
import test.models.Equipable;

public class Main {

    public static void main(String[] args) {

        Character player = new Character(
                "Olaf",
                10,
                20);

        player.equipItem(new MainHand(
                "Dagger",
                1.5,
                1));

        System.out.println(player);
    }
}

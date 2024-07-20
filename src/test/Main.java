package test;

import test.items.MainHand;
import test.models.Character;

public class Main {

    public static void main(String[] args) {

        Character player = new Character("Olaf");

        System.out.println(player);

        player.obtainItem(new MainHand(
                "Sword",
                5,
                5,
                2));

        System.out.println(player);

        player.obtainItem(new MainHand(
                "Dagger",
                12,
                2));

        System.out.println(player);

        player.obtainItem(new MainHand(
                "Axe",
                8,
                4,
                2));

        System.out.println(player);

        player.obtainItem(new MainHand(
                "Mace",
                3,
                4,
                2));

        System.out.println(player);

        player.printInventory();
        System.out.println();
        player.disposeItem(new MainHand(
                "Sword",
                21,
                5,
                2));

        player.printInventory();

        System.out.println(player);
//
//        player.equipItem(new MainHand(
//                "Sword",
//                4,
//                2));
//
//        player.equipItem(new OffHand(
//                "Shield",
//                2,
//                1));
//
//        player.equipItem(new Body(
//                "Armor",
//                10,
//                5));
//
//        System.out.println(player);
//
//        player.unequipItem(new MainHand(
//                "Sword",
//                4,
//                2));
//
//        player.unequipItem(new OffHand(
//                "Shield",
//                2,
//                1));
//
//        player.unequipItem(new Body(
//                "Armor",
//                10,
//                5));
//
//        System.out.println(player);
    }
}

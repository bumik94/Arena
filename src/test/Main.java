package test;

import test.items.Body;
import test.items.MainHand;
import test.models.Character;
import test.items.OffHand;

public class Main {

    public static void main(String[] args) {

        Character player = new Character("Olaf");

        System.out.println(player);

        player.obtainItem(new MainHand(
                "Sword",
                4,
                2));

        System.out.println(player);

        player.obtainItem(new MainHand(
                "Sword",
                4,
                2));

        System.out.println(player);

        player.obtainItem(new MainHand(
                "Sword",
                4,
                4,
                2));

        System.out.println(player);

        player.obtainItem(new MainHand(
                "Sword",
                4,
                4,
                2));

        System.out.println(player);

        player.obtainItem(new MainHand(
                "Sword",
                4,
                4,
                2));

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

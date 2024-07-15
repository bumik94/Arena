package test.items;

import test.models.Equipable;

import java.util.ArrayList;
import java.util.List;

public record Armory() {

    static List<MainHand> mainHands = new ArrayList<>(List.of(
            new MainHand("Dagger",1.5,1),
            new MainHand("Sword", 3, 2),
            new MainHand("Axe", 3, 2))
    );
}

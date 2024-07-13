package root.main.modifiers;

import root.main.character.Character;

public interface Consumable {

    void modifyStat(Character character, Stats stat, double value);
}

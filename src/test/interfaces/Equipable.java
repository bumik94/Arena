package test.interfaces;

public interface Equipable {
    enum EquipSlot {
        MAIN_HAND,
        OFF_HAND,
        BODY
    }

    enum StatBonus {
        HEALTH,
        DAMAGE,
        ARMOR
    }

    int getSlotOrdinal();

    StatBonus getBonusType();

    int getBonusValue();
}


package test.models;

public interface Equipable {
    public enum EquipSlot {
        MAIN_HAND,
        OFF_HAND,
        BODY;

    }

    EquipSlot getSLOT();
}


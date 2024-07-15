package test.items;

import test.models.Equipable;
import test.models.Item;

public class MainHand extends Item implements Equipable {
    private final EquipSlot SLOT;
    private final int damage;

    public MainHand(String name, double weight, int damage) {
        super(name, weight);
        this.damage = damage;
        this.SLOT = EquipSlot.MAIN_HAND;
    }

    public EquipSlot getSLOT() {
        return SLOT;
    }

    @Override
    public String toString() {
        return String.format("'%s'\t <] %d [>\t |%.2f|", super.name(), damage, super.weight());
    }
}

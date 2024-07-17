package test.items;

import test.models.Equipable;
import test.models.Item;

import java.util.Objects;

public class OffHand extends Item implements Equipable {
    private final EquipSlot slot;
    private final StatBonus bonusType;
    private final int       bonusValue;

    public OffHand(String name, double weight, int bonusValue) {
        super(name, weight);
        this.slot       = EquipSlot.OFF_HAND;
        this.bonusType  = StatBonus.ARMOR;
        this.bonusValue = bonusValue;
    }

    public OffHand(String name, double weight, int bonusValue, EquipSlot slot, StatBonus bonusType) {
        super(name, weight);
        this.slot       = slot;
        this.bonusType  = bonusType;
        this.bonusValue = bonusValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OffHand offHand)) return false;
        return slot == offHand.slot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), slot);
    }

    public int getSlotOrdinal() {
        return slot.ordinal();
    }

    @Override
    public StatBonus getBonusType() {
        return bonusType;
    }

    @Override
    public int getBonusValue() {
        return bonusValue;
    }

    @Override
    public String toString() {
        return String.format("'%s' >%d< (%.2f)", super.name(), getBonusValue(), super.weight());
    }

    public OffHand item() {
        return this;
    }
}

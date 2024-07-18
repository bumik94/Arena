
package test.models;

public class ItemStack<T extends Item> {
    private final T item;

    private int quantity;

    public ItemStack(T item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }

    public T getItem() {
        return item;
    }
}

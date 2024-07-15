
package test.models;

public class Stack <T extends Item> {
    private final T stack;

    private int quantity;

    public Stack(T stack, int quantity) {
        this.stack = stack;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stack=" + stack +
                ", quantity=" + quantity +
                '}';
    }

    public T getStack() {
        return stack;
    }
}

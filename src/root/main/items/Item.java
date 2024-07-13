package root.main.items;

public abstract class Item{

    private final String name;
    private final double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public static class Stack{
        private final Item item;

        private int     quantity;
        private double  stackWeight;

        public Stack(Item item, int quantity) {
            this.item = item;
            this.quantity = quantity;
            this.stackWeight = getStackWeight();
        }

        @Override
        public String toString() {
            return "Stack{" + item +
                    ", quantity=" + quantity +
                    ", stackWeight=" + stackWeight +
                    '}';
        }

        public String getItemName() {
            return item.getName();
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getStackWeight() {
            return item.getWeight() * quantity;
        }

        public void setStackWeight(double stackWeight) {
            this.stackWeight = stackWeight;
        }

        // Add stack to inventory
        public void add(int quantity) {
            setQuantity(getQuantity() + quantity);
            setStackWeight(getStackWeight());
        }

        // Take stack from inventory
        public void take(int quantity) {
            setQuantity(getQuantity() - quantity);
            setStackWeight(getStackWeight());
        }
    }
}


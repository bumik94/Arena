package test.models;

public abstract class Item {
    private final String name;
    private final double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%s (wgt %.2f)", name, weight);
//        return "Item{" +
//                "name='" + name + '\'' +
//                ", weight=" + weight +
//                '}';
    }

    public String name() {
        return name;
    }

    public double weight() {
        return weight;
    }
}

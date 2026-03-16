package kz.rpg.save;

import java.io.Serializable;

public class Item implements Serializable {

    private static final long serialVersionUID = 1l;

    private String name;
    private String type;
    private double weight;
    private int value;

    public Item(String name, String type, double weight, int value) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " [" + type + ", " + weight + " кг, " + value + " золота]";
    }
}

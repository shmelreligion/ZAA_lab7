package kz.rpg.save;

import java.io.Serializable;

public class Stats implements Serializable {

    private static final long serialVersionUID = 1L;

    private int strength;
    private int agility;
    private int intelligence;

    public Stats(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getSummary() {
        return strength + agility + intelligence;
    }

    @Override
    public String toString() {
        return "Сила = " + strength + ", Ловкость = " + agility + ", Интеллект = " + intelligence;
    }
}
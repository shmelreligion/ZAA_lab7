package kz.rpg.save;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameCharacter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int level;
    private double health;
    private transient String sessionToken; // не сохраняется
    private String guild;
    private Stats stats;
    private List<Item> inventory;

    public GameCharacter(String name, int level, double health) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.sessionToken = "TOKEN_" + System.nanoTime();
        this.guild = "Без гильдии";
        this.inventory = new ArrayList<>();
    }

    public GameCharacter(String name, int level, double health, Stats stats) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.stats = stats;
        this.sessionToken = "TOKEN_" + System.nanoTime();
        this.guild = "Без гильдии";
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getHealth() {
        return health;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public String getGuild() {
        return guild;
    }

    public Stats getStats() {
        return stats;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "Герой: " + name +
                ", уровень: " + level +
                ", HP: " + health +
                ", гильдия: " + guild +
                ", статистика: " + stats +
                ", инвентарь: " + inventory;
    }
}
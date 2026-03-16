package kz.rpg.save;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1: сохранение одного героя");
        GameCharacter hero1 = new GameCharacter("Артур", 15, 240);
        SaveGame.save(hero1);
        GameCharacter restoredHero1 = SaveGame.load();

        if (restoredHero1 != null) {
            boolean same = hero1.getName().equals(restoredHero1.getName())
                    && hero1.getLevel() == restoredHero1.getLevel()
                    && hero1.getHealth() == restoredHero1.getHealth();

            System.out.println("[ПРОВЕРКА] Данные совпадают: " + same);
        }

        System.out.println("\n Задание 2: transient поле");
        GameCharacter hero2 = new GameCharacter("Ланселот", 18, 300.0);
        System.out.println("До сохранения sessionToken: " + hero2.getSessionToken());

        SaveGame.save(hero2);
        GameCharacter restoredHero2 = SaveGame.load();

        if (restoredHero2 != null) {
            System.out.println("После загрузки sessionToken: " + restoredHero2.getSessionToken());
            System.out.println("[ПРОВЕРКА] session token == null: " + (restoredHero2.getSessionToken() == null));
        }

        System.out.println("\n Задание 3: список персонажей");
        List<GameCharacter> party = new ArrayList<>();
        party.add(new GameCharacter("Артур", 15, 240.5));
        party.add(new GameCharacter("Мерлин", 20, 180.0));
        party.add(new GameCharacter("Гавейн", 17, 260.0));
        party.add(new GameCharacter("Персиваль", 16, 230.0));

        SaveGameList.saveList(party);
        List<GameCharacter> restoredParty = SaveGameList.loadlist();

        if (restoredParty != null) {
            System.out.println("Персонажи после загрузки: ");
            for (GameCharacter hero : restoredParty) {
                System.out.println(hero);
            }
            System.out.println("[ПРОВЕРКА] Размер списка совпадает: " + (party.size() == restoredParty.size()));
        }

        System.out.println("\n Задание 4 и 5: инвентарь + статистика");
        Stats stats = new Stats(25, 18, 30);
        GameCharacter hero3 = new GameCharacter("Артур Пендрагон", 20, 350.0, stats);

        hero3.addItem(new Item("Экскалибур", "Оружие", 4.0, 1000));
        hero3.addItem(new Item("Зелье ярости", "Зелье", 0.2, 80));
        hero3.addItem(new Item("Кольчуга", "Броня", 8.0, 600));

        SaveGame.save(hero3);
        GameCharacter restoredHero3 = SaveGame.load();

        if (restoredHero3 != null) {
            System.out.println("Загруженный герой: ");
            System.out.println(restoredHero3);

            System.out.println("[ПРОВЕРКА] Количество предметво совпадает: "
                    + (hero3.getInventory().size() == restoredHero3.getInventory().size()));

            System.out.println("[ПРОВЕРКА] Статистика совпадает: "
                    + (hero3.getStats().getSummary() == restoredHero3.getStats().getSummary()));
        }
    }
}

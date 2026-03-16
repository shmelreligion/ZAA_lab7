package kz.rpg.save;

import java.io.*;

public class SaveGame {

    public static void save(GameCharacter hero) {
        try {
            new File("saves").mkdir();

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("saves/hero.ser")
            );

            oos.writeObject(hero);
            oos.close();

            System.out.println("[СОХРАНЕНИЕ] Герой сохранен: " + hero);
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении героя: " + e.getMessage());
        }
    }

    public static GameCharacter load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("saves/hero.ser")
            );

            GameCharacter hero = (GameCharacter) ois.readObject();
            ois.close();

            System.out.println("[ЗАГРУЗКА] Герой загружен: " + hero);
            return hero;
        } catch (Exception e) {
            System.out.println("Ошибка при загрузке героя: " + e.getMessage());
            return null;
        }
    }
}

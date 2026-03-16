package kz.rpg.save;

import java.io.*;
import java.util.List;

public class SaveGameList {

    public static void saveList(List<GameCharacter> party) {
        try {
            new File("saves").mkdir();

            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("saves/party.ser")
            );

            oos.writeObject(party);
            oos.close();

            System.out.println("[СОХРАНЕНИЕ СПИСКА] Отряд сохранен: ");
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении списка: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<GameCharacter> loadlist() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("saves/party.ser")
            );

            List<GameCharacter> party = (List<GameCharacter>) ois.readObject();
            ois.close();

            System.out.println("[ЗАГРУЗКА СПИСКА] Отряд загружен: ");
            return party;
        } catch (Exception e) {
            System.out.println("Ошибка при загрузке списка: " + e.getMessage());
            return null;
        }
    }
}

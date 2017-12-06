package Logic;

import java.io.*;

public class SaveLoader {
    public static void save() throws IOException {
        try(ObjectOutputStream saveOS = new ObjectOutputStream(new FileOutputStream("Snake\\src\\saves\\save.txt"))) {
            saveOS.writeObject(new GameSave());
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream loadIS = new ObjectInputStream(new FileInputStream("Snake\\src\\saves\\save.txt"))){
            GameSave gameSave = (GameSave) loadIS.readObject();
            Main.field = gameSave.field;
            Main.snake = gameSave.snake;
            Main.direction = gameSave.direction;
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}

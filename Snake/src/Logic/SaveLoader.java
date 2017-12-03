package Logic;

import java.io.*;

public class SaveLoader {
    public static void save() throws IOException {
        FileOutputStream saveOutputStream = null;
        ObjectOutputStream saveOS = null;
        try {
            saveOutputStream = new FileOutputStream("Snake\\src\\saves\\save.txt");
            saveOS = new ObjectOutputStream(saveOutputStream);
            saveOS.writeObject(new GameSave());
        } finally {
            saveOS.close();
            saveOutputStream.close();
        }
    }

    public static void load() throws IOException, ClassNotFoundException {
        FileInputStream loadInputStream = null;
        ObjectInputStream loadIS = null;
        try {
            loadInputStream = new FileInputStream("Snake\\src\\saves\\save.txt");
            loadIS = new ObjectInputStream(loadInputStream);
            GameSave gameSave = (GameSave) loadIS.readObject();
            Main.field = gameSave.field;
            Main.snake = gameSave.snake;
            Main.direction = gameSave.direction;
        } finally {
            loadIS.close();
            loadInputStream.close();
        }
    }
}

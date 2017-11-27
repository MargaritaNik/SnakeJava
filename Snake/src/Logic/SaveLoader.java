package Logic;

import java.io.*;

public class SaveLoader {
    public static void save() throws IOException {
        FileOutputStream fieldOutputStream = new FileOutputStream("Snake\\src\\saves\\field.txt");
        FileOutputStream snakeOutputStream = new FileOutputStream("Snake\\src\\saves\\snake.txt");
        FileOutputStream directionOutputStream = new FileOutputStream("Snake\\src\\saves\\direction.txt");

        ObjectOutputStream fieldOS = new ObjectOutputStream(fieldOutputStream);
        ObjectOutputStream snakeOS = new ObjectOutputStream(snakeOutputStream);
        ObjectOutputStream directionOS = new ObjectOutputStream(directionOutputStream);

        fieldOS.writeObject(Main.field);
        snakeOS.writeObject(Main.snake);
        directionOS.writeObject(Main.direction);

        fieldOS.flush();
        snakeOS.flush();
        directionOS.flush();

        fieldOS.close();
        snakeOS.close();
        directionOS.close();

        fieldOutputStream.close();
        snakeOutputStream.close();
        directionOutputStream.close();
    }

    public static void load() throws IOException, ClassNotFoundException {
        FileInputStream fieldInputStream = new FileInputStream("Snake\\src\\saves\\field.txt");
        FileInputStream snakeInputStream = new FileInputStream("Snake\\src\\saves\\snake.txt");
        FileInputStream directionInputStream = new FileInputStream("Snake\\src\\saves\\direction.txt");

        ObjectInputStream fieldIS = new ObjectInputStream(fieldInputStream);
        ObjectInputStream snakeIS = new ObjectInputStream(snakeInputStream);
        ObjectInputStream directionIS = new ObjectInputStream(directionInputStream);

        Main.field = (Field)fieldIS.readObject();
        Main.snake = (Snake)snakeIS.readObject();
        Main.direction = (Direction)directionIS.readObject();

        fieldIS.close();
        snakeIS.close();
        directionIS.close();

        fieldInputStream.close();
        snakeInputStream.close();
        directionInputStream.close();
    }
}

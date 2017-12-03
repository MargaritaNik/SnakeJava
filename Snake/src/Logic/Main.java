package Logic;

import GUI.Frame;
import GUI.GameWindow;
import GUI.Sound;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {
    static public Direction direction = Direction.RIGHT;
    static public Field field = new Field();
    static public Snake snake = new Snake();
    static GameWindow gameWindow = new GameWindow();

    public static void main(String[] args) throws InterruptedException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new Frame(gameWindow);
                frame.setTitle("Logic.Snake");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        gameWindow.addKeyListener(new KeyControl());
        gameWindow.setFocusable(true);
        Sound.playSound("Snake\\src\\music\\music.wav").play();
        field.addRandomFruit(snake);
        while (true) {
                makeTurn();
        }
    }

    public static void makeTurn() throws InterruptedException {
        if (snake.getIsAlive()){
            gameWindow.repaint();
            Move.move(field, snake, direction);
            TimeUnit.MILLISECONDS.sleep(500);
        }
        else
            gameWindow.paintGameOver();
    }

}
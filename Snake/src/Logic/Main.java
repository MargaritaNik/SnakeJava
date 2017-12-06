package Logic;

import GUI.Frame;
import GUI.GameWindow;
import GUI.Sound;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    static public Direction direction = Direction.RIGHT;
    static public Field field = new Field();
    static public Snake snake = new Snake();
    static private GameWindow gameWindow = new GameWindow();
    static Sound gameSound = new Sound(new File("Snake\\src\\music\\tetris.wav"));
    static Sound gameOverSound = new Sound(new File("Snake\\src\\music\\game_over.wav"));
    static Sound eatSound = new Sound(new File("Snake\\src\\music\\sonic_ring.wav"));

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
        gameSound.play();
        field.addRandomFruit(snake);
        Timer timer = new Timer(100, e -> makeTurn());
        timer.start();
    }

    private static void makeTurn() {
        if (snake.getIsAlive()) {
            if (!gameSound.isPlaying())
                gameSound.play();
            gameWindow.repaint();
            Move.move(field, snake, direction);
        } else {
            if (!gameOverSound.isPlaying())
                gameOverSound.play();
            gameWindow.paintGameOver();
        }
    }

}
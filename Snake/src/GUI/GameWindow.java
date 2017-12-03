package GUI;

import Logic.*;
import Logic.Point;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameWindow extends JComponent{
    public static final int DEFAULT_WEIGHT = 600;
    public static final int DEFAULT_HEIGHT = 600;

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WEIGHT, DEFAULT_HEIGHT);
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int x = 0; x < 20; x++)
            for (int y = 0; y < 20; y++)
                paintCell(Move.search(Main.field, Main.snake, new Logic.Point(x, y)), graphics2D, x, y);
        paintHead(graphics2D, Main.snake.getSnakeHead().position);
    }

    public void paintCell(MapObject object, Graphics2D graphics2D, int x, int y){
        Visitor visitor = new Visitor(graphics2D, new Point(x, y));
        object.accept(visitor);
    }

    public void paintHead(Graphics2D graphics2D, Point head){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Snake\\src\\images\\head.png"));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        graphics2D.drawImage(img, head.x*30, 570 - head.y*30, 30, 30, this);
    }

    public void paintGameOver(){
        Graphics graphics = getGraphics();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Snake\\src\\images\\game_over.jpg"));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        graphics.drawImage(img, 0, 0, 600, 600, this);
    }
}
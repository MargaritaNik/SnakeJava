package GUI;

import javax.swing.*;

public class Frame extends JFrame{
    public Frame(GameWindow gameWindow){
        add(gameWindow);
        pack();
    }
}

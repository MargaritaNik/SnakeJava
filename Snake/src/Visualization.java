import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Visualization extends JPanel {
    private static final HashMap<Class, Color> objectColor = new HashMap<>();
    static
    {
        objectColor.put(Fruit.class, Color.RED);
        objectColor.put(Wall.class, Color.GRAY);
        objectColor.put(SnakePart.class, Color.GREEN);
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Field {

    private int size = 30;

    public int getSize() {
        return size;
    }

    public Map<Point, Type> stateCell = new HashMap<Point, Type>();

    public Field() {
        for (int x = 0; x < size; x++) {
            stateCell.put(new Point(x, 0), Type.WALL);
            stateCell.put(new Point(x, size - 1), Type.WALL);
        }

        for (int y = 0; y < size; y++) {
            stateCell.put(new Point(0, y), Type.WALL);
            stateCell.put(new Point(size - 1, y), Type.WALL);
        }
    }

    public Point randomMeanings() {
        Random random = new Random();
        return new Point(random.nextInt(size), random.nextInt(size));
    }

    public void addFruit(Snake snake) {
        boolean pointInStateCell = false;
        do {
            Point point = randomMeanings();
            if (!(stateCell.containsKey(point) || snake.snake.contains(point))) {
                stateCell.put(point, Type.FRUIT);
                pointInStateCell = true;
            }
        }
        while (pointInStateCell);
    }
}




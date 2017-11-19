import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Field {

    private int size = 20;

    public int getSize() {
        return size;
    }

    private Map<Point, MapObject> stateCell = new HashMap<Point, MapObject>();

    public Field() {
        for (int x = 0; x < size; x++) {
            stateCell.put(new Point(x, 0), new Wall(new Point(x, 0)));
            stateCell.put(new Point(x, size - 1), new Wall(new Point(x, size - 1)));
        }

        for (int y = 0; y < size; y++) {
            stateCell.put(new Point(0, y), new Wall(new Point(0, y)));
            stateCell.put(new Point(size - 1, y), new Wall(new Point(size - 1, y)));
        }
    }

    public Field(int size) {
        for (int x = 0; x < size; x++) {
            stateCell.put(new Point(x, 0), new Wall(new Point(x, 0)));
            stateCell.put(new Point(x, size - 1), new Wall(new Point(x, size - 1)));
        }

        for (int y = 0; y < size; y++) {
            stateCell.put(new Point(0, y), new Wall(new Point(0, y)));
            stateCell.put(new Point(size - 1, y), new Wall(new Point(size - 1, y)));
        }
    }

    public void addRandomFruit(Snake snake) {

        boolean pointInStateCell = true;

        do {
            Point newRandomPoint = getRandomPointInSize();
            if (!stateCell.containsKey(newRandomPoint) && snake.objectSearch(newRandomPoint) == MapObject.EmptyObject) {
                stateCell.put(newRandomPoint, new Fruit(50, newRandomPoint));
                pointInStateCell = false;
            }

            if (snake.getSnakeSize() + stateCell.size() == size * size)
                pointInStateCell = false;
        } while (pointInStateCell);
    }

    public void deleteFruit(Fruit fruit) {
        stateCell.remove(fruit.position, fruit);
    }

    public Point getRandomPointInSize() {
        Random random = new Random();
        return new Point(random.nextInt(size), random.nextInt(size));
    }

    public void remove(Point point) {
        if (stateCell.containsKey(point))
            stateCell.remove(point);
    }

    public void add(Point point, MapObject object) {
        stateCell.put(point, object);
    }

    public boolean contains(Point point) {
        return stateCell.containsKey(point);
    }

    public MapObject get(Point point) {
        if (contains(point))
            return stateCell.get(point);
        return MapObject.EmptyObject;
    }
}

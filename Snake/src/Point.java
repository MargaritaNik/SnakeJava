import java.util.Random;

public class Point {
    private final int x;
    private final int y;
    public static final Point Zero = new Point(0, 0);

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point add(Point term) {
        return new Point(this.x + term.x, this.y + term.y);
    }

    public static Point getRandomPointInSize(int size){
        Random random = new Random();
        return new Point(random.nextInt(size), random.nextInt(size));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

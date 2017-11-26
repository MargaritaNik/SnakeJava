package Logic;

import java.io.Serializable;

public class Point implements Serializable{
    public final int x;
    public final int y;
    public static final Point Zero = new Point(0, 0);

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point add(Point term) {
        return new Point(this.x + term.x, this.y + term.y);
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

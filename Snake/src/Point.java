import java.util.Random;

public class Point {
    private int x;

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

    private int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setX(int x){ this.x = x; }

    public void setY(int y){ this.y = y; }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Point add(Point term){
        return new Point(this.x + term.x, this.y + term.y);
    }
}

import java.awt.Color;

public interface MapObject {
    MapObject EmptyObject = new MapObject() {
        public void moveToThisObject(Snake snake, Field field) {}
        public Color getColor(){return null;}
    };

    void moveToThisObject(Snake snake, Field field);

    Color getColor();
}

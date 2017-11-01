public interface MapObject {
    MapObject Empty = (snake, field) -> {};
    void moveToThisObject(Snake snake, Field field);
}

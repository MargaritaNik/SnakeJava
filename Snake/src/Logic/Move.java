package Logic;

public class Move {

    public static void move(Field field, Snake snake, Direction direction) {
        snake.setCurrentDirection(direction);
        Point headCoordinate = getNextCoordinate(snake, field);
        MapObject mapObject = Move.search(field, snake, headCoordinate);

        mapObject.moveToThisObject(snake, field);
        snake.move(snake.getCurrentDirection(), field.getSize());
        if (snake.getIsFull()) {
            snake.addToTail(snake.snakeTail.position);
            snake.setFull(false);
        }
    }

    public static MapObject search(Field field, Snake snake, Point point){
        if (field.contains(point))
            return field.get(point);
        return snake.objectSearch(point);
    }

    public static Point getNextCoordinate(Snake snake, Field field){
        Point headCoordinate = snake.getSnakeHead().position;
        headCoordinate = headCoordinate.add(snake.getCurrentDirection().getShift());
        if (headCoordinate.x == -1)
            headCoordinate = new Point(field.getSize() - 1, headCoordinate.y);
        if (headCoordinate.y == -1)
            headCoordinate = new Point(headCoordinate.x, field.getSize() - 1);
        return new Point(headCoordinate.x % field.getSize(), headCoordinate.y % field.getSize());
    }
}

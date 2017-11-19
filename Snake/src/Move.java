public class Move {

    public static void move(Field field, Snake snake, Direction direction) {
        Point headCoordinate = snake.getSnakeHead().position;
        snake.setCurrentDirection(direction);
        headCoordinate = headCoordinate.add(snake.getCurrentDirection().getShift());
        MapObject mapObject = Move.search(field, snake, headCoordinate);

        mapObject.moveToThisObject(snake, field);
        snake.move(snake.getCurrentDirection());
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
}

public class Move {

    public static void move(Field field, Snake snake, Direction changeDirection) {
        Point headCoordinate = snake.snake.getLast().coordinate;
        headCoordinate = headCoordinate.add(changeDirection.getShift());
        MapObject mapObject = Move.searchObject(field, snake, headCoordinate);

        if (snake.getIsFull()) {
            snake.addToTail(snake.snakeTail.coordinate);
            snake.setFull(false);
        }

        if (mapObject != null)
            mapObject.moveToThisObject(snake);

        snake.move(changeDirection);

        if (snake.getIsFull())
            field.addRandomFruit(snake);
    }

    public static MapObject searchObject(Field field, Snake snake, Point point){
        if (field.stateCell.containsKey(point))
            return field.stateCell.get(point);
        return snake.pointSearch(point);
    }
}

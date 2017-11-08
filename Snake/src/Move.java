public class Move {

    public static void move(Field field, Snake snake) {
        Point headCoordinate = snake.snake.getLast().position;
        headCoordinate = headCoordinate.add(snake.getCurrentDirection().getShift());
        MapObject mapObject = Move.searchObject(field, snake, headCoordinate);

        if (snake.getIsFull()) {
            snake.addToTail(snake.snakeTail.position);
            snake.setFull(false);
        }

        if (mapObject != null)
            mapObject.moveToThisObject(snake);

        snake.move();

        if (snake.getIsFull())
            field.addRandomFruit(snake);
    }

    public static MapObject searchObject(Field field, Snake snake, Point point){
        if (field.stateCell.containsKey(point))
            return field.stateCell.get(point);
        return snake.objectSearch(point);
    }
}

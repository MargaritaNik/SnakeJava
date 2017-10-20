public class Move{
    static boolean fruiteIsEaten = false;
    static Point tail;

    public static void move(Field field, Snake snake, Direction changeDir) throws Exception{
        Point headCoordination = snake.snake.getLast();
        headCoordination = headCoordination.add(changeDir.getShift());

        if (field.stateCell.containsKey(headCoordination) && ((field.stateCell.get(headCoordination)).equals(Type.WALL) ||
                (field.stateCell.get(headCoordination)).equals(Type.SNAKE)))
            throw new Exception("Snake crashed");

        if(fruiteIsEaten){
            snake.addToTail(tail);
            fruiteIsEaten = false;
        }

        System.out.println(field.stateCell.containsKey(headCoordination));

        if ((field.stateCell.get(headCoordination)).equals(Type.FRUIT)) {
            tail = snake.snake.getFirst();
            fruiteIsEaten = true;
        }

        snake.move(changeDir);
        if (fruiteIsEaten) field.addFruit(snake);

    }
}

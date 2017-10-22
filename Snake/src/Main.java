public class Main {


    static Direction direction = Direction.RIGHT;
    static Field field = new Field();
    static Snake snake = new Snake();

    public static void main(String[] args) {
        while (true) {
            if (!snake.getIsAlive())
                break;
            snake.setCurrentDirection(direction);
            Move.move(field, snake, direction);
        }
    }

}
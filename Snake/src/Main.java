

public class Main {


    static Direction direction = Direction.RIGHT;
    static Field field = new Field();
    static Snake snake = new Snake();


    public static void main(String[] args) {
        while (true)
        {
            snake.setCurrentDirection(direction);
            try {
                Move.move(field,snake, direction);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

public class FieldTests {

    private Field field;

    @Before
    public void initialization() {
        field = new Field();
    }

    @Test
    public void getRandomPointInSizeTest(){
        Point newRandomPoint = field.getRandomPointInSize();
        Assert.assertTrue(newRandomPoint.x < field.getSize() && newRandomPoint.x >= 0);
        Assert.assertTrue(newRandomPoint.y < field.getSize() && newRandomPoint.y >= 0);
    }

    @Test
    public void addRandomFruitTest(){
        Snake snake = new Snake();

    }
}

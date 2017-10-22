import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import static junit.framework.Assert.assertEquals;

public class TestsField {

    private Field field;

    @Before
    public void initialization() {
        field = new Field();
    }

    @Test
    public void getRandomPointInSizeTest(){
        Point newRandomPoint = field.getRandomPointInSize();
        Assert.assertTrue(newRandomPoint.getX() < field.getSize() && newRandomPoint.getX() >= 0);
        Assert.assertTrue(newRandomPoint.getY() < field.getSize() && newRandomPoint.getY() >= 0);
    }

    @Test
    public void addRandomFruitTest(){
        Snake snake = new Snake();

    }
}

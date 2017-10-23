import org.junit.Assert;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class TestsOperations {

    @Test
    public void addPointTest(){
        assertEquals(new Point(4, 7), new Point(2, 3).add(new Point(2, 4)));
    }

    @Test
    public void getShiftTest(){
        assertEquals(new Point(0, 1), Direction.UP.getShift());
        assertEquals(new Point(0, -1), Direction.DOWN.getShift());
        assertEquals(new Point(1, 0), Direction.RIGHT.getShift());
        assertEquals(new Point(-1, 0), Direction.LEFT.getShift());
    }

    @Test
    public void isOppositeTest(){
        Assert.assertTrue(Direction.DOWN.isOpposite(Direction.UP));
        Assert.assertTrue(Direction.LEFT.isOpposite(Direction.RIGHT));
        Assert.assertFalse(Direction.DOWN.isOpposite(Direction.LEFT));
        Assert.assertFalse(Direction.UP.isOpposite(Direction.RIGHT));
    }
}

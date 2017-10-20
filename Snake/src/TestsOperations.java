import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class TestsOperations {
    @Test
    public void checkAdd(){
        assertEquals(new Point(3,5),new Point(1,2).add(new Point(2,3)));
    }
    @Test
    public void checkShift(){
        assertEquals(new Point(0,1), Direction.UP.getShift());
        assertEquals(new Point(0,-1), Direction.DOWN.getShift());
        assertEquals(new Point(1,0), Direction.RIGHT.getShift());
        assertEquals(new Point(-1,0), Direction.LEFT.getShift());
    }
}

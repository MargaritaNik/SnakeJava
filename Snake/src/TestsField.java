import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class TestsField {
    private Field field;
    @Before
    public void initialization(){
        field = new Field();
    }

    @Test
    public void cheakRandom(){
        Point point = field.randomMeanings();
        assertTrue(point.getX() >= 0 && point.getX()< field.getSize() && point.getY() >= 0
                && point.getY()< field.getSize());
    }
}

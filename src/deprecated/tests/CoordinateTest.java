import junit.framework.TestCase;

/**
 * Created by horatiulazu on 2016-12-16.
 */
public class CoordinateTest extends TestCase {
    private final Coordinate TEST_COORDINATE = new Coordinate(3, 4);
    private final Coordinate TEST_REFLECTED_COORDINATE = new Coordinate(3, 4, "10");

    public void testGetX() throws Exception {
        assertEquals(TEST_COORDINATE.getX(), 3);
    }

    public void testGetY() throws Exception {
        assertEquals(TEST_COORDINATE.getY(), 4);
    }

    public void testGetReflectedBinaryCode() throws Exception {
        assertEquals(TEST_REFLECTED_COORDINATE.getReflectedBinaryCode(), "10");
    }

}
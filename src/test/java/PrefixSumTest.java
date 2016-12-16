import junit.framework.TestCase;

/**
 * Created by horatiulazu on 2016-12-16.
 */
public class PrefixSumTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {

    }

    public void testSumRegion() throws Exception {
        int[][] multi = new int[][]{
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        assertEquals("Sum from (0, 0) to (2, 2) should be 3", new PrefixSum(multi).sumRegion(0, 0, 2, 2), 3);
    }

}
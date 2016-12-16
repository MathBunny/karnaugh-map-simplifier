import junit.framework.TestCase;

/**
 * @author Horatiu Lazu
 * @version 1.0
 */
public class PrefixSumTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {}

    /**
     * Test the 2D prefix sum calculations for determining area in a 2D grid in O(N*N) + O(1)*M time, M = queries
     * @throws Exception
     */
    public void testSumRegion() throws Exception {
        final int[][] MULTI_ARRAY = new int[][]{
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        assertEquals("Sum from (0, 0) to (2, 2) should be 3", new PrefixSum(MULTI_ARRAY).sumRegion(0, 0, 2, 2), 3);
        assertEquals("Sum from (0, 1) to (2, 2) should be 2", new PrefixSum(MULTI_ARRAY).sumRegion(1, 0, 2, 2), 2);
        assertEquals("Sum from (0, 2) to (2, 2) should be 1", new PrefixSum(MULTI_ARRAY).sumRegion(2, 0, 2, 2), 1);
        assertEquals("Sum from (1, 2) to (2, 2) should be 1", new PrefixSum(MULTI_ARRAY).sumRegion(2, 1, 2, 2), 1);
        assertEquals("Sum from (9, 3) to (9, 3) should be 0", new PrefixSum(MULTI_ARRAY).sumRegion(3, 9, 3, 9), 0);
    }

}
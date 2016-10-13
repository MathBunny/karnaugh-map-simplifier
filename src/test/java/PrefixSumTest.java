import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * This class tests prefix sum arrays.
 * @author Horatiu Lazu
 */
public class PrefixSumTest {

    @Test
    public void testSumRegion (String [] args) {
        int[][] multi = new int[][]{
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        assertTrue(new PrefixSum(multi).sumRegion(0, 0, 2, 2) == 2); //2
    }
}

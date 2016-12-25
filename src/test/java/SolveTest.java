import junit.framework.TestCase;

import java.util.Arrays;

/**
 * This class tests the solve mechanism.
 * For integration solving, see ContentPanelTest.java
 * @author Horatiu Lazu
 */
public class SolveTest extends TestCase {
    public void testSolveKarnaughMap() throws Exception {
        assert(true);
    }

    public void testSolvingHelper() throws Exception {
        assert(true);
    }

    public void testIsSquared() throws Exception {
        assertTrue(Solve.isSquared(0));
        assertTrue(Solve.isSquared(4));
        assertTrue(Solve.isSquared(1));
        assertFalse(Solve.isSquared(91));
        assertFalse(Solve.isSquared(3));
    }

    public void testConvertIncidenceArray() throws Exception {
        final int [] [] TEST_ANSWER_A = new int[2][2];
        final int [] EMPTY_TRUTH_TABLE = new int [4];

        final int [] FILLED_TRUTH_TABLE = new int [] {1, 1, 1, 1};
        final int [] [] TEST_ANSWER_B = new int[2][2];
        Arrays.fill(TEST_ANSWER_B[0], 1);
        Arrays.fill(TEST_ANSWER_B[1], 1);
        
        assertEquals(Arrays.deepToString(Solve.convertIncidenceArray(EMPTY_TRUTH_TABLE)),
               (Arrays.deepToString(TEST_ANSWER_A)));

        assertEquals(Arrays.deepToString(Solve.convertIncidenceArray(FILLED_TRUTH_TABLE)),
                (Arrays.deepToString(TEST_ANSWER_B)));
    }

    public void testToStringMatrix() throws Exception {
        assert(true);
    }

}
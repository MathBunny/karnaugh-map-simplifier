import junit.framework.TestCase;

/**
 * Created by horatiulazu on 2016-12-16.
 */
public class TruthTableTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testGetInputEquation() throws Exception {
        assertEquals(TruthTable.getInputEquation(0, 2), "A'B'");
        assertEquals(TruthTable.getInputEquation(1, 2), "A'B");
        assertEquals(TruthTable.getInputEquation(2, 2), "AB'");
        assertEquals(TruthTable.getInputEquation(3, 2), "AB");
    }

    public void testLog2() throws Exception {
        assertEquals(TruthTable.log2(2), 2);
        assertEquals(TruthTable.log2(1), 1);
    }

    public void testInitializeTruthTableValues() throws Exception {

    }

    public void testUpdateGivenSOP() throws Exception {

    }

    public void testPopulateMatrix() throws Exception {

    }

}
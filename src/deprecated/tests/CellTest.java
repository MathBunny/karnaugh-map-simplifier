import junit.framework.TestCase;

/**
 * @author Horatiu Lazu
 * @version 1.0
 */
public class CellTest extends TestCase {
    private final Cell CELL_A = new Cell(2, 3, 0);

    public void testGetRow() throws Exception {
        assertEquals(CELL_A.getRow(), 3);
    }

    public void testGetCol() throws Exception {
        assertEquals(CELL_A.getCol(), 2);
    }

    public void testGetStatus() throws Exception {
        assertEquals(CELL_A.getStatus(), 0);
    }

    public void testSetStatus() throws Exception {
        CELL_A.setStatus(1);
        assertEquals(CELL_A.getStatus(), 1);
    }

}
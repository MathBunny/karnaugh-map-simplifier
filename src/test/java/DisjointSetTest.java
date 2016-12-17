import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author Horatiu Lazu
 * @version 1.0
 */
public class DisjointSetTest extends TestCase {
    private final int DISJOINT_SET_SIZE = 5;
    private DisjointSet DS = new DisjointSet(DISJOINT_SET_SIZE);

    public void testCreate() throws Exception {
        DS.create(2);
        assertEquals(DS.findPathCompression(2), 2);
    }

    public void testGetArr() throws Exception {
        DisjointSet dS2 = new DisjointSet(DISJOINT_SET_SIZE);
        assertEquals(Arrays.toString(dS2.getArr()), Arrays.toString(new int [5]));
    }

    public void testAdd() throws Exception {
        DS = new DisjointSet(DISJOINT_SET_SIZE);
        DS.create(2);
        DS.add(3, 2);
        assertEquals(Arrays.toString(DS.getArr()), Arrays.toString(new int[] {0, 0, -3, 2, 0}));
    }

    public void testFind() throws Exception {
        DS = new DisjointSet(DISJOINT_SET_SIZE);
        DS.create(2);
        DS.add(3, 2);
        assertEquals(DS.find(3), 2);
    }

    public void testFindPathCompression() throws Exception {
        // Test A
        DS = new DisjointSet(DISJOINT_SET_SIZE);
        DS.create(2);
        DS.add(3, 2);
        assertEquals(DS.findPathCompression(3), 2);
        assertEquals(DS.getArr()[3], 2);

        // Test B (with union)
        DS.create(0);
        DS.add(1, 0);
        DS.merge(0, 2);
        assertEquals(DS.findPathCompression(0), 2);
        assertEquals(DS.getArr()[0], 2);
    }


    public void testMerge() throws Exception {
        DS.create(2);
        DS.add(3, 2);
        DS.create(0);
        DS.add(1, 0);
        DS.merge(0, 2);
        assertEquals(DS.findPathCompression(0), 2);
        assertEquals(DS.getArr()[2], -3);
    }

}
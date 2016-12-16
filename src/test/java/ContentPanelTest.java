import junit.framework.TestCase;
import java.util.LinkedList;

/**
 * @author Horatiu Lazu
 * @version 1.0
 */
public class ContentPanelTest extends TestCase {
    /** CONTENT_PANEL ContentPanel This is a three variable content panel */
    private final ContentPanel CONTENT_PANEL = new ContentPanel(3);

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {}

    public void testGetVar() throws Exception {
        assertEquals(CONTENT_PANEL.getVar(), 3);
    }

    public void testGetSimplifiedExpression() throws Exception {
        // Test A (no grouping)
        new Frame(false);
        CONTENT_PANEL.getSimplifiedExpression(new LinkedList<Grouping>());
        assertEquals(Frame.ans[CONTENT_PANEL.getVar() - 2].getText(), "False");
        LinkedList<Grouping> groupingList = new LinkedList <Grouping>();

        // Test B (one large grouping)
        groupingList.add(new Grouping(0, 0, 1, 1));
        CONTENT_PANEL.getSimplifiedExpression(groupingList);
        assertEquals(Frame.ans[CONTENT_PANEL.getVar() - 2].getText(), "A'");

        // Test C (one horizontal grouping)
        groupingList = new LinkedList <Grouping>();
        groupingList.add(new Grouping(0, 1, 1, 1));
        CONTENT_PANEL.getSimplifiedExpression(groupingList);
        assertEquals(Frame.ans[CONTENT_PANEL.getVar() - 2].getText(), "A'B");

        // Test D (one vertical grouping)
        groupingList = new LinkedList <Grouping>();
        groupingList.add(new Grouping(1, 0, 1, 1));
        CONTENT_PANEL.getSimplifiedExpression(groupingList);
        assertEquals(Frame.ans[CONTENT_PANEL.getVar() - 2].getText(), "A'C");

        // Test E (complete group)
        groupingList = new LinkedList <Grouping>();
        groupingList.add(new Grouping(0, 0, 1, 3));
        CONTENT_PANEL.getSimplifiedExpression(groupingList);
        assertEquals(Frame.ans[CONTENT_PANEL.getVar() - 2].getText(), "True");
    }
}
import java.util.*;

/**
 * This class stores all FourVariableTests to be used in ContentPanelTest
 * @author Horatiu Lazu
 * @version 1.0
 */
public class FourVariableTest implements SimplificationTest{

    public HashMap<LinkedList<CompoundedGroupings>, String> getTests (){
        HashMap<LinkedList<CompoundedGroupings>, String> tests = new HashMap<LinkedList<CompoundedGroupings>, String>();

        // Test A (no group)
        LinkedList<CompoundedGroupings> noGroups = new LinkedList<CompoundedGroupings>();
        tests.put(noGroups, "False");

        // Test B (small narrow group)
        LinkedList<CompoundedGroupings> narrowGroupTop = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groups = new LinkedList<Grouping>();
        groups.add(new Grouping(0, 0, 0, 3));
        narrowGroupTop.add(new CompoundedGroupings(groups));
        tests.put(narrowGroupTop, "C'D'");

        // Test B (small narrow group)
        LinkedList<CompoundedGroupings> wideGroupTop = new LinkedList<CompoundedGroupings>();
        groups = new LinkedList<Grouping>();
        groups.add(new Grouping(0, 0, 3, 0));
        wideGroupTop.add(new CompoundedGroupings(groups));
        tests.put(wideGroupTop, "A'B'");

        return null;
    }
}

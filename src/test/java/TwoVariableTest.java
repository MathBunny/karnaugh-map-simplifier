import java.util.HashMap;
import java.util.LinkedList;

/**
 * This class stores all TwoVariableTests to be used in ContentPanelTest
 * @author Horatiu Lazu
 * @version 1.0
 */

public class TwoVariableTest implements SimplificationTest {
    public HashMap<LinkedList<CompoundedGroupings>, String> getTests () {
        HashMap<LinkedList<CompoundedGroupings>, String> tests = new HashMap<LinkedList<CompoundedGroupings>, String>();

        // Test A (no group)
        LinkedList<CompoundedGroupings> noGroups = new LinkedList<CompoundedGroupings>();
        noGroups.add(new CompoundedGroupings());
        tests.put(noGroups, "False");

        // Test B (top row)
        LinkedList<CompoundedGroupings> narrowGroupTop = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsB = new LinkedList<Grouping>();
        groupsB.add(new Grouping(0, 0, 1, 0));
        narrowGroupTop.add(new CompoundedGroupings(groupsB));
        tests.put(narrowGroupTop, "A'");

        // Test C (bottom row)
        LinkedList<CompoundedGroupings> wideGroupTop = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsC = new LinkedList<Grouping>();
        groupsC.add(new Grouping(0, 1, 1, 1));
        wideGroupTop.add(new CompoundedGroupings(groupsC));
        tests.put(wideGroupTop, "A");

        // Test D (left column)
        LinkedList<CompoundedGroupings> compoundedGroupD = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsD = new LinkedList<Grouping>();
        groupsD.add(new Grouping(0, 0, 0, 1));
        compoundedGroupD.add(new CompoundedGroupings(groupsD));
        tests.put(compoundedGroupD, "B'");

        // Test E (right column)
        LinkedList<CompoundedGroupings> compoundedGroupE = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsE = new LinkedList<Grouping>();
        groupsE.add(new Grouping(1, 0, 1, 0));
        compoundedGroupE.add(new CompoundedGroupings(groupsE));
        tests.put(compoundedGroupE, "A'B");

        // Test F (complete group)
        LinkedList<CompoundedGroupings> compoundedGroupF = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsF = new LinkedList<Grouping>();
        groupsF.add(new Grouping(0, 0, 1, 1));
        compoundedGroupF.add(new CompoundedGroupings(groupsF));
        tests.put(compoundedGroupF, "True");

        // Test G (compounded group, 1x1 + 2x1)
        LinkedList<CompoundedGroupings> compoundedGroupG = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsG = new LinkedList<Grouping>();
        groupsG.add(new Grouping(1, 0, 1, 0));
        groupsG.add(new Grouping(0, 0, 0, 1));
        compoundedGroupG.add(new CompoundedGroupings(groupsG));
        tests.put(compoundedGroupG, "A'B+B'");

        return tests;
    }
}

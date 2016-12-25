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
        noGroups.add(new CompoundedGroupings());
        tests.put(noGroups, "False");

        // Test B (small narrow group)
        LinkedList<CompoundedGroupings> narrowGroupTop = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsB = new LinkedList<Grouping>();
        groupsB.add(new Grouping(0, 0, 0, 3));
        narrowGroupTop.add(new CompoundedGroupings(groupsB));
        tests.put(narrowGroupTop, "C'D'");

        // Test C (small wide group)
        LinkedList<CompoundedGroupings> wideGroupTop = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsC = new LinkedList<Grouping>();
        groupsC.add(new Grouping(0, 0, 3, 0));
        wideGroupTop.add(new CompoundedGroupings(groupsC));
        tests.put(wideGroupTop, "A'B'");

        // Test D (1x1 box - top left)
        LinkedList<CompoundedGroupings> compoundedGroupD = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsD = new LinkedList<Grouping>();
        groupsD.add(new Grouping(0, 0, 0, 0));
        compoundedGroupD.add(new CompoundedGroupings(groupsD));
        tests.put(compoundedGroupD, "A'B'C'D'");

        // Test E (2x2 box)
        LinkedList<CompoundedGroupings> compoundedGroupE = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsE = new LinkedList<Grouping>();
        groupsE.add(new Grouping(0, 0, 1, 1));
        compoundedGroupE.add(new CompoundedGroupings(groupsE));
        tests.put(compoundedGroupE, "A'C'");

        // Test F (4x4 box)
        LinkedList<CompoundedGroupings> compoundedGroupF = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsF = new LinkedList<Grouping>();
        groupsF.add(new Grouping(0, 0, 3, 3));
        compoundedGroupF.add(new CompoundedGroupings(groupsF));
        tests.put(compoundedGroupF, "True");

        // Test G (1x1 box), shift right one
        LinkedList<CompoundedGroupings> compoundedGroupG = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsG = new LinkedList<Grouping>();
        groupsG.add(new Grouping(1, 0, 1, 0));
        compoundedGroupG.add(new CompoundedGroupings(groupsG));
        tests.put(compoundedGroupG, "A'B'C'D");

        // Test H (1x1 box), shifted right two
        LinkedList<CompoundedGroupings> compoundedGroupH = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsH = new LinkedList<Grouping>();
        groupsH.add(new Grouping(2, 0, 2, 0));
        compoundedGroupH.add(new CompoundedGroupings(groupsH));
        tests.put(compoundedGroupH, "A'B'CD");

        // Test I (1x1 box), shifted down one
        LinkedList<CompoundedGroupings> compoundedGroupI = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsI = new LinkedList<Grouping>();
        groupsI.add(new Grouping(0, 1, 0, 1));
        compoundedGroupI.add(new CompoundedGroupings(groupsI));
        tests.put(compoundedGroupI, "A'BC'D'");

        return tests;
    }
}

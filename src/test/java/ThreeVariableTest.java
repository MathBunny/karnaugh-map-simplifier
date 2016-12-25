import java.util.HashMap;
import java.util.LinkedList;

/**
 * This class stores all ThreeVariableTests to be used in ContentPanelTest
 * @author Horatiu Lazu
 * @version 1.0
 */

public class ThreeVariableTest implements SimplificationTest {
    public HashMap<LinkedList<CompoundedGroupings>, String> getTests (){
        HashMap<LinkedList<CompoundedGroupings>, String> tests = new HashMap<LinkedList<CompoundedGroupings>, String>();

        // Test A (no group)
        LinkedList<CompoundedGroupings> noGroups = new LinkedList<CompoundedGroupings>();
        noGroups.add(new CompoundedGroupings());
        tests.put(noGroups, "False");

        // Test B (one large group)
        LinkedList<CompoundedGroupings> narrowGroupTop = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsB = new LinkedList<Grouping>();
        groupsB.add(new Grouping(0, 0, 1, 1));
        narrowGroupTop.add(new CompoundedGroupings(groupsB));
        tests.put(narrowGroupTop, "A'");

        // Test C (one horizontal group)
        LinkedList<CompoundedGroupings> wideGroupTop = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsC = new LinkedList<Grouping>();
        groupsC.add(new Grouping(0, 1, 1, 1));
        wideGroupTop.add(new CompoundedGroupings(groupsC));
        tests.put(wideGroupTop, "A'B");

        // Test D (one vertical group)
        LinkedList<CompoundedGroupings> compoundedGroupD = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsD = new LinkedList<Grouping>();
        groupsD.add(new Grouping(1, 0, 1, 1));
        compoundedGroupD.add(new CompoundedGroupings(groupsD));
        tests.put(compoundedGroupD, "A'C");

        // Test E (complete group)
        LinkedList<CompoundedGroupings> compoundedGroupE = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsE = new LinkedList<Grouping>();
        groupsE.add(new Grouping(0, 0, 1, 3));
        compoundedGroupE.add(new CompoundedGroupings(groupsE));
        tests.put(compoundedGroupE, "True");

        // Test F (1x1 box)
        LinkedList<CompoundedGroupings> compoundedGroupF = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsF = new LinkedList<Grouping>();
        groupsF.add(new Grouping(1, 0, 1, 3));
        compoundedGroupF.add(new CompoundedGroupings(groupsF));
        tests.put(compoundedGroupF, "C");

        // Test G (1x1 box), shift right one
        LinkedList<CompoundedGroupings> compoundedGroupG = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsG = new LinkedList<Grouping>();
        groupsG.add(new Grouping(1, 0, 1, 0));
        compoundedGroupG.add(new CompoundedGroupings(groupsG));
        tests.put(compoundedGroupG, "A'B'C");

        // Test H (1x1 box), shifted down two
        LinkedList<CompoundedGroupings> compoundedGroupH = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsH = new LinkedList<Grouping>();
        groupsH.add(new Grouping(0, 0, 0, 2));
        compoundedGroupH.add(new CompoundedGroupings(groupsH));
        tests.put(compoundedGroupH, "C'");

        // Test I (1x1 box), shifted down one
        LinkedList<CompoundedGroupings> compoundedGroupI = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsI = new LinkedList<Grouping>();
        groupsI.add(new Grouping(0, 1, 0, 1));
        compoundedGroupI.add(new CompoundedGroupings(groupsI));
        tests.put(compoundedGroupI, "A'BC'");

        // Test J (2x1 box)
        LinkedList<CompoundedGroupings> compoundedGroupJ = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsJ = new LinkedList<Grouping>();
        groupsJ.add(new Grouping(0, 0, 1, 0));
        compoundedGroupJ.add(new CompoundedGroupings(groupsJ));
        tests.put(compoundedGroupJ, "A'B'");

        // Test K (1x2 box)
        LinkedList<CompoundedGroupings> compoundedGroupK = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsK = new LinkedList<Grouping>();
        groupsK.add(new Grouping(0, 0, 0, 1));
        compoundedGroupK.add(new CompoundedGroupings(groupsK));
        tests.put(compoundedGroupK, "A'C'");

        // Test L (1x2 box) one unit right
        LinkedList<CompoundedGroupings> compoundedGroupL = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsL = new LinkedList<Grouping>();
        groupsL.add(new Grouping(1, 0, 1, 2));
        compoundedGroupL.add(new CompoundedGroupings(groupsL));
        tests.put(compoundedGroupL, "C");

        // Test M (1x3 box)
        LinkedList<CompoundedGroupings> compoundedGroupM = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsM = new LinkedList<Grouping>();
        groupsM.add(new Grouping(0, 0, 0, 2));
        compoundedGroupM.add(new CompoundedGroupings(groupsM));
        tests.put(compoundedGroupM, "C'");

        // Test N (1x3 box) one unit right
        LinkedList<CompoundedGroupings> compoundedGroupN = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsN = new LinkedList<Grouping>();
        groupsN.add(new Grouping(1, 0, 1, 2));
        compoundedGroupN.add(new CompoundedGroupings(groupsN));
        tests.put(compoundedGroupN, "C");

        // Test O (2x4 box)
        LinkedList<CompoundedGroupings> compoundedGroupO = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsO = new LinkedList<Grouping>();
        groupsO.add(new Grouping(0, 0, 1, 3));
        compoundedGroupO.add(new CompoundedGroupings(groupsO));
        tests.put(compoundedGroupO, "True");

        // Test P (4x1 box)
        LinkedList<CompoundedGroupings> compoundedGroupP = new LinkedList<CompoundedGroupings>();
        LinkedList<Grouping> groupsP = new LinkedList<Grouping>();
        groupsP.add(new Grouping(0, 0, 0, 3));
        compoundedGroupP.add(new CompoundedGroupings(groupsP));
        tests.put(compoundedGroupP, "C'");

        return tests;
    }
}

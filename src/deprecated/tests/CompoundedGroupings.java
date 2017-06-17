import java.util.LinkedList;

/**
 * This class encapsulates a list of groupings in a grid.
 * @author Horatiu Lazu
 */
public class CompoundedGroupings {
    private LinkedList<Grouping> groups;

    public LinkedList<Grouping> getGroups(){
        return groups;
    }

    public CompoundedGroupings(){
        groups = new LinkedList<Grouping>();
    }

    public CompoundedGroupings(LinkedList<Grouping> groups){
        this.groups = groups;
    }

    public void addGroup(Grouping g){
        groups.add(g);
    }
}

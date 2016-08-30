import java.util.LinkedList;

/**
 * Created by horatiulazu on 2016-08-30.
 */
public class Scenario {
    private LinkedList<Grouping> sol = new LinkedList<Grouping>();
    private int variables;

    public Scenario(LinkedList<Grouping> sol, int variables){
        this.sol = sol;
        this.variables = variables;
    }

    public String getSimplifiedExpresion(){
        int bits = 0;
        for(Grouping group : sol){
            LinkedList<Integer> binaryRepresentation = new LinkedList<Integer>();
            for(int x = group.getStartX(); x <= group.getEndX(); x++){
                for(int y = group.getStartY(); y  <= group.getEndY(); y++){
                    //solve!
                    binaryRepresentation.add(new GraycodeReflectedBinaryMappingSOP().convertCoordinateToBinary.get(x + "|" + y + "|" + variables));
                }
            }
            //now check for unique values in it
        }
        return "";
    }
}

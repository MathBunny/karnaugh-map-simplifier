import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * Created by horatiulazu on 2016-08-30.
 */
public class Scenario {
    /** sol LinkedList This is the solution */
    private LinkedList<Grouping> sol = new LinkedList<Grouping>();
    /** variables int This is the number of variables */
    private int variables;

    /**
     * This is the class constructor for scenario
     * @param sol LinkedList This is the solution for the scenario
     * @param variables int These are the variables
     */
    public Scenario(LinkedList<Grouping> sol, int variables){
        this.sol = sol;
        this.variables = variables;
    }

    /**
     * This method returns the simplified expression
     * @return String This is the simplified expression
     */
    public String getSimplifiedExpresion(){
        int bits = variables;
        boolean addedBitsPreviously = false;
        StringBuilder sB = new StringBuilder("");
        for(Grouping group : sol){
            LinkedList<Integer> binaryRepresentation = new LinkedList<Integer>();
            for(int x = group.getStartX(); x <= group.getEndX(); x++){
                for(int y = group.getStartY(); y  <= group.getEndY(); y++){
                    binaryRepresentation.add(new GraycodeReflectedBinaryMappingSOP().convertCoordinateToBinary.get(x + "|" + y + "|" + variables));
                }
            }
            //check for 1's, repeated 1's with AND operator
            int onesConsistent = binaryRepresentation.get(0);
            for(Integer number : binaryRepresentation){
                onesConsistent &= number;
            }

            HashSet<Integer> keepBitsOne = new HashSet<Integer>();
            int bitCount = 0;
            for(int x = 0; x < bits; x++){
                if ((onesConsistent & 1) == 1){ //keep it
                    keepBitsOne.add(bitCount);
                }
                onesConsistent >>= 1;
                bitCount++;
            }

            HashSet<Integer> keepBitsZero = new HashSet<Integer>();
            //check for 0's, repeated 0's with OR operator
            int zerosConsistent = binaryRepresentation.get(0);
            for(Integer number : binaryRepresentation){
                zerosConsistent |= number;
            }

            bitCount = 0;
            for(int x = 0; x < bits; x++){
                if ((zerosConsistent & 1) == 0){ //keep it
                    keepBitsZero.add(bitCount);
                }
                zerosConsistent >>= 1;
                bitCount++;
            }

            boolean addedBits = false;
            for(int x = variables-1; x >= 0; x--){
                if (keepBitsOne.contains(x) || keepBitsZero.contains(x)){
                    addedBits = true;
                    if (addedBitsPreviously){
                        sB.append("+");
                        addedBitsPreviously = false;
                    }
                    sB.append(((char)('A' + (variables-1-x)) + "" +  (keepBitsZero.contains(x) ? ('\'') : (""))));
                }
            }
            addedBitsPreviously = addedBits;

        }
        String ans = sB.toString();
        if (ans.equals("")) {
            if (sol.size() > 0)
                return "True"; //not always the case!
            return "False";
        }
        return ans;
    }
}

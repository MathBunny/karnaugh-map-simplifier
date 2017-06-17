import java.util.*;

/** The purpose of this class is to add functionality to the Truth Tables, which includes adding the original SOP equation into a textbox and making the buttons work.
  * @author Horatiu Lazu
  * @version 1.0 */

public class DontCare extends TruthTable{
  /** twoVariableDontCare int [] This is the two variable truth table */
  public static int [] twoVariableDontCare = new int [4];
  /** threeVariableDontCare int [] This is the three variable truth table */
  public static int [] threeVariableDontCare = new int [9];
  /** fourVariableDontCare int [] This is the four variable truth table */
  public static int [] fourVariableDontCare = new int [16]; /* 2D array? */
  /** ignoreFlag boolean This is the ignore flag */
  static boolean ignoreFlag = false;
  
  /** This method fills the truth tables with 0 values. */
  public static void initializeDontCareValues(){
    Arrays.fill(twoVariableDontCare, 0);
    Arrays.fill(threeVariableDontCare, 0);
    Arrays.fill(fourVariableDontCare, 0);
  }
}

import java.util.*;

/** The purpose of this class is to add functionality to the Truth Tables, which includes adding the original SOP equation into a textbox and making the buttons work.
  * @author Horatiu Lazu
  * @version 1.0 */
public class DontCare extends TruthTable{
  
  public static int [] twoVariableDontCare = new int [4];
  public static int [] threeVariableDontCare = new int [9];
  public static int [] fourVariableDontCare = new int [16]; /* 2D array? */
  static boolean ignoreFlag = false;
  
  /** This method fills the truth tables with 0 values. */
  public static void initializeDontCareValues(){
    Arrays.fill(twoVariableDontCare, 0);
    Arrays.fill(threeVariableDontCare, 0);
    Arrays.fill(fourVariableDontCare, 0);
  }
}

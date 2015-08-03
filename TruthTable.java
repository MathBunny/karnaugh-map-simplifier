import javax.swing.*;
import java.util.*;


public class TruthTable{
  
  public static int [] twoVariableTruth = new int [4];
  public static int [] threeVariableTruth = new int [9];
  public static int [] fourVariableTruth = new int [16]; /* 2D array? */
  
  static boolean ignoreFlag = false;
  
  /* This method returns the boolean expression from the truthtable. */
  public static String getInputEquation(int num, int variables){
    variables = variables * variables; //this is the max number... 
    int [] s;
    int bits = log2(variables) - 1; //why -1?
    System.out.println("Bits: " + bits);
    s = new int[bits];
    for(int i = bits-1; i >= 0; i--){
      s[i] = (num >> (bits-1-i) & 1); //bits-1-i = i
      System.out.println(s[i]);
    }
    System.out.println();
    
    String returnS = "";
    for(int i = 0; i < s.length; i++){
      if (s[i] == 0)
        returnS += (char)('A' + i) + "'";
      else
        returnS += (char)('A' + i) + "";
    }
    return returnS;
  }
  
  /* Get the number of bits */
  static int log2(int value) {
    return Integer.SIZE-Integer.numberOfLeadingZeros(value);
  }
  
  
  public static void initializeTruthTableValues(){
    Arrays.fill(twoVariableTruth, 0);
    Arrays.fill(threeVariableTruth, 0);
    Arrays.fill(fourVariableTruth, 0);
  }
  
  public static void updateGivenSOP(int variables){
    String output = "";
    for(int x = 0; x < variables * variables; x++){
      int val;
      if (variables == 2)
        val = twoVariableTruth[x];
      else if (variables == 3)
        val = threeVariableTruth[x];
      else
        val = fourVariableTruth[x];
      if (val == 1){
        output += "+" + getInputEquation(x, variables);
      }
    }
    if (output.length() >= 1)
      Frame.givenEq[variables-2].setText(output.substring(1)); //take off additional 
    else
      Frame.givenEq[variables-2].setText("hi");
  }
  
}

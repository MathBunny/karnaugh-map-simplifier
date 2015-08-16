

public class Solve{
  
  public static void solveKarnaughMap(int variables, boolean dontCare){
    if (!dontCare){
      int [] [] map = convertIncidenceArray((variables == 2) ? (TruthTable.twoVariableTruth) : (variables == 3) ? (TruthTable.threeVariableTruth) : (TruthTable.fourVariableTruth));
      
      /* You can brute force this. */
      if (variables == 2){
        
      }
      
      
    }
  }
  
  public static int [] [] convertIncidenceArray(int [] arr){
    int variables = (int)(Math.log10(arr.length) / Math.log10(2));
    int maxX;
    int maxY;
    if (variables == 3){
      maxX = 2;
      maxY = 4;
    }
    else{
      maxX = variables;
      maxY = variables;
    }
    int [] [] arrR = new int[maxX][maxY];
    
    for(int x = 0; x < maxX; x++){
      for(int y = 0; y < maxY; y++){
        arrR[x][y] = arr[y * 4 + x]; //works?? :/ :/ :/
      }
    }
    return arrR;
  }
}
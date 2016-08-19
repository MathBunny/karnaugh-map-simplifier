

public class Solve{
  
  public static void solveKarnaughMap(int variables, boolean dontCare){
    if (!dontCare){
      int [] [] map = convertIncidenceArray((variables == 2) ? (TruthTable.twoVariableTruth) : (variables == 3) ? (TruthTable.threeVariableTruth) : (TruthTable.fourVariableTruth));

      toStringMatrix(map);

      PrefixSum pS = new PrefixSum(map);
      for(int y = 0; y < map[0].length; y++){ //you should be able to start from -1 to deal with overlaps :-)
        for(int x = 0; x < map.length; x++){
          if (map[x][y] == 1){
            //generate grouping
            for(int yy = y; yy < map[0].length; yy++){ //make sure both aren't -'ve??
              for(int xx = x; xx < map[0].length; xx++){
                //if ((Math.abs(xx-x) * ))
              }
            }
          }
        }
      }
      
      
    }
  }

  /** This method is used for debugging and outputting the incidence array.
   * @param map int [] [] This is the array to be outputted
   */
  public static void toStringMatrix(int [] [] map){
    for(int y = 0; y < map[0].length; y++){
      for(int x = 0; x < map.length; x++){
        System.out.print(map[x][y] + " ");
      }
      System.out.println();
    }
  }

  /** This method converts a truthtable to a matrix
   * @param arr This is the truth-table
   * @return int [] [] This is the resultant matrix
   */
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
        arrR[x][y] = arr[y * ((variables == 4) ? (4) : (2)) + x]; //works?? :/ :/ :/
      }
    }

    /* Swap to ensure proper adjacency... */
    if (variables != 2){
      for(int i = 0; i < maxX; i++){
        int temp;
        temp = arrR[i][2];
        arrR[i][2] = arrR[i][3];
        arrR[i][3] = temp;
      }
    }
    if (variables == 4){
      for(int i = 0; i < maxY; i++){
        int temp;
        temp = arrR[3][i];
        arrR[3][i] = arrR[2][i];
        arrR[2][i] = temp;
      }
    }
    return arrR;
  }
}
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * This class solves Karnaugh maps
 * @author Horatiu Lazu
 */

public class Solve{
  /** solution LinkedList This are the groupings */
  public static LinkedList<Grouping> solution;
  /** matrix int [] [] This is the matrix */
  public static int [] [] matrix;
  /** NUM_VARIABLES int This is the number of variables */
  public static int NUM_VARIABLES = 0;

  /**
   * This method solves the Karnaugh Map
   * @param variables int This is the number of variables.
   * @param dontCare boolean This indicates true/false for the don't care
   */
  public static void solveKarnaughMap(int variables, boolean dontCare){
    if (!dontCare){
      int [] [] map = convertIncidenceArray((variables == 2) ? (TruthTable.twoVariableTruth) : (variables == 3) ? (TruthTable.threeVariableTruth) : (TruthTable.fourVariableTruth));
      matrix = map;
      solvingHelper(variables, dontCare, map);
      Solve.NUM_VARIABLES = variables;
      return;
    }
  }

  /**
   * This method is a solver helper, using 2D prefix sums
   * @param variables int This is the number of variables
   * @param dontCare boolean This indicates if don't cares are taken into account
   * @param map int [] [] This is the matrix.
   */
  public static void solvingHelper(int variables, boolean dontCare, int [] [] map){
    if (!dontCare){

      PrefixSum pS = new PrefixSum(map);
      PriorityQueue<Grouping> groupings = new PriorityQueue<Grouping>(); //pairings
      LinkedList<Grouping> pairings = new LinkedList<Grouping>(); //final ans

      for(int y = 0; y < map[0].length; y++)
        for(int x = 0; x < map.length; x++)
          for(int yy = y; yy < map[0].length; yy++)
            for (int xx = x; xx < map.length; xx++)
              if ((!(x == xx && y == yy)) && (isSquared((Math.abs(x-xx)+1) * (Math.abs(y-yy)+1)) && (pS.sumRegion(x, y, xx, yy) == (Math.abs(x-xx)+1) * (Math.abs(y-yy)+1)) && pS.sumRegion(x, y, xx, yy) != 0))
                groupings.add(new Grouping(x, y, xx, yy));


      boolean [] [] visited = new boolean[map.length][map[0].length];
      while(!groupings.isEmpty()){
        Grouping g = groupings.remove();
        for(int y = g.getStartY(); y <= g.getEndY(); y++){ //<= ???
          for(int x = g.getStartX(); x <= g.getEndX(); x++){
            if (!visited[x][y]){ //mark all as visited
              pairings.add(g);
              for(int yy = g.getStartY(); yy <= g.getEndY(); yy++){
                for(int xx = g.getStartX(); xx <= g.getEndX(); xx++){
                  visited[xx][yy] = true;
                }
              }
            }
          }
        }
      }

      for(int y = 0; y < map[0].length; y++){ //groups of 1
        for(int x = 0; x < map.length; x++){
          if (!visited[x][y] && map[x][y] == 1){
            pairings.add(new Grouping(x, y, x, y)); //single one
          }
        }
      }

      solution = pairings;
    }
  }

  /**
   * This method indicates if the equation is a valid size / geometry.
   * @param size int This is the size of the square.
   * @return int This is the return value.
   */
  public static boolean isSquared(int size){
    if (size == 0)
      return true;
    return ((int)(Math.log(size)/Math.log(2))) == Math.log(size)/Math.log(2);
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

  /** This method is used for debugging and outputting the incidence array.
   * @param map int [] [] This is the array to be outputted.
   */
  public static void toStringMatrix(int [] [] map){
    for(int y = 0; y < map[0].length; y++){
      for(int x = 0; x < map.length; x++){
        System.out.print(map[x][y] + " ");
      }
      System.out.println();
    }
  }
}
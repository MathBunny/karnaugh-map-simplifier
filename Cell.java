/** The purpose of this class is to hold a cell in a table and give information to the program using accessor / mutator methods 
 * @author Horatiu Lazu
  *  
  */

public class Cell{
  private int row;
  private int col;
  private int status;
  
  public Cell(int row, int col, int status){
    this.row = row;
    this.col = col;
    this.status = status;
  }
  
  public int getRow(){
    return row;
  }
  
  public int getCol(){
    return col;
  }
  
  public int getStatus(){
    return status;
  }
  
  public void setStatus(int status){
    this.status = status;
  }
  
  
}
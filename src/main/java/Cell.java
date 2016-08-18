/** The purpose of this class is to hold a cell in a table and give information to the program using accessor / mutator methods 
  * @author Horatiu Lazu
  * @version 1.0
  */

public class Cell{
  private int row;
  private int col;
  private int status;
  
  /** This is the class constructor for a cell
   * @param row int This is the row
   * @param col int This is the column
   * @param status int This is the temporary status in the cell */
  public Cell(int row, int col, int status){
    this.row = row;
    this.col = col;
    this.status = status;
  }
  
  /** This method gets the row
    * @return int This is the row */
  public int getRow(){
    return row;
  }
  
  /** This method returns the col
    * @return int This is the column number */
  public int getCol(){
    return col;
  }
  
  /** This method returns the status.
    * @return int This is the status */
  public int getStatus(){
    return status;
  }
  
  /** This method sets the status.
    * @param status int This is the status that wants to be set. */
  public void setStatus(int status){
    this.status = status;
  }
}
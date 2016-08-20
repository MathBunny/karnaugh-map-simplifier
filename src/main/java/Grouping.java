/**
 * @author Horatiu Lazu
 * @version 1.0
 * Created by horatiulazu on 2016-08-19.
 */
public class Grouping implements Comparable<Grouping>{
    /** startX int This is the starting x value. */
    private int startX;
    /** startY int This is the starting y value. */
    private int startY;
    /** endX int This is the ending x value */
    private int endX;
    /** endY int This is the ending y value */
    private int endY;
    /** size int This is the size of the grid */
    private int size;


    /**
     * This constructor is used for Groupings to store their information
     * @param startX int This is the starting x value
     * @param startY int This is the starting y value
     * @param endX int This is the ending x value
     * @param endY int This is the ending y value
     */
    public Grouping(int startX, int startY, int endX, int endY){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.size = (Math.abs(startX-endX)+1) * (Math.abs(startY - endY)+1);
    }

    public int getStartX(){
        return startX;
    }

    public int getStartY(){
        return startY;
    }

    public int getEndX(){
        return endX;
    }

    public int getEndY(){
        return endY;
    }

    public int getSize() {return size;}

    /** This method compares groupings for use in the priorityqueue.
     * Priority is set to those with larger groups, if equal, the ones that are square will take priority.
     * @param o Grouping This is the comparison grouping.
     * @return int This is the comparison value.
     */
    public int compareTo(Grouping o){
        if (getSize() == o.getSize()) {
            if (Math.abs(startX-endX) == Math.abs(startY-endY)){
                return 1;
            }
            return -1;
        }
        return o.getSize() - getSize();
    }

    /**
     * This method returns the string representation of the object, used for debugging.
     * @return String This is the value
     */
    public String toString(){
        return "(" + startX + "," + startY + ") to (" + endX + "," + endY + ")";
    }
}

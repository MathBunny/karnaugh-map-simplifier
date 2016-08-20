/**
 * @author Horatiu Lazu
 * Created by horatiulazu on 2016-08-19.
 */
public class Grouping implements Comparable<Grouping>{
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int size;


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

    public String toString(){
        return "(" + startX + "," + startY + ") to (" + endX + "," + endY + ")";
    }
}

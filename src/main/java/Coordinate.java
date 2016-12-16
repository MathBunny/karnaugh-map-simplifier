/**
 * This class encapsulates a coordinate.
 * @author Horatiu Lazu
 * @version 1.0
 */
public class Coordinate {
    /** x int This is the x value */
    private int x;
    /** y int This is the y coordinate */
    private int y;
    /** reflectedBinaryCode String This is the reflected binary code for the coordinate */
    private String reflectedBinaryCode;

    /**
     * Class constructor for standard coordinate.
     * @param x int This is the x value
     * @param y int This is the y value
     */
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * This is the class constructor for reflected binary code values inside Karnaugh maps
     * @param x int This is the x value
     * @param y int This is the y value
     * @param reflectedBinaryCode String This is the reflected binary code
     */
    public Coordinate(int x, int y, String reflectedBinaryCode){
        this.x = x;
        this.y = y;
        this.reflectedBinaryCode = reflectedBinaryCode;
    }

    /**
     * Returns x coordinate value
     * @return int This is the x value
     */
    public int getX(){
        return x;
    }

    /**
     * Returns y coordinate value
     * @return int This is the y value
     */
    public int getY(){
        return y;
    }

    public String getReflectedBinaryCode(){
        return reflectedBinaryCode;
    }
}

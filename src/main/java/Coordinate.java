/**
 * This class encapsulates a coordinate.
 * @author Horatiu Lazu
 * @version 1.0
 * Created by horatiulazu on 2016-08-30.
 */
public class Coordinate {
    private int x;
    private int y;
    private String reflectedBinaryCode;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinate(int x, int y, String reflectedBinaryCode){
        this.x = x;
        this.y = y;
        this.reflectedBinaryCode = reflectedBinaryCode;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getReflectedBinaryCode(){
        return reflectedBinaryCode;
    }
}

import java.util.*;

/**
 * Created by horatiulazu on 2016-08-18.
 * This class stores the greycode mapping (reflected binary code)
 * @author Horatiu Lazu
 * @version 1.0
 */

public class GraycodeReflectedBinaryMappingSOP {

    /**convert HashMap This is used to convert binary graycode to its location. Cells are initialized to -1 in value. */
    HashMap<String, Cell> convertBinaryToCoordinate = new HashMap<String, Cell>() {{
        //4 variable SOP
        put("0000",new Cell(0, 0, -1));
        put("0001",new Cell(1, 0, -1));
        put("0011",new Cell(2, 0, -1));
        put("0010",new Cell(3, 0, -1));
        put("0100",new Cell(0, 1, -1));
        put("0101",new Cell(1, 1, -1));
        put("0111",new Cell(2, 1, -1));
        put("0110",new Cell(3, 1, -1));
        put("1100",new Cell(0, 2, -1));
        put("1101",new Cell(1, 2, -1));
        put("1111",new Cell(2, 2, -1));
        put("1110",new Cell(3, 2, -1));
        put("1000",new Cell(0, 3, -1));
        put("1001",new Cell(1, 3, -1));
        put("1011",new Cell(2, 3, -1));
        put("1010",new Cell(3, 3, -1));
        //3 variable SOP
        put("000",new Cell(0, 0, -1));
        put("001",new Cell(1, 0, -1));
        put("010",new Cell(0, 1, -1));
        put("011",new Cell(1, 1, -1));
        put("110",new Cell(0, 2, -1));
        put("111",new Cell(1, 2, -1));
        put("100",new Cell(0, 3, -1));
        put("101",new Cell(1, 3, -1));
        //2 variable SOP
        put("00",new Cell(0, 0, -1));
        put("01",new Cell(1, 0, -1));
        put("10",new Cell(0, 1, -1));
        put("11",new Cell(1, 1, -1));
    }};

    /**
     * This stores the coordinate to binary conversions.
     * There is a pattern, but I hardcoded it anyways:
     * 00
     * 01
     * 11
     * 10
     * Loop between this in the first two digits and second.
     */
    HashMap<String, Integer> convertCoordinateToBinary = new HashMap<String, Integer>() {{
        //4 variable SOP
        put("0|0|4",Integer.parseInt("0000", 2));
        put("1|0|4",Integer.parseInt("0001", 2));
        put("2|0|4",Integer.parseInt("0011", 2));
        put("3|0|4",Integer.parseInt("0010", 2));
        put("0|1|4",Integer.parseInt("0100", 2));
        put("1|1|4",Integer.parseInt("0101", 2));
        put("2|1|4",Integer.parseInt("0111", 2));
        put("3|1|4",Integer.parseInt("0110", 2));
        put("0|2|4",Integer.parseInt("1100", 2));
        put("1|2|4",Integer.parseInt("1101", 2));
        put("2|2|4",Integer.parseInt("1111", 2));
        put("3|2|4",Integer.parseInt("1110", 2));
        put("0|3|4",Integer.parseInt("1000", 2));
        put("1|3|4",Integer.parseInt("1001", 2));
        put("2|3|4",Integer.parseInt("1011", 2));
        put("3|3|4",Integer.parseInt("1010", 2));


        //3 variable SOP
        put("0|0|3",Integer.parseInt("000", 2));
        put("1|0|3",Integer.parseInt("001", 2));
        put("0|1|3",Integer.parseInt("010", 2));
        put("1|1|3",Integer.parseInt("011", 2));
        put("0|2|3",Integer.parseInt("110", 2));
        put("1|2|3",Integer.parseInt("111", 2));
        put("0|3|3",Integer.parseInt("100", 2));
        put("1|3|3",Integer.parseInt("101", 2));

        //2 variable SOP
        put("0|0|2",Integer.parseInt("0b00", 2));
        put("1|0|2",Integer.parseInt("0b01", 2));
        put("0|1|2",Integer.parseInt("0b10", 2));
        put("1|1|2",Integer.parseInt("0b11", 2));
    }};
}

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
        put("0|0|4",0b0000);
        put("1|0|4",0b0001);
        put("2|0|4",0b0011);
        put("3|0|4",0b0010);
        put("0|1|4",0b0100);
        put("1|1|4",0b0101);
        put("2|1|4",0b0111);
        put("3|1|4",0b0110);
        put("0|2|4",0b1100);
        put("1|2|4",0b1101);
        put("2|2|4",0b1111);
        put("3|2|4",0b1110);
        put("0|3|4",0b1000);
        put("1|3|4",0b1001);
        put("2|3|4",0b1011);
        put("3|3|4",0b1010);


        //3 variable SOP
        put("0|0|3",0b000);
        put("1|0|3",0b000);
        put("2|0|3",0b000);
        put("0|1|3",0b000);
        put("1|1|3",0b000);
        put("2|1|3",0b000);
        put("0|2|3",0b000);
        put("1|2|3",0b000);
        put("2|2|3",0b000);

        //2 variable SOP
        put("0|0|2",0b00);
        put("1|0|2",0b01);
        put("0|1|2",0b10);
        put("1|1|2",0b11);
    }};
}

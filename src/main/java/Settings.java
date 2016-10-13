/**
 * This class stores the settings
 * @author Horatiu Lazu
 * @version 1.0
 */
public class Settings {
    /** REALTIME_GRAPHICS boolean This indicates if real-time graphics should be present */
    private static boolean REALTIME_GRAPHICS = true;
    /** AND_CHARACTER String This contains the and character */
    public static String AND_CHARACTER = ""; //∧
    /** OR_CHARACTER String This contains the or character */
    public static String OR_CHARACTER = "+"; //∨
    /** NOT_CHARACTER String This is the not character */
    public static String NOT_CHARACTER = "*"; //¬
    /** IS_DEFAULT_NOTATION boolean Indicates if the symbols are in algebraic notation or not */
    public static boolean IS_DEFAULT_NOTATION = false;

    /** This method returns real-time setting
     * @return boolean This indicates if it is real-time
     */
    public static boolean getRealtime(){
        return REALTIME_GRAPHICS;
    }

    /**
     * This method toggles real-time
     */
    public static void toggleRealtime(){
        REALTIME_GRAPHICS = !REALTIME_GRAPHICS;
    }

    /** This method toggles the notation */
    public void toggleNotation(){
        IS_DEFAULT_NOTATION = !IS_DEFAULT_NOTATION;
    }

    /**
     * This method toggles characters from algebraic and circuit style notation
     */
    public static void toggleCharacters(){
        if (AND_CHARACTER.equals("")){
            AND_CHARACTER = "∧";
            OR_CHARACTER = "∨";
            NOT_CHARACTER = "¬";
        }
        else{
            AND_CHARACTER = "";
            OR_CHARACTER = "+";
            NOT_CHARACTER = "'";
        }
    }
}

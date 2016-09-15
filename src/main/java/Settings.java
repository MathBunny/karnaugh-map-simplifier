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

    /**
     * This method toggles characters from algebraic and circuit style notation
     */
    public static void toggleCharacters(){
        if (AND_CHARACTER.equals("")){
            AND_CHARACTER = "∧";
            OR_CHARACTER = "∨";
        }
        else{
            AND_CHARACTER = "";
            OR_CHARACTER = "+";
        }
    }
}

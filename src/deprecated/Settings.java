/**
 *  @author Horatiu Lazu
 *  @version 1.0
 */
public class Settings {
    private static boolean REALTIME_GRAPHICS = true;

    public static boolean getRealtime(){
        return REALTIME_GRAPHICS;
    }

    public static void toggleRealtime(){
        REALTIME_GRAPHICS = !REALTIME_GRAPHICS;
    }
}

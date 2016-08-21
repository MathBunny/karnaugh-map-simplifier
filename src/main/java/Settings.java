/**
 * Created by horatiulazu on 2016-08-20.
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

/**
 *  @author Horatiu Lazu
 *  @version 1.0
 */
public class Settings {
    private static boolean REALTIME_GRAPHICS = true;
    private static boolean COPY_TO_CLIPBOARD = false;

    public static boolean getRealtime(){
        return REALTIME_GRAPHICS;
    }

    public static boolean getCopyClipboard(){
        return COPY_TO_CLIPBOARD;
    }

    public static void toggleRealtime(){
        REALTIME_GRAPHICS = !REALTIME_GRAPHICS;
    }

    public static void toggleCopyClipboard(){ COPY_TO_CLIPBOARD = !COPY_TO_CLIPBOARD; }

}

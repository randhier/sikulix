package helpers;

import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.sikuli.script.Screen;

public class general {
    public static String appLocation() {
        String OS;
        if (Settings.isMac()) {
            OS = "/Applications/Spotify.app/Contents/MacOS/Spotify";
        } else {
            // assuming if not MAC then Win. Enter win launcher location here
            OS = "spotify.exe";
        }
        return OS;
    }
    public static void login(Screen s, String user, String password){
        try {
            s.click("img/logo");
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
        s.type(Key.TAB + Key.TAB);
        s.type("a", KeyModifier.CMD);
        s.type(Key.BACKSPACE + user);
        s.type(Key.TAB + password);
        try {
            s.click("img/login");

        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
}

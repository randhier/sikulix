package helpers;

import org.sikuli.basics.Settings;
import org.sikuli.script.*;

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

    public static void logout(Screen s){
        s.type("w",  KeyModifier.CMD | KeyModifier.SHIFT);
        try {
            s.find("img/logo");
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public static void closeApp(App spotify){
        spotify.close();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void search(Screen s, String search) {
        try {
            s.click("img/search_bar");
        } catch (FindFailed findFailed){
            findFailed.printStackTrace();
        }
        s.type("Chronixx");
        s.type(Key.ENTER);
    }
}

package helpers;

import org.sikuli.basics.Settings;

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
}

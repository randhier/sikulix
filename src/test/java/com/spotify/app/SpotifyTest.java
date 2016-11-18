package com.spotify.app;

import org.testng.Assert;
import org.testng.annotations.*;
import org.sikuli.script.App;

public class SpotifyTest {

    App spotify;

    @Test
    public void main() {
        System.out.println("Test");
    }

    @BeforeClass
    public void setUp() {
        System.out.println("Setup");
        spotify = App.open(getLaunch());
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Teardown");
        spotify.close();
    }

    public static String getLaunch() {
        String OS = System.getProperty("os.name").toLowerCase();
        if (OS.indexOf("mac") >= 0) {
            OS = "/Applications/Spotify.app/Contents/MacOS/Spotify";
        } else {
            // assuming if not MAC then Win. Enter win launcher location here
            OS = "spotify.exe";
        }
        return OS;
    }
}
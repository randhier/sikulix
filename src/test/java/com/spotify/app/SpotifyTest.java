package com.spotify.app;

import org.sikuli.script.Key;
import org.sikuli.script.KeyModifier;
import org.testng.Assert;
import org.testng.annotations.*;
import org.sikuli.script.App;
import org.sikuli.script.Screen;
import helpers.*;

public class SpotifyTest {

    private App spotify;
    private Screen s;

    @Test
    public void main() {
        s.type("a", KeyModifier.CMD);
        s.type(Key.BACKSPACE);
        s.type(System.getenv("SPOTIFY_USER"));
        s.type(Key.TAB);
        s.type(System.getenv("SPOTIFY_PASSWORD"));
    }

    @BeforeClass
    public void setUp() {
        s = new Screen();
        spotify = App.open(general.appLocation());
        spotify.focus();
    }

    @AfterClass
    public void tearDown() {
        spotify.close();
    }
}
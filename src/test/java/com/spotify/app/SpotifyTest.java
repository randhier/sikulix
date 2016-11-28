package com.spotify.app;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.App;
import org.testng.Assert;
import org.testng.annotations.*;
import helpers.*;

public class SpotifyTest {

    private App spotify;
    private Screen s;

    @Test
    public void invalidLoginTest() {
        general.login(s, System.getenv("SPOTIFY_USER"), " ");
        try {
            s.find("img/login_error");

        } catch (FindFailed findFailed) {
            Assert.fail("Cound not find image");
        }
    }

    @Test
    public void validLoginTest(){
        general.login(s, System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        try {
            s.find("img/search_bar");

        } catch (FindFailed findFailed) {
            Assert.fail("Cound not find image");
        }
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
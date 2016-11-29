package com.spotify.app;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.App;
import org.testng.Assert;
import org.testng.annotations.*;
import helpers.*;

public class LoginTest {

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
            s.find("img/browse_tabs");

        } catch (FindFailed findFailed) {
            Assert.fail("Cound not find image");
        }
    }

    @BeforeMethod
    public void setUp() {
        s = new Screen();
        spotify = App.open(general.appLocation());
        spotify.focus();
    }

    @AfterMethod
    public void tearDown() {
        general.logout(s);
        general.closeApp(spotify);
    }
}
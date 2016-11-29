package com.spotify.app;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.sikuli.script.App;
import org.testng.Assert;
import org.testng.annotations.*;
import helpers.*;

public class SearchTest {

    private App spotify;
    private Screen s;

    @Test
    public void searchTest(){
        general.login(s, System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        try {
            s.find("img/search_bar");
            s.find("img/browse_tabs");

        } catch (FindFailed findFailed) {
            Assert.fail("Cound not find image");
        }
        general.search(s, "Chronixx");
        try {
            s.find("img/search_chronixx");

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
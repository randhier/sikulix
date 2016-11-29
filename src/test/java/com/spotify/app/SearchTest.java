package com.spotify.app;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.*;

public class SearchTest {

    private Screen s;
    private BasePage BasePage;

    @Test
    public void searchTest(){
        BasePage.login(System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        try {
            s.find("img/search_bar");
            s.find("img/browse_tabs");

        } catch (FindFailed findFailed) {
            Assert.fail("Cound not find image");
        }
        BasePage.search("Chronixx");
        try {
            s.find("img/search_chronixx");

        } catch (FindFailed findFailed) {
            Assert.fail("Cound not find image");
        }
    }

    @BeforeMethod
    public void setUp() {
        s = new Screen();
        BasePage = new BasePage(s);
    }

    @AfterMethod
    public void tearDown() {
        BasePage.logout();
        BasePage.closeApp();
    }
}
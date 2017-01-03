package com.spotify.app;

import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.*;
import com.spotify.app.pageObject.*;

public class PlayTest {

    private Screen s;
    private BasePage BasePage;
    private LoginPage LoginPage;

    @Test
    public void searchTest(){
        LoginPage.login(System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        Assert.assertTrue(BasePage.find_login_images());
        Assert.assertTrue(BasePage.find_play_image());
        BasePage.click_play();
        BasePage.click_search_bar();
        Assert.assertTrue(BasePage.verify_play());
        BasePage.click_pause();
        BasePage.click_search_bar();
        Assert.assertTrue(BasePage.find_play_image());
    }

    @BeforeMethod
    public void setUp() {
        s = new Screen();
        BasePage = new BasePage(s);
        LoginPage = new LoginPage(s);
    }

    @AfterMethod
    public void tearDown() {
        BasePage.logout();
        BasePage.closeApp();
    }
}
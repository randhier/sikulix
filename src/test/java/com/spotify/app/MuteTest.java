package com.spotify.app;

import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.*;
import com.spotify.app.pageObject.*;

public class MuteTest {

    private Screen s;
    private BasePage BasePage;
    private LoginPage LoginPage;

    @Test
    public void muteTest(){
        LoginPage.login(System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        Assert.assertTrue(BasePage.find_login_images());
        Assert.assertTrue(BasePage.find_play_image());
        BasePage.click_play();
        BasePage.click_search_bar();
        Assert.assertTrue(BasePage.verify_play());
        BasePage.click_mute();
        BasePage.click_search_bar();
        Assert.assertTrue(BasePage.verify_muted());
        BasePage.click_search_bar();
        BasePage.click_unmute();
        BasePage.click_search_bar();
        Assert.assertTrue(BasePage.verify_unmuted());
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
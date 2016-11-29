package com.spotify.app;

import org.sikuli.script.Screen;
import org.testng.annotations.*;
import pageObject.*;

public class MuteTest {

    private Screen s;
    private BasePage BasePage;
    private LoginPage LoginPage;

    @Test
    public void muteTest(){
        LoginPage.login(System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        BasePage.find_login_images();
        BasePage.find_play_image();
        BasePage.click_play();
        BasePage.click_search_bar();
        BasePage.verify_play();
        BasePage.click_mute();
        BasePage.click_search_bar();
        BasePage.verify_muted();
        BasePage.click_search_bar();
        BasePage.click_unmute();
        BasePage.click_search_bar();
        BasePage.verify_unmuted();
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
package com.spotify.app;

import org.sikuli.script.Screen;
import org.testng.annotations.*;
import pageObject.*;

public class PlayTest {

    private Screen s;
    private BasePage BasePage;
    private LoginPage LoginPage;

    @Test
    public void searchTest(){
        LoginPage.login(System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        BasePage.find_login_images();
        BasePage.find_play_image();
        BasePage.click_play();
        BasePage.click_search_bar();
        BasePage.verify_play();
        BasePage.click_pause();
        BasePage.click_search_bar();
        BasePage.find_play_image();
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
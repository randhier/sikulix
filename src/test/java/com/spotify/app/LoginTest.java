package com.spotify.app;

import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.*;

public class LoginTest {

    private Screen s;
    private BasePage BasePage;

    @Test
    public void invalidLoginTest() {
        BasePage.login(System.getenv("SPOTIFY_USER"), " ");
        BasePage.find_login_error();
    }

    @Test
    public void validLoginTest(){
        BasePage.login(System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        BasePage.find_login_images();
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
package com.spotify.app;

import junit.framework.Assert;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import com.spotify.app.pageObject.*;

public class LoginTest {

    private BasePage BasePage;
    private LoginPage LoginPage;

    @Test
    public void invalidLoginTest() {
        LoginPage.login(System.getenv("SPOTIFY_USER"), " ");
        Assert.assertTrue(LoginPage.find_login_error());
    }

    @Test
    public void validLoginTest(){
        LoginPage.login(System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        Assert.assertTrue(BasePage.find_login_images());
    }

    @BeforeMethod
    public void setUp() {
        Screen s = new Screen();
        BasePage = new BasePage(s);
        LoginPage = new LoginPage(s);
    }

    @AfterMethod
    public void tearDown() {
        BasePage.logout();
        BasePage.closeApp();
    }
}
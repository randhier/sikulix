package com.spotify.app;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.*;
import com.spotify.app.pageObject.*;

public class SearchTest {

    private Screen s;
    private BasePage BasePage;
    private LoginPage LoginPage;

    @Test
    public void searchTest(){
        LoginPage.login(System.getenv("SPOTIFY_USER"), System.getenv("SPOTIFY_PASSWORD"));
        BasePage.find_login_images();
        BasePage.search("Chronixx");
        Assert.assertTrue(BasePage.find_search_image());
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
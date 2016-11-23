package com.spotify.app;

import org.testng.Assert;
import org.testng.annotations.*;
import org.sikuli.script.App;
import org.sikuli.basics.Settings;
import helpers.*;

public class SpotifyTest {

    App spotify;

    @Test
    public void main() {
        System.out.println("Test");
    }

    @BeforeClass
    public void setUp() {
        System.out.println("Setup");
        spotify = App.open(general.appLocation());
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Teardown");
        spotify.close();
    }
}
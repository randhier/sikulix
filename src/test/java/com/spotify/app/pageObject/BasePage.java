package com.spotify.app.pageObject;

import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.testng.Assert;


public class BasePage {

    Screen screen;
    private App spotify;
    public int selectKey;
    private static String searchBar = "img/search_bar";
    private static String browseTabs = "img/browse_tabs";
    private static String searchResult = "img/search_chronixx";
    private static String loginLogo = "img/logo";
    private static String playButton = "img/play_button";
    private static String pauseButton = "img/pause_button";
    private static String muted = "img/muted";
    private static String unmuted = "img/unmuted";

    public BasePage(Screen s) {
        String app_location;
        if (Settings.isMac()) {
            this.selectKey = KeyModifier.CMD;
            app_location = "/Applications/Spotify.app/Contents/MacOS/Spotify";
        } else {
            this.selectKey = KeyModifier.CTRL;
            // Enter win launcher location here
            app_location = "spotify.exe";
        }
        this.screen = s;
        this.spotify = App.open(app_location);
        this.spotify.focus();
    }

    public void logout(){
        // Not sure what the Windows command is but I think this is correct
        this.screen.type("w",  this.selectKey | KeyModifier.SHIFT);
        try {
            this.screen.find(loginLogo);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public void closeApp(){
        this.spotify.close();
        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void search(String search) {
        click_search_bar();
        this.screen.type(search);
        this.screen.type(Key.ENTER);
    }

    public void click_search_bar() {
        try {
            this.screen.click(searchBar);
        } catch (FindFailed findFailed){
            findFailed.printStackTrace();
        }
    }

    public void find_image(String... images) {
        for (String i : images) {
            try {
                this.screen.find(i);
            } catch (FindFailed findFailed) {
                Assert.fail("Could not find image");
            }
        }
    }

    public void find_login_images(){
        find_image(searchBar, browseTabs);
    }

    public void find_search_image() {
        find_image(searchResult);
    }

    public void find_play_image() {
        find_image(playButton);
    }

    public void verify_play() {
        find_image(playButton);
    }

    public void verify_muted() {
        find_image(muted);
    }

    public void verify_unmuted() {
        find_image(unmuted);
    }

    private void click_image(String image){
        try {
            this.screen.click(image);
        } catch (FindFailed findFailed){
            findFailed.printStackTrace();
        }
    }

    public void click_play() {
            click_image(playButton);
    }

    public void click_pause() {
        click_image(pauseButton);
    }

    public void click_mute() {
        click_image(unmuted);
    }

    public void click_unmute() {
        click_image(muted);
    }
}

package pageObject;

import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.testng.Assert;


public class BasePage {

    App spotify;
    Screen screen;

    public BasePage(Screen s) {
        this.screen = s;
        this.spotify = App.open(appLocation());
        this.spotify.focus();
    }

    public String appLocation() {
        String OS;
        if (Settings.isMac()) {
            OS = "/Applications/Spotify.app/Contents/MacOS/Spotify";
        } else {
            // assuming if not MAC then Win. Enter win launcher location here
            OS = "spotify.exe";
        }
        return OS;
    }

    public void login(String user, String password){
        try {
            this.screen.click("img/logo");
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
        this.screen.type(Key.TAB + Key.TAB);
        this.screen.type("a", KeyModifier.CMD);
        this.screen.type(Key.BACKSPACE + user);
        this.screen.type(Key.TAB + password);
        try {
            this.screen.click("img/login");
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public void logout(){
        this.screen.type("w",  KeyModifier.CMD | KeyModifier.SHIFT);
        try {
            this.screen.find("img/logo");
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
        try {
            this.screen.click("img/search_bar");
        } catch (FindFailed findFailed){
            findFailed.printStackTrace();
        }
        this.screen.type("Chronixx");
        this.screen.type(Key.ENTER);
    }

    public void find_login_error(){
        try {
            this.screen.find("img/login_error");

        } catch (FindFailed findFailed) {
            Assert.fail("Cound not find image");
        }
    }

    public void find_login_images(){
        try {
            this.screen.find("img/search_bar");
            this.screen.find("img/browse_tabs");

        } catch (FindFailed findFailed) {
            Assert.fail("Cound not find image");
        }
    }
}

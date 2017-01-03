package com.spotify.app.pageObject;

import org.sikuli.script.*;

public class LoginPage extends BasePage{

    private static String loginLogo = "img/logo";
    private static String loginButton = "img/login";
    private static String loginError = "img/login_error";

    public LoginPage(Screen s){
        super(s);
    }

    public void login(String user, String password){
        try {
            this.screen.click(loginLogo);
        } catch (FindFailed findFailed) {
            throw new Error(findFailed);
        }
        this.screen.type(Key.TAB + Key.TAB);
        this.screen.type("a", this.selectKey);
        this.screen.type(Key.BACKSPACE + user);
        this.screen.type(Key.TAB + password);
        try {
            this.screen.click(loginButton);
        } catch (FindFailed findFailed) {
            throw new Error(findFailed);
        }
    }

    public boolean find_login_error(){
        return find_image(loginError);
    }
}

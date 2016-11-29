package pageObject;

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
            findFailed.printStackTrace();
        }
        this.screen.type(Key.TAB + Key.TAB);
        this.screen.type("a", this.selectKey);
        this.screen.type(Key.BACKSPACE + user);
        this.screen.type(Key.TAB + password);
        try {
            this.screen.click(loginButton);
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }

    public void find_login_error(){
        find_image(loginError);
    }
}
